package apackage;

import javax.swing.*;
import java.util.List;

public class Map {
    protected static List<String> buildingList = null;
    private List<String> roomList = null;
    protected JTextArea log;
    protected JTextField input;
    private Building b;
    private ObjectHandler handler;

    public Map() {

    }

    protected void printMenu() {
        String temp = new String();
        char selection;
        temp = "+----------------------------------+\n" +
                "        Select a building          ";

        log.append(temp);
    }


}
