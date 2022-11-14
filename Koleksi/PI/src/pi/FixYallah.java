package pi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FixYallah {
    public static void main(String[] args) {
        String path = "..\\Koleksi";
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan kata yang di cari : ");
        String kataQuery = input.nextLine();
        
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
                                    if (token.equalsIgnoreCase(kataQuery)) {
                                        System.out.println(directoryName + " " + token);
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
    }  
     
    
}
