package hexlet.code.games;

import java.util.List;

public class Calculator extends Game {
    private static final List<String> AVAILABLE_OPERATIONS = List.of("+", "-", "*");
    private static final int RANDOM_NUMBER_BOUND = 100;

    @Override
    public void printTask() {
        System.out.println("What is the result of the expression?");
    }

    @Override
    public boolean askQuestion() {
        int firstNumber = RANDOM.nextInt(RANDOM_NUMBER_BOUND);
        int secondNumber = RANDOM.nextInt(RANDOM_NUMBER_BOUND);
        int operationIndex = RANDOM.nextInt(AVAILABLE_OPERATIONS.size());
        String operation = AVAILABLE_OPERATIONS.get(operationIndex);
        printQuestionDetails(String.format("%s %s %s", firstNumber, operation, secondNumber));
        int playerAnswer = SCANNER.nextInt();
        int correctAnswer = calculateCorrectAnswer(firstNumber, secondNumber, operation);
        boolean isCorrectAnswer = correctAnswer == playerAnswer;
        if (!isCorrectAnswer) {
            printWrongAnswerDetails(String.valueOf(playerAnswer), String.valueOf(correctAnswer));
        }
        return isCorrectAnswer;
    }

    private int calculateCorrectAnswer(int firstNumber, int secondNumber, String operation) {
        return switch (operation) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            default -> throw new IllegalStateException("This operation is currently unsupported" + operation);
        };
    }
}
