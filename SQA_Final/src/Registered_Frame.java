import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

public class Registered_Frame extends JFrame{
	public Registered_Frame(){
		Frame_Setting();
		this.setVisible(true);
	}
	private void Frame_Setting(){
		this.setTitle("註冊");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(400,800);
		this.setLocation((dimension.width/2)-(this.getWidth()/2), dimension.height/2);
	}
	private void Button_Setting(){
		
	}
	private void Panel_Setting(){
		
	}
	private void TextField_Setting(){
		
	}
	private void TextArea_Setting(){
		
	}
	private void Add_into(){
		
	}
}
