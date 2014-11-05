
public class NestedDoLoops

{
    public static void main(String[] args)
    {
        int counter = 0;
        int n = 0;
        
        do
        {
            counter += 1;
            int counter2 = 0;
            int y = 0;
            n += 1;
            do
            {
                counter2 += 1;
                System.out.println(counter + " " + counter2);
                y += 1;
            }
            while (y < 4);
        }
        while (n < 2);
    }
}
