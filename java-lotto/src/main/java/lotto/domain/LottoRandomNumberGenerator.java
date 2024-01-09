package lotto.domain;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoRandomNumberGenerator implements LottoNumberGenerator {
    private static final int NUMBER_MIN = 1;
    private static final int NUMBER_MAX = 45;
    private static final int NUMBER_COUNT = 6;

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(NUMBER_MIN, NUMBER_MAX, NUMBER_COUNT);
    }
}
