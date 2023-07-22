package ir.ac.kntu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuestionBank {

    public enum Sort{BY_TIME, BY_DIFFICULTY, DEFAULT}

    private ArrayList<Question> questions;

    private ArrayList<Answer> answers;

    public QuestionBank() {
        questions = new ArrayList<>();
        answers = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public Question getQuestion(Scanner scanner) {
        ArrayList<Question> copyOfQuestions = new ArrayList<>(questions);
        printQuestions(scanner, copyOfQuestions);
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        return copyOfQuestions.get(index);
    }

    public static Sort defineSortWay(Scanner scanner) {
        System.out.println("do you want to define sort way? (Y for yes and N for no)");
        if(scanner.nextLine().equals("Y")) {
            System.out.println("──────────────────────────────────");
            System.out.println("1.Sort by time");
            System.out.println("2.Sort by difficulty");
            System.out.println("──────────────────────────────────");
            System.out.println("Please select your choice:");
            return scanOption(scanner);
        }else {
            return Sort.DEFAULT;
        }
    }

    public static Sort scanOption(Scanner scanner) {
        Sort[] options = Sort.values();
        int userInput = scanner.nextInt();
        scanner.nextLine();
        userInput--;
        if(userInput>=0 && userInput<=options.length) {
            return options[userInput];
        }
        return Sort.DEFAULT;
    }

    public void printQuestions(Scanner scanner, ArrayList<Question> copy) {
        if(defineSortWay(scanner) == Sort.BY_DIFFICULTY) {
            Collections.sort(copy);
        }
        for (int i = 0; i < copy.size(); i++) {
            System.out.println((i + 1) + "_" + copy.get(i).getName());
        }
    }

    public void answerQuestion(Scanner scanner) {
        if(Main.currentUser == null) {
            System.out.println("please log in first");
        }else {
            answers.add(createAnswer(scanner));
            System.out.println("answer added successfully");
        }
    }

    public Answer createAnswer(Scanner scanner) {
        String senderUserName = Main.currentUser.getUserName();
        Question question = getQuestion(scanner);
        LocalDateTime sendingTime = LocalDateTime.now();
        String inputAnswer = scanAnswer(scanner);
        return new Answer(senderUserName, question, sendingTime, inputAnswer);
    }

    public String scanAnswer(Scanner scanner) {
        System.out.println("please enter your answer:");
        return scanner.nextLine();
    }
}

