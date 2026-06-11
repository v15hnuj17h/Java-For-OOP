class BankAccount {

    private int balance = 1000;

    // Synchronized deposit method
    synchronized void deposit(int amount) {

        balance += amount;

        System.out.println(
            Thread.currentThread().getName()
            + " deposited ₹" + amount
            + " | Balance = ₹" + balance
        );
    }

    // Synchronized withdraw method
    synchronized void withdraw(int amount) {

        if (balance >= amount) {

            balance -= amount;

            System.out.println(
                Thread.currentThread().getName()
                + " withdrew ₹" + amount
                + " | Balance = ₹" + balance
            );

        } else {

            System.out.println(
                Thread.currentThread().getName()
                + " tried to withdraw ₹" + amount
                + " | Insufficient Balance!"
            );
        }
    }

    int getBalance() {
        return balance;
    }
}

public class BankBalance {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        // Deposit Thread
        Thread depositor = new Thread(() -> {

            for (int i = 1; i <= 10; i++) {

                account.deposit(500);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Deposit thread interrupted!");
                }
            }

        }, "Depositor");


        // Withdraw Thread
        Thread withdrawer = new Thread(() -> {

            for (int i = 1; i <= 10; i++) {

                account.withdraw(300);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Withdraw thread interrupted!");
                }
            }

        }, "Withdrawer");


        // Start threads
        depositor.start();
        withdrawer.start();

        try {
            // Wait for both threads to finish
            depositor.join();
            withdrawer.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted!");
        }

        // Final balance
        System.out.println("\nFinal Balance = ₹" + account.getBalance());
    }
}