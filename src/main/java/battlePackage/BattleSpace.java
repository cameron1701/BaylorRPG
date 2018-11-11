package battlePackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class BattleSpace extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JMenu selectEnemyMenu;
	private JMenuBar menuBar;
	private JButton returnButton;
	private JButton fightButton;
	private JButton runButton;
	private JButton startButton;
	private JButton endTurnButton;
	private JPanel buttonPanel;
	private JTextArea log;
	private JScrollPane logScrollPane;
	private Player player;
	private BattleGraphics bGraphic;
	private int index;
	private List<Enemy> enemies;
	private Timer timer;
	private Random rand = new Random();

	BattleSpace(Player p, List<Enemy> enemies) {
		// Text Area Set Up
		super(new BorderLayout());
		this.log = new JTextArea(700, 700);
		this.log.setOpaque(true);
		this.log.setMargin(new Insets(5, 5, 5, 5));
		this.log.setEditable(false);
		this.log.setBackground(Color.BLACK);
		this.log.setForeground(Color.GREEN);
		this.logScrollPane = new JScrollPane(this.log);
		this.logScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.logScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		// Assign characters
		this.player = p;
		this.enemies = enemies;

		// Make a new Timer for showing results
		this.timer = new Timer();

		// Select Enemy Menu Set Up
		this.selectEnemyMenu = new JMenu("Select Enemy");
		this.selectEnemyMenu.setBorderPainted(false);
		this.selectEnemyMenu.setOpaque(true);
		this.selectEnemyMenu.setEnabled(false);

		// Add Menu Items
		for (Enemy e : this.enemies) {
			JMenuItem menuItem = new JMenuItem(e.getName() + ": " + e.getCurrentHealth());
			menuItem.setVisible(true);
			menuItem.setBackground(Color.BLACK);
			menuItem.setForeground(Color.GREEN);
			menuItem.addActionListener(this);
			this.selectEnemyMenu.add(menuItem);
		}

		// Add Menu to MenuBar
		this.menuBar = new JMenuBar();
		this.menuBar.setForeground(Color.GREEN);
		this.menuBar.setBackground(Color.BLACK);
		this.menuBar.add(this.selectEnemyMenu);

		// Set Up Buttons
		this.fightButton = new JButton("ATTACK");
		this.fightButton.addActionListener(this);
		this.fightButton.setBackground(Color.GREEN);
		this.fightButton.setOpaque(true);
		this.fightButton.setBorderPainted(false);
		this.fightButton.setEnabled(false);

		this.runButton = new JButton("RETREAT");
		this.runButton.addActionListener(this);
		this.runButton.setBackground(Color.GREEN);
		this.runButton.setOpaque(true);
		this.runButton.setBorderPainted(false);
		this.runButton.setEnabled(false);

		this.startButton = new JButton("START");
		this.startButton.addActionListener(this);
		this.startButton.setBackground(Color.GREEN);
		this.startButton.setOpaque(true);
		this.startButton.setBorderPainted(false);

		this.endTurnButton = new JButton("END TURN");
		this.endTurnButton.addActionListener(this);
		this.endTurnButton.setBackground(Color.RED);
		this.endTurnButton.setOpaque(true);
		this.endTurnButton.setBorderPainted(false);
		this.endTurnButton.setEnabled(false);

		this.returnButton = new JButton("Return to Arena");
		this.returnButton.addActionListener(this);
		this.returnButton.setBackground(Color.GREEN);
		this.returnButton.setOpaque(true);
		this.returnButton.setBorderPainted(false);
		this.returnButton.setEnabled(true);

		// Button Panel Set Up
		this.buttonPanel = new JPanel();
		this.buttonPanel.add(this.fightButton);
		this.buttonPanel.add(this.runButton);
		this.buttonPanel.add(this.startButton);
		this.buttonPanel.add(this.endTurnButton);

		// Add Log and ButtonPanel
		this.add(this.buttonPanel, BorderLayout.PAGE_END);
		this.add(this.logScrollPane, BorderLayout.CENTER);

		// Create and Show Battle Space
		this.createAndShowGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.startButton) {
			// Prompt player for action
			this.log.append("What Do You Want To Do? \n");

			// Disable Start Button
			this.startButton.setEnabled(false);

			// Enable Player Action Buttons
			this.fightButton.setEnabled(true);
			this.runButton.setEnabled(true);
		} else if (e.getSource() == this.fightButton) {
			// Disable Player Action Buttons
			this.fightButton.setEnabled(false);
			this.runButton.setEnabled(false);

			// Display Player Action Selection
			this.log.append("You " + player.getRandAttack(rand.nextInt(player.getAttackNamesSize())) + "\n");
			this.log.append("You Selected: " + this.fightButton.getActionCommand() + "\n");

			// Prompt Player to Select an Enemy to Attack
			this.log.append("Select an Enemy...\n");

			// Enable Enemy Selection Menu
			this.selectEnemyMenu.setEnabled(true);
		} else if (e.getSource() == this.runButton) {
			// Disable Player Action Buttons
			this.fightButton.setEnabled(false);
			this.runButton.setEnabled(false);

			// Display Player Action Selection
			this.log.append("You Selected: " + this.runButton.getActionCommand() + "\n");

			// Show Retreat Graphic
			this.timer.schedule(new TimerTask() {
				@Override
				public void run() {
					showResult("retreat");
				}
			}, 3000);
		}

		else if (e.getSource() == this.endTurnButton) {
			// Get Enemies that are Alive
			for (Enemy enemy : this.enemies) {
				if (!enemy.isDefeated()) {
					// Show Enemy Action
					this.log.append("The " + enemy.getName() + " attacked!\n");

					// Enemy Attack
					enemy.attack(this.player);
				}
			}

			// Disable Button
			this.endTurnButton.setEnabled(false);

			// Enable Player Action Buttons
			this.fightButton.setEnabled(true);
			this.runButton.setEnabled(true);

			// Show Enemy Attack Result
			if (this.player.getCurrentHealth() > 0) {
				this.log.append("You now have " + this.player.getCurrentHealth() + "/" + this.player.getTotalHealth()
						+ " health.\n");
			} else {
				// Disable Button
				this.endTurnButton.setEnabled(false);

				// Show Results
				this.log.append("You Lost The Fight!\n");
				this.log.append(this.enemies.get(this.index).getName() + " has Defeated You!\n");

				// Show Lose Graphic
				this.timer.schedule(new TimerTask() {
					@Override
					public void run() {
						showResult("lose");
					}
				}, 3000);
			}
		} else if (e.getSource() == this.returnButton) {
			this.frame.dispose();
		} else {
			// Determine Enemy to Attack
			for (int i = 0; i < this.enemies.size(); i++) {
				if (e.getActionCommand().contains(this.enemies.get(i).getName())) {
					this.index = i;
				}
			}

			// Attack Enemy
			this.player.attack(this.enemies.get(this.index));

			// Update Enemy Selection Menu
			this.updateMenuItems();

			// Disable Buttons
			this.selectEnemyMenu.setEnabled(false);
			this.endTurnButton.setEnabled(true);

			// Show Result from Attack
			if (this.enemies.get(this.index).getCurrentHealth() > 0) {
				this.log.append("The " + this.enemies.get(this.index).getName() + " now has "
						+ this.enemies.get(this.index).getCurrentHealth() + "/"
						+ this.enemies.get(this.index).getTotalHealth() + " health.\n");
			} else {
				this.log.append("You have Defeated " + this.enemies.get(this.index).getName() + "!\n");
			}

			// Check if Battle is Finished
			if (this.endOfBattle()) {
				// Disable Button
				this.endTurnButton.setEnabled(false);

				// Display Results
				this.log.append("You Won the Battle!\n");

				// Show Win Graphic
				this.timer.schedule(new TimerTask() {
					@Override
					public void run() {
						showResult("win");
					}
				}, 3000);
			}
		}
	}

	private void createAndShowGUI() {
		// Frame Set Up
		this.frame = new JFrame("Battle");
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.setPreferredSize(new Dimension(800, 700));
		this.frame.setResizable(false);
		this.frame.setJMenuBar(this.menuBar);
		this.setOpaque(true);
		this.frame.add(this);
		
		// Show Frame
		this.frame.pack();
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
	}

	private void showResult(String str) {
		// Show Battle Outcome
		this.bGraphic = new BattleGraphics(str);
		this.frame.remove(this);
		this.frame.getJMenuBar().remove(this.selectEnemyMenu);
		this.frame.add(this.bGraphic);
		this.frame.pack();

		// Show Battle Statistics
		this.timer.schedule(new TimerTask() {
			@Override
			public void run() {
				printBattleStats();
			}
		}, 3000);
	}

	private void updateMenuItems() {
		// Update Enemy Menu Status
		for (int i = 0; i < this.selectEnemyMenu.getItemCount(); i++) {
			if (this.enemies.get(i).getCurrentHealth() <= 0) {
				this.selectEnemyMenu.getItem(i).setText(this.enemies.get(i).getName() + ": Diseased");
				this.selectEnemyMenu.getItem(i).setEnabled(false);
			} else {
				this.selectEnemyMenu.getItem(i)
						.setText(this.enemies.get(i).getName() + ": " + this.enemies.get(i).getCurrentHealth());
			}
		}
	}

	private boolean endOfBattle() {
		// Check all Enemy Health
		for (Enemy e : this.enemies) {
			if (e.getCurrentHealth() > 0) {
				return false;
			}
		}
		return true;
	}

	private void printBattleStats() {
		// Set Up Result Frame
		this.remove(this.buttonPanel);
		this.buttonPanel.removeAll();
		this.buttonPanel.add(this.returnButton);
		this.add(this.buttonPanel, BorderLayout.PAGE_END);
		this.frame.remove(this.bGraphic);
		this.frame.add(this);
		this.frame.pack();

		// Print Battle Statistics
		this.log.setText("");
		this.log.append("\tBattle Statistics\n");
		this.log.append("Player\t\t\tStatus\n");
		if (this.player.getCurrentHealth() <= 0) {
			this.log.append(this.player.getName() + "\t\t\tDiseased\n\n");
		} else {
			this.log.append(this.player.getName() + "\t\t\t" + this.player.getCurrentHealth() + "\n\n");
		}

		this.log.append("Enemy\t\t\tStatus\n");
		for (Enemy e : this.enemies) {
			if (e.getCurrentHealth() <= 0) {
				this.log.append(e.getName() + "\t\t\tDiseased\n");
			} else {
				this.log.append(e.getName() + "\t\t\t" + e.getCurrentHealth() + "\n");
			}
		}
	}
}
