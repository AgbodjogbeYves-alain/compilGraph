package graphprojet;

import java.util.ArrayList;

/**
 * Classe representante un sommet du graphe
 * @author Yves-alain Agbodjogbe  Godefroi Roussel
 *
 */


public class Vertex {
	
	private int numVertex;
	ArrayList<Vertex> interferencesVertex = new ArrayList<Vertex>();
	ArrayList<Vertex> preferencesVertex = new ArrayList<Vertex>();
	ArrayList<Edge> relatedEdge = new ArrayList<Edge>();
	int degre;
	String color;
	Graph g;
	
	
	
	/**
	 * Constructeur du Vertex
	 * @param num identifiant du vertex
	 */
	public Vertex(int num)
	{
		numVertex = num;
		interferencesVertex = null;
		preferencesVertex = null;
		relatedEdge = null;
		degre = 0;
		this.color = null;
	}
	
	/**
	 * Constructeur du vertex
	 * @param num identifiant du vertex
	 * @param g Graphe auquel le vertex appartient vertex
	 */
	public Vertex(int num,Graph g)
	{
		this.g = g;
		numVertex = num;
		interferencesVertex = null;
		relatedEdge = null;
		this.degre = 0;
		this.color = null;
	}
	
	/**
	 * Constructeur du Vertex
	 * @param g Graphe auquel le Vertex appartient
	 */
	@SuppressWarnings("null")
	public Vertex(Graph g)
	{
		this.g = g;
		numVertex = (Integer) null;
		interferencesVertex = null;
		relatedEdge = null;
		this.degre = 0;
		this.color = null;
	}
	
	
	/**
	 * Recuperer l identifiant du sommet s il en a un
	 * @return l identifiant du vertex
	 */
	public int getNumVertex() {
		return this.numVertex;
	}
	/**
	 *Modifier l identifiant du sommet 
	 * @param numVertex nouvel identifiant du vertex
	 */
	public void setNumVertex(int numVertex) {
		this.numVertex = numVertex;
	}
	
	/**
	 * Relier un autre vertex a celui ci 
	 * @param v le vertex a lier
	 * Modifie la liste des Vertex qui sont lies a celui ci
	 */
	public void relatevertex(Vertex v)
	{
		int num=0;
		while(this.relatedEdge.get(num) != null){num++;}
		Edge e = new Edge(num);
		this.interferencesVertex.add(v);
		v.interferencesVertex.add(this);
		this.relatedEdge.add(e);
		e.relierSommet(this,v);
		this.degre+=1;
	}
	
	/**
	 * Permet de recuperer les voisins d'interferences d'un sommet
	 * @return
	 */
	public ArrayList<Vertex> interferencesNeighbors(){
		return this.interferencesVertex;
	}
	
	/**
	 * Permet de recuperer les voisins de preference d'un sommet
	 * @return
	 */
	public ArrayList<Vertex> preferencesNeighbors(){
		return this.preferencesVertex;
	}
		
	/**
	 * Trouver un Edge relie a ce vertex
	 * @param numEdge identifiant du Edge
	 * @return 
	 */
	public int foundEdge(int numEdge)
	{
		Edge x = null;
		for(Edge e : relatedEdge)
			if (e.numEdge == numEdge){
				x = e;
			}
		return x.numEdge;
	}
	
	/**
	 * Recuperer la liste des arretes de ce vertex
	 * @return liste des edges
	 */
	public ArrayList<Edge> getListEdge()
	{
		return this.relatedEdge;
	}
	
	/**
	 * Pour savoir si un sommet est interferent ou pas
	 * @param v : sommet d'interference
	 * @return boolean
	 */
	public boolean estinterferent(Vertex v){
		boolean bool = false;
		if(this.interferencesVertex.contains(v)){
			bool = true;
		}
		return bool;
	}
	
	/**
	 * Pour savoir si un sommet est preferent ou pas
	 * @param v : sommet de preference
	 * @return boolean
	 */
	public boolean estpreferent(Vertex v){
		boolean bool = false;
		if(this.preferencesVertex.contains(v)){
			bool = true;
		}
		return bool;
	}
	
	/**
	 * Recuperer le graphe lie a ce Vertex
	 * @return graphe
	 */
	public Graph getGraph()
	{return this.g;}
	
	/**
	 * Changer le graphe lie a ce vertex
	 * @param g nouveau graphe
	 */
	public void setGraph(Graph g){
		this.g = g; 
	}
	
	/**
	 * Recuperer la couleur d'un sommet
	 * @return String couleur
	 */
	public String getColor(){
		return this.color;
	}
}
