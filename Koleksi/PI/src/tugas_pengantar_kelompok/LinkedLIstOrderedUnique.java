package tugas_pengantar_kelompok;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedLIstOrderedUnique <E> extends LinkedList<E>{
    
    public boolean addSort(E value){
        ListIterator<E> iteratorData = this.listIterator();
        while(iteratorData.hasNext()){
            E data = iteratorData.next();
            if ( ( (Comparable) data).compareTo(value) > 0) {
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
    public boolean addTerm(term value){
        ListIterator<E> iteratorData = this.listIterator();
        while(iteratorData.hasNext()){
            term data = (term) iteratorData.next();
            if ( ( (Comparable) data.getNama()).compareTo(value.getNama()) > 0) {
                iteratorData.previous();
                iteratorData.add((E) value);
                return true;
            }else if(((Comparable) data.getNama()).compareTo(value.getNama()) == 0){
                return true;
            }
        }
        iteratorData.add((E) value);
        return true;
    }
    
    public term getInputString(String value){
        ListIterator<E> iterator = this.listIterator();
        while (iterator.hasNext()) {            
            term temp = (term) iterator.next();
            if (((Comparable) temp.getNama()).compareTo(value) == 0) {
                return temp;
            }
        }
        return null;
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
