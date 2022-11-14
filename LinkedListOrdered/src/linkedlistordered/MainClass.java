package linkedlistordered;

import java.util.ListIterator;

public class MainClass {
    public static void main(String[] args) {
        LinkedListOrdered dataList = new LinkedListOrdered();
        LinkedLIstOrderedUnique list = new LinkedLIstOrderedUnique();
        
        dataList.addSort("zzz");
        dataList.addSort("bbb");
        dataList.addSort("eee");
        dataList.addSort("ccc");
        dataList.addSort("ccc");
        dataList.addSort("aaa");
        
        
        System.out.println("LinkedList Biasa");
        System.out.println(dataList);
        System.out.println("");
        
        list.addSort("zzz");
        list.addSort("bbb");
        list.addSort("eee");
        list.addSort("ccc");
        list.addSort("ccc");
        list.addSort("aaa");
        
        System.out.println("LinkedList Unik");
        System.out.println(list);
        System.out.println("");
    }
}
