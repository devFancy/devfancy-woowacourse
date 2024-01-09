package baseball.view;

import baseball.util.Validate;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final Validate validate = new Validate();
    private static final OutputView outputView = new OutputView();

    public String readNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();
        validate.validationNumber(number);
        return number;
    }

    public int readRestartNumber() {
        outputView.printRestartOrEnd();
        String input = Console.readLine();
        int number = Integer.parseInt(input);
        return number;
    }
}
