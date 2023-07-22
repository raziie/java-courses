package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Classroom {

    private String name;

    private String educationalInstitution;

    private final User professor;

    private int year;

    private boolean isOpen;

    private String description;

    private boolean isPrivate;

    private String password;

    private ArrayList<User> students;

    private ArrayList<Practice> practices;

    public Classroom(String name, String educationalInstitution, User professor,
                     int year, boolean isOpen, String description, boolean isPrivate) {
        this.name = name;
        this.educationalInstitution = educationalInstitution;
        this.professor = professor;
        this.year = year;
        this.isOpen = isOpen;
        this.description = description;
        this.isPrivate = isPrivate;
        students = new ArrayList<>();
        practices = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEducationalInstitution() {
        return educationalInstitution;
    }

    public User getProfessor() {
        return professor;
    }

    public int getYear() {
        return year;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPrivate() {
        return isPrivate;
    }


    public ArrayList<Practice> getPractices() {
        return new ArrayList<>(practices);
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEducationalInstitution(String educationalInstitution) {
        this.educationalInstitution = educationalInstitution;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public void addStudent(User student) {
        students.add(student);
    }

    public void addPractice(Practice practice) {
        practices.add(practice);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void requestPassword(Scanner scanner, Classroom theClass) {
        System.out.println("password:");
        String inputPassword = scanner.nextLine();
        while(!(inputPassword.equals(theClass.getPassword()))) {
            System.out.println("password is incorrect!");
            System.out.println("password:");
            inputPassword = scanner.nextLine();
        }
    }

    public static void register() {
        if(Main.currentClass.isOpen()) {
            Main.currentClass.addStudent(Main.currentUser);
            System.out.println("successfully registered");
        }else {
            System.out.println("you can't register in the class now!");
        }
    }

    public static void getOut() {
        if(Main.currentClass == null) {
            System.out.println("you haven't enter a class yet!");
        }else {
            Main.currentClass = null;
            System.out.println("got out successfully!");
        }
    }

    public static void createClass(Scanner scanner) {
        if(Main.currentUser == null) {
            System.out.println("you haven't logged in yet!");
        }else {
            String inputName = scanName(scanner);
            String inputEI = scanEI(scanner);
            int inputYear = scanYear(scanner);
            scanner.nextLine();
            boolean inputIsOpen = scanIsOpen(scanner);
            String inputDescription = scanDescription(scanner);
            boolean inputIsPrivate = scanIsPrivate(scanner);
            String inputPassword = "";
            Classroom theClass = new Classroom(inputName, inputEI, Main.currentUser,
                    inputYear, inputIsOpen, inputDescription, inputIsPrivate);
            if(inputIsPrivate) {
                inputPassword = scanPassword(scanner);
                theClass.setPassword(inputPassword);
            }
            Main.classes.add(theClass);
            System.out.println("successfully created");
        }
    }

    public static String scanName(Scanner scanner) {
        System.out.println("please enter your class's name:");
        return scanner.nextLine();
    }

    public static String scanEI(Scanner scanner) {
        System.out.println("please enter the educational institution:");
        return scanner.nextLine();
    }

    public static int scanYear(Scanner scanner) {
        System.out.println("please enter the year:");
        return scanner.nextInt();
    }

    public static boolean scanIsOpen(Scanner scanner) {
        System.out.println("is your class open for registration?" + "\n" + "(please enter y for yes and n for no)");
        return scanner.nextLine().equals("y");
    }

    public static String scanDescription(Scanner scanner) {
        System.out.println("please enter the description:" + "\n" + "(if there is no need enter <none>)");
        return scanner.nextLine();
    }

    public static boolean scanIsPrivate(Scanner scanner) {
        System.out.println("is your class private?" + "\n" + "(please enter y for yes and n for no)");
        return scanner.nextLine().equals("y");
    }

    public static String scanPassword(Scanner scanner) {
        System.out.println("please enter your class's password:");
        return scanner.nextLine();
    }

    public static void editName(Scanner scanner) {
        System.out.println("Enter the new name:");
        Main.currentClass.setName(scanner.nextLine());
    }

    public static void editEI(Scanner scanner) {
        System.out.println("Enter the new educational description:");
        Main.currentClass.setEducationalInstitution(scanner.nextLine());
    }

    public static void editYear(Scanner scanner) {
        System.out.println("Enter the new year:");
        Main.currentClass.setYear(scanner.nextInt());
        scanner.nextLine();
    }

    public static void open() {
        Main.currentClass.setOpen(true);
    }

    public static void close() {
        Main.currentClass.setOpen(false);
    }

    public static void editDescription(Scanner scanner) {
        System.out.println("Enter the new description:");
        Main.currentClass.setDescription(scanner.nextLine());
    }

    public static void makePrivate(Scanner scanner) {
        Main.currentClass.setPrivate(true);
        String inputPassword = scanPassword(scanner);
        Main.currentClass.setPassword(inputPassword);
    }

    public static void makePublic() {
        Main.currentClass.setPrivate(false);
    }

    public static void editPassword(Scanner scanner) {
        System.out.println("Enter the new password:");
        Main.currentClass.setPassword(scanner.nextLine());
    }

    public static void addStudent(Scanner scanner) {
        System.out.println("please enter the email of the user you want to add:");
        String inputEmail = scanner.nextLine();
        boolean isAdded = false;
        boolean isAlreadyThere = false;
        for(User user : Main.users) {
            if(user.getEmail().equals(inputEmail)) {
                if(Main.currentClass.containsStudent(user)) {
                    System.out.println("this student is already in class");
                    isAlreadyThere = true;
                }else {
                    Main.currentClass.addStudent(user);
                    isAdded = true;
                }
                break;
            }
        }
        if(isAdded) {
            System.out.println("user added to class successfully!");
        }else if(!isAlreadyThere) {
            System.out.println("there is no user with this email!");
        }
    }

    public static void delete() {
        if(Main.currentClass == null) {
            System.out.println("please enter a class first");
        }else {
            Main.classes.remove(Main.currentClass);
            Main.currentClass = null;
        }
    }

    public void printPractices() {
        for(int i=0; i<practices.size(); i++) {
            System.out.println((i+1) + "_" + practices.get(i).getName());
        }
    }

    public void removePractice(Practice practice) {
        practices.remove(practice);
    }

    public boolean containsStudent(User user) {
        for(User student : students) {
            if(student.equals(user)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<User> sortStudents() {
        ArrayList<User> copy = new ArrayList<>(students);
        Collections.sort(copy);
        return copy;
    }

    public User findStudent(String email) {
        for(User student : students) {
            if(student.getEmail().equals(email)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "name: " + name + "\n"
                + "educational institution: " + educationalInstitution + "\n"
                + "professor: " + professor
                + "year: " + year + "\n"
                + "is open: " + isOpen + "\n"
                + "description: " + description;
    }
}
