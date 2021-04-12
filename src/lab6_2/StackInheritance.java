package lab6_2;
import java.util.ArrayList;

public class StackInheritance extends ArrayList<Object> {
    private int capacity;

    public StackInheritance(int initialCapacity) {
        super(initialCapacity);
        this.capacity = initialCapacity;
    }

    public void push(Object object) {
        if (this.size() < this.capacity) {
            super.add(object);
        }
    }

    public void pop() {
        super.remove(super.size()-1);
    }

    public Object top() {
        if ( this.isEmpty() ) {
            return null;
        }
        return super.get(super.size()-1);
    }

    public boolean isEmpty() {
        return (super.size() == 0) ;
    }

    public boolean isFull() {
        return (super.size() == this.capacity);
    }

    public int getSize() {
        return super.size();
    }

}
