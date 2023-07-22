package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchUser {

    public static void searchById(Scanner scanner) {
        System.out.println("search:");
        String input = scanner.nextLine();
        ArrayList<String> nationalIds = new ArrayList<>();
        for (User user : Main.users) {
            if (user.getNationalId().contains(input)) {
                nationalIds.add(user.getNationalId());
            }
        }
        if (nationalIds.isEmpty()) {
            System.out.println("there is no user with this national id!");
        } else {
            for (int i = 0; i < nationalIds.size(); i++) {
                System.out.println((i + 1) + "_" + nationalIds.get(i));
            }
            int index = scanner.nextInt();
            String id = nationalIds.get(index - 1);
            int userIndex = 0;
            for (int i = 0; i < Main.users.size(); i++) {
                if (Main.users.get(i).getNationalId().equals(id)) {
                    userIndex = i;
                    break;
                }
            }
            System.out.println(Main.users.get(userIndex));
        }
    }

    public static void searchByEmail(Scanner scanner) {
        System.out.println("search:");
        String input = scanner.nextLine();
        ArrayList<String> emails = new ArrayList<>();
        for (User user : Main.users) {
            if (user.getEmail().contains(input)) {
                emails.add(user.getEmail());
            }
        }
        if (emails.isEmpty()) {
            System.out.println("there is no user with this email!");
        } else {
            for (int i = 0; i < emails.size(); i++) {
                System.out.println((i + 1) + "_" + emails.get(i));
            }
            int index = scanner.nextInt();
            String email = emails.get(index - 1);
            int userIndex = 0;
            for (int i = 0; i < Main.users.size(); i++) {
                if (Main.users.get(i).getEmail().equals(email)) {
                    userIndex = i;
                    break;
                }
            }
            System.out.println(Main.users.get(userIndex));
        }
    }
}
