package apackage.junit;

import apackage.Building;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class BuildingTester {
	protected Building building = null;

	@BeforeEach
	void init() {
		this.building = new Building("Cashion");
	}

	@Test
	void testNullTextArea() {
		if (this.building != null) {
			Assertions.assertThrows(NullPointerException.class, () -> {
				this.building.printBuildingMenu(null);
			}, "NullPointerException is Expected");
		}
	}
	
	@Test
	void testPrintBuildingMenu() {
		if (this.building != null) {
			JTextArea testLog = new JTextArea();
			this.building.printBuildingMenu(testLog);
			Assertions.assertTrue(testLog.getText().contains("Foster\n"), "True Expected"); 
		}
	}
	
	@Test
	void testID() {
		if (this.building != null) {
			Assertions.assertEquals("CASH", this.building.getID(), "CASH Expected");
		}
	}

	@Test
	void testSetInvalidID() {
		if (this.building != null) {
			this.building.setID("Chapel");
			Assertions.assertEquals("CASH", this.building.getID(), "CASH Expected");
		}
	}

	@Test
	void testSetNullID() {
		if (this.building != null) {
			this.building.setID(null);
			Assertions.assertEquals("CASH", this.building.getID(), "CASH Expected");
		}
	}

	@Test
	void testGetBuildingDescr() {
		if (this.building != null) {
			Assertions.assertEquals(
					"Cashion is your second home and the main building you will toil your life away coding\n"
							+ "programs and stressing out with your fellow masochists...errr...classmates.\n"
							+ "Beware traveler, for enemies you encounter here will be far more difficult than any\n"
							+ "you will likely encounter anywhere else on campus. They can come in the form of challenging\n"
							+ "programming assignments, difficult exams in which you studied hard for but none of\n"
							+ "the material you crammed into your brain ends up on the test, time, and stress.\n"
							+ "The rulers of this land are know as the Professional Renowned Order of Fear, or as\n"
							+ "they are commonly known, the 'PROFs'. An ancient order, they are the creators of the\n"
							+ "many enemies you will face, but have also been know to show mercy upon their underling\n"
							+ "student undergrads by pushing assignments and even exams back by as much as two days.\n"
							+ "While sometimes merciful though, do not count on such luck to be the norm. Sharpen your\n"
							+ "mind, study hard, forget sleep, and drink juuusst enough coffee that you can stay up for\n"
							+ "all nighters but it won't send you in the emergency room.\n",
					this.building.buildingDesc(), "Cashion Building Description Expected");
		}
	}

}
