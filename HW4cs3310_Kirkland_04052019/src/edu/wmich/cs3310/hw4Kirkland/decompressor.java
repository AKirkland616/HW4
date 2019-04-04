package edu.wmich.cs3310.hw4Kirkland;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class decompressor {
	Map<String, Character> key = new HashMap<String, Character>();

	public decompressor(Huffman ke) throws IOException {
		key= ke.getDecodeKey();
		decomp();
	}
	
	private void decomp() throws IOException {
		System.out.print("Decompressing “myfile_compressed.bin” into “myfile_decompressed.txt”... ");
		BufferedReader reader = new BufferedReader(new FileReader("myTextFile_compressed.bin"));
		FileOutputStream fos=new FileOutputStream("myTextFile_decompressed.txt");
		String line = reader.readLine();
		while(line!=null) {
			String letCode = "";
			for (int i = 0; i < line.length(); i++) {
				letCode+=line.charAt(i);
				//System.out.print(letCode);
				if(key.containsKey(letCode)) {
					char s = key.get(letCode);
					fos.write(s);
					letCode="";
				}
			}
			line = reader.readLine();
			if(line!=null)
			fos.write("\n".getBytes());
		}
		fos.close();
		reader.close();
		System.out.println("[Done]");
	}
}
