package lotto.domain;

import static lotto.util.Validate.*;
import static lotto.view.InputView.*;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static int paid;
    private static List<Integer> winningNumber = new ArrayList<>();
    private static int bonusNumber;

    public void getInputMoney() {
        String money = readInputMoney();
        checkInputMoney(money);
        this.paid = Integer.parseInt(money);
    }

    public int getMoney() {
        return paid;
    }

    public void inputWinningNumber() {
        String winningInput = readInputWinningNumber();
        List<String> numbers = List.of(winningInput.split(","));
        checkWinningNumberInfo(numbers);
        for (String str : numbers) {
            winningNumber.add(Integer.parseInt(str));
        }
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public void inputBonusNumber() {
        String bonusInput = readInputBonusNumber();
        checkBonusNumberInfo(bonusInput, winningNumber);
        bonusNumber = Integer.parseInt(bonusInput);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
