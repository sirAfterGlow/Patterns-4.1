public class BankCard {
    protected String  number;
    protected String cardHolder;
    protected int moneyBalance;

    public BankCard(String number, String cardHolder, int moneyBalance) {
        this.number = number;
        this.cardHolder = cardHolder;
        this.moneyBalance = moneyBalance;
    }

    public String getNumber() {
        return number;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public int getMoneyBalance() {
        return moneyBalance;
    }

    public boolean payToBalance(int money) {
        this.moneyBalance += moneyBalance;
        return true;
    }

    public boolean drawFromBalance (int money) {
        if (this.moneyBalance >= money) {
            moneyBalance -= money;
            return true;
        } else {
            return false;
        }
    }
}
