public class Main {
    public static void main(String[] args) {
        Client client = new SelfEmployedClient();
        client.withdrawMoney(11000);
        client.checkClientsAccount();
    }
}
