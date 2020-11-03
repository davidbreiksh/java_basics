public class Main {
    public static void main(String[] args) {
        Client client = new SelfEmployedClient();
        client.depositMoney(1000);
        client.checkClientsAccount();
    }
}
