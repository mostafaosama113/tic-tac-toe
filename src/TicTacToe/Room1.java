package TicTacToe;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Component.CButtonn;
import Component.GamePanel;
import Component.Panel;
import Component.State;

public class Room1 extends Panel implements MouseListener{

	public boolean single;
	private ImageIcon grid ;
	private CButtonn home;
	private GamePanel game[];
	private int counter = 0;
	
	Room1(){
		
		
		game = new GamePanel[9];
		
		for(int i = 0 ; i < 9 ; i++) {
			game[i] = new GamePanel(i);
		}
		
		grid = new ImageIcon(this.getClass().getResource("/pic/grid.png"));
		home = new CButtonn();
		home.setBounds(10 , 10 ,44,44);
		home.addMouseListener(this);
		////////////// add comp /////////////////////////////////
		game[0].setBounds(40, 58, 95, 95);
		game[0].addMouseListener(this);
		add(game[0]);
		
		game[1].setBounds(153, 58, 95, 95);
		game[1].addMouseListener(this);
		add(game[1]);
		
		game[2].setBounds(266, 58, 95, 95);
		game[2].addMouseListener(this);
		add(game[2]);
		
		game[3].setBounds(40, 170, 95, 95);
		game[3].addMouseListener(this);
		add(game[3]);
		
		game[4].setBounds(153, 170, 95, 95);
		game[4].addMouseListener(this);
		add(game[4]);
		
		game[5].setBounds(266, 170, 95, 95);
		game[5].addMouseListener(this);
		add(game[5]);
		
		game[6].setBounds(40, 285, 95, 95);
		game[6].addMouseListener(this);
		add(game[6]);
		
		game[7].setBounds(153, 285, 95, 95);
		game[7].addMouseListener(this);
		add(game[7]);
		
		game[8].setBounds(266, 285, 95, 95);
		game[8].addMouseListener(this);
		add(game[8]);
		////////////// add comp /////////////////////////////////
		add(home);
	}
	
	public void reset() {
		for(int i = 0 ; i < 9 ; i++)
			game[i].reset();
		counter = 0;
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		grid.paintIcon(this, g, 0, 0);
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override public void mouseEntered(MouseEvent arg0) {}
	@Override public void mouseExited(MouseEvent arg0) {}
	@Override public void mousePressed(MouseEvent e) {
		if(e.getSource() == home) {
			TicTacToe.main.content.remove(TicTacToe.room1);
			TicTacToe.main.content.add(TicTacToe.room0);
			repaint();
			TicTacToe.main.repaint();
			reset();
		}
		if(e.getSource() instanceof GamePanel) {
			GamePanel btn = (GamePanel)e.getSource();
			if(btn.play())
				counter++;
			if(Tools.chickWinner('x', game)) {
				if(single)
					State.win();
				else
					State.XOWin('x');
				reset();
				return;
			}
			else if(Tools.chickWinner('o', game) && !single) {
				State.XOWin('o');
				reset();
				return;
			}
				
			if(counter >= 9) {
				State.draw();
				reset();
				return;
			}
			///////////////////////////auto play////////////////////////////////
			if(single && game[0].temp == 'o') {
				while(true) {
			///////////////////INT PALYER/////////////////////////
					if(counter == 1 && game[4].placement == '\u0000') { 
					game[4].play();
					break;
					}
					else if(counter == 1 && game[4].placement == 'x') { 
						game[0].play();
						break;
					}
					
			///////////////////INT PALYER/////////////////////////

					if(Tools.IPlayer('o', game))
						break;
					else if(Tools.IPlayer('x', game))
						break;
					else if(counter == 3 && (game[0].play() || game[2].play() || game[6].play() || game[8].play())) 
						break;
					int R = new Random().nextInt(9);
					if(game[R].placement == '\u0000') {
						game[R].play();
						break;
					}
				}
				counter++;
				if(Tools.chickWinner('o', game)) {
					State.lost();
					reset();
					return;
				}
			}
			///////////////////////////auto play////////////////////////////////
			
		}
	}
	@Override public void mouseReleased(MouseEvent arg0) {}
}
