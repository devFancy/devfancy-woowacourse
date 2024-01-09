package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballRandomNumberGenerator implements BaseballNumberGenerator {
    private static final int NUMBER_MIN = 1;
    private static final int NUMBER_MAX = 9;

    public int generate() {
        return Randoms.pickNumberInRange(NUMBER_MIN, NUMBER_MAX);
    }
}
