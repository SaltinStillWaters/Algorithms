package salt.recursion;


public class MergeSort 
{
    public static void mergeSort(int[] array, int startIndex, int endIndex)
    {
        //divide array until only 1 element is left
        if (startIndex < endIndex)
	{	
            int midIndex = (startIndex + endIndex) / 2;
        
            mergeSort(array, startIndex, midIndex);     //left halves
            mergeSort(array, midIndex + 1, endIndex);   //right halves
            
            
            //once the leftmost element is reached, begin merging
            /*
            Parameters:
            array = reference to the original int[]
            indexes = index of current sub-array relative to original array
            */
            sort(array, startIndex, midIndex, endIndex);
	}
    }
    
    private static void sort(int[] array, int start, int mid, int end)
    {   
        //create a temporary array with a length similar to the sub-array.
        int[] temp = new int[end - start + 1];
        //tempCtr = first empty index of the array
        int tempCtr = 0;
        
        //leftCtr and rightCtr will represent the starting index of the left and right sub-array
        int leftCtr = start;
        int rightCtr = mid + 1;
        
        
    //MERGING    
        /*
            if both the left and right sub-arrays still have elements yet to be placed in the []temp,
            they will be compared and the lesser value will be transfered to []temp.
    
            the values are fetched from the original int[] and we simulate that we have 2 sub-arrays (left and right)
            using the leftCtr and rightCtr
         */
        while (leftCtr <= mid && rightCtr <= end)
        {
            if (array[leftCtr] <= array[rightCtr])
            {
                temp[tempCtr] = array[leftCtr];
                ++tempCtr;
                ++leftCtr;
            }
            else
            {
                temp[tempCtr] = array[rightCtr];
                ++tempCtr;
                ++rightCtr;
            }
        }
        //once this line is reached, it means that atleast one of the sub-arrays have been fully copied onto the []temp
        //as a result, the remaining sub-array will be copied over to the []temp in a queue-like manner
        //Note: remember that both sub-arrays are sorted to begin with
        while (leftCtr <= mid)
        {
            temp[tempCtr] = array[leftCtr];
            ++tempCtr;
            ++leftCtr;
        }
        
        while (rightCtr <= end)
        {
            temp[tempCtr] = array[rightCtr];
            ++tempCtr;
            ++rightCtr;
        }
        
        
        //lastly, the original array's values are overwritten by the []temp's values
        for (int x = start; x <= end; ++x)
        {
            array[x] = temp[x - start];
        }
    }
}
    