package edu.baylor.ecs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Game {
	private File file = new File("BearQuestDB.csv");
	private String[] headers = { "Player", "Level", "Location" ,"Skills", "Items" };
	private List<String[]> data = new ArrayList<String[]>();
	
	public void createGameScreen() {
		try {
			Scanner sc = new Scanner(file);
			String line = null;

			// Read from .csv file
			while (sc.hasNext()) {
				line = sc.nextLine();
				String[] str = new String[headers.length];
				String[] col = line.split(",");

				// Populate str with values in col
				for (int i = 0; i < headers.length; i++) {
					if (i < col.length) {
						str[i] = col[i];
					}

					else {
						str[i] = "";
					}
				}

				// Populate data with info of current
				data.add(str);
			}

			// Close .csv file
			sc.close();

		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found.");
		}
	}
	
	void startNewGame(JFrame window) {
		String playerName = (String) JOptionPane.showInputDialog(window, "Choose a name", "Player Name",
				JOptionPane.YES_NO_CANCEL_OPTION, null, null, null);
		Player player = new Player(playerName);
	}
	
	void loadGame() {
		
	}
	
	public void saveGame() throws IOException {
		try {
			FileWriter writer = new FileWriter(file);

			for (int i = 0; i < data.size(); i++) {
				String str = new String();

				for (int j = 0; j < data.get(i).length - 1; j++) {
					str += (data.get(i)[j] + ",");
				}
				str += (data.get(i)[data.get(0).length - 1]);
				writer.write(str.trim() + '\n');
			}
			writer.flush();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR: File not found");
		}
	}
	
	void pauseGame() {
		
	}
	
	void restartLevel( ) {
		
	}
	
	void quitGame() {
		// Exit game
		System.exit(0);
	}
	
	void createMenuScreen() {
		
	}
}
