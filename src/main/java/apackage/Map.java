package apackage;

import javax.swing.*;
import java.awt.*;

public class Map {
	protected JTextArea log;
	JLabel label = new JLabel();
	JTextField textfield = new JTextField("", 10);

	public Map() {
	}

	public void printMenu() {
		// Optional menu in map
		label.setBackground(Color.WHITE);
		label.setForeground(Color.green);
		textfield.setVisible(true);
		label.setVisible(true);
	}
}
