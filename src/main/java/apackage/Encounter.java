package apackage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Encounter {
	private static Logger logger = Logger.getLogger("Error Logger");

    public static int generateRandomInt(int upperRange) {
        Random random = new Random();
        return random.nextInt(upperRange);
    }

    public static String randomEncounter(String buildingID) throws IOException {
        int rand = generateRandomInt(10);
        String result = "";
        BufferedReader bufferedReader = null;
        
        if (rand != 0) {
            
            switch (buildingID) {
                case "BSB":
                    try {
                        String strCurrentLine = null;
                        bufferedReader = new BufferedReader(new FileReader("BSB Encounters.txt"));
                        while ((strCurrentLine = bufferedReader.readLine()) != null) {
                            if (strCurrentLine.startsWith(String.valueOf(rand))) {
                                if (!strCurrentLine.endsWith("\n")) {
                                    result = strCurrentLine.substring(2, strCurrentLine.length() - 3);
                                    break;
                                }
                            }
                        }
                    } catch (FileNotFoundException e) {
                        logger.log(Level.SEVERE, "File Not Found!");
                    } catch (IOException e) {
                    	logger.log(Level.SEVERE, "File Not Found!");
                    }
                    break;

                case "CASH":
                    try {
                        String strCurrentLine = null;
                        bufferedReader = new BufferedReader(new FileReader("Cashion Encounters.txt"));
                        while ((strCurrentLine = bufferedReader.readLine()) != null) {
                            if (strCurrentLine.startsWith(String.valueOf(rand))) {
                                if (!strCurrentLine.endsWith("\n")) {
                                    result = strCurrentLine.substring(2, strCurrentLine.length() - 3);
                                    break;
                                }
                            }
                        }
                    } catch (FileNotFoundException e) {
                        logger.log(Level.SEVERE, "File Not Found!");;
                    } catch (IOException e) {
                        logger.log(Level.SEVERE, "File Not Found!");;
                    }
                    break;

                case "PEN":
                    try {
                        String strCurrentLine = null;
                        bufferedReader = new BufferedReader(new FileReader("Penland Encounters.txt"));
                        while ((strCurrentLine = bufferedReader.readLine()) != null) {
                            if (strCurrentLine.startsWith(String.valueOf(rand))) {
                                if (!strCurrentLine.endsWith("\n")) {
                                    result = strCurrentLine.substring(2, strCurrentLine.length() - 3);
                                    break;
                                }
                            }
                        }
                    } catch (FileNotFoundException e) {
                        logger.log(Level.SEVERE, "File Not Found!");;
                    } catch (IOException e) {
                        logger.log(Level.SEVERE, "File Not Found!");;
                    }
                    break;

                case "MOOD":
                    try {
                        String strCurrentLine = null;
                        bufferedReader = new BufferedReader(new FileReader("Moody Encounters.txt"));
                        while ((strCurrentLine = bufferedReader.readLine()) != null) {
                            if (strCurrentLine.startsWith(String.valueOf(rand))) {
                                if (!strCurrentLine.endsWith("\n")) {
                                    result = strCurrentLine.substring(2, strCurrentLine.length() - 3);
                                    break;
                                }
                            }
                        }
                    } catch (FileNotFoundException e) {
                        logger.log(Level.SEVERE, "File Not Found!");;
                    } catch (IOException e) {
                        logger.log(Level.SEVERE, "File Not Found!");;
                    }
                    break;

                case "SUB":
                    try {
                        String strCurrentLine = null;
                        bufferedReader = new BufferedReader(new FileReader("SUB Encounters.txt"));
                        while ((strCurrentLine = bufferedReader.readLine()) != null) {
                            if (strCurrentLine.startsWith(String.valueOf(rand))) {
                                if (!strCurrentLine.endsWith("\n")) {
                                    result = strCurrentLine.substring(2, strCurrentLine.length() - 3);
                                    break;
                                }
                            }
                        }
                    } catch (FileNotFoundException e) {
                        logger.log(Level.SEVERE, "File Not Found!");;
                    } catch (IOException e) {
                        logger.log(Level.SEVERE, "File Not Found!");;
                    }
                    break;

                case "FSTR":
                    try {
                        String strCurrentLine = null;
                        bufferedReader = new BufferedReader(new FileReader("Foster Encounters.txt"));
                        while ((strCurrentLine = bufferedReader.readLine()) != null) {
                            if (strCurrentLine.startsWith(String.valueOf(rand))) {
                                if (!strCurrentLine.endsWith("\n")) {
                                    result = strCurrentLine.substring(2, strCurrentLine.length() - 3);
                                    break;
                                }
                            }
                        }
                    } catch (FileNotFoundException e) {
                        logger.log(Level.SEVERE, "File Not Found!");;
                    } catch (IOException e) {
                        logger.log(Level.SEVERE, "File Not Found!");;
                    }
                     
                    break;
            }
        }
        
        if(bufferedReader != null) {
        	bufferedReader.close();
        }
        
        return result;
    }
    
	public boolean isValid(String input) {
		boolean flag = false;
		
		if(input.equals("Cashion") || input.equals("Penland") || input.equals("Moody") || input.equals("SUB")
			|| input.equals("BSB") || input.equals("SLC") || input.equals("Teal") || input.equals("Foster")
			|| input.equals("Waco Hall") || input.equals("Robinson Tower") || input.equals("Tidwell")) {
			flag = true;
		}
		
		return flag;
	}
}
