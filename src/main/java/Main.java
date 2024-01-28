

public class Main 
{
    public static void main(String[] args)
    {
        int[][] c = {
    {25, 4},
    {0, 33}
};

        int[][] d = {
    {1, 1},
    {1, 1}
};
        
        int[][] a = {
    {1, 2, 3, 4},
    {5, 6, 7, 8},
    {9, 10, 11, 12},
    {13, 14, 15, 16}
};

        int[][] b = {
    {17, 18, 19, 20},
    {21, 22, 23, 24},
    {25, 26, 27, 28},
    {29, 30, 31, 32}
};
        
        int[][]e = MatMult_DivConq.multiply(a, 0, 0, b,0,0, a.length);
        for (int[] arr : e)
        {
            for (int num : arr)
            {
                System.out.print(num + " ");
            }
            System.out.println("");
        }
    }
}