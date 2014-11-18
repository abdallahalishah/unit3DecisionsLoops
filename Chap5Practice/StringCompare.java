public class StringCompare
{
    public static void main(String[] args)
    {
        String word1 = "catalog";
        String word2 = "cat";
        if (word1.compareTo("aaa")<0)
        {
            System.out.println("word1 is less than aaa");
        }
        else if (word1.compareTo("aaa")>0)
        {
            System.out.println("word1 is greater than aaa");
        }
        else
        {
            System.out.println("word1 is equal to aaa");
        }
        if (word1.equals(word2))
        {
            System.out.println("word1 is equal to word2");
        }
        else
        {
            System.out.println("word1 is not equal to word2");
        }
        if (word1.compareTo(word2)< 0)
        {
            System.out.println("word1 is less than word2");
        }
        else if (word1.compareTo(word2)> 0)
        {
            System.out.println("word1 is greater than word2");
        }
        else
        {
            System.out.println("word1 is equal to word2");
        }
        if (word1.substring(0,3).equals(word2.substring(0,3)))
        {
            System.out.println("The 3 letter prefix of word1 is equal to the 3 letter prefix of word2");
        }
        else
        {
            System.out.println("The 3 letter prefix of word1 is not equal to the 3 letter prefix of word2");
        }
    }
}