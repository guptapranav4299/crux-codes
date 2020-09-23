import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
	private class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	Node root;
	int size;

	public BinaryTree() {
		Scanner s = new Scanner(System.in);
		this.root = takeInput(s, null, false);
	}

	private Node takeInput(Scanner s, Node parent, boolean isLeftRight) {
		if (parent == null)
			System.out.println("Enter data for root node");
		else {
			if (isLeftRight)
				System.out.println("Enter data for left child" + parent.data);
			else
				System.out.println("Enter data for right child" + parent.data);
		}
		int nodeData = s.nextInt();
		Node node = new Node(nodeData, null, null);
		this.size++;

		boolean choice = false;
		System.out.println("Do you have left child of" + node.data);
		choice = s.nextBoolean();

		if (choice)
			node.left = takeInput(s, node, true);

		choice = false;
		System.out.println("Do you have right child of" + node.data);
		choice = s.nextBoolean();

		if (choice)
			node.right = takeInput(s, node, false);

		return node;
	}

	public void display() {
		this.display(this.root);
	}

	private void display(Node node) {
		String str = "";
		if (node.left == null)
			str += "End=>";
		else
			str += node.left.data + "=>";

		str += node.data;

		if (node.right == null)
			str += "<=End";
		else
			str += "<=" + node.right.data;

		System.out.println(str);

		if (node.left != null)
			this.display(node.left);
		if (node.right != null)
			this.display(node.right);
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		if (node == null)
			return -1;
		int lheight = height(node.left);
		int rheight = height(node.right);

		int height = Math.max(lheight, rheight);
		return height;
	}

	public void preOrder() {
		this.preOrder(this.root);
	}

//	nlr
	private void preOrder(Node node) {
		if (node == null)
			return;

		System.out.println(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}

	public void inOrder() {
		this.inOrder(this.root);
	}

//	lnr
	private void inOrder(Node node) {
		if (node == null)
			return;

		inOrder(node.left);
		System.out.println(node.data);
		inOrder(node.right);
	}

	public void postOrder() {
		this.postOrder(this.root);
	}

//	lrn
	private void postOrder(Node node) {
		if (node == null)
			return;

		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.data);
	}

	public void levelOrder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(this.root);
		while (!queue.isEmpty()) {
			Node rv = queue.removeFirst();

			System.out.println(rv.data + ",");

			if (rv.left != null)
				queue.addFirst(rv.left);
			if (rv.right != null)
				queue.addFirst(rv.right);
		}
	}

	public int sum() {

		return sum(this.root);

	}

	private int sum(Node node) {
		if (node == null)
			return 0;
		return node.data + sum(node.left) + sum(node.right);
	}

	public void leftViewTreeIter() {
		if (root == null)
			return;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int count = queue.size();

			for (int i = 0; i < count; i++) {
				Node curr = queue.poll();
				if (i == 0)
					System.out.print(curr.data + " ");
				if (curr.left != null)
					queue.add(curr.left);
				if (curr.right != null)
					queue.add(curr.right);
			}
		}
	}
	
	public void rightViewTreeIter() {
		if (root == null)
			return;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int count = queue.size();

			for (int i = 0; i < count; i++) {
				Node curr = queue.poll();
				if (i == 0)
					System.out.print(curr.data + " ");
				if (curr.right != null)
					queue.add(curr.right);
				if (curr.left != null)
					queue.add(curr.left);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		10
//		true
//		20
//		true
//		40
//		true
//		70
//		false
//		false
//		false
//		true
//		60
//		true
//		80
//		false
//		false
//		false
//		true
//		30
//		false
//		false
		BinaryTree bt = new BinaryTree();
		System.out.println(bt.sum());
		bt.leftViewTreeIter();
		System.out.println("...................");
		bt.rightViewTreeIter();
	}

}
