package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Random;
import java.util.Scanner;

public class Even {
    public static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static final int CORRECT_ANSWERS_LIMIT = 3;

    public static void playEvenGame() {
        String playerName = Cli.askUserName();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        int correctAnswersAmount = 0;
        while (correctAnswersAmount < CORRECT_ANSWERS_LIMIT) {
            int number = RANDOM.nextInt();
            System.out.println("Question: " + number);
            System.out.print("Your answer is: ");
            String playerAnswer = SCANNER.next();
            boolean isEven = number % 2 == 0;
            if ("yes".equals(playerAnswer) && isEven || "no".equals(playerAnswer) && !isEven) {
                correctAnswersAmount++;
                System.out.println("Correct!");
            }  else {
                String correctAnswer = isEven ? "yes" : "no";
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", playerAnswer, correctAnswer);
                System.out.printf("Let's try again, %s!\n", playerName);
                break;
            }
        }
        if (correctAnswersAmount == CORRECT_ANSWERS_LIMIT) {
            System.out.printf("Congratulations, %s!\n", playerName);
        }
    }

    private Even() {
    }
}
