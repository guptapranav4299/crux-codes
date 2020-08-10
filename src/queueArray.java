
public class queueArray {
	private int[] data;
	private int size;
	private int front;
	public static final int Default_Capacity = 10;

	public queueArray() throws Exception {
		// TODO Auto-generated constructor stub
		this(Default_Capacity);
	}

	public queueArray(int capacity) throws Exception {
		// TODO Auto-generated constructor stub
		if (capacity < 1)
			throw new Exception("Invalid capacity");
		this.data = new int[capacity];
		this.front = 0;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void enqueue(int value) throws Exception {
		if (this.size == this.data.length)
			throw new Exception("Queue is full");

		int idx = (this.front + this.size) % this.data.length;
		this.data[idx] = value;
		this.size++;
	}

	public int dequeue() throws Exception {
		if (this.size() == 0)
			throw new Exception("Queue is Empty");
		int rv = this.data[this.front];
		this.data[this.front] = 0;
		this.front = (this.front + 1) % this.data.length;
		this.size--;
		return rv;
	}

	public int front() throws Exception {
		if (this.size() == 0)
			throw new Exception("Queue is Empty");
		int rv = this.data[this.front];
		return rv;
	}

	public void display() {
		for (int i = 0; i < this.size; i++) {
			int ai = (this.front + i) % this.data.length;
			System.out.print(this.data[ai] + " ");
		}
		System.out.print("END");
		System.out.println();
		System.out.println("...............");
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		queueArray q = new queueArray();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.display();
		q.dequeue();
		q.display();
		System.out.println(q.size());
		System.out.println(q.isEmpty());

	}

}
