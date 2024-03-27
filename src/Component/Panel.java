package Component;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel {

	private ImageIcon bg ;
	private Timer t;
	
	public Panel(){
        setLayout(null);
		bg = new ImageIcon(this.getClass().getResource("/pic/background.jpg"));
		setSize(400,515);
		setLayout(null);
		setBackground(Color.white);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		bg.paintIcon(this, g, 0, 0);
	}
	
}
