import java.util.Random;
import java.util.Scanner;
public class DrunkardWalk
{
    public static void main(String[] args)
    {
        Random gen = new Random();
        Scanner scan = new Scanner(System.in);
        String ans = scan.next();
        int num = gen.nextInt(4)+1;
        int x=0,y=0;
        while (ans != "n")
        {
            //north = 1, east = 2, south = 3, west = 4
            for (int i = 0; i < 100; i++)
            {
                if (num == 1){y+=1;}
                if (num == 2){x+=1;}
                if (num == 3){y-=1;}
                if (num == 4){x-=1;}
                num = gen.nextInt(4)+1;
            }
            System.out.print("("+x+","+y+")");
            ans = scan.next();
        }
        
        System.out.print("("+x+","+y+")");
        
    }
}
