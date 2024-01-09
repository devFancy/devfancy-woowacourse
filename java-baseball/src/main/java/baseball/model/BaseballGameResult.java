package baseball.model;

public class BaseballGameResult {
    private static final int ALL_SUCCESS = 3;
    private int ballCount;
    private int strikeCount;

    public BaseballGameResult(int ball, int strike) {
        this.ballCount = ball;
        this.strikeCount = strike;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isSuccess() {
        if (strikeCount == ALL_SUCCESS) {
            return true;
        }
        return false;
    }
}
