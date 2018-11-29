package MainGame;

import java.awt.*;

import Menu.*;

public class MainClass extends Canvas implements Runnable {
	private static final long serialVersionUID = 7034980898387217024L;
	public static final int WIDTH = 800, HEIGHT = 640;
	private Thread thread;

	// Default constructor that creates the main game window
	public MainClass() {
		new Window(WIDTH, HEIGHT, "BearQuest", this);
	}

	// Spawns a new process that starts the game
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
	}

	// Stops the game by killing the thread
	public synchronized void stop() {
		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
        Main.startMenu();
	}

	public static void main(String[] args) {
		new MainClass();
	}
}
