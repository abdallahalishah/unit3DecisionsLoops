import java.util.Scanner;

public class CountMatches
{
    /**
     * Counts the nuymber of spaces (' ') in the specified string.
     */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scan.nextLine();
        int spaces = 0;
        for (int i = 1; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (ch == ' ')
            {
                spaces++;
            }
        }
        
        System.out.println("Number of spaces: " + spaces);
    }
}
