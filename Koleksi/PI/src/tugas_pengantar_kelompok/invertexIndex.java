package tugas_pengantar_kelompok;

import java.util.ListIterator;

public class invertexIndex {
    LinkedLIstOrderedUnique<term> kamus;
    
    public invertexIndex() {
        kamus = new LinkedLIstOrderedUnique();
    }
    
    public void search(String data){
        ListIterator iterator;
        term temp = new term(data);
        iterator = kamus.listIterator();
        while (iterator.hasNext()) {
            
        }
    }
    
    public void add(String term,String dokumen){
        term temp = new term(term);
        temp.setNama(term);
        temp.addDokumen(dokumen);
        if (this.kamus.getInputString(temp.getNama()) == null) {
            //kalo data nya masih kosong
            this.kamus.addTerm(temp);
//            dictionary.addDokumen(dokumen);
//            this.dictionary.addDokumen(dokumen);
        }else{
            //klk data dictionary nya dah ada
            //cari data nya
            term data = this.kamus.getInputString(temp.getNama());
            data.addDokumen(dokumen);
//            dictionary = new term();
//            dictionary.setNama(term);
//            dictionary.addDokumen(dokumen);
//            this.kamus.addSort(dictionary);
        }
    }
    
}
