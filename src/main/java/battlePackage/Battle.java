package battlePackage;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Story.Boss;

public class Battle {
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
					e.printStackTrace();
				}

			}
		});
	}

	public static void bossBattle(Player p, String id) {
		final Player player = p;
		final EnemyList e = new EnemyList();

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
					e.printStackTrace();
				}

			}
		});
	}

}
