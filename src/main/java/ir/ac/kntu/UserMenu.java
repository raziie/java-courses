package ir.ac.kntu;

import java.util.Scanner;

public class UserMenu {

    public enum UserOption {
        ADD_A_USER, LOG_IN, LOG_OUT, SEARCH_BY_NATIONAL_ID, SEARCH_BY_EMAIL, BACK, UNDEFINED
    }

    public static void handle(Scanner scanner) {
        printMenu();
        UserOption option = scanOption(scanner);
        while(option != UserOption.BACK) {
            handleOption(option, scanner);
            printMenu();
            option = scanOption(scanner);
        }
    }

    public static void printMenu() {
        System.out.println("──────────────────────────────────");
        System.out.println("1.Add a user");
        System.out.println("2.Log in");
        System.out.println("3.Log out");
        System.out.println("4.Search by national ID");
        System.out.println("5.Search by email");
        System.out.println("6.Back");
        System.out.println("──────────────────────────────────");
        System.out.println("Please select your choice:");

    }

    public static UserOption scanOption(Scanner scanner) {
        UserOption[] options = UserOption.values();
        int userInput = scanner.nextInt();
        scanner.nextLine();
        userInput--;
        if(userInput>=0 && userInput<=options.length) {
            return options[userInput];
        }
        return UserOption.UNDEFINED;
    }

    public static void handleOption(UserOption option, Scanner scanner) {
        switch (option) {
            case ADD_A_USER -> User.addUser(scanner);
            case LOG_IN -> User.logIn(scanner);
            case LOG_OUT -> User.logOut();
            case SEARCH_BY_NATIONAL_ID -> SearchUser.searchById(scanner);
            case SEARCH_BY_EMAIL -> SearchUser.searchByEmail(scanner);
            default -> System.out.println("invalid choice!");
        }
    }
}
