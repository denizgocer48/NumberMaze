public class Stack {
	private int top;
    private Object[] elements;
    
    
    public Stack(int capacity){
        elements = new Object[capacity];
        top= -1;
    }

    public void push(Object data) {
        if(isFull()) {        	
        }         
        else {
            top++;
            elements[top] = data;
        }
    }
    
    public Object pop() {
        if(isEmpty()) {
            return null;
        }
        else {
            Object retData = elements[top];
            top--;
            return retData;
        }
    }
    public Object peek() {
        if(isEmpty()) {
            return null;
        }
        else
            return elements[top];
    }
    
    
    public boolean isEmpty() {
        return(top == -1);
    }
    
    public boolean isFull() {
        return (top + 1 == elements.length);
    }
    
    public int size() {
        return top+1;
    }
}
