package org.gregory.graph;

import java.util.TreeSet;
import java.util.Vector;
import java.io.FileWriter;
import java.io.IOException;

public class Graph {
	static class Edge implements Comparable<Edge>{
		public Double weight;
		public Node   toNode;
		public Edge(Node node, Double weight) {
			this.toNode = node;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge rhs) {
			return this.toNode.compareTo(rhs.toNode);			
		}
		@Override
		public boolean equals(Object foo) {
			Edge rhs = (Edge)foo;
			return (this.toNode.compareTo(rhs.toNode) == 0);			
		}
	}
	static class Node implements Comparable<Node> {
		public String name;
		public TreeSet<Edge> edges;
		public Node parent;
		public void addEdge(Node node, Double weight) {
			this.edges.add(new Edge(node, weight));
		}
		public Node(String nodeName) {
				name   = nodeName;
				edges  = new TreeSet<Edge>();
				parent = null;
		}
		@Override
		public int compareTo(Node rhs) {
			return this.name.compareTo(rhs.name);
		}
	}
	
	public String name;
	public Vector<Node> nodes;
	public boolean directed;
	public Graph(String name, boolean directed) {
		nodes = new Vector<Node>();
		this.name = name;  
		this.directed = directed;
	}
	public void addNode(Node node) {
		nodes.add(node);
	}
	
	public void dumpDotFile(String fileName) {
		try {
			FileWriter foo = new FileWriter(fileName);
			foo.write("digraph \"" + this.name + "\" {\n");
			for( Node node : nodes) {
				if( node.edges.isEmpty()) {
					foo.write("\""+node.name + "\"");
				} 
				for( Edge edge : node.edges) {
					StringBuilder outString = new StringBuilder("\"" + node.name + "\" -> \"" + edge.toNode.name + "\" [label = \""+edge.weight+"\"");
					if(edge.toNode.parent == node) {
						outString.append(" color=\"blue\"");
					} else {
						outString.append(" color=\"black\"");
					}
					outString.append("]\n");
					foo.write(outString.toString());
				}
			}
			foo.write("}\n");
			foo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
