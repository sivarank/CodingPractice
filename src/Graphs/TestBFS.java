package Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class TestBFS {
	private void BFS(Graph g, int v) {
		Queue<Integer> q = new  LinkedList<Integer>();
		q.add(v);
		boolean[] visited = new boolean[g.size()];
		while(!q.isEmpty()) {
			Integer val = q.poll();
			System.out.println(val);
			visited[val] = true;
			Iterator<Integer> it = g.get(val).iterator();
			while(it.hasNext()) {
				int node = it.next();
				if(!visited[node]) {
					q.add(node);
				}
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
		
		TestBFS d = new TestBFS();
		d.BFS(g, 2);
	}

}

