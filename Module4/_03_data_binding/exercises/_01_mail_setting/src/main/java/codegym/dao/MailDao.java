package codegym.dao;

import java.util.ArrayList;
import java.util.List;

public class MailDao {
    public static List<String> languageList;
    public static List<Integer> pageSizeList;
    static {
        languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
    }

    static {
        pageSizeList = new ArrayList<>();
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
    }

}
