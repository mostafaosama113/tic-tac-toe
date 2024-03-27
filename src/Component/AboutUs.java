package Component;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import TicTacToe.TicTacToe;

public class AboutUs extends JDialog{

	
	public AboutUs() {
				setModal(true);
				setSize(328,346);
				setLocationRelativeTo(TicTacToe.main);
				setUndecorated(true);
				add(new panel1());
				setOpacity(0);
				setVisible(true);
		
	}

	class panel1 extends JPanel implements WindowListener{
		
		private ImageIcon icon;
		
		panel1(){
			icon = new ImageIcon(this.getClass().getResource("/pic/about us.png"));
			setLayout(null);
			JExit exit = new JExit();
			addWindowListener(this);
			exit.setBounds(270, 17, 43, 35);
			exit.addMouseListener(new MouseListener() {
				
				@Override public void mouseReleased(MouseEvent arg0) { }	
				@Override public void mousePressed(MouseEvent arg0) { 
					for(float i = 1 ; i > 0 ; i -= 0.02) {
						setOpacity(i);
						try {Thread.sleep(2);}catch (Exception e) {}
					}
					dispose();
				}	
				@Override public void mouseExited(MouseEvent arg0) {}
				@Override public void mouseEntered(MouseEvent arg0) {}
				@Override public void mouseClicked(MouseEvent arg0) { }
			});
			exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
			add(exit);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			icon.paintIcon(this, g, 0, 0);
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
				setOpacity(i);
				try {Thread.sleep(2);}catch (Exception e) {}
			}
			
		}

	}
}

