package edu.baylor.ecs;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class Game implements ActionListener {

	private JFrame window;
	private Container container;
	private JPanel titleNamePanel, gamePanel;
	private File file = new File("BearQuestDB.csv");
	private String[] headers;
	private String playerName;
	private Player player = null;
	private List<Player> players = new ArrayList<Player>();
	JPanel mainTextPanel, choiceButtonPanel, menuPanel;
	JLabel titleNameLabel;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
	JButton menuButton, mapButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;

	public void createGameScreen(JFrame w, Container c, JPanel t, JPanel g) {

		// Assign values to window, container, titleNamePanel, and gamePanel
		this.window = w;
		this.container = c;
		this.titleNamePanel = t;
		this.gamePanel = g;
		
		// Clear start window
		titleNamePanel.setVisible(false);
		gamePanel.setVisible(false);

		// Set main text panel
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		container.add(mainTextPanel);

		// Set main text area
		mainTextArea = new JTextArea("Welcome, " + playerName + "!");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setEditable(false);
		mainTextPanel.add(mainTextArea);

		// Set choice button panel
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4, 1));
		container.add(choiceButtonPanel);

		// Set choice 1 button
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(this);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);

		// Set choice 2 button
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(this);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);

		// Set choice 3 button
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(this);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);

		// Set choice 4 button
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(this);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);

		menuPanel = new JPanel();
		menuPanel.setBounds(100, 15, 600, 50);
		menuPanel.setBackground(Color.black);
		menuPanel.setLayout(new GridLayout(1, 4));
		container.add(menuPanel);

		menuButton = new JButton("Menu");
		menuButton.setBackground(Color.black);
		menuButton.setForeground(Color.white);
		menuButton.setFont(normalFont);
		menuButton.setFocusPainted(false);
		menuButton.addActionListener(this);
		menuButton.setActionCommand("Menu");
		menuPanel.add(menuButton);

		mapButton = new JButton("Map");
		mapButton.setBackground(Color.black);
		mapButton.setForeground(Color.white);
		mapButton.setFont(normalFont);
		mapButton.setFocusPainted(false);
		mapButton.addActionListener(this);
		mapButton.setActionCommand("Map");
		menuPanel.add(mapButton);
	}

	void startNewGame(JFrame window, Container container, JPanel titleNamePanel, JPanel gamePanel) {

		// Set background and foreground of input dialog
		UIManager.put("OptionPane.background", Color.black);
		UIManager.put("Panel.background", Color.black);
		UIManager.put("Button.background", Color.black);
		UIManager.put("OptionPane.messageForeground", Color.white);
		UIManager.put("Button.foreground", Color.white);

		// Take player name from user and create new player
		playerName = (String) JOptionPane.showInputDialog(window, "Choose a name", "New Player",
				JOptionPane.DEFAULT_OPTION);
		player = new Player(playerName);

		// Create a new game and open the screen
		Game game = new Game();
		game.createGameScreen(window, container, titleNamePanel, gamePanel);
	}

	void loadGame() {
		try {
			Scanner reader = new Scanner(new FileReader(file));
			String line = null, attackNames = null;
			String[] col = null;
			int currentHealth, totalHealth, attack, defense, level;
			Level l = null;
			List<String[]> lines = new ArrayList<String[]>();

			// Read
			line = reader.nextLine();
			headers = line.split(",");

			// Read from .csv file
			while (reader.hasNext()) {
				line = reader.nextLine();
				col = line.split(",");
				lines.add(col);
			}

			// Close .csv file
			reader.close();

			// Get Player attributes from list of lines
			for (int i = 0; i < lines.size(); i++) {
				for (int j = 0; j < lines.get(i).length; j++) {
					playerName = lines.get(i)[0];
					currentHealth = Integer.parseInt(lines.get(i)[1]);
					totalHealth = Integer.parseInt(lines.get(i)[2]);
					attack = Integer.parseInt(lines.get(i)[3]);
					defense = Integer.parseInt(lines.get(i)[4]);
					level = Integer.parseInt(lines.get(i)[5]);
					attackNames = lines.get(i)[6];
					attackNames = attackNames.replace("_", " ");

					// Create new instances of Level and Player classes, respectively
					l = new Level(level);
					player = new Player(playerName);
				}

				// Add player to the players list
				players.add(player);
			}

		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found.");
		}
	}

	public void saveGame() throws IOException {
		try {
			FileWriter writer = new FileWriter(file);

			for (int i = 0; i < players.size(); i++) {
				String str = new String();

				/*
				 * for (int j = 0; j < players.get(i).length - 1; j++) { str +=
				 * (players.get(i)[j] + ","); } str += (players.get(i)[data.get(0).length - 1]);
				 * writer.write(str.trim() + '\n');
				 */
			}
			writer.flush();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR: File not found");
		}
	}

	void pauseGame() {
		// Pause game

	}

	void restartLevel() {
		Level level = new Level(1);

		level.restart(player);
	}

	void quitGame() {
		// Save game
		try {
			this.saveGame();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Exit game
		System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand() == "Menu") {
			System.out.println("Menu");

			// Create Menu screen
			Menu menu = new Menu();
			menu.createMenuScreen(window, container, titleNamePanel, gamePanel);
		}
		
		if (event.getActionCommand() == "Map") {
			System.out.println("Map");

			// Create Map screen
			Map map = new Map();
			map.createMapScreen();
		}
	}
}
