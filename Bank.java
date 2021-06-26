import java.util.Vector;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
public class Bank{
    int balance;
    int previousDeposit,previousWithdraw;
    boolean isPreviousTransactionADeposit;
    boolean isFirstTransaction;
    String username;
    String password;
    ArrayDeque<User> previousTransactions=new ArrayDeque<User>(10);
    // Queue<User>previousTransactions=new LinkedList<User>();

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
                balance-=amount;
            previousTransactions.add(new User("Withdraw",amount,balance));
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
            if(amount<=0){
                System.out.println("Please enter a valid amount".toUpperCase());
                return false;
            }
            balance+=amount;
            previousTransactions.add(new User("Deposit",amount,balance));
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
            System.out.println("S.No  Type of Transaction          Value     Balance".toUpperCase());
            int count=1;
            for(Iterator itr=previousTransactions.iterator();itr.hasNext();count++)
            {
                User p=(User)itr.next();
                System.out.printf("%-4d  %-28s %-8d  %-8d\n",count,p.typeOfTransaction,p.amountofTransaction,p.balance);
                // System.out.println(count+") "+p.typeOfTransaction+": "+p.amountofTransaction);
            }
        }
    }
}
