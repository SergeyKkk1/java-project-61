package hexlet.code.games;

public class Even extends Game {
    private static final int RANDOM_NUMBER_BOUND = 1000;

    @Override
    public void printTask() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    @Override
    public boolean askQuestion() {
        int number = RANDOM.nextInt(RANDOM_NUMBER_BOUND);
        printQuestionDetails(String.valueOf(number));
        String playerAnswer = SCANNER.next();
        boolean isEven = number % 2 == 0;
        boolean isCorrectAnswer = "yes".equals(playerAnswer) && isEven || "no".equals(playerAnswer) && !isEven;
        if (!isCorrectAnswer) {
            String correctAnswer = isEven ? "yes" : "no";
            printWrongAnswerDetails(playerAnswer, correctAnswer);
        }
        return isCorrectAnswer;
    }
}
