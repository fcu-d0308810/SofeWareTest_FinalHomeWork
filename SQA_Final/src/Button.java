import java.awt.Font;

import javax.swing.JButton;

public class Button extends JButton{
	
	public Button(String title){
		this.setText(title);
		this.setFont(new Font("粗體",Font.PLAIN,20));
		
	}
}
