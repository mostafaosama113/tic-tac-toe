package Component;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements MouseListener{

	public int id;
	public char placement;
	public static char temp = 'x';
	private ImageIcon icon;
	
	public GamePanel(int id){
		setOpaque(false);
		this.id = id+1;
		icon = null;
		addMouseListener(this);
	}
	
	public void reset() {
		placement = '\u0000';
		icon = null;
		temp = 'x';
	}
	
	public boolean play() {
		if(placement == '\u0000') {
		placement = temp;
		if(placement == 'x') {
			temp = 'o';
			icon =  new ImageIcon(this.getClass().getResource("/pic/X.png"));
			repaint();
			return true;
		}
		else if(placement == 'o') {;
			icon =  new ImageIcon(this.getClass().getResource("/pic/O.png"));
			temp = 'x';
			repaint();
			return true;
		}
		}
		return false;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(icon != null)
			icon.paintIcon(this, g, 0, 0);
	}
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if(placement == '\u0000') {
				if(temp == 'x') 
					icon =  new ImageIcon(this.getClass().getResource("/pic/X1.png"));
				else if(temp == 'o')
					icon =  new ImageIcon(this.getClass().getResource("/pic/O1.png"));
				repaint();
			}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if(placement == '\u0000') {
				icon = null;
				repaint();
			}
		
	}

	@Override public void mouseClicked(MouseEvent arg0) {}
	@Override public void mousePressed(MouseEvent arg0) {}
	@Override public void mouseReleased(MouseEvent arg0) {}
}
