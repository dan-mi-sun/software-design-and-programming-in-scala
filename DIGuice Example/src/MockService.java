public class MockService implements Service {

	private boolean gone = false;

	@Override
	public void go() {
		gone = true;
	}

	public boolean isGone() {
		return gone;
	}

}