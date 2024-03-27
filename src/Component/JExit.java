package Component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JExit extends JLabel implements MouseListener{
	
	private ImageIcon ico;
	
	JExit(){
		setPreferredSize(new Dimension(43,35));
		setOpaque(false);
		ico = new ImageIcon(this.getClass().getResource("/pic/X-out.png"));
		addMouseListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D)graphics;
		g.scale(.8, .8);
		ico.paintIcon(this, g, 5, 6);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		ico = new ImageIcon(this.getClass().getResource("/pic/X-out1.png"));
		setForeground(new Color(255, 153, 51));
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		ico = new ImageIcon(this.getClass().getResource("/pic/X-out.png"));
		setForeground(Color.white);
	}
	@Override public void mouseClicked(MouseEvent arg0) {}
	@Override public void mousePressed(MouseEvent arg0) {}
	@Override public void mouseReleased(MouseEvent arg0) {}
}
