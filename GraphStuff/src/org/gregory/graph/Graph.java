package org.gregory.graph;

import java.util.LinkedList;
import java.util.Vector;

public class Graph {
	static class Edge {
		public Double weight;
		public Node   toNode;
		public Edge(Node node, Double weight) {
			this.toNode = node;
			this.weight = weight;
		}
	}
	static class Node {
		public String name;
		public LinkedList<Edge> edges;
		public void addEdge(Node node, Double weight) {
			this.edges.add(new Edge(node, weight));
		}
		public Node(String nodeName) {
				name = nodeName;
				edges = new LinkedList<Edge>();
		}
	}
	
	public String name;
	public Vector<Node> nodes;
		public Graph(String name) {
		nodes = new Vector<Node>();
		this.name = name;  
	}
	public void addNode(Node node) {
		nodes.add(node);
	}
}
