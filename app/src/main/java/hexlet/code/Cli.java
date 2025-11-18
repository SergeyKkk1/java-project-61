package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String askUserName() {
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.printf("Hello, %s!\n", name);
        return name;
    }

    private Cli() {
    }
}
