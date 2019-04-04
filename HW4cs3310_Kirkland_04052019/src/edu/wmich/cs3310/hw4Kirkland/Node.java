package edu.wmich.cs3310.hw4Kirkland;

public class Node {
	HuffmanNode value;
	Node nextN;

	public Node(HuffmanNode dataValue){// Constructor
		value = dataValue;
		nextN = null;
	}
	
	public Node(HuffmanNode dataValue, Node nextNode){// Constructor
		value = dataValue;
		nextN = nextNode;
	}

	public HuffmanNode getData() {
		// TODO Auto-generated method stub
		return value;
	}
	
	public int getValue() {
		return value.getFreq();
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
