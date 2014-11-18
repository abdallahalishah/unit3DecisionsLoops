import java.util.Scanner;

public class LeepYear
{
    public static void main(String[] args)
    {
        while (true)
        {
            Scanner input = new Scanner(System.in);

            System.out.println("Enter a year after 1582: ");
            int year = input.nextInt();

            if (  ((year%4==0) && (year%100!=0))   ||   ((year%400==0))   )
            {
                System.out.println("This year is a leap year.\n");
            }
            else
            {
                System.out.println("This year is not a leap year.\n");
            }
        }
    }
}