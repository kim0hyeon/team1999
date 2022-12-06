import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
 
public class ImageDownloader {
	
	public static void imageDownloader() throws ParseException {
		
		String URL = "https://www.genie.co.kr/search/searchMain?query="+Starter.art+" "+Starter.na;
		Document doc;
		
		try {
			doc = Jsoup.connect(URL).get();
			
			Element img = doc.selectFirst(".cover");
			String src = img.toString();
			
			String[] results = src.split("<");
			String li = results[4];
			String[] fin = li.split("\"");
			String imglink = fin[1];
			
			String link = "http:" + imglink;
            
            URL imgUrl = new URL(link);
            BufferedImage jpg = ImageIO.read(imgUrl);
            File file = new File("C:\\Users\\kht99\\Desktop\\test\\cover.jpg");
            ImageIO.write(jpg, "jpg", file);
			
		} catch (MalformedURLException e) {
            e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}