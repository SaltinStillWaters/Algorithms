
public class BruteForce 
{
    public static void selectionSort(int []array)
    {
        for (int unsorted = 0; unsorted < array.length; ++unsorted)
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
