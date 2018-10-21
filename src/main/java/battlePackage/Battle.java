package battlePackage;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Battle {
	public static void battle() {
		// Make temp player and enemies for demo, instantiate
		final Player player = new Player("Student");
		final List<Enemy> enemies = new ArrayList<Enemy>();
		enemies.add(new Enemy("Homework 1", 10, 2, 1));
		enemies.add(new Enemy("Quiz", 5, 1, 0));
		enemies.add(new Enemy("Practicum", 7, 4, 1));

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// Make new BattleSpace with player and enemies
				new BattleSpace(player, enemies);
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}

			}
		});
	}

}
