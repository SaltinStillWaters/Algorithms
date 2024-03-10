import java.util.Arrays;

public class Kruskal 
{
    public static int[][] kruskal(int[][] graph)
    {
        boolean[] visited = new boolean[graph[0].length];
        Arrays.fill(visited, false);

        int[][] MST = new int[graph[0].length][graph[0].length];
        for (int[] arr : MST)
        {
            Arrays.fill(arr, -1);
        }

        Edge edgeList = disectGraph(graph);

        int iter = 0;
        while (iter < edgeList.size && !allVisited(visited))
        { 
            kruskal(edgeList, iter, visited, MST);
            ++iter;
        }

        return MST;
    }

    private static void kruskal(Edge edgelist, int iter, boolean[] visited, int[][] MST)
    {
        if (visited[edgelist.ends[iter]] == true && visited[edgelist.starts[iter]] == true)
        {
            return;
        }

        visited[edgelist.ends[iter]] = true;
        visited[edgelist.starts[iter]] = true;

        MST[edgelist.starts[iter]][edgelist.ends[iter]] = edgelist.edges[iter];
    }

    public static boolean allVisited(boolean[] visited)
    {
        for (boolean bool : visited)
        {
            if (bool == false)
            {
                return false;
            }
        }

        return true;
    }

    public static int getGraphTotalEdges(int[][] graph)
    {
        int size = 0;
        for (int x = 0; x < graph[0].length; ++x)
        {
            for (int y = x; y < graph[0].length; ++y)
            {
                if (graph[x][y] != -1)
                {
                    ++size;
                }
            }
        }

        return size;
    }

    public static Edge disectGraph(int[][] graph)
    {
        int size = getGraphTotalEdges(graph);
        Edge edgeList = new Edge(size);

        int listIter = 0;
        for (int x = 0; x < graph[0].length; ++x)
        {
            for (int y = x; y < graph[0].length; ++y)
            {
                if (graph[x][y] != -1)
                {
                    edgeList.edges[listIter] = graph[x][y];
                    edgeList.starts[listIter] = x;
                    edgeList.ends[listIter] = y;

                    ++listIter;
                }
            }
        }

        edgeList.sort();
       
        return edgeList;
    }
}
