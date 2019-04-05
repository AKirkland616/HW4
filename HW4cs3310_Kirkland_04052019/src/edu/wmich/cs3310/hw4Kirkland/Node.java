package edu.wmich.cs3310.hw4Kirkland;

/**
 * @author Anthony Kirkland and Michael Coffey
 *
 */
public class Node {
	HuffmanNode value;
	Node nextN;

	/**constructor that takes huffman node
	 * @param dataValue huffman node
	 */
	public Node(HuffmanNode dataValue){// Constructor
		value = dataValue;
		nextN = null;
	}
	
	/**constructor that takes huffman node and next node
	 * @param dataValue huffman node
	 * @param nextNode huffman node
	 */
	public Node(HuffmanNode dataValue, Node nextNode){// Constructor
		value = dataValue;
		nextN = nextNode;
	}

	/** getter for data
	 * @return huffman node
	 */
	public HuffmanNode getData() {
		// TODO Auto-generated method stub
		return value;
	}
	
	/**getter for value
	 * @return frequency
	 */
	public int getValue() {
		return value.getFreq();
	}

	/**getter for next node
	 * @return next node
	 */
	public Node getNext(){
		// TODO Auto-generated method stub
		return nextN;
	}

	/**setter for next node
	 * @param next next node
	 */
	public void setNext(Node next) {
		// TODO Auto-generated method stub
		nextN = next;
	}

}
