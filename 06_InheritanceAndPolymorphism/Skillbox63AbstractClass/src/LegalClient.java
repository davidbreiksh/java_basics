public class LegalClient extends Client {

    private final double COMMISSION_PERCENTAGE = 0.01;

    @Override
    public double checkClientsAccount() {
        System.out.println("Остаток на счете : " + clientAccount + " RUB");
        return clientAccount;
    }

    @Override
    public double withdrawMoney(double withdraw) {
        double commission = withdraw * COMMISSION_PERCENTAGE;
        withdraw = commission + withdraw;
        System.out.println("Комиссия : " + commission + " RUB");
        System.out.println("Сумма снятия с коммиссией " + withdraw + " RUB");
        return super.withdrawMoney(withdraw);
    }
}