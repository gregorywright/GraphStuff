package org.gregory.graph;
import org.gregory.graph.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("Building graph.");
		Graph graph = new Graph("The Graph");
		final int numNodes = 5;
		final int numEdges = 5;
		for( int i=0 ; i<numNodes; i++) {
			Graph.Node node = new Graph.Node(Integer.toString(i));
			System.out.println("Adding node "+i+" to graph.");
			graph.addNode(node);
		}
		//Got a graph of node but no edges. Create some random ones.
		for( int i=0 ; i<numEdges ; i++) {
			int source = (int) (Math.random()*numNodes);
			int dest = source;
			while(dest == source)
				dest = (int) (Math.random()*numNodes);
			System.out.println("Adding edge from node " + source + " to node "+ dest);
			graph.nodes.get(source).addEdge(graph.nodes.get(dest), 1.0);
		}
	}
}
