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
    
    public void search(String data){
        this.kamus.search(data);
    }
    
    
    public void add(String term,String dokumen){
        term temp = new term(term);
        temp.setNama(term);
        temp.addDokumen(dokumen);
        if (this.kamus.getInputString(temp.getNama()) == null) {
            //kalo data nya masih kosong
            this.kamus.addTerm(temp);
        }else{
            //klk data dictionary nya dah ada //cari data nya
            term data = this.kamus.getInputString(temp.getNama());
            data.addDokumen(dokumen);
        }
    }
    
    public void searchDoc(String value){
        term temp = new term(value);
        term hasil = this.kamus.get(temp);
        System.out.println("");
        
        LinkedLIstOrderedUnique hasilCari = hasil.getDokumen();
        System.out.println(hasilCari);
    }
}
