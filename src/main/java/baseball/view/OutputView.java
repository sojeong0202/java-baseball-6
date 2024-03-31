package baseball.view;

import baseball.model.Player;
import camp.nextstep.edu.missionutils.Console;

public class OutputView {

    private static final String OUTPUT_BALL_MESSAGE = "볼";
    private static final String OUTPUT_STRIKE_MESSAGE = "스트라이크";
    private static final String OUTPUT_NOTHING_MESSAGE = "낫싱";


    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printEndGameMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printRestartGameMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    // 결과 값 출력
    public static void printResultMessage(int strikes, int balls) {
        if (strikes > 0 && balls > 0) {
            System.out.println(balls + OUTPUT_BALL_MESSAGE + strikes + OUTPUT_STRIKE_MESSAGE);
        }
        if (strikes == 0 && balls > 0) {
            System.out.println(balls + OUTPUT_BALL_MESSAGE);
        }
        if (strikes > 0 && balls == 0) {
            System.out.println(strikes + OUTPUT_STRIKE_MESSAGE);
        }
        if (strikes == 0 && balls == 0) {
            System.out.println(OUTPUT_NOTHING_MESSAGE);
        }
    }

}