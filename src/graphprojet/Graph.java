package graphprojet;

import java.util.ArrayList;

public class Graph {
	
	//Constructeurs graphe
	private static final int NB_MAX_EDGES = 2000;
	private static final int NB_MAX_VERTICES = 1000;
	
	private ArrayList<Vertex> vertices = new ArrayList<Vertex>();
	private int verticesIndex;

	private ArrayList<Edge> edges= new ArrayList<Edge>();
	private int edgesIndex;
	
	public Graph() {
		this.vertices = null;
		this.edges = null;
	}
	
	public Graph(ArrayList<Edge> e,ArrayList<Vertex> v) {
		this.vertices = v;
		this.edges = e;
	}
	
	public ArrayList<Vertex> getVertexs(){
		return this.vertices;
	}
	
}
