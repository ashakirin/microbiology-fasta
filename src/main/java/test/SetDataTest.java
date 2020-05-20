package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import by.microbiology.genom.SetData;

class SetDataTest {

	private static String lines[];
	private static String locusTag[];
	private static String protein[];
	private static String location[];

	public void setUp() {
		lines = new String[] {
				">lcl|NC_000962.3_cds_NP_214515.1_1 [gene=dnaA] [locus_tag=Rv0001] [db_xref=GeneID:885041] [protein=chromosomal replication initiator protein DnaA] [protein_id=NP_214515.1] [location=1..1524] [gbkey=CDS]",
				">lcl|NC_000962.3_cds_NP_214516.1_2 [gene=dnaN] [locus_tag=Rv0002] [db_xref=GeneID:887092] [protein=DNA polymerase III subunit beta] [protein_id=NP_214516.1] [location=2052..3260] [gbkey=CDS]",
				">lcl|NC_000962.3_cds_NP_214517.1_3 [gene=recF] [locus_tag=Rv0003] [db_xref=GeneID:887089] [protein=DNA replication/repair protein RecF] [protein_id=NP_214517.1] [location=3280..4437] [gbkey=CDS]" };

		locusTag = new String[] { "Rv0001", "Rv0002", "Rv0003" };

		protein = new String[] {
				"chromosomal replication initiator protein DnaA",
				"DNA polymerase III subunit beta",
				"DNA replication/repair protein RecF" };

		location = new String[] {
				"1..1524",
				"2052..3260",
				"3280..4437" };
	}

	@Test
	void testData() {
		setUp();
		
		for(int i=0; i<lines.length; i++) {
			SetData data = new SetData();
			
			data.setLocation(lines[i]);
			data.setLocusTag(lines[i]);
			data.setProtein(lines[i]);
			
			 assertEquals("getLocation() fuer Testfall [" + i + "]: " + lines[i]
                     + " nicht korrekt", location[i],
                     data.getLocation());
             
			 assertEquals("getLocusTag() fuer Testfall [" + i + "]: " + lines[i]
                     + " nicht korrekt", locusTag[i],
                     data.getLocusTag());
             
			 assertEquals("getProtein() fuer Testfall [" + i + "]: " + lines[i]
                     + " nicht korrekt", protein[i], data.getProtein());
		}
	}

}
