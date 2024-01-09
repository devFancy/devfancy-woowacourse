package lotto.domain;

public enum Rank {
        RANK1(200000000),
        RANK2(30000000),
        RANK3(1500000),
        RANK4(50000),
        RANK5(5000),
        RANK6(0);

        private int reward;

        public int getReward() {
            return reward;
        }

        Rank(int reward) {
            this.reward = reward;
        }
    }