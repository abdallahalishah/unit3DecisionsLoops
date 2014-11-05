import java.util.Scanner;

public class Diamond
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = scan.nextInt();
        int rows = num * 2 - 1;
        int count = 1;
        int space = num - 1;
        
        for (int i = 0; i < rows; i++)
        {
            if (i < num - 1)
            {
                for (int x = 0; x < space; x++)
                {
                    System.out.print(" ");
                }
                for (int j = 0; j < count; j++)
                {
                    System.out.print("*");
                }
                count += 2;
                space -= 1;
                System.out.println("");
            }
            else 
            {
                for (int x = 0; x < space; x++)
                {
                    System.out.print(" ");
                }
                for (int j = 0; j < count; j++)
                {
                    System.out.print("*");
                }
                count += -2;
                space += 1;
                System.out.println("");
            }
        }
        
    }
}
