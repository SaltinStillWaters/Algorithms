import java.util.ArrayList;
import java.util.Arrays;


public class Prim 
{
    public static int[][] prim(int[][] graph, int start)
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(start);
        
        boolean[] visited = new boolean[graph[0].length];
        Arrays.fill(visited, false);
        visited[start] = true;   

        int[][] MST = new int[graph[0].length][graph[0].length];
        for (int[] arr : MST)
        {
            Arrays.fill(arr, -1);
        }

        while (!list.isEmpty())
        {
            prim(graph, list, visited, MST);
        }
        
        return MST;
    }

    private static void prim(int graph[][], ArrayList<Integer> list, boolean[] visited, int[][] MST)
    {
        int lowest = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;

        for (int x = 0; x < list.size(); ++x)
        {
            int leastNode = findLeastEdge(graph, list.get(x), visited);

            if (leastNode == -1)
            {
                list.remove(x);
                continue;
            }

            int edgeValue = graph[list.get(x)][leastNode];
                
            if (edgeValue < lowest)
            {
                lowest = edgeValue;
                start = list.get(x);
                end = leastNode;
            }
        }

        if (end != -1)
        {
            list.add(end);
            visited[end] = true;
            MST[start][end] = lowest;
        }
    }

    public static int findLeastEdge(int[][] graph, int start, boolean[] visited)
    {
        int lowest = Integer.MAX_VALUE;
        int end = -1;

        for (int x = 0; x < graph[0].length; ++x)
        {
            int edge = graph[start][x];
            if (edge != -1 && visited[x] == false && edge < lowest)
            {
                lowest = edge;
                end = x;
            }
        }

        return end;
    }
}
