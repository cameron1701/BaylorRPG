package battlePackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class BattleSpace extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JButton fightButton;
	private JButton runButton;
	private JButton startButton;
	private JButton endTurnButton;
	private JPanel buttonPanel;
	private JTextArea log;
	private JScrollPane logScrollPane;
	private Player player;
	private List<Enemy> enemyList;
	
	BattleSpace(Player p, List<Enemy> eList){
		//Text Area Set Up
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
		
		//Assign characters
		this.player = p;
		this.enemyList = eList;
		
		//Button Set Up
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
		
		//Button Panel Set Up
		this.buttonPanel = new JPanel();
		this.buttonPanel.add(this.fightButton);
		this.buttonPanel.add(this.runButton);
		this.buttonPanel.add(this.startButton);
		this.buttonPanel.add(this.endTurnButton);
		
		//Add Log and ButtonPanel
		this.add(this.buttonPanel, BorderLayout.PAGE_END);
		this.add(this.logScrollPane, BorderLayout.CENTER);
		
		//Create and Show Battle Space
		this.createAndShowGUI();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.startButton) {
			this.log.append("What Do You Want To Do? \n");
			this.startButton.setEnabled(false);
			this.fightButton.setEnabled(true);
			this.runButton.setEnabled(true);
		}
		else if(e.getSource() == this.fightButton){
				this.fightButton.setEnabled(false);
				this.runButton.setEnabled(false);
				this.log.append("You Selected: " + this.fightButton.getActionCommand() + "\n");
				this.log.append("You Attack!\n");
				
				// Have player select which enemy to attack
				this.player.attack(this.enemyList.get(0));
				this.endTurnButton.setEnabled(true);
			if(this.enemyList.get(0).getCurrentHealth() > 0) {
				this.log.append("The " + this.enemyList.get(0).getName() + " now has " + this.enemyList.get(0).getCurrentHealth() + "/"
						+ this.enemyList.get(0).getTotalHealth() + " health.\n");
			}
			else {
				this.endTurnButton.setEnabled(false);
				this.log.append("You Won the Fight!\n");
				this.log.append("You have defeated " + this.enemyList.get(0).getName() + "!\n");
				
				//Show Win Graphic
				this.showResult();
			}
		}
		else if(e.getSource() == this.runButton){
			this.fightButton.setEnabled(false);
			this.runButton.setEnabled(false);
			this.log.append("You Selected: " + this.runButton.getActionCommand() + "\n");
			this.log.append("You Run!\n");
			this.endTurnButton.setEnabled(true);
		}
		
		else{
			if(this.player.getCurrentHealth() > 0) {
				for(int i = 0; i < enemyList.size(); i++) {
					this.log.append("The " + this.enemyList.get(i).getName() + " attacked!\n");
					this.enemyList.get(i).attack(this.player);	
					this.endTurnButton.setEnabled(false);
					this.fightButton.setEnabled(true);
					this.runButton.setEnabled(true);
					this.log.append("You now have " + this.player.getCurrentHealth() + "/"
							+ this.player.getTotalHealth() + " health.\n");
				}
			}
			if(this.player.getCurrentHealth() <= 0) {
				this.endTurnButton.setEnabled(false);
				this.log.append("You Lost The Fight!\n");
				this.log.append(this.enemyList.get(0).getName() + " has Defeated You!\n");
				
				//Show Lose Graphic
				this.showResult();
			}
		}

	}
	
	private void createAndShowGUI() {
		// Frame Set Up
		this.frame = new JFrame("Battle");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setPreferredSize(new Dimension(800, 700));
		this.frame.setResizable(false);
		this.setOpaque(true);
		this.frame.add(this);

		// Show Frame
		this.frame.pack();
		this.frame.setVisible(true);
	}
	
	private void showResult() {
		this.frame.remove(this);
		this.frame.setPreferredSize(new Dimension(800, 800));
		this.frame.add(new BattleGraphics());
		this.frame.pack();
	}
}
