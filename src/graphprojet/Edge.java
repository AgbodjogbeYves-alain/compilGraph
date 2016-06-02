package graphprojet;
/* Classe representante une arrete du graphe*/
/**
 * 
 * @author Othniel Agbodjogbe Godefroi Roussel
 *
 */
public class Edge {
	
	int numEdge;
	Vertex[] relatedVertex = new Vertex[2];
	Graph g;
	/**
	 * Constructeur d un edge
	 * @param num identificateur du Edge
	 */
	public Edge(int num){
		numEdge = num;
		relatedVertex = null;
	}
	
	/**
	 * Constructeur d un Edge
	 * @param v L un des vertex que lie le Edge
	 * @param x L un des vertex que lie le Edge
	 * @param g Le graphe auquel appartient le Edge
	 */
	public Edge(Vertex v,Vertex x,Graph g)
	{
		this.g = g;
		relatedVertex[1] = x;
		relatedVertex[0] = v;
	}
	
	/**
	 * Constructeur d un Edge
	 * @param num identificateur du Edge
	 * @param g Le graphe auquel appartient le Edge
	 */
	public Edge(int num,Graph g){
		this.g = g;
		numEdge = num;
		relatedVertex = null;
	}
	
	public Edge(int num,Vertex v,Vertex x,Graph g)
	{
		this.g = g;
		this.numEdge = num;
		relatedVertex[1] = x;
		relatedVertex[0] = v;
	}
	
	/**
	 * Procedure qui permet de lier 2 Vertex
	 * @param v Vertex a lier
	 * @param x Vertex a lier
	 * Si le Edge est deja lié a 2 Vertex renvoi un erreur
	 */
	public void relierSommet(Vertex v,Vertex x)
	{
		if (relatedVertex[0]== null || relatedVertex[1] == null){
			relatedVertex[0] = v;
			relatedVertex[1] = x;
			}
			else System.out.println("Cette arrete est deja lié a 2");
	}
	
	/**
	 * Renvoi l identifiant du Edge si il en a un
	 * @return numEdge identifiant du Edge
	 */
	public int getEdge()
	{
		return this.numEdge;
	}
	
	/**
	 * Renvoi le vertex dont part la liaison
	 * @return Vertex
	 */
	public Vertex getFirstVertex(){
		return this.relatedVertex[0];
	}
	
	/**
	 * Renvoi le vertex ou arrive la liaison
	 * @return Vertex
	 */
	public Vertex getSecondVertex(){
		return this.relatedVertex[1];
	}
	
	/**
	 * Modifie l identifiant du Edge
	 * @param num nouvel identifiant du Edge
	 */
	public void setEdge(int num)
	{
		this.numEdge = num;
	}
	
	/**
	 * Procedure de suppression de Edge
	 * Si le Edge est relie a au moins un Vertex supprime la relation entre le Edge et le 
	 * Vertex
	 * Sinon renvoi une erreur
	 * Propage la suppression aux Vertex concernes
	 */
	public void supprimerRelation()
	{
		if (relatedVertex[0] != null){
			this.relatedVertex[0].relatedEdge.remove(relatedVertex[0].foundEdge(numEdge));
			if (this.relatedVertex[0].estpreferent(this.relatedVertex[1])){
				this.relatedVertex[0].preferencesVertex.remove(relatedVertex[1]);
				this.relatedVertex[1].relatedEdge.remove(relatedVertex[0].foundEdge(numEdge));
				this.relatedVertex[1].preferencesVertex.remove(relatedVertex[0]);
				this.relatedVertex = null;
			}
			else if(this.relatedVertex[0].estinterferent(this.relatedVertex[1])){
				this.relatedVertex[0].interferencesVertex.remove(relatedVertex[1]);
				this.relatedVertex[1].relatedEdge.remove(relatedVertex[0].foundEdge(numEdge));
				this.relatedVertex[1].interferencesVertex.remove(relatedVertex[0]);
				this.relatedVertex = null;
			}
		}
		else {this.relatedVertex = null;}
	}
	
}
