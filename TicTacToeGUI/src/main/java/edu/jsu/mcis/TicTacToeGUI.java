package edu.jsu.mcis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGUI extends JFrame {

	Container content;
	JLabel result;
	JButton[] cells;
	JButton exitButton;
	JButton initButton;
	cellButtonListener[] cellHandlers;
	ExitButtonHandler exitHandler;
	InitButtonHandler initHandler;
	
	boolean OTurn;
	boolean isGameOver;
	
	public TicTacToeGUI() {
		setTitle("TicTacToe");
		setSize(400,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		content = getContentPane();
		content.setBackground(Color.red.darker());
		content.setLayout(new GridLayout(4,3));
		cells = new JButton[9];
		cellHandlers = new cellButtonListener[9];
		
		for(int i=0; i<9; i++) {
			char ch = (char)('0'+i+1);
			cells[i]=new JButton(""+ch);
			cellHandlers[i] = new cellButtonListener();
			cells[i].addActionListener(cellHandlers[i]);
		}
		
		exitButton = new JButton("EXIT GAME");
		exitHandler = new ExitButtonHandler();
		exitButton.addActionListener(exitHandler);
		initButton = new JButton("CLEAR BOARD");
		initHandler = new InitButtonHandler();
		initButton.addActionListener(initHandler);
		
		result = new JLabel("OTurn", SwingConstants.CENTER);
		result.setForeground(Color.white);

		for(int i=0; i<9; i++)
			content.add(cells[i]);
			
		content.add(initButton);
		content.add(result);
		content.add(exitButton);
		
		startGame();
	}
	
	public void startGame() {
		OTurn = true;
		isGameOver = false;
		
		for(int i=0; i<9; i++) {
			char ch = (char)('0'+i+1);
			cells[i].setText(""+ch);
		}
		
		result.setText("O's Turn");
		setVisible(true);
	}
	
	public boolean checkForWinner() {
		if(cells[0].getText().equals(cells[1].getText()) && cells[1].getText().equals(cells[2].getText())) {
			return true;
		}
		else if(cells[3].getText().equals(cells[4].getText()) && cells[4].getText().equals(cells[5].getText())) {
			return true;
		}
		else if(cells[6].getText().equals(cells[7].getText()) && cells[7].getText().equals(cells[8].getText())) {
			return true;
		}
		else if(cells[0].getText().equals(cells[3].getText()) && cells[3].getText().equals(cells[6].getText())) {
			return true;
		}
		else if(cells[1].getText().equals(cells[4].getText()) && cells[4].getText().equals(cells[7].getText())) {
			return true;
		}
		else if(cells[2].getText().equals(cells[5].getText()) && cells[5].getText().equals(cells[8].getText())) {
			return true;
		}
		else if(cells[0].getText().equals(cells[4].getText()) && cells[4].getText().equals(cells[8].getText())) {
			return true;
		}
		else if(cells[2].getText().equals(cells[4].getText()) && cells[4].getText().equals(cells[6].getText())) {
			return true;
		}
		else
			return false;
	}
	
	public static void main(String[] args) {
		TicTacToeGUI gui = new TicTacToeGUI();
	}
	
	private class cellButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if(isGameOver)
				return;

			JButton pressed = (JButton)(e.getSource());
			
			String text = pressed.getText();
			
			if(text.equals("O") || text.equals("X"))
				return;
			
			if(OTurn)
				pressed.setText("O");
			else
				pressed.setText("X");
			
			if(checkForWinner())
			{
				isGameOver = true;
				if(OTurn)
					result.setText("O wins!");
				else
					result.setText("X wins!");
			}
			else
			{
				OTurn =! OTurn;
				if(OTurn)
					result.setText("O's Turn");
				else
					result.setText("X's Turn");
			}
		}
	}
	
	private class ExitButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	private class InitButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			startGame();
		}
	}
}
