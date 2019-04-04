package edu.wmich.cs3310.hw4Kirkland;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		System.out.println("============");
		System.out.println("Huffman Code");
		System.out.println("============");
		// TODO Auto-generated method stub
		String[] filenames = {"myTextFile.txt"};
		for (int i = 0 ; i < filenames.length;i++) {
			Compressor cp = new Compressor(filenames[i]);
			decompressor dc = new decompressor(cp.getHuffmanTree());
			System.out.println("\nResults...\n");
			cp.printFreq();
			cp.printKey();
			
		}

		//FileInputStream input = new FileInputStream("myTextFile.txt"); 
		
		//FileOutputStream fos=new FileOutputStream("myTextFile_compressed.bin");
		
		
		
	}

}
