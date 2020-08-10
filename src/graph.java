import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class graph {

	public class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	HashMap<String, Vertex> vtces;

	public graph() {
		vtces = new HashMap<>();
	}

	public int numVertex() {
		return this.vtces.size();
	}

	public boolean containsVertex(String vname) {
		return this.vtces.containsKey(vname);
	}

	public void addVertex(String vname) {
		Vertex vtx = new Vertex();
		vtces.put(vname, vtx);
	}

	public int numEdges() {
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		int count = 0;
		for (String key : keys) {
			Vertex vtx = vtces.get(key);
			count = count + vtx.nbrs.size();
		}

		return count / 2;
	}

	public boolean containsEdge(String vname1, String vname2) {
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2))
			return false;

		return true;
	}

	public void addEdge(String vname1, String vname2, int cost) {
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2))
			return;

		vtx1.nbrs.put(vname2, cost);
		vtx2.nbrs.put(vname1, cost);
	}

	public void removeEdge(String vname1, String vname2) {
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2))
			return;

		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);
	}

	public void removeVertex(String vname) {
		Vertex vtx = vtces.get(vname);

		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

		for (String key : keys) {
			Vertex nbrvtx = vtces.get(key);
			nbrvtx.nbrs.remove(vname);
		}
	}

	public void display() {
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		for (String key : keys) {
			Vertex vtx = vtces.get(key);
			System.out.println(key + ":" + vtx.nbrs);
		}
	}

	public boolean hasPath(String vname1, String vname2, HashMap<String, Boolean> processed) {
		processed.put(vname1, true);

		if (containsEdge(vname1, vname2))
			return true;

		Vertex vtx = vtces.get(vname1);

		ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());

		for (String nbr : nbrs)
			if (!processed.containsKey(nbr) && hasPath(nbr, vname2, processed))
				return true;

		return false;
	}

//	BFS IMPLEMENTATION- Always gives shortest path

	private class Pair {
		String vname;
		String psf;
	}

	public boolean BFS(String src, String destination) {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();

//		create a new pair
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;

//		put new pair in queue
		queue.addLast(sp);

		while (!queue.isEmpty()) {
			Pair rp = queue.removeFirst();

			if (processed.containsKey(rp.vname))
				continue;

//			insert into processed hashmap
			processed.put(rp.vname, true);

//			check direct edge
			if (containsEdge(rp.vname, destination)) {
				System.out.println(rp.psf);
				return true;
			}

			Vertex rpvtx = vtces.get(rp.vname);

			ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

			for (String nbr : nbrs) {
				if (!processed.containsKey(nbr)) {
					Pair np = new Pair();

					np.vname = nbr;
					np.psf = rp.psf + nbr;

					queue.addLast(np);
				}
			}
		}
		return false;
	}

//	DFS Implementation stack 

	public boolean DFS(String src, String destination) {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();

//		create a new pair
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;

//		put new pair in queue
		stack.addFirst(sp);

		while (!stack.isEmpty()) {
			Pair rp = stack.removeFirst();

			if (processed.containsKey(rp.vname))
				continue;

//			insert into processed hashmap
			processed.put(rp.vname, true);

//			check direct edge
			if (containsEdge(rp.vname, destination)) {
				System.out.println(rp.psf);
				return true;
			}

			Vertex rpvtx = vtces.get(rp.vname);

			ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

			for (String nbr : nbrs) {
				if (!processed.containsKey(nbr)) {
					Pair np = new Pair();

					np.vname = nbr;
					np.psf = rp.psf + nbr;

					stack.addFirst(np);
				}
			}
		}
		return false;
	}

//	BFT  IMPLEMENTATION

	public void BFT() {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>();

		for (String key : keys) {

			if (processed.containsKey(key))
				continue;

//		create a new pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

//		put new pair in queue
			queue.addLast(sp);

			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname))
					continue;

//			insert into processed hashmap
				processed.put(rp.vname, true);

				System.out.println(rp.vname + "via" + rp.psf);

				Vertex rpvtx = vtces.get(rp.vname);

				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();

						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}
			}
		}
	}

//	DFT IMPLEMENTATION

	public void DFT() {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>();
		for (String key : keys) {

			if (processed.containsKey(key))
				continue;
//		create a new pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

//		put new pair in queue
			stack.addFirst(sp);

			while (!stack.isEmpty()) {
				Pair rp = stack.removeFirst();

				if (processed.containsKey(rp.vname))
					continue;

//			insert into processed hashmap
				processed.put(rp.vname, true);

				System.out.println(rp.vname + "via" + rp.psf);

				Vertex rpvtx = vtces.get(rp.vname);

				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();

						np.vname = nbr;
						np.psf = rp.psf + nbr;

						stack.addFirst(np);
					}
				}
			}
		}
	}

//	IS CYCLIC IMPLEMENTATION

	public boolean isCyclic() {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>();

		for (String key : keys) {

			if (processed.containsKey(key))
				continue;

//		create a new pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

//		put new pair in queue
			queue.addLast(sp);

			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname))
					return true;

//			insert into processed hashmap
				processed.put(rp.vname, true);

				Vertex rpvtx = vtces.get(rp.vname);

				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();

						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}
			}
		}

		return false;
	}

//	ISCONNECTED IMPLEMENTATION

	public boolean isConnected() {
		int flag = 0;
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>();

		for (String key : keys) {

			if (processed.containsKey(key))
				continue;

			flag++;

//		create a new pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

//		put new pair in queue
			queue.addLast(sp);

			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname))
					continue;

//			insert into processed hashmap
				processed.put(rp.vname, true);

				System.out.println(rp.vname + "via" + rp.psf);

				Vertex rpvtx = vtces.get(rp.vname);

				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();

						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}
			}
		}

		if (flag >= 2)
			return false;
		else
			return true;
	}

//	ISTREE IMPLEMENTATION

	public boolean isTree() {
		return (!isCyclic() && isConnected());
	}

//	GET CONNECTED COMPONENTS
	public ArrayList<ArrayList<String>> getCC() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>();

		ArrayList<ArrayList<String>> ans = new ArrayList<>();

		for (String key : keys) {

			if (processed.containsKey(key))
				continue;

			ArrayList<String> subans = new ArrayList<>();

//		create a new pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

//		put new pair in queue
			queue.addLast(sp);

			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname))
					continue;

//			insert into processed hashmap
				processed.put(rp.vname, true);

				subans.add(rp.vname);

				Vertex rpvtx = vtces.get(rp.vname);

				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();

						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}
			}

			ans.add(subans);
		}
		
		return ans;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
