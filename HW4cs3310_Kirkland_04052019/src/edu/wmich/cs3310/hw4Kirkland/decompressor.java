package edu.wmich.cs3310.hw4Kirkland;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class decompressor {
	Map<Integer, Character> key = new HashMap<Integer, Character>();

	public decompressor(Map<Integer, Character> ke) throws IOException {
		key= ke;
		decomp();
	}
	
	public void decomp() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("myTextFile_compressed.bin"));
		FileOutputStream fos=new FileOutputStream("myTextFile_decompressed.bin");
		String line = reader.readLine();
		while(line!=null) {
			String letCode = "";
			for (int i = 0; i < line.length(); i++) {
				letCode+=line.charAt(i);
				System.out.print(letCode);
				if(key.containsKey(Integer.parseInt(letCode))) {
					char s = key.get(letCode);
					fos.write(s);
					letCode="";
				}
			}
			fos.write("\n".getBytes());
		}
	}
}
