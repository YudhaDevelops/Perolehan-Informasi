package linkedlistordered;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedLIstOrderedUnique <E> extends LinkedList<E>{
    public boolean addSort(E value){
        ListIterator<E> iteratorData = this.listIterator();
        while(iteratorData.hasNext()){
            E data = iteratorData.next();
            if ( ( (Comparable) data).compareTo(value) > 0) {
//                data di casting menjadi object Comparable agar dapat di bandingkan dengan data object value
                iteratorData.previous();
                iteratorData.add(value);
                return true;
            }else if(((Comparable) data).compareTo(value) == 0){
                return true;
            }
        }
        iteratorData.add(value);
        return true;
    }
    
}
