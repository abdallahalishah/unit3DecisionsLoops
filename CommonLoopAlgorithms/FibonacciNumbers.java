import java.util.Scanner;

public class FibonacciNumbers
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an integer to indicate the number of the Fibonacci Sequence displayed: ");
        int user = scan.nextInt();
        int fold1 = 1;
        int fold2 = 1;
        int foldnew = 2;
        for (int i = 2; i < user ; i++)
        {
            foldnew = fold2 + fold1;
            fold1 = fold2;
            fold2 = foldnew;
            
        }
        if (user==1){System.out.print("The corresponding fibonacci number is: " + fold1);}
        else if (user==2){System.out.print("The corresponding fibonacci number is: " + fold1);}
        else
        {
            System.out.print("The corresponding fibonacci number is: " + foldnew);
        }
    }
}
