public class LegalClient extends Client {

    private final double COMMISSION_PERCENTAGE = 0.01;
    private double commission;
    private double finalSum;

    @Override
    public double checkClientsAccount() {
        System.out.println(clientAccount);
        return clientAccount;
    }

    @Override
    public double depositMoney(double deposit) {
        return super.depositMoney(deposit);
    }

    @Override
    public double withdrawMoney(double withdraw) {
        if (withdraw > clientAccount) {
            return super.withdrawMoney(withdraw);
        }
        commission = withdraw * COMMISSION_PERCENTAGE;
        finalSum = commission + withdraw;
        System.out.println("Комиссия за операцию : " + (withdraw * COMMISSION_PERCENTAGE) + " RUB");
        System.out.println("Сумма снятия с учетом комиссии : " + finalSum);
        return  clientAccount = clientAccount - finalSum ;
    }
}