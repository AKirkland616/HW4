package edu.wmich.cs3310.hw4Kirkland;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Anthony Kirkland & Michael Coffey
 *
 */
public class decompressor {
	Map<String, Character> key = new HashMap<String, Character>();
	long time;
	String compFile;
	String decompFile;

	/** constructor for Decompressor class
	 * @param ke huffman tree aka key
	 * @param file compressed file to be decompressed
	 * @param where where to write decompression of compressed file
	 * @throws IOException
	 */
	public decompressor(Huffman ke, String file, String where) throws IOException {
		key= ke.getDecodeKey();
		compFile = file;
		decompFile = where;
		decomp();
	}
	
	/** reads compressed file "bit by bit" decodes and writes
	 * @throws IOException
	 */
	private void decomp() throws IOException {
		System.out.print("Decompressing " + compFile + " into " + decompFile + "... ");
		long start = System.currentTimeMillis();
		BufferedReader reader = new BufferedReader(new FileReader(compFile));
		FileOutputStream fos=new FileOutputStream(decompFile);
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
		long end = System.currentTimeMillis();
		time = end-start;
		System.out.println("[Done]");
	}
	
	/** get method for time taken
	 * @return time taken
	 */
	public long getTime() {
		return time;
	}
}
