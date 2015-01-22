import static org.junit.Assert.*;

import org.junit.Test;

public class TestClient {

	@Test
	public void testClient() {
		Service previous = ServiceFactory.getInstance();
		try {
			final MockService mock = new MockService();
			ServiceFactory.setInstance(mock);
			Client client = new Client();
			client.go();
			assertTrue(mock.isGone());
		} finally {
			ServiceFactory.setInstance(previous);
		}
	}

}
