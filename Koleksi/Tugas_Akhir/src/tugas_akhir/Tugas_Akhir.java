package tugas_akhir;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Tugas_Akhir {
    public static void main(String[] args) {
        invertexIndex invertex = new invertexIndex();
        String [] query;
        //baca file 
        String path = "..\\Koleksi";
        Scanner input;
        
        File name = new File(path);
        if (name.exists()) {
            if (name.isDirectory()) {
                String directory[] = name.list();
                System.out.println("\n\nDirectory contents : \n");
                
                for (String directoryName : directory) {
                    System.out.printf("%s\n", directoryName);
                    
                    try {
                        input = new Scanner (new File(name.getAbsolutePath()+"\\"+directoryName));
                        
                        try {
                            while (input.hasNext()) {
                                String sentence = input.nextLine();
                                String[] tokens = sentence.split(" ");
                                for (String token : tokens) {
                                    if (token.isEmpty()) {
                                        continue;
                                    }else{
                                        System.out.println(directoryName + " " + token);
                                        invertex.add(token, directoryName);
                                    }
                                }
                            }//end while
                        } catch (NoSuchElementException elementException) {
                            System.out.println("File improperly formed.");
                            input.close();
                            System.exit(1);
                        }//end catch
                    } catch (FileNotFoundException fileNotFoundException) {
                        System.out.println("Error opening file.");
                        System.exit(1);
                    }
                    System.out.println("");
                }
            }else{
                System.out.println("Tidak nemu");
            }
        }else{
            System.out.printf("%s %s", path, "does not exist");
        }
        
        input = new Scanner(System.in);

        //input jumlah kata yang ingin di cari
        System.out.print("Masukkan Jumlah Kata Yg Ingin di Cari : ");
        int jmlh = input.nextInt();
//        int jmlh = 2;
        
        
        query = new String [jmlh];
//        String []query = {"dan","jalan"};
        for (int i = 0; i < jmlh; i++) {
        //inputan cari data
            System.out.print("Input Kata Yang Ingin Di Cari : ");
            String data = input.next();
            query[i] = data;
        }
        
        System.out.println("Data yang di cari satu persatu\n");
        for (int i = 0; i < query.length; i++) {
            invertex.search(query[i]);
        }
        System.out.println("\n\n\n");
        System.out.println("Data Yang di cari sekaligus berdasarkan jumlah inputan");
        invertex.searchBanyak(query);
    }
    
}
