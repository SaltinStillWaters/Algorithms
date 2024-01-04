
import completed.MergeSort;


public class Main 
{
    public static void main(String[] args)
    {
        int[] array = {1, 2, 0, 5, 10, 0, 7, 6, 9};
      
        BruteForce.selectionSort(array);
        
        for (int num : array)
        {
            System.out.print(num + " ");
        }
          
//        MergeSort.mergeSort(array, 0, array.length - 1);
//        
//        for (int num : array)
//        {
//            System.out.print(num + " ");
//        }
//        System.out.println("");
//        
//        int index = BinarySearch.binarySearch(array, 2, 0, array.length - 1);
//        System.out.println(index);
    }
}