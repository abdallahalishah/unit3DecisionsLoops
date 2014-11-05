
public class NestedWhileLoops

{
    public static void main(String[] args)
    {
        int counter = 0;
        int n = 0;
        
        while (n < 2)
        {
            counter += 1;
            int counter2 = 0;
            int y = 0;
            //n += 1;
            while (y < 4)
            {
                counter2 += 1;
                System.out.println(counter + " " + counter2);
                y += 1;
            }
            
        }
    }
}
