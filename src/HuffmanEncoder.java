import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HuffmanEncoder {
	private class Node implements Comparable<Node> {
		Character data;
		int cost;
		Node left;
		Node right;

		Node(char data, int cost) {
			this.data = data;
			this.cost = cost;
			this.left = null;
			this.right = null;
		}

		public Node(Node left, Node right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}

	HashMap<Character, String> encoder;
	HashMap<String, Character> decoder;

	public HuffmanEncoder(String feeder) {
// 1. Make frequency map of the given characters
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < feeder.length(); i++) {
			char cc = feeder.charAt(i);
			if (fmap.containsKey(cc)) {
				int ov = fmap.get(cc);
				ov = ov + 1;
				fmap.put(cc, ov);
			} else
				fmap.put(cc, 1);
		}
//		2. Create minHeap
		HeapGeneric<Node> minHeap = new HeapGeneric<>();
		Set<Map.Entry<Character, Integer>> entryset = fmap.entrySet();

		for (Map.Entry<Character, Integer> entry : entryset) {
			Node node = new Node(entry.getKey(), entry.getValue());
			minHeap.add(node);
		}

//		3.Combine nodes until there is only 1 node in heap
		while (minHeap.size() != 1) {
			Node minOne = minHeap.remove();
			Node minSecond = minHeap.remove();

//			combined node
			Node combined = new Node(minOne, minSecond);
			combined.data = '\0';
			combined.cost = minOne.cost + minSecond.cost;

//			add to min heap
			minHeap.add(combined);
		}

		Node fullTree = minHeap.remove();
		this.encoder = new HashMap<>();
		this.decoder = new HashMap<>();

//		preorder traversal
		this.initEncoderDecoder(fullTree, "");

	}

	private void initEncoderDecoder(Node node, String osf) {
		if (node == null)
			return;

		if (node.left == null && node.right == null) {
			this.encoder.put(node.data, osf);
			this.decoder.put(osf, node.data);
		}

		this.initEncoderDecoder(node.left, osf + "0");
		this.initEncoderDecoder(node.right, osf + "1");

	}

	public String encode(String source) {
		String rv = "";
		for (int i = 0; i < source.length(); i++) {
			String code = this.encoder.get(source.charAt(i));
			rv = rv + code;
		}
		return rv;
	}

	public String decode(String codedString) {
		String rv = "";
		String key = "";
		for (int i = 0; i < codedString.length(); i++) {
			key = key + codedString.charAt(i);
			if (this.decoder.containsKey(key)) {
				rv = rv + this.decoder.get(key);
				key = "";
			}
		}
		return rv;
	}

	public static void main(String[] args) {
		String str = "abbcdda";
		System.out.println("Initial string size=" + 2 * (str.length()) + "bytes");
		HuffmanEncoder hf = new HuffmanEncoder(str);
		String codedString = hf.encode(str);
		System.out.println(codedString);
		String output = hf.decode(codedString);
		System.out.println(output);

		BitSet bitset = new BitSet(codedString.length());
		int bitcounter = 0;
		for (Character c : codedString.toCharArray()) {
			if (c.equals('1'))
				bitset.set(bitcounter);
			bitcounter++;
		}
		byte[] arr = bitset.toByteArray();
		System.out.println("Reduced size=" + arr.length + "bytes");
	}

}
