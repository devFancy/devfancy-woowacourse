package lotto.util;

import static lotto.util.ExceptionMessage.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {

    public int checkInputMoney(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_ONLY_NUMBER);
        }
        int money = Integer.parseInt(input);
        if(money % 1000 != ZERO) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_LOTTO_PRICE);

        }
        return money;
    }
    public void checkWinningNumberInfo(List<String> numbers) {
        checkWinningNumberSize(numbers);
        checkWinningNumberNoDuplicate(numbers);
        checkWinningNumberRange(numbers);
    }

    private void checkWinningNumberSize(List<String> numbers) {
        if(numbers.size() != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_WINNING_NUMBER_COUNT);
        }
    }

    private void checkWinningNumberNoDuplicate(List<String> numbers) {
        Set<String> numbersNoDuplicate = new HashSet<>(numbers);
        if(numbersNoDuplicate.size() != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_WINNING_NUMBER_NO_DUPLICATE);
        }
    }

    private void checkWinningNumberRange(List<String> numbers) {
        for(int i = 0; i < numbers.size(); i++) {
            String number = numbers.get(i);
            if(!number.matches("^[0-9]*$")) {
                throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_ONLY_NUMBER);
            }
            int num = Integer.parseInt(numbers.get(i));
            if(num < LOTTO_NUMBER_RANGE_MIN || num > LOTTO_NUMBER_RANGE_MAX) {
                throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_LOTTO_NUMBER_RANGE);
            }
        }
    }

    public void checkBonusNumberInfo(String bonusInput, List<Integer> winningNumber) {
        if(!bonusInput.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_ONLY_NUMBER);
        }
        int bonusNumber = Integer.parseInt(bonusInput);
        if(winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_NUMBER_NO_DUPLICATE);
        }
        if(bonusNumber < LOTTO_NUMBER_RANGE_MIN || bonusNumber > LOTTO_NUMBER_RANGE_MAX) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_LOTTO_NUMBER_RANGE);
        }
    }
}
