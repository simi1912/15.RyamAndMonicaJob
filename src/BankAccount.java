public class BankAccount {

    private static int balance = 100;

    public static int getBalance(){
        return balance;
    }

    public static void  withdraw(int amount) {
        balance = balance - amount;
    }
}

