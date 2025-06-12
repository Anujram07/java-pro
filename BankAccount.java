import java.util.ArrayList;
import java.util.Scanner;


class Transaction {
    String type;
    double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String toString() {
        return type + ": Rs. " + amount;
    }
}

class Account {
    private String Account_Holder;
    private int AccountNo;
    private double Bank_Balance;

    ArrayList<Transaction> transaction = new ArrayList<>();

    public Account(String name, int AccountNo, double Bank_Balance) {
        this.Account_Holder = name;
        this.AccountNo = AccountNo;
        this.Bank_Balance = Bank_Balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            Bank_Balance += amount;
            transaction.add(new Transaction("Deposit", amount));
            System.out.println("Deposit Successful!");
            System.out.println("Current Balance: Rs. " + Bank_Balance);
        } else {
            System.out.println("Please Enter a Valid Amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= Bank_Balance) {
            Bank_Balance -= amount;
            transaction.add(new Transaction("Withdraw", amount));
            System.out.println("Withdrawn Successfully!");
            System.out.println("Current Balance: Rs. " + Bank_Balance);
        } else if (amount > Bank_Balance) {
            System.out.println("Insufficient Balance");
        } else {
            System.out.println("Please Enter a Valid Amount");
        }
    }

    public void transaction() {
        if (transaction.isEmpty()) {
            System.out.println("No Transactions Yet.");
        } else {
            System.out.println("Transaction History:");
            for (Transaction t : transaction) {
                System.out.println(t);
            }
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: Rs. " + Bank_Balance);
    }


    public void Loan(double amount){
        if(Bank_Balance>1000){
            System.out.println("Loan Granted");
        }
        else{
             System.out.println("you Sholud have minimum account of $10000 in your account");
        }
       
    }


    public int getAccountNo(){
        return AccountNo;
    }

    public String getname(){
        return Account_Holder;
    }

    // public void saveaccount(String name){
    //      try {
    //         File file = new File(name);
    //         if(file.createNewFile()){
    //             System.out.println("File Created" + file.getName());
    //         } 
    //         FileWriter fw = new FileWriter(file.true);
    //         fw.write("Name "+ name );
            
           
            
            
    //     } catch (IOException e) {
    //         System.out.println("An Error occurred");
    //         e.printStackTrace();
    //     }
    // }

   public void savetransaction(double amount) {
    // try {
    //     FileWriter writer = new FileWriter("new.txt", true); // append mode
    //     writer.write("Transaction Amount: Rs. " + amount + "\n");
    //     writer.close();
    //     System.out.println("Successfully Written!");
    // } catch (IOException e) {
    //     System.out.println("An error occurred.");
    //     e.printStackTrace();
    // }
}

}

public class BankAccount {
    static Account account;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       
       
        System.out.print("Enter Your Name: ");
        String name = in.nextLine();
        System.out.println("Hello! Welcome Dear "+name+" Sir to Dhani Money Bank");
        System.out.println("-------------------------------------------------");

        // Create account with dummy account number and initial balance
        account = new Account(name, 1001, 0.0);

        int choice = 0;
        while (choice != 6) {
            System.out.println("\nMenu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Apply for loan");
            System.out.println("6. Exit");

            System.out.print("Please Enter Your Choice: ");
            if (in.hasNextInt()) {
                choice = in.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                in.next(); 
                continue;
            }

            switch (choice) {
            case 1:
                  System.out.print("Enter amount to deposit: ");
                  double dep = in.nextDouble();
                 account.deposit(dep);
                 // account.saveaccount(name);
                   account.savetransaction(dep);
                  break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double with = in.nextDouble();
                    account.withdraw(with);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    account.transaction();
                    break;

                case 5:
                    System.out.print("Enter amount to deposit: ");
                    double lon = in.nextDouble();
                    account.Loan(lon);
                    break;
                    
                case 6:
                 
                    System.out.println("Thank you for using the Bank App.");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
        in.close();
    }
}

