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
		final EnemyList e = new EnemyList();
		final List<Enemy> toBattle = new ArrayList<Enemy>();
		
		toBattle.add(e.getRandomEnemy());
		toBattle.add(e.getRandomEnemy());
		toBattle.add(e.getRandomEnemy());

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// Make new BattleSpace with player and enemies
				new BattleSpace(player, toBattle);
				
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
