package lotto.model;

import java.util.List;
import java.util.Set;
import lotto.util.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6)
            throw new IllegalArgumentException(ExceptionMessage.ERROR_MESSAGE + ExceptionMessage.ERROR_WINNING_NUMBER_COUNT);
        if (Set.copyOf(numbers).size() != 6)
            throw new IllegalArgumentException(ExceptionMessage.ERROR_MESSAGE + ExceptionMessage.ERROR_WINNING_NUMBER_NO_DUPLICATE);
        for (int num : numbers) {
            if (num < 1 || num > 45)
                throw new IllegalArgumentException(ExceptionMessage.ERROR_MESSAGE + ExceptionMessage.ERROR_LOTTO_NUMBER_RANGE);
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
