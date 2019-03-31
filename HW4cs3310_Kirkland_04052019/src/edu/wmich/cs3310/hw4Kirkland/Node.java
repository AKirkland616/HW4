package edu.wmich.cs3310.hw4Kirkland;

import java.util.Map;

public class Node {
	Map.Entry<Character, Integer> value;
	Node nextN;
	
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
