package MainGame;

import java.awt.*;

// Class for main window of game
public class Window extends Canvas {

	private static final long serialVersionUID = -1252554278185049860L;

	public Window(int width, int height, String title, MainClass game) {
		game.start();
	}
}
