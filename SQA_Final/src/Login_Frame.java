import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.*;
	
public class Login_Frame extends JFrame{
	Button login_button, registered_button, forget_password_button;
	Panel login_panel, registered_panel, forget_password_panel, account_input_panel, password_input_panel;
	TextField account_input_textfield, password_input_textfield;
	JPanel space = new JPanel();
	public Login_Frame(){
		Frame_Setting();
		Button_Setting();
		TextField_Setting();
		Panel_Setting();
		Add_into();
		this.setVisible(true);
	}
	private void Frame_Setting(){
		this.setTitle("登入");
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(400,800);
		this.setLocation((dimension.width/2)-(this.getWidth()/2), dimension.height/2);
		this.setLocationRelativeTo(null);
		this.setResizable(false);	
		this.setLayout(new GridLayout(8,1));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	private void Button_Setting(){
		login_button = new Button("登 入");
		registered_button = new Button("註 冊");
		forget_password_button = new Button("忘 記 密 碼");
	}
	private void Panel_Setting(){
		login_panel = new Panel(login_button);
		registered_panel = new Panel(registered_button);
		forget_password_panel = new Panel(forget_password_button);
		account_input_panel = new Panel(account_input_textfield, "帳號：");
		password_input_panel = new Panel(password_input_textfield, "密碼：");
	}
	private void TextField_Setting(){
		account_input_textfield = new TextField();
		password_input_textfield = new TextField();
	}
	private void Add_into(){
		this.add(space);
		this.add(account_input_panel);
		this.add(password_input_panel);
		this.add(login_panel);
		this.add(registered_panel);
		this.add(forget_password_panel);
		
	}
}
