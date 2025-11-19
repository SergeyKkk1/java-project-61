package hexlet.code.games;

import hexlet.code.Engine;

public final class Prime {

    private static final int RANDOM_NUMBER_BOUND = 200;
    private static final String PRIME_GAME_QUESTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private Prime() {
    }

    public static void play() {
        Engine.startGame(PRIME_GAME_QUESTION, generateQuestionToAnswer());
    }

    private static String[][] generateQuestionToAnswer() {
        String[][] questionToAnswer = new String[Engine.ROUNDS][2];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int number = Engine.RANDOM.nextInt(RANDOM_NUMBER_BOUND);
            questionToAnswer[i][0] = String.valueOf(number);
            questionToAnswer[i][1] = isPrime(number) ? "yes" : "no";
        }
        return questionToAnswer;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        } else if (number == 2) {
            return true;
        } else if (number % 2 == 0) {
            return false;
        } else {
            double sqrted = Math.sqrt(number);
            for (int i = 2; i <= sqrted; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
