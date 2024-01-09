# 🚀미션 - 로또

---

### 💙구현 목표

- 로또 게임 기능을 구현해야 한다.

### 📜구현 동작

1. 구입 금액을 입력한다.
2. 발행한 로또 수량 및 번호를 출력한다.
3. 중복되지 않는 당첨 번호 6개와 보너스 번호 1개를 입력한다.
4. 사용자가 구매한 로또 번호와 당첨 번호를 비교한다.
5. 당첨 통계를 출력하고 게임을 종료한다.

---

## 🔍구현 로직

- ### main diagram

- [x] LottoGame : 로또 게임을 관리하는 로직
  - [x] 사용자가 구매한 로또 번호와 당첨 번호를 비교하는 기능
  - [x] 당첨 통계를 출력하는 기능
- [x] User : 사용자로부터 입력 받는 로직
  - [x] 구매 금액 입력받는 기능
  - [x] 중복되지 않는 당첨 번호 6개와 보너스 번호 1개를 입력받는 기능
- [x] Lotto : 로또 값(데이터)를 저장하는 로직
- [x] LottoMachine : 랜덤 값을 저장하는 로직
- [x] LottoRandomNumberGenerator : 랜덤 값 추출하는 로직
- [x] LottoNumberGenerator : LottoRandomNumberGenerator 의 인터페이스 역할

- ### utils diagram

- [x] Validate : 유효성 검사
- [x] ExceptionMessage : 예외 메세지

- ### view diagram

- [x] InputView : 입력 부분
- [x] OutputView : 출력 부분

---

## ✅ 기능 목록 checkList

- [x] 1.로또 구입 금액을 입력 받는다.
  - [x] 구입 금액에 해당하는 만큼 (랜덤으로)로또를 발행한다.
- [x] 2.발행한 로또 수량 및 번호를 출력한다.
  - [x] 로또 번호는 오름차순으로 정렬하여 보여준다.
  - [x] 번호는 쉼표(,)를 기준으로 구분한다.
- [x] 3.중복되지 않는 당첨 번호 6개와 보너스 번호를 입력 받는다.
- [x] 4.사용자가 구매한 로또 번호와 당첨 번호를 비교한다.
- [x] 5.당첨 통계을 출력하고 게임을 종료한다.
  - [x] 당첨 내역을 출력한다.
  - [x] 수익률을 출력한다.(수익률은 소수점 둘째 자리에서 반올림한다.)



## ✅ 예외 처리

- [x] 로또 구입급액을 입력할 때 잘못된 값을 입력하는 경우
  - [x] 구입금액을 입력받을 때 1,000원으로 나누어 떨어지지 않는 경우
  - [x] 숫자가 아닌 문자로 입력한 경우
- [x] 로또 번호를 입력할 때 잘못된 번호로 입력하는 경우
  - [x] 당첨 번호 개수가 6개가 아닌 경우
  - [x] 당첨 번호가 중복되는 경우
  - [x] 로또 번호(당첨 번호와 보너스 번호)의 숫자 범위가 1부터 45 사이가 아닌 경우
  - [x] 당첨 번호와 보너스 번호가 중복되는 경우



## ✅ 테스트 기능 목록

- domain 패키지
  - UserTest
    - [x] 당첨 번호 유효성 검사 - 갯수가 6개가 아닌 경우, 숫자가 아닌 경우, 중복인 경우, 숫자 범위를 벗어난 경우
    - [x] 보너스 번호 유효성 검사 - 숫자가 아닌 경우, 당첨 번호와 중복인 경우, 숫자 범위를 벗어난 경우
- ApplicationTest
  - [x] 전체 기능 확인
  - [x] 에러 처리 확인
- LottoTest
  - [x] 로또 번호 개수가 6개가 아닌 경우
  - [x] 로또 번호가 중복인 경우
  - [x] 로또 번호 범위가 1~45가 아닌 경우


### 폴더 구조

```
└── src
    ├── main
    │   └── java
    │       └── lotto
    │           ├── Application.java
    │           ├── controller
    │           │   └── LottoGame.java
    │           ├── domain
    │           │   ├── LottoMachine.java
    │           │   ├── LottoNumberGenerator.java
    │           │   ├── LottoRandomNumberGenerator.java
    │           │   ├── Rank.java
    │           │   └── User.java
    │           ├── model
    │           │   └── Lotto.java
    │           ├── util
    │           │   ├── ExceptionMessage.java
    │           │   └── Validate.java
    │           └── view
    │               ├── InputView.java
    │               └── OutputView.java
    └── test
        └── java
            └── lotto
                ├── ApplicationTest.java
                ├── LottoTest.java
                └── domain
                    └── UserTest.java

```