import java.util.Scanner;
import java.util.Vector;

public class BST {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;
//	private Vector<Node> sv;

	public BST(int[] arr) {
		this.root = construct(arr, 0, arr.length - 1);
//		this.root=build(this.sv,0,arr.length-1);
	}

//	Construct a bst
//the mid of the array will be the root node for o(logn) complexity 
//because if we take border points then we will get a left or right skewed
//	array which will give us 0(N) complexity
	private Node construct(int[] arr, int low, int high) {
		if (low > high)
			return null;

		int mid = (low + high) / 2;

		Node n = new Node();
		n.data = arr[mid];
		n.left = construct(arr, low, mid - 1);
		n.right = construct(arr, mid + 1, high);
		return n;
	}

	public void display() {
		System.out.println(".................");
		display(this.root);
		System.out.println(".................");
	}

//	to display bst
	private void display(Node node) {
		if (node == null)
			return;
		String str = "";
		if (node.left == null)
			str += ".";
		else
			str += node.left.data;
		str += "->" + node.data + "<-";

		if (node.right == null)
			str += ".";
		else
			str += node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public boolean find(int item) {
		return find(this.root, item);
	}

//	to find an item in bst
	private boolean find(Node node, int item) {
		if (node == null)
			return false;
		if (item > node.data)
			find(node.right, item);
		else if (item < node.data)
			find(node.left, item);

		return true;
	}

	public int max() {
		return max(this.root);
	}

	// to find max in bst
	private int max(Node node) {
		if (node.right == null)
			return node.data;

		return max(node.right);
	}

	public void insert(int item) {
		insert(this.root, item);
	}

//	to insert an element
	private void insert(Node node, int item) {
		if (item > node.data) {
			if (node.right == null) {
				Node n = new Node();
				n.data = item;
				node.right = n;
			} else
				insert(node.right, item);
		} else {

			if (node.left == null) {
				Node n = new Node();
				n.data = item;
				node.left = n;
			} else
				insert(node.left, item);
		}
	}

	public void remove(int item) {
		remove(this.root, null, false, item);
	}

	private void remove(Node node, Node parent, boolean ilc, int item) {
		if (node == null)
			return;

		if (item > node.data)
			remove(node.right, node, false, item);
		else if (item < node.data)
			remove(node.left, node, true, item);
		else {
//			case-1 when both children are null
			if (node.left == null && node.right == null) {
				if (ilc)
					parent.left = null;
				else
					parent.right = null;
			}
//			case 2-when either of them is not null
			else if (node.left == null && node.right != null)
//				case 2a) if left is null
			{
				if (ilc)
					parent.left = node.right;
				else
					parent.right = node.right;
			} else if (node.left != null && node.right == null)
//			case 2b) when right is null
			{
				if (ilc)
					parent.left = node.left;
				else
					parent.right = node.left;
			} else {
//				case 3-when both the children are not null
				int max = max(node.left);
				node.data = max;

				remove(node.left, node, true, max);
			}
		}
	}

	public void storeBSTnodes(Node node, Vector<Node> nodes) {
		if (node == null)
			return;

		storeBSTnodes(node.left, nodes);
		nodes.add(node);
		storeBSTnodes(node.right, nodes);
	}

	private Node build(Vector<Node> nodes, int low, int high) {
		if (low > high)
			return null;

		int mid = (low + high) / 2;

		Node n = nodes.get(mid);

		n.left = build(nodes, low, mid - 1);
		n.right = build(nodes, mid + 1, high);
		return n;
	}

	public Node buildNode(Node node) {
		Vector<Node> nodes = new Vector<Node>();
		storeBSTnodes(node, nodes);

		int n = nodes.size();
		return build(nodes, 0, n - 1);

	}

	public void preOrder() {
		preOrder(this.root);
	}

	private void preOrder(Node node) {
		if (node == null)
			return;

		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
//		int arr[] = { 20, 30, 40, 50, 60 };
//		BST bst = new BST(arr);
//		bst.display();
//		System.out.println(bst.find(30));
//		System.out.println(bst.max());
//		bst.insert(55);
//		bst.display();
//		bst.remove(55);
//		bst.display();

//		int t=scn.nextInt();
//		
//		int arr []=new int [1000];
//		for(int i=0;i<t;i++)
//		{
//			int size=scn.nextInt();
//			for(int j=0;j<size;j++)
//			{
//				arr[j]=scn.nextInt();
//			}
//			BST bst=new BST(arr);
//			bst.preOrder();
//		int n=Integer.MIN_VALUE;

	}
}
