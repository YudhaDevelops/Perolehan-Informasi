package tugas_pengantar_kelompok;

import java.util.Iterator;
import java.util.ListIterator;

public class term {
    String nama;
    LinkedLIstOrderedUnique dokumen;

    public term(String nama) {
        this.nama = nama;
        dokumen = new LinkedLIstOrderedUnique();
    }
    public term() {
        this.nama = null;
        dokumen = new LinkedLIstOrderedUnique();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void addDokumen(String dokumen){
        this.dokumen.addSort(dokumen);
    }

    public LinkedLIstOrderedUnique getDokumen() {
        return dokumen;
    }
    
    public String getStringDokumen(){
        String doc = "";
        for (Object data : this.dokumen) {
            doc += "" + data + ", ";
        }
        return doc;
    }
    
}
