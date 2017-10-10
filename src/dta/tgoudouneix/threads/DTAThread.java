package dta.tgoudouneix.threads;

public class DTAThread extends Thread {
	private String message;
	private Integer number;
	private Integer sleepTime;
	
	public DTAThread(String display, Integer times, Integer sleep) {
		this.message = display;
		this.number = times;
		this.sleepTime = sleep;
	}
	
	public void run() {
		for(int i = 0; i < this.number; i++) {
			System.out.println(message);
			try {
				DTAThread.sleep(sleepTime * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
