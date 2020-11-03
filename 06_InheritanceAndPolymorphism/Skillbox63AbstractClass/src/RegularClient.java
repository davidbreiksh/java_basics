public class RegularClient extends Client {

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
        return super.withdrawMoney(withdraw);
    }
}