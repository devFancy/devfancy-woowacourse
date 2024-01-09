package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lotto.model.Lotto;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    LottoRandomNumberGenerator lottoRandomNumberGenerator;
    List<Lotto> lottos = new ArrayList<>();

    public LottoMachine(LottoRandomNumberGenerator lottoRandomNumberGenerator) {
        this.lottoRandomNumberGenerator = lottoRandomNumberGenerator;
    }

    public List<Lotto> makeNumber(int money) {
        int count = money / LOTTO_PRICE;
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = lottoRandomNumberGenerator.generate();
            List<Integer> sortedLottoNumbers = numbers.stream().sorted().collect(Collectors.toList());
            Lotto lotto = new Lotto(sortedLottoNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }
}
