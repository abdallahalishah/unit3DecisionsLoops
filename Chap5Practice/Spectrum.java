import java.util.Scanner;
import java.lang.Math;

public class Spectrum
{
    public static void main(String[] args)
    {
        double ans = 0.01;
        while (ans!=-1.0)
        {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a wavelength: ");
            float wl = input.nextFloat();
            ans = wl;
            
            if (wl > Math.pow(10,-1))
            {
                System.out.println("\nFrequency < 3x10^9\nType: Radio Waves\n");
            }
            else if (  wl > Math.pow(10,-3)   )
            {
                System.out.println("\nFrequency: 3x10^9 - 3x10^11\nType: Microwaves\n");
            }
            else if (  wl > 7*Math.pow(10,-7)  ) 
            {
                System.out.println("\nFrequency: 3x10^11 - 4x10^14\nType: Infrared\n");
            }
            else if (  wl > 4*Math.pow(10,-7)  )
            {
                System.out.println("\nFrequency: 4x10^14 - 7.5x10^14\nType: Visible light\n");
            }
            else if (  wl > Math.pow(10,-8)  ) 
            {
                System.out.println("\nFrequency: 7.5*x10^14- 3x10^16\nType: Ultraviolet\n");
            }
            else if (  wl > Math.pow(10,-11)  ) 
            {
                System.out.println("\nFrequency: 3x10^16 - 3x10^19\nType: X-Rays\n");
            }
            else
            {
                System.out.println("\nFrequency > 3x10^191\nType: Gamma Rays\n");
            }
        }
    }
}