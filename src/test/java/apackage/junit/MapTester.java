package apackage.junit;

import org.junit.jupiter.api.BeforeEach;
import apackage.Map;

public class MapTester {
	protected Map map = null;


	@BeforeEach
	void init() {
		this.map = new Map();
	}
	
}
