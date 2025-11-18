package hexlet.code.games;

import hexlet.code.Engine;

public class Even extends Game {
    private static final int RANDOM_NUMBER_BOUND = 1000;
    private static final String EVEN_GAME_QUESTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private Even() {
    }

    public static void play() {
        Engine.startGame(EVEN_GAME_QUESTION, generateQuestionToAnswer());
    }

    private static String[][] generateQuestionToAnswer() {
        String[][] answers = new String[QUESTIONS_LIMIT][2];
        for (int i = 0; i < QUESTIONS_LIMIT; i++) {
            int number = RANDOM.nextInt(RANDOM_NUMBER_BOUND);
            boolean isEven = number % 2 == 0;
            String answer = isEven ? "yes" : "no";
            answers[i][0] = String.valueOf(number);
            answers[i][1] = answer;
        }
        return answers;
    }
}
