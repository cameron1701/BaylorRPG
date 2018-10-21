package battlePackage;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Battle {
	public static void main(String args[]) {
		final Player player = new Player("Player1");
		final List<Enemy> enemies = new ArrayList<Enemy>();
		enemies.add(new Enemy("Goblin", 10, 2, 1));
		enemies.add(new Enemy("Ninja", 5, 1, 0));
		enemies.add(new Enemy("Hobbit", 7, 4, 1));
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new BattleSpace(player, enemies);
				try {
					UIManager.setLookAndFeel(
					        UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				
			}	
		});
	}

}
