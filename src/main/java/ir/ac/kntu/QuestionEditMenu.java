package ir.ac.kntu;

import java.util.Scanner;

public class QuestionEditMenu {

    public enum QuestionEditOption {
        EDIT_NAME, EDIT_POINT, EDIT_SCRIPT, EDIT_LEVEL, BACK, UNDEFINED
    }

    public static void edit(Scanner scanner, Question question) {
        printMenu();
        QuestionEditOption option = scanOption(scanner);
        while (option != QuestionEditOption.BACK) {
            handleOption(option, scanner, question);
            printMenu();
            option = scanOption(scanner);
        }
    }

    public static void printMenu() {
        System.out.println("──────────────────────────────────");
        System.out.println("1.Edit name");
        System.out.println("2.Edit point");
        System.out.println("3.Edit script");
        System.out.println("4.Edit level");
        System.out.println("5.Back");
        System.out.println("──────────────────────────────────");
        System.out.println("Please select your choice:");
    }

    public static QuestionEditOption scanOption(Scanner scanner) {
        QuestionEditOption[] options = QuestionEditOption.values();
        int userInput = scanner.nextInt();
        scanner.nextLine();
        userInput--;
        if(userInput>=0 && userInput<=options.length) {
            return options[userInput];
        }
        return QuestionEditOption.UNDEFINED;
    }

    public static void handleOption(QuestionEditOption option, Scanner scanner, Question question) {
        switch (option) {
            case EDIT_NAME -> question.editName(scanner);
            case EDIT_POINT -> question.editPoint(scanner);
            case EDIT_SCRIPT -> question.editScript(scanner);
            case EDIT_LEVEL -> question.editLevel(scanner);
            default -> System.out.println("invalid choice!");
        }
    }
}
