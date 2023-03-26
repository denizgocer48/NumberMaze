import java.util.Random;

public class Coordinant {
	int x,y,counter = 0;
	Coordinant previous;
	Game g ;
	Stack s1 = new Stack(100000);
	Stack s2 = new Stack(100000);
	Stack temp1 = new Stack(100000);
	Stack temp2 = new Stack(100000);
	Stack se = new Stack(100);
	Stack ss = new Stack(100);
	int redcount = 0;
	public Coordinant(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Stack getSe() {
		return se;
	}
	public Stack getSs() {
		return ss;
	}
	public void findRed(Object[][] screen) {
		for(int i = 0;i<23;i++){			   
			   for(int j =0;j<55;j++) {
				   if(screen[i][j] == (Object)7 || screen[i][j] ==(Object) 8 || screen[i][j] == (Object)9) {
					   redcount++;
					   se.push(i);
					   ss.push(j);
				   }
			   }
		  }	
	}
	public Stack coord(int x,int y, Object[][] screen,Stack se, Stack ss) {
		 for(int i =0;i<redcount;i++) {
			 if(!se.isEmpty()) {
				 int num1 = (int)se.peek();
				 int num2 = (int )ss.peek();
				 while((num1!=y || num2 != x)) {
						
					 Random r = new Random();
						int direction = r.nextInt(4) + 1;
						if(direction == 1 && screen[y][x+1] != (Object)'#' ) {
							x++;
							s1.push(x);s2.push(y);
							counter++;
							if(screen[y][x+1] != (Object) '#' || screen[y-1][x] != (Object) '#'  ||screen[y+1][x] != (Object) '#') {
								temp1.push(x);temp2.push(y);
							}
						}
						else if(direction == 2 && screen[y-1][x] != (Object)'#' ) {
							y--;
							s1.push(x);s2.push(y);counter++;
							if(screen[y][x+1] != (Object) '#' || screen[y-1][x] != (Object) '#'  ||screen[y][x-1] != (Object) '#') {
								temp1.push(x);temp2.push(y);
							}
						}
						else if(direction == 3 && screen[y][x-1] != (Object)'#') {
							x--;
							s1.push(x);s2.push(y);counter++;
							if(screen[y][x-1] != (Object) '#' || screen[y-1][x] != (Object) '#'  ||screen[y+1][x] != (Object) '#') {
								temp1.push(x);temp2.push(y);
							}
						}
						else if(direction == 4 && screen[y+1][x] != (Object)'#' ) {
							y++;
							s1.push(x);s2.push(y);counter++;
							if(screen[y+1][x] != (Object) '#' || screen[y][x+1] != (Object) '#'  ||screen[y][x-1] != (Object) '#') {
								temp1.push(x);temp2.push(y);
							}
						}
						
						if(screen[y][x+1] == (Object)'#'  &&screen[y-1][x] == (Object) '#' && screen[y+1][x] == (Object) '#') {
							while(s1.peek() != temp1.peek() && s2.peek() != temp2.peek()) {
								s1.pop();s2.pop();counter--;
							}
						}
						
						if(screen[y-1][x] == (Object)'#'  && screen[y][x+1] == (Object) '#'  && screen[y][x-1] == (Object) '#') {
							while(s1.peek() != temp1.peek() && s2.peek() != temp2.peek()) {
								s1.pop();s2.pop();counter--;
							}
						}
						
						if (screen[y][x-1] == (Object)'#' &&  screen[y-1][x] == (Object) '#'  && screen[y+1][x] == (Object) '#'){
							while(s1.peek() != temp1.peek() && s2.peek() != temp2.peek()) {
								s1.pop();s2.pop();counter--;
							}
						}
						
						if(screen[y+1][x] == (Object)'#'  && screen[y][x+1] == (Object) '#'  && screen[y][x-1] == (Object) '#') {
							while(s1.peek() != temp1.peek() && s2.peek() != temp2.peek()) {
								s1.pop();s2.pop();counter--;
							}
						}
					}
				 se.pop();
				 ss.pop();
			 }
		 }
		 
		return s1;
	}
	public int getCounter() {
		return counter;
		
	}
	public Stack Return() {
		return s2;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}