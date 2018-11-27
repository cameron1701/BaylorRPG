package battlePackage.junit;

import java.io.IOException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import battlePackage.BattleGraphics;

public class BattleGraphicsTester {
	/*protected BattleGraphics bGraph = null;

	@ParameterizedTest
	@ValueSource(strings = { "win", "lose", "retreat" })
	@BeforeEach
	void init(String str) throws IOException {
		this.bGraph = new BattleGraphics(str);
	}

	@Test
	void testNullFile(){
		Assertions.assertThrows(IOException.class, () -> {
			new BattleGraphics(null);
		}, "IOException is Expected");
	}
	
	@Test
	void testInvalidFile(){
		Assertions.assertThrows(IOException.class, () -> {
			new BattleGraphics("invalid");
		}, "IOException is Expected");
	}

	@Test
	void testPaintComponent() {
		if (this.bGraph != null) {
			Assertions.assertNotNull(this.bGraph.getGraphics(), "Graphics should not be null");
		}
	}
	
	@AfterEach
	void tearDown() {
		if(this.bGraph != null) {
			this.bGraph.invalidate();
			this.bGraph = null;
			Assertions.assertNull(this.bGraph, "Null Expected");
		}
	}*/
}
