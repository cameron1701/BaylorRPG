package battlePackage.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import battlePackage.Enemy;
import battlePackage.Player;

public class EnemyTester {
	protected Enemy e = null;

	@BeforeEach
	void init() {
		this.e = new Enemy("testEnemy", 15, 7, 4);
	}

	@Test
	void testDefeated() {
		if (this.e != null) {
			this.e.setCurrentHealth(this.e.getCurrentHealth());
			Assertions.assertTrue(this.e.isDefeated());
		}
	}

	@Test
	void testCurrentHealth() {
		if (this.e != null) {
			this.e.setCurrentHealth(5);
			Assertions.assertEquals(10, this.e.getCurrentHealth(), "10 Expected");
		}
	}

	@Test
	void testName() {
		if (this.e != null) {
			this.e.setName("newName");
			Assertions.assertEquals("newName", this.e.getName(), "newName Expected");
		}
	}

	@Test
	void testTotalHealth() {
		if (this.e != null) {
			this.e.setTotalHealth(10);
			Assertions.assertEquals(10, this.e.getTotalHealth(), "10 Expected");
		}
	}

	@Test
	void testAttack() {
		if (this.e != null) {
			this.e.setAttack(7);
			Assertions.assertEquals(7, this.e.getAttack(), "7 Expected");
		}
	}

	@Test
	void testDefense() {
		if (this.e != null) {
			this.e.setDefense(3);
			Assertions.assertEquals(3, this.e.getDefense(), "3 Expected");
		}
	}

	@Test
	void testEnemyAttack() {
		if (this.e != null) {
			this.e.attack(new Player("testPlayer"));
			Assertions.assertEquals(15, this.e.getCurrentHealth(), "15 Expected");
		}
	}
}
