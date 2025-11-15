package hexlet.code;

import hexlet.code.games.*;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class App {
    private static final Map<Integer, Game> GAME_NUMBER_TO_GAME = Map.of(
            2, new Even(),
            3, new Calculator(),
            4, new Gcd(),
            5, new Progression()
    );

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calculator");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        Scanner scanner = new Scanner(System.in);
        int gameNumber = scanner.nextInt();
        if (gameNumber != 0) {
            System.out.println("Welcome to the Brain Games!");
        }
        Optional<Game> game = Optional.empty();
        if (gameNumber == 1) {
            Cli.askUserName();
        } else {
            game = Optional.ofNullable(GAME_NUMBER_TO_GAME.get(gameNumber));
        }
        game.ifPresent(Engine::startGame);
    }

    private App() {

    }
}
