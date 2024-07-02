package org.example;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

//integração do mock e o junit para unir as classes de teste para que trabalhem juntas.
@RunWith(MockitoJUnitRunner.class)
public class BankAccountTest {


    //teste que não sera implementado, feito apenas para teste "Mock"
    @Mock
    private PrintStream mockPrintStream;

    // conta cnpj
    private BussinessAccount bussinessAccount;

    // conta cpf
    private PersonalAccount personalAccount;

    //decorator before  é usado em metodos para que esses aconteçam antes de outros teste.
    @Before
    public void setUp() {
        //print falso
        System.setOut(mockPrintStream);

        personalAccount = new PersonalAccount("Lucas Cunha", "Rua Orlando,52", 1000,25555555,"123456");
        bussinessAccount= new BussinessAccount("Manuela Lucia", "Rua 2 de Novembro,122", 1000, 25555,"1233");
    }

    //ERRO - perguntar para os meninos.
    @Test

    public  void depositAddMoneyToAccount () {
        personalAccount.deposit(500);
        bussinessAccount.deposit(10200);
        assertEquals(500,personalAccount.getBalance(),0.01);
        assertEquals(10200,bussinessAccount.getBalance(),0.01);
    }

    @Test
    //ele conta com o initial balance, não usando os testes anterior.
    public  void withdrawMoneyFromAccount () {
        personalAccount.withdraw(500);
        bussinessAccount.withdraw(5000);
        assertEquals(0,personalAccount.getBalance(),0.01);
        assertEquals(0,bussinessAccount.getBalance(),0.01);
    }

    @Test
    public  void withdrawMoneyFromAccountInvalid () {
        personalAccount.withdraw(2000);
        bussinessAccount.withdraw(50000);
        assertEquals(1000,personalAccount.getBalance(),0.01);
        assertEquals(10000,bussinessAccount.getBalance(),0.01);
    }

    @Test
    public void testPrintStatement() {
        personalAccount.printStatement();
        verify(mockPrintStream).println("Extrato de: Lucas Cunha");
    }

}
