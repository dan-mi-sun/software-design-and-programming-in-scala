public class ClientDIHand {
	private final Service service;

	public ClientDIHand(Service service) {
		this.service = service;
	}

	public void go() {
		service.go();
	}
}