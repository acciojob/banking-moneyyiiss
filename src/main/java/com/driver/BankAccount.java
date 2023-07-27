package com.driver;

public class BankAccount {

    private String name;
    protected double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }
    public BankAccount(String name, double balance){
        this.name = name;
        this.balance = balance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        int sum1 = 0;
        int dummy = digits;
        while(dummy != 0){
            int f = dummy % 10;
            dummy /= 10;
            sum1+=dummy;

        }
        if(sum1 != sum){
            throw new Exception("Account Number can not be generated");
        }
        return "Your account number is generated";
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance +=amount;
        System.out.println(amount + "has been deposited in your account");

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(balance-amount < minBalance){
            throw new Exception("Insufficient Balance");
        }else{
            this.balance-=amount;
            System.out.println(amount + "has been withdrawn. Remaining Balance is " + this.balance);
        }
    }

}