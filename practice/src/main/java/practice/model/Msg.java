package practice.model;

public class Msg {
	
	private String status;
	private int step;
	private boolean isOnRoute;
	

	public Msg(String status, int step, boolean isOnRoute) {
		super();
		this.status = status;
		this.step = step;
		this.isOnRoute = isOnRoute;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isOnRoute() {
		return isOnRoute;
	}

	public void setOnRoute(boolean isOnRoute) {
		this.isOnRoute = isOnRoute;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

}
