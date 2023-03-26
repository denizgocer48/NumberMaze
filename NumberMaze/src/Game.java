import enigma.core.Enigma;
import enigma.event.TextMouseEvent;
import enigma.event.TextMouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import enigma.console.Console;
import enigma.console.TextAttributes;
import java.awt.Color;


public class Game {
   public static TextAttributes att = new TextAttributes(Color.white);
   public static TextAttributes att1 = new TextAttributes(Color.green);
   public static TextAttributes att2 = new TextAttributes(Color.yellow);
   public static TextAttributes att3 = new TextAttributes(Color.red);
   public static TextAttributes att4 = new TextAttributes(Color.blue);
   
   public enigma.console.Console cn = Enigma.getConsole("Mouse and Keyboard",100,30,15,1);
   public TextMouseListener tmlis; 
   public KeyListener klis; 

   // ------ Standard variables for mouse and keyboard ------
   public int mousepr;          // mouse pressed?
   public int mousex, mousey;   // mouse text coords.
   public int keypr;   // key pressed?
   public int rkey;    // key   (for press/release)
   // ----------------------------------------------------
   int counter = 0;
   int human = 5;
   int time = 0;
   public void RandomMovingNumbers(Object[][] tempinput,int px, int py) throws InterruptedException {
	   Random rnd = new Random();
	   for(int j =0;j<55;j++) {         
       	for(int i=0;i<23;i++) {
       		if(i!=py || j!=px) {
       			if(tempinput[i][j] == (Object)4 || tempinput[i][j] == (Object)5 || tempinput[i][j] == (Object)6 ) {
           			int y = rnd.nextInt(4)+1;
           			if(y == 1 && tempinput[i][j-1].equals((Object)' ')) {
           				if(tempinput[i][j-1] == (Object)'.') {
           					tempinput[i][j-1] = (int)tempinput[i][j];
               				tempinput[i][j] = (Object)'.';
               				cn.getTextWindow().output(j-1,i,'.');
           				}
           				else {
           					tempinput[i][j-1] = (int)tempinput[i][j];
               				tempinput[i][j] = (Object)' ';
               				cn.getTextWindow().output(j,i,' ');
           				}
           				cn.setTextAttributes(att2);
           				cn.getTextWindow().setCursorPosition(j-1,i);
           				System.out.println(tempinput[i][j-1]);
           				cn.setTextAttributes(att);
           				i++;
           			}
           			else if(y == 2 && tempinput[i][j+1].equals((Object)' ')) {
           				if(tempinput[i][j+1] == (Object)'.') {
           					tempinput[i][j+1] = (int)tempinput[i][j];
               				tempinput[i][j] = (Object)'.';
               				cn.getTextWindow().output(j+1,i,'.');
           				}
           				else {
           					tempinput[i][j+1] = (int)tempinput[i][j];
               				tempinput[i][j] = (Object)' ';
               				cn.getTextWindow().output(j,i,' ');
           				}
           				 cn.setTextAttributes(att2);
           				cn.getTextWindow().setCursorPosition(j+1,i);
           				System.out.println(tempinput[i][j+1]);
           				cn.setTextAttributes(att);
           				i++;
           			}
           			else if(y == 3 && tempinput[i-1][j].equals((Object)' ')) {
           				if(tempinput[i-1][j] == (Object)'.') {
           					tempinput[i-1][j] = (int)tempinput[i][j];
               				tempinput[i][j] = (Object)'.';
               				cn.getTextWindow().output(j,i-1,'.');
           				}
           				else {
           					tempinput[i-1][j] = (int)tempinput[i][j];
               				tempinput[i][j] = (Object)' ';
               				cn.getTextWindow().output(j,i,' ');
           				}
           				 cn.setTextAttributes(att2);
           				cn.getTextWindow().setCursorPosition(j,i-1);
           				System.out.println(tempinput[i-1][j]);
           				cn.setTextAttributes(att);
           				i++;
           			}
           			else if(y == 4 && tempinput[i+1][j].equals((Object)' ')) {
           				if(tempinput[i+1][j] == (Object)'.') {
           					tempinput[i+1][j] = (int)tempinput[i][j];
               				tempinput[i][j] = (Object)'.';
               				cn.getTextWindow().output(j,i+1,'.');
           				}
           				else {
           					tempinput[i+1][j] = (int)tempinput[i][j];
               				tempinput[i][j] = (Object)' ';
               				cn.getTextWindow().output(j,i,' ');
           				}
           				cn.setTextAttributes(att2);
           				cn.getTextWindow().setCursorPosition(j,i+1);
           				System.out.println(tempinput[i+1][j]);
           				cn.setTextAttributes(att);	
           				i++;
           			}
           		}
       		}	            		
       	}
       }
   }
   public Object[][] displayscreen() throws FileNotFoundException {
	   File inFile = new File("input.txt");                                 
	   Scanner sc = new Scanner(inFile); 
	   Object[][] tempinput = new Object[23][55];
	   char[] chr = new char[55];
	   String line ;

	   for(int i = 0;i<23;i++){
		   line = sc.nextLine();
		   chr = line.toCharArray();
		   for(int j =0;j<55;j++) {
			  tempinput[i][j] = chr[j];
		   }
	   }	   
	   for(int i = 0;i<23;i++) {		   
	    	for(int j =0;j<55;j++) {	    		
	    		System.out.print(tempinput[i][j]);
	    	}
	    	System.out.println();
	    }
	   
	   cn.getTextWindow().setCursorPosition(60,0);
       System.out.println("Input");
       cn.getTextWindow().setCursorPosition(60,1);
       System.out.println("<<<<<<<<<<");         
       cn.getTextWindow().setCursorPosition(60,3);
       System.out.println("<<<<<<<<<<");
       cn.getTextWindow().setCursorPosition(60,6);
       System.out.println("Backpack");         
       cn.getTextWindow().setCursorPosition(60,7);
       System.out.println("|    | |    |");
       cn.getTextWindow().setCursorPosition(60,8);
       System.out.println("|    | |    |");
       cn.getTextWindow().setCursorPosition(60,9);
       System.out.println("|    | |    |");
       cn.getTextWindow().setCursorPosition(60,10);
       System.out.println("|    | |    |");
       cn.getTextWindow().setCursorPosition(60,11);
       System.out.println("|    | |    |");
       cn.getTextWindow().setCursorPosition(60,12);
       System.out.println("|    | |    |");
       cn.getTextWindow().setCursorPosition(60,13);
       System.out.println("|    | |    |");
       cn.getTextWindow().setCursorPosition(60,14);
       System.out.println("|    | |    |");
       cn.getTextWindow().setCursorPosition(60,15);
       System.out.println("+____+ +____+");
       cn.getTextWindow().setCursorPosition(61,16);
       System.out.println("Left   Right");
       cn.getTextWindow().setCursorPosition(63,17);
       System.out.println("Q     W");
       cn.getTextWindow().setCursorPosition(60,20);
       System.out.println("Score: ");
       cn.getTextWindow().setCursorPosition(60,22);
       System.out.println("Time : ");
      // tempinput[5][7] = (Object) 7;
       //cn.getTextWindow().setCursorPosition(7,5);
       //System.out.println(tempinput[5][7]);
       return tempinput;
   }
   public void addNumbers(Queue queue,Object[][] tempinput) {
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
	   for(int i =0;i<24;i++) {
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
		    while(true) {
		    	int x = rnd.nextInt(54) + 1;
				int y = rnd.nextInt(22) + 1;
		    	if(tempinput[y][x].equals(' ')) {
		    		if(a == 1 || a == 2 || a == 3) {
						   tempinput[y][x] = a;
						   cn.getTextWindow().output(x,y,' ');
						   cn.getTextWindow().setCursorPosition(x,y);
						   cn.setTextAttributes(att1);
						   System.out.print(tempinput[y][x]);	
						   cn.setTextAttributes(att);							   
					   }
		    		else if(a == 4 || a == 5 || a == 6) {
						   tempinput[y][x] = a;								   
						   cn.getTextWindow().output(x,y,' ');
						   cn.setTextAttributes(att2);
						   cn.getTextWindow().setCursorPosition(x,y);
						   System.out.print(tempinput[y][x]);	
						   cn.setTextAttributes(att);
					   }
					   else if(a == 7 || a == 8 || a == 9)
					   {
						   tempinput[y][x] = a;
						   cn.getTextWindow().output(x,y,' ');
						   cn.getTextWindow().setCursorPosition(x,y);
						   cn.setTextAttributes(att3);
						   System.out.print(tempinput[y][x]);		
						   cn.setTextAttributes(att);
					   }			    	
		    		break;
		    	}
		    }
		    cn.getTextWindow().setCursorPosition(60,2);
		    for(int l =0;l<queue.size();l++) {
				System.out.print(queue.peek());
				queue.enqueue(queue.dequeue());					
			}
	   }
   }
   Game() throws Exception {   // --- Contructor
	       Stack bag1 = new Stack(8) ;
		   Stack bag2 = new Stack(8) ;
		   Stack tempbag1 = new Stack(8) ;
		   Stack tempbag2 = new Stack(8) ;
		   Queue queue = new Queue(1000);
		   Random rnd = new Random();
		   
		   Object[][] tempinput = displayscreen();
		   addNumbers(queue,tempinput);
		                   
      // ------ Standard code for mouse and keyboard ------ Do not change
      tmlis=new TextMouseListener() {
         public void mouseClicked(TextMouseEvent arg0) {}
         public void mousePressed(TextMouseEvent arg0) {
            if(mousepr==0) {
               mousepr=1;
               mousex=arg0.getX();
               mousey=arg0.getY();
            }
         }
         public void mouseReleased(TextMouseEvent arg0) {}
      };
      cn.getTextWindow().addTextMouseListener(tmlis);
    
      klis=new KeyListener() {
         public void keyTyped(KeyEvent e) {}
         public void keyPressed(KeyEvent e) {
            if(keypr==0) {
               keypr=1;
               rkey=e.getKeyCode();
            }
         }
         public void keyReleased(KeyEvent e) {}
      };
      cn.getTextWindow().addKeyListener(klis);
      // ----------------------------------------------------
      

      int px=5,py=5;
      tempinput[py][px] = human;
      cn.setTextAttributes(att4); 
      cn.getTextWindow().setCursorPosition(px,py);
      System.out.println(tempinput[py][px]);
      cn.setTextAttributes(att);
      Coordinant c = new Coordinant(px,py);
      c.findRed(tempinput);
      Stack stack1 = c.coord(px,py,tempinput,c.getSe(),c.getSs());
 	  Stack stack2 = c.Return();
 	  int count = c.getCounter();
      //Game
 	 Stack s1 = new Stack(100000);
 	 Stack s2 = new Stack(100000);
 	 s1 = c.coord(px,py,tempinput,c.getSe(),c.getSs());
 	 s2 = c.Return();
	  int score =0;
      while(true) {
    	  if(counter%10 == 0) {
     		 RandomMovingNumbers(tempinput,px,py); 
     		 if(s1.size()>0) {
         		 int x1 = (int) s1.pop();
     			 int y1 = (int) s2.pop();
     			 int x2 = (int)s1.peek(); 
     			 int y2 = (int)s2.peek();
     			 tempinput[y2][x2] = tempinput[y1][x1];
     			 cn.setTextAttributes(att3);
     			 cn.getTextWindow().setCursorPosition(x2,y2);
   	         	 System.out.println(tempinput[y2][x2]);
   	         	 cn.setTextAttributes(att);
   	         	 cn.getTextWindow().setCursorPosition(x1,y1);
  	         	 System.out.println(' ');
  	         	 tempinput[y1][x1] = (Object)' ';
     		 }
     	 }
    	  
    	  if(!stack1.isEmpty()) {
     		 for(int i = 0; i < count-1; i++) {
     			 if(!stack1.isEmpty()) {
     				 int a1 = (int)stack1.pop();
       	 			int b = (int)stack2.pop();
     				 if(tempinput[b][a1]  == (Object)' ') {
     					 cn.getTextWindow().setCursorPosition(a1,b);
     	     	         	System.out.println((Object)'.'); 
     				 }			
     			 }
     	 		}
     	 }
    	 
    	 
    	  	 
    	  while(true) {
    		  if(counter%50==0) {
    			  int x = rnd.nextInt(54) + 1;
				  int y = rnd.nextInt(22) + 1;
					   while(true) {
						   if(tempinput[y][x].equals(' ')) {
							   int num = (int) queue.peek();
							   if(num == 1 || num == 2 || num == 3) {
								   tempinput[y][x] = num;
								   cn.getTextWindow().output(x,y,' ');
								   cn.getTextWindow().setCursorPosition(x,y);
								   cn.setTextAttributes(att1);
								   System.out.print(tempinput[y][x]);	
								   cn.setTextAttributes(att);
								   
							   }
							   else if(num == 4 || num == 5 || num == 6) {
								   tempinput[y][x] = num;								   
								   cn.getTextWindow().output(x,y,' ');
								   cn.setTextAttributes(att2);
								   cn.getTextWindow().setCursorPosition(x,y);
								   System.out.print(tempinput[y][x]);	
								   cn.setTextAttributes(att);
							   }
							   else if(num == 7 || num == 8 || num == 9)
							   {
								   tempinput[y][x] = num;
								   cn.getTextWindow().output(x,y,' ');
								   cn.getTextWindow().setCursorPosition(x,y);
								   cn.setTextAttributes(att3);
								   System.out.println(tempinput[y][x]);		
								   cn.setTextAttributes(att);
								   stack1 = c.coord(px,py,tempinput,c.getSe(),c.getSs());
								   stack2 = c.Return();
								   count = c.getCounter();
							   }
							   queue.dequeue();
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
							    break;
						   }
						   else {
							   x = rnd.nextInt(54) + 1;
							   y = rnd.nextInt(22) + 1;
						   } 
					   }
					   	cn.getTextWindow().setCursorPosition(60,2);
					    for(int l =0;l<queue.size();l++) {
							System.out.print(queue.peek());
							queue.enqueue(queue.dequeue());					
						   }
    		  }
    		  if(counter%1==0) {
    			  counter++;
    	  	   		cn.getTextWindow().setCursorPosition(67,22);
    	  			System.out.print(counter/10);
    	  			break;
    		  }
    		  else {
    			  if(human == 1) {
    				  time++;
    			  }
    			  counter++;
    			  break;
    		  }
  		   
  	   }
    	  int r = 14; 
          int a =14;
          int d = 14; 
          int f =14;
         if(mousepr==1) {  // if mouse button pressed
            cn.getTextWindow().output(mousex,mousey,'#');  // write a char to x,y position without changing cursor position
            px=mousex; py=mousey;
            
            mousepr=0;     // last action  
         }        
        
         while(!bag1.isEmpty()) {
         	tempbag1.push(bag1.pop());
         }
         while(!bag2.isEmpty()) {
         	tempbag2.push(bag2.pop());
         }        
         
         while (!(tempbag1.isEmpty())) {
        	 	cn.getTextWindow().setCursorPosition(62,d);
 			System.out.print(tempbag1.peek()+" ");						
 			bag1.push(tempbag1.pop());
 			d--;
 		}	    		
 		while (!(tempbag2.isEmpty())) {
        	 	cn.getTextWindow().setCursorPosition(69,f);
 			System.out.print(tempbag2.peek()+" ");						
 			bag2.push(tempbag2.pop());
 			f--;
 		}	
 		cn.getTextWindow().output(62,d,' ');
		cn.getTextWindow().output(69,f,' ');             
		
		while(!bag1.isEmpty()) {
        	tempbag1.push(bag1.pop());
        }
        while(!bag2.isEmpty()) {
        	tempbag2.push(bag2.pop());
        }
        
        
        
        //score
        int tempsize1 = tempbag1.size();
        int tempsize2 = tempbag2.size();
        if(tempsize1<=tempsize2) {
        	for(int i =0;i<tempsize1;i++) {	            	
        		if(tempbag1.peek().equals(tempbag2.peek())) {
        			if(tempbag1.peek() == (Object)1 || tempbag1.peek() == (Object)2 || tempbag1.peek() == (Object)3) {
        				score += (int)tempbag1.peek()*1;
        				if(human == 9)
        					human = 1;
        				else
        					human++;
        			}
        			else if(tempbag1.peek() == (Object)4 || tempbag1.peek() == (Object)5 || tempbag1.peek() == (Object)6) {
        				score += (int)tempbag1.peek()*5;
        				if(human== 9)
        					human = 1;
        				else
        					human++;
        			}
        			else if(tempbag1.peek() == (Object)7 || tempbag1.peek() == (Object)8 || tempbag1.peek() == (Object)9) {
        				score += (int)tempbag1.peek()*25;
        				if(human== 9) {
        					human = 1;
        				}
        				else
        					human++;
        			}
        			tempbag1.pop();
        			tempbag2.pop();
        		}
        		else {
        			bag1.push(tempbag1.pop());
        			bag2.push(tempbag2.pop());
        		}		            		 
        		 cn.getTextWindow().output(62,13-bag1.size(),' ');
        		 cn.getTextWindow().output(69,12-bag2.size(),' ');
        	}
        }
        else {
        	for(int i =0;i<tempbag2.size();i++) {
        		if(tempbag1.peek()==tempbag2.peek()) {
        			if(tempbag1.peek() == (Object)1 || tempbag1.peek() == (Object)2 || tempbag1.peek() == (Object)3) {
        				score += (int)tempbag1.peek()*1;
        				
        				if(human== 9)
        					human = 1;
        				else
        					human++;
        			}
        			else if(tempbag1.peek() == (Object)4 || tempbag1.peek() == (Object)5 || tempbag1.peek() == (Object)6) {
        				score += (int)tempbag1.peek()*5;
        				if(human== 9)
        					human = 1;
        				else
        					human++;
        			}
        			else if(tempbag1.peek() == (Object)7 || tempbag1.peek() == (Object)8 || tempbag1.peek() == (Object)9) {
        				score += (int)tempbag1.peek()*25;
        				if(human== 9)
        					human = 1;
        				else
        					human++;
        			}
        			tempbag1.pop();
        			tempbag2.pop();	            			
        		}
        		else {
        			bag1.push(tempbag1.pop());
        			bag2.push(tempbag2.pop());
        		}
        		cn.getTextWindow().output(62,13-bag1.size(),' ');
        		cn.getTextWindow().output(69,12-bag2.size(),' ');
        	}
        }
       
        while(!bag1.isEmpty()) {
        	tempbag1.push(bag1.pop());
        }
        while(!bag2.isEmpty()) {
        	tempbag2.push(bag2.pop());
        }
                        
        while (!(tempbag1.isEmpty())) {
       	 	cn.getTextWindow().setCursorPosition(62,r);
			System.out.print(tempbag1.peek()+" ");						
			bag1.push(tempbag1.pop());
			r--;
		}	    		
		while (!(tempbag2.isEmpty())) {
       	 	cn.getTextWindow().setCursorPosition(69,a);
			System.out.print(tempbag2.peek()+" ");						
			bag2.push(tempbag2.pop());
			a--;
		}		    		
		cn.getTextWindow().output(62,r,' ');
		cn.getTextWindow().output(69,a,' ');
				            
			            
		 cn.setTextAttributes(att4); 
	      cn.getTextWindow().setCursorPosition(px,py);
	      System.out.println(tempinput[py][px]);
	      cn.setTextAttributes(att);		
		
        cn.getTextWindow().setCursorPosition(67,20);
        System.out.println(score);
        
		
		 if(0<px && px<54 && 0<py && py<55) {			 
			 if(keypr==1) {    // if keyboard button pressed
				 if(!stack1.isEmpty()) {
		    		 for(int i = 0; i < count-1; i++) {
		    			 if(!stack1.isEmpty()) {
		    				 int a1 = (int)stack1.pop();
		      	 			int b = (int)stack2.pop();
		    				 if(tempinput[b][a1]  == (Object)' ') {
		    					 cn.getTextWindow().setCursorPosition(a1,b);
		    	     	         	System.out.println((Object)'.'); 
		    				 }			
		    			 }
		    	 		}
		    	 }     
				 if(rkey==KeyEvent.VK_LEFT && tempinput[py][px-1] != (Object)'#') { 
		            	if(tempinput[py][px-1] == (Object)1 || tempinput[py][px-1] == (Object)2 || tempinput[py][px-1] == (Object)3 || tempinput[py][px-1] == (Object)4|| tempinput[py][px-1] == (Object)5|| tempinput[py][px-1] == (Object)6|| tempinput[py][px-1] == (Object)7|| tempinput[py][px-1] == (Object)8|| tempinput[py][px-1] == (Object)9 ) {
		            		if((int)tempinput[py][px] < (int)tempinput[py][px-1]) {
		            			System.out.println("Game Over");
		            			break;
		            		}
		            		if(bag1.isFull()) {
		            			bag1.pop();
		            		}
			            	bag1.push(tempinput[py][px-1]);
			            	tempinput[py][px] = ' ';
			            	cn.getTextWindow().output(px,py,' ');
			            	tempinput[py][px-1] = human;
			            } 
		            	else {
		            		tempinput[py][px-1] = human;
			            	 tempinput[py][px] = ' ';
			            	cn.getTextWindow().output(px,py,' ');
		            	}            	 
		            	px--;
		            }   
		            if(rkey==KeyEvent.VK_RIGHT && tempinput[py][px+1] != (Object)'#') {
		            	if(tempinput[py][px+1] == (Object)1 || tempinput[py][px+1] == (Object)2 || tempinput[py][px+1] == (Object)3 || tempinput[py][px+1] == (Object)4|| tempinput[py][px+1] == (Object)5|| tempinput[py][px+1] == (Object)6|| tempinput[py][px+1] == (Object)7|| tempinput[py][px+1] == (Object)8|| tempinput[py][px+1] == (Object)9 ) {
		            		if((int)tempinput[py][px] < (int)tempinput[py][px+1]) {
		            			System.out.println("Game Over");
		            			break;
		            		}
		            		if(bag1.isFull()) {
		            			bag1.pop();
		            		}
			            	bag1.push(tempinput[py][px+1]);
			            	tempinput[py][px] = ' ';
			            	cn.getTextWindow().output(px,py,' ');
			            	tempinput[py][px+1] = human;
			            } 
		            	else {
		            		tempinput[py][px+1] = human;
			            	tempinput[py][px] = ' ';
			            	cn.getTextWindow().output(px,py,' ');
		            	}		            	
		            	px++;
		            }
		            if(rkey==KeyEvent.VK_UP && tempinput[py-1][px]!= (Object)'#') {
		            	if(tempinput[py-1][px] == (Object)1 || tempinput[py-1][px] == (Object)2 || tempinput[py-1][px] == (Object)3 || tempinput[py-1][px] == (Object)4|| tempinput[py-1][px] == (Object)5|| tempinput[py-1][px] == (Object)6|| tempinput[py-1][px] == (Object)7|| tempinput[py-1][px] == (Object)8|| tempinput[py-1][px] == (Object)9 ) {
		            		if((int)tempinput[py][px] < (int)tempinput[py-1][px]) {
		            			System.out.println("Game Over");
		            			break;
		            		}
		            		if(bag1.isFull()) {
		            			bag1.pop();
		            		}
			            	bag1.push(tempinput[py-1][px]);
			            	tempinput[py][px] = ' ';
			            	cn.getTextWindow().output(px,py,' ');
			            	tempinput[py-1][px] = human;
			            }
		            	else {
		            		tempinput[py-1][px] = human;
			            	tempinput[py][px] = ' ';
			            	cn.getTextWindow().output(px,py,' ');
		            	}	            	
		            	py--;
		            }
		            if(rkey==KeyEvent.VK_DOWN && tempinput[py+1][px] != (Object)'#') {
		            	if(tempinput[py+1][px] == (Object)1 || tempinput[py+1][px] == (Object)2 || tempinput[py+1][px] == (Object)3 || tempinput[py+1][px] == (Object)4|| tempinput[py+1][px] == (Object)5|| tempinput[py+1][px] == (Object)6|| tempinput[py+1][px] == (Object)7|| tempinput[py+1][px] == (Object)8|| tempinput[py+1][px] == (Object)9 ) {
		            		if((int)tempinput[py][px] < (int)tempinput[py+1][px]) {
		            			System.out.println("Game Over");
		            			break;
		            		}
		            		if(bag1.isFull()) {
		            			bag1.pop();
		            		}
			            	bag1.push(tempinput[py+1][px]);
			            	tempinput[py][px] = ' ';
			            	cn.getTextWindow().output(px,py,' ');
			            	tempinput[py+1][px] = human;
			            }
		            	else {
		            		 tempinput[py+1][px] = human;
		            		 tempinput[py][px] = ' ';
			            	 cn.getTextWindow().output(px,py,' ');
		            	}	            	
		            	py++;
		            }
		            if(rkey==KeyEvent.VK_Q && !bag2.isEmpty()) {
		            	bag1.push(bag2.pop());		            	
		            }
		            if(rkey==KeyEvent.VK_W && !bag1.isEmpty()) {
		            	bag2.push(bag1.pop());      	
		            }		            	     
		            keypr=0;    // last action  	            
		         }
	      }
		 if(human == 1 && time % 40 == 0) {
	        	human = 2;
	        	cn.getTextWindow().setCursorPosition(px,py);
	        	System.out.println(tempinput[py][px]);
	      }
		 Thread.sleep(100);
      } 
   }
}