package hexlet.code.games;

import hexlet.code.Engine;

public final class Gcd {
    private static final int RANDOM_NUMBER_BOUND = 30;
    private static final String GCD_GAME_QUESTION = "Find the greatest common divisor of given numbers.";

    private Gcd() {
    }

    public static void play() {
        Engine.startGame(GCD_GAME_QUESTION, generateQuestionToAnswer());
    }

    private static String[][] generateQuestionToAnswer() {
        String[][] questionToAnswer = new String[Engine.ROUNDS][2];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int firstNumber = Engine.RANDOM.nextInt(RANDOM_NUMBER_BOUND);
            int secondNumber = Engine.RANDOM.nextInt(RANDOM_NUMBER_BOUND);
            questionToAnswer[i][0] = String.format("%s %s ", firstNumber, secondNumber);
            questionToAnswer[i][1] = String.valueOf(calculateCorrectAnswer(firstNumber, secondNumber));
        }
        return questionToAnswer;
    }

    private static int calculateCorrectAnswer(int firstNumber, int secondNumber) {
        int result = Math.min(firstNumber, secondNumber);
        if (firstNumber == 0 || secondNumber == 0) {
            return Math.max(firstNumber, secondNumber);
        }
        while (result > 0) {
            if (firstNumber % result == 0 && secondNumber % result == 0) {
                break;
            }
            result--;
        }

        return result;
    }
}
