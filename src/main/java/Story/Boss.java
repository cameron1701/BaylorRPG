package Story;

import java.util.ArrayList;
import java.util.List;

import battlePackage.Enemy;

public class Boss {
	private Enemy boss = new Enemy();
	private List<String> attackLines = new ArrayList<String>();

	private boolean isDefeated = false;
	
	public Boss(Enemy e) {
		boss = e;
		attackLines.add("I am attacking!");
	}
	
	public void setDefeated(boolean b) {
		isDefeated = b;
	}
	
	public boolean getDefeated() {
		return isDefeated;
	}
	
	public Enemy getBoss() {
		return boss;
	}
	
	public int getAttackLinesSize() {
		return attackLines.size();
	}
	
	public String getLine(int i) {
		return attackLines.get(i);
	}
}
