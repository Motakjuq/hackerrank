// https://www.hackerrank.com/challenges/dijkstrashortreach
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static void calculatePaths(short begin, int nodes, List<Map<Short, Short>> graph){
        int paths[] = new int[nodes];
        boolean visited[] = new boolean[nodes];
        Deque<Short> queue = new ArrayDeque<Short>();
        queue.add(begin);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            if(visited[node])
                continue;
            visited[node] = true;
            for(Short nextNode : graph.get(node).keySet()) {
                if(begin != nextNode && graph.get(node).get(nextNode) != 0) {
                    if(!visited[nextNode])
                        queue.add(nextNode);
                    if(paths[nextNode] == 0 || paths[nextNode] > graph.get(node).get(nextNode) + paths[node]){
                        paths[nextNode] = graph.get(node).get(nextNode) + paths[node];
                        if(visited[nextNode]){
                            visited[nextNode] = false;
                            queue.add(nextNode);
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < nodes ; i++){
            if(begin != i){
                sb.append(" " + (paths[i]==0?-1:paths[i]));
            }
        }
        System.out.println(sb.toString().substring(1));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for(int i = 0 ; i < cases ; i++){
            short nodes = in.nextShort();
            int edges = in.nextInt();
            List<Map<Short, Short>> graph = new ArrayList<Map<Short, Short>>(nodes);
            for(int j = 0 ; j < nodes ; j++){
                graph.add(new HashMap<Short, Short>());
            }
            for(int j = 0 ; j < edges ; j++){
                short nodeOrigin = (short)(in.nextInt() - 1);
                short nodeDestiny = (short)(in.nextInt() - 1);
                short length = in.nextShort();
                if(graph.get(nodeOrigin).get(nodeDestiny) == null || graph.get(nodeOrigin).get(nodeDestiny) > length){
                    graph.get(nodeOrigin).put(nodeDestiny, length);
                    graph.get(nodeDestiny).put(nodeOrigin, length);
                }
            }
            short begin = (short)(in.nextInt() - 1);
            calculatePaths(begin, nodes, graph);
        }
        in.close();
    }
}
