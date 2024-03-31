package baseball.util;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import static baseball.util.ExceptionHandler.Exception;
import static baseball.util.ErrorMessage.*;

public class Validator {

    private static final int INPUT_NUMBER_LENGTH = 3;

    public static void validateInputNumber(String input) {
        // null 값 검증
        if (input == null) {
            Exception(INPUT_NUMBER_NOT_NULL);
        }
        // 3자리 검증
        if (input.length() != INPUT_NUMBER_LENGTH) {
            Exception(INPUT_NUMBER_NOT_3_DIGIT);
        }
        // 중복된 수 검증
        if (hasDuplicateNumber(input)) {
            Exception(INPUT_NUMBER_DUPLICATE);
        }
        // 요구조건 검증
        if (!isRequirementNumber(input)) {
            Exception(INPUT_NUMBER_NOT_RANGE);
        }

    }

    private static boolean hasDuplicateNumber(String input) {
        Set<Character> characterSet = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!characterSet.add(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isRequirementNumber(String input) {
        return Pattern.matches("^[1-9]{3}$", input);
    }
}
