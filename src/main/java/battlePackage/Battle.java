package battlePackage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Battle {
	public static void battle() {
		final Player player = new Player("Player1");
		final List<Enemy> enemyList = new ArrayList<Enemy>();
		Enemy quiz1 = new Enemy("Quiz 1", 10, 2, 1);
		
		enemyList.add(new Enemy("A", 10, 2, 1));
		enemyList.add(new Enemy("B", 5, 1, 0));
		enemyList.add(new Enemy("C", 7, 4, 1));
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new BattleSpace(player, enemyList);
				try {
					UIManager.setLookAndFeel(
					        UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}

			}	
		});
	}

}
