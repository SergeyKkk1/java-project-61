package hexlet.code;

import hexlet.code.games.Calculator;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
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
        } else if (gameNumber == 2) {
            Even.play();
        } else if (gameNumber == 3) {
            Calculator.play();
        } else if (gameNumber == 4) {
            Gcd.play();
        } else if (gameNumber == 5) {
            Progression.play();
        } else if (gameNumber == 6) {
            Prime.play();
        }
    }

    private App() {

    }
}
