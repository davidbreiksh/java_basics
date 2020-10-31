public class RegularClient extends Client {

    @Override
    public double checkClientsAccount() {
        System.out.println(clientAccount);
        return clientAccount;
    }

    @Override
    public double depositMoney(double deposit) {
        System.out.println("Какую сумму вы хотите внести на счет ? , ваша сумма : " + deposit + " RUB");
        return clientAccount = clientAccount + deposit;
    }

    @Override
    public double withdrawMoney(double withdraw) {
        System.out.println("Какую сумму вы хотите снять со счета ? , ваша сумма : " + withdraw + " RUB");
        if (withdraw > clientAccount){
            System.out.println("У вас недостаточно средств");
            return clientAccount;
        }
        return clientAccount = clientAccount - withdraw;
    }
}