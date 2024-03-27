package Component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import TicTacToe.TicTacToe;

public class Form extends JFrame implements WindowListener{

	public JPanel content;
	
	public Form() {
		setSize(400,550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setLayout(null);
		Jbar bar = new Jbar();
		bar.setBounds(0, 0, 400, 35);
		add(bar);
		setLocationRelativeTo(null);
		setOpacity(0);
		addWindowListener(this);
		content = new JPanel();
		content.setLayout(null);
		content.setBounds(0, 35, 400, 515);
		content.setBackground(Color.white);
		add(content);
		
	}

	
	@Override public void windowActivated(WindowEvent arg0) {}

	@Override public void windowClosed(WindowEvent arg0) {}

	@Override public void windowClosing(WindowEvent arg0) {}

	@Override public void windowDeactivated(WindowEvent arg0) {}

	@Override public void windowDeiconified(WindowEvent arg0) {}

	@Override public void windowIconified(WindowEvent arg0) {}

	@Override
	public void windowOpened(WindowEvent arg0) {
		for(float i = 0 ; i < 1 ; i += 0.02) {
			TicTacToe.main.setOpacity(i);
			try {Thread.sleep(2);}catch (Exception e) {}
		}
		
	}
}
class Jbar extends JPanel implements MouseListener , MouseMotionListener {
	private ImageIcon bar , icon;
	private int x , y;

	Jbar(){
		setSize(400,35);
		bar = new ImageIcon(this.getClass().getResource("/pic/bar.png"));
		icon = new ImageIcon(this.getClass().getResource("/pic/mIcon.png"));
		JExit exit = new JExit();
		//////////////exit/////////////////
		exit.addMouseListener(new MouseListener() {
			@Override public void mouseReleased(MouseEvent arg0) { }	
			@Override 
			public void mousePressed(MouseEvent arg0) { 
				for(float i = 1 ; i > 0 ; i -= 0.02) {
					TicTacToe.main.setOpacity(i);
					try {Thread.sleep(2);}catch (Exception e) {}
				}
				System.exit(0);
			}		
			@Override public void mouseExited(MouseEvent arg0) { }
			@Override public void mouseEntered(MouseEvent arg0) {}
			
			@Override public void mouseClicked(MouseEvent arg0) {}
		});
		exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//////////////exit/////////////////
		setLayout(new BorderLayout());
		exit.setForeground(Color.white);
		exit.setFont(new Font("Comic Sans MS", Font.PLAIN , 25));
		addMouseListener(this);
		addMouseMotionListener(this);
		add(exit,BorderLayout.EAST);
		JLabel label = new JLabel("          TicTacToe");
		label.setFont(new Font("DIN Pro", Font.BOLD , 16));
		label.setForeground(Color.white);
		add(label);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		bar.paintIcon(this, g, 0, 0);
		icon.paintIcon(this, g, 5, 2);
	}
	
	@Override public void mouseClicked(MouseEvent arg0) {}

	@Override public void mouseEntered(MouseEvent arg0) {}

	@Override public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	@Override public void mouseReleased(MouseEvent arg0) {}

	@Override
	public void mouseDragged(MouseEvent e) {
		TicTacToe.main.setLocation(e.getXOnScreen() -x , e.getYOnScreen() -y);
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {}


}