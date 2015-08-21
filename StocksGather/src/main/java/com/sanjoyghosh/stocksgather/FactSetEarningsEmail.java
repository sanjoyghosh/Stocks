package com.sanjoyghosh.stocksgather;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.LineNumberReader;

public class FactSetEarningsEmail {

	public static void processFactSetEarningsEmail() {
		File factSetFolder = new File("/Users/sanjoyghosh/Downloads/FactSetEarningsEmail");
		File[] factSetFiles = factSetFolder.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.startsWith("FactSet StreetAccount Summary - Week Ahead") && name.endsWith(".txt");
			}
		});
		
		for (File factSetFile : factSetFiles) {
			try {
				processFactSetFile(factSetFile);
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private static void processFactSetFile(File factSetFile) throws IOException {
		LineNumberReader reader = null;
		try {
			reader = new LineNumberReader(new FileReader(factSetFile));
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		}
		finally {
			if (reader != null) {
				reader.close();
			}
		}
	}
}
