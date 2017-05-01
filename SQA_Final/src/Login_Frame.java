import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
	
public class Login_Frame extends JFrame implements ActionListener{
	Button login_button, registered_button, forget_password_button;
	Panel login_panel, registered_panel, forget_password_panel, account_input_panel, password_input_panel, console_panel;
	TextField account_input_textfield, password_input_textfield;
	TextArea console_textarea;
	JPanel space = new JPanel();
	boolean isFirstTime = true;
	public Login_Frame(){
		Frame_Setting();
		Button_Setting();
		TextField_Setting();
		TextArea_Setting();
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
		login_button.setActionCommand("Login");
		login_button.addActionListener(this);
		registered_button = new Button("註 冊");
		registered_button.setActionCommand("Registered");
		registered_button.addActionListener(this);
		forget_password_button = new Button("忘 記 密 碼");
		forget_password_button.setActionCommand("forget");
		forget_password_button.addActionListener(this);
	}
	private void Panel_Setting(){
		login_panel = new Panel(login_button);
		registered_panel = new Panel(registered_button);
		forget_password_panel = new Panel(forget_password_button);
		account_input_panel = new Panel(account_input_textfield, "帳號：");
		password_input_panel = new Panel(password_input_textfield, "密碼：");
		console_panel = new Panel(console_textarea);
	}
	private void TextField_Setting(){
		account_input_textfield = new TextField();
		password_input_textfield = new TextField();
	}
	private void TextArea_Setting(){
		console_textarea = new TextArea();
	}
	private void Add_into(){
		this.add(space);
		this.add(account_input_panel);
		this.add(password_input_panel);
		this.add(console_panel);
		this.add(login_panel);
		this.add(registered_panel);
		this.add(forget_password_panel);
		
	}
	public void Lock_Button(){
		login_button.setEnabled(false);
		registered_button.setEnabled(false);
		forget_password_button.setEnabled(false);
	}
	public void Unlock_Button(){
		login_button.setEnabled(true);
		registered_button.setEnabled(true);
		forget_password_button.setEnabled(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		String message;
		DataBase database = new DataBase();
		if(command.equals("Login")){
			Lock_Button();
			message = database.Check(account_input_textfield.getText(), password_input_textfield.getText());
			if(message.equals("")){
				Main_Frame main_frame = new Main_Frame();
				this.dispose();
				
			}
			else{
				console_textarea.setText(message);
			}
			Unlock_Button();
		}
		else if(command.equals("Registered")){
			this.setVisible(false);
			Registered_Frame registered_Frame = new Registered_Frame();
			this.setVisible(true);
		}
		else if(command.equals("forget")){
			isFirstTime = false;
		}
		else{
			
		}		
	}
}
