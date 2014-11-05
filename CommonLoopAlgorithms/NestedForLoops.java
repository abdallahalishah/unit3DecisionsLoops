
public class NestedForLoops

{
    public static void main(String[] args)
    {
        int counter = 0;
        for (int i = 0; i < 2; i++)
        {
            int counter2 = 0;
            counter += 1;
            for (int n = 0; n < 4; n++)
            {
                counter2 += 1;
                System.out.println(counter + " " + counter2);
            }
            
        }
    }
}
