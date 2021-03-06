import java.util.*;

public class Permute
{
    static int minDistance(int dist[], Boolean sptSet[],int size)
    {
        int min = Integer.MAX_VALUE, min_index=-1;
 
        for (int v = 0; v < size; v++)
            if (sptSet[v] == false && dist[size] <= min)
            {
                min = dist[v];
                min_index = v;
            }
 
        return min_index;
    }

    public static int dijkstra(int graph[][], int src, int dest,int size)
    {
        int dist[] = new int[size];
        Boolean sptSet[] = new Boolean[size];
        for (int i = 0; i < size; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[src] = 0;
        for (int count = 0; count < size-1; count++)
        {
            int u = minDistance(dist, sptSet, size);
            sptSet[u] = true;
            for (int v = 0; v < size; v++)
                if (!sptSet[v] && graph[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
        return dist[dest];
    }

    public static int diff(String x, String y){
        int minLen = Integer.MAX_VALUE;
        int count = Integer.MAX_VALUE;
        String min = null, max = null;
        if(x.length() < y.length()){
            minLen = x.length();
            min = x;
            max = y;
        } else {
            minLen = y.length();
            min = y;
            max = x;
        }
        if(min.length() +1 == max.length()){
            if(max.contains(min))
                return count;
        } else if(min.length() == max.length()){
            count = 0;
            for(int i=0;i<minLen;i++){
                if(count > 1)
                    break;
                if(min.charAt(i)!=max.charAt(i))
                    count++;
            }
            
        }
        
        return count;
    }

    public static int createGraphandSolve(String[] words,String srcStr,String destStr){
        int size = words.length;
        int graph[][] = new int[size][size];
        int src = -1, dest = -1;
        for(int i=0;i<size-1;i++){
            for(int j=i+1;j<size;j++){
                int diffrn = diff(words[i],words[j]);
                if(diffrn <= 1)
                {
                    graph[i][j] = diffrn;
                    graph[j][i] = diffrn;
                } 
                if(words[i].equals(srcStr)) src = i;
                if(words[i].equals(destStr)) dst = i;
                if(words[j].equals(srcStr)) src = j;
                if(words[j].equals(destStr)) dst = j;
            }
        }

        return dijkstra(graph, src, dest, size);
    }
 
    // Driver method
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
         
        int total = in.nextInt();
        String[] words = new String[total];
        for(int i = 0; i < total; i++){
            words[i] = scan.next();
        }
        String src = scan.next();
        String dest = scan.next();
        int least = createGraphandSolve(words, src, dest);
        if(least != Integer.MAX_VALUE)
        System.out.println("Least changes is :"+least);
        else
        System.out.println("Can't change");
    }
}