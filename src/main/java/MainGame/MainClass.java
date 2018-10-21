package MainGame;

import java.awt.*;

import apackage.TextArea;

public class MainClass extends Canvas implements Runnable {
	private static final long serialVersionUID = 7034980898387217024L;
	public static final int WIDTH = 800, HEIGHT = 640;
	private Thread thread;
	private boolean running = false;

	// Default constructor that creates the main game window
	public MainClass() {
		new Window(WIDTH, HEIGHT, "Bear Quest", this);

	}

	// Spawns a new process that starts the game
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	// Stops the game by killing the thread
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
        TextArea.startMap();
	}

	public static void main(String[] args) {
		new MainClass();
	}

}
