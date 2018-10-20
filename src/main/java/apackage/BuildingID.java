package apackage;

public enum BuildingID {
    CASH(0),
    PEN(1),
    MOOD(2),
    SUB(3),
    BSB(4),
    SLC(5),
    TEAL(6),
    FSTR(7);


    private int name;

    BuildingID(int name) {
        this.name = name;
    }

    public int getBuildingID() {
        return name;
    }
}
