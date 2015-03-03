package cdi;

import mydi.ATMTransport;

import java.math.BigDecimal;

interface ATM {
    public void deposit(BigDecimal amount);
    public void withdraw(BigDecimal amount);
}

class ATMImpl implements mydi.ATM {

    private ATMTransport transport;
    private byte[] dummy;

    void setTransport(ATMTransport trans){
        transport = trans;
    }

    @Override
    public void deposit(BigDecimal amount) {
        System.out.println("deposit");
        transport.communicateWithBank(dummy);
    }

    @Override
    public void withdraw(BigDecimal amount) {
        System.out.println("withdraw");
        transport.communicateWithBank(dummy);
    }
}