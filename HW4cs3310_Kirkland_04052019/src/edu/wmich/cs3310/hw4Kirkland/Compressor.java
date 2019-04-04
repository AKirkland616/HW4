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
	Map<Character, String> key = new HashMap<Character, String>();
	String filename;
	ArrayList<Character> lin = new ArrayList<Character>();
	Huffman h; 
	
	
	public Compressor(String fileName) throws IOException {
		filename = fileName;
		countLetters();
		setPriority();
		h = new Huffman(pq);
		key = h.getEncodeKey();
		createCompressedFile();
		//printFreq();
		//printKey();
		
	}
	
	private void countLetters() throws IOException {
		//System.out.println("counting letters");
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String line = reader.readLine();
		while(line!=null) {
				 for (int i = 0; i < line.length(); i++) {
					 //System.out.println(line.charAt(i));
					 	
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
		reader.close();
	}
	
	private void setPriority() {
		//System.out.println("creating pq");
		for (Map.Entry<Character, Integer> aa : letterFrequency.entrySet()) { 
			HuffmanNode bb = new HuffmanNode(aa.getKey(),aa.getValue());
			pq.enqueue(bb);
            //System.out.println(aa.getKey()+" "+aa.getValue());
        } 
		
	}
	
	
	
	private void createCompressedFile() throws IOException {
		System.out.print("Compressing “myfile.txt” into “myfile_compressed.bin”... ");
		FileOutputStream fos=new FileOutputStream("myTextFile_compressed.bin");
		for(int i = 0; i<lin.size();i++) {
			if(lin.get(i)=='\n') {
				if(i!=lin.size()-1)
				fos.write("\n".getBytes());
			}else {
			byte[] st = key.get(lin.get(i)).toString().getBytes();
			fos.write(st);
			}
		}
		fos.close();
		System.out.println("[Done]");
	}
	
	public void printKey() {
		System.out.println("\nCharacters\tEncodings");
		System.out.println("--------------------------");
		for (Map.Entry<Character, String> aa : key.entrySet()) { 
			//HuffmanNode bb = new HuffmanNode(aa.getKey(),aa.getValue());
			//pq.enqueue(bb);
            System.out.println("\t"+aa.getKey()+"\t"+aa.getValue());
        } 
	}
	public void printFreq() {
		System.out.println("Characters\tFrequency");
		System.out.println("--------------------------");
		for (Map.Entry<Character, Integer> aa : letterFrequency.entrySet()) { 
			System.out.println("\t"+aa.getKey()+"\t"+aa.getValue());
        } 
		
		System.out.println("\nTotal Characters: " + letterFrequency.size());
	}
	
	public Huffman getHuffmanTree() {
		return h;
	}

}
