import java.util.Arrays;

class Edge
{
        int[] edges;
        int[] starts;
        int[] ends;
        int size;

        public Edge(int size)
        {
            this.edges = new int[size];
            Arrays.fill(edges, -1);
            this.starts = new int[size];
            Arrays.fill(starts, -1);
            this.ends = new int[size];
            Arrays.fill(ends, -1);
            this.size = size;
        }

        public void sort()
        {
            for (int unsorted = 0; unsorted < size - 1; ++unsorted)
            {
                int min = unsorted;
                
                for (int toSearch = min + 1; toSearch < size; ++toSearch)
                {
                    if (edges[toSearch] < edges[min])
                    {
                        min = toSearch;
                    }
                }
                
                int temp = edges[unsorted];
                edges[unsorted] = edges[min];
                edges[min] = temp;

                int temp2 = starts[unsorted];
                starts[unsorted] = starts[min];
                starts[min] = temp2;

                int temp3 = ends[unsorted];
                ends[unsorted] = ends[min];
                ends[min] = temp3;
            }
    }
}