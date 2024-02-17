public class InsertionSort 
{
    public static void insertionSort(int[] arr)
    {
        for (int sorted = 0; sorted < arr.length - 1; ++sorted)
        {
            int toInsert = arr[sorted + 1];
            
            int iter = sorted;
            while (iter >= 0 && toInsert < arr[iter]) 
            {
                arr[iter + 1] = arr[iter];
                --iter;
            }
            
            arr[iter + 1] = toInsert;
        }
    }
    
}