import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

public class TextArea extends JTextArea{
	public TextArea(){
		this.setFont(new Font("粗體",Font.PLAIN,20));
		this.setEditable(false);
		this.setForeground(Color.RED);
		this.setOpaque(false);
	}
}
