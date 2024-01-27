
public class QuickSort 
{
    public static void swap(int []arr, int index1, int index2)
    {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    
    public static void quickSort(int []arr, int left, int right)
    {
        if (left >= right)
        {
            return;
        }
        
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }
    
    public static int partition(int []arr, int left, int right)
    {
        int pivot = arr[right];
        
        int lowest = left - 1;
        for(int x = left; x < right; ++x)
        {
            if (arr[x] <= pivot)
            {
                ++lowest;
                swap(arr, lowest, x);
            }
        }
        
        swap(arr, lowest + 1, right);
        return lowest + 1;
    }
}
