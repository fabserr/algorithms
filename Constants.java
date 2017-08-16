package dancinglinks;

public final class Constants {
	public static final int n = 3;
	public static final int n_2 = n * n;
	public static final int n_4 = n_2 * n_2;

	public static final int N = n_4 * n_2;

	public static final int R_INDEX = n_4;
	public static final int C_INDEX = 2 * n_4;
	public static final int B_INDEX = 3 * n_4;
	public static final int M = 4 * n_4;
	// designed for n=3
	public static final int[][] blocKeys = { { 0, 1, 2 }, { 3, 4, 5 },{ 6, 7, 8 } };

}