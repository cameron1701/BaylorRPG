package apackage.junit;

import apackage.TextArea;
import battlePackage.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;

public class TextAreaTester {
	protected TextArea area = null;

	@BeforeEach
	void init() {
		this.area = new TextArea(new Player("player1"));
	}

	@Test
	void testTextAreaValid() {
		Assertions.assertTrue(this.area.isValid(), "True Expected");
	}

	@Test
	void testTextAreaEnabled() {
		if (this.area != null) {
			Assertions.assertTrue(this.area.isEnabled(), "True Expected");
		}
	}

	@Test
	void testTextAreaVisible() {
		if (this.area != null) {
			Assertions.assertTrue(this.area.isVisible(), "True Expected");
		}
	}

	@Test
	void testTextAreaComponentCount() {
		if (this.area != null) {
			Assertions.assertEquals(2, this.area.getComponentCount(), "Two Components Expected");
		}
	}

	@Test
	void testCreateMenuAction() {
		if (this.area != null) {
			ActionEvent event = new ActionEvent(this.area, 1, "MENU");
			this.area.actionPerformed(event);
			//Assertions.assertEquals("MENU", event.getActionCommand(), "MENU Expected");
		}
	}
	
	@Test
	void testCreateBattleAction() {
		if(this.area != null) {
			ActionEvent event = new ActionEvent(this.area, 1, "Battle");
			this.area.new ButtonListener().actionPerformed(event);
			Assertions.assertEquals("ENTER", event.getActionCommand(), "");
		}
	}

	@Test
	void testFrameCreation() {
		if (this.area != null) {
			Assertions.assertNotNull(this.area.getRootPane(), "Not Null Expected");
		}
	}

	@Test
	void testFrameValid() {
		if (this.area != null) {
			Assertions.assertTrue(this.area.getRootPane().isValid(), "True Expected");
		}
	}

	@Test
	void testFrameVisible() {
		if (this.area != null) {
			Assertions.assertTrue(this.area.getRootPane().isVisible(), "True Expected");
		}
	}

	@Test
	void testFrameEnabled() {
		if (this.area != null) {
			Assertions.assertTrue(this.area.getRootPane().isEnabled(), "True Expected");
		}
	}

	@AfterEach
	void tearDown() {
		this.area.invalidate();
		this.area = null;
	}
}
