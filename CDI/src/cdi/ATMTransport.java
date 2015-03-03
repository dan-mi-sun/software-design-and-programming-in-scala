package cdi;

interface ATMTransport {
    public void communicateWithBank(byte[] dispatch);
}

class StandardATMTransport implements mydi.ATMTransport {
    @Override
    public void communicateWithBank(byte[] dispatch) {
        System.out.println("Communicating with bank " + this.getClass());
    }
}

class SOAPATMTransport implements mydi.ATMTransport {
    @Override
    public void communicateWithBank(byte[] dispatch) {
        System.out.println("Communicating with bank " + this.getClass());
    }
}

class RESTATMTransport implements mydi.ATMTransport {
    @Override
    public void communicateWithBank(byte[] dispatch) {
        System.out.println("Communicating with bank " + this.getClass());
    }
}