import java.lang.String;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;


public class Test {

    public static void main(String[] args) throws IOException {
        String URL = "https://www.google.com/search?q=blueming+lyrics";
        Document doc = Jsoup.connect(URL).get();

        System.out.println(doc.text());  //text 출력
    }

}
