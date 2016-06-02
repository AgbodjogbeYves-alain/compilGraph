package graphprojet;

import java.util.Scanner;

public class colorier {
	public void colorier(Graph g){
		System.out.println("Entrer le nombre de couleurs");//creer un tableau de couleurs
		Scanner sc = new Scanner(System.in);
		int k = Integer.parseInt(sc.nextLine());
		
		for(Vertex v : g.getVertexs()){
			v.color = "Blanc";
		}
		
		
		
	}
	
	public Vertex vertex_less_degre(Graph g,int k){
		Vertex temp;
		if(g.getVertexs()!= null){
			temp = g.getVertexs().get(0);
			for(Vertex v : g.getVertexs()){
				if (temp.degre <= v.degre){
					if (temp.degre<k){
						temp = v;
					}
				}
			}
		}
		
		
		return null;
		
	}
}
