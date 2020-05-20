package by.microbiology.genom;

import java.io.FileWriter;
import java.io.PrintWriter;

public class CsvWriter {

	
	public CsvWriter() throws Exception {
		writeCSVHead();
	}
	
	public void writeCSVHead() throws Exception {
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
	
	public void writeCSV(StringBuilder sequence, String locusTag, String protein, String location) throws Exception {
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
}
