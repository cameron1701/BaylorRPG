package battlePackage.junit;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import battlePackage.BattleSpace;
import battlePackage.Enemy;
import battlePackage.Player;

public class BattleSpaceTester {
	protected BattleSpace space = null;
	protected Player player = null;
	protected List<Enemy> enemies = null;
	
	@BeforeEach
	void init() {
		this.enemies = new ArrayList<Enemy>();
		this.enemies.add(new Enemy("Homework 1", 10, 2, 1));
		this.enemies.add(new Enemy("Quiz", 5, 1, 0));
		this.enemies.add(new Enemy("Practicum", 7, 4, 1));
		this.player = new Player("player1");
		this.space = new BattleSpace(this.player, this.enemies);
	}
	
	@Test
	void testBattleSpaceEnabled() {
		if(this.space != null) {
			Assertions.assertTrue(this.space.isEnabled(), "BattleSpace should be Enabled");
		}
	}
	
	@Test
	void testBattleSpaceVisible() {
		if(this.space != null) {
			Assertions.assertTrue(this.space.isVisible(), "BattleSpace should be Visible");
		}
	}
	
	@Test
	void testBattleSpaceComponentCount() {
		if(this.space != null) {
			Assertions.assertEquals(2, this.space.getComponentCount(), "BattleSpace should have 2 Components");
		}
	}
	
	@Test
	void testFrameCreation() {
		if (this.space != null) {
			Assertions.assertNotNull(this.space.getRootPane(), "Frame should not be null");
		}
	}
	
	@Test
	void testFrameValid() {
		if (this.space != null) {
			Assertions.assertTrue(this.space.getRootPane().isValid(), "Frame should be Valid");
		}
	}

	@Test
	void testFrameVisible() {
		if (this.space != null) {
			Assertions.assertTrue(this.space.getRootPane().isVisible(), "Frame should be Visible");
		}
	}

	@Test
	void testFrameEnabled() {
		if (this.space != null) {
			Assertions.assertTrue(this.space.getRootPane().isEnabled(), "Frame should be Enabled");
		}
	}
	
	@Test
	void testComponentCreation() {
		if (this.space != null) {
			for(Component c : this.space.getComponents()) {
				Assertions.assertNotNull(c, "Component should not be null");
			}
		}
	}
	
	@Test
	void testNotEndOfBattle() {
		if (this.space != null) {
			Assertions.assertFalse(this.space.endOfBattle(), "Should not be End of Battle");
		}
	}
	
	@Test
	void testEndOfBattle() {
		if (this.space != null) {
			for(Enemy e : this.enemies) {
				e.setCurrentHealth(e.getCurrentHealth());
			}
			Assertions.assertTrue(this.space.endOfBattle(), "Should be End of Battle");
		}
	}

	@AfterEach
	void tearDown() {
		this.space.invalidate();
		this.space = null;
		Assertions.assertNull(this.space, "BattleSpace should be null");
	}
	
}
