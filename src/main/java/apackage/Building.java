package apackage;

import javax.swing.*;
import java.util.ArrayList;

public class Building extends Map {
	private String id;
	private String desc;

	public Building(String id) {
		this.setID(id);
	}

	public void printBuildingMenu(JTextArea log) {
        // Make a list of buildings we want in map
        buildingList = new ArrayList<String>();
        buildingList.add("Cashion");
        buildingList.add("Penland");
        buildingList.add("Moody");
        buildingList.add("SUB");
        buildingList.add("BSB");
        buildingList.add("SLC");
        buildingList.add("Teal");
        buildingList.add("Foster");
        for (String str : buildingList) {
            log.append(str);
            log.append("\n");
        }
	}

	public String getID() {
		return id;
	}

	public String buildingDesc() {
		switch (id) {
		case "CASH":
			desc = "Cashion is your second home and the main building you will toil your life away coding\n"
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
					+ "all nighters but it won't send you in the emergency room.\n";
			break;
		case "PEN":
			desc = "Within close proximity of Cashion, Penland Dining Hall is a great place to fuel your late\n"
					+ "semester midnight munchies and to blow all your entry swipes within the first few weeks of\n"
					+ "the semester. Burgers, hotdogs, juice and cereal among others will increase your health and\n"
					+ "give you time to complain about your classes with other students.";
			break;
		case "MOOD":
			desc = "Moody library can be a great place to study during the beginning of the semester, but quickly\n"
					+ "evolves into what many students call 'Club Moody' in the mid to later parts of the semester.\n"
					+ "The lower and ground levels are usually the most crowded so head for higher ground to max\n"
					+ "your study ability. NPC encounters are probably the highest here, with students from across\n"
					+ "all majors meeting to 'study' which usually means yelling over each other about anything\n"
					+ "and everything besides what their exam will cover. Entering Moody after dark can either\n"
					+ "help you or hurt you so enter at your own risk, especially when finals and midterms hang\n"
					+ "in the balance. The resources available in addition to the close Starbucks location inside\n"
					+ "still make this an appealing location to boost your study ability. Enemy encounters here \n"
					+ "include Distraction and Time\n";
			break;
		case "SUB":
			desc = "The SUB is an oasis located in Fountain Mall. Here, a weary traveler can purchase wares\n"
					+ "such as Chick-Fil-a nuggies with hunny mussy sauce, energy drinks, coffee, and knock-off\n"
					+ "Chinese food. Though their are no enemy encounters in this building, the road you travel\n"
					+ "to get there is fraught with peril.";
			break;
		case "BSB":
			desc = "The Baylor Science Building, or BSB, is where you will take all of your science (geology)\n"
					+ "classes required for your major. The road to travel to this location is the longest of \n"
					+ "of any you will make including a long stretch of swampland along the way. Do not \n"
					+ "underestimate the enemies you may face here, including Exams, Stress and arduous Labs.\n"
					+ "Boost your stamina and study abilities by visiting the conveniently located Starbucks"
					+ "located on the first floor.\n";
			break;
		case "SLC":
			desc = "The Student Life Center is probably the least likely place you'll encounter another Computer\n"
					+ "Science student even though with as much time as you spend sedentary in a chair in front\n"
					+ "of a computer screen, it is where you should be spending at least a little bit of your\n"
					+ "time outside of class in the gym. If you do go here, you can boost your health drastically\n"
					+ "but will take a large hit in study ability.\n";
			break;
		case "TEAL":
			desc = "Teal is your home. You can go here to sleep, study, and relax. There are no enemies here\n"
					+ "and is a great place to replenish your stats.\n";
			break;
		case "FSTR":
			desc = "Paul L. Foster Campus for Business and Innovation. You will never find a more wretched hive\n"
					+ "of scum and villainy.\n";
			break;
		}
		return desc;
	}

	public String setID(String s) {
		// Set building name based on string param
        if (s != null) {
			switch (s) {
                case "Cashion":
                    id = "CASH";
                    break;
                case "Penland":
                    id = "PEN";
                    break;
                case "Moody":
                    id = "MOOD";
                    break;
                case "SUB":
                    id = "SUB";
                    break;
                case "BSB":
                    id = "BSB";
                    break;
                case "SLC":
                    id = "SLC";
                    break;
                case "Teal":
                    id = "TEAL";
                    break;
                case "Foster":
                    id = "FSTR";
                    break;
                case "Waco Hall":
                    id = "WH";
                    break;
                case "Robinson Tower":
                    id = "RT";
                    break;
                case "Tidwell":
                    id = "TID";
                    break;
			}
		}
		return id;
	}
}
