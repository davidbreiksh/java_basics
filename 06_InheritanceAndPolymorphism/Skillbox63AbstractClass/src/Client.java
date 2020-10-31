public abstract class Client {

    public double clientAccount = 10000.0;
    public double withdraw;

    public abstract double checkClientsAccount();

    public abstract double depositMoney(double deposit);

    public abstract double withdrawMoney(double withdraw);
}