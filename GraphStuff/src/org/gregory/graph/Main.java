package org.gregory.graph;
import static org.gregory.graph.Graph.Node;
import static org.gregory.graph.Graph.Edge;

public class Main {


	public static void main(String[] args) {
		System.out.println("Building graph.");
		Graph graph = new Graph("The Graph", false);
		final int numNodes = 9;
		final int numEdges = 7;
		for( int i=0 ; i<numNodes; i++) {
			Graph.Node node = new Graph.Node(Integer.toString(i));
			System.out.println("Adding node "+i+" to graph.");
			graph.addNode(node);
		}
		//Got a graph of node but no edges. Create some random ones.
		for( int i=0 ; i<numEdges ; i++) {
			boolean added = false;
			while (!added) {
				int source = (int) (Math.random()*numNodes);
				int dest = source;
				while(dest == source)
					dest = (int) (Math.random()*numNodes);
				Node srcNode = graph.nodes.get(source);
				Node dstNode = graph.nodes.get(dest);
				double weight = Math.floor(100*Math.random())+1/10;
				Edge newEdge1 = new Edge(dstNode, weight);
				Edge newEdge2 = new Edge(srcNode, weight);
				if (!srcNode.edges.contains(newEdge1)) {
					System.out.println("Adding edge from node " + source + " to node "+ dest + " and back again...");
					srcNode.edges.add(newEdge1);
					dstNode.edges.add(newEdge2);
					added = true;
				}
			}
		}
		
		BFS walker = new BFS(graph);
		
		//Check for how many connected components we have.
		int count = 0;
		for( Node it : graph.nodes) {
			if(!walker.discovered.contains(it)) {
				count++;
				System.out.print("Component "+count+": ");
				walker.walk(it);
				System.out.println();
			}
		}
				
		//dump the graph.
		graph.dumpDotFile("ttt.dot");
	}
}
