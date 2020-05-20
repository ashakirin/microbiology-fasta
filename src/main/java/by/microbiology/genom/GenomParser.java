package by.microbiology.genom;

import java.io.*;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenomParser {
//	private static Logger LOGGER = LoggerFactory.getLogger(GenomParser.class);
	private static String line;
	public String path;
	
	public GenomParser(String[] args) {
		try {
			readAndSet(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readAndSet(String[] args) throws Exception {
		boolean first = true;
		CsvWriter csv = new CsvWriter();

		SetData dat = new SetData();

		try (Scanner sc = new Scanner(new File(args[0]))) {
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				if (line.charAt(0) != '>') {
					dat.setSequence(line);
				} else {
					if (!first) {
						csv.writeCSV(dat.getSequence(), dat.getLocusTag(), dat.getProtein(), dat.getLocation());
					}
					first = false;
					dat.resetSequence();
					dat.setLocusTag(line);
					dat.setProtein(line);
					dat.setLocation(line);
				}
			}
			dat.setSequence(line);
			csv.writeCSV(dat.getSequence(), dat.getLocusTag(), dat.getProtein(), dat.getLocation());
		}
	}
}
