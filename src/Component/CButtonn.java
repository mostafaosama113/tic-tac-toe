package Component;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CButtonn extends JPanel implements MouseListener{
	
	private ImageIcon icon;
	
	public CButtonn(){
		icon = new ImageIcon(this.getClass().getResource("/pic/Back.png"));
		setOpaque(false);
		addMouseListener(this);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		icon.paintIcon(this, g, 0, 0);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		icon = new ImageIcon(this.getClass().getResource("/pic/Back1.png"));
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		icon = new ImageIcon(this.getClass().getResource("/pic/Back.png"));
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		icon = new ImageIcon(this.getClass().getResource("/pic/Back.png"));
		repaint();
		
	}
	
	@Override public void mouseClicked(MouseEvent arg0) {}
	@Override public void mouseReleased(MouseEvent arg0) {}
}
