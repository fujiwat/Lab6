package lab6_2;
import java.util.ArrayList; // import the ArrayList class

public class StackAggregation  {
    private static ArrayList<Object> stack = new ArrayList<>();
    private int capacity;

    public StackAggregation(int capacity) {
        this.capacity = capacity;
    }

    public void push(Object object) {
        if ( stack.size() < this.capacity ) {
            stack.add(object);
        }
    }

    public void pop() {
        stack.remove(stack.size()-1);
    }

    public Object top() {
        if ( this.isEmpty() ) {
            return null;
        }
        return stack.get(stack.size()-1);
    }

    public boolean isEmpty() {
        return (stack.size() == 0) ;
    }

    public boolean isFull() {
        return (stack.size() == this.capacity);
    }

    public int getSize() {
        return stack.size();
    }
}
