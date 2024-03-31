package baseball.service;

import static baseball.view.OutputView.printRestartGameMessage;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballGame {
    private final Computer computer;
    private final Player player;
    private final CountResult countResult;

    public BaseballGame(Computer computer, Player player, CountResult countResult) {
        this.computer = computer;
        this.player = player;
        this.countResult = countResult;
    }

    public void playGame() {

        do {
            OutputView.printStartMessage();
            processGame();
        } while (askRestartGame());
    }

    public void processGame() {
        List<Integer> computerNumber = computer.generateRandomNumber();
        List<Integer> playerNumber;
        do {
            playerNumber = player.inputPlayerNumber();

            int countStrikes = countResult.countStrikes(playerNumber, computerNumber);
            int countBalls = countResult.countBalls(playerNumber, computerNumber);

            OutputView.printResultMessage(countStrikes, countBalls);

        } while (!countResult.judgementEndGame(playerNumber, computerNumber));

        OutputView.printEndGameMessage();
    }

    public boolean askRestartGame() {
        printRestartGameMessage();
        int answerNumber = Integer.parseInt(Console.readLine());

        if (answerNumber != 1 && answerNumber != 2) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
        return answerNumber == 1;
    }
}
