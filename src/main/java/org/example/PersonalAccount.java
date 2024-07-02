package org.example;

public class PersonalAccount extends  BankAccount{
    // conta cpf
    private int cpf;

    public PersonalAccount(String customerName, String billingAddress,double initialBalance, int cpf, String password) {
        super(customerName, billingAddress, initialBalance, password);

        this.cpf = cpf;
    }
    @Override
    public String getAccountDetails() {
        return "Personal Account [CPF: " + this.cpf + "]";
    }

}

