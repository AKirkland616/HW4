package edu.wmich.cs3310.hw4Kirkland;

public class HuffmanTree {
	
	Node leftChild;
	Node rightChild;
	Node newParent;
	Node temp;
	
	public void treeCreation(int[] freq, char[] letters) {
		for(int i = freq.length -1;  i >= 0; i --) {
			//This takes the lowest two frequencies and adds them together
			if(i == freq.length -1) {
				leftChild = new Node(letters[i]);
				rightChild = new Node(letters[i-1]);
				newParent = new Node(freq[i]+ freq[i-1],leftChild, rightChild);
				i -= 1;
			}
			else if(freq[i] < newParent.getVal()) {			//Checks if frequency is lower than small tree just created
				temp = newParent;														//Sets a temp node to be able to reach data
				leftChild = new Node(letters[i]);										//Makes the left leaf node a character
				newParent = new Node((freq[i] + temp.getVal()),leftChild, temp);		//Combines the two trees to make a larger one
			}
		}
	}

}
