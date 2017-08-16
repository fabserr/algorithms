package dancinglinks;


public class ColumnNode extends Node {
	ColumnNode left;
	ColumnNode right;
	public int j;
	String name;
	int size;

	ColumnNode() {
		this.left = this;
		this.right = this;
		this.size = 0;
		this.j = -1;
	}

	ColumnNode(int j, ColumnNode left, ColumnNode right) {
		this.left = left;
		left.right = this;
		this.right = right;
		right.left = this;
		this.up = this;
		this.down = this;
		this.size = 0;
		this.j = j;
		this.name = asName(j);
	}

	private String asName(int col) {
		if (col == -1) {
			return "h";
		}
		if (col < Constants.R_INDEX) {
			int i = col / Constants.n_2 + 1;
			int j = col % Constants.n_2 + 1;
			return "R" + i + "C" + j;
		} else if (col < Constants.C_INDEX) {
			col -= Constants.R_INDEX;
			int i = col / Constants.n_2 + 1;
			int n = col % Constants.n_2 + 1;
			return "R" + i + "#" + n;
		} else if (col < Constants.B_INDEX) {
			col -= Constants.C_INDEX;
			int j = col / Constants.n_2 + 1;
			int n = col % Constants.n_2 + 1;
			return "C" + j + "#" + n;
		} else {
			col -= Constants.B_INDEX;
			int b = col / Constants.n_2 + 1;
			int n = col % Constants.n_2 + 1;
			return "B" + b + "#" + n;
		}
	}

	public String getName() {
		return name;
	}

}
