
/*
 * Java program to find out whether 
a given graph is Bipartite or not. 
Using recursion. */
class Bipartite 
{ 
	static final int V = 4; 

	static boolean colorGraph(int G[][],boolean[] visited,int color[],int v,int c) 
	{ 
		visited[v]=true;
		color[v]=c;
		for(int i=0;i<G[v].length;i++) {
			if(visited[i]==false) {
				if(colorGraph(G,visited,color,i,c^1)==false)
					return false;
				else if(color[v]==color[i]) return false;
			}
		}
				return true; 
	} 

	static boolean isBipartite(int G[][]) 
	{ 
		int[] color = new int[V]; 
		boolean[] visited = new boolean[V]; 
		for (int i = 0; i < V; i++) 
			color[i] = -1;  
	
		
		return colorGraph(G,visited,color,0,1); 
	} 

	
	public static void main(String[] args) 
	{ 
		int G[][] = { { 0, 1, 0, 1 }, 
					{ 1, 0, 1, 0 }, 
					{ 0, 1, 0, 1 }, 
					{ 1, 0, 1, 0 } }; 

		if (isBipartite(G)) 
			System.out.print("Yes"); 
		else
			System.out.print("No"); 
	} 
} 