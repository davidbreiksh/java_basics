public class SelfEmployedClient extends Client {

    private final double BIG_COMMISSION = 0.01;
    private final double SMALL_COMMISSION = 0.005;
    private double commission;
    private double finalSum;

    @Override
    public double checkClientsAccount() {
        System.out.println(clientAccount);
        return clientAccount;
    }

    @Override
    public double depositMoney(double deposit) {
        System.out.println("Какую сумму вы хотите внести на счет ? , ваша сумма : " + deposit + " RUB");
        if (deposit >= 1000) {
            commission = deposit * SMALL_COMMISSION;
            finalSum = deposit - commission;
            System.out.println("Комиссия за операцию : " + commission + " Рублей.Сумма с учетом комиссии : " + finalSum + " RUB");
            return clientAccount = clientAccount + finalSum;
        }
        if (deposit < 1000) {
            commission = deposit * BIG_COMMISSION;
            finalSum = deposit - commission;
            System.out.println("Комиссия за операцию : " + commission + " Рублей.Сумма с учетом комиссии : " + finalSum + " RUB");
        }
        return clientAccount = clientAccount + finalSum;
    }

    @Override
    public double withdrawMoney(double withdraw) {
        System.out.println("Какую сумму вы хотите снять со счета ? , ваша сумма : " + withdraw + " RUB");
        if (withdraw > clientAccount) {
            System.out.println("У вас недостаточно средств");
            return clientAccount;
        }
        return clientAccount = clientAccount - withdraw;
    }
}