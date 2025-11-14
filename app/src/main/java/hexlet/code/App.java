package hexlet.code;

import hexlet.code.games.Even;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
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
            Even.playEvenGame();
        }
    }

    private App() {

    }
}
