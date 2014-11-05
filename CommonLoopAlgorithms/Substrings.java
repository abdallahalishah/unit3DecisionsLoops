import java.util.Scanner;

public class Substrings
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an word: ");
        String word = scan.next();
        int num=1;
        for (int i = 0; i < word.length(); i++)
        {
            
            for (int j = 0; j < word.length()-num+1; j++)
            {
                System.out.println(word.substring(j,j+num));
            }
            num+=1;
        }
        
        
        
    }
}
