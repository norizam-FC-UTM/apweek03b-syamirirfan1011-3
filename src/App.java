import java.util.Scanner;

class BankAccount {

    String name;
    double balance;
    double dividendRate; // example: 0.05 = 5%
    String[] transacHistory;
    int idx;

    // Constructor
    public BankAccount(String name, double initialDeposit) {
        this.name = name;
        this.balance = initialDeposit;
        this.transacHistory = new String[90];
        this.dividendRate = 0.0;
        idx = 0;
    }

    public double getBalance() {
        return this.balance;
    }

    // Deposit money
    public void deposit(double amount) {
        balance = balance + amount;
        transacHistory[idx] = "Deposit " + amount;
        idx++;
        // too simple - need refinement
    }

    // Withdraw money
    public void withdraw(double amount) {
        balance = balance - amount;
        transacHistory[idx] = "Withdraw " + amount;
        idx++;
        // too simple - need refinement
    }

    // Calculate dividend
    public double calculateDividend() {
        return balance * dividendRate;
    }

    // Apply dividend to balance
    public void applyDividend() {
        double dividend = calculateDividend();
        balance = balance + dividend;
        transacHistory[idx] = "Add Divident " + dividend;
        idx++;
    }

    public void printTransac() {
        for(int i=0; i<idx; i++) {
            System.out.println(transacHistory[i]);
        }
    }

    // Set dividend rate
    public void setDividendRate(double rate) {
        dividendRate = rate;
        // too simple - need refinement
    }

    // Display account information
    public void printObjectState() {
        System.out.println("\n===== ACCOUNT INFO =====");
        System.out.println("Name          : " + name);
        System.out.println("Balance       : RM " + balance);
        System.out.println("Dividend Rate : " + dividendRate * 100 + "%");
        System.out.println();
    }
}

public class App {
    public static void main(String[] args) {
        int[] finMark = { 88, 75, 60, 80, 90, 95, 77, 91, 77, 80 };
        for (int elem:finMark) {
            System.out.println(elem);
        }


        Scanner sc = new Scanner(System.in);

        System.out.println("===== BANK ACCOUNT SYSTEM =====");

        // Input
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial deposit: RM ");
        double initialDeposit = sc.nextDouble();

        // Create account
        BankAccount acc1 = new BankAccount(name, initialDeposit);
        BankAccount a2 = new BankAccount("Ali", 10);
        BankAccount a3 = new BankAccount("Bali", 10);
        BankAccount a4 = new BankAccount("Cali", 10);
        BankAccount a5 = new BankAccount("Dali", 10);

        System.out.println(acc1);
        System.out.println(a2);
        System.out.println(a3);
        a3.applyDividend();
        a3.printObjectState();

        BankAccount[] accArr;
        accArr = new BankAccount[7];
        System.out.println(accArr[0]);
        System.out.println(accArr[1]);
        System.out.println(accArr[2]);
        System.out.println(accArr[3]);
        System.out.println(accArr[4]);
        System.out.println(accArr[5]);

        accArr[0] = acc1;
        accArr[1] = a2;
        accArr[2] = a3;
        accArr[3] = new BankAccount("Siti", 500);
        accArr[4] = new BankAccount("Siva", 100);
        accArr[5] = a4;
        accArr[6] = a5;

        accArr[3].deposit(700);

        accArr[4].withdraw(50);

        for(int i = 0; i < 7; i++) { // print info - 
            accArr[i].printObjectState();
        }

        for( int i = 0; i < 7; i++) {
            accArr[i].setDividendRate(0.075);
            accArr[i].applyDividend();
        }

         for(int i = 0; i < 7; i++) { // print info - 
            accArr[i].printObjectState();
        }

        double highest = accArr[0].getBalance();
        int highestNo = 0;
        for(int i = 0; i < 7; i++) {
            if(accArr[i].getBalance() > highest) {
                highestNo = i;
                highest = accArr[i].getBalance();
            }
        }

        System.out.println("Print account with highest balance");
        accArr[highestNo].printObjectState();


        System.out.println("\nAccount created successfully.");
/* 
        // Deposit
        System.out.println("----- DEPOSIT -----");
        System.out.print("Enter deposit amount: RM ");
        double depositAmount = sc.nextDouble();
        acc1.deposit(depositAmount);
        acc1.printObjectState();

        // Withdraw
        System.out.println("----- WITHDRAW -----");
        System.out.print("Enter withdrawal amount: RM ");
        double withdrawAmount = sc.nextDouble();
        acc1.withdraw(withdrawAmount);
        acc1.printObjectState();

        // Dividend
        System.out.println("----- YEAR-END DIVIDEND -----");
        System.out.print("Enter dividend rate (example 0.05 for 5%): ");
        double rate = sc.nextDouble();
        acc1.setDividendRate(rate);
        acc1.applyDividend();

        acc1.printObjectState(); */
        accArr[0].deposit(200);
        accArr[0].withdraw(100);
        accArr[0].printTransac();

        System.out.println("===== END OF PROGRAM =====");

        sc.close();
    }
}

/*
 * import java.util.Scanner;
 * 
 * class BankAccount {
 * 
 * String name;
 * double balance;
 * double dividentRate; // e.g. 0.03 = 3%
 * 
 * // Constructor
 * public BankAccount(String name, double initDeposit) {
 * this.name = name;
 * this.balance = initDeposit;
 * }
 * 
 * // Deposit money
 * public void deposit(double amount) {
 * balance = balance + amount;
 * }
 * 
 * // Withdraw money
 * public void withdraw(double amount) {
 * balance = balance - amount;
 * }
 * 
 * // Calculate divident
 * public double calculateDivident() {
 * return balance * dividentRate;
 * }
 * 
 * // Add divident into balance
 * public void applyDivident() {
 * double divident = calculateDivident();
 * balance += divident;
 * }
 * 
 * public void setDividentRate(double theRate) {
 * this.dividentRate = theRate;
 * }
 * 
 * // Display account info
 * public String printObjState() {
 * return "===== ACCOUNT INFO ===== \n" +
 * "Name          : " + name +
 * "Balance       : RM " + balance +
 * "Divident Rate : " + dividentRate * 100;
 * }
 * }
 * 
 * public class App {
 * public static void main(String[] args) throws Exception {
 * System.out.println("Hello, World!");
 * 
 * Scanner sc = new Scanner(System.in);
 * 
 * System.out.println("CREATING NEW BANK ACCOUNT");
 * System.out.print("Enter account holder name: ");
 * String name = sc.nextLine();
 * 
 * System.out.println("Enter initial deposit: ");
 * double initialDeposit = sc.nextDouble();
 * 
 * // Create account
 * BankAccount acc1 = new BankAccount(name, initialDeposit);
 * System.out.println("Acc Successfully created...initial deposit=RM" +
 * initialDeposit);
 * acc1.printObjState();
 * // Perform operations
 * System.out.println("\n--- PERFORMING TRANSACTIONS ---");
 * System.out.println("Enter amount Deposit RM...");
 * double depo = sc.nextDouble();
 * acc1.deposit(depo);
 * System.out.println(acc1.printObjState());
 * System.out.println("Enter amount Withdraw RM...");
 * double wd = sc.nextDouble();
 * acc1.withdraw(wd);
 * acc1.printObjState();
 * System.out.
 * println("\n\n\nEND OF 2026 - CALC DIVIDENT AT END OF FINANTIAL YEAR");
 * System.out.println("Enter div rate (ie 0.5 for 5%");
 * double theRate = sc.nextDouble();
 * acc1.setDividentRate(theRate);
 * acc1.applyDivident();
 * 
 * // Final output
 * acc1.printObjState();
 * 
 * sc.close();
 * }
 * }
 */