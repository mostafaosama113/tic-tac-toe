package Component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RButton extends JPanel implements MouseListener{
	
	private ImageIcon NIcon , icon;
	private JLabel l;
	private Component.Color c; 
	
	public RButton(){
		l = new JLabel("");
		c = Component.Color.blue;
		if(c == Component.Color.blue)
			NIcon = new ImageIcon(this.getClass().getResource("/pic/BB1.png"));
		else if(c == Component.Color.red)
			NIcon = new ImageIcon(this.getClass().getResource("/pic/BB1R.png"));
		addMouseListener(this);
		setOpaque(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		l.setFont(new Font("DIN Pro" , Font.BOLD , 20));
		setLayout(null);
	}
	
	public void setColor(Component.Color c) {
		this.c = c;
		if(c == Component.Color.blue)
			NIcon = new ImageIcon(this.getClass().getResource("/pic/BB1.png"));
		else if(c == Component.Color.red)
			NIcon = new ImageIcon(this.getClass().getResource("/pic/BB1R.png"));
		repaint();
	}
	
	public void setIcon(String name) {
		icon = new ImageIcon(this.getClass().getResource("/pic/" + name));
		l.setFont(new Font("DIN Pro" , Font.BOLD , 16));
		l.setText("       " + l.getText());
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D)graphics;
		g.scale(163.0 / getWidth(), 55.0 / getHeight() );
		NIcon.paintIcon(this, graphics, 0, 0);
		if(icon != null)
			icon.paintIcon(this, g, 20, 12);
		super.paintComponents(graphics);
		l.setBounds(0,0,getWidth() ,6+getHeight());
		l.setHorizontalAlignment(SwingConstants.CENTER);
		l.setForeground(Color.white);
		
		add(l);
		
	}
	@Override public void mouseClicked(MouseEvent arg0) {}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		if(c == Component.Color.blue)
			NIcon = new ImageIcon(this.getClass().getResource("/pic/BB2.png"));
		else if(c == Component.Color.red)
			NIcon = new ImageIcon(this.getClass().getResource("/pic/BB2R.png"));
		repaint();
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		if(c == Component.Color.blue)
			NIcon = new ImageIcon(this.getClass().getResource("/pic/BB1.png"));
		else if(c == Component.Color.red)
			NIcon = new ImageIcon(this.getClass().getResource("/pic/BB1R.png"));
		repaint();	
	}
	@Override 
	public void mousePressed(MouseEvent arg0) {
		if(c == Component.Color.blue)
			NIcon = new ImageIcon(this.getClass().getResource("/pic/BB1.png"));
		else if(c == Component.Color.red)
			NIcon = new ImageIcon(this.getClass().getResource("/pic/BB1R.png"));
		repaint();
	}
	@Override public void mouseReleased(MouseEvent arg0) {}
	
	public void setText(String txt) {
		l.setText(txt);
	}
}
