package org.gregory.graph;
//import org.gregory.graph.Graph.*;
import static org.gregory.graph.Graph.Node;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void walk(Graph graph){
		Queue<Node> nodeList = new LinkedList<Node>();
		//Add in the start node.
		nodeList.add(graph.nodes.elementAt(0));
		
	}
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
		
		//Walk the graph.
		walk(graph);
	}
}
