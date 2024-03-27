package TicTacToe;

import java.awt.Image;
import javax.imageio.ImageIO;
import Component.Form;

public class TicTacToe extends Form{
	
	public static TicTacToe main;
	public static Room0 room0;
	public static Room1 room1;
	
	public static void main(String [] args) {
		main = new TicTacToe();		
		main.setVisible(true);
	}
	TicTacToe(){
		try {
            Image img = ImageIO.read(getClass().getResource("/pic/icon.png"));
            setIconImage(img);
        }catch (Exception e) {
            e.printStackTrace();
        }
		room0 = new Room0();
		room1 = new Room1();
		content.add(room0);
		
	}
	
}