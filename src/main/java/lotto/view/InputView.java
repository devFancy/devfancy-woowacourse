package lotto.view;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }
    public String readInputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }
    public String readInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
