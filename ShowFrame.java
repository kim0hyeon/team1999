import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import javax.swing.*;
import java.awt.*;

public class ShowFrame extends JFrame{

	Document doc;
	
	public ShowFrame(Document d) {
		
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(2,1));
		
		doc = d;
		Elements information = doc.select(".rVusze");
		
		List<String> inf = information.eachText();
		JLabel l1 = new JLabel(inf.get(0));
		
		JLabel l2 = new JLabel(inf.get(1));
		
		
		cp.add(l2);
		cp.add(l1);
		
		setTitle("Information");
		setVisible(true);
		setSize(200,100);
		setLocation(800,0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}