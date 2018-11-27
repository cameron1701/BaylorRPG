package battlePackage;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name;
	private int currentHealth;
	private int totalHealth;
	private int attack;
	private int defense;
	private List<String> attackNames = new ArrayList<String>();

	public Player(String s) {
		if(s != null) {
			this.name = s;
		}
		else {
			this.name = "player";
		}
		this.totalHealth = 30;	
		this.currentHealth = this.totalHealth;
		this.attack = 10;
		this.defense = 7;
		this.initAttackNames();
	}

	public void initPlayer(String s) {
		name = s;
	}

	public int getAttackNamesSize() {
		return attackNames.size();
	}

	public String getRandAttack(int a) {
		return attackNames.get(a);
	}

	public void initAttackNames() {
		attackNames.add("managed your schedule!");
		attackNames.add("pulled an all-nighter!");
		attackNames.add("slept well!");
		attackNames.add("went to office hours!");
		attackNames.add("went to StackOverflow!");
		attackNames.add("had Chick-Fil-A!");
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth -= currentHealth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalHealth() {
		return totalHealth;
	}

	public void setTotalHealth(int totalHealth) {
		this.totalHealth = totalHealth;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public void attack(Enemy e) {
		e.setCurrentHealth(Math.abs(this.attack - e.getDefense()));
	}
}
