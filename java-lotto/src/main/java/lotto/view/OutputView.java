package lotto.view;

import java.util.List;

import lotto.model.Lotto;

public class OutputView {
    public static void printLottoMoneyCount(List<Lotto> lottos) {
        printEnter();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printEnter() {
        System.out.println();
    }

    public static void printResult(int revenue, int[] countRank, int paid) {
        String rate = String.format("%.1f", (double)revenue * 100 / paid);
        printEnter();
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + countRank[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + countRank[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + countRank[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countRank[2] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + countRank[1] + "개");
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }

    public static void printErrorMessage(String e) {
        System.out.println(e);
    }
}