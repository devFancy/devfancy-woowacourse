package bridge;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("입력 받은 크기의 다리 길이를 생성하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 15, 20, 1, 30})
    void makeBridge(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        assertEquals(bridge.size(), size);
    }
}