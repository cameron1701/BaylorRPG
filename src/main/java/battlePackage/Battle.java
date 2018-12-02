package battlePackage;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Battle {
	private static Logger logger = Logger.getLogger("Error Logger");
	
	public static void battle(Player p) {
		final Player player = p;
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
					logger.log(Level.SEVERE, "Exception Thrown!", e);
				}

			}
		});
	}

	public static void bossBattle(Player p, String id, EnemyList e) {
		final Player player = p;
		//final EnemyList e = new EnemyList();

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// Make new BattleSpace with player and boss

				if (id.equals("CASH")) {
					new BossBattleSpace(player, e.getBossList().get(1));
				} else if (id.equals("BSB")) {
					new BossBattleSpace(player, e.getBossList().get(2));
				} else if (id.equals("TEAL")) {
					new BossBattleSpace(player, e.getBossList().get(0));
				}

				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					logger.log(Level.SEVERE, "Exception Thrown!", e);
				}

			}
		});
	}

}
