import java.util.Scanner;

public class CompareAdjacent
{
    /**
     * Detects duplicate adjavent numbers in the specific series of numbers.
     */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a series of numbers (type 'q' to quit): ");
        
        double preValue = scan.nextDouble();
        
        while (scan.hasNextDouble())
        {
            double value = scan.nextDouble();
            if (value == preValue)
            {
                System.out.println("Duplicate number!  :)");
            }
            preValue = value;
        }
        
    }
}
 