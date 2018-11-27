package apackage;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Map {
	protected static List<String> buildingList = null;
	protected JTextArea log;
	JLabel label = new JLabel();
	JTextField textfield = new JTextField("", 10);
	private String selection;

	public Map() {
	}

	public void printMenu() {
		// Optional menu in map
		label.setBackground(Color.WHITE);
		label.setForeground(Color.green);
		textfield.setVisible(true);
		label.setVisible(true);

		String temp = new String();
		System.out.println(selection);
		temp = "+----------------------------------+\n" + "        Select a building          ";
	}
	
	public List<String> getBuildingList() {
		return buildingList;
	}
}
