package org.gregory.graph;
import static org.gregory.graph.Graph.Node;
import static org.gregory.graph.Graph.Edge;

public class Main {


	public static void main(String[] args) {
		System.out.println("Building graph.");
		Graph graph = new Graph("The Graph", true);
		final int numNodes = 5;
		final int numEdges = 5;
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
				Edge newEdge = new Edge(dstNode, Math.floor(100*Math.random())+1/10);
				if (!srcNode.edges.contains(newEdge)) {
					System.out.println("Adding edge from node " + source + " to node "+ dest);
					srcNode.edges.add(newEdge);
					added = true;
				}
			}
		}
		
		BFS walker = new BFS();
		//Walk the graph.
		walker.walk(graph);
		
		//dump the graph.
		graph.dumpDotFile("ttt.dot");
	}
}
