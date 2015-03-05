package org.cdi.advocacy;


import javax.enterprise.inject.Alternative;

//@Soap
@Alternative
//@Transport(type=TransportType.SOAP)
public class SoapAtmTransport implements ATMTransport {
	
	private int retries;

	public void setRetries(int retries) {
		this.retries = retries;
	}


	public void communicateWithBank(byte[] datapacket) {
		System.out.println("communicating with bank via Soap transport retries=" + retries);
	}

}
