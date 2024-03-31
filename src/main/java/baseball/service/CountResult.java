package baseball.service;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class CountResult {

    private static final int FULL_STRIKE_COUNT = 3;

    // 스트라이크 개수
    public int countStrikes(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        int count = 0;

        if (Objects.equals(playerNumbers.get(0), computerNumbers.get(0))) {
            count++;
        }

        if (Objects.equals(playerNumbers.get(1), computerNumbers.get(1))) {
            count++;
        }

        if (Objects.equals(playerNumbers.get(2), computerNumbers.get(2))) {
            count++;
        }

        return count;
    }

    // 볼 개수
    public int countBalls(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        int strikes = countStrikes(playerNumbers, computerNumbers);
        List<Integer> matchList = playerNumbers.stream().filter(o -> computerNumbers.stream()
                .anyMatch(Predicate.isEqual(o))).toList();
        return matchList.size() - strikes;
    }

    // 정답 판정
    public boolean judgementEndGame(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        int strikeCount = this.countStrikes(playerNumbers, computerNumbers);
        return strikeCount == FULL_STRIKE_COUNT;
    }
}
