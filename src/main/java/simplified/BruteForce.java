package simplified;



public class BruteForce 
{
    public static int stringSearch(String orig, String toFind)
    {
        for (int x = 0; x < orig.length(); ++x)
        {
            int index = -1;
            
            if (toFind.length() > orig.length() - x)
            {
                return -1;
            }
            
            for (int y = 0; y < toFind.length(); ++y)
            {
                if (orig.charAt(x + y) == toFind.charAt(y))
                {
                    if (index == -1)
                    {
                        index = x + y;
                    }
                    
                    if (y == toFind.length() - 1)
                    {
                        return index;
                    }
                }
                else
                {
                    break;
                }
            }
        }
        
        return -1;
    }
    
    public static void selectionSort(int []array)
    {
        for (int unsorted = 0; unsorted < array.length - 1; ++unsorted)
        {
            int min = unsorted;
            
            for (int toSearch = min + 1; toSearch < array.length; ++toSearch)
            {
                if (array[toSearch] < array[min])
                {
                    min = toSearch;
                }
            }
            
            int temp = array[unsorted];
            array[unsorted] = array[min];
            array[min] = temp;
        }
    }
}
