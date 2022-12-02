package tugas_akhir;

import java.util.ArrayList;
import java.util.ListIterator;

public class invertexIndex {

    LinkedLIstOrderedUnique<term> kamus;
    LinkedLIstOrderedUnique dataDoc;
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
            this.kamus.addTerm(temp);
        } else {
            //klk data dictionary nya dah ada //cari data nya
            term data = this.kamus.get(temp);
            data.addDokumen(dokumen);
        }
    }

    public void searchDoc(String value) {
        String [] key = value.split(" ");
        
        if (key.length == 1) {
            term temp = new term(value);
            term hasil = this.kamus.get(temp);
            if (hasil != null) {
                LinkedLIstOrderedUnique hasilCari = hasil.getDokumen();
                cetakHasil(hasilCari);
                System.out.println(hasilCari.size());
            } else {
                System.out.println("Data Yang Anda Cari Tidak Ada");
            }
        }else{
            for (int i = 0; i < key.length; i++) {
                
            }
        }
    }

    public void searchDuaData(String data) {
//        term temp1 = new term(data1);
//        term temp2 = new term(data2);

//        term doc1 = this.kamus.get(temp1);
//        term doc2 = this.kamus.get(temp2);

//        LinkedLIstOrderedUnique hasilData1 = doc1.getDokumen();
//        LinkedLIstOrderedUnique hasilData2 = doc2.getDokumen();
        
//        if (hasilData1.size() > hasilData2.size()) {
//            intersec(hasilData1,hasilData2);
//        }else{
//            intersec(hasilData2,hasilData1);
//        }
    }
    
    public void intersec(LinkedLIstOrderedUnique data1, LinkedLIstOrderedUnique data2){
        LinkedLIstOrderedUnique temp;
        for (int i = 0; i < data1.size(); i++) {
            
        }
    }

    public void cetakHasil(LinkedLIstOrderedUnique data) {
        System.out.println(data);
    }
}
