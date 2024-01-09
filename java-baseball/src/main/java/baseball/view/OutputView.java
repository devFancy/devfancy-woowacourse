package baseball.view;

import java.util.ArrayList;
import java.util.List;

import baseball.model.BaseballGameResult;

public class OutputView {
    private static final String STRIKE_MESSAGE = "%d스트라이크";
    private static final String BALL_MESSAGE = "%d볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String ALL_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printResult(BaseballGameResult baseballGameResult) {
        int ballCount = baseballGameResult.getBallCount();
        int strikeCount = baseballGameResult.getStrikeCount();
        List<String> result = new ArrayList<>();

        if (ballCount == 0 && strikeCount == 0)
            result.add(NOTHING_MESSAGE);
        if (ballCount != 0)
            result.add(String.format(BALL_MESSAGE, ballCount));
        if (strikeCount != 0)
            result.add(String.format(STRIKE_MESSAGE, strikeCount));

        System.out.println(String.join(" ", result));
    }

    public void printSuccess() {
        System.out.println(ALL_STRIKE_MESSAGE);
    }

    public void printRestartOrEnd() {
        System.out.println(RESTART_OR_END_MESSAGE);
    }
}
