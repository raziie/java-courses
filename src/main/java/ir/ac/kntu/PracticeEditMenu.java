package ir.ac.kntu;

import java.util.Scanner;

public class PracticeEditMenu {

    public enum PracticeEditOption {
        EDIT_NAME, EDIT_EXPLANATION, EDIT_START_TIME, EDIT_END_TIME, ACTIVATE_TEST,
        DEACTIVATE_TEST, ADD_QUESTION, REMOVE_QUESTION, EDIT_QUESTION,
        MAKE_SCOREBOARD_VISIBLE, MAKE_SCOREBOARD_INVISIBLE, BACK, UNDEFINED
    }

    public static void edit(Scanner scanner) {
        if(Main.currentPractice == null) {
            System.out.println("please open a practice first!");
        }else {
            if (Main.currentUser.equals(Main.currentClass.getProfessor())) {
                printMenu();
                PracticeEditOption option = scanOption(scanner);
                while (option != PracticeEditOption.BACK) {
                    handleOption(option, scanner);
                    printMenu();
                    option = scanOption(scanner);
                }
            } else {
                System.out.println("you are not allowed to edit this practice");
            }
        }
    }

    public static void printMenu() {
        System.out.println("──────────────────────────────────");
        System.out.println("1.Edit name");
        System.out.println("2.Edit explanation");
        System.out.println("3.Edit start time");
        System.out.println("4.Edit end time");
        System.out.println("5.Activate test");
        System.out.println("6.Deactivate test");
        System.out.println("7.Add question");
        System.out.println("8.Remove question");
        System.out.println("9.Edit question");
        System.out.println("10.Make scoreboard visible");
        System.out.println("11.Make scoreboard visible");
        System.out.println("12.Back");
        System.out.println("──────────────────────────────────");
        System.out.println("Please select your choice:");
    }

    public static PracticeEditOption scanOption(Scanner scanner) {
        PracticeEditOption[] options = PracticeEditOption.values();
        int userInput = scanner.nextInt();
        scanner.nextLine();
        userInput--;
        if(userInput>=0 && userInput<=options.length) {
            return options[userInput];
        }
        return PracticeEditOption.UNDEFINED;
    }

    public static void handleOption(PracticeEditOption option, Scanner scanner) {
        switch (option) {
            case EDIT_NAME -> PracticeScannersAndEditors.editName(scanner);
            case EDIT_EXPLANATION -> PracticeScannersAndEditors.editExplanation(scanner);
            case EDIT_START_TIME -> PracticeScannersAndEditors.editStartTime(scanner);
            case EDIT_END_TIME -> PracticeScannersAndEditors.editEndTime(scanner);
            case ACTIVATE_TEST -> Practice.activateTest();
            case DEACTIVATE_TEST -> Practice.deactivateTest();
            case ADD_QUESTION -> Practice.addQuestion(scanner);
            case REMOVE_QUESTION -> Practice.remove(scanner);
            case EDIT_QUESTION -> Practice.edit(scanner);
            case MAKE_SCOREBOARD_VISIBLE -> Scoreboard.makeVisible();
            case MAKE_SCOREBOARD_INVISIBLE -> Scoreboard.makeInvisible();
            default -> System.out.println("invalid choice!");
        }
    }
}
