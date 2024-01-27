package completed;


public class BruteForce 
{
    public static int stringSearch(String orig, String toFind)
    {
        for (int x = 0; x < orig.length(); ++x)
        {
            //an index of -1 marks that orig[x] != toFind[0]
            int index = -1;
            
            //early return in case toFind is longer than the rest of the unfiltered characters of orig
            if (toFind.length() > orig.length() - x)
            {
                return -1;
            }
            
            for (int y = 0; y < toFind.length(); ++y)
            {
                if (orig.charAt(x + y) == toFind.charAt(y))
                {
                    //if there was a match and it was with toFind[0],
                    //then save that index as it could be the answer
                    if (index == -1)
                    {
                        index = x + y;
                    }
                    
                    //if all characters of toFind has been searched through,
                    //then an answer has been found
                    if (y == toFind.length() - 1)
                    {
                        return index;
                    }
                }
                else
                {
                    //if there is no match, then simply end comparison
                    break;
                }
            }
        }
        
        //this is only reached if no match was found
        return -1;
    }
    
    public static void selectionSort(int []array)
    {
        //unsorted represents the index of the start of the unsorted array
        for (int unsorted = 0; unsorted < array.length - 1; ++unsorted)
        {
            int min = unsorted;
            
            //find a number less than min
            for (int toSearch = min + 1; toSearch < array.length; ++toSearch)
            {
                //once a number is found, swap its index with min
                if (array[toSearch] < array[min])
                {
                    min = toSearch;
                }
            }
            
            //swap the min value to the start of the unsorted array
            int temp = array[unsorted];
            array[unsorted] = array[min];
            array[min] = temp;
        }
    }
}
