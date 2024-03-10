
public class Main 
{
    public static void main(String[] args)
    {
        int[][] graph = 
        {
            {-1, 4, 2, 2},
            {4, -1, 6, 3},
            {2, 6, -1, 2},
            {2, 3, 2, -1}
        };
        System.out.println("\n\nOriginal Graph:");
        for (int[] arr : graph)
        {
            for (int x : arr)
            {
                System.out.print(x + "\t");
            }
            System.out.println();
        }


        int[][] MST = Kruskal.kruskal(graph);
        System.out.println("\nMinimum Spanning Tree:");
        for (int[] arr : MST)
        {
            for (int x : arr)
            {
                System.out.print(x + "\t");
            }
            System.out.println();
        }
    }
}