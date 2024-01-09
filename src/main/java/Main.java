
import completed.MergeSort;


public class Main 
{
    public static void main(String[] args)
    {
       AVL tree = new AVL();
       tree.insert(1);
       tree.insert(2);
       tree.insert(3);
       tree.insert(4);
       tree.insert(5);
       tree.insert(6);
       
       tree.printPreOrder();
    }
}