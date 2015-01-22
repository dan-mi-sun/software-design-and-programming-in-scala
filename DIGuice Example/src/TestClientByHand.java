import static org.junit.Assert.*;

import org.junit.Test;

public class TestClientByHand {

	@Test
	public void testClient() {
		MockService mock = new MockService();
		ClientDIHand client = new ClientDIHand(mock);
		client.go();
		assertTrue(mock.isGone());
	}
}
