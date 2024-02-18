
public class Main 
{
    public static void main(String[] args)
    {
        boolean[][] graph = {
            {false, true, true},
            {false, false, false},
            {false, false, false}
        };

        boolean[][] graph2 = {
            {false, true, true, false, false},
            {true, false, false, true, false},
            {true, false, false, true, true},
            {false, true, true, false, false},
            {false, false, true, false, false}
        };
        BFS.bfs(0, graph2);
    }
}