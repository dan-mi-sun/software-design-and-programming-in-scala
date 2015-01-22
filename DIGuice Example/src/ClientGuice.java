import com.google.inject.Inject;

public class ClientGuice {
	private final Service service;

	@Inject
	public ClientGuice(Service service) {
		this.service = service;
	}

	public void go() {
		service.go();
	}
}
