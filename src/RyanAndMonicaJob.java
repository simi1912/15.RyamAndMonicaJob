public class RyanAndMonicaJob implements Runnable {

    public static void main(String[] args) {
        Runnable theJob = new RyanAndMonicaJob();
        Thread one = new Thread(theJob);
        Thread two = new Thread(theJob);
        one.setName("Ryan");
        two.setName("Monica");
        one.start();
        two.start();
    }

    public void run() {
        for (int x = 0; x < 10; x++) {
            makeWithdrawl(10);
            if (BankAccount.getBalance() < 0) {
                System.out.println("Overdrawn!");
            }
        }
    }

    private void makeWithdrawl(int amount) {
        if (BankAccount.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw");
            try {
                System.out.println(Thread.currentThread().getName() + " is going to sleep");
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " woke up!");
            BankAccount.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " completes the withdrawl");
        } else {
            System.out.println("Not enough for " + Thread.currentThread().getName());
        }
    }
}
