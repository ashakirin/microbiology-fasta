package by.microbiology.genom;

import java.io.*;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GenomParser {
	private static Logger LOGGER = LoggerFactory.getLogger(GenomParser.class);
	private static String location = "";
	private static String protein = "";
	private static StringBuilder sequence = new StringBuilder();
	private static String locusTag = "";
	private static String line;

	public static void writeCSV() throws Exception {
		FileWriter fileWriter = new FileWriter("microbiology.csv", true);
		try (PrintWriter writer = new PrintWriter(fileWriter)) {

			StringBuilder sb = new StringBuilder();
			sb.append(sequence);
			sb.append(';');
			sb.append(locusTag + "  PROTEIN: " + protein + "  LOCATION: " + location);
			sb.append('\n');

			writer.write(sb.toString());
		}
	}

	public static void writeCSVHead() throws Exception {
		FileWriter fileWriter = new FileWriter("microbiology.csv", true);
		try (PrintWriter writer = new PrintWriter(fileWriter)) {

			StringBuilder sb = new StringBuilder();
			sb.append("sequence");
			sb.append(';');
			sb.append("locus_tag");
			sb.append('\n');

			writer.write(sb.toString());
		}
	}

	public static void setSequence(String line) throws Exception {
		sequence.append(line);
	}

	public static void setLocusTag(String line) {
		if (line.contains("locus_tag")) {
			locusTag = line.substring(line.indexOf("locus_tag=") + 10);
			locusTag = locusTag.substring(0, locusTag.indexOf("]"));
		}
	}

	public static void setProtein(String line) {
		protein = line.substring(line.indexOf("protein=") + 8);
		protein = protein.substring(0, protein.indexOf("] "));
	}

	public static void setLocation(String line) {
		location = line.substring(line.indexOf("location=") + 9);
		location = location.substring(0, location.indexOf("] "));
	}

	public static void main(String[] args) throws Exception {
		boolean first = true;
		writeCSVHead();
		Scanner pathScanner = new Scanner(System.in);
		System.out.print("Please insert the fna path: ");
		String path = pathScanner.next();

		try (Scanner sc = new Scanner(new File(path))) {
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				if (line.charAt(0) != '>') {
					setSequence(line);
				} else {
					if (!first) {
						writeCSV();
					}
					first = false;
					sequence = new StringBuilder();
					setLocusTag(line);
					setProtein(line);
					setLocation(line);
				}
			}
			setSequence(line);
			writeCSV();
		}
		pathScanner.close();
		System.out.println("Done!");
	}
}
