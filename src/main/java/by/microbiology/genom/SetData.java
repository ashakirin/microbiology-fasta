package by.microbiology.genom;

public class SetData {

	private StringBuilder sequence = new StringBuilder();
	private String location = "";
	private String protein = "";
	private String locusTag = "";
	
	public SetData() {
		
	}
	
	public void setLocusTag(String line) {
		if (line.contains("locus_tag")) {
			locusTag = line.substring(line.indexOf("locus_tag=") + 10);
			locusTag = locusTag.substring(0, locusTag.indexOf("]"));
		}
	}

	public void setProtein(String line) {
		protein = line.substring(line.indexOf("protein=") + 8);
		protein = protein.substring(0, protein.indexOf("] "));
	}

	public void setLocation(String line) {
		location = line.substring(line.indexOf("location=") + 9);
		location = location.substring(0, location.indexOf("] "));
	}
	
	public void setSequence(String line) throws Exception {
		sequence.append(line);
	}
	
	public void resetSequence() {
		sequence = new StringBuilder();
	}
	
	public String getLocusTag() {
		return locusTag;
	}
	
	public String getProtein() {
		return protein;
	}
	
	public String getLocation() {
		return location;
	}
	
	public StringBuilder getSequence() {
		return sequence;
	}
}
