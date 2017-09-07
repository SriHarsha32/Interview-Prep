import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RoadsLibs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            long clib = in.nextInt();
            long croad = in.nextInt();

            Map<Integer,Set<Integer>> graph = new HashMap<>();
            for(int i=1;i<=n;i++){
                graph.put(i, new HashSet<Integer>());
            }

            for(int a1 = 0; a1 < m; a1++){
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();
                graph.get(city_1).add(city_2);
                graph.get(city_2).add(city_1);
            }
            System.out.println(solve(n, m, clib, croad, graph));

        }
    }

    static long solve(int n,int m,long clib,long croad,Map<Integer,Set<Integer>> graph){
        long ans = 0;

        boolean[] visited = new boolean[n+1];
        for(int node =1;node<=n;node++){
            if(!visited[node]){
                long size = DFS(node,graph,visited,1);

                ans += clib;
                if(clib < croad){
                    ans += ((size-1)*clib);
                }
                else{
                    ans += ((size-1)*croad);
                }
            }
        }
        return ans;
    }

    static long DFS(int root,Map<Integer,Set<Integer>> graph,boolean[] visited,long count){
        visited[root] = true;

        Set<Integer> adjs = graph.get(root);
        for(Integer node : adjs){
            if(!visited[node]){
                count = 1 + DFS(node,graph,visited,count);
            }
        }
        return count;
    }
}
