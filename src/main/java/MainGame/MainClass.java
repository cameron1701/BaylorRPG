package MainGame;

import battlePackage.Battle;

import java.awt.*;
import java.awt.image.BufferStrategy;

import apackage.*;
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
        while (running){

            if (running){
                render();
            }

        }
        stop();

	}


    private void tick() {

    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);


        g.dispose();
        bs.show();
    }

	public static void main(String[] args) {
		new MainClass();
	}

}
