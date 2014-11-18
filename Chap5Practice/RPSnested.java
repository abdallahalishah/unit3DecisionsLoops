import java.util.Scanner;
public class RPSnested
{
     public static void main(String[] args)
    {
        while (true)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("Player 1: Choose rock, scissors, or paper: ");
            String player1 = scan.next().toLowerCase();
            System.out.println("Player 2: Choose rock, scissors, or paper: ");
            String player2 = scan.next().toLowerCase(); 
            //(your code goes here…)
            
            if (player1.equals(player2))
            {
                System.out.println("It is a tie");            
            }
            else
            {
                if (player1.equals("rock") && player2.equals("scissors"))
                {
                    System.out.println("Player 1 wins");
                }
                else
                {
                    if (player1.equals("paper") && player2.equals("rock"))
                    {
                        System.out.println("Player 1 wins");
                    }
                    else
                    {
                        if (player1.equals("scissors") && player2.equals("paper"))
                        {
                            System.out.println("Player 1 wins");
                        }
                        else
                        {
                            if (player2.equals("rock") && player1.equals("scissors"))
                            {
                                System.out.println("Player 2 wins");
                            }
                            else
                            {
                                if (player2.equals("paper") && player1.equals("rock"))
                                {
                                    System.out.println("Player 2 wins");
                                }
                                else
                                {
                                    System.out.println("Player 2 wins");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}