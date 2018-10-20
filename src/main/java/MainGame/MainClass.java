package MainGame;

import java.awt.*;
import java.awt.image.BufferStrategy;
import battlePackage.Battle;

public class MainClass extends Canvas implements Runnable {
	private static final long serialVersionUID = 7034980898387217024L;
	public static final int WIDTH = 1000, HEIGHT = 1000;
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

	/*
	 * Game loop to update the game and display a frames per second counter in the
	 * console Called by thread.start() we created in start() method Resources:
	 * https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html#Thread(java.
	 * lang.Runnable)
	 * https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html#start()
	 * https://docs.oracle.com/javase/7/docs/api/java/lang/Runnable.html#run()
	 */
	public void run() {
		long lastTime = System.nanoTime(); // instantiated to current time, used to measure amount of time passed
		double amountOfTicks = 60.0; // num ticks per sec
		double ns = 1000000000 / amountOfTicks; // nanoseconds between ticks
		double delta = 0; // difference in time between ticks
		long timer = System.currentTimeMillis(); // instantiated to current time in ms, used to measure 1sec
		int frames = 0; // counts frames per second i.e. calls to render
		// Battle battle = new Battle();

		Battle.battle();

		// While the game is running
		while (running) {
			long now = System.nanoTime(); // grab the current system time
			delta += (now - lastTime) / ns; // find the diff. from the current time and the last iteration of the loop
			lastTime = now; // update previous time to now
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running) {
				render();
			}
			frames++; // increase the frame counter

			// If one sec. has passed
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000; // increase the timer by 1000ms
				System.out.println("FPS: " + frames); // print the fps to the console
				frames = 0; // reset the frame counter
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
