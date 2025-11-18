package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;

public class Progression extends Game {

    private static final int MIN_PROGRESSION_STEP = 1;
    private static final int MAX_PROGRESSION_STEP = 15;
    private static final int MIN_ELEMENTS_IN_PROGRESSION = 5;
    private static final int MAX_ELEMENTS_IN_PROGRESSION = 10;
    private static final int MAX_PROGRESSION_INITIAL_VALUE = 20;
    private static final String PROGRESSION_GAME_QUESTION = "Find the greatest common divisor of given numbers.";

    private Progression() {
    }

    public static void play() {
        Engine.startGame(PROGRESSION_GAME_QUESTION, generateQuestionToAnswer());
    }

    private static String[][] generateQuestionToAnswer() {
        String[][] questionToAnswer = new String[QUESTIONS_LIMIT][2];
        for (int i = 0; i < QUESTIONS_LIMIT; i++) {
            int progressionLength = RANDOM.nextInt(MIN_ELEMENTS_IN_PROGRESSION, MAX_ELEMENTS_IN_PROGRESSION);
            int progressionStep = RANDOM.nextInt(MIN_PROGRESSION_STEP, MAX_PROGRESSION_STEP);
            int initialValue = RANDOM.nextInt(MAX_PROGRESSION_INITIAL_VALUE);
            List<String> progressionElements = generateProgressionElements(initialValue, progressionStep, progressionLength);
            int missingElementIndex = RANDOM.nextInt(progressionElements.size());
            String missingElement = progressionElements.get(missingElementIndex);
            progressionElements.set(missingElementIndex, "..");
            String progressionElementsString = String.join(" ", progressionElements);
            questionToAnswer[i][0] = progressionElementsString;
            questionToAnswer[i][1] = missingElement;
        }
        return questionToAnswer;
    }

    private static List<String> generateProgressionElements(int initialValue, int progressionStep, int length) {
        List<String> progressionElements = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            progressionElements.add(String.valueOf(initialValue + i * progressionStep));
        }
        return progressionElements;
    }
}
