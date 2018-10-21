package battlePackage;

public class Enemy {
	private String name;
	private int currentHealth;
	private int totalHealth;
	private int attack;
	private int defense;
	
	Enemy(String s, int tHealth, int atk, int def) {
		this.name = s;
		this.totalHealth = tHealth;
		this.currentHealth = this.totalHealth;
		this.attack = atk;
		this.defense = def;
	}

	public boolean isDefeated() {
		if(this.currentHealth <= 0) {
			return true;
		}
		return false;
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
