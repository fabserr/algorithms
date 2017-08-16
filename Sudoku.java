package dancinglinks;

/**
 * 
 * @author fabriceserriere
 *
 * To represent a sudoku, we use the RiCj#k representation
 * 
 * if (sudoku[p]) then RiCj = k where
 * 		i = p / Constants.n_4
 * 		j = (p - i * Constants.n_4) / Constants.n_2
 * 		k = p - i * Constants.n_4 - j * Constants.n_2
 * 
 * NB: RiCj#k are the sets of the exact cover
 * 
 */

public class Sudoku {
	private boolean[] sudoku ;

	public Sudoku() {
		sudoku = new boolean[Constants.N];
	}
	
	public boolean[] getSudoku() {
		return sudoku;
	}

	public void set(XNode set) {
		sudoku[set.i] = true;
	}
	
	public void reset(XNode set) {
		sudoku[set.i] = false;
	}

	public void setSquare(int i, int j, char c) {
		int position = (c - '1') + j * Constants.n_2 + i * Constants.n_4;
		sudoku[position]=true;		
	}

	public int[][] toChars(){
		int[][] ret = new int[Constants.n_2][Constants.n_2];
		for (int i=0;i<Constants.N;i++) {
			if (sudoku[i]) toChar(i,ret);
		}
		return ret;
	}

	private void toChar(int p, int[][] ret) {
		int i = p / Constants.n_4;
		int j = (p - i * Constants.n_4) / Constants.n_2;
		int k = p - i * Constants.n_4 - j * Constants.n_2;
		ret[i][j]= (k+1);
	}

	public void display() {
		int[][] toDisplay = toChars();
		for (int i=0;i<Constants.n_2;i++) {
			for (int j=0;j<Constants.n_2;j++) {
				System.out.print(" "+toDisplay[i][j]+" ");
				if (j<Constants.n_2-1) {
					System.out.print('|');
					if (j%Constants.n==Constants.n-1) System.out.print("|");
				}
			}
			System.out.println();
			if (i<Constants.n_2-1) {
				System.out.println("-----------||-----------||----------");
				if (i%Constants.n==Constants.n-1) System.out.println("-----------||-----------||----------");
			}
		}
	}
}
