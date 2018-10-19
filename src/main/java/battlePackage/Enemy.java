package battlePackage;

public class Enemy {
	private String name;
	private int currentHealth;
	private int totalHealth;
	private int attack;
	private int defense;
	
	Enemy(String s) {
		this.name = s;
		this.totalHealth = 10;
		this.currentHealth = this.totalHealth;
		this.attack = 3;
		this.defense = 1;
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

	public void attack(Player p) {
		p.setCurrentHealth(Math.abs(this.attack - p.getDefense()));
	}
}
