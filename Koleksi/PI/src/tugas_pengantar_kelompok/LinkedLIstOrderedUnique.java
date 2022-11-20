package tugas_pengantar_kelompok;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class LinkedLIstOrderedUnique <E> extends LinkedList<E>{
    ArrayList<String> dataArray = new ArrayList<String>();
    
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
    
    public void cetak(){
        ListIterator<E> iterator = this.listIterator();
        while (iterator.hasNext()) {            
            term temp = (term) iterator.next();
            System.out.println("term : " + temp.getNama());
            System.out.print("Dokument : ");
            System.out.print(temp.getDokumen());
            System.out.println("\n");
        }
    }
    
    public void getApa(){
        ListIterator<E> iterator = this.listIterator();
        LinkedLIstOrderedUnique data;
        
        while (iterator.hasNext()) {            
            term temp = (term) iterator.next();
            data = temp.getDokumen();
            ListIterator<String> it = data.listIterator();
            while (it.hasNext()) {                
                dataArray.add(it.next());
            }
        }
        List<String> dataArray2;
        dataArray2 = dataArray.stream().distinct().collect(Collectors.toList());
        Iterator<String> it = dataArray2 .iterator();
        while (it.hasNext()) {            
            System.out.print(it.next()+", ");
        }
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
