import java.util.ArrayList;
import java.util.Scanner;

public class graphAL {
	ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();;
	int u;
	int v;

	public graphAL() {
		System.out.println("Enter no. of vertices");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<Integer>());
	}

	public void addEdge(int u1, int v1) {
		adj.get(u1).add(v1);
		adj.get(v1).add(u1);
	}

	public void printGraph() {
		for (int i = 0; i < adj.size(); i++) {
			System.out.println("Adjacency list of vertex " + i);
			System.out.print("Head");

			for (int j = 0; j < adj.get(i).size(); j++)
				System.out.print("->" + adj.get(i).get(j));
			System.out.println();
		}
	}

	public int numVertex() {
		return this.adj.size();
	}

	public boolean containsVertex(int vname) {
		for (int i = 0; i < adj.size(); i++)
			if (vname == i)
				return true;
		return false;
	}

	public void addVertex(int vname) {
		adj.add(vname, new ArrayList<Integer>());
	}

	public int numEdges() {
		int count = 0;
		for (int i = 0; i < adj.size(); i++) {
			for (int j = 0; j < adj.get(i).size(); j++)
				count++;
		}
		return count / 2;
	}

	public boolean containsEdge(int vname1, int vname2) {
		for (int i = 0; i < adj.get(vname1).size(); i++)
			if (vname2 == adj.get(vname1).get(i))
				return true;
		return false;

	}

	public void removeEdge(int vname1, int vname2) {

		for (int i = 0; i < adj.get(vname1).size(); i++) {
			if (adj.get(vname1).get(i) == vname2) {
				adj.get(vname1).remove(i);
				break;
			}
		}

		for (int i = 0; i < adj.get(vname2).size(); i++) {
			if (adj.get(vname2).get(i) == vname1) {
				adj.get(vname2).remove(i);
				break;
			}
		}
	}

	public void removeVertex(int vname1) {
		while (adj.get(vname1).size()>0)
			adj.get(vname1).remove(0);
		adj.remove(vname1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		graphAL gl = new graphAL();
		gl.addEdge(0, 1);
		gl.addEdge(0, 4);
		gl.addEdge(1, 2);
		gl.addEdge(1, 3);
		gl.addEdge(1, 4);
		gl.addEdge(2, 3);
		gl.addEdge(3, 4);
		gl.printGraph();
//		gl.addVertex(5);
//		gl.printGraph();
//		gl.removeEdge(0, 1);
		System.out.println(".....................");
//		gl.printGraph();
//		System.out.println(gl.containsEdge(0, 1));
//		System.out.println(gl.containsEdge(2, 4));
//		gl.removeVertex(4);
		gl.printGraph();
		System.out.println(gl.containsVertex(4));
		System.out.println(gl.numVertex());
		System.out.println(gl.numEdges());

	}

}
