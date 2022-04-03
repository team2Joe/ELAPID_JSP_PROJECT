package util;

public class ActionForward {
	
	private String nextPath; //������ �̵��� url ����...
	private boolean isRedirect; // Redirect ? Forward?
	
	public ActionForward(String nextPath,boolean isRedirect) {
		this.nextPath = nextPath;
		this.isRedirect = isRedirect;
	}

	public String getNextPath() {
		return nextPath;
	}

	public void setNextPath(String nextPath) {
		this.nextPath = nextPath;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}
