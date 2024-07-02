package org.example;

import java.util.ArrayList;
import java.util.List;


//classe abstrata, não pode ser instanciada, apenas se outra classe usar ela
public abstract class BankAccount {

//propriedades- são os dados que o meu objeto deve possuir

    private String customerName;

    private String billingAddress;

    private double balance;

    private String password;

    private List<String> transactions;

//construtor- metodo utilizado para fornecer valores iniciais a variaveis definidas na classe

    public  BankAccount(String customerName,String billingAddress,double initialBalance, String password){
        this.customerName = customerName;
        this.password = password;
        this.billingAddress = billingAddress;

        this.balance = balance;

        this.transactions = new ArrayList<>();
        this.transactions.add("Saldo inicial:" + initialBalance);


    }
//metodo de deposito

    public void  deposit (double amount) {

        if (amount > 0) {
            balance = balance + amount;
            transactions.add("Depósito: " + amount);
        }else {
            transactions.add("Tentativa de Depósito impossível");
        }
    }

    //metodo de saque
    public void withdraw (double amount) {
        if (amount > 0 && amount <= balance){
            balance = balance - amount;
            transactions.add("Saque: " + amount);
        }else {
            transactions.add("Tentativa de Saque impossível");
        }
    }

    //extrato usando a lista
    public void printStatement() {
        System.out.println("Extrato de: " + customerName);

        for (String transaction : transactions) {
            System.out.println(transaction);
        }
        System.out.println("Saldo atual:" +balance);
    }

//sets e getters dos atributos para permitir que eu defina um valor ao atributo e ou no caso do get retornar o valor do campo


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean verifyPassword (String typedPassword) {
        if (typedPassword.equals(password)) {
            return true;
        } else
            return false;

    }

    public abstract String getAccountDetails();
}
