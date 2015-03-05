package cdi;

public class ATMmain {
    public static void main(String[] args) {
        ATM atm = new ATMImpl();
//        ATMTransport trans = new SOAPATMTransport();
//        // Inject the transport
//        ((ATMImpl)atm).setTransport(trans);
//        // DI - constructor or mutator
    }
}
