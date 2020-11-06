public class Main {
    public static void main(String[] args) {
        Client client = new LegalClient();
        client.withdrawMoney(900);
        client.checkClientsAccount();
    }
}
