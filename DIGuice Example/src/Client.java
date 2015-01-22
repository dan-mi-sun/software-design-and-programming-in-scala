public class Client {

	public void go() {
		Service service = ServiceFactory.getInstance();
		service.go();
	}
}
