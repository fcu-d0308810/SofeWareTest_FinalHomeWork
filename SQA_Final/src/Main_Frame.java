import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main_Frame extends JFrame{
	public Main_Frame(){
		Frame_Setting();
		this.setVisible(true);
	}
	private void Frame_Setting(){
		this.setTitle("主畫面");
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(800,800);
		this.setLocation((dimension.width/2)-(this.getWidth()/2), dimension.height/2);
		this.setLocationRelativeTo(null);
		this.setResizable(false);	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
}
