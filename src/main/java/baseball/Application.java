package baseball;


import java.util.List;

public class Application {
    public static void main(String[] args) {
        RandomNumber randomNumber = new RandomNumber();
        List<Integer> numbers = randomNumber.generateRandomNumber();
    }
}
