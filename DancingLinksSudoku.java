package dancinglinks;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author fabriceserriere
 *
 * I happened to solve the dancing links for getting whether or not a given sudoku is feasible while I was solving a simple
 * problem on CodeFight. The problem was just to say whether or not the constraints of a Sudoku are met on a given board.
 * After getting it solved, I started to implement a brutforce backtrack to give the feasibility of the case that were profided
 * by Codefight. I rapidly discovered that running it could take forever. That's how I discovered the link between Sudoku 
 * and exact cover, X-Algorithm and all the papers due to Donald Knuth (must be readen in order to understand the way this 
 * code works)
 * 
 * Several improvement could be brought on this code:
 * - putting in a cash the solution found
 * - refactor
 * - decoupling exact cover solving and sudoku
 * - transform the size of the sudoky as a parameter (here, n=3).
 * 
 */

public class DancingLinksSudoku {


	/** Instance unique pré-initialisée */
	private static DancingLinksSudoku INSTANCE = new DancingLinksSudoku();

	Map<Integer, Map<ColumnNode, Boolean>> nextColumns = new HashMap<Integer, Map<ColumnNode, Boolean>>();

	/** Point d'accès pour l'instance unique du singleton */
	public static DancingLinksSudoku getInstance() {
		return INSTANCE;
	}

	private Map<Integer, ColumnNode> columns = new HashMap<Integer, ColumnNode>();
	public ColumnNode h;

	public Map<Integer, ColumnNode> getColumns() {
		return columns;
	}


	public void init(char[][] c) {
		init();
		remove(c);
	}

	public void init() {
		initColumns();
		initNodes();
	}

	public void initColumns() {
		h = new ColumnNode();
		columns.put(-1, h);
		ColumnNode zero = new ColumnNode(0, h, h);
		columns.put(0, zero);

		for (int j = 1; j < Constants.M; j++) {
			ColumnNode current = new ColumnNode(j, columns.get(j - 1), h);
			columns.put(j, current);
		}
	}

	private void initNodes() {
		for (int i = 0; i < Constants.N; i++) {
			initConstraints(i);
		}
	}

	private void initConstraints(int i) {

		int line = i / Constants.n_4;
		int column = (i - line * Constants.n_4) / Constants.n_2;
		int number = i - Constants.n_4 * line - column * Constants.n_2;

		XNode node_RC = insertNode(i, getRCIndex(line, column));
		XNode node_R = insertNode(i, getRnIndex(line, number), node_RC);
		XNode node_C = insertNode(i, getCnIndex(column, number), node_R);
		insertNode(i, getBnIndex(line, column, number), node_C);

	}

	private int getBnIndex(int line, int column, int number) {
		return Constants.B_INDEX + Constants.n_2 * (Constants.blocKeys[line / Constants.n][column / Constants.n]) + number;
	}

	private int getCnIndex(int column, int number) {
		return Constants.C_INDEX + Constants.n_2 * column + number;
	}

	private int getRnIndex(int line, int number) {
		return Constants.R_INDEX + Constants.n_2 * line + number;
	}

	private int getRCIndex(int line, int column) {
		return Constants.n_2 * line + column;
	}

	public XNode insertNode(int i, int j) {
		XNode toInsert = new XNode(i, j);
		toInsert.left = toInsert;
		toInsert.right = toInsert;

		ColumnNode header = columns.get(j);
		toInsert.columnNode = header;
		header.size++;

		Node down = header.up;
		toInsert.up = down;
		toInsert.down = header;
		down.down = toInsert;
		header.up = toInsert;

		return toInsert;
	}

	public XNode insertNode(int i, int j, Node left) {
		XNode toInsert = new XNode(i, j);
		Node first = left.right;
		toInsert.right = first;
		toInsert.left = left;
		first.left = toInsert;
		left.right = toInsert;

		ColumnNode header = columns.get(j);
		toInsert.columnNode = header;
		header.size++;

		Node down = header.down;
		toInsert.up = header;
		toInsert.down = down;
		down.up = toInsert;
		header.down = toInsert;

		return toInsert;
	}

	private void remove(char[][] c) {
		for (int i = 0; i < Constants.n_2; i++)
			for (int j = 0; j < Constants.n_2; j++)
				if ('.' != c[i][j])
					removeKnownSquare(i, j, c[i][j]);
	}

	public void removeKnownSquare(int i, int j, char c) {
		int number = c - '1';
		int position = number + j * Constants.n_2 + i * Constants.n_4;
		int line = position / Constants.n_4;
		int column = (position - line * Constants.n_4) / Constants.n_2;
		cover(columns.get(getRCIndex(line, column)));
		cover(columns.get(getRnIndex(line, number)));
		cover(columns.get(getCnIndex(column, number)));
		cover(columns.get(getBnIndex(line, column, number)));
	}

	boolean run(char[][] c) {
		return run(0, nextColumn(0));
	}

	boolean run(int k, ColumnNode column) {
		if (h.right == h) {
			return true;
		}
		if (column == null)
			return false;
		List<Node> sets = cover(column);
		for (Node set : sets) {
			List<List<Node>> setOfSubsets = new LinkedList<List<Node>>();
			for (XNode right = (XNode) set.right; right != set; right = (XNode) right.right) {
				ColumnNode c_j = right.columnNode;
				setOfSubsets.add(cover(c_j));
			}

			if (run(k + 1, nextColumn(k + 1)))
				return true;

			for (int i = 0; i < setOfSubsets.size(); i++) {
				List<Node> subsets = setOfSubsets.get(i);
				for (int j = 0; j < subsets.size(); j++) {
					uncover(subsets.get(j));
				}
				if (!subsets.isEmpty()) {
					uncover(((XNode) subsets.get(0)).columnNode);
				}
			}
		}

		for (Node set : sets)
			uncover(set);
		uncover(column);
		return false;
	}

	private List<Node> cover(ColumnNode column) {
		column.left.right = column.right;
		column.right.left = column.left;
		List<Node> coveredSet = new LinkedList<Node>();

		for (Node set = column.down; set != column; set = set.down) {
			coverSet(set);
			coveredSet.add(set);
		}

		return coveredSet;
	}

	private void coverSet(Node set) {
		XNode first = (XNode) set;
		coverElement(first);
		XNode next = (XNode) set.right;
		while (next != set) {
			coverElement(next);
			next = (XNode) next.right;
		}
	}

	private void coverElement(XNode element) {
		if (!element.isCovered()) {
			element.up.down = element.down;
			element.down.up = element.up;
			element.columnNode.size--;
			element.setCovered(true);
		}
	}

	/**
	 * @param columnNode
	 *            : When covered, the column has no more pointers on her
	 *            elements, it's only able to insert itself in the header's list
	 */
	private void uncover(ColumnNode columnNode) {
		columnNode.right.left = columnNode;
		columnNode.left.right = columnNode;
	}

	private void uncover(Node set) {
		XNode first = (XNode) set;
		XNode next = (XNode) first.left;
		while (next != first) {
			uncoverElement(next);
			next = (XNode) next.left;
		}
		uncoverElement(first);
	}

	private void uncoverElement(XNode element) {
		if (element.isCovered()) {
			element.up.down = element;
			element.down.up = element;
			element.columnNode.size++;
			element.setCovered(false);
		}
	}

	private ColumnNode nextColumn(int k) {
		if (nextColumns.get(k) == null) {
			nextColumns.put(k, new HashMap<ColumnNode, Boolean>());
		}

		Map<ColumnNode, Boolean> selectedColumns = nextColumns.get(k);

		ColumnNode selected = getFirstCandidate(selectedColumns);

		if (selected == null)
			return null;

		int count = 0;
		for (ColumnNode current = h.right; current != h; current = current.right) {
			if (selected.size == 1 && selectedColumns.get(selected) == null) {
				selectedColumns.put(selected, true);
				System.out.println("k: " + k);
				System.out.println("total: " + count);
				System.out.println("selected: " + selected.getName()
						+ " size: " + selected.size);
				return selected;
			} else if (current.size > 0 && current.size < selected.size
					&& selectedColumns.get(current) == null) {
				selected = current;
			}
			count += current.size;
		}
		
		if (selected.size > 0) {
			System.out.println("k: " + k);
			System.out.println("total: " + count);
			System.out.println("selected: " + selected.getName() + " size: "
					+ selected.size);
			selectedColumns.put(selected, true);
			return selected;
		}

		return null;
	}

	private ColumnNode getFirstCandidate(
			Map<ColumnNode, Boolean> selectedColumns) {
		for (ColumnNode current = h.right; current != h; current = current.right) {
			if (selectedColumns.get(current) == null && current.size > 0) {
				return current;
			}
		}
		return null;
	}

}
