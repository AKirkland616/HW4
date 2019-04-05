package edu.wmich.cs3310.hw4Kirkland;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anthony Kirkland & Michael Coffey
 *
 */
public class Huffman {
	PriorityQueue pq = new PriorityQueue();
	Map<Character, String> encodeKey = new HashMap<Character, String>();
	Map<String, Character> decodeKey = new HashMap<String,Character >();
	HuffmanNode tree;
	int oddEven;
	
	/** constructor for huffman class
	 * @param pqt
	 * @param oddeven
	 */
	public Huffman(PriorityQueue pqt, int oddeven) {
		pq = pqt;
		oddEven = oddeven;
		tree = createTree();
		makeKeys(tree, "");
	}
	
	/** uses priority queue to create huffman tree
	 * @return
	 */
	public HuffmanNode createTree() {
		HuffmanNode root = null; 
		
		while(pq.size()>1) {
			HuffmanNode first = pq.dequeue();
			HuffmanNode second = pq.dequeue();
			HuffmanNode f = new HuffmanNode(); 
			f.setFreq(first.getFreq()+second.getFreq());
			f.setChar('\n');
			f.setLeft(first);
			f.setRight(second);
			root = f;
			pq.enqueue(f);
		}
		return root;
	}
	
	
	/** makes encoding and decoding keys
	 * @param root root of tree
	 * @param s string of path
	 */
	public void makeKeys(HuffmanNode root, String s) {
		if (root.getLeft() == null && root.getRight() == null && root.getChar()!='\n') { 
			
            // c is the character in the node 
			encodeKey.put(root.getChar(), s);
			decodeKey.put(s, root.getChar());
            //System.out.println(root.getChar() + ":" + s); 
  
            return; 
        } 
		
		 if(oddEven == 0) {
			 makeKeys(root.getLeft(), s + "0"); 
			 makeKeys(root.getRight(), s + "1");
	     }else {
	    	 makeKeys(root.getLeft(), s + "1"); 
	    	 makeKeys(root.getRight(), s + "0"); 
	        }
	}
	
	/** used to encode
	 * @return key to encodings
	 */
	public Map<Character, String> getEncodeKey() {
		return encodeKey;
	}
	
	/**used to decode
	 * @return decoding key
	 */
	public Map<String, Character> getDecodeKey() {
		return decodeKey;
	}
}
