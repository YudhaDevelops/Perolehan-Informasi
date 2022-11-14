package Materi;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedLisIterator {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList();
        linkedList.addFirst("aaa");
        linkedList.addLast("bbb");
        linkedList.addLast("ddd");
        
        ListIterator iterator;
        iterator = linkedList.listIterator();
        while (iterator.hasNext()) {            
            System.out.println(iterator.next());
        }
        System.out.println("");
        System.out.println(iterator.previous());
//        previuous adalah letak yang ada di node nya 
        iterator.add("ccc");
//        penambahan ccc dilakukan setelah iterator
        System.out.println(linkedList);
    }
    
}
