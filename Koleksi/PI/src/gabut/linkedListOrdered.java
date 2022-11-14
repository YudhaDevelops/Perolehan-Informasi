package gabut;

import java.util.LinkedList;
import java.util.ListIterator;

public class linkedListOrdered<E> extends LinkedList<E> {
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
    public E get(E value){
        ListIterator<E> iterator = this.listIterator();
        while (iterator.hasNext()) {            
            E temp = iterator.next();
            if (((Comparable) temp).compareTo(value) == 0) {
                return temp;
            }
        }
        return null;
    }
    
}
