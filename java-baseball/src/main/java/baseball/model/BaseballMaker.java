package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class BaseballMaker {
    private final BaseballRandomNumberGenerator baseballRandomNumberGenerator;
    private static final int NUMBER_SIZE = 3;

    public BaseballMaker(BaseballRandomNumberGenerator baseballRandomNumberGenerator) {
        this.baseballRandomNumberGenerator = baseballRandomNumberGenerator;
    }

    public List<Integer> makeNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_SIZE) {
            int randomNumber = baseballRandomNumberGenerator.generate();
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
