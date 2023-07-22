package ir.ac.kntu;

import java.util.Scanner;

public class ClassEditMenu {

    public enum ClassEditOption {
        EDIT_NAME, EDIT_EDUCATIONAL_INSTITUTION, EDIT_YEAR, OPEN_FOR_REGISTRATION, CLOSE_FOR_REGISTRATION,
        EDIT_DESCRIPTION, MAKE_PRIVATE, MAKE_PUBLIC, EDIT_PASSWORD, ADD_STUDENT, ADD_PRACTICE, BACK, UNDEFINED
    }

    public static void edit(Scanner scanner) {
        if(Main.currentClass == null) {
            System.out.println("please enter a class first!");
        }else {
            if (Main.currentUser.equals(Main.currentClass.getProfessor())) {
                printMenu();
                ClassEditOption option = scanOption(scanner);
                while (option != ClassEditOption.BACK) {
                    handleOption(option, scanner);
                    printMenu();
                    option = scanOption(scanner);
                }
            } else {
                System.out.println("you are not allowed to edit this class");
            }
        }
    }

    public static void printMenu() {
        System.out.println("──────────────────────────────────");
        System.out.println("1.Edit name");
        System.out.println("2.Edit educational institution");
        System.out.println("3.Edit year");
        System.out.println("4.Open for registration");
        System.out.println("5.Close for registration");
        System.out.println("6.Edit description");
        System.out.println("7.Make private");
        System.out.println("8.Make public");
        System.out.println("9.Edit password");
        System.out.println("10.Add student");
        System.out.println("11.Add practice");
        System.out.println("12.Back");
        System.out.println("──────────────────────────────────");
        System.out.println("Please select your choice:");
    }

    public static ClassEditOption scanOption(Scanner scanner) {
        ClassEditOption[] options = ClassEditOption.values();
        int userInput = scanner.nextInt();
        scanner.nextLine();
        userInput--;
        if(userInput>=0 && userInput<=options.length) {
            return options[userInput];
        }
        return ClassEditOption.UNDEFINED;
    }

    public static void handleOption(ClassEditOption option, Scanner scanner) {
        switch (option) {
            case EDIT_NAME -> Classroom.editName(scanner);
            case EDIT_EDUCATIONAL_INSTITUTION -> Classroom.editEI(scanner);
            case EDIT_YEAR -> Classroom.editYear(scanner);
            case OPEN_FOR_REGISTRATION -> Classroom.open();
            case CLOSE_FOR_REGISTRATION -> Classroom.close();
            case EDIT_DESCRIPTION -> Classroom.editDescription(scanner);
            case MAKE_PRIVATE -> Classroom.makePrivate(scanner);
            case MAKE_PUBLIC -> Classroom.makePublic();
            case EDIT_PASSWORD -> Classroom.editPassword(scanner);
            case ADD_STUDENT -> Classroom.addStudent(scanner);
            case ADD_PRACTICE -> Practice.addPractice(scanner);
            default -> System.out.println("invalid choice!");
        }
    }
}
