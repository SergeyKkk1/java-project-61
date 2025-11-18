package hexlet.code.games;

import hexlet.code.Engine;

public final class Gcd extends Game {
    private static final int RANDOM_NUMBER_BOUND = 30;
    private static final String GCD_GAME_QUESTION = "Find the greatest common divisor of given numbers.";

    public static void play() {
        Engine.startGame(GCD_GAME_QUESTION, generateQuestionToAnswer());
    }

    private static String[][] generateQuestionToAnswer() {
        String[][] questionToAnswer = new String[QUESTIONS_LIMIT][2];
        for (int i = 0; i < QUESTIONS_LIMIT; i++) {
            int firstNumber = RANDOM.nextInt(RANDOM_NUMBER_BOUND);
            int secondNumber = RANDOM.nextInt(RANDOM_NUMBER_BOUND);
            questionToAnswer[i][0] = String.format("%s %s ", firstNumber, secondNumber);
            questionToAnswer[i][1] = String.valueOf(calculateCorrectAnswer(firstNumber, secondNumber));
        }
        return questionToAnswer;
    }

    private static int calculateCorrectAnswer(int firstNumber, int secondNumber) {
        int result = Math.min(firstNumber, secondNumber);
        while (result > 0) {
            if (firstNumber % result == 0 && secondNumber % result == 0) {
                break;
            }
            result--;
        }

        return result;
    }
}
