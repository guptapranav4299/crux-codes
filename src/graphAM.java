import java.util.Scanner;

public class graphAM {
	int vertex;
	int[][] matrix = new int[50][50];

	public graphAM(int vertex) {
		this.vertex = vertex;
		for (int i = 0; i < vertex; i++)
			for (int j = 0; j < vertex; j++)
				matrix[i][j] = 0;
	}

	public int numVertex() {
		return vertex;
	}

	public void addEdge(int source, int destination) {
		matrix[source][destination] = 1;
		matrix[destination][source] = 1;
	}

	public boolean containsVertex(int vtx) {
		for (int i = 0; i < matrix.length; i++)
			if (i == vtx)
				return true;
		return false;
	}

	public void printVertices() {
		for (int i = 0; i < matrix.length; i++)
			System.out.println(i);
	}

	public void printGraph() {
		System.out.println("Graph: (Adjacency Matrix)");
		for (int i = 0; i < vertex; i++) {
			for (int j = 0; j < vertex; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		for (int i = 0; i < vertex; i++) {
			System.out.print("Vertex " + i + " is connected to:");
			for (int j = 0; j < vertex; j++) {
				if (matrix[i][j] == 1) {
					System.out.print(j + " ");
				}
			}
			System.out.println();
		}
	}

	public void addVertex() {
		this.vertex++;
		for (int i = 0; i < this.vertex; ++i) {
			matrix[i][this.vertex - 1] = 0;
			matrix[this.vertex - 1][i] = 0;
		}
	}

	public int numEdges() {
		int count = 0;
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix.length; j++)
				if (matrix[i][j] == 1)
					count++;
		return count / 2;
	}

	public boolean containsEdge(int source, int destination) {
		return (matrix[source][destination] == 1);
	}

	public void removeEdge(int source, int destination) {
		matrix[source][destination] = 0;
		matrix[destination][source] = 0;
	}

	public void removeVertex(int vtx) {
		if (vtx > vertex) {
			System.out.println("Vertex not present!");
			return;
		} else {
			int i;

			// removing the vertex
			while (vtx < vertex) {

				// shifting the rows to left side
				for (i = 0; i < vertex; ++i) {
					matrix[i][vtx] = matrix[i][vtx + 1];
				}

				// shifting the columns upwards
				for (i = 0; i < vertex; ++i) {
					matrix[vtx][i] = matrix[vtx + 1][i];
				}
				vtx++;
			}

			// decreasing the number of vertices
			vertex--;
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		graphAM gm = new graphAM(n);
		gm.addEdge(0, 1);
		gm.addEdge(0, 2);
		gm.addEdge(1, 2);
		gm.addEdge(1, 3);
		gm.addEdge(2, 4);
		gm.addEdge(3, 4);
		gm.addEdge(2, 3);
		gm.printGraph();
//		System.out.println(gm.containsVertex(7));
//		gm.printVertices();
//		gm.addVertex();
//		gm.printGraph();
		System.out.println(gm.numEdges());
//		gm.removeEdge(2, 3);
//		System.out.println(gm.numEdges());		
		System.out.println(gm.containsEdge(2, 3));
		gm.removeVertex(4);
		System.out.println(gm.numVertex());

	}

}
