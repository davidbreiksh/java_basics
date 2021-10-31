import java.util.Comparator;

import org.jetbrains.annotations.NotNull;

public class Account implements Comparable<Account> {

    private long money;

    private String accNumber;

    private boolean isBlocked;

    public Account(long money, String accNumber) {
        this.money = money;
        this.accNumber = accNumber;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public long getMoney() {
        return money;
    }

    public long setMoney(long money) {
        return this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
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

    @Override
    public int compareTo(@NotNull Account o) {
        return Integer.compare(o.hashCode(), this.hashCode());
    }

//    @Override
//    public int compare(Account o1, Account o2) {
//
//        return Integer.compare(o1.hashCode(), o2.hashCode());
//    }
}