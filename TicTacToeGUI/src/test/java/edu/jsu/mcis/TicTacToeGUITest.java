package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeGUITest {
	
	@Test
	public void testInititialBoardIsUnmarked() {
		TicTacToeGUI t = new TicTacToeGUI();
		t.startGame();
		for(int i=0; i<9; i++) {
			char ch = (char)('0'+i+1);
			assertEquals(""+ch, t.cells[i].getText());
		}
	}
	
	@Test
	public void XWinsDiagonally() {
		TicTacToeGUI t = new TicTacToeGUI();
		String expected = "X";
		t.startGame();
		t.cells[0].setText(expected);
		t.cells[4].setText(expected);
		t.cells[8].setText(expected);
		assertEquals(expected, t.cells[0].getText());
		assertEquals(expected, t.cells[4].getText());
		assertEquals(expected, t.cells[8].getText());
	}
	
	@Test
	public void XWinsHorizontally() {
		TicTacToeGUI t = new TicTacToeGUI();
		String expected = "X";
		t.startGame();
		t.cells[0].setText(expected);
		t.cells[1].setText(expected);
		t.cells[2].setText(expected);
		assertEquals(expected, t.cells[0].getText());
		assertEquals(expected, t.cells[1].getText());
		assertEquals(expected, t.cells[2].getText());
	}
	
	@Test
	public void XWinsVertically() {
		TicTacToeGUI t = new TicTacToeGUI();
		String expected = "O";
		t.startGame();
		t.cells[0].setText(expected);
		t.cells[3].setText(expected);
		t.cells[6].setText(expected);
		assertEquals(expected, t.cells[0].getText());
		assertEquals(expected, t.cells[3].getText());
		assertEquals(expected, t.cells[6].getText());
	}
		@Test
	public void OWinsDiagonally() {
		TicTacToeGUI t = new TicTacToeGUI();
		String expected = "O";
		t.startGame();
		t.cells[0].setText(expected);
		t.cells[4].setText(expected);
		t.cells[8].setText(expected);
		assertEquals(expected, t.cells[0].getText());
		assertEquals(expected, t.cells[4].getText());
		assertEquals(expected, t.cells[8].getText());
	}
	
	@Test
	public void OWinsHorizontally() {
		TicTacToeGUI t = new TicTacToeGUI();
		String expected = "O";
		t.startGame();
		t.cells[0].setText(expected);
		t.cells[1].setText(expected);
		t.cells[2].setText(expected);
		assertEquals(expected, t.cells[0].getText());
		assertEquals(expected, t.cells[1].getText());
		assertEquals(expected, t.cells[2].getText());
	}
	
	@Test
	public void OWinsVertically() {
		TicTacToeGUI t = new TicTacToeGUI();
		String expected = "O";
		t.startGame();
		t.cells[0].setText(expected);
		t.cells[3].setText(expected);
		t.cells[6].setText(expected);
		assertEquals(expected, t.cells[0].getText());
		assertEquals(expected, t.cells[3].getText());
		assertEquals(expected, t.cells[6].getText());
	}
}
