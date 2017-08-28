// https://www.hackerrank.com/challenges/bfsshortreach
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static void calculatePath(int nodes, int start, int graph[][]){
        boolean visited[] = new boolean[nodes];
        int distance[] = new int[nodes];
        for(int i = 0 ; i < nodes ; i ++){
            distance[i] = -1;
        }
        distance[start] = 0;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(start);
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(!visited[node]){
                visited[node] = true;
                for(int i = 0 ; i < nodes ; i++){
                    if(graph[node][i] == 1){
                        if(!visited[i])
                        	queue.add(i);
                        if(distance[i] == -1 || distance[i] > distance[node] + 1){
                        	distance[i] = distance[node] + 1;
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < nodes ; i++){
        	if(i != start){
        		if(sb.length() > 0)
        			sb.append(" ");
        		sb.append(distance[i]*(distance[i]==-1?1:6));
        	}
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for(int i = 0 ; i < cases ; i++){
            int nodes = in.nextInt();
            int edges = in.nextInt();
            int graph[][] = new int[nodes][nodes];
            for(int j = 0 ; j < edges ; j++){
                int origin = in.nextInt();
                int destiny = in.nextInt();
                graph[origin-1][destiny-1] = 1;
                graph[destiny-1][origin-1] = 1;
            }
            int start = in.nextInt()-1;
            
            calculatePath(nodes, start, graph);
        }
        in.close();
    }
}
