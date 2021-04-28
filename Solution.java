package BankingApplicationPackage;
import java.util.*;
import java.util.Vector;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 class Solution {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("\t\tWELCOME TO THE STATE BANK OF INDIA!!");
        Bank A=new Bank();
        A.inputUserDetails();
        A.printAllFacilities();
        int exitWhenZero=1;
        while(exitWhenZero==1){
            System.out.println("Enter the facility number: [Enter 4: List out all the facility numbers][Enter 7: To clear the screen]");
            int requirement=sc.nextInt();
            A.giveSpace(25);
            switch(requirement)
            {
                case 1:
                {
                    System.out.print("Enter the amount you want to withdraw: ");
                    int amount=sc.nextInt();
                    if(A.withdraw(amount)==false){
                        System.out.println("We are closing this withdraw request.");
                    }
                    else{
                        System.out.println("The amount withdrawal is completed.");
                    }
                    A.currentBalance();
                    break;
                }
                case 2:
                {
                    System.out.print("Enter the amount you want to deposit: ");
                    int amount=sc.nextInt();
                    if(A.deposit(amount)==true)
                    {
                        System.out.println("The amount deposition is completed.");
                        A.currentBalance();
                    }
                    break;
                }
                case 3:
                {
                    A.last10Transactions();
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
                case 6:
                {
                    A.outputUserDetails(); break;
                }
                case 7:
                {
                    A.giveSpace(25);break;
                }
                default:
                {
                    System.out.println("Please enter the correct facility number from 1 to 7");
                }
            }
    }
    }
}
class Pair{
     String typeOfTransaction;
     int amountofTransaction;
     Pair(String transaction,int amount){
        typeOfTransaction=transaction;
        amountofTransaction=amount;
     }
}




class Bank{
    int balance;
    int previousDeposit,previousWithdraw;
    boolean isPreviousTransactionADeposit;
    boolean isFirstTransaction;
    String username;
    String password;
    ArrayDeque<Pair> previousTransactions=new ArrayDeque<Pair>(10);
    // Queue<Pair>previousTransactions=new LinkedList<Pair>();

    Bank()
    {
        previousDeposit=0;previousWithdraw=0;
        balance=0;
        isPreviousTransactionADeposit=false;
        isFirstTransaction=false;
    }
    void inputUserDetails()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your account details.");
        System.out.print("Enter your name: ");
        username=sc.nextLine();
        System.out.print("Enter your new password: ");
        password=sc.nextLine();
    }
    void outputUserDetails()
    {
        System.out.println("\t\t\t\t Details of the SBI account".toUpperCase());
        System.out.println("\t\t\t\t Name: "+ username);
        System.out.print("\t\t\t\t Password: ");
        for(int eachChar=0;eachChar<password.length();eachChar++)
        {
            System.out.print('*');
        }
        System.out.print('\n');
        if(balance==0) System.out.println("\t\t\t\t Current Balance: "+ "Zero Balance");
        else           System.out.println("\t\t\t\t Current Balance: "+ balance);
    }
    void printAllFacilities()
    {
        System.out.println("\t\tCheck all the facilities and their facility number available in our SBI Account:");
        System.out.println("\t\tFor Withdrawing some amount:                                  enter 1");
        System.out.println("\t\tFor Depositing some amount:                                   enter 2");
        System.out.println("\t\tFor Checking the balance and last 10 Transactions:            enter 3");
        System.out.println("\t\tFor Listing out all the facilities and their facility number: enter 4");
        System.out.println("\t\tFor exiting the banking application:                          enter 5");
        System.out.println("\t\tFor viewing Account Details:                                  enter 6");
        System.out.println("\t\tFor clearing the screen:                                      enter 7");
    }
    boolean withdraw(int amount)
    {
        if(amount<=0){
            System.out.println("Please enter valid amount!!".toUpperCase());
            return false;
        }
        if(balance<amount){
            System.out.println("You don't have the required amount in your account!!".toUpperCase());
            return false;
        }
        if(amount>0)
        {
            if(previousTransactions.size()==10)
                previousTransactions.removeFirst();
            previousTransactions.add(new Pair("Withdraw",amount));
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
        if(previousTransactions.size()==10)
            previousTransactions.removeFirst();
        previousTransactions.add(new Pair("Deposit",amount));
        if(amount<=0){
            System.out.println("Please enter a valid amount".toUpperCase());
            return false;
        }
        balance+=amount;
        return true;
    }
    int currentBalance()
    {
        System.out.printf("Your current balance is: %d\n",balance);
        return balance;
    }
    void last10Transactions()
    {
        if(previousTransactions.size()==0)
        {
            System.out.println("You don't have any transaction from this account yet!!".toUpperCase());
        }
        else{
            System.out.println("LIST OF LAST 10 TRANSACTIONS. {Starting from the oldest transaction first}");
            System.out.println("Type of Transaction: Value".toUpperCase());
            int count=1;
            for(Iterator itr=previousTransactions.iterator();itr.hasNext();count++)
            {
                Pair p=(Pair)itr.next();
                System.out.println(count+") "+p.typeOfTransaction+": "+p.amountofTransaction);
            }
        }
    }
    void giveSpace(int numberOfLines)
    {
        for(int loop=1;loop<=numberOfLines;loop++)
        System.out.println("\n");
    }
}
