public class SelfEmployedClient extends Client {

    private final double BIG_COMMISSION = 0.01;
    private final double SMALL_COMMISSION = 0.005;
    private final int MONEY_AMOUNT = 1000;

    @Override
    public double checkClientsAccount() {
        System.out.println("Остаток на счете : " + clientAccount);
        return clientAccount;
    }

    @Override
    public double depositMoney(double deposit) {
        double commission = 0;
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
        System.out.println("Сумма снятия " + withdraw + " RUB");
        return super.withdrawMoney(withdraw);
    }
}