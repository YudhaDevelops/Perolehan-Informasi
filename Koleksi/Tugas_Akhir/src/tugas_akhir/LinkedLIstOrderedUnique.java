package tugas_akhir;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class LinkedLIstOrderedUnique<E> extends LinkedList<E> {

    LinkedLIstOrderedUnique dataDokumen;
    ArrayList<String> dataTampung = new ArrayList<String>();

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

    public boolean addTerm(term value) {
        ListIterator<E> iteratorData = this.listIterator();
        while (iteratorData.hasNext()) {
            term data = (term) iteratorData.next();
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
        term value = new term(data);
        ListIterator<E> iterator = this.listIterator();
        while (iterator.hasNext()) {
            term temp = (term) iterator.next();
            if ((temp.getNama()).equalsIgnoreCase(value.getNama())) {
                System.out.println("Hasil : " + temp.getNama());
                System.out.print("Terletak di : " + temp.getDokumen());
                System.out.println("");
            }
        }
    }

    public void searchBanyakData(String data) {
        System.out.println("Data yang di cari : " + data);
        term dataCari = new term(data);
        ListIterator<E> iterator = this.listIterator();
        while (iterator.hasNext()) {
            term temp = (term) iterator.next();
            if ((temp.getNama()).equalsIgnoreCase(dataCari.getNama())) {
                System.out.println("Hasil : " + temp.getNama());
                System.out.print("Terletak di : " + temp.getDokumen());
                System.out.println("");

                dataDokumen = temp.getDokumen();
                ListIterator<String> it = dataDokumen.listIterator();
                while (it.hasNext()) {
                    dataTampung.add(it.next());
                }
            }
        }
    }

    public void getDaftarDoc() {
        //not use distinct
//        Iterator<String> it = dataTampung.iterator();
//        System.out.print("Berada Di : ");
//        while (it.hasNext()) {
//            System.out.print(it.next() + ", ");
//        }
        
        //use distinct
        List<String> dataUniq = dataTampung.stream().distinct().collect(Collectors.toList());
        Iterator<String> it = dataUniq.iterator();
        System.out.print("\nBerada di : ");
        while (it.hasNext()) {
            System.out.print(it.next() + ", ");
        }
    }

    public term getInputString(String value) {
        ListIterator<E> iterator = this.listIterator();
        while (iterator.hasNext()) {
            term temp = (term) iterator.next();
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
