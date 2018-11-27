package apackage.junit;

import apackage.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class RoomTester {
	protected Room room = null;

	@BeforeEach
	void init() {
		this.room = new Room();
	}

	@Test
	void testName() {
		if (this.room != null) {
			this.room.setName("Computer Lab");
			Assertions.assertEquals("Computer Lab", this.room.getName(), "Computer Lab Expected");
		}
	}
}
