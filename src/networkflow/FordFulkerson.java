/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkflow;

import java.util.LinkedList;

/**
 *
 * @author Tony
 */
public class FordFulkerson {
    
    static final int numV = 6;
    
    public boolean bfs(int graph[][],int s,int t,int p[]){
        
        boolean visited[] = new boolean[numV];
        for (int i = 0; i <numV; ++i)
            visited[i] = false;
        
        LinkedList<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        p[s] = -1;
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v = 0; v<numV; v++){
                if (visited[v] == false && graph[u][v]>0){
                    q.add(v);
                    p[v] = u;
                    visited[v] = true;
                }
            }
        }
        return (visited[t] == true);
    }
    
    public int Ford_Fulkerson(int graph[][],int s, int t){
        
        int u;
        int v;
        
        int resGraph[][] = new int[numV][numV];
        for(u = 0;u<numV;u++)
            for(v = 0;v<numV; v++)
                resGraph[u][v] = graph[u][v];
        int p[] = new int[numV];
        int maxFlow = 0;
        while (bfs(resGraph,s,t,p)){
            int path = Integer.MAX_VALUE;
            for(v = t; v!=s; v=p[v]){
                u = p[v];
                path = Math.min(path, resGraph[u][v]);
            }
            for(v=t; v!=s; v = p[v]){
                u = p[v];
                resGraph[u][v] -= path;
                resGraph[v][u] +=path;
            }
            maxFlow += path;
        }
        return maxFlow;
}
    
}
