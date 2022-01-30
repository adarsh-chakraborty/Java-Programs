import java.io.*;  
import java.util.*;
public class BreadthFirstSearch {  
    private int node;      
    private LinkedList<Integer> adj[];       
    private Queue<Integer> que;   
    @SuppressWarnings("unchecked")          
    BreadthFirstSearch(int v)  
    {  
        node = v;  
        adj = new LinkedList[node];  
        for (int i=0; i<v; i++)  
        {  
            adj[i] = new LinkedList<>();  
        }  
        que = new LinkedList<Integer>();  
    }  
    void insertEdge(int v,int w)  
    {  
        adj[v].add(w);     
    }  
    void BFS(int n)  
    {  
        boolean nodes[] = new boolean[node];       
        int a = 0;  
        nodes[n]=true;                    
        que.add(n);       
        while (que.size() != 0)  
        {  
            n = que.poll();        
            System.out.print(n+" ");    
            for (int i = 0; i < adj[n].size(); i++) 
            {  
                a = adj[n].get(i);  
                if (!nodes[a])     
                {  
                    nodes[a] = true;  
                    que.add(a);  
                }  
            }    
        }  
    }  
    public static void main(String args[])  
    {  
        BreadthFirstSearch graph = new BreadthFirstSearch(6);  
        graph.insertEdge(0, 1);  
        graph.insertEdge(0, 3);  
        graph.insertEdge(0, 4);  
        graph.insertEdge(4, 5);  
        graph.insertEdge(3, 5);  
        graph.insertEdge(1, 2);  
        graph.insertEdge(1, 0);  
        graph.insertEdge(2, 1);  
        graph.insertEdge(4, 1);  
        graph.insertEdge(3, 1);  
        graph.insertEdge(5, 4);  
        graph.insertEdge(5, 3);  
        System.out.println("Breadth First Traversal for the graph is:");  
        graph.BFS(0);  
    }  
}  
    

