package hexlet.code;

import hexlet.code.games.Game;

public class Engine {
    private static final int CORRECT_ANSWERS_LIMIT = 3;

    private Engine() {
    }

    public static void startGame(Game game) {
        String userName = Cli.askUserName();
        game.printTask();
        int correctAnswers = 0;
        while (game.askQuestion() && ++correctAnswers < CORRECT_ANSWERS_LIMIT) {
            System.out.println("Correct!");
        }
        if (correctAnswers == CORRECT_ANSWERS_LIMIT) {
            System.out.printf("Congratulations, %s!\n", userName);
        } else {
            System.out.printf("Let's try again, %s!\n", userName);
        }
    }
}
