package org.example;

public class BussinessAccount extends BankAccount{
    // conta cnpj
    private int cnpj;

    public BussinessAccount(String customerName, String billingAddress, double initialBalance, int cnpf, String password) {
        super(customerName, billingAddress, initialBalance, password);

        this.cnpj = cnpj;
    }

    @Override
    public String getAccountDetails() {
        return "Bussiness Account [CNPJ: " + this.cnpj + "]";
    }
}
