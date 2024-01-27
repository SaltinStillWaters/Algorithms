package completed;


public class BinarySearch 
{
    public static int binarySearch(int []array, int value, int start, int end)
    {
        //due to the recursive calls, either
        //start will be incremented to be greater than end
        //or end will be decremented to be lesser than start
        //signifying that for all recursive calls;
        //array[mid] was never equal to value
        if (start > end)
        {
            return -1;
        }
        
        int mid = (start + end) / 2;
        
        //divide the array into 2 parts until array[mid] == value
        if (array[mid] < value)
        {
            //means that value must be in the first half of the array
            return binarySearch(array, value, mid + 1, end);
        }
        else if (array[mid] > value)
        {
            //means that value must be in the latter half of the array
            return binarySearch(array, value, start, mid - 1);
        }
        else
        {
            //value has been found
            return mid;
        }
    }
}
