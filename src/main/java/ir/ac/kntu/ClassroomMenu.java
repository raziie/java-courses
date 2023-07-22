package ir.ac.kntu;

import java.util.Scanner;

public class ClassroomMenu {

    public enum ClassOption {
        SEARCH_BY_NAME, SEARCH_BY_INSTITUTION, SEARCH_BY_OWNER, ENTER_CLASS, GET_OUT_OF_CLASS,
        CREATE_CLASS, EDIT_CLASS, DELETE_CLASS, BACK, UNDEFINED
    }

    public static void handle(Scanner scanner) {
        printMenu();
        ClassOption option = scanOption(scanner);
        while(option != ClassOption.BACK) {
            handleOption(option, scanner);
            printMenu();
            option = scanOption(scanner);
        }
    }

    public static void printMenu() {
        System.out.println("──────────────────────────────────");
        System.out.println("1.Search by name");
        System.out.println("2.Search by institution");
        System.out.println("3.Search by owner's name");
        System.out.println("4.Enter class");
        System.out.println("5.Get out of class");
        System.out.println("6.Create class");
        System.out.println("7.Edit class");
        System.out.println("8.Delete class");
        System.out.println("9.Back");
        System.out.println("──────────────────────────────────");
        System.out.println("Please select your choice:");

    }

    public static ClassOption scanOption(Scanner scanner) {
        ClassOption[] options = ClassOption.values();
        int userInput = scanner.nextInt();
        scanner.nextLine();
        userInput--;
        if(userInput>=0 && userInput<=options.length) {
            return options[userInput];
        }
        return ClassOption.UNDEFINED;
    }

    public static void handleOption(ClassOption option, Scanner scanner) {
        switch (option) {
            case SEARCH_BY_NAME -> SearchClass.searchAndEnterByName(scanner);
            case SEARCH_BY_INSTITUTION -> SearchClass.searchAndEnterByInstitution(scanner);
            case SEARCH_BY_OWNER -> SearchClass.searchAndEnterByOwner(scanner);
            case ENTER_CLASS -> User.enterClass(scanner);
            case GET_OUT_OF_CLASS -> Classroom.getOut();
            case CREATE_CLASS -> Classroom.createClass(scanner);
            case EDIT_CLASS -> ClassEditMenu.edit(scanner);
            case DELETE_CLASS -> Classroom.delete();
            default -> System.out.println("invalid choice!");
        }
    }
}
