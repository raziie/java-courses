package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public enum Option {
        USER_OPTIONS, CLASS_OPTIONS, PRACTICE_OPTIONS, GO_TO_QUESTION_BANK, EXIT, UNDEFINED
    }

    public static ArrayList<User> users = new ArrayList<>();

    public static ArrayList<Classroom> classes = new ArrayList<>();

    public static Classroom currentClass;

    public static User currentUser;

    public static Practice currentPractice;

    public static QuestionBank bank = new QuestionBank();

    public static void printMenu() {
        System.out.println("──────────────────────────────────");
        System.out.println("1.User options");
        System.out.println("2.Class options");
        System.out.println("3.Practice options");
        System.out.println("4.Go to question bank");
        System.out.println("5.Exit");
        System.out.println("──────────────────────────────────");
        System.out.println("Please select your choice:");

    }

    public static Option scanOption(Scanner scanner) {
        Option[] options = Option.values();
        int userInput = scanner.nextInt();
        scanner.nextLine();
        userInput--;
        if(userInput>=0 && userInput<=options.length) {
            return options[userInput];
        }
        return Option.UNDEFINED;
    }

    public static void handleOption(Option option, Scanner scanner) {
        switch (option) {
            case CLASS_OPTIONS -> ClassroomMenu.handle(scanner);
            case USER_OPTIONS -> UserMenu.handle(scanner);
            case PRACTICE_OPTIONS -> PracticeMenu.handle(scanner);
            case GO_TO_QUESTION_BANK -> bank.answerQuestion(scanner);
            default -> System.out.println("invalid choice!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Test.set();
        printMenu();
        Option option = scanOption(scanner);
        while(option != Option.EXIT) {
            handleOption(option, scanner);
            printMenu();
            option = scanOption(scanner);
        }
        scanner.close();
    }
}