package Hash;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImpl {

	// Custom HashMap Implementation
	static class HashMap<K, V> {

		// Node class to store key-value pair
		private class Node {
			K key;
			V value;

			public Node(K key, V value) {
				this.key = key;
				this.value = value;
			}
		}

		private int n; // number of nodes (key-value pairs)
		private int N; // number of buckets
		private LinkedList<Node> buckets[]; // array of linked lists

		@SuppressWarnings("unchecked")
		public HashMap() {

			// initial bucket size
			this.N = 4;

			// create array of linked lists
			this.buckets = new LinkedList[N];

			for (int i = 0; i < N; i++) {
				buckets[i] = new LinkedList<>();
			}
		}

		// Hash function to convert key → bucket index
		private int hashFunction(K key) {
			int bi = key.hashCode(); // hashCode from Object class
			return Math.abs(bi) % N; // ensure index within bucket range
		}

		// Search key inside LinkedList of a bucket
		private int searchInLL(K key, int bi) {

			LinkedList<Node> ll = buckets[bi];

			for (int i = 0; i < ll.size(); i++) {

				// equals() must be used instead of ==
				if (ll.get(i).key.equals(key)) {
					return i; // return data index
				}
			}

			return -1; // key not found
		}

		// Rehashing when load factor becomes large
		public void rehash() {

			LinkedList<Node> oldBucket[] = buckets;

			// increase bucket size
			N = N * 2;

			buckets = new LinkedList[N];

			for (int i = 0; i < N; i++) {
				buckets[i] = new LinkedList<>();
			}

			n = 0; // reset node count

			// reinsert all nodes
			for (int i = 0; i < oldBucket.length; i++) {

				LinkedList<Node> ll = oldBucket[i];

				for (int j = 0; j < ll.size(); j++) {
					Node node = ll.get(j);
					put(node.key, node.value);
				}
			}
		}

		// Insert or update key-value pair
		public void put(K key, V value) {

			int bi = hashFunction(key); // bucket index
			int di = searchInLL(key, bi); // data index

			if (di == -1) {

				// key not present → insert new node
				buckets[bi].add(new Node(key, value));
				n++;

			} else {

				// key already exists → update value
				Node node = buckets[bi].get(di);
				node.value = value;
			}

			// Load factor calculation
			double lambda = (double) n / N;

			// if load factor too high → rehash
			if (lambda > 2.0) {
				rehash();
			}
		}

		// Get value by key
		public V get(K key) {

			int bi = hashFunction(key);
			int di = searchInLL(key, bi);

			if (di == -1) {
				return null;
			} else {
				Node node = buckets[bi].get(di);
				return node.value;
			}
		}

		// Check if key exists
		public boolean containsKey(K key) {

			int bi = hashFunction(key);
			int di = searchInLL(key, bi);

			return di != -1;
		}

		// Remove key-value pair
		public V remove(K key) {

			int bi = hashFunction(key);
			int di = searchInLL(key, bi);

			if (di == -1) {
				return null;
			} else {
				Node node = buckets[bi].remove(di);
				n--;
				return node.value;
			}
		}

		// Check if map is empty
		public boolean isEmpty() {
			return n == 0;
		}

		// Return all keys
		public ArrayList<K> keySet() {

			ArrayList<K> keys = new ArrayList<>();

			for (int i = 0; i < buckets.length; i++) {

				LinkedList<Node> ll = buckets[i];

				for (int j = 0; j < ll.size(); j++) {
					Node node = ll.get(j);
					keys.add(node.key);
				}
			}

			return keys;
		}

		// Override toString() so printing map shows key-value pairs
		@Override
		public String toString() {

			StringBuilder sb = new StringBuilder();

			sb.append("{");

			for (int i = 0; i < buckets.length; i++) {

				LinkedList<Node> ll = buckets[i];

				for (int j = 0; j < ll.size(); j++) {

					Node node = ll.get(j);

					sb.append(node.key).append("=").append(node.value).append(", ");
				}
			}

			if (sb.length() > 1) {
				sb.delete(sb.length() - 2, sb.length());
			}

			sb.append("}");

			return sb.toString();
		}
	}

	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap<>();

		map.put("US", 180);
		map.put("India", 120);
		map.put("Nepal", 100);

		// Now this prints correctly
		System.out.println(map);

		// Print using keySet
		ArrayList<String> keys = map.keySet();

		for (int i = 0; i < keys.size(); i++) {

			System.out.println(keys.get(i) + " " + map.get(keys.get(i)));
		}
	}
}