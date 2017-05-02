import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class Registered_Frame extends JFrame implements ActionListener{
	TextField account_textfield, name_textfield;
	PasswordField password_textfield, check_password_textfield;
	Button send_button, cancel_button;
	TextArea console_textarea;
	Panel send_panel, cancel_panel, account_panel, password_panel, check_password_panel, name_panel, console_panel;
	Panel not_robot_panel;
	JCheckBox not_robot_checkbox;
	Border default_border;
	public Registered_Frame(){
		Frame_Setting();
		Button_Setting();
		TextField_Setting();
		TextArea_Setting();
		Check_Box();
		Panel_Setting();
		Add_into();
		this.setVisible(true);
	}
	private void Frame_Setting(){
		this.setTitle("註 冊");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(400,800);
		this.setLocation((dimension.width/2)-(this.getWidth()/2), dimension.height/2);
		this.setLayout(new GridLayout(8,1));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	private void Button_Setting(){
		send_button = new Button("確 定");
		send_button.setActionCommand("Send");
		send_button.addActionListener(this);
		cancel_button = new Button("取 消");
		cancel_button.setActionCommand("Cancel");
		cancel_button.addActionListener(this);
	}
	private void Check_Box(){
		not_robot_checkbox = new JCheckBox();
		not_robot_checkbox.setText("我 不 是 機 器 人");
		not_robot_checkbox.setSelected(false);
		not_robot_checkbox.setFont(new Font("粗體",Font.PLAIN,20));
	}
	private void Panel_Setting(){
		send_panel = new Panel(send_button);
		cancel_panel = new Panel(cancel_button);
		account_panel = new Panel(account_textfield, "帳 號：");
		password_panel = new Panel(password_textfield, "密 碼：");
		check_password_panel = new Panel(check_password_textfield, "確認密碼：");
		name_panel = new Panel(name_textfield,"暱 稱：");
		console_panel = new Panel(console_textarea);
		not_robot_panel = new Panel(not_robot_checkbox);
	}
	private void TextField_Setting(){
		account_textfield = new TextField();
		password_textfield = new PasswordField();
		check_password_textfield = new PasswordField();
		name_textfield = new TextField();
		default_border = account_textfield.getBorder();
	}
	private void TextArea_Setting(){
		console_textarea = new TextArea();
	}
	private void Add_into(){
		this.add(account_panel);
		this.add(password_panel);
		this.add(check_password_panel);
		this.add(name_panel);
		this.add(not_robot_checkbox);
		this.add(console_panel);
		this.add(send_panel);
		this.add(cancel_panel);
	}
	private void Error_Account_Change(){
		account_textfield.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		password_textfield.setBorder(default_border);
		check_password_textfield.setBorder(default_border);
		name_textfield.setBorder(default_border);
	}
	private void Error_Password_Change(){
		account_textfield.setBorder(default_border);
		password_textfield.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		check_password_textfield.setBorder(default_border);
		name_textfield.setBorder(default_border);
	}
	private void Error_Check_Password_Change(){
		account_textfield.setBorder(default_border);
		password_textfield.setBorder(default_border);
		check_password_textfield.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		name_textfield.setBorder(default_border);
	}
	private void Error_Name_Change(){
		account_textfield.setBorder(default_border);
		password_textfield.setBorder(default_border);
		check_password_textfield.setBorder(default_border);
		name_textfield.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		DataBase database;
		if(command.equals("Send")){
			if(not_robot_checkbox.isSelected()){
				if(!account_textfield.getText().isEmpty()){
					if(!password_textfield.getText().isEmpty()){
						if(password_textfield.getText().equals(check_password_textfield.getText())){
							database = new DataBase();
							String message = database.Check(account_textfield.getText(), password_textfield.getText());
							if(message.equals("Your account isn't exist!")){
								if(!name_textfield.getText().isEmpty()){
									database.Registered(account_textfield.getText(), password_textfield.getText(), name_textfield.getText());
									Login_Frame login_frame =  new Login_Frame(account_textfield.getText());
									this.dispose();
								}
								else{
									console_textarea.setText("Your name is empty!");
									Error_Name_Change();
									name_textfield.selectAll();
								}
							}
							else{
								console_textarea.setText("This account is already exist!");
								Error_Account_Change();
								account_textfield.selectAll();
							}
						}
						else{
							console_textarea.setText("Your two password are not same!");
							Error_Check_Password_Change();
							check_password_textfield.selectAll();
						}
					}
					else{
						console_textarea.setText("Your password is empty!");
						Error_Password_Change();
						password_textfield.selectAll();
					}
				}
				else{
					console_textarea.setText("Your account is empty!");
					Error_Account_Change();
					account_textfield.selectAll();
				}
			}
			else{
				console_textarea.setText("Please click you are not robot!");
				
			}
		}
		else if(command.equals("Cancel")){
			Login_Frame login_frame = new Login_Frame();
			this.dispose();
		}
		else{
			
		}
	}
}
