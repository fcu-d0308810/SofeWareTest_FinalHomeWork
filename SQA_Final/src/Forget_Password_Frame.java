import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class Forget_Password_Frame extends JFrame implements ActionListener{
	UtilDateModel model;
	JDatePanelImpl datePanel;
	JDatePickerImpl datePicker;
	Button send_button, cancel_button;
	Panel send_panel, cancel_panel, console_panel;
	TextArea console_textarea;
	private JPanel panel = new JPanel(new GridLayout(0, 1));
	public Forget_Password_Frame(){
		Frame_Setting();
		DatePicker();
		Button_Setting();
		TextArea_Setting();
		Panel_Setting();
		Add_into();
		this.setVisible(true);
	}
	private void Frame_Setting(){
		this.setTitle("忘 記 密 碼");
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(400,400);
		this.setLocation((dimension.width/2)-(this.getWidth()/2), dimension.height/2);
		this.setLocationRelativeTo(null);
		this.setResizable(false);	
		this.setLayout(new GridLayout(4,1));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	private void DatePicker(){
		Properties p = new Properties();
        p.put("text.today", "Today");
		panel.add(new JLabel("     生 日："));
		UtilDateModel model = new UtilDateModel();
		model.setDate(1990, 8, 24);
		model.setSelected(true);
		//Date selectedDate = (Date) datePicker.getModel().getValue();
		//Calendar selectedValue = (Calendar) datePicker.getModel().getValue();
		//Date selectedDate = selectedValue.getTime();
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		//JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		panel.add(datePicker);
	}
	private void TextArea_Setting(){
		console_textarea = new TextArea();
	}
	private void Panel_Setting(){
		send_panel = new Panel(send_button);
		cancel_panel = new Panel(cancel_button);
		console_panel = new Panel(console_textarea);
	}
	private void Button_Setting(){
		send_button = new Button("確 認");
		send_button.setActionCommand("Send");
		send_button.addActionListener(this);
		cancel_button = new Button("取 消");
		cancel_button.setActionCommand("Cancel");
		cancel_button.addActionListener(this);
	}
	private void Add_into(){
		this.add(panel);
		this.add(send_panel);
		this.add(cancel_panel);
		this.add(console_panel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		if(command.equals("Send")){
			
		}
		else if(command.equals("Cancel")){
			Login_Frame login_frame = new Login_Frame();
			this.dispose();
		}
		else{
			
		}
	}
}
