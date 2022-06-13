import java.util.List;

public class CashRegister implements CashAccepter, BankCardAccepter {

    private int totalToPay;

    public CashRegister() {
        totalToPay = 0;
    }

    public int getTotalToPay() {
        return totalToPay;
    }

    @Override
    public boolean getFromCard(BankCard card) {
        if (card.moneyBalance >= totalToPay) {
            card.drawFromBalance(totalToPay);
            totalToPay = 0;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean getCash(int money) {
        if (money >= totalToPay) {
            totalToPay = 0;
            return true;
        } else {
            return false;
        }
    }

    public boolean calculateTotal (Basket basket) {
        int total = 0;

        for (Product product : basket.content.keySet()) {
            total += product.getPrice() * basket.content.get(product);
        }
        this.totalToPay = total;
        return true;
    }
}
