package completed;

public class MatMult_Strassen 
{
    public static int [][]strassen(int [][]a, int [][]b, int size)
    {
        if (size == 1)
        {
            int[][] product = new int[size][size];
            product[0][0] = a[0][0] * b[0][0];
            return product;
        }

        
        size /= 2;
        int[][][] partsA = split(a);
        int[][][] partsB = split(b);
        
        int[][] p = strassen(add(partsA[0], partsA[3]), add(partsB[0], partsB[3]), size);
        int[][] q = strassen(add(partsA[2], partsA[3]), partsB[0], size);
        int[][] r = strassen(partsA[0], sub(partsB[1], partsB[3]), size);
        int[][] s = strassen(partsA[3], sub(partsB[2], partsB[0]), size);
        int[][] t = strassen(add(partsA[0], partsA[1]), partsB[3], size);
        int[][] u = strassen(sub(partsA[2], partsA[0]), add(partsB[0], partsB[1]), size);
        int[][] v = strassen(sub(partsA[1], partsA[3]), add(partsB[2], partsB[3]), size);
        
        int[][] aTemp = add(sub(add(p, s), t), v);
        int[][] bTemp = add(r, t);
        int[][] cTemp = add(q, s);
        int[][] dTemp = add(sub(add(p, r), q), u);
        
        return combine(aTemp, bTemp, cTemp, dTemp);
    }
    
    public static int [][]combine(int [][]a, int [][]b, int [][]c, int [][]d)
    {
        int size = a.length;
        int [][]combined = new int[size * 2][size * 2];
        
        for (int x = 0; x < size; ++x)
        {
            for (int y = 0; y < size; ++y)
            {
                combined[x][y] = a[x][y];
                combined[x][y + size] = b[x][y];
                combined[x + size][y] = c[x][y];
                combined[x + size][y + size] = d[x][y];
            }
        }
        
        return combined;
    }
    
    public static int [][][]split(int [][]matrix)
    {
        int size = matrix.length / 2;
    
        int [][][]split = new int[4][size][size];
        for (int x = 0; x < size; ++x)
        {
            for (int y = 0; y < size; ++y)
            {
                split[0][x][y] = matrix[x][y];
                split[1][x][y] = matrix[x][y + size];
                split[2][x][y] = matrix[x + size][y];
                split[3][x][y] = matrix[x + size][y + size];
            }
        }
        
        return split;
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
    
    public static int [][]sub(int [][]a, int [][]b)
    {
        int size = a.length;
        int [][]sum = new int[size][size];
        
        for (int x = 0; x < size; ++x)
        {
            for (int y = 0; y < size; ++y)
            {
                sum[x][y] = a[x][y] - b[x][y];
            }
        }
        
        return sum;
    }
}
