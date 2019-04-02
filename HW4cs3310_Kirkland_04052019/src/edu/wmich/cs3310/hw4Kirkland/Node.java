package edu.wmich.cs3310.hw4Kirkland;

import java.util.Map;

public class Node {
	Map.Entry<Character, Integer> value;
	Node nextN;
	
	
	
	//For Huffman Tree
	int val;
	char letter;
	Node lChild;
	Node rChild;
	Node parent;
	
	public Node(int dataVal, Node left, Node right) {
		val = dataVal;
		lChild = left;
		rChild = right;
	}
	
	public Node(char letterVal) {
		letter = letterVal;
		lChild = null;
		rChild = null;
	}
	
	public int getVal() {
		return val;
	}
	
	public Node leftChild() {
		return lChild;
	}
	
	public Node rightChild() {
		return rChild;
	}
	
	
	//End of Huffman Tree
	
	
	
	
	public Node(Map.Entry<Character, Integer> dataValue){// Constructor
		value = dataValue;
		nextN = null;
	}
	
	public Node(Map.Entry<Character, Integer> dataValue, Node nextNode){// Constructor
		value = dataValue;
		nextN = nextNode;
	}

	public Map.Entry<Character, Integer> getData() {
		// TODO Auto-generated method stub
		return value;
	}

	public Node getNext(){
		// TODO Auto-generated method stub
		return nextN;
	}

	public void setNext(Node next) {
		// TODO Auto-generated method stub
		nextN = next;
	}

}
