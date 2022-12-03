package tugas_akhir;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Tugas_Akhir {
    public static void main(String[] args) {
        InvertexIndex invertex = new InvertexIndex();
        int jumlah;
        //baca file 
        String path = "..\\Koleksi";
        Scanner input;
        
        File name = new File(path);
        if (name.exists()) {
            if (name.isDirectory()) {
                String directory[] = name.list();
//                System.out.println("\n\nDirectory contents : \n");
                System.out.println("\n--------------------------------------");
                for (String directoryName : directory) {
//                    System.out.printf("%s\n", directoryName);
                    try {
                        input = new Scanner (new File(name.getAbsolutePath()+"\\"+directoryName));
                        System.out.println("\n Memasukkan Data Dari File " + directoryName + " :");
                        try {
                            while (input.hasNext()) {
                                String sentence = input.nextLine();
                                StringTokenizer st = new StringTokenizer(sentence," ~!@#$%^&*()_+`1234567890-={}|:<>?[]\";'\\,./'");
                                while (st.hasMoreTokens()) {                                    
                                    invertex.add(st.nextToken(), directoryName);
                                }
//                                String[] tokens = sentence.split(" ");
//                                for (String token : tokens) {
//                                    if (token.isEmpty()) {
//                                        continue;
//                                    }else{
////                                        System.out.println(directoryName + " " + token);
//                                        invertex.add(token.toLowerCase(), directoryName);
//                                    }
//                                }
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
                }
                System.out.println("\n--------------------------------------");
            }else{
                System.out.println("Tidak nemu");
            }
        }else{
            System.out.printf("%s %s", path, "does not exist");
        }
        
        input = new Scanner(System.in);
        System.out.println("Masukkan Query yang di pisah kan dengan spasi");
        System.out.print("Masukkan Query : ");
        String data = input.nextLine();
        
        StringTokenizer st = new StringTokenizer(data," ~!@#$%^&*()_+`1234567890-={}|:<>?[],./'");
        
        String [] query = new String[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens()) {            
            query[i] = st.nextToken();
            i++;
        }
        System.out.println("");
        invertex.searchDoc(query);
    }
}
