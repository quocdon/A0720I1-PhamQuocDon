package practices.my_generic_stack;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyGenericStack<T> {
    private LinkedList<T> stack;

    public MyGenericStack() {
        this.stack = new LinkedList<>();
    }

    public void push(T element){
        stack.addLast(element);
    }

    public T pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        } else return stack.removeLast();
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
