package ir.ac.kntu;

import java.util.Scanner;

public class PracticeMenu {

    public enum PracticeOption {
       OPEN_PRACTICE, EDIT_PRACTICE, DELETE_PRACTICE, PRINT_SCOREBOARD,
        SEE_MY_ANSWERS, SEE_MY_FINAL_ANSWERS, SEE_ANSWERS, SEARCH_ANSWERS, ADD_ANSWER, BACK, UNDEFINED
    }

    public static void handle(Scanner scanner) {
        printMenu();
        PracticeOption option = scanOption(scanner);
        while(option != PracticeOption.BACK) {
            handleOption(option, scanner);
            printMenu();
            option = scanOption(scanner);
        }
    }

    public static void printMenu() {
        System.out.println("──────────────────────────────────");
        System.out.println("1.Open practice");
        System.out.println("2.Edit practice");
        System.out.println("3.Delete practice");
        System.out.println("4.Print scoreboard");
        System.out.println("5.See my answers");
        System.out.println("6.See my final answers");
        System.out.println("7.See answers");
        System.out.println("8.Search answers");
        System.out.println("9.send answer");
        System.out.println("10.Back");
        System.out.println("──────────────────────────────────");
        System.out.println("Please select your choice:");

    }

    public static PracticeOption scanOption(Scanner scanner) {
        PracticeOption[] options = PracticeOption.values();
        int userInput = scanner.nextInt();
        scanner.nextLine();
        userInput--;
        if(userInput>=0 && userInput<=options.length) {
            return options[userInput];
        }
        return PracticeOption.UNDEFINED;
    }

    public static void handleOption(PracticeOption option, Scanner scanner) {
        switch (option) {
            case OPEN_PRACTICE -> Practice.openPractice(scanner);
            case EDIT_PRACTICE -> PracticeEditMenu.edit(scanner);
            case DELETE_PRACTICE -> Practice.delete();
            case PRINT_SCOREBOARD -> Practice.printScoreboard();
            case SEE_MY_ANSWERS -> Answer.seeAnswers();
            case SEE_MY_FINAL_ANSWERS -> Answer.seeFinalAnswers();
            case SEE_ANSWERS -> Answer.seeAndMarkAnswers(scanner);
            case SEARCH_ANSWERS -> Practice.searchAnswers(scanner);
            case ADD_ANSWER -> Practice.addAnswer(scanner);
            default -> System.out.println("invalid choice!");
        }
    }
}
