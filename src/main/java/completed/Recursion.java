package completed;


public class Recursion 
{   
    public static int sumNatural(int num)
    {
        if (num <= 0)
        {
            return 0;
        }
        
        return sumNatural(num - 1) + num;
    }
    
    public static String toBin(int num)
    {
        int quotient = num / 2;
        
        if (quotient == 0)
        {
            return "1";
        }
        
        return toBin(quotient) + String.valueOf(num % 2);
    }
    
    public static boolean isPalindrome(String string)
    {
        System.out.println(string);
        if (string.length() <= 1)
        {
            return true;
        }
        
        if (string.charAt(0) != string.charAt(string.length() - 1))
        {
            return false;
        }
        
        return isPalindrome(string.substring(1, string.length() - 1));
    }
    
    public static String reverse(String string)
    {
        if (string.isEmpty())
        {
            return "";
        }
        
        return reverse(string.substring(1)) + string.charAt(0);
    }
}
