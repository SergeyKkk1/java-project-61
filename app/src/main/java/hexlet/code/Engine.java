package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public final class Engine {
    public static final int ROUNDS = 3;
    public static final Random RANDOM = new Random();

    private Engine() {
    }

    public static void startGame(String mainGameQuestion, String[][] questionsAndAnswers) {
        String userName = Cli.askUserName();
        System.out.println(mainGameQuestion);
        int correctAnswersCount = 0;
        String playerAnswer = null;
        String correctAnswer = null;
        for (String[] questionWithAnswer : questionsAndAnswers) {
            System.out.println("Question: " + questionWithAnswer[0]);
            System.out.print("Your answer is: ");
            Scanner scanner = new Scanner(System.in);
            playerAnswer = scanner.next();
            correctAnswer = questionWithAnswer[1];
            if (!isAnswerCorrect(playerAnswer, correctAnswer) || ++correctAnswersCount >= ROUNDS) {
                break;
            }
        }

        if (correctAnswersCount == ROUNDS) {
            System.out.printf("Congratulations, %s!\n", userName);
        } else {
            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", playerAnswer, correctAnswer);
            System.out.printf("Let's try again, %s!\n", userName);
        }
    }

    private static boolean isAnswerCorrect(String playerAnswer, String correctAnswer) {
        boolean isCorrectAnswer = playerAnswer.equals(correctAnswer);
        if (isCorrectAnswer) {
            System.out.println("Correct!");
        }
        return isCorrectAnswer;
    }
}
