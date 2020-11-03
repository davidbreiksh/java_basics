public class SelfEmployedClient extends Client {

    private final double BIG_COMMISSION = 0.01;
    private final double SMALL_COMMISSION = 0.005;
    private double commission;
    private final int MONEY_AMOUNT = 1000;

    @Override
    public double checkClientsAccount() {
        System.out.println(clientAccount);
        return clientAccount;
    }

    @Override
    public double depositMoney(double deposit) {
        if (deposit >= MONEY_AMOUNT) {
            commission = deposit * SMALL_COMMISSION;
            System.out.println("Комиссия за операцию : " + commission + " Рублей.Сумма с учетом комиссии : " + (deposit - commission) + " RUB");
            return clientAccount = clientAccount + (deposit - commission);
        }
        if (deposit < MONEY_AMOUNT) {
            commission = deposit * BIG_COMMISSION;
            System.out.println("Комиссия за операцию : " + commission + " Рублей.Сумма с учетом комиссии : " + (deposit - commission) + " RUB");
        }
        return clientAccount = clientAccount + (deposit - commission);
    }

    @Override
    public double withdrawMoney(double withdraw) {
        return super.withdrawMoney(withdraw);
    }
}