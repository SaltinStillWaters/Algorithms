import java.util.Arrays;

public class Main 
{
    public static void main(String[] args)
    {
        boolean[][] graph = 
        {
            {false, true, true, true, false},
            {true, false, false, false, true},
            {true, false, false, false, false},
            {true, false, false, false, false},
            {false, true, false, false, false}
        };

        boolean[][] graph2 = {
            {false, true, true, false, false},
            {true, false, false, true, false},
            {true, false, false, true, true},
            {false, true, true, false, false},
            {false, false, true, false, false}
        };

        BFS.bfs(1, graph2);
    }
}