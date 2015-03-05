package mydi;

interface ATMTransport {
    public void communicateWithBank(byte[] dispatch);
}

class StandardATMTransport implements ATMTransport {
    @Override
    public void communicateWithBank(byte[] dispatch) {
        System.out.println("Communicating with bank " + this.getClass());
    }
}

class SOAPATMTransport implements ATMTransport {
    @Override
    public void communicateWithBank(byte[] dispatch) {
        System.out.println("Communicating with bank " + this.getClass());
    }
}
class RESTATMTransport implements ATMTransport {
    @Override
    public void communicateWithBank(byte[] dispatch) {
        System.out.println("Communicating with bank " + this.getClass());
    }
}