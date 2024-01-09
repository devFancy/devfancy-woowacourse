package bridge;



import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeTest {

    List<String> answerBridge = List.of("U","U","D","D","U","D");
    Bridge bridge = new Bridge(answerBridge);

    @ParameterizedTest
    @CsvSource({"0,U,true", "1,U,true", "2,U,false", "3,D,true", "4,U,true", "5,U,false"})
    void isRightDirection(int index, String direction, boolean result) {
        Assertions.assertThat(bridge.isRightDirection(index, direction)).isEqualTo(result);
    }


}