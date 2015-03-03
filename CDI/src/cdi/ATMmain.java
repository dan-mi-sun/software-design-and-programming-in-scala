package cdi;

import mydi.*;

public class ATMmain {
    public static void main(String[] args) {
        mydi.ATM atm = new mydi.ATMImpl();
        ATMTransport trans = new SOAPATMTransport();
        // Inject the transport
        ((mydi.ATMImpl)atm).setTransport(trans);
        // DI - constructor or mutator
    }
}
