
public class Main 
{
    public static void main(String[] args)
    {
        simplified.AVL avl = new simplified.AVL();

        int[] inputs = {5, 4, 0, 1, 3, 9, 6, 8, 10};
        System.out.println("\nOriginal linear array:");
        for (int x : inputs)
        {
            avl.insert(x);
            System.out.print(x + " ");
        }
        
        System.out.println("\n\navl tree in-order traversal:");
        avl.printInOrder();

        System.out.println("\nLookup:");
        int[] toLook = {5, 2, 1, 0, 6, 11};
        for (int x : toLook)
        {
            System.out.println(x + " is in the AVL tree:\t" + avl.find(x));
        }
    }
}