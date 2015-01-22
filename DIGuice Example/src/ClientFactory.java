public class ClientFactory {
	private ClientFactory() {
	}

	public static ClientDIHand getInstance() {
		Service service = ServiceFactory.getInstance();
		return new ClientDIHand(service);
	}
}