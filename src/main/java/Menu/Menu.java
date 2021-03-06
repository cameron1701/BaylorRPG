package Menu;

import battlePackage.EnemyList;
import battlePackage.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu implements ActionListener {
	private JFrame window;
	private Container container;
	private JPanel titleNamePanel, gamePanel;
	private JLabel titleNameLabel;
	private Font titleFont = new Font("Times New Roman", Font.PLAIN, 40);
	private Font normalFont = new Font("Times New Roman", Font.PLAIN, 22);
	private JButton startNewGame, loadGame, saveGame, quitGame, back;
	private Player player;
	private Game game = new Game();
	private EnemyList e = new EnemyList();
	private Logger logger = Logger.getLogger("Error Logger");

	public Menu(){}

	Menu(Game g, Player p){
		this.player = p;
		this.game = g;
	}
	
	public Menu(EnemyList eList, Player p){
		e = eList;
		player = p;
	}

	public void createMenuScreen() {
		// Create frame
		window = new JFrame("BearQuest");
		window.setSize(800, 700);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		container = window.getContentPane();

		// Create title panel
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 80);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("Game Menu");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);

		// Create start new game panel
		gamePanel = new JPanel();
		gamePanel.setBounds(300, 200, 180, 300);
		gamePanel.setBackground(Color.black);

		// Create start new game button
		startNewGame = new JButton("Start New Game");
		startNewGame.setBackground(Color.black);
		startNewGame.setForeground(Color.white);
		startNewGame.setFont(normalFont);
		startNewGame.addActionListener(this);
		startNewGame.setFocusPainted(false);
		// startNewGame.setBorderPainted(false);

		// Create start new game button
		loadGame = new JButton("Load Game");
		loadGame.setBackground(Color.black);
		loadGame.setForeground(Color.white);
		loadGame.setFont(normalFont);
		loadGame.addActionListener(this);
		loadGame.setFocusPainted(false);
		// loadGame.setBorderPainted(false);

		// Create save game button
		saveGame = new JButton("Save Game");
		saveGame.setBackground(Color.black);
		saveGame.setForeground(Color.white);
		saveGame.setFont(normalFont);
		saveGame.addActionListener(this);
		saveGame.setFocusPainted(false);
		// saveGame.setBorderPainted(false);

		// Create quit game button
		quitGame = new JButton("Quit Game");
		quitGame.setBackground(Color.black);
		quitGame.setForeground(Color.white);
		quitGame.setFont(normalFont);
		quitGame.addActionListener(this);
		quitGame.setFocusPainted(false);
		// quitGame.setBorderPainted(false);

		// Create back button
		back = new JButton("<<");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setFont(normalFont);
		back.addActionListener(this);
		back.setFocusPainted(false);
		// back.setBorderPainted(false);

		titleNamePanel.add(titleNameLabel);
		gamePanel.add(startNewGame);
		gamePanel.add(loadGame);
		gamePanel.add(saveGame);
		gamePanel.add(quitGame);
		gamePanel.add(back);

		container.add(titleNamePanel);
		container.add(gamePanel);
	}


	public void actionPerformed(ActionEvent event) {
		//Game game = new Game();

        if (event.getActionCommand().equals("Start New Game")) {
			System.out.println("New Game Started!");

			// Start new game
			game.startNewGame(window, container, titleNamePanel, gamePanel);
		}

        if (event.getActionCommand().equals("Load Game")) {
			System.out.println("Game loaded!");

			// Load saved game
			game.loadGame(window, container, titleNamePanel, gamePanel);
		}

        if (event.getActionCommand().equals("Save Game")) {
			System.out.println("Game saved!");

			// Save game
			try {
				game.saveGame(e, player);
			} catch (IOException e) {
				logger.log(Level.SEVERE, "File Not Found!");
			}
		}

        if (event.getActionCommand().equals("Quit Game")) {
			System.out.println("Game quit!");

			// Quit game
			window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
			System.exit(0);
		}

        if (event.getActionCommand().equals("<<")) {
			System.out.println("Going back...");

			// Close Menu window
			window.dispose();
		}
	}
}