package ir.ac.kntu;

import java.time.LocalDateTime;

public class Test {

    public static void set() {
        User user1 = new User("ali", "ali123", "ali81@yahoo.com",
                "109", "3051246374", "09134567856");
        User user2 = new User("fatemeh", "fatemeh1", "fatemeHosseini@yahoo.com",
                "567", "3042342233", "09134562219");
        User user3 = new User("razie", "razi", "rzyh@gmail.com",
                "3467", "3046577890", "09134548863");
        User user4 = new User("mohammad", "m.s", "mohammad@gmail.com",
                "1236", "3056754433", "09120982245");
        User user5 = new User("narges","nargess","nargesMohammadi@yahoo.com",
                "56879","3049876657","09395462298");
        Main.users.add(user1);
        Main.users.add(user2);
        Main.users.add(user3);
        Main.users.add(user4);
        Main.users.add(user5);
        Classroom class1 = new Classroom("math", "khaje nasir", user1,
                1399, true, "study hard!", false);
        Classroom class2 = new Classroom("physics", "stanford", user2,
                1400, false, "we will do our best", true);
        class2.setPassword("101010");
        class1.addStudent(user3);
        class1.addStudent(user4);
        class2.addStudent(user5);
        class2.addStudent(user1);
        class2.addStudent(user4);
        Practice practice1 = new Practice("number1", "it has one question",
                LocalDateTime.of(2022,5,9,22,5,0),
                LocalDateTime.of(2022,5,9,23,30,0),
                LocalDateTime.of(2022,5,10,23,45,0),
                false, 0.8);
        Question question1 = new Question("toy factory", 100,"calculate cost of toys",
                Question.Level.EASY, Question.QuestionType.TEST);
        practice1.addQuestion(question1);
        class1.addPractice(practice1);
        Main.classes.add(class1);
        Main.classes.add(class2);
        Question question2 = new Question("taxi", 150,"you should mange an online taxi company",
                Question.Level.MEDIUM, Question.QuestionType.BLANK_SPACE);
        Question question3 = new Question("taxi2", 150,"you should mange an online taxi company",
                Question.Level.EASY, Question.QuestionType.BLANK_SPACE);
        Main.bank.addQuestion(question2);
        Main.bank.addQuestion(question3);
    }
}
