public class ServiceFactory {

	private ServiceFactory() {
	}

	private static Service instance = new ServiceImpl();

	public static Service getInstance() {
		return instance;
	}

	public static void setInstance(Service service) {
		instance = service;
	}
}
