package battlePackage;

public class Player {
	private String name;
	private int currentHealth;
	private int totalHealth;
	private int attack;
	private int defense;
	
	Player(String s) {
		this.name = s;
		this.totalHealth = 20;
		this.currentHealth = this.totalHealth;
		this.attack = 10;
		this.defense = 5;
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
