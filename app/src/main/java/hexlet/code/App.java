package hexlet.code;

import hexlet.code.games.Calculator;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public final class App {

    private static final int EVEN_GAME_NUMBER = 2;
    private static final int CALCULATOR_GAME_NUMBER = 3;
    private static final int GCD_GAME_NUMBER = 4;
    private static final int PROGRESSION_GAME_NUMBER = 5;
    private static final int PRIME_GAME_NUMBER = 6;

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calculator");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        Scanner scanner = new Scanner(System.in);
        int gameNumber = scanner.nextInt();
        if (gameNumber != 0) {
            System.out.println("Welcome to the Brain Games!");
        }
        if (gameNumber == 1) {
            Cli.askUserName();
        } else if (gameNumber == EVEN_GAME_NUMBER) {
            Even.play();
        } else if (gameNumber == CALCULATOR_GAME_NUMBER) {
            Calculator.play();
        } else if (gameNumber == GCD_GAME_NUMBER) {
            Gcd.play();
        } else if (gameNumber == PROGRESSION_GAME_NUMBER) {
            Progression.play();
        } else if (gameNumber == PRIME_GAME_NUMBER) {
            Prime.play();
        }
    }

    private App() {

    }
}
