import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ParsedInfo {
    private static String fileName;

    public ParsedInfo(String fileName) {
        this.fileName = fileName;
    }
// HashMap<Integer, String>
    public HashMap<Integer, String> allPlayers() throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        HashMap<Integer, String> allPlayersMap = new HashMap<>();
        int count=0;
        String name;
        int id=0;
        while (scanner.hasNext()) {
            scanner.useDelimiter("\\p{javaWhitespace}+");
            if (scanner.next().equals("matchCentreData")) {
                scanner.next();
                scanner.useDelimiter("[\\Q\",:\\E]");
                scanner.next();
                scanner.next();
                scanner.next();
                scanner.next();
                while ((true)) {
                    if (scanner.hasNextInt()) id = scanner.nextInt();
                    name = scanner.next();
                    if (name.equals("}")) break;
                    if (!name.isEmpty()) {
                        allPlayersMap.put(id, name);
                    }
                }


            }
        }
        return allPlayersMap;
    }

    public int[] squad() throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        int[] squad = new int[11];
        int id = 0;
        boolean access=false;
        while (scanner.hasNext()) {
            if (scanner.next().equals("matchCentreData")) { scanner.useDelimiter("[\\Q\",:\\E]+");
                access=true; }
            if (scanner.next().equals("Krylya Sovetov Samara") && access) {
                for (int i = 0; i < squad.length; i++) {
                    while (!(scanner.next().equals("playerId"))) {}
                    if (scanner.hasNextInt()) id=scanner.nextInt();
                    while (!scanner.next().equals("isFirstEleven")) {}
                    if (scanner.hasNextBoolean() & scanner.nextBoolean()) squad[i]=id;
                } break;
            }
        }
    return squad;
    }

    public static int parsedShirtNo(int id) throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        int shirtNo=0;
        boolean access=false;
        while (scanner.hasNext()) {
            if (scanner.next().equals("matchCentreData")) {
                scanner.useDelimiter("[\\Q\",:\\E]+");
                access = true;
            }
            if (scanner.next().equals("Krylya Sovetov Samara") && access) {
                while(scanner.hasNext()) {
                    if (scanner.next().equals("playerId") && scanner.nextInt()==id) {
                        while (scanner.hasNext()) {
                            if (scanner.next().equals("shirtNo")) { shirtNo=scanner.nextInt(); break; }
                        } break;
                    }
                } break;
            }
        }
        return shirtNo;
    }

    public static int parsedAge(int id) throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        int age=0;
        boolean access=false;
        while (scanner.hasNext()) {
            if (scanner.next().equals("matchCentreData")) {
                scanner.useDelimiter("[\\Q\",:\\E]+");
                access = true;
            }
            if (scanner.next().equals("Krylya Sovetov Samara") && access) {
                while(scanner.hasNext()) {
                    if (scanner.next().equals("playerId") && scanner.nextInt()==id) {
                        while (scanner.hasNext()) {
                            if (scanner.next().equals("age")) {
                                age=scanner.nextInt();
                                break;
                            }
                        } break;
                    }
                } break;
            }
        }
        return age;
    }

    public static int parsedHeight(int id) throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        int height=0;
        boolean access=false;
        while (scanner.hasNext()) {
            if (scanner.next().equals("matchCentreData")) {
                scanner.useDelimiter("[\\Q\",:\\E]+");
                access = true;
            }
            if (scanner.next().equals("Krylya Sovetov Samara") && access) {
                while(scanner.hasNext()) {
                    if (scanner.next().equals("playerId") && scanner.nextInt()==id) {
                        while (scanner.hasNext()) {
                            if (scanner.next().equals("height")) { height=scanner.nextInt(); break; }
                        } break;
                    }
                } break;
            }
        }
        return height;
    }

    public static int parsedWeight(int id) throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        int weight=0;
        boolean access=false;
        while (scanner.hasNext()) {
            if (scanner.next().equals("matchCentreData")) {
                scanner.useDelimiter("[\\Q\",:\\E]+");
                access = true;
            }
            if (scanner.next().equals("Krylya Sovetov Samara") && access) {
                while(scanner.hasNext()) {
                    if (scanner.next().equals("playerId") && scanner.nextInt()==id) {
                        while (scanner.hasNext()) {
                            if (scanner.next().equals("weight")) { weight=scanner.nextInt(); break; }
                        } break;
                    }
                } break;
            }
        }
        return weight;
    }

    public static String parsedPosition(int id) throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        String position=null;
        boolean access=false;
        while (scanner.hasNext()) {
            if (scanner.next().equals("matchCentreData")) {
                scanner.useDelimiter("[\\Q\",:\\E]+");
                access = true;
            }
            if (scanner.next().equals("Krylya Sovetov Samara") && access) {
                while(scanner.hasNext()) {
                    if (scanner.next().equals("playerId") && scanner.nextInt()==id) {
                        while (scanner.hasNext()) {
                            if (scanner.next().equals("position")) { position=scanner.next(); break; }
                        } break;
                    }
                } break;
            }
        }
        return position;
    }

    public static double parsedRatings(int id) throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        double rating=0;
        boolean access=false;
        while (scanner.hasNext()) {
            if (scanner.next().equals("matchCentreData")) {
                scanner.useDelimiter("[\\Q\",:\\E]+");
                access = true;
            }
            if (scanner.next().equals("Krylya Sovetov Samara") && access) {
                while(scanner.hasNext()) {
                    if (scanner.next().equals("playerId") && scanner.nextInt()==id) {
                        while (scanner.hasNext()) {
                            String string = scanner.next();
                            if (string.equals("playerId") || string.equals("managerName")) { break; }
                            if (string.equals("ratings")) {
                                scanner.next();
                                scanner.useDelimiter("[\\Q{}\\E]+");
                                String str = scanner.next();
                                try {
                                    String lastRaiting = str.substring(str.length()-4);
                                    rating=Double.parseDouble(lastRaiting);
                                } catch (NumberFormatException e) {
                                    String lastRaiting = str.substring(str.length()-3);
                                    rating=Double.parseDouble(lastRaiting);
                                }
                            }
                        }
                    }
                }
            }
        }
        return rating;
    }


    public static double parsedPassesTotal (int id) throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        String position=null;
        boolean access=false;
        double passesTotal=0;
        while (scanner.hasNext()) {
            if (scanner.next().equals("matchCentreData")) {
                scanner.useDelimiter("[\\Q\",:\\E]+");
                access = true;
            }
            if (scanner.next().equals("Krylya Sovetov Samara") && access) {
                while(scanner.hasNext()) {
                    if (scanner.next().equals("playerId") && scanner.nextInt()==id) {
                        while (scanner.hasNext()) {
                            String string = scanner.next();
                            if (string.equals("playerId") || string.equals("managerName")) { break; }
                            if (string.equals("passesTotal")) {
                                scanner.next();
//                                scanner.next();
                                scanner.useDelimiter("[\\Q\",:\\E]+");

                                while (true) {
                                    String str = scanner.next();
                                    if (str.contains("}")) {
                                        passesTotal+=Double.parseDouble(str.substring(0, str.length()-1));
                                        break; }
                                    if (str.contains(".")) {
                                        passesTotal+=Double.parseDouble(str);
                                    }
                                }
                                break;
                            }
                        } break;
                    }
                } break;
            }
        }
        return passesTotal;
    }

    public static double parsedPassesAccurate (int id) throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        String position=null;
        boolean access=false;
        double passesTotal=0;
        while (scanner.hasNext()) {
            if (scanner.next().equals("matchCentreData")) {
                scanner.useDelimiter("[\\Q\",:\\E]+");
                access = true;
            }
            if (scanner.next().equals("Krylya Sovetov Samara") && access) {
                while(scanner.hasNext()) {
                    if (scanner.next().equals("playerId") && scanner.nextInt()==id) {
                        while (scanner.hasNext()) {
                            String string = scanner.next();
                            if (string.equals("playerId") || string.equals("managerName")) { break; }
                            if (string.equals("passesAccurate")) {
                                scanner.next();
//                                scanner.next();
                                scanner.useDelimiter("[\\Q\",:\\E]+");

                                while (true) {
                                    String str = scanner.next();
                                    if (str.contains("}")) {
                                        passesTotal+=Double.parseDouble(str.substring(0, str.length()-1));
                                        break; }
                                    if (str.contains(".")) {
                                        passesTotal+=Double.parseDouble(str);
                                    }
                                }
                                break;
                            }
                        } break;
                    }
                } break;
            }
        }
        return passesTotal;
    }

    public static double parsedPassesKey (int id) throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        String position=null;
        boolean access=false;
        double passesTotal=0;
        while (scanner.hasNext()) {
            if (scanner.next().equals("matchCentreData")) {
                scanner.useDelimiter("[\\Q\",:\\E]+");
                access = true;
            }
            if (scanner.next().equals("Krylya Sovetov Samara") && access) {
                while(scanner.hasNext()) {
                    if (scanner.next().equals("playerId") && scanner.nextInt()==id) {
                        while (scanner.hasNext()) {
                            String string = scanner.next();
                            if (string.equals("playerId") || string.equals("managerName")) { break; }
                            if (string.equals("passesKey")) {
                                scanner.next();
//                                scanner.next();
                                scanner.useDelimiter("[\\Q\",:\\E]+");

                                while (true) {
                                    String str = scanner.next();
                                    if (str.contains("}")) {
                                        passesTotal+=Double.parseDouble(str.substring(0, str.length()-1));
                                        break; }
                                    if (str.contains(".")) {
                                        passesTotal+=Double.parseDouble(str);
                                    }
                                }
                                break;
                            }
                        } break;
                    }
                } break;
            }
        }
        return passesTotal;
    }

}
