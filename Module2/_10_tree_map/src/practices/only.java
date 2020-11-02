package practices;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class only {
    public static void main(String[] args) {
        Stack<Integer> list = new Stack<>();
        Stack<Integer> left = new Stack<>();
        Stack<Integer> result = new Stack<>();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(1);
        list.push(2);

        while (list.isEmpty()){
            int element = list.pop();
            if (list.contains(element)){
                left.push(element);
            } else {
                if (!left.contains(element)){
                    result.push(element);
                }
            }
        }

        for (int integer: result){
            System.out.println(integer);
        }

    }
}
