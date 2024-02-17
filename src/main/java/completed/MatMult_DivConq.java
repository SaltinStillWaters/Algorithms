package completed;

public class MatMult_DivConq 
{
    public static int [][]multiply(int [][]a, int rowA, int colA, int [][]b, int rowB, int colB, int size)
    {
        if (size <= 2)
        {
            int[][] product = new int[2][2];
            
            product[0][0] = a[0 + rowA][0 + colA] * b[0 + rowB][0 + colB] + a[0 + rowA][1 + colA] * b[1 + rowB][0 + colB];
            product[0][1] = a[0 + rowA][0 + colA] * b[0 + rowB][1 + colB] + a[0 + rowA][1 + colA] * b[1 + rowB][1 + colB];
            product[1][0] = a[1 + rowA][0 + colA] * b[0 + rowB][0 + colB] + a[1 + rowA][1 + colA] * b[1 + rowB][0 + colB];
            product[1][1] = a[1 + rowA][0 + colA] * b[0 + rowB][1 + colB] + a[1 + rowA][1 + colA] * b[1 + rowB][1 + colB];
            
            return product;
        }
        
        size /= 2;
        
        int[][] aTemp = add( multiply(a, 0, 0, b, 0, 0, size), multiply(a, 0, size, b, size, 0, size) );
        int[][] bTemp = add( multiply(a, 0, 0, b, 0, size, size), multiply(a, 0, size, b, size, size, size) );
        int[][] cTemp = add( multiply(a, size, 0, b, 0, 0, size), multiply(a, size, size, b, size, 0, size) );
        int[][] dTemp = add( multiply(a, size, 0, b, 0, size, size), multiply(a, size, size, b, size, size, size) );
        
        return combine(aTemp, bTemp, cTemp, dTemp);
    }
    
    public static int [][]combine(int [][]a, int [][]b, int [][]c, int [][]d)
    {
        int size = a.length;
        int [][]combined = new int[size * 2][size * 2];
        
        for (int x = 0; x < size * 2; ++x)
        {
            for (int y = 0; y < size * 2; ++y)
            {
                if (x < size && y < size)
                {
                    combined[x][y] = a[x][y];
                }
                else if (x < size && y >= size)
                {
                    combined[x][y] = b[x][y - size];
                }
                else if (x >= size && y < size)
                {
                    combined[x][y] = c[x - size][y];
                }
                else
                {
                    combined[x][y] = d[x - size][y - size];
                }
            }
        }
        
        return combined;
    }
    
    public static int [][]add(int [][]a, int [][]b)
    {
        int size = a.length;
        int [][]sum = new int[size][size];
        
        for (int x = 0; x < size; ++x)
        {
            for (int y = 0; y < size; ++y)
            {
                sum[x][y] = a[x][y] + b[x][y];
            }
        }
        
        return sum;
    }
}
