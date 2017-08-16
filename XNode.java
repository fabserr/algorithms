package dancinglinks;

public class XNode extends Node {
	int i;
	int j;
	boolean covered;
	ColumnNode columnNode;

	XNode(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public boolean isCovered() {
		return covered;
	}

	public void setCovered(boolean b) {
		covered = b;
	}
}
