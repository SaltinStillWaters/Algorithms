package salt.recursion;


public class Recursion 
{
    public static void main(String[] args) 
    {
        int[] array = {1, 2, 0, 5, 10, 0, 7, 6};
        
        test.mergeSort(array, 0, array.length - 1);
        
        for (int num : array)
        {
            System.out.println(num);
        }
    }
    
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
