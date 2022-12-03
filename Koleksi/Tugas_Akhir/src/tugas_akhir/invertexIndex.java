package tugas_akhir;

import java.util.ArrayList;
import java.util.ListIterator;

public class invertexIndex {

    LinkedLIstOrderedUnique<term> kamus;

    ArrayList<LinkedLIstOrderedUnique> dataBesar = new ArrayList<LinkedLIstOrderedUnique>();

    public invertexIndex() {
        kamus = new LinkedLIstOrderedUnique();
    }

    public void search(String data) {
        this.kamus.search(data);
    }

    public void add(String term, String dokumen) {
        term temp = new term(term);
        temp.setNama(term);
        temp.addDokumen(dokumen);
        if (this.kamus.get(temp) == null) {
            //kalo data nya masih kosong
            this.kamus.addSort(temp);
        } else {
            //klk data dictionary nya dah ada //cari data nya
            term data = this.kamus.get(temp);
            data.addDokumen(dokumen);
        }
    }

    public void searchDoc(String[] data) {
//        ArrayList<term> dataTemp = new ArrayList<>();

        if (data.length == 1) {
            term temp = new term(data[0]);
            term hasil = this.kamus.get(temp);
            if (hasil != null) {
                LinkedLIstOrderedUnique hasilCari = hasil.getDokumen();
                cetakHasil(hasilCari);
            } else {
                System.out.println("Data Yang Anda Cari Tidak Ada");
            }
        } else {
            LinkedLIstOrderedUnique<term> dataBaru = new LinkedLIstOrderedUnique<>();
            for (int i = 0; i < data.length; i++) {
                term temp = new term(data[i]);
                term hasil = this.kamus.getKamus(temp.getNama());
                if (hasil != null) {
                    dataBaru.add(hasil);
                }
            }

            term tempp = new term();
            for (int i = 0; i < dataBaru.size() - 1; i++) {
                for (int j = 0; j < dataBaru.size() - 1; j++) {
                    if (dataBaru.get(j).getDokumen().size() > dataBaru.get(j + 1).getDokumen().size()) {
                        tempp = dataBaru.get(j);
                        dataBaru.set(j, dataBaru.get(j + 1));
                        dataBaru.set(j + 1, tempp);
                    }
                }
            }

            if (dataBaru.size() > 1) {
                LinkedLIstOrderedUnique docKamus1 = dataBaru.get(0).getDokumen();
                for (int i = 1; i < dataBaru.size(); i++) {
                    LinkedLIstOrderedUnique docKamus2 = dataBaru.get(i).getDokumen();
                    docKamus1 = intersec(docKamus1, docKamus2);
                }
                if (docKamus1.size() < 1) {
                    System.out.println("Query Tidak Di Temukan Di Dokumen Manapun");
                }else{
                    cetakHasil(docKamus1);
                }
            }
        }
    }

    public LinkedLIstOrderedUnique intersec(LinkedLIstOrderedUnique data1, LinkedLIstOrderedUnique data2) {
        LinkedLIstOrderedUnique temp = new LinkedLIstOrderedUnique();
        for (int i = 0; i < data2.size(); i++) {
            for (int j = 0; j < data1.size(); j++) {
                if (data2.get(i).equals(data1.get(j))) {
                    temp.add(data2.get(i));
                }
            }
        }
        return temp;
    }

    public void cetakHasil(LinkedLIstOrderedUnique data) {
        for (int i = 0; i < data.size(); i++) {
            System.out.print(data.get(i) + ", ");
        }
        System.out.println("");
    }
}
