package Menu;

import apackage.Map;
import apackage.TextArea;
import battlePackage.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game implements ActionListener {

	private JFrame window;
	private Container container;
	private JPanel titleNamePanel, gamePanel;
	private File file = new File("BearQuestDB.csv");
	private String[] headers;
	private String playerName;
	private Player player = null;

	private List<Player> players = new ArrayList<Player>();
	private JPanel mainTextPanel, menuPanel;
	private JLabel titleNameLabel;
	private Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	private Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
	private JButton menuButton, mapButton;
	private JTextArea mainTextArea;

	public void createGameScreen(JFrame w, Container c, JPanel t, JPanel g, Player p) {

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
		mainTextPanel.setBounds(100, 100, 600, 500);
		mainTextPanel.setBackground(Color.black);
		container.add(mainTextPanel);

		// Set main text area
		mainTextArea = new JTextArea("Welcome, " + p.getName() + "!\n\nYou are about to embark"
				+ " in a 4 year adventure that\nwill define the rest of your life!"
				+ "\n\nThe first task for you to follow is to meet up with\nyour academic advisor."
				+ " Once this is done, you will be able to walk around campus and complete your" 
				+ "\nassignments.\n\nNow you should go and get to know the campus by\ngoing to the Map." 
				+ "\n\nGood luck on your BearQuest!");
		mainTextArea.setBounds(100, 100, 600, 400);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setEditable(false);
		mainTextPanel.add(mainTextArea);

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
        playerName = JOptionPane.showInputDialog(window, "Choose a name", "New Player",
				JOptionPane.DEFAULT_OPTION);
		player = new Player(playerName);

		// Create a new game and open the screen
		//Game game = new Game();
		this.createGameScreen(window, container, titleNamePanel, gamePanel, player);
	}

	void loadGame() {
		try {
			Scanner reader = new Scanner(new FileReader(file));
			String line = null, attackNames = null;
			String[] col = null;
			int currentHealth, totalHealth, attack, defense, level;
			// Level l = null;
            List<String[]> lines = new ArrayList<>();

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
					// l = new Level(level);
					player = new Player(playerName);
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found.");
		}
	}

	public void saveGame() throws IOException {
		try {
			// Open file to write into in append mode
			// Prevents old data from being overwritten
			FileWriter writer = new FileWriter(file, true);
			
			// Write attributes to a CSV file
			writer.write(player.getName() + ",");
			writer.write(player.getCurrentHealth() + ",");
			writer.write(player.getTotalHealth() + ",");
			writer.write(player.getAttack() + ",");
			writer.write(player.getDefense() + ",");
			
			// Write newline character at the end
			writer.write("\n");
			
			writer.flush();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR: File not found");
		}
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
			// Create Menu screen
			Menu menu = new Menu(this, this.player);
			menu.createMenuScreen(window, container, titleNamePanel, gamePanel);
		}

		if (event.getActionCommand() == "Map") {
			// Create Map screen
			Map map = new Map();
			map.printMenu();

			new TextArea(this.player);
            //TextArea.startMap();
			//MainClass.run();
		}
	}
}
