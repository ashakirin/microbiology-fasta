package by.microbiology.genom;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class GenomParser {
    private static Logger LOGGER = LoggerFactory.getLogger(GenomParser.class);

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://www.ncbi.nlm.nih.gov/portal/loader/pload.cgi?curl=http%3A%2F%2Fwww.ncbi.nlm.nih.gov%2Fsviewer%2Fviewer.cgi%3Fid%3D448814763%26db%3Dnuccore%26report%3Dfasta%26retmode%3Dtext%26withmarkup%3Don%26tool%3Dportal%26log%24%3Dseqview%26from%3D4352609%26to%3D4352896&pid=0").get();
            LOGGER.info(doc.title());
            Elements newsHeadlines = doc.select("#mp-itn b a");
            LOGGER.info(doc.html());
            for (Element headline : newsHeadlines) {
                LOGGER.info("%s\n\t%s",
                        headline.attr("title"), headline.absUrl("href"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
