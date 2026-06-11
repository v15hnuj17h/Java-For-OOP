// Write a program that simulates basic ATM logic:
// Start with balance = 5000
// Use a switch for menu: 1=Check Balance, 2=Deposit, 3=Withdraw, 4=Exit
// For now, hardcode the choice and amount as variables
// Print appropriate message for each operation
// For withdraw: check if balance is sufficient

public class SimpleATM {
    public static void main( String[] args){

        long balance = 5000L;
        int amount = 500,choice = 2;
        boolean run = true;

        while(run){
            System.out.println("Type: 1=Check Balance, 2=Deposit, 3=Withdraw, 4=Exit ");

            switch (choice){
                case 1:
                    System.out.println("Balance = "+ balance);
                    run = false;
                    break;
                case 2:
                    balance+=amount;
                    choice--;
                    break;
                case 3:
                    balance-=amount;
                    break;
                case 4:
                    run = false;
                    break;
                default:
                    System.out.println("Wrong input");
            }
            
        }

    }
}