package domain;

public abstract class StartableObject {

	private StartableStatus status = StartableStatus.CREATED;

	public void start() {
		setStatus(StartableStatus.STARTED);
	}

	public void resume() {
		setStatus(StartableStatus.RESUMED);
	}

	public void stop() {
		setStatus(StartableStatus.STOPPED);
	}

	public StartableStatus getStatus() {
		return status;
	}

	private void setStatus(StartableStatus status) {
		this.status = status;
	}
	
	
}
