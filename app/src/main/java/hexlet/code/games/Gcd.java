package hexlet.code.games;

public class Gcd extends Game {
    private static final int RANDOM_NUMBER_BOUND = 30;

    @Override
    public void printTask() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    @Override
    public boolean askQuestion() {
        int firstNumber = RANDOM.nextInt(RANDOM_NUMBER_BOUND);
        int secondNumber = RANDOM.nextInt(RANDOM_NUMBER_BOUND);
        printQuestionDetails(String.format("%s %s ", firstNumber, secondNumber));
        int playerAnswer = SCANNER.nextInt();
        int correctAnswer = calculateCorrectAnswer(firstNumber, secondNumber);
        boolean isCorrectAnswer = correctAnswer == playerAnswer;
        if (!isCorrectAnswer) {
            printWrongAnswerDetails(String.valueOf(playerAnswer), String.valueOf(correctAnswer));
        }
        return isCorrectAnswer;

    }

    private int calculateCorrectAnswer(int firstNumber, int secondNumber) {
        int result = Math.min(firstNumber, secondNumber);
        while (result > 0) {
            if (firstNumber % result == 0 && secondNumber % result == 0) {
                break;
            }
            result--;
        }

        return result;
    }
}
