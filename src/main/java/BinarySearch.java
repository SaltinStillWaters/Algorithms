
public class BinarySearch 
{
    public static int binarySearch(int []array, int value, int start, int end)
    {
        System.out.println("start: " + start + "    end: " + end);
        if (start > end)
        {
            return -1;
        }
        
        int mid = (start + end) / 2;
        
        if (array[mid] < value)
        {
            return binarySearch(array, value, mid + 1, end);
        }
        else if (array[mid] > value)
        {
            return binarySearch(array, value, start, mid - 1);
        }
        else
        {
            return mid;
        }
    }
}
