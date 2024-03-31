package baseball;


import baseball.model.Player;
import baseball.util.RandomNumber;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        RandomNumber randomNumber = new RandomNumber();
        List<Integer> numbers = randomNumber.generateRandomNumber();

        Player player = new Player();
        player.inputPlayerNumber();


    }
}

