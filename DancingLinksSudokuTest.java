package dancinglinks;
import static org.junit.Assert.*;

import org.junit.Test;

public class DancingLinksSudokuTest {

	char[][] s1 = { { '.', '.', '.', '1', '4', '.', '.', '2', '.' },
			{ '.', '.', '6', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '1', '.', '.', '.', '.', '.', '.' },
			{ '.', '6', '7', '.', '.', '.', '.', '.', '9' },
			{ '.', '.', '.', '.', '.', '.', '8', '1', '.' },
			{ '.', '3', '.', '.', '.', '.', '.', '.', '6' },
			{ '.', '.', '.', '.', '.', '7', '.', '.', '.' },
			{ '.', '.', '.', '5', '.', '.', '.', '7', '.' } };

	char[][] s2 = { { '.', '.', '.', '.', '2', '.', '.', '9', '.' },
			{ '.', '.', '.', '.', '6', '.', '.', '.', '.' },
			{ '7', '1', '.', '.', '7', '5', '.', '.', '.' },
			{ '.', '7', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '8', '3', '.', '.', '.' },
			{ '.', '.', '8', '.', '.', '7', '.', '6', '.' },
			{ '.', '.', '.', '.', '.', '2', '.', '.', '.' },
			{ '.', '1', '.', '2', '.', '.', '.', '.', '.' },
			{ '.', '2', '.', '.', '3', '.', '.', '.', '.' } };

	// grille invalide column
	char[][] s3 = { { '.', '.', '4', '.', '.', '.', '6', '3', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '5', '.', '.', '.', '.', '.', '.', '9', '.' },
			{ '.', '.', '.', '5', '6', '.', '.', '.', '.' },
			{ '4', '.', '3', '.', '.', '.', '.', '.', '1' },
			{ '.', '.', '.', '7', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '5', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.' } };

	char[][] s4 = { { '.', '.', '.', '.', '.', '.', '.', '.', '2' },
			{ '.', '.', '.', '.', '.', '.', '6', '.', '.' },
			{ '.', '.', '1', '4', '.', '.', '8', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '3', '.', '.', '.', '.' },
			{ '5', '.', '8', '6', '.', '.', '.', '.', '.' },
			{ '.', '9', '.', '.', '.', '.', '4', '.', '.' },
			{ '.', '.', '.', '.', '5', '.', '.', '.', '.' } };

	char[][] s5 = { { '.', '9', '.', '.', '4', '.', '.', '.', '.' },
			{ '1', '.', '.', '.', '.', '.', '6', '.', '.' },
			{ '.', '.', '3', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '7', '.', '.', '.', '.', '.' },
			{ '3', '.', '.', '.', '5', '.', '.', '.', '.' },
			{ '.', '.', '7', '.', '.', '4', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '7', '.', '.', '.', '.' } };

	// validate row
	char[][] s6 = { { '7', '.', '.', '.', '4', '.', '.', '.', '.' },
			{ '.', '.', '.', '8', '6', '5', '.', '.', '.' },
			{ '.', '1', '.', '2', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '9', '.', '.', '.' },
			{ '.', '.', '.', '.', '5', '.', '5', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '2', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.' } };

	// validate bloc
	char[][] s7 = { { '.', '4', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '4', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '1', '.', '.', '7', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '3', '.', '.', '.', '6', '.' },
			{ '.', '.', '.', '.', '.', '6', '.', '9', '.' },
			{ '.', '.', '.', '.', '1', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '2', '.', '.' },
			{ '.', '.', '.', '8', '.', '.', '.', '.', '.' } };

	// validate bloc
	char[][] s8 = { { '.', '.', '5', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '8', '.', '.', '.', '3', '.' },
			{ '.', '5', '.', '.', '2', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '9' },
			{ '.', '.', '.', '.', '.', '.', '4', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '7' },
			{ '.', '1', '.', '.', '.', '.', '.', '.', '.' },
			{ '2', '4', '.', '.', '.', '.', '9', '.', '.' } };

	// validate row
	char[][] s9 = { { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '9', '.', '.', '.', '.', '.', '.', '1' },
			{ '8', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '9', '9', '3', '5', '7', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '4', '.' },
			{ '.', '.', '.', '8', '.', '.', '.', '.', '.' },
			{ '.', '1', '.', '.', '.', '.', '4', '.', '9' },
			{ '.', '.', '.', '5', '.', '4', '.', '.', '.' } };

	char[][] s10 = { { '.', '.', '.', '2', '.', '.', '6', '.', '.' },
			{ '.', '.', '.', '1', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '5', '.', '1', '.', '.', '8' },
			{ '.', '3', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '9', '.', '.', '.', '.', '3' },
			{ '4', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '3', '8', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '4' } };

	char[][] s11 = { { '.', '.', '.', '.', '8', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '5', '.', '.' },
			{ '.', '.', '.', '.', '4', '.', '.', '2', '.' },
			{ '.', '.', '.', '3', '.', '9', '.', '.', '.' },
			{ '.', '.', '1', '8', '.', '.', '9', '.', '.' },
			{ '.', '.', '.', '.', '.', '5', '1', '.', '.' },
			{ '.', '.', '3', '.', '.', '8', '.', '.', '.' },
			{ '.', '1', '2', '.', '3', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '7', '.', '.', '1' } };

	// validate bloc
	char[][] s12 = { { '.', '.', '.', '.', '.', '.', '5', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '9', '3', '.', '.', '2', '.', '4', '.', '.' },
			{ '.', '.', '7', '.', '.', '.', '3', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '3', '4', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '3', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '5', '2', '.', '.' } };

	char[][] s13 = { { '.', '.', '.', '.', '4', '.', '9', '.', '.' },
			{ '.', '.', '2', '1', '.', '.', '3', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '3' },
			{ '.', '.', '.', '2', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '7', '.', '.', '.' },
			{ '.', '.', '.', '6', '1', '.', '.', '.', '.' },
			{ '.', '.', '9', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '9', '.' } };

	char[][] s14 = { { '.', '8', '7', '6', '5', '4', '3', '2', '1' },
			{ '2', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '3', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '4', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '5', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '6', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '7', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '8', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '9', '.', '.', '.', '.', '.', '.', '.', '.' } };

	char[][] s15 = { { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '4', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '6', '.', '.' },
			{ '.', '.', '.', '3', '8', '.', '.', '.', '.' },
			{ '.', '5', '.', '.', '.', '6', '.', '.', '1' },
			{ '8', '.', '.', '.', '.', '.', '.', '6', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '7', '.', '9', '.', '.', '.', '.' },
			{ '.', '.', '.', '6', '.', '.', '.', '.', '.' } };

	// invalidate line/bloc
	char[][] s16 = { { '.', '.', '.', '.', '.', '.', '.', '.', '1' },
			{ '.', '.', '.', '.', '.', '6', '.', '.', '.' },
			{ '4', '.', '.', '.', '.', '.', '3', '8', '.' },
			{ '7', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '5', '3', '.', '.', '.' },
			{ '.', '.', '.', '.', '6', '8', '.', '.', '.' },
			{ '3', '.', '.', '9', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '2', '1', '1', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.' } };
	

	char[][] s18={{'.','.','.','.','.','.','.','.','.'}, 
		 {'.','.','2','.','.','.','.','.','.'}, 
		 {'.','.','.','.','.','2','7','1','.'}, 
		 {'.','.','.','.','.','.','.','.','.'}, 
		 {'.','2','.','.','.','.','.','.','.'}, 
		 {'.','5','.','.','.','.','.','.','.'}, 
		 {'.','.','.','.','9','.','.','.','8'}, 
		 {'.','.','.','.','.','1','6','.','.'}, 
		 {'.','.','.','.','6','.','.','.','.'}};



	@Test
	public void testInitColumn() {
		DancingLinksSudoku dancingLinks = DancingLinksSudoku.getInstance();
		assertNotNull(dancingLinks.getColumns());

		dancingLinks.initColumns();
		assertEquals(325, dancingLinks.getColumns().size());
		assertEquals(-1, dancingLinks.getColumns().get(-1).j);
		assertEquals(-1, dancingLinks.getColumns().get(0).left.j);
		assertEquals(-1, dancingLinks.getColumns().get(323).right.j);
		assertEquals(0, dancingLinks.getColumns().get(1).left.j);
		assertEquals(2, dancingLinks.getColumns().get(1).right.j);
	}

	@Test
	public void testInsertOneNode() {
		DancingLinksSudoku dancingLinks = DancingLinksSudoku.getInstance();

		dancingLinks.initColumns();

		XNode inserted = dancingLinks.insertNode(0, 0);
		ColumnNode header = dancingLinks.getColumns().get(0);

		assertEquals(inserted, (header.down));
		assertEquals(inserted, (header.up));
		assertEquals(0, inserted.i);
		assertEquals(inserted, inserted.left);
		assertEquals(inserted, inserted.right);

		assertEquals(header, inserted.columnNode);
		assertEquals(header.j, inserted.j);
		assertEquals(header, inserted.up);
		assertEquals(header, inserted.down);
		assertEquals(1, header.size);
	}

	@Test
	public void testInsertTwoNodesSameSet() {
		DancingLinksSudoku dancingLinks = DancingLinksSudoku.getInstance();

		dancingLinks.initColumns();
		XNode left = dancingLinks.insertNode(0, 0);
		ColumnNode header_0 = dancingLinks.getColumns().get(
				0);

		XNode inserted = dancingLinks.insertNode(0, 1, left);
		ColumnNode header_1 = dancingLinks.getColumns().get(
				1);

		assertEquals(left, inserted.left);
		assertEquals(left.right, inserted);
		assertEquals(left, inserted.right);
		assertEquals(left.left, inserted);

		assertEquals(header_0, left.columnNode);
		assertEquals(header_1, inserted.columnNode);

		assertEquals(1, header_1.size);
	}

	@Test
	public void testInsertTwoNodesSameColumn() {
		DancingLinksSudoku dancingLinks = DancingLinksSudoku.getInstance();

		dancingLinks.initColumns();
		XNode first = dancingLinks.insertNode(0, 0);
		XNode inserted = dancingLinks.insertNode(1, 0);
		ColumnNode header = dancingLinks.getColumns().get(0);

		assertEquals(header.size, 2);
		assertEquals(inserted, first.down);
		assertEquals(inserted, header.up);
		assertEquals(header, (first.up));
		assertEquals(1, inserted.i);
		assertEquals(inserted, inserted.left);
		assertEquals(inserted, inserted.right);

		assertEquals(header, inserted.columnNode);
		assertEquals(header.j, inserted.j);
		assertEquals(header, first.up);
		assertEquals(header, inserted.down);

	}

	@Test
	public void testInit() {
		DancingLinksSudoku dancingLinks = DancingLinksSudoku.getInstance();

		dancingLinks.init();

		for (int j = 0; j < Constants.M; j++) {
			ColumnNode header = dancingLinks.getColumns()
					.get(j);

			assertEquals(header.size, 9);
		}

	}

	@Test
	public void testRemoveR1C1n1() {
		DancingLinksSudoku dancingLinks = DancingLinksSudoku.getInstance();

		dancingLinks.init();

		dancingLinks.removeKnownSquare(0, 0, '1');

		ColumnNode h = dancingLinks.getColumns().get(-1);
		ColumnNode R1C2 = dancingLinks.getColumns().get(1);
		ColumnNode R9C9 = dancingLinks.getColumns().get(80);
		ColumnNode R1n2 = dancingLinks.getColumns().get(82);
		ColumnNode R9n9 = dancingLinks.getColumns().get(161);
		ColumnNode C1n2 = dancingLinks.getColumns().get(163);
		ColumnNode C9n9 = dancingLinks.getColumns().get(242);
		ColumnNode B1n2 = dancingLinks.getColumns().get(244);

		ColumnNode R1C1 = dancingLinks.getColumns().get(0);
		ColumnNode R1n1 = dancingLinks.getColumns().get(81);
		ColumnNode C1n1 = dancingLinks.getColumns().get(162);
		ColumnNode B1n1 = dancingLinks.getColumns().get(243);

		assertEquals(h.right, R1C2);
		assertEquals(R9C9.right, R1n2);
		assertEquals(R9n9.right, C1n2);
		assertEquals(C9n9.right, B1n2);

		assertEquals(0, R1C1.size);
		assertEquals(0, R1n1.size);
		assertEquals(0, C1n1.size);
		assertEquals(0, B1n1.size);
	}

	@Test
	public void testRemoveR1C1n2() {
		DancingLinksSudoku dancingLinks = DancingLinksSudoku.getInstance();

		dancingLinks.init();

		dancingLinks.removeKnownSquare(0, 0, '2');

		ColumnNode h = dancingLinks.getColumns().get(-1);
		ColumnNode R1C2 = dancingLinks.getColumns().get(1);
		ColumnNode R1n1 = dancingLinks.getColumns().get(81);
		ColumnNode R1n3 = dancingLinks.getColumns().get(83);
		ColumnNode C1n1 = dancingLinks.getColumns().get(162);
		ColumnNode C1n3 = dancingLinks.getColumns().get(164);
		ColumnNode B1n1 = dancingLinks.getColumns().get(243);
		ColumnNode B1n3 = dancingLinks.getColumns().get(245);

		ColumnNode R1C1 = dancingLinks.getColumns().get(0);
		ColumnNode R1n2 = dancingLinks.getColumns().get(82);
		ColumnNode C1n2 = dancingLinks.getColumns().get(163);
		ColumnNode B1n2 = dancingLinks.getColumns().get(244);

		assertEquals(h.right, R1C2);
		assertEquals(R1n1.right, R1n3);
		assertEquals(C1n1.right, C1n3);
		assertEquals(B1n1.right, B1n3);

		assertEquals(0, R1C1.size);
		assertEquals(0, R1n2.size);
		assertEquals(0, C1n2.size);
		assertEquals(0, B1n2.size);
	}

	@Test
	public void testRemoveR9C9n9() {
		DancingLinksSudoku dancingLinks = DancingLinksSudoku.getInstance();

		dancingLinks.init();

		dancingLinks.removeKnownSquare(8, 8, '9');

		ColumnNode R9C8 = dancingLinks.getColumns().get(79);
		ColumnNode R1n1 = dancingLinks.getColumns().get(81);
		ColumnNode R9n8 = dancingLinks.getColumns().get(160);
		ColumnNode C1n1 = dancingLinks.getColumns().get(162);
		ColumnNode C9n8 = dancingLinks.getColumns().get(241);
		ColumnNode B1n1 = dancingLinks.getColumns().get(243);
		ColumnNode B9n8 = dancingLinks.getColumns().get(322);
		ColumnNode h = dancingLinks.getColumns().get(-1);

		ColumnNode R9C9 = dancingLinks.getColumns().get(80);
		ColumnNode R9n9 = dancingLinks.getColumns().get(161);
		ColumnNode C9n9 = dancingLinks.getColumns().get(242);
		ColumnNode B9n9 = dancingLinks.getColumns().get(323);

		assertEquals(h.left, B9n8);
		assertEquals(B1n1.left, C9n8);
		assertEquals(C1n1.left, R9n8);
		assertEquals(R1n1.left, R9C8);

		assertEquals(0, R9C9.size);
		assertEquals(0, R9n9.size);
		assertEquals(0, C9n9.size);
		assertEquals(0, B9n9.size);
	}

	@Test
	public void testRun1() {
		DancingLinksSudoku sudoku = DancingLinksSudoku.getInstance();
		sudoku.init(s1);
		assertTrue(sudoku.run(null));
	}

	@Test
	public void testRun2() {
		DancingLinksSudoku sudoku = DancingLinksSudoku.getInstance();
		sudoku.init(s2);
		assertFalse(sudoku.run(null));
	}

	// grille invalide : TODO
	// @Test
	// public void testRun3() {
	// DancingLinksSudoku sudoku = DancingLinksSudoku.getInstance();
	// sudoku.init(s3);
	// assertFalse(sudoku.run());
	// }

	@Test
	public void testRun4() {
		DancingLinksSudoku sudoku = DancingLinksSudoku.getInstance();
		sudoku.init(s4);
		assertTrue(sudoku.run(null));
	}

	@Test
	public void testRun5() {
		DancingLinksSudoku sudoku = DancingLinksSudoku.getInstance();
		sudoku.init(s5);
		assertTrue(sudoku.run(null));
	}

	@Test
	public void testRun10() {
		DancingLinksSudoku sudoku = DancingLinksSudoku.getInstance();
		sudoku.init(s10);
		assertTrue(sudoku.run(null));
	}

	@Test
	public void testRun11() {
		DancingLinksSudoku sudoku = DancingLinksSudoku.getInstance();
		sudoku.init(s11);
		assertTrue(sudoku.run(null));
	}

	@Test
	public void testRun13() {
		DancingLinksSudoku sudoku = DancingLinksSudoku.getInstance();
		sudoku.init(s13);
		assertTrue(sudoku.run(null));
	}

	@Test
	public void testRun14() {
		DancingLinksSudoku sudoku = DancingLinksSudoku.getInstance();
		sudoku.init(s14);
		assertFalse(sudoku.run(null));
	}

	@Test
	public void testRun15() {
		DancingLinksSudoku sudoku = DancingLinksSudoku.getInstance();
		sudoku.init(s15);
		assertTrue(sudoku.run(null));
	}

	@Test
	public void testRun18() {
		DancingLinksSudoku sudoku = DancingLinksSudoku.getInstance();
		sudoku.init(s18);
		assertTrue(sudoku.run(null));
	}
	
	

}
