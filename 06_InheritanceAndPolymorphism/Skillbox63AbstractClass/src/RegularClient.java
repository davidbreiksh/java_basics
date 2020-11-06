public class RegularClient extends Client {

    @Override
    public double checkClientsAccount() {
        System.out.println("Остаток на счете : " + clientAccount);
        return clientAccount;
    }

    @Override
    public double depositMoney(double deposit) {
        return super.depositMoney(deposit);
    }

    @Override
    public double withdrawMoney(double withdraw) {
        System.out.println("Сумма снятия : " + withdraw + " RUB");
        return super.withdrawMoney(withdraw);
    }
}