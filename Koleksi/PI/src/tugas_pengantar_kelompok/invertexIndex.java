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
        }else{
            term data = this.kamus.getInputString(temp.getNama());
            data.addDokumen(dokumen);
        }
    }
    
    public void cetak(){
        this.kamus.cetak();
        System.out.println("\n");
        this.kamus.getApa();
    }

//    @Override
//    public String toString() {
//        return "Kamus : \t\t"
//                + "\n" + kamus.;
//    }
    
}
