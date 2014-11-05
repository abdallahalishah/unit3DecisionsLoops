import java.util.Scanner;
import java.util.Random;

public class GuessingGame
{
    public static void main(String[] args)
    {
        String ans = "n";
        while (ans == "n")
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("Choose a Door 1-3 for your guess: ");
            int user = scan.nextInt();
            Random gen = new Random();
            int rand = gen.nextInt(3) + 1;
            if (user == rand)
            {
                System.out.println("That is correct. You got the car!");
                ans = "y";
            }
            else
            {
                System.out.println("Nope, that's wrong.");
            }
        }
    }
}
