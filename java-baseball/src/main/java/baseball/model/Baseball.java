package baseball.model;

import java.util.List;
import java.util.stream.IntStream;

public class Baseball {
    List<Integer> baseball;

    public Baseball(List<Integer> baseball) {
        this.baseball = baseball;
    }

    public BaseballGameResult compare(Baseball inputNumbers) {
        return new BaseballGameResult(countBall(inputNumbers), countStrike(inputNumbers));
    }

    private int countBall(Baseball inputNumbers) {
        int ball = 0;
        for (int i = 0; i < baseball.size(); i++) {
            if (inputNumbers.isContainNumber(baseball.get(i), i)) {
                ball++;
            }
        }
        return ball;
    }

    private int countBall2(Baseball inputNumbers) {
        return (int)IntStream.range(0, baseball.size())
            .filter(index -> inputNumbers.isContainNumber(baseball.get(index), index))
            .count();
    }

    private boolean isContainNumber(int number, int position) {
        return position != baseball.indexOf(number) && baseball.contains(number);
    }

    private int countStrike(Baseball inputNumbers) {
        int strike = 0;
        for (int i = 0; i < baseball.size(); i++) {
            if (inputNumbers.isSameNumber(baseball.get(i), i)) {
                strike++;
            }
        }
        return strike;
    }

    private boolean isSameNumber(int number, int position) {
        return position == baseball.indexOf(number);
    }
}
