public abstract class Client {

    public double clientAccount = 10000.0;

    public abstract double checkClientsAccount();

    public double depositMoney(double deposit) {
        System.out.println("Какую сумму вы хотите внести на счет ? , ваша сумма : " + deposit + " RUB");
        return clientAccount = clientAccount + deposit;
    }

    public double withdrawMoney(double withdraw) {
        if (withdraw > clientAccount) {
            System.out.println("У вас недостаточно средств");
            return clientAccount;
        }
        return clientAccount = clientAccount - withdraw;
    }
}