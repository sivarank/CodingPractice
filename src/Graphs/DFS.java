package Graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {

	void DFSUtil(Graph g, int startNode) {
		boolean visited[] = new boolean[6];
		DFS(g, startNode, visited);
	}
	
	private void DFS(Graph g, int v, boolean[] visited) {
		
		visited[v] = true;
		LinkedList<Integer> list = g.get(v);
		System.out.println(v);
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			int node = it.next();
			if(!visited[node]) {
				DFS(g,node, visited);
			}
		}
		
	}
	public static void main(String[] args) {
		Graph g = new Graph(5+1);
		g.addEdge(0, 1);
		g.addEdge(1, 3);
		g.addEdge(3, 2);
		g.addEdge(2, 0);
		g.addEdge(3, 0);
		
		DFS d = new DFS();
		d.DFSUtil(g, 2);
	}

}

class Graph{
	private LinkedList<Integer> adj[];
	private Integer size;
	Graph(int v){
		size = v;
		adj  = new LinkedList[v];
		for(int i=0; i<v; i++) {
			adj[i] = new LinkedList<>();
		}
		
	}
	
	void addEdge(int v1, int v2) {
		adj[v1].add(v2);
	}
	
	LinkedList<Integer> get(int v){
		return adj[v];
	}
	Integer size(){
		return size;
	}
}