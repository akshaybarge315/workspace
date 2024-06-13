package basics;

class Demo1 extends Thread {
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("User thread executing");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println("Some problem occured");
			}
		}
	}
}

class Demo2 extends Thread {
	
	public void run() {
		for (;;) {
			System.out.println("Daemon thread executing");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println("Some problem occurred");
			}
		}
	}
}

public class ThreadingUserDaemon {

	    public static void main(String[] args) {

	        System.out.println("Main() started execution");

	        Demo1 d1 = new Demo1();
	        Demo2 d2 = new Demo2();

	        d2.setDaemon(true);
	        d1.start();
	        d2.start();

	        System.out.println("Main() completed execution");
	    }

}
