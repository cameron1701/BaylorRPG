package apackage.junit;

import javax.swing.JTextArea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import apackage.Building;
import apackage.Map;

public class MapTester {
	protected Map map = null;


	@BeforeEach
	void init() {
		this.map = new Map();
	}
	
	@Test
	void testInitializedBuildingList() {
		if(this.map != null) {
			Building b = new Building("Moody");
			b.printBuildingMenu(new JTextArea());
			Assertions.assertEquals(8, this.map.getBuildingList().size(), "8 Expected");
		}
	}

	
}
