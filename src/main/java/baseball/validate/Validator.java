package baseball.validate;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {

    private static final int INPUT_NUMBER_LENGTH = 3;

    public static void validateInputNumber(String input) {
        // null 값 검증
        if (input == null) {
            throw new IllegalArgumentException("입력 값이 null이 될 수 없습니다.");
        }
        // 3자리 검증
        if (input.length() != INPUT_NUMBER_LENGTH) {
            throw new IllegalArgumentException("입력 값이 3자리가 아닙니다.");
        }
        // 중복된 수 검증
        if (hasDuplicateNumber(input)) {
            throw new IllegalArgumentException("입력 값이 중복되었습니다.");
        }
        // 요구조건 검증
        if (!isRequirementNumber(input)) {
            throw new IllegalArgumentException("입력 값이 범위에 맞지 않습니다.");
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
