package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Collections;

public class Scoreboard {

    private boolean isVisible;

    private ArrayList<User> students;

    public Scoreboard(boolean isVisible) {
        this.isVisible = isVisible;
        if(Main.currentClass != null) {
            students = Main.currentClass.sortStudents();
        }
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public static void makeVisible() {
        if(Main.currentClass == null) {
            System.out.println("please enter a class first");
        }else if(Main.currentPractice == null) {
            System.out.println("please open a practice first");
        }else if(Main.currentUser == null){
            System.out.println("please log in first");
        }else if(Main.currentUser.equals(Main.currentClass.getProfessor())) {
            Main.currentPractice.getScoreboard().setVisible(true);
        }else {
            System.out.println("you are not allowed to do this");
        }
    }

    public static void makeInvisible() {
        if(Main.currentClass == null) {
            System.out.println("please enter a class first");
        }else if(Main.currentPractice == null) {
            System.out.println("please open a practice first");
        }else if(Main.currentUser == null){
            System.out.println("please log in first");
        }else if(Main.currentUser.equals(Main.currentClass.getProfessor())) {
            Main.currentPractice.getScoreboard().setVisible(false);
        }else {
            System.out.println("you are not allowed to do this");
        }
    }

    public String getUsers() {
        String result = "";
        int rank = 1;
        double previousPoint = 0;
        for(User student : students) {
            result += rank + "." + student.getName() + createSpace(student.getName()) + "|";
            result += Main.currentPractice.getPoints(student.getUserName());
            result += Main.currentPractice.calculatePoints(student.getUserName());
            result += "\n";
            if(previousPoint != Main.currentPractice.calculatePoints(student.getUserName())) {
                rank++;
            }
            previousPoint = Main.currentPractice.calculatePoints(student.getUserName());
        }
        return result;
    }

    public String createSpace(String name) {
        int size = name.length();
        String spaces = "";
        for(int i=0; i<10 - size; i++) {
            spaces += " ";
        }
        return spaces;
    }

    @Override
    public String toString() {
        return "User        |" + Main.currentPractice.getQuestionsWithoutEnter() + "total" + "\n"
                + getUsers();
    }
}
