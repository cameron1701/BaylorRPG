package apackage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Map {
    private static List<String> buildingList = null;
    private List<String> roomList = null;
    private JTextArea log;

    public Map() {
        makeBuildingList();
    }

    public static void makeBuildingList() {
        buildingList = new ArrayList<String>();
        buildingList.add("Cashion");
        buildingList.add("Penland");
        buildingList.add("Moody Library");
        buildingList.add("The SUB");
        buildingList.add("BSB");
        buildingList.add("Waco Hall");
        buildingList.add("Robinson Tower");
        buildingList.add("Teal");
        buildingList.add("Foster");
        buildingList.add("Tidwell");
    }
}
