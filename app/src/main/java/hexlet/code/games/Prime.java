package hexlet.code.games;

public class Prime extends Game {

    private static final int RANDOM_NUMBER_BOUND = 200;

    @Override
    public void printTask() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    @Override
    public boolean askQuestion() {
        int number = RANDOM.nextInt(RANDOM_NUMBER_BOUND);
        printQuestionDetails(String.valueOf(number));
        String playerAnswer = SCANNER.next();
        boolean isPrime = isPrime(number);
        boolean isCorrectAnswer = "yes".equals(playerAnswer) && isPrime || "no".equals(playerAnswer) && !isPrime;
        if (!isCorrectAnswer) {
            String correctAnswer = isPrime ? "yes" : "no";
            printWrongAnswerDetails(playerAnswer, correctAnswer);
        }
        return isCorrectAnswer;

    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        } else if (number == 2) {
            return true;
        } else if (number % 2 == 0) {
            return false;
        } else {
            double sqrted = Math.sqrt(number);
            for (int i = 2; i < sqrted; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
