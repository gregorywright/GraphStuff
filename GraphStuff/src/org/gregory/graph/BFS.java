package org.gregory.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

import org.gregory.graph.Graph.Edge;
import org.gregory.graph.Graph.Node;

public class BFS {
	
	public Graph graph;
	public TreeSet<Node> processed;
	public TreeSet<Node> discovered;
	
	public BFS(Graph graph) {
		processed  = new TreeSet<Node>();
		discovered = new TreeSet<Node>();
		this.graph = graph;
		Init();
	}
	
	public void Init() {
		processed.clear();
		discovered.clear();
	}
	
	public void processVertexEarly(Node node) {
		System.out.print(node.name+", ");
	}
	public void processEdge(Node node, Edge edge) {
		//System.out.println("processed edge from node: " + node.name + " to node: " + edge.toNode.name);
	}
	public void processVertexLate(Node node) {
		//System.out.println("processed late node: " + node.name);
	}
	
	public void walk(Node startNode) {
		Queue<Node> nodeList = new LinkedList<Node>();
		nodeList.add(startNode);
		discovered.add(startNode);
		while(!nodeList.isEmpty()) {
			Node node = nodeList.remove();
			processVertexEarly(node);
			processed.add(node);
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
