package Menu;

import battlePackage.*;
import apackage.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main implements ActionListener {

	private JFrame window;
	private Container container;
	private JPanel titleNamePanel, gamePanel;
	private JLabel titleNameLabel;
	private Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	private Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
	private JButton startNewGame, loadGame;

	public void createStartScreen() throws IOException {
		// Create frame
		window = new JFrame("BearQuest");
		window.setSize(800, 700);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		container = window.getContentPane();

		// Title panel
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 650, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("Bear Quest");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);

		// Create start new game panel
		gamePanel = new JPanel();
		gamePanel.setBounds(300, 400, 250, 100);
		gamePanel.setBackground(Color.black);

		// Create start new game button
		startNewGame = new JButton("Start New Game");
		startNewGame.setBackground(Color.black);
		startNewGame.setForeground(Color.white);
		startNewGame.setFont(normalFont);
		startNewGame.addActionListener(this);
		startNewGame.setFocusPainted(false);

		// Create load game button
		loadGame = new JButton("Load Game");
		loadGame.setBackground(Color.black);
		loadGame.setForeground(Color.white);
		loadGame.setFont(normalFont);
		loadGame.addActionListener(this);
		loadGame.setFocusPainted(false);

		titleNamePanel.add(titleNameLabel);
		gamePanel.add(startNewGame);
		gamePanel.add(loadGame);

		container.add(titleNamePanel);
		container.add(gamePanel);
	}

	public static void main(String[] args) {
		final Main guiMaker = new Main();

		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				try {
					guiMaker.createStartScreen();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void actionPerformed(ActionEvent event) {
		Game game = new Game();

		if (event.getActionCommand() == "Start New Game") {
			System.out.println("New Game Started!");

			// Start new game
			game.startNewGame(window, container, titleNamePanel, gamePanel);
		}

		if (event.getActionCommand() == "Load Game") {
			System.out.println("Game loaded!");

			// Start new game
			game.loadGame();
		}
	}
}
