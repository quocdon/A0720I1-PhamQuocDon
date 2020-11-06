package practices;

import java.util.ArrayList;
import java.util.List;

public class UniqueValue {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Integer a = Integer.valueOf(1);
        Integer b = Integer.valueOf(2);
        Integer c = Integer.valueOf(3);
        Integer d = Integer.valueOf(4);
        Integer e = Integer.valueOf(5);
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(e);
        list.add(a);
        list.add(b);
        list.add(b);
    // Duyệt mảng, nếu như Index của đối tượng bằng với lastIndex của nó thì nó là duy nhất
    //Add đối tượng duy nhất vào mảng result
        for (Integer number : list) {
            if (list.indexOf(number) == list.lastIndexOf(number)) {
                result.add(number);
            }
        }
        System.out.println("Danh sách ban đầu");
        for (Integer number : list) {
            System.out.print(number + "\t");
        }
        System.out.println();
        System.out.println("Danh sách các đối tượng duy nhất");
        for (Integer number : result) {
            System.out.print(number + "\t");
        }
    }
}
