package Component;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import TicTacToe.TicTacToe;

public class State extends JDialog implements WindowListener , MouseListener , MouseMotionListener{
	
	private ImageIcon  icon;
	private panel p;
	private int x , y;
	
	private State() {
		setModal(true);
		setUndecorated(true);
		setSize(330,131);
		setLayout(null);
		setLocationRelativeTo(TicTacToe.main);
		p = new panel();
		p.setBounds(0,0,330,131);
		add(p);
		setOpacity(0);
		addWindowListener(this);
		/////////////////////////////////bar///////////////////////////////////////
//		JPanel bar = new JPanel();
//		bar.setBounds(0,0,330,18);
//		bar.setOpaque(false);
//		bar.addMouseListener(this);
//		bar.addMouseMotionListener(this);
//		p.add(bar);
		/////////////////////////////////bar///////////////////////////////////////
		addMouseListener(this);
		addMouseMotionListener(this);
		JExit exit = new JExit();
		exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exit.setBounds(287, 0, 43, 35);
		exit.addMouseListener(this);
		p.add(exit);
	}
	
	public static void win() {
		State s = new State();
		s.icon = new ImageIcon(s.getClass().getResource("/pic/win.png"));
		s.setVisible(true);	
		}
	public static void lost() {
		State s = new State();
		s.icon = new ImageIcon(s.getClass().getResource("/pic/lost.png"));
		s.setVisible(true);	
		}
	public static void draw() {
		State s = new State();
		s.icon = new ImageIcon(s.getClass().getResource("/pic/draw.png"));
		s.setVisible(true);	
		}
	public static void XOWin(char a) {
		State s = new State();
		if(a == 'x')
			s.icon = new ImageIcon(s.getClass().getResource("/pic/Xwin1.png"));
		else if(a == 'o')
			s.icon = new ImageIcon(s.getClass().getResource("/pic/Owin1.png"));
		s.setVisible(true);	
	}
	class panel extends JPanel{	
		
		panel(){
			setLayout(null);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(icon != null)
				icon.paintIcon(this, g, 0, 0);
		}
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		for(float i = 0 ; i < 1 ; i += 0.02) {
			setOpacity(i);
			try {Thread.sleep(2);}catch (Exception e) {}
		}
	}

	@Override 
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		if(e.getSource() instanceof JExit) {
			for(float i = 1 ; i > 0 ; i -= 0.02) {
				setOpacity(i);
				try {Thread.sleep(2);}catch (Exception ex) {}
			}
			dispose();
		}
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		int lx = e.getXOnScreen() - x , ly = e.getYOnScreen() - y;
		if(e.getXOnScreen() - x < TicTacToe.main.getX()) 
			lx = TicTacToe.main.getX();
		else if(e.getXOnScreen() - x > TicTacToe.main.getX() + TicTacToe.main.getWidth() - 330) 
			lx = TicTacToe.main.getX() + TicTacToe.main.getWidth() - 330;
		if(e.getYOnScreen() - y < TicTacToe.main.getY()+35) 
			ly = TicTacToe.main.getY()+35;
		else if(e.getYOnScreen() - y > TicTacToe.main.getY() + TicTacToe.main.getHeight() - 131)
			ly = TicTacToe.main.getY() + TicTacToe.main.getHeight() - 131;
		
		setLocation(lx,  ly);
	}
	@Override public void windowClosed(WindowEvent arg0) {}
	@Override public void mouseMoved(MouseEvent arg0) {}
	@Override public void mouseClicked(MouseEvent arg0) {}
	@Override public void mouseEntered(MouseEvent arg0) {}
	@Override public void mouseReleased(MouseEvent arg0) {}
	@Override public void mouseExited(MouseEvent arg0) {}
	@Override public void windowDeactivated(WindowEvent arg0) {}
	@Override public void windowDeiconified(WindowEvent arg0) {}
	@Override public void windowIconified(WindowEvent arg0) {}
	@Override public void windowActivated(WindowEvent arg0) {}
	@Override public void windowClosing(WindowEvent arg0) {}
}
