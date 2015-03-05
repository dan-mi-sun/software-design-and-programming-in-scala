package cdi;

import javax.inject.Inject;
import java.math.BigDecimal;

interface ATM {
    public void deposit(BigDecimal amount);
    public void withdraw(BigDecimal amount);
}

class ATMImpl implements ATM {

    @Inject
//    @TransportConfig(retries=5)
    private ATMTransport transport;

    private byte[] dummy;

//    @Inject
//    void setTransport(ATMTransport trans){
//        transport = trans;
//    }

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