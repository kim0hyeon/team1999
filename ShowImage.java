import javax.swing.*;

public class ShowImage extends JFrame{
	
	public ShowImage() {
		ImageIcon icon = new ImageIcon("C:\\Users\\kht99\\Desktop\\test\\cover.jpg");
		JLabel imgLabel = new JLabel(icon);
		add(imgLabel);
		
		setTitle("Album cover");
		setSize(600,600);
		setLocation(800,100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
}