package edu.wmich.cs3310.hw4Kirkland;

import java.util.Map;

public class PriorityQueue {
	private Node head;
	private Node tail;
	private int sizeOfQueue = 0;
	
	
	// Determine if the priority queue is empty.
	public boolean isEmpty() {
		return (head==null);
	}
	
	// Add object received to the priority queue taking into consideration the rules governing priority.
	public void enqueue(Map.Entry<Character, Integer> data) {
		Node n = new Node(data);
		sizeOfQueue++;
		if(isEmpty()) {
			head =n;
			tail =head;
		}else {
			
			Node headcopy = head;
			int index = 0;
			while(headcopy != null) {
				if(( data.getValue()> headcopy.getData().getValue())|| data.getValue()==headcopy.getData().getValue()) {
					break;
				}
				headcopy = headcopy.getNext();
				index++;
				
			}
			if (index == 0) {
				Node newNode = new Node(n.getData(), head);
				head = newNode;
			
			}else {
				Node ref = head;
				for(int i = 0; i <index-1; i++) {
				ref = ref.getNext();
			}
			Node successor = ref.getNext();
			ref.setNext(n);
			n.setNext(successor);
			if(n.getNext() == null) {
				tail = n;
			}
		}
		}
		
	}
	
	public void enqueue(Node data) {
		Node n = data;
		sizeOfQueue++;
		if(isEmpty()) {
			head =n;
			tail =head;
		}else {
			
			Node headcopy = head;
			int index = 0;
			while(headcopy != null) {
				if(( data.getVal()> headcopy.getData().getValue())|| data.getVal() ==headcopy.getData().getValue()) {
					break;
				}
				headcopy = headcopy.getNext();
				index++;
				
			}
			if (index == 0) {
				Node newNode = new Node(n.getData(), head);
				head = newNode;
			
			}else {
				Node ref = head;
				for(int i = 0; i <index-1; i++) {
				ref = ref.getNext();
			}
			Node successor = ref.getNext();
			ref.setNext(n);
			n.setNext(successor);
			if(n.getNext() == null) {
				tail = n;
			}
		}
		}
		
	}
	// Remove the next object to be processed from the priority queue.
	public Map.Entry<Character, Integer> dequeue(){
		Map.Entry<Character, Integer> ret = head.getData();
		head = head.getNext();
		sizeOfQueue --;
		return ret;
		
	}
	
	public int size() {
		return sizeOfQueue;
	}
	
	public int getFreq(Map map, char key) {
		return (int) map.get(key);
	}
	public Node peek() {
		return head;
	}



}
