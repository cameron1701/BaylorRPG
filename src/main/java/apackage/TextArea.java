package apackage;

import Menu.Menu;
import battlePackage.Battle;
import battlePackage.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextArea extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextArea log;
	private JScrollPane logScrollPane;
	private JPanel buttonPanel;
	private JButton nextButton;
	private Player player;
	// private String bID = "CASH";

	private String inputString;
	private JTextField input;
	private JButton enterButton, menuButton;

	private Building building = new Building("CASH");

	public TextArea(Player p) {
		// Text Area Set Up
		super(new BorderLayout());
		this.player = p;
		this.log = new JTextArea(700, 700);
		this.log.setOpaque(true);
		this.log.setMargin(new Insets(5, 5, 5, 5));
		this.log.setEditable(false);
		this.log.setBackground(Color.BLACK);
		this.log.setForeground(Color.GREEN);
		this.logScrollPane = new JScrollPane(this.log);
		this.logScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.logScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		// Add scroll pane and tell border layout
		this.add(this.logScrollPane, BorderLayout.CENTER);

		// Make a buttonListener
		ButtonListener buttonListener = new ButtonListener();

		// Create enterButton
		this.enterButton = new JButton("ENTER");
		this.enterButton.addActionListener(this);
		this.enterButton.setBackground(Color.GREEN);
		this.enterButton.setOpaque(true);
		this.enterButton.setBorderPainted(false);
		this.enterButton.setEnabled(true);

		// Create menuButton
		this.menuButton = new JButton("MENU");
		this.menuButton.addActionListener(this);
		this.menuButton.setBackground(Color.GREEN);
		this.menuButton.setOpaque(true);
		this.menuButton.setBorderPainted(false);
		this.menuButton.setEnabled(true);
		this.menuButton.setActionCommand("Menu");

		// Make buttons have a buttonListener
		enterButton.addActionListener(buttonListener);
		menuButton.addActionListener(this);

		// Make input text field
		input = new JTextField(20);
		input.setActionCommand("ENTER");
		input.addActionListener(buttonListener);

		// Make new buttonPanel
		this.buttonPanel = new JPanel();

		// Add input field and enter button to buttonPanel
		this.buttonPanel.add(this.input);
		this.buttonPanel.add(this.enterButton);
		this.buttonPanel.add(this.menuButton);
		this.add(this.buttonPanel, BorderLayout.PAGE_END);

		// Print the menu of options to travel to
		log.append("\nWhere would you like to go?\n");
		log.append("\n+------------------------------+\n");
		building.printBuildingMenu(log);
		log.append("+------------------------------+\n");

		this.setVisible(true);
		// Create and Show Map
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand() == "Menu") {

			// Create Menu screen
			Menu menu = new Menu();
			menu.createMenuScreen();
		}
	}

	public void createAndShowGUI() {
		// Frame Set Up
		this.frame = new JFrame("Map");
		this.frame.setLocationRelativeTo(null);
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.setPreferredSize(new Dimension(800, 700));
		this.frame.setResizable(false);
		this.setOpaque(true);
		this.frame.add(this);

		// Show Frame
		this.frame.pack();
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
	}

	public class ButtonListener implements ActionListener {
		public void actionPerformed(final ActionEvent ev) {
			// Get input from input box
			inputString = input.getText();
			input.setText("");
			input.requestFocus();

			// Echo print
			log.append("You selected " + inputString);

			// Change buildings
			building = new Building(building.setID(inputString));

			// Print current building
			log.append("\nYou are now in " + building.getID() + "\n\n");

			// Show building description
			log.append(building.buildingDesc() + "\n");

			// Have a battle in the BSB (for demo)
			if (building.getID().equals("BSB")) {
				Battle.battle(player);
			}

			// Ask to move
			building.printBuildingMenu(log);
			log.append("\nWhere would you like to go?\n");
		}
	}

}
