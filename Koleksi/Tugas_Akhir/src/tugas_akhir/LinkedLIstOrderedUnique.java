package tugas_akhir;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class LinkedLIstOrderedUnique<E> extends LinkedList<E> {

    LinkedLIstOrderedUnique dataDokumen;
    public boolean addSort(E value) {
        ListIterator<E> iteratorData = this.listIterator();
        while (iteratorData.hasNext()) {
            E data = iteratorData.next();
            if (((Comparable) data).compareTo(value) > 0) {
                iteratorData.previous();
                iteratorData.add(value);
                return true;
            } else if (((Comparable) data).compareTo(value) == 0) {
                return true;
            }
        }
        iteratorData.add(value);
        return true;
    }

    public boolean addTerm(Term value) {
        ListIterator<E> iteratorData = this.listIterator();
        while (iteratorData.hasNext()) {
            Term data = (Term) iteratorData.next();
            if (((Comparable) data.getNama()).compareTo(value.getNama()) > 0) {
                iteratorData.previous();
                iteratorData.add((E) value);
                return true;
            } else if (((Comparable) data.getNama()).compareTo(value.getNama()) == 0) {
                return true;
            }
        }
        iteratorData.add((E) value);
        return true;
    }

    public void search(String data) {
        Term value = new Term(data);
        ListIterator<E> iterator = this.listIterator();
        while (iterator.hasNext()) {
            Term temp = (Term) iterator.next();
            if ((temp.getNama()).equals(value.getNama())) {
                System.out.println("Hasil : " + temp.getNama());
                System.out.print("Terletak di : " + temp.getDokumen());
                System.out.println("");
            }
        }
    }

    public Term getKamus(String value) {
        ListIterator<E> iterator = this.listIterator();
        while (iterator.hasNext()) {
            Term temp = (Term) iterator.next();
            if (((Comparable) temp.getNama()).compareTo(value) == 0) {
                return temp;
            }
        }
        return null;
    }

    public E get(E value) {
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
