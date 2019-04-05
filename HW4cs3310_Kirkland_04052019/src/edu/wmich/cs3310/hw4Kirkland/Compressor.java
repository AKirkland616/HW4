package edu.wmich.cs3310.hw4Kirkland;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Anthony Kirkland & Michael Coffey
 *
 */
public class Compressor {
	PriorityQueue pq = new PriorityQueue();
	Map<Character, Integer> letterFrequency = new HashMap<Character, Integer>();
	Map<Character, String> key = new HashMap<Character, String>();
	String filename;
	String compFileName;
	ArrayList<Character> lin = new ArrayList<Character>();
	Huffman h; 
	long[] time = new long[2];
	
	
	/** constructor for compressor class
	 * @param fileName file to be read from
	 * @param compfile what to name the compressed file
	 * @param oddeven what to label right and left child nodes
	 * @throws IOException
	 */
	public Compressor(String fileName, String compfile, int oddeven) throws IOException {
		filename = fileName;
		compFileName = compfile;
		countLetters();
		setPriority();
		long start = System.currentTimeMillis();
		h = new Huffman(pq,oddeven);
		key = h.getEncodeKey();
		long end = System.currentTimeMillis();
		time[0]= end-start;
		createCompressedFile();
		//printFreq();
		//printKey();
		
	}
	
	/** add the frequency of letters and places/ replaces them in hash map
	 * @throws IOException
	 */
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
	
	/**
	 * puts all letters in hash map to priority queue where lowest frequencies are dequeued first
	 */
	private void setPriority() {
		//System.out.println("creating pq");
		for (Map.Entry<Character, Integer> aa : letterFrequency.entrySet()) { 
			HuffmanNode bb = new HuffmanNode(aa.getKey(),aa.getValue());
			pq.enqueue(bb);
            //System.out.println(aa.getKey()+" "+aa.getValue());
        } 
		
	}
	
	
	
	/** creates compressed file using encoding from huffman tree
	 * @throws IOException
	 */
	private void createCompressedFile() throws IOException {
		System.out.print("Compressing " + filename + " into " + compFileName + "... ");
		long start = System.currentTimeMillis();
		FileOutputStream fos=new FileOutputStream(compFileName);
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
		long end = System.currentTimeMillis();
		time[1] = end - start;
		System.out.println("[Done]");
	}
	
	/**
	 * prints corresponding letters and encodings
	 */
	public void printKey() {
		System.out.println("\nCharacters\tEncodings");
		System.out.println("--------------------------");
		for (Map.Entry<Character, String> aa : key.entrySet()) { 
			//HuffmanNode bb = new HuffmanNode(aa.getKey(),aa.getValue());
			//pq.enqueue(bb);
            System.out.println("\t"+aa.getKey()+"\t"+aa.getValue());
        } 
	}
	
	
	/**
	 * prints corresponding letters and frequencies
	 */
	public void printFreq() {
		System.out.println("Characters\tFrequency");
		System.out.println("--------------------------");
		for (Map.Entry<Character, Integer> aa : letterFrequency.entrySet()) { 
			System.out.println("\t"+aa.getKey()+"\t"+aa.getValue());
        } 
		
		System.out.println("\nTotal Unique Characters: " + letterFrequency.size());
	}
	
	/**get method for huffman tree
	 * @return huffman tree
	 */
	public Huffman getHuffmanTree() {
		return h;
	}
	
	/** get method for times taken
	 * @return times taken
	 */
	public long[] getTime() {
		return time;
	}

}
