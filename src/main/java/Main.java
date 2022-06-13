import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ProductHandler stock = Stock.getInstance();
        CashRegister cashRegister = new CashRegister();
        Consumer consumer = new Consumer(2000, new BankCard("124321512", "VIP Consumer", 5000));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Добрый день!");
        System.out.println("Для вывода списка товара введите: ?");
        System.out.println("Для добавления товара в корзину введение его название и через пробел желаемое количество");
        System.out.println("Для перехода к оплате введите end");

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            if (input.equals("?")) {
                System.out.println(stock.getAvailableProducts().toString());
                continue;
            }

            try {
                String[] parts = input.split(" ");
                String productName = parts[0];
                int productCount = Integer.parseInt(parts[1]);
                if (consumer.getBasket().add(stock.findProductByName(productName), productCount)) {
                    System.out.println("Товар добавлен");
                } else {
                    System.out.println("Столько товара нет");
                }


            } catch (RuntimeException exception) {
                System.out.println("Что-то пошло не так. Попробуйте еще раз");
            }

            System.out.println(stock.howMuchLeft(stock.findProductByName("Хлеб")));

        }
        cashRegister.calculateTotal(consumer.getBasket());

        System.out.println("К оплате " + cashRegister.getTotalToPay());
        System.out.println("Карта или наличные? Введите 1 или 2 соответственно");
        System.out.println("Для отказа от покупки введите 0");
        String decision;
        while (true) {
            decision = scanner.nextLine();
            if (decision.equals("1") || decision.equals("2") || decision.equals("0")) {
                break;
            } else {
                System.out.println("Некорректный ввод. Попробуйте еще раз");
            }
        }

        switch (decision) {
            case "1": {
                cashRegister.getCash(consumer.payMoney(cashRegister.getTotalToPay()));
                System.out.println("Осталось наличными: " + consumer.getMoney());
                break;
            }
            case "2": {
                cashRegister.getFromCard(consumer.getBankCard());
                System.out.println("Осталось на карте: " + consumer.getBankCard().getMoneyBalance());
                break;
            }
            case "0": {
                break;
            }
        }


        scanner.close();
    }
}
