package BankingApplicationPackage;
import java.util.Vector;
import java.util.Scanner;
 class Solution {
    public static void main(String[] args)
    {
        Bank A=new Bank();
        System.out.println("\t\tWELCOME TO THE STATE BANK OF INDIA!!");
        A.printAllFacilities();
        int exitWhenZero=1;
        while(exitWhenZero==1){
            System.out.println("Enter the facility number: (Enter 4 to list out all the facility numbers)");
            Scanner sc=new Scanner(System.in);
            int requirement=sc.nextInt();
            switch(requirement)
            {
                case 1:
                {
                    System.out.println("Enter the amount you want to withdraw:");
                    int amount=sc.nextInt();
                    if(A.withdraw(amount)==false){
                        System.out.println("We are closing this withdraw request.");
                    }
                    else{
                        System.out.println("The amount withdrawal is completed.");
                    }
                    currentBalance();
                    break;
                }
                case 2:
                {
                    System.out.println("Enter the amount you want to deposit:");
                    int amount=sc.nextInt();
                    if(A.deposit(amount)==true)
                    {
                        System.out.println("The amount deposition is completed.");
                        currentBalance();
                    }
                    break;
                }
                case 3:
                {
                    A.currentBalance(); break;
                }
                case 4:
                {
                    A.printAllFacilities(); break;
                }
                case 5:
                {
                    System.out.println("Now this application will be closed as you pressed zero 0.");
                    for(int i=0;i<=2500000;i++);
                    System.out.println("Please do visit again.\nThank You!!");
                    for(int i=0;i<=2500000;i++);
                    exitWhenZero=0;
                    break;
                }
                default:
                {
                    System.out.println("Please enter correct facility number (1,2,3...)");
                }
            }
    }
    }
}
class Bank{
    int balance;
    int previousDeposit,previousWithdraw;
    boolean isPreviousTransactionADeposit;
    boolean isFirstTransaction;
    Vector<String> nameOfCostumer= new Vector<String>();
    Vector<String> idOfCustomer= new Vector<String>();
    public static void main(String[]args)
    {
    }
    Bank()
    {
        previousDeposit=0;previousWithdraw=0;
        balance=0;
        isPreviousTransactionADeposit=false;
        isFirstTransaction=false;
    }
    void printAllFacilities()
    {
        System.out.println("\t\tCheck all the facilities and their facility number available in our SBI Account:");
        System.out.println("\t\tFor Withdrawing some amount:                                  enter 1");
        System.out.println("\t\tFor Depositing some amount:                                   enter 2");
        System.out.println("\t\tFor Checking the balance:                                     enter 3");
        System.out.println("\t\tFor Listing out all the facilities and their facility number: enter 4");
        System.out.println("\t\tFor exiting the banking application:                          enter 5");
    }
    boolean withdraw(int amount)
    {
        if(amount<=0){
            System.out.println("Please enter valid amount.");
            return false;
        }
        if(balance<amount){
            System.out.println("You don't have the required amount in your account.");
            return false;
        }
        if(amount>0)
        {
            balance-=amount;
            if(balance==0) {
                System.out.println("Now you don't have any balance in the account.");
            }
            previousWithdraw=amount;
        }
        return true;
    }
    boolean deposit(int amount)
    {
        if(amount>0){
            balance+=amount;
            previousDeposit=amount;
        }
        return true;
    }
    int currentBalance()
    {
        System.out.printf("Your current balance is: %d\n",balance);
        return balance;
    }
}