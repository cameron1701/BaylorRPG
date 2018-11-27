package apackage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Encounter {

    public static int generateRandomInt(int upperRange) {
        Random random = new Random();
        return random.nextInt(upperRange);
    }

    public static String randomEncounter(String buildingID) {
        int rand = generateRandomInt(10);
        String result = "";
        if (rand != 0) {
            BufferedReader bufferedReader = null;
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
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
        }
        return result;
    }
}
