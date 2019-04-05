package edu.wmich.cs3310.hw4Kirkland;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Anthony Kirkland & Michael Coffey
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
		
		int oddEven = getInput();
		
		// TODO Auto-generated method stub
		String[] filenames = {"testcase30.txt","testcase60.txt"};
		String[] compFilenames= {"testcase30_compressed.bin", "testcase60_compressed.bin"};
		String[] decompFilenames = {"testcase30_decompressed.txt","testcase60_decompressed.txt"};
		for (int i = 0 ; i < filenames.length;i++) {
			Compressor cp = new Compressor(filenames[i], compFilenames[i] , oddEven);
			decompressor dc = new decompressor(cp.getHuffmanTree(),compFilenames[i], decompFilenames[i]);
			System.out.println("\nResults...\n");
			cp.printFreq();
			cp.printKey();
			long[] time = cp.getTime();
			System.out.println("\nTime: "+time[0]+" ms to find Huffman compression codes for "+filenames[i]+".");
			System.out.println("Time: "+time[1]+" ms to compress "+filenames[i]+".");
			System.out.println("Time: "+dc.getTime()+" ms to decompress " + decompFilenames[i]+".\n\n");
			
		}
	}
	
	/** gets integer key from using. used to determine labeling of right and left child
	 * @return 0 if sum of all digits is even 1 if not
	 * @throws IOException
	 */
	public static int getInput() throws IOException {
		System.out.print("Enter the integer key: ");
		Scanner sc = new Scanner(System.in);
		while (!sc.hasNextInt()) sc.next();
		int key = sc.nextInt();
		int sum = 0; 
        while (key != 0) { 
            sum = sum + key % 10; 
            key = key/10; 
        } 
        int oddEven = sum%2;
		sc.close();
		return oddEven;
	}
}
