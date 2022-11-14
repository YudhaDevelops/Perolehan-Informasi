package tugas_pengantar_kelompok;
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
}
