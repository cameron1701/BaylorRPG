package apackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class TextArea extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextArea log;
	private JScrollPane logScrollPane;
	private JPanel buttonPanel;
	private JButton nextButton;
	//private String bID = "CASH";
	
	private String inputString;
	private JTextField input;
	private JButton enterButton;
	
	private Building building = new Building("CASH");
	
	TextArea(){
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
		
		this.add(this.logScrollPane, BorderLayout.CENTER);
		
		this.nextButton = new JButton("NEXT");
		this.nextButton.addActionListener(this);
		this.nextButton.setBackground(Color.GREEN);
		this.nextButton.setOpaque(true);
		this.nextButton.setBorderPainted(false);
		this.nextButton.setEnabled(true);
		
		ButtonListener buttonListener = new ButtonListener();
		
		this.enterButton = new JButton("ENTER");
		this.enterButton.addActionListener(this);
		this.enterButton.setBackground(Color.GREEN);
		this.enterButton.setOpaque(true);
		this.enterButton.setBorderPainted(false);
		this.enterButton.setEnabled(true);
		enterButton.addActionListener(buttonListener);
		
		input = new JTextField(20);
		input.setActionCommand("ENTER");
        input.addActionListener(buttonListener);
		
		this.buttonPanel = new JPanel();
		//this.buttonPanel.add(this.nextButton);
		this.buttonPanel.add(this.input);
		this.buttonPanel.add(this.enterButton);
		this.add(this.buttonPanel, BorderLayout.PAGE_END);
		
		//building = new Building(building.setid(inputString));
		building.printBuildingMenu(log);
		log.append("\nWhere would you like to go?\n");
		
		//Create and Show Map
		this.createAndShowGUI();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public class ButtonListener implements ActionListener
    {

        public void actionPerformed(final ActionEvent ev)
        {
            inputString = input.getText();
            input.setText("");
            input.requestFocus();
            
            log.append("You selected " + inputString);
            
            building = new Building(building.setid(inputString));
        }
    }
	
	private void createAndShowGUI() {
		// Frame Set Up
		this.frame = new JFrame("Map");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setPreferredSize(new Dimension(800, 700));
		this.frame.setResizable(false);
		this.setOpaque(true);
		this.frame.add(this);

		// Show Frame
		this.frame.pack();
		this.frame.setVisible(true);
	}
	
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                new TextArea().setVisible(true);
            }
        });
    }
	
}
