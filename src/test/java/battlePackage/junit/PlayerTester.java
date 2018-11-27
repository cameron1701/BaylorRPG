package battlePackage.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import battlePackage.Enemy;
import battlePackage.Player;

public class PlayerTester {
	protected Player p = null;

	@BeforeEach
	void init() {
		this.p = new Player("testPlayer");
	}

	@Test
	void testInitPlayer() {
		if (this.p != null) {
			this.p.initPlayer("newName");
			Assertions.assertEquals("newName", this.p.getName(), "newName Expected");
		}
	}

	@Test
	void testAttackNamesList() {
		if (this.p != null) {
			Assertions.assertEquals(6, this.p.getAttackNamesSize(), "6 Expected");
		}
	}

	@Test
	void testRandomAttack() {
		if (this.p != null) {
			Assertions.assertEquals("pulled an all-nighter!", this.p.getRandAttack(1),
					"pulled an all-nighter! Expected");
		}
	}
	
	@Test
	void testCurrentHealth() {
		if(this.p != null) {
			this.p.setCurrentHealth(6);
			Assertions.assertEquals(14, this.p.getCurrentHealth(), "14 Expected");
		}
	}

	@Test
	void testName() {
		if (this.p != null) {
			this.p.setName("name");
			Assertions.assertEquals("name", this.p.getName(), "name Expected");
		}
	}
	
	@Test
	void testTotalHealth() {
		if (this.p != null) {
			this.p.setTotalHealth(11);
			Assertions.assertEquals(11, this.p.getTotalHealth(), "11 Expected");
		}
	}

	@Test
	void testAttack() {
		if (this.p != null) {
			this.p.setAttack(45);
			Assertions.assertEquals(45, this.p.getAttack(), "45 Expected");
		}
	}
	
	@Test
	void testDefense() {
		if (this.p != null) {
			this.p.setDefense(8);
			Assertions.assertEquals(8, this.p.getDefense(), "8 Expected");
		}
	}
	
	@Test
	void testPlayerAttack() {
		if (this.p != null) {
			Enemy e = new Enemy("enemy", 12, 6, 4);
			this.p.attack(e);
			Assertions.assertEquals(6, e.getCurrentHealth(), "6 Expected");
		}
	}

}
