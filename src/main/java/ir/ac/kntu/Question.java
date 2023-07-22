package ir.ac.kntu;

import java.awt.desktop.ScreenSleepEvent;
import java.util.Objects;
import java.util.Scanner;

public class Question implements Comparable<Question> {

    public enum Level{EASY, MEDIUM, HARD, VERY_HARD}

    public enum QuestionType{LONG_ANSWER, TEST, SHORT_ANSWER, BLANK_SPACE}

    private String name;

    private double point;

    private String script;

    private Level level;

    private QuestionType type;

    public Question(String name, double point, String script, Level level, QuestionType type) {
        this.name = name;
        this.point = point;
        this.script = script;
        this.level = level;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getPoint() {
        return point;
    }

    public String getScript() {
        return script;
    }

    public Level getLevel() {
        return level;
    }

    public QuestionType getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public void editName(Scanner scanner) {
        System.out.println("Enter the new name:");
        name = scanner.nextLine();
    }

    public void editPoint(Scanner scanner) {
        System.out.println("Enter the new point:");
        point = scanner.nextDouble();
        scanner.nextLine();
    }

    public void editScript(Scanner scanner) {
        System.out.println("Enter the new script:");
        script = scanner.nextLine();
    }

    public void editLevel(Scanner scanner) {
        System.out.println("Choose the new level:");
        System.out.println("""
                1.easy
                2.medium
                3.hard
                4.very hard""");
        int input = scanner.nextInt();
        scanner.nextLine();
        if(input == 1) {
            level = Level.EASY;
        }else if(input == 2) {
            level = Level.MEDIUM;
        }else if(input == 3) {
            level = Level.HARD;
        }else {
            level = Level.VERY_HARD;
        }
    }

    public static Question createQuestion(Scanner scanner) {
        System.out.println("do you want to use question bank? (Y for yes and N for no)");
        if(scanner.nextLine().equals("Y")) {
            return Main.bank.getQuestion(scanner);
        }else {
            String inputName = scanName(scanner);
            int inputPoint = scanPoint(scanner);
            scanner.nextLine();
            String inputScript = scanScript(scanner);
            Level inputLevel = scanLevel(scanner);
            QuestionType inputType = scanType(scanner);
            System.out.println("do you want to add this to question bank? (Y for yes and N for no)");
            Question question = new Question(inputName, inputPoint, inputScript, inputLevel, inputType);
            if(scanner.nextLine().equals("Y")) {
                Main.bank.addQuestion(question);
            }
            return question;
        }
    }

    public static String scanName(Scanner scanner) {
        System.out.println("please enter your question's name:");
        String input = scanner.nextLine();
        while (Main.currentPractice.nameIsRepeated(input)) {
            System.out.println("this name is repeated!");
            System.out.println("please enter another name:");
            input = scanner.nextLine();
        }
        return input;
    }

    public static int scanPoint(Scanner scanner) {
        System.out.println("please enter your question's point:");
        int input =  scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public static String scanScript(Scanner scanner) {
        System.out.println("please enter your question's script:");
        return scanner.nextLine();
    }

    public static Level scanLevel(Scanner scanner) {
        System.out.println("please choose your question's level:");
        System.out.println("""
                1.easy
                2.medium
                3.hard
                4.very hard""");
        int input = scanner.nextInt();
        scanner.nextLine();
        if(input == 1) {
            return Level.EASY;
        }else if(input == 2) {
            return Level.MEDIUM;
        }else if(input == 3) {
            return Level.HARD;
        }else {
            return Level.VERY_HARD;
        }
    }

    public static QuestionType scanType(Scanner scanner) {
        System.out.println("please choose your question's type:");
        System.out.println("""
                1.long answer
                2.test
                3.short answer
                4.blank space""");
        int input = scanner.nextInt();
        scanner.nextLine();
        if(input == 1) {
            return QuestionType.LONG_ANSWER;
        }else if(input == 2) {
            return QuestionType.TEST;
        }else if(input == 3) {
            return QuestionType.SHORT_ANSWER;
        }else {
            return QuestionType.BLANK_SPACE;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Question question = (Question) obj;
        return (this.name.equals(question.getName()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Question other) {
        Level[] levels = Level.values();
        int thisIndex = 0;
        int otherIndex = 0;
        for(int i=0; i<levels.length; i++) {
            if(levels[i] == this.level) {
                thisIndex = i;
                break;
            }
        }
        for(int i=0; i<levels.length; i++) {
            if(levels[i] == other.getLevel()) {
                otherIndex = i;
                break;
            }
        }
        return thisIndex - otherIndex;
    }
}
