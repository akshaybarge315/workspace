package basics;

public class MultithreadingProducerConsumer2 {

	public static void main(String[] args) {
		
	}

}

class Queuee {

  boolean is_data_present = false;
  int x;

  synchronized void store(int j) {
    try {
      if (is_data_present == false) {
        x = j;
        System.out.println("Produced" + x);
        is_data_present = true;
        notify();
      } else {
        wait();
      }
    } catch (Exception e) {
      System.out.println("Some problem occured");
    }
  }
  
  synchronized void retrieve() {
	  try {
	    if (is_data_present == true) {
	      System.out.println("Consumed" + x);
	      is_data_present = false;
	      notify();
	    } else {
	      wait();
	    }
	  } catch (Exception e) {
	    System.out.println("Some problem occured");
	  }
	}

}
