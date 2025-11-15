package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public abstract class Game {
    protected static final Scanner SCANNER = new Scanner(System.in);
    protected static final Random RANDOM = new Random();

    public abstract void printTask();
    public abstract boolean askQuestion();

    protected void printQuestionDetails(String question) {
        System.out.println("Question: " + question);
        System.out.print("Your answer is: ");
    }

    protected void printWrongAnswerDetails(String playerAnswer, String correctAnswer) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", playerAnswer, correctAnswer);
    }
}
