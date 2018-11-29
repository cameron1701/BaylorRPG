package Menu;

import apackage.Map;
import apackage.TextArea;
import battlePackage.EnemyList;
import battlePackage.Player;

import javax.swing.*;

import Story.Boss;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
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
	private Player player = new Player();

	private List<Player> players = new ArrayList<Player>();
	private JPanel mainTextPanel, menuPanel;
	private JLabel titleNameLabel;
	private Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	private Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
	private JButton menuButton, mapButton;
	private JTextArea mainTextArea;
	
	private EnemyList e = new EnemyList();

	public void createGameScreen(JFrame w, Container c, JPanel t, JPanel g, Player p) {

		// Assign values to window, container, titleNamePanel, and gamePanel
		this.window = w;
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		player = p;
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
		this.createGameScreen(window, container, titleNamePanel, gamePanel, player);
	}

	void loadGame(JFrame window, Container container, JPanel titleNamePanel, JPanel gamePanel) {
		try {
			Scanner reader = new Scanner(new FileReader(file));
			String line = null, attackNames = null;
			String[] col = null;
			int currentHealth, totalHealth, attack, defense;
			// Level l = null;
            List<String[]> lines = new ArrayList<>();

			// Read
			line = reader.nextLine();

			// Read from .csv file
			line = reader.nextLine();
			col = line.split(",");

			// Close .csv file
			reader.close();

			// Get Player attributes from list of lines

			player = new Player();
			player.setName(col[0]);
			player.setCurrentHealth(Integer.parseInt(col[1]));
			player.setTotalHealth(Integer.parseInt(col[2]));
			player.setAttack(Integer.parseInt(col[3]));
			player.setDefense(Integer.parseInt(col[4]));
			
			e = new EnemyList();
			
			for(int i = 0; i < 3; i++) {
				if(col[i + 5].equals("T")) {
					e.getBossList().get(i).setDefeated(true);
				} else {
					e.getBossList().get(i).setDefeated(false);
				}
			}
			
			this.createGameScreen(window, container, titleNamePanel, gamePanel, player);

		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found.");
		}
	}

	public void saveGame(EnemyList eList, Player p) throws IOException {
		try {
			// Open file to write into in append mode
			// Prevents old data from being overwritten
			FileWriter writer = new FileWriter(file, true);
			
			List<Boss> list = eList.getBossList();
			
			player = p;
			
			// Write attributes to a CSV file
			writer.write(player.getName() + ",");
			writer.write(player.getCurrentHealth() + ",");
			writer.write(player.getTotalHealth() + ",");
			writer.write(player.getAttack() + ",");
			writer.write(player.getDefense() + ",");
			
			for(int i = 0; i < 3; i++) {
				if(list.get(i).getDefeated()) {
					writer.write("T" + ",");
				} else {
					writer.write("F" + ",");
				}
			}
			
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
		// Exit game
		window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand() == "Menu") {
			// Create Menu screen
			Menu menu = new Menu(this, this.player);
			//menu.createMenuScreen(window, container, titleNamePanel, gamePanel);
			menu.createMenuScreen();
		}

		if (event.getActionCommand() == "Map") {
			// Create Map screen
			Map map = new Map();
			map.printMenu();

			new TextArea(this.player, e);
            
			window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
		}
	}
}
