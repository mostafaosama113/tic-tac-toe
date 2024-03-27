package TicTacToe;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import Component.AboutUs;
import Component.Color;
import Component.Panel;
import Component.RButton;

public class Room0 extends Panel implements MouseListener{
	
	private RButton Rbtn;
	private RButton Rbtn1;
	private RButton Rbtn2;
	private RButton Rbtn3;
    private ImageIcon icon ,gamaName;    
	
	Room0(){
		Rbtn = new RButton();
		Rbtn.setBounds(118,190,163,62);
		Rbtn.setText("Single Player");
		Rbtn.setIcon("singleIcon.png");
		Rbtn1 = new RButton();
		Rbtn1.setBounds(118,262,163,62);
		Rbtn1.setText("Multiplayer");
		Rbtn1.setIcon("multiIcon.png");
		Rbtn2 = new RButton();
		Rbtn2.setBounds(118,334,163,62);
		Rbtn2.setText("About us");
		Rbtn2.setIcon("about-usIcon.png");
        Rbtn3 = new RButton();
		Rbtn3.setBounds(118,406,163,62);
		Rbtn3.setText("Exit");
		Rbtn3.setColor(Color.red);
		Rbtn.addMouseListener(this);
		Rbtn1.addMouseListener(this);
		Rbtn2.addMouseListener(this);
		Rbtn3.addMouseListener(this);
		
		icon = new ImageIcon(this.getClass().getResource("/pic/XOicon.png"));
		gamaName = new ImageIcon(this.getClass().getResource("/pic/game name.png"));
		
		add(Rbtn);
		add(Rbtn1);
		add(Rbtn2);
        add(Rbtn3);
	}

	@Override public void mouseClicked(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent arg0) {}
	@Override public void mouseExited(MouseEvent arg0) {}
	@Override public void mousePressed(MouseEvent e) {
		if(e.getSource() == Rbtn) {
			TicTacToe.main.content.remove(TicTacToe.room0);
			TicTacToe.main.content.add(TicTacToe.room1);
			TicTacToe.main.room1.single = true;
			TicTacToe.main.repaint();
		}else if(e.getSource() == Rbtn1) {
			TicTacToe.main.content.remove(TicTacToe.room0);
			TicTacToe.main.content.add(TicTacToe.room1);
			TicTacToe.main.room1.single = false;
			TicTacToe.main.repaint();
		}else if(e.getSource() == Rbtn2) {
			new AboutUs();
		}else if(e.getSource() == Rbtn3) {
			for(float i = 1 ; i > 0 ; i -= 0.02) {
				TicTacToe.main.setOpacity(i);
				try {Thread.sleep(2);}catch (Exception ex) {}
			}
			System.exit(0);
		}
	}
	@Override public void mouseReleased(MouseEvent arg0) {}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		icon.paintIcon(this, g, 150, 20);
		gamaName.paintIcon(this, g, 0, 110);
	}
}
