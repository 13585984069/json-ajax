package json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JJChen
 * @version 1.0
 */
public class javaJson {
    public static void main(String[] args) {
        // javaBean -> json
        Book hsp = new Book(100, "hsp");
        Gson gson = new Gson();
        String s = gson.toJson(hsp);
        // 底层是反射
        Book book = gson.fromJson(s, Book.class);
        System.out.println(book);
        // list ->json
        List<Book> books = new ArrayList<>();
        books.add(new Book(200, "aa"));
        books.add(new Book(300, "bb"));
        String s1 = gson.toJson(books);
        System.out.println(s1);
        // json -> list 字符串， 需要使用gson提供的typeToken
        // type返回类型完整路径,以此来完成反射
        Type type = new TypeToken<List<Book>>(){}.getType(); //注意{},匿名内部类，既是定义又是实参 相当于子类
        List<Book> list = gson.fromJson(s1, type);
        System.out.println(list);
        // map -> json
        Map<Integer, Book> map = new HashMap<>();
        map.put(1, new Book(11, "cc"));
        map.put(2, new Book(22, "jj"));
        String s2 = gson.toJson(map);
        System.out.println(s2);
        Map<Integer, Book> maps = gson.fromJson(s2, new TypeToken<Map<Integer, Book>>() {}.getType());
        System.out.println(maps);

    }
}

interface Ai{
    public void f1();
}
