package hexlet.code;

import java.util.Scanner;

public final class Engine {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int CORRECT_ANSWERS_LIMIT = 3;

    private Engine() {
    }

    public static void startGame(String mainGameQuestion, String[][] questionsAndAnswers) {
        String userName = Cli.askUserName();
        System.out.println(mainGameQuestion);
        int correctAnswersCount = 0;
        String playerAnswer;
        String correctAnswer;
        do {
            printQuestionDetails(questionsAndAnswers[correctAnswersCount][0]);
            playerAnswer = SCANNER.next();
            correctAnswer = questionsAndAnswers[correctAnswersCount][1];
        } while (isAnswerCorrect(playerAnswer, correctAnswer) && ++correctAnswersCount < CORRECT_ANSWERS_LIMIT);

        if (correctAnswersCount == CORRECT_ANSWERS_LIMIT) {
            System.out.printf("Congratulations, %s!\n", userName);
        } else {
            printWrongAnswerDetails(playerAnswer, correctAnswer);
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

    private static void printQuestionDetails(String question) {
        System.out.println("Question: " + question);
        System.out.print("Your answer is: ");
    }

    private static void printWrongAnswerDetails(String playerAnswer, String correctAnswer) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", playerAnswer, correctAnswer);
    }
}
