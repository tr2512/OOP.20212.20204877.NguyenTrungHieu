package hust.soict.dsai.aims.thread;

public class MemoryDaemon extends Thread implements java.lang.Runnable{
	
	private long memoryUsed = 0;
	
	public void run() {
		Runtime rt = Runtime.getRuntime();
		long used;
		while (true) {
			used = rt.totalMemory() - rt.freeMemory();
			if (used != memoryUsed) {
				System.out.println("\tMemory used = " + used);
				memoryUsed = used;
			}
		}
	}
	public MemoryDaemon(String title) {
		super(title);
	}

}
