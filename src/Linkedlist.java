
public class Linkedlist {

	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

//	o(n)
	public void display() {
		Node temp = this.head;
		System.out.println("..................");
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		System.out.println("..................");
	}

//	o(1)
	public void addLast(int item) {

		Node n = new Node();
		n.data = item;
		n.next = null;

		if (this.size == 0) {
			this.head = n;
			this.tail = n;
			this.size++;
		} else {
			this.tail.next = n;
			this.tail = n;
			this.size++;
		}
	}

//	o(1)
	public void addFirst(int item) {
		Node n = new Node();
		n.data = item;
		n.next = null;

		if (this.size == 0) {
			this.head = n;
			this.tail = n;
			this.size++;
		} else {
			n.next = head;
			head = n;
			this.size++;
		}
	}

//	o(1)
	public int getFirst() throws Exception {
		if (this.size == 0)
			throw new Exception("LL is empty");
		return this.head.data;
	}

//	o(1)
	public int getLast() throws Exception {
		if (this.size == 0)
			throw new Exception("LL is empty");
		return this.tail.data;
	}

//	o(n)
	public int getAt(int idx) throws Exception {
		if (idx >= this.size || idx < 0)
			throw new Exception("Invalid index");
		if (this.size == 0)
			throw new Exception("LL is empty");
		Node temp = this.head;

		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

//	o(n)
	public Node getNodeAt(int idx) throws Exception {
		if (this.size == 0)
			throw new Exception("LL is empty");
		if (idx >= this.size || idx < 0)
			throw new Exception("Invalid index");

		Node temp = this.head;
		for (int i = 1; i <= idx; i++)
			temp = temp.next;

		return temp;
	}

	public void AddAt(int item, int idx) throws Exception {

		if (idx < 0 || idx >= this.size)
			throw new Exception("Invalid index");
		if (idx == 0)
			addFirst(item);
		if (idx == this.size)
			addLast(item);

		Node n = new Node();
		n.data = item;
		n.next = null;

		Node nm1 = getNodeAt(idx - 1);
		Node np1 = nm1.next;
		nm1.next = n;
		n.next = np1;
		this.size++;

	}

// o(1)
	public int removeFirst() throws Exception {
		if (this.size == 0)
			throw new Exception("Nothing to delete from empty LL");

		int rv = head.data;

		if (this.size == 1) {

			this.head = null;
			this.tail = null;
			size = 0;
		} else {
			this.head = head.next;
			this.size--;
		}
		return rv;

	}

	public int removeLast() throws Exception {
		if (this.size == 0)
			throw new Exception("Empty LL");

		int rv = this.tail.data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			size = 0;
		} else {
			Node sizem2 = getNodeAt(this.size - 2);
			this.tail = sizem2;
			this.tail.next = null;
			this.size--;
		}
		return rv;

	}

//	o(n)
	public int removeAt(int idx) throws Exception {
		if (this.size == 0)
			throw new Exception("LL is empty");
		if (idx < 0 || idx >= this.size)
			throw new Exception("Invalid index");

		if (idx == 0)
			return removeFirst();
		else if (idx == this.size - 1)
			return removeLast();
		else {
			Node nm1 = getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;
			this.size--;

			return n.data;
		}
	}

//	o(n*t)
	public void reverseLLData() throws Exception {
		int left = 0;
		int right = this.size - 1;
		while (left < right) {
			Node ln = getNodeAt(left);
			Node rn = getNodeAt(right);

			int temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;

			left++;
			right--;
		}
	}

//	o(n)
	public int mid() {
		Node slow = this.head;
		Node fast = this.head;

		while (fast.next != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;
	}

//	o(n)
	public void reverseLLPointer() {
		Node prev = this.head;
		Node curr = prev.next;

		while (curr != null) {
			Node ahead = curr.next;
			curr.next = prev;
			curr = ahead;
		}
//		swap
		Node t = this.head;
		this.head = this.tail;
		this.tail = t;

		this.tail.next = null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linkedlist ll = new Linkedlist();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.display();

	}

}
