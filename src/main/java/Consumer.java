public class Consumer {
    private Basket basket;
    private int money;
    private BankCard bankCard;

    public Consumer(int money, BankCard bankCard) {
        this.basket = new Basket();
        this.money = money;
        this.bankCard = bankCard;
    }

    public int payMoney(int money) {
        if (this.money >= money) {
            this.money -= money;
            return money;
        }
        else {
            return 0;
        }
    }

    public BankCard getBankCard() {
        return bankCard;
    }

    public Basket getBasket() {
        return basket;
    }

    public int getMoney() {
        return money;
    }
}
