package edu.wmich.cs3310.hw4Kirkland;


/**
 * @author Anthony Kirkland and Michael Coffey
 *
 */
public class PriorityQueue {
	private Node head;
	private Node tail;
	private int sizeOfQueue = 0;
	
	
	
	/** Determine if the priority queue is empty.
	 * @return true if empty false if else
	 */
	public boolean isEmpty() {
		return (head==null);
	}
	
	
	/** Add object received to the priority queue taking into consideration the rules governing priority.
	 * @param data huffman node
	 */
	public void enqueue(HuffmanNode data) {
		Node n = new Node(data);
		sizeOfQueue++;
		if(isEmpty()) {
			head =n;
			tail =head;
		}else {
			
			Node headcopy = head;
			int index = 0;
			while(headcopy != null) {
				if(( n.getValue() < headcopy.getValue())|| n.getValue()==headcopy.getValue()) {
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
	
	
	/** Remove the next object to be processed from the priority queue.
	 * @return huffman node
	 */
	public HuffmanNode dequeue(){
		HuffmanNode ret = head.getData();
		head = head.getNext();
		sizeOfQueue --;
		return ret;
		
	}
	
	/**gets size of queue
	 * @return size
	 */
	public int size() {
		return sizeOfQueue;
	}
	



}
