package org.gregory.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

import org.gregory.graph.Graph.Edge;
import org.gregory.graph.Graph.Node;

public class BFS {
	
	public TreeSet<Node> processed;
	public TreeSet<Node> discovered;
	
	public BFS() {
		processed  = new TreeSet<Node>();
		discovered = new TreeSet<Node>();
		Init();
	}
	
	public void Init() {
		processed.clear();
		discovered.clear();
	}
	
	public void processVertexEarly(Node node) {
		
	}
	public void processEdge(Node node, Edge edge) {
		
	}
	public void processVertexLate(Node node) {
		
	}
	public void walk(Graph graph) {
		Queue<Node> nodeList = new LinkedList<Node>();
		Node startNode = graph.nodes.elementAt(0);
		nodeList.add(startNode);
		discovered.add(startNode);
		while(!nodeList.isEmpty()) {
			Node node = nodeList.remove();
			processVertexEarly(node);
			processed.add(node);
			System.out.println("Just processed node: " + node.name);
			for( Edge it : node.edges) {
				if( !processed.contains(it.toNode) || graph.directed) {
					processEdge(node, it);
				}
				if( !discovered.contains(it.toNode)) {
					nodeList.add(it.toNode);
					discovered.add(it.toNode);
					it.toNode.parent = node;
				}
			}
			processVertexLate(node);
		}
	}
}
