package bridge;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeGameTest {
    BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("입력 받은 다리 길이 3이상 20이하의 숫자가 아니면 오류")
    @ParameterizedTest
    @ValueSource(strings = {"100", "abc", "z", "2", "23", " ", ""})
    void NumberRange3over20under(String input) {
        Assertions.assertThatThrownBy(()->
            bridgeGame.init(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 받은 다리 길이 3이상 20이하의 숫자 확인")
    @ParameterizedTest
    @ValueSource(strings = {"3", "5", "10", "15", "17", "19", "20"})
    void NumberRange3over20underOk(String input) {
        assertDoesNotThrow(()->
            bridgeGame.init(input));
    }

    @DisplayName("입력 받은 이동 방향이 \"U\" 와 \"D\" 둘 중 하나가 아니면 오류")
    @ParameterizedTest
    @ValueSource(strings = {"A", "UU", "DD", "Z", " ", ""})
    void moveDirection(String moveDirection) {
        Assertions.assertThatThrownBy(()->
            bridgeGame.move(moveDirection))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 받은 이동 방향이 \"U\" 와 \"D\" 둘 중 하나인지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void moveDirectionOK(String direction) throws NoSuchFieldException, IllegalAccessException {
        Field bridge = bridgeGame.getClass().getDeclaredField("bridge");
        bridge.setAccessible(true);
        List<String> answerBridge = List.of("U","D","D");
        bridge.set(bridgeGame,new Bridge(answerBridge));
        assertDoesNotThrow(()->
            bridgeGame.move(direction));
    }

    @DisplayName("게임을 다시 시도할지 여부에 대한 입력 받은 이동 방향이 \"R\" 와 \"Q\" 둘 중 하나가 아니면 오류")
    @ParameterizedTest
    @ValueSource(strings = {"A", "RR", "QQ", "Z", "ID", "RQ"})
    void retryOption(String select) {
        Assertions.assertThatThrownBy(()->
            bridgeGame.retry(select))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임을 다시 시도할지 여부에 대한 입력 받은 이동 방향이 \"R\" 와 \"Q\" 둘 중 하나인지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"R","Q"})
    void retryOptionOk(String select) {
        assertDoesNotThrow(()->
            bridgeGame.retry(select));
    }
}