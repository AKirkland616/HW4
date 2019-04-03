package edu.wmich.cs3310.hw4Kirkland;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Compressor {
	PriorityQueue pq = new PriorityQueue();
	Map<Character, Integer> letterFrequency = new HashMap<Character, Integer>();
	Map<Character, Integer> key = new HashMap<Character, Integer>();
	Map<Integer, Character> passedKey = new HashMap<Integer,Character >();
	String filename;
	ArrayList<Character> lin = new ArrayList<Character>();
	//int numlines=0;
	
	//Huffman Tree variables
	Node leftChild;
	Node rightChild;
	Node parent;
	
	
	public Compressor(String fileName) throws IOException {
		filename = fileName;
		countLetters();
		setPriority();
		createKey();
		createCompressedFile();
		
	}
	
	private void countLetters() throws IOException {
		System.out.println("counting letters");
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String line = reader.readLine();
		while(line!=null) {
				 for (int i = 0; i < line.length(); i++) {
					 System.out.println(line.charAt(i));
					 	
			            char c = line.charAt(i);
			            lin.add(c);
			            if (letterFrequency.containsKey(c)) {
			                int frequency = letterFrequency.get(c);
			                letterFrequency.put(c, ++frequency);
			            } else
			                letterFrequency.put(c, 1);
			            
			            if(i==line.length()-1) {
			            	lin.add('\n');
			            }
			            
			            
			        }
				 
				 
					line=reader.readLine();
			
			//numlines++;
		}
	}
	
	private void setPriority() {
		System.out.println("creating pq");
		for (Map.Entry<Character, Integer> aa : letterFrequency.entrySet()) { 
			pq.enqueue(aa);
            System.out.println(aa.getKey()+" "+aa.getValue());
        } 
		
	}
	
	private void createKey() {
		System.out.println("creating key");
		int i = 0;
		
		while(!pq.isEmpty()) {
			Map.Entry<Character, Integer> d = pq.dequeue();
			System.out.println(d.getKey()+" "+d.getValue());
			key.put(d.getKey(),Integer.parseInt(Integer.toBinaryString(i)));
			passedKey.put(Integer.parseInt(Integer.toBinaryString(i)), d.getKey());
			i++;
		}
		for (Map.Entry<Character, Integer> aa : key.entrySet()) {
            System.out.println(aa.getKey()+" "+aa.getValue());
        } 
	}
	
	public Map<Integer, Character> getKeyToDecomp(){
		return passedKey;
	}
	
	private void createCompressedFile() throws IOException {
		FileOutputStream fos=new FileOutputStream("myTextFile_compressed.bin");
		for(int i = 0; i<lin.size();i++) {
			if(lin.get(i)=='\n') {
				if(i!=lin.size()-1)
				fos.write("\n".getBytes());
			}else {
			byte[] st = key.get(lin.get(i)).toString().getBytes();
			fos.write(st);
			char s = '\n';
			}
		}
		
	}
	
	public void createHuffmanTree() {
		PriorityQueue freq = new PriorityQueue();
		
		for(Map.Entry<Character, Integer> entry : key.entrySet()) {
			freq.enqueue(new Node(entry.getKey(),entry.getValue()));
		}
		
		while(pq.size() > 1) {
			leftChild = freq.peek();
			freq.dequeue();
			rightChild = freq.peek();
			freq.dequeue();
			
			parent = new Node(leftChild.getVal() + rightChild.getVal(),leftChild,rightChild);
			
		}
	}

}
