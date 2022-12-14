package tugas_akhir;
public class Term implements Comparable{
    String nama;
    LinkedLIstOrderedUnique dokumen;

    public Term(String nama) {
        this.nama = nama;
        dokumen = new LinkedLIstOrderedUnique();
    }
    public Term() {
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

    @Override
    public int compareTo(Object o) {
        return nama.compareTo( ( (Term)o).nama);
    }
    
}
