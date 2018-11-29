package apackage.junit;

import apackage.TextArea;
import battlePackage.EnemyList;
import battlePackage.Player;
import java.awt.Component;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TextAreaTester{
	protected TextArea area = null;
	
	@BeforeEach
	void init() {
		this.area = new TextArea(new Player("testP"), new EnemyList());
	}
	
	@Test
	void testTextAreaEnabled() {
		if(this.area != null) {
			Assertions.assertTrue(this.area.isEnabled(), "TextArea should be Enabled");
		}
	}
	
	@Test
	void testTextAreaVisible() {
		if(this.area != null) {
			Assertions.assertTrue(this.area.isVisible(), "TextArea should be Visible");
		}
	}
	
	@Test
	void testTextAreaComponentCount() {
		if(this.area != null) {
			Assertions.assertEquals(2, this.area.getComponentCount(), "TextArea should have 2 Components");
		}
	}
	
	@Test
	void testComponentCreation() {
		if (this.area != null) {
			for(Component c : this.area.getComponents()) {
				Assertions.assertNotNull(c, "Component should not be null");
			}
		}
	}

	@AfterEach
	void tearDown() {
		this.area.invalidate();
		this.area = null;
		Assertions.assertNull(this.area, "TextArea should be null");
	}
}

