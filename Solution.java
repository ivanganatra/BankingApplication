import java.util.Scanner;
 class Solution {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("\t\tWELCOME TO THE STATE BANK OF INDIA!!");
        Bank A=new Bank();
        A.inputUserDetails();
        printAllFacilities();
        int exitWhenZero=1;
        while(exitWhenZero==1){
            System.out.println("=================================================================================================================");
            System.out.println("Enter the facility number: [Enter 4: List out all the facility numbers][Enter 7: To clear the screen]");
            int requirement=sc.nextInt();
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
                    printAllFacilities(); break;
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
                default:
                {
                    System.out.println("Please enter the correct facility number from 1 to 7");
                }
            }
        }
    }
    static void printAllFacilities()
    {
        System.out.println("\t\tCheck all the facilities and their facility number available in our SBI Account:");
        System.out.println("\t\tFor Withdrawing some amount:                                  enter 1");
        System.out.println("\t\tFor Depositing some amount:                                   enter 2");
        System.out.println("\t\tFor Checking the balance and last 10 Transactions:            enter 3");
        System.out.println("\t\tFor Listing out all the facilities and their facility number: enter 4");
        System.out.println("\t\tFor exiting the banking application:                          enter 5");
        System.out.println("\t\tFor viewing Account Details:                                  enter 6");
    }
}