package baseball.util;

import static baseball.util.ExceptionMessage.*;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Validate {
    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 1;
    private static final int RESTART_NUM = 1;
    private static final int END_NUM = 2;
    private static final int INPUT_LENGTH = 3;

    public void validationNumber(String input) {
        if (checkInputLength(input)) {
            throw new IllegalArgumentException(ERROR_INPUT_SIZE);
        }
        if (!checkDuplicateNumber(input)) {
            throw new IllegalArgumentException(ERROR_NUMBER_SIZE);
        }
        if (!checkNumberRange(input)) {
            throw new IllegalArgumentException(ERROR_NUMBER_RANGE);
        }
    }

    private boolean checkInputLength(String input) {
        return (input.length() != INPUT_LENGTH);
    }

    private boolean checkDuplicateNumber(String input) {
        String[] inputs = input.split("");
        if (inputs.length != Arrays.stream(inputs).distinct().count()) {
            return false;
        }
        return true;
    }

    private boolean checkNumberRange(String input) {
        String[] inputs = input.split("");
        for (String s : inputs) {
            if (Integer.parseInt(s) < MIN_NUMBER || Integer.parseInt(s) > MAX_NUMBER) {
                return false;
            }
        }
        return true;
    }

    private boolean checkNumberRange2(String input) {
        return IntStream.range(0, input.length())
            .noneMatch(
                i -> Character.getNumericValue(input.charAt(i)) < 1 || Character.getNumericValue(input.charAt(i)) > 9);
    }

    public void validationRestartOrEnd(int input) {
        if (input != RESTART_NUM && input != END_NUM) {
            throw new IllegalArgumentException(ERROR_RESTART_OR_END);
        }
    }
}
