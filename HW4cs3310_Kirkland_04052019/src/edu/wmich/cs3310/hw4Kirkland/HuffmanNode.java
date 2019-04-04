package edu.wmich.cs3310.hw4Kirkland;


public class HuffmanNode {
	
	//For Huffman Tree
	/**
		int val;
		char letter;
		Node lChild;
		Node rChild;
		Node parent;
		**/
		 private char ch;
	     private int freq;
	     private HuffmanNode left, right;
		/**
		public HuffmanNode(int dataVal, Node left, Node right) {
			val = dataVal;
			lChild = left;
			rChild = right;
		}
		**/
	    public HuffmanNode() {
	    	ch    = '\0';
            freq  = 0;
            left  = null;
            right = null;
	    }
	    
	    public HuffmanNode(char cht, int freqt) {
	    	ch    = cht;
            freq  = freqt;
            left  = null;
            right = null;
	    }
	    
		public HuffmanNode (char cht, int freqt, HuffmanNode leftt, HuffmanNode rightt) {
            ch    = cht;
            freq  = freqt;
            left  = leftt;
            right = rightt;
        }
		
		public char getChar() {
			return ch;
		}
		
		public int getFreq() {
			return freq;
		}
		
		public HuffmanNode getLeft() {
			return left;
		}
		
		public HuffmanNode getRight() {
			return right;
		}
		
		public void setFreq(int fr) {
			freq = fr;
		}
		public void setChar(char chara) {
			ch = chara;
		}
		
		public void setLeft(HuffmanNode l) {
			left = l;
		}
		
		public void setRight(HuffmanNode r) {
			right = r;
		}
		
		
		/**
		public HuffmanNode(char character, int frequency) {
			val = frequency;
			letter = character;
			lChild = null;
			rChild = null;
		}
		
		public char getChar() {
			return letter;
		}
		public int getFreq() {
			return val;
		}
		
		public Node leftChild() {
			return lChild;
		}
		
		public Node rightChild() {
			return rChild;
		}
		
		
		//End of Huffman Tree
		  **/
		 
}
