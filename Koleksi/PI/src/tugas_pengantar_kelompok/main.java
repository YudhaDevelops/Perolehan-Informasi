package tugas_pengantar_kelompok;
public class main {
    public static void main(String[] args) {
        invertexIndex data = new invertexIndex();
        data.add("lumpia", "dok1.txt");
        data.add("rabu", "dok2.txt");
        data.add("lumpia", "dok2.txt");
        data.add("bakwan","dok3.txt");
        data.add("bakwan","dok5.txt");
        data.add("bakwan","dok7.txt");
        data.add("bakwan","dok4.txt");
        
        System.out.println();
        data.cetak();
    }
    
}
