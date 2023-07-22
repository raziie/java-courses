package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchClass {
    public static void searchAndEnterByName(Scanner scanner) {
        if(Main.currentClass != null) {
            System.out.println("please get out of previous class first");
        }else if(Main.currentUser == null) {
            System.out.println("please log in first");
        }else {
            System.out.println("search:");
            String input = scanner.nextLine();
            ArrayList<String> names = new ArrayList<>();
            for (Classroom aClass : Main.classes) {
                if (aClass.getName().contains(input)) {
                    names.add(aClass.getName());
                }
            }
            if (names.isEmpty()) {
                System.out.println("there is no class with this name!");
            } else {
                for (int i = 0; i < names.size(); i++) {
                    System.out.println((i + 1) + "_" + names.get(i));
                }
                String name = names.get(scanner.nextInt() - 1);
                scanner.nextLine();
                int classIndex = 0;
                for (int i = 0; i < Main.classes.size(); i++) {
                    if (Main.classes.get(i).getName().equals(name)) {
                        classIndex = i;
                        break;
                    }
                }
                if(Main.classes.get(classIndex).isPrivate()) {
                    Classroom.requestPassword(scanner,Main.classes.get(classIndex));
                }
                Main.currentClass = Main.classes.get(classIndex);
                System.out.println("entered the class successfully");
                System.out.println(Main.currentClass);
                Classroom.register();
            }
        }
    }

    public static void searchAndEnterByInstitution(Scanner scanner) {
        if(Main.currentClass != null) {
            System.out.println("please get out of previous class first");
        }else if(Main.currentUser == null) {
            System.out.println("please log in first");
        }else {
            System.out.println("search:");
            String input = scanner.nextLine();
            ArrayList<String> institutions = new ArrayList<>();
            for (Classroom aClass : Main.classes) {
                if (aClass.getEducationalInstitution().contains(input)) {
                    institutions.add(aClass.getEducationalInstitution());
                }
            }
            if (institutions.isEmpty()) {
                System.out.println("there is no class with this educational institution!");
            } else {
                for (int i = 0; i < institutions.size(); i++) {
                    System.out.println((i + 1) + "_" + institutions.get(i));
                }
                int theClass = scanner.nextInt();
                String institution = institutions.get(theClass - 1);
                int classIndex = 0;
                for (int i = 0; i < Main.classes.size(); i++) {
                    if (Main.classes.get(i).getEducationalInstitution().equals(institution)) {
                        classIndex = i;
                        break;
                    }
                }
                if(Main.classes.get(classIndex).isPrivate()) {
                    Classroom.requestPassword(scanner, Main.classes.get(classIndex));
                }
                Main.currentClass = Main.classes.get(classIndex);
                System.out.println("entered the class successfully");
                System.out.println(Main.currentClass);
                Classroom.register();
            }
        }
    }

    public static void searchAndEnterByOwner(Scanner scanner) {
        if(Main.currentClass != null) {
            System.out.println("please get out of previous class first");
        }else if(Main.currentUser == null) {
            System.out.println("please log in first");
        }else {
            System.out.println("search:");
            String input = scanner.nextLine();
            ArrayList<String> owners = new ArrayList<>();
            for (Classroom aClass : Main.classes) {
                if (aClass.getProfessor().getName().contains(input)) {
                    owners.add(aClass.getProfessor().getName());
                }
            }
            if (owners.isEmpty()) {
                System.out.println("there is no class with this owner!");
            } else {
                for (int i = 0; i < owners.size(); i++) {
                    System.out.println((i + 1) + "_" + owners.get(i));
                }
                int theClass = scanner.nextInt();
                String owner = owners.get(theClass - 1);
                int classIndex = 0;
                for (int i = 0; i < Main.classes.size(); i++) {
                    if (Main.classes.get(i).getProfessor().getName().equals(owner)) {
                        classIndex = i;
                        break;
                    }
                }
                if(Main.classes.get(classIndex).isPrivate()) {
                    Classroom.requestPassword(scanner, Main.classes.get(classIndex));
                }
                Main.currentClass = Main.classes.get(classIndex);
                System.out.println("entered the class successfully");
                System.out.println(Main.currentClass);
                Classroom.register();
            }
        }
    }
}
