package edu.wmich.cs3310.hw4Kirkland;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Anthony Kirkland and Michael Coffey
 *
 */
public class Main {

	/** main method. the driver for all code.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		System.out.println("============");
		System.out.println("Huffman Code");
		System.out.println("============");
		
		
		// TODO Auto-generated method stub
		String[] filenames = {"myfile.txt"};
		String[] compFilenames= {"myfile_compressed.bin"};
		String[] decompFilenames = {"myfile_decompressed.txt"};
		for (int i = 0 ; i < filenames.length;i++) {
			int oddEven = getInput();
			Compressor cp = new Compressor(filenames[i], compFilenames[i] , oddEven);
			Decompressor dc = new Decompressor(cp.getHuffmanTree(),compFilenames[i], decompFilenames[i]);
			System.out.println("\nResults...\n");
			cp.printFreq();
			cp.printKey();
			long[] time = cp.getTime();
			System.out.println("\nTime: "+time[0]+" ms to find Huffman compression codes for "+filenames[i]+".");
			System.out.println("Time: "+time[1]+" ms to compress "+filenames[i]+".");
			System.out.println("Time: "+dc.getTime()+" ms to decompress " + decompFilenames[i]+".\n\n");
			
		}
	}
	
	/** 
	 *randomly fills text file with characters and gets integer key from using. used to determine labeling of right and left child
	 * @return 0 if sum of all digits is even 1 if not
	 * @throws IOException
	 */
	public static int getInput() throws IOException{
		
		System.out.print("Enter the number of characters: ");
		Scanner sc = new Scanner(System.in);
		while (!sc.hasNextInt()) sc.next();
		int numOfChar = sc.nextInt();
		FileOutputStream fos =new FileOutputStream("myfile.txt");
		Random rand = new Random();
		
		System.out.print("Enter the integer key: ");
		while (!sc.hasNextInt()) sc.next();
		int key = sc.nextInt();
		
		System.out.print("Writing to file... ");
		for(int i = 0; i<numOfChar;i++) {
			fos.write((char)(rand.nextInt(127-32)+32));
		}
		System.out.println("[Done]");
		
		int sum = 0; 
        while (key != 0) { 
            sum = sum + key % 10; 
            key = key/10; 
        } 
        int oddEven = sum%2;
        fos.close();
		sc.close();
		return oddEven;
	}
	
}
