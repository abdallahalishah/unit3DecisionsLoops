import java.util.Scanner;
import java.util.Random;

public class SwapLetters
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = scan.next();
        
        for (int i = 0; i < word.length(); i++)
        {
            System.out.println(word);
        }
        
        Random gen = new Random();
        int i = gen.nextInt(word.length()-1);
        
        int j = gen.nextInt(word.length());
        while (j <= i)
        {
            j = gen.nextInt(word.length());
        }
                
        System.out.println(i + " " + j);
        System.out.println("i: "+word.charAt(i) + "\nj: " + word.charAt(j)+"\n");
        
        word = word.substring(0,i) + word.charAt(j) + word.substring(i+1,j) + word.charAt(i) +
                        word.substring(j+1);
        
        System.out.println(word);
        
        
    }
}
