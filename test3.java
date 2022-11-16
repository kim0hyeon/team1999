import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import javax.swing.*;
import java.awt.*;

public class Test {
	public static void main(String[] args) throws ParseException {
		
		String name = JOptionPane.showInputDialog("듣고 싶은 곡의 제목을 입력해주세요!");
		String URL = "https://www.google.com/search?q="+name+"+lyrics";
		Document doc;

		try {
			doc = Jsoup.connect(URL).get();
			doc.select("br").append("\n");
			doc.outputSettings().prettyPrint(false);
			
			
			Elements lyrics =doc.select(".ujudUb");
			
			List<String> ly = lyrics.eachText();
			
			for (int i = 0; i < ly.size(); i++)
				JOptionPane.showMessageDialog(null,(ly.get(i)));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
