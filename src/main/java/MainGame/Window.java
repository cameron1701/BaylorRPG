package MainGame;

import java.awt.*;

// Class for main window of game
public class Window extends Canvas {

	private static final long serialVersionUID = -1252554278185049860L;

	public Window(int width, int height, String title, MainClass game) {
		/*JFrame frame = new JFrame(title);

		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);*/
		game.start();
	}
}
