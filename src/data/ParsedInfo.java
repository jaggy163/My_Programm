package data;

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

    public static double parsedShotsTotal (int id) throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        String position=null;
        boolean access=false;
        double shotsTotal=0;
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
                            if (string.equals("shotsTotal")) {
                                scanner.next();
//                                scanner.next();
                                scanner.useDelimiter("[\\Q\",:\\E]+");

                                while (true) {
                                    String str = scanner.next();
                                    if (str.contains("}")) {
                                        shotsTotal+=Double.parseDouble(str.substring(0, str.length()-1));
                                        break; }
                                    if (str.contains(".")) {
                                        shotsTotal+=Double.parseDouble(str);
                                    }
                                }
                                break;
                            }
                        } break;
                    }
                } break;
            }
        }
        return shotsTotal;
    }

    public static double parsedShotsOnTarget (int id) throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        String position=null;
        boolean access=false;
        double shotsOnTarget=0;
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
                            if (string.equals("shotsOnTarget")) {
                                scanner.next();
//                                scanner.next();
                                scanner.useDelimiter("[\\Q\",:\\E]+");

                                while (true) {
                                    String str = scanner.next();
                                    if (str.contains("}")) {
                                        shotsOnTarget+=Double.parseDouble(str.substring(0, str.length()-1));
                                        break; }
                                    if (str.contains(".")) {
                                        shotsOnTarget+=Double.parseDouble(str);
                                    }
                                }
                                break;
                            }
                        } break;
                    }
                } break;
            }
        }
        return shotsOnTarget;
    }

    public static double parsedShotsOffTarget (int id) throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        String position=null;
        boolean access=false;
        double shotsOffTarget=0;
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
                            if (string.equals("shotsOffTarget")) {
                                scanner.next();
//                                scanner.next();
                                scanner.useDelimiter("[\\Q\",:\\E]+");

                                while (true) {
                                    String str = scanner.next();
                                    if (str.contains("}")) {
                                        shotsOffTarget+=Double.parseDouble(str.substring(0, str.length()-1));
                                        break; }
                                    if (str.contains(".")) {
                                        shotsOffTarget+=Double.parseDouble(str);
                                    }
                                }
                                break;
                            }
                        } break;
                    }
                } break;
            }
        }
        return shotsOffTarget;
    }

    public static double parsedClearances (int id) throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        String position=null;
        boolean access=false;
        double clearances=0;
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
                            if (string.equals("clearances")) {
                                scanner.next();
//                                scanner.next();
                                scanner.useDelimiter("[\\Q\",:\\E]+");

                                while (true) {
                                    String str = scanner.next();
                                    if (str.contains("}")) {
                                        clearances+=Double.parseDouble(str.substring(0, str.length()-1));
                                        break; }
                                    if (str.contains(".")) {
                                        clearances+=Double.parseDouble(str);
                                    }
                                }
                                break;
                            }
                        } break;
                    }
                } break;
            }
        }
        return clearances;
    }

    public static double parsedInterseptions (int id) throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        String position=null;
        boolean access=false;
        double interseptions=0;
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
                            if (string.equals("interseptions")) {
                                scanner.next();
//                                scanner.next();
                                scanner.useDelimiter("[\\Q\",:\\E]+");

                                while (true) {
                                    String str = scanner.next();
                                    if (str.contains("}")) {
                                        interseptions+=Double.parseDouble(str.substring(0, str.length()-1));
                                        break; }
                                    if (str.contains(".")) {
                                        interseptions+=Double.parseDouble(str);
                                    }
                                }
                                break;
                            }
                        } break;
                    }
                } break;
            }
        }
        return interseptions;
    }

    public static double parsedArialsTotal (int id) throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        String position=null;
        boolean access=false;
        double arialsTotal=0;
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
                            if (string.equals("arialsTotal")) {
                                scanner.next();
//                                scanner.next();
                                scanner.useDelimiter("[\\Q\",:\\E]+");

                                while (true) {
                                    String str = scanner.next();
                                    if (str.contains("}")) {
                                        arialsTotal+=Double.parseDouble(str.substring(0, str.length()-1));
                                        break; }
                                    if (str.contains(".")) {
                                        arialsTotal+=Double.parseDouble(str);
                                    }
                                }
                                break;
                            }
                        } break;
                    }
                } break;
            }
        }
        return arialsTotal;
    }

    public static double parsedArialsWon (int id) throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        String position=null;
        boolean access=false;
        double arialsWon=0;
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
                            if (string.equals("arialsWon")) {
                                scanner.next();
//                                scanner.next();
                                scanner.useDelimiter("[\\Q\",:\\E]+");

                                while (true) {
                                    String str = scanner.next();
                                    if (str.contains("}")) {
                                        arialsWon+=Double.parseDouble(str.substring(0, str.length()-1));
                                        break; }
                                    if (str.contains(".")) {
                                        arialsWon+=Double.parseDouble(str);
                                    }
                                }
                                break;
                            }
                        } break;
                    }
                } break;
            }
        }
        return arialsWon;
    }

    public static double parsedTacklesTotal (int id) throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        String position=null;
        boolean access=false;
        double tacklesTotal=0;
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
                            if (string.equals("tacklesTotal")) {
                                scanner.next();
//                                scanner.next();
                                scanner.useDelimiter("[\\Q\",:\\E]+");

                                while (true) {
                                    String str = scanner.next();
                                    if (str.contains("}")) {
                                        tacklesTotal+=Double.parseDouble(str.substring(0, str.length()-1));
                                        break; }
                                    if (str.contains(".")) {
                                        tacklesTotal+=Double.parseDouble(str);
                                    }
                                }
                                break;
                            }
                        } break;
                    }
                } break;
            }
        }
        return tacklesTotal;
    }

    public static double parsedTacklesSuccessful (int id) throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        String position=null;
        boolean access=false;
        double tacklesSuccessful=0;
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
                            if (string.equals("tacklesSuccessful")) {
                                scanner.next();
//                                scanner.next();
                                scanner.useDelimiter("[\\Q\",:\\E]+");

                                while (true) {
                                    String str = scanner.next();
                                    if (str.contains("}")) {
                                        tacklesSuccessful+=Double.parseDouble(str.substring(0, str.length()-1));
                                        break; }
                                    if (str.contains(".")) {
                                        tacklesSuccessful+=Double.parseDouble(str);
                                    }
                                }
                                break;
                            }
                        } break;
                    }
                } break;
            }
        }
        return tacklesSuccessful;
    }

    public static double parsedDribblesTotal (int id) throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        String position=null;
        boolean access=false;
        double dribblesTotal=0;
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
                            if (string.equals("dribblesAttempted")) {
                                scanner.next();
//                                scanner.next();
                                scanner.useDelimiter("[\\Q\",:\\E]+");

                                while (true) {
                                    String str = scanner.next();
                                    if (str.contains("}")) {
                                        dribblesTotal+=Double.parseDouble(str.substring(0, str.length()-1));
                                        break; }
                                    if (str.contains(".")) {
                                        dribblesTotal+=Double.parseDouble(str);
                                    }
                                }
                                break;
                            }
                        } break;
                    }
                } break;
            }
        }
        return dribblesTotal;
    }

    public static double parsedDribblesLost(int id) throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        String position=null;
        boolean access=false;
        double dribblesLost=0;
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
                            if (string.equals("dribblesLost")) {
                                scanner.next();
//                                scanner.next();
                                scanner.useDelimiter("[\\Q\",:\\E]+");

                                while (true) {
                                    String str = scanner.next();
                                    if (str.contains("}")) {
                                        int tmp = str.indexOf("}");
                                        dribblesLost+=Double.parseDouble(str.substring(0, tmp));
                                        break; }
                                    if (str.contains(".")) {
                                        dribblesLost+=Double.parseDouble(str);
                                    }
                                }
                                break;
                            }
                        } break;
                    }
                } break;
            }
        }
        return dribblesLost;
    }

}
