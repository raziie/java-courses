package ir.ac.kntu;

import java.time.LocalDateTime;
import java.util.Scanner;

public class PracticeScannersAndEditors {
    public static String scanName(Scanner scanner) {
        System.out.println("please enter your practice's name:");
        return scanner.nextLine();
    }

    public static String scanExplanation(Scanner scanner) {
        System.out.println("please enter your practice's explanation:");
        return scanner.nextLine();
    }

    public static LocalDateTime scanStartTime(Scanner scanner) {
        System.out.println("please enter start time:");
        System.out.println("YYYY:");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("MM:");
        int month = scanner.nextInt();
        scanner.nextLine();
        System.out.println("DD:");
        int day = scanner.nextInt();
        scanner.nextLine();
        System.out.println("HH:");
        int hour = scanner.nextInt();
        scanner.nextLine();
        System.out.println("MM:");
        int minute = scanner.nextInt();
        scanner.nextLine();
        return LocalDateTime.of(year, month, day, hour, minute);
    }

    public static LocalDateTime scanEndTime(Scanner scanner) {
        System.out.println("please enter end time:");
        System.out.println("YYYY:");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("MM:");
        int month = scanner.nextInt();
        scanner.nextLine();
        System.out.println("DD:");
        int day = scanner.nextInt();
        scanner.nextLine();
        System.out.println("HH:");
        int hour = scanner.nextInt();
        scanner.nextLine();
        System.out.println("MM:");
        int minute = scanner.nextInt();
        scanner.nextLine();
        return LocalDateTime.of(year, month, day, hour, minute);
    }

    public static LocalDateTime scanDelayTime(Scanner scanner) {
        System.out.println("please enter delay time:");
        System.out.println("YYYY:");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("MM:");
        int month = scanner.nextInt();
        scanner.nextLine();
        System.out.println("DD:");
        int day = scanner.nextInt();
        scanner.nextLine();
        System.out.println("HH:");
        int hour = scanner.nextInt();
        scanner.nextLine();
        System.out.println("MM:");
        int minute = scanner.nextInt();
        scanner.nextLine();
        return LocalDateTime.of(year, month, day, hour, minute);
    }

    public static boolean scanIsBeingTested(Scanner scanner) {
        System.out.println("Is this practice being tested for now?");
        System.out.println("(Y for yes and N for no)");
        String answer = scanner.nextLine();
        return answer.equals("Y");
    }

    public static double scanDelayFacor(Scanner scanner) {
        System.out.println("please enter your practice's delay factor:");
        double input = scanner.nextDouble();
        scanner.nextLine();
        return input;
    }

    public static void editName(Scanner scanner) {
        System.out.println("Enter the new name:");
        Main.currentPractice.setName(scanner.nextLine());
    }

    public static void editExplanation(Scanner scanner) {
        System.out.println("Enter the new explanation:");
        Main.currentPractice.setExplanation(scanner.nextLine());
    }

    public static void editStartTime(Scanner scanner) {
        System.out.println("please enter the new start time:");
        System.out.println("YYYY:");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("MM:");
        int month = scanner.nextInt();
        scanner.nextLine();
        System.out.println("DD:");
        int day = scanner.nextInt();
        scanner.nextLine();
        System.out.println("HH:");
        int hour = scanner.nextInt();
        scanner.nextLine();
        System.out.println("MM:");
        int minute = scanner.nextInt();
        scanner.nextLine();
        Main.currentPractice.setStartTime(LocalDateTime.of(year, month, day, hour, minute));
    }

    public static void editEndTime(Scanner scanner) {
        System.out.println("please enter the new start time:");
        System.out.println("YYYY:");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("MM:");
        int month = scanner.nextInt();
        scanner.nextLine();
        System.out.println("DD:");
        int day = scanner.nextInt();
        scanner.nextLine();
        System.out.println("HH:");
        int hour = scanner.nextInt();
        scanner.nextLine();
        System.out.println("MM:");
        int minute = scanner.nextInt();
        scanner.nextLine();
        Main.currentPractice.setEndTime(LocalDateTime.of(year, month, day, hour, minute));
    }
}
