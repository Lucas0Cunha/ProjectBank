package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class BankSystem {

    private HashMap<String, BankAccount> accountsDatabase;

    private Scanner scanner;

    public BankSystem(HashMap<String,BankAccount>accounts,Scanner scanner) {
        this.accountsDatabase = accounts;

        this.scanner = scanner;

    }

    public void createAccount() {
        System.out.println("Criando uma nova conta: ");
        System.out.println("Digite o seu nome: ");
        //nextline serve para limpar o scanner e tbm ler o conteudo até o fim.
        String name = scanner.nextLine();

        System.out.println("Digite o endereço de cobrança: ");
        String address = scanner.nextLine();

        System.out.println("Digite o saldo inicial: ");
        double balance = scanner.nextDouble();

        System.out.println("Digite uma senha: ");
        int password = scanner.nextInt();

        System.out.println("Digite o tipo de conta: 1 para pessoal, 2 para jurídica");
        int accountType = scanner.nextInt();
        scanner.nextLine();

        if (accountType == 1) {
            System.out.println("Digite o seu CPF: ");
            String cpf = scanner.nextLine();
            PersonalAccount personalAccount = new PersonalAccount(name, address, balance,password, cpf);
            accountsDatabase.put(cpf, personalAccount);
            System.out.println("Conta pessoal criada com sucesso!");

        } else if (accountType == 2) {
            System.out.println("Digite o seu CNPJ: ");
            String cnpj = scanner.nextLine();
            BussinessAccount bussinessAccount = new BussinessAccount(name, address, balance,password, cnpj);
            accountsDatabase.put(cnpj, bussinessAccount);
            System.out.println("Conta jurídica criada com sucesso!");
        } else {
            System.out.println("Operação inválida");
        }
    }

    public void login(String identifier, String password){
        if (accountsDatabase.containsKey(identifier)) {
            BankAccount bankAccount = accountsDatabase.get(identifier);
            boolean passwordMatch = bankAccount.verifyPassword(password);

            if (passwordMatch){
                System.out.println("Usuario logado com sucesso. Bem vindo(a)" + bankAccount.getCustomerName());
                System.out.println("Seus dados:"+accountsDatabase);
            }

        }else {
            System.out.println("Conta não encontrada");
        }




    }

    public static void main (String[] args){
        HashMap<String, BankAccount> accounts = new HashMap<>();
        //scanner system.in vigia oq o usuario escreve
        Scanner scanner = new Scanner(System.in);

        BankSystem bankSystem = new BankSystem(accounts, scanner);


        int option;
        do {
            System.out.println("Seja bem vindo(a) ao LucasBank");
            System.out.println("1.Login");
            System.out.println("2.Crie uma conta");
            System.out.println("3.Deletar conta");
            System.out.println("0.Sair");
            System.out.println("Digite a opção desejada:");
            //option vai receber o proximo inteiro digitado sera recebido pelo scanner e o next line é para limpar o uso do scanner (sempre necessario ao usar scanner)
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Operação Inválida.");
            }

        } while (option != 0);

    }


}
