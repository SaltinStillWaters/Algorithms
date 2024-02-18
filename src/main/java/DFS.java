import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DFS 
{
    public static void dfs(int start, boolean[][] graph)
    {
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[graph[0].length];
        Arrays.fill(visited, false);

        search(start, graph, visited, deque);
    }

    public static void search(int vertex, boolean[][] graph, boolean[] visited, Deque<Integer> deque)
    {
        System.out.print(vertex + " ");

        if (!visited[vertex])
        {
            deque.push(vertex);
            visited[vertex] = true;
        }
        
        if (deque.isEmpty())
        {
            return;
        }
        
        for (int x = 0; x < graph[0].length; ++x)
        {
            if (graph[deque.peek()][x] == true && visited[x] == false)
            {
                search(x, graph, visited, deque);
            }
        }

        deque.pop();
    }
}
