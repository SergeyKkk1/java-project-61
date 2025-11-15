package hexlet.code.games;

import java.util.ArrayList;
import java.util.List;

public class Progression extends Game {

    private static final int MAX_PROGRESSION_STEP = 15;
    private static final int ELEMENTS_IN_PROGRESSION = 10;
    private static final int MIN_PROGRESSION_STEP = 1;

    @Override
    public void printTask() {
        System.out.println("What number is missing in the progression?");
    }

    @Override
    public boolean askQuestion() {
        List<String> progressionElements = generateProgressionElements();
        int missingElementIndex = RANDOM.nextInt(progressionElements.size());
        String missingElement = progressionElements.get(missingElementIndex);
        progressionElements.set(missingElementIndex, "..");
        String progressionElementsString = String.join(" ", progressionElements);
        printQuestionDetails(progressionElementsString);
        int playerAnswer = SCANNER.nextInt();
        int correctAnswer = Integer.parseInt(missingElement);
        boolean isCorrectAnswer = correctAnswer == playerAnswer;
        if (!isCorrectAnswer) {
            printWrongAnswerDetails(String.valueOf(playerAnswer), String.valueOf(correctAnswer));
        }
        return isCorrectAnswer;
    }

    private List<String> generateProgressionElements() {
        int progressionStep = RANDOM.nextInt(MIN_PROGRESSION_STEP, MAX_PROGRESSION_STEP);
        List<String> progressionElements = new ArrayList<>();
        for (int i = 0; i < ELEMENTS_IN_PROGRESSION; i++) {
            progressionElements.add(String.valueOf(progressionStep + i * progressionStep));
        }
        return progressionElements;
    }
}
