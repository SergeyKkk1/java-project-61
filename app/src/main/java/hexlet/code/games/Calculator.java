package hexlet.code.games;

import hexlet.code.Engine;

import java.util.List;

public final class Calculator extends Game {
    private static final List<String> AVAILABLE_OPERATIONS = List.of("+", "-", "*");
    private static final int RANDOM_NUMBER_BOUND = 100;
    private static final String CALCULATOR_GAME_QUESTION = "What is the result of the expression?";

    private Calculator() {
    }

    public static void play() {
        Engine.startGame(CALCULATOR_GAME_QUESTION, generateQuestionToAnswer());
    }

    private static String[][] generateQuestionToAnswer() {
        String[][] questionToAnswer = new String[QUESTIONS_LIMIT][2];
        for (int i = 0; i < QUESTIONS_LIMIT; i++) {
            int firstNumber = RANDOM.nextInt(RANDOM_NUMBER_BOUND);
            int secondNumber = RANDOM.nextInt(RANDOM_NUMBER_BOUND);
            int operationIndex = RANDOM.nextInt(AVAILABLE_OPERATIONS.size());
            String operation = AVAILABLE_OPERATIONS.get(operationIndex);
            questionToAnswer[i][0] = String.format("%s %s %s", firstNumber, operation, secondNumber);
            questionToAnswer[i][1] = String.valueOf(calculateCorrectAnswer(firstNumber, secondNumber, operation));
        }
        return questionToAnswer;
    }

    private static int calculateCorrectAnswer(int firstNumber, int secondNumber, String operation) {
        return switch (operation) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            default -> throw new IllegalStateException("This operation is currently unsupported" + operation);
        };
    }
}
