package pi;

import java.util.Scanner;

public class TokenTest {
    public static void main(String[] args) {
        //get sentence
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a sentence and press enter");
        String sentence = input.nextLine();
        
        //proses query dari user
        String[] tokens = sentence.split(" ");
        System.out.printf("Number of elements: %d\n The Tokens are: \n ", tokens.length);
        
        for (String token : tokens) {
            if (token.equalsIgnoreCase("saya")) {
                System.out.println("kata saya sama \n\n");
            }
            System.out.println(token);
        }
    }
    
}
