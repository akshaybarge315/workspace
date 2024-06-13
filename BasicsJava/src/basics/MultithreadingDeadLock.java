package basics;

class Family implements Runnable
{
    String resource1 = "Tv";
    String resource2 = "Playstation";
    
    public void run()
    {
        String name = Thread.currentThread().getName();
        if(name.equals("Rohit") == true)
        {
            rohitAcquiredResource();
        }
        else
        {
            vijayAcquiredResource();
        }
    }
    
    void rohitAcquiredResource()
    {
        synchronized(resource2) {
        	try
        	{
	        	System.out.println("Rohit accquired Playstation"); 
	        	Thread.sleep(1000);
	        	synchronized(resource1)
	        	{
	        		System.out.println("Rohit accquired Tv "); 
	        		Thread.sleep(1000);
	        	}
        	}
        	catch (Exception e)
        	{
        	System.out.println("Rohit failed");
        	}
        }
    }
    
    void vijayAcquiredResource() {
    	synchronized(resource1) {
        	try
        	{
	        	System.out.println("Vijay accquired Tv"); 
	        	Thread.sleep(1000);
	        	synchronized(resource2)
	        	{
	        		System.out.println("Vijay accquired Playstation"); 
	        		Thread.sleep(1000);
	        	}
        	}
        	catch (Exception e)
        	{
        	System.out.println("Vijay failed");
        	}
        }
    }
}
        

public class MultithreadingDeadLock {
	public static void main(String args[]) {
		
		Family f = new Family();
		Thread t1 = new Thread(f);
		Thread t2 = new Thread(f);
		
		t1.setName("Rohit");
		t1.setName("Vijay");
		
		t1.start();
		t2.start();
	}
}
