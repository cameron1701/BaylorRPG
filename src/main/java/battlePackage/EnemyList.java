package battlePackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Story.Boss;

public class EnemyList {
	private List<Enemy> enemyList = new ArrayList<Enemy>();
	private List<Boss> bossList = new ArrayList<Boss>();
	
	public EnemyList(){
		enemyList = makeList();
		bossList = makeBossList();
	}
	
	public List<Enemy> getList(){
		return enemyList;
	}
	
	public List<Boss> getBossList() {
		return bossList;
	}
	
	public Enemy getRandomEnemy() {
		Random rand = new Random();
		
		return enemyList.get(rand.nextInt(enemyList.size()));
	}
	
	public boolean bossesDefeated() {
		boolean flag = false;
		
		if(bossList.get(0).getDefeated() && bossList.get(1).getDefeated()
			&& bossList.get(2).getDefeated()) {
			flag = true;
		}
		
		return flag;
	}
	
	public List<Boss> makeBossList(){
		List<Boss> boss = new ArrayList<Boss>();
		
		boss.add(new Boss(new Enemy("Dr. Booth", 30, 4, 3)));
		boss.add(new Boss(new Enemy("Dr. Cerny", 40, 4, 1)));
		boss.add(new Boss(new Enemy("Prof. Fry", 30, 4, 3)));		
		
		return boss;
	}
	
	public List<Enemy> makeList(){
		List<Enemy> list = new ArrayList<Enemy>();
		
		list.add(new Enemy("Homework 1", 5, 2, 1));
		list.add(new Enemy("Homework 2", 10, 4, 3));
		list.add(new Enemy("Homework 3", 20, 8, 5));
		list.add(new Enemy("Barista", 7, 3, 3));
		list.add(new Enemy("Bees?", 1, 1, 1));
		list.add(new Enemy("BEEEEEEEEES", 20, 20, 1));
		list.add(new Enemy("Pre-Med Student", 7, 6, 5));
		list.add(new Enemy("Frat Boi", 3, 10, 7));
		list.add(new Enemy("Librarian", 15, 3, 0));
		list.add(new Enemy("Tour Group", 5, 7, 5));
		list.add(new Enemy("Tour Guide", 20, 1, 1));
		list.add(new Enemy("Segway Dude", 10, 10, 5));
		list.add(new Enemy("AirBear", 15, 2, 1));
		list.add(new Enemy("Wobbly Chair", 5, 2, 1));
		list.add(new Enemy("Bad Keyboard", 10, 5, 3));
		list.add(new Enemy("Unresponsive Monitor", 5, 10, 5));
		list.add(new Enemy("Make-Up Assignment", 7, 4, 3));
		list.add(new Enemy("SUB Cashier", 4, 2, 1));
		list.add(new Enemy("Bus Driver", 7, 6, 4));
		list.add(new Enemy("Security Guard", 20, 5, 5));
		list.add(new Enemy("Lab Assistant", 6, 2, 1));
		list.add(new Enemy("Allergies", 25, 7, 5));
		list.add(new Enemy("Wrong Java Version", 10, 9, 5));
		list.add(new Enemy("Long Line", 9, 2, 1));
		list.add(new Enemy("Runtime Error", 3, 8, 5));
		
		return list;
	}
}
