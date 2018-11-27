package Story;

import Menu.Menu;
import battlePackage.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Advisor extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextArea log;
	private JScrollPane logScrollPane;
	private JPanel buttonPanel;
	private JButton nextButton;
	private Player player;
	private String inputString;
	private JTextField input;
	private JButton enterButton, menuButton;
	public Advisor(Player p) throws InterruptedException {
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

		log.append("Hi there " + p.getName() + ", and welcome to your first year at Baylor University!");
		Thread.sleep(2000);
		log.append("I see your major is Computer Science! That sounds like a lot of fun.");
		Thread.sleep(1000);
		log.append("Before you start your journey, please pick a student build!");
		//log.append("");

		this.setVisible(true);
		// Create and Show Advisor
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI();
			}
		});
	}

	public Player advise(Player p) {


		return p;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand() == "Menu") {

			// Create Menu screen
			Menu menu = new Menu();
			menu.createMenuScreen();
		}
	}

	private void createAndShowGUI() {
		// Frame Set Up
		this.frame = new JFrame("Advisor");
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

		}
	}

}
