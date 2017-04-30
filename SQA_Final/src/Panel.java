import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends JPanel{
	JLabel label_north = new JLabel("      ");
	JLabel label_south = new JLabel("      ");
	JLabel label_east = new JLabel("          ");
	JLabel label_west = new JLabel("          ");
	public Panel(Button button){
		label_north = new JLabel("      ");
		label_south = new JLabel("      ");
		label_east = new JLabel("          ");
		label_west = new JLabel("          ");
		this.setLayout(new BorderLayout());
		this.add(label_north, BorderLayout.NORTH);
		this.add(label_south, BorderLayout.SOUTH);
		this.add(label_east, BorderLayout.EAST);
		this.add(label_west, BorderLayout.WEST);
		this.add(button, BorderLayout.CENTER);
	}
	public Panel(TextField textfield,String title){
		label_north = new JLabel("      ");
		label_south = new JLabel("      ");
		label_east = new JLabel("          ");
		label_west = new JLabel("   "+title+"   ");
		label_west.setFont(new Font("粗體",Font.PLAIN,20));
		this.setLayout(new BorderLayout());
		this.add(label_north, BorderLayout.NORTH);
		this.add(label_south, BorderLayout.SOUTH);
		this.add(label_east, BorderLayout.EAST);
		this.add(label_west, BorderLayout.WEST);
		this.add(textfield, BorderLayout.CENTER);
	}
}
