public class Account {

    private long money;

    private String accNumber;

    private boolean isBlocked;

    public Account(long money, String accNumber) {
        this.money = money;
        this.accNumber = accNumber;
    }

    protected synchronized void withdraw(long withdrawMoney) {
        money -= withdrawMoney;
        // Делаю проверку на деньги в классе банке
    }

    protected synchronized void depositMoney(long depositMoney) {
        money += depositMoney;
    }

    protected boolean isBlocked() {
        return isBlocked;
    }

    protected void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    protected long getMoney() {
        return money;
    }

    protected long setMoney(long money) {
        return this.money = money;
    }

    protected String getAccNumber() {
        return accNumber;
    }

    protected void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "money=" + money +
                ", isBlocked=" + isBlocked +
                ", accNumber='" + accNumber + '\'' +
                '}';
    }
}