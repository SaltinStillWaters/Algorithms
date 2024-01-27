

public class Main 
{
    public static void main(String[] args)
    {
        int[]arr = {5, 4, 10, 8, 2};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        for (int num : arr)
        {
            System.out.print(num + " ");
        }
    }
}