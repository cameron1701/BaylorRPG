package battlePackage;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Battle {
	public static void main(String args[]) {
		Player player = new Player("Player1");
		List<Enemy> enemyList = new ArrayList<Enemy>();
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
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				
			}	
		});
	}

}
