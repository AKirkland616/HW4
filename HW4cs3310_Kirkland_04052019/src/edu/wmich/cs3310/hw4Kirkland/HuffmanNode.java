package edu.wmich.cs3310.hw4Kirkland;


/**
 * @author Anthony Kirkland & Michael Coffey
 *
 */
public class HuffmanNode {
	private char ch;
    private int freq;
    private HuffmanNode left, right;
	
    /**
     * empty constructor
     */
    public HuffmanNode() {
    	ch    = '\0';
        freq  = 0;
        left  = null;
        right = null;
    }
    
    /**constructor that initalizes character and frequency
     * @param cht character
     * @param freqt frequency
     */
    public HuffmanNode(char cht, int freqt) {
    	ch    = cht;
        freq  = freqt;
        left  = null;
        right = null;
    }
	
	/** getter for character
	 * @return character
	 */
	public char getChar() {
		return ch;
	}
	
	/** getter for frequency
	 * @return frequency
	 */
	public int getFreq() {
		return freq;
	}
	
	/**getter for left child
	 * @return left child
	 */
	public HuffmanNode getLeft() {
		return left;
	}
	
	/**getter for right child
	 * @return right child
	 */
	public HuffmanNode getRight() {
		return right;
	}
	
	/**setter for frequency
	 * @param fr frquency
	 */
	public void setFreq(int fr) {
		freq = fr;
	}
	/**setter for character
	 * @param chara character
	 */
	public void setChar(char chara) {
		ch = chara;
	}
	
	/**setter for left child
	 * @param l left child
	 */
	public void setLeft(HuffmanNode l) {
		left = l;
	}
	
	/**setter for right child
	 * @param r right child
	 */
	public void setRight(HuffmanNode r) {
		right = r;
	}
	
		 
}
