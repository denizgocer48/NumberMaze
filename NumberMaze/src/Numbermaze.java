import java.util.Random;

public class Numbermaze {

	   Stack bag1 = new Stack(8) ;
	   Stack bag2 = new Stack(8) ;
	   Stack tempbag1 = new Stack(8) ;
	   Stack tempbag2 = new Stack(8) ;
	   Queue queue = new Queue(10);
	   Queue queue2 = new Queue(10);
	   String[] tempinput = new String[1000];
 
   public Queue Scorefactor() {
	   Random rnd = new Random();
	   for(int i =0;i<10;i++) {
		   int random = rnd.nextInt(100);
		    int a ;
		    if (random<75) {
				a = rnd.nextInt(3)+1;
			  }
		    else if (random>75 && random<95) {
		  	  a = rnd.nextInt(3)+4;
		    }
		    else {
		  	  a = rnd.nextInt(3)+7;
		    }
		    queue.enqueue(a);
	   }	
	   return queue;
   }    
    
  
}

