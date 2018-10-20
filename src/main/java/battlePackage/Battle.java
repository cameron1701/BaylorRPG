package battlePackage;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Battle {
	public static void main(String args[]) {
		Player player = new Player("Player1");
		Enemy enemy = new Enemy("Goblin");
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new BattleSpace(player, enemy);
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
