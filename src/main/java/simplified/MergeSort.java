package simplified;


public class MergeSort 
{
    public static void mergeSort(int []array, int start, int end)
    {
        if (start < end)
        {
            int mid = (start + end) / 2;
            
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            
            sort(array, start, mid, end);
        }
    }
    
    private static void sort(int []array, int start, int mid, int end)
    {
        int []temp = new int[end - start + 1];
        int tempCtr = 0;
        
        int left = start;
        int right = mid + 1;
        
        while (left <= mid && right <= end)
        {
            if (array[left] <= array[right])
            {
                temp[tempCtr++] = array[left++];
            }
            else
            {
                temp[tempCtr++] = array[right++];
            }
        }
        
        while (left <= mid)
        {
            temp[tempCtr++] = array[left++];
        }
        
        while (right <= end)
        {
            temp[tempCtr++] = array[right++];
        }
        
        for (int x = start; x <= end; ++x)
        {
            array[x] = temp[x - start];
        }
    }
}
