import java.util.*;
public class User{
    String typeOfTransaction;
    int amountofTransaction;
    int balance;
    User(String transaction,int amount,int balance){
       typeOfTransaction=transaction;
       amountofTransaction=amount;
       this.balance=balance;
    }
}
