import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import javax.swing.*;
 
public class Starter {
	
	public static String lyr = "";
	public static String art;
	public static String na;
	
	public static void main(String[] args) throws ParseException, org.json.simple.parser.ParseException {
		
		String name = JOptionPane.showInputDialog("듣고 싶은 곡의 제목을 입력해주세요!");
		String artist = JOptionPane.showInputDialog("아티스트 명을 입력해주세요!");
		art = artist;
		na = name;
		String URL = "https://www.google.com/search?q="+artist+name+"+lyrics";
		Document doc;

		try {
			doc = Jsoup.connect(URL).get();
			doc.select("br").append("\n");
			doc.outputSettings().prettyPrint(false);			
			
			new ImageDownloader().imageDownloader();
			new ShowFrame(doc);
			new ShowImage();
			
			Elements lyrics = doc.select(".ujudUb");
			
			List<String> ly = lyrics.eachText();
			
			int translate = JOptionPane.showConfirmDialog(null, "번역을 실행할까요? (영문 -> 한글)", "Translate", JOptionPane.YES_NO_OPTION);
			
			if (translate == 0) {
				//번역 실행
				for (int i = 0; i < ly.size(); i++) {
					lyr = ly.get(i);
					String transly = TranslateTool.translate();
					JOptionPane.showMessageDialog(null,(ly.get(i)) + "\n" + transly);
				}
			} else if (translate == 1) {
				//번역 미실행
				for (int i = 0; i < ly.size(); i++) {
					JOptionPane.showMessageDialog(null,(ly.get(i)));
				}
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}