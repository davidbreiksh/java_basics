import javax.swing.*;

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
        System.out.println("Какую сумму вы хотите внести на счет ? , ваша сумма : " + deposit + " RUB");
        return clientAccount = clientAccount + deposit;
    }

    @Override
    public double withdrawMoney(double withdraw) {
        System.out.println("Какую сумму вы хотите снять со счета ? , ваша сумма : " + withdraw + " RUB");
        if (withdraw > clientAccount) {
            System.out.println("У вас недостаточно средств");
            return clientAccount;
        }
        commission = withdraw * COMMISSION_PERCENTAGE;
        finalSum = commission + withdraw;
        System.out.println("Комиссия за операцию : " + (withdraw * COMMISSION_PERCENTAGE) + " RUB");
        System.out.println("Сумма снятия с учетом комиссии : " + finalSum);
        return  clientAccount = clientAccount - finalSum ;
    }
}