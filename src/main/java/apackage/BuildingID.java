package apackage;

public enum BuildingID {
	CASH(0), PEN(1), MOOD(2), SUB(3), BSB(4), SLC(5), TEAL(6), FSTR(7), WH(8), RT(9), TID(10);

	private int name;

	BuildingID(int name) {
		this.name = name;
	}

	public int getBuildingID() {
		return name;
	}

	public void setName(String s) {
		switch (s) {
		case "Cashion":
			name = 0;
			break;
		case "Penland":
			name = 1;
			break;
		case "Moody":
			name = 2;
			break;
		case "SUB":
			name = 3;
			break;
		case "BSB":
			name = 4;
			break;
		case "SLC":
			name = 5;
			break;
		case "Teal":
			name = 6;
			break;
		case "Foster":
			name = 7;
			break;
		case "Waco Hall":
			name = 8;
			break;
		case "Robinson Tower":
			name = 9;
			break;
		case "Tidwell":
			name = 10;
			break;
		}
	}
}
