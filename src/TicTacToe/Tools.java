package TicTacToe;


import Component.GamePanel;

public class Tools {

	public static boolean chickWinner(char a , GamePanel[] game) {
		if( (game[0].placement == a) && (game[1].placement == a) && (game[2].placement == a) || 
				(game[3].placement == a) && (game[4].placement == a) && (game[5].placement == a)||
				(game[6].placement == a) && (game[7].placement == a) && (game[8].placement == a)||
				(game[0].placement == a) && (game[3].placement == a) && (game[6].placement == a)||
				(game[1].placement == a) && (game[4].placement == a) && (game[7].placement == a)||
				(game[2].placement == a) && (game[5].placement == a) && (game[8].placement == a)||
				(game[0].placement == a) && (game[4].placement == a) && (game[8].placement == a)||
				(game[2].placement == a) && (game[4].placement == a) && (game[6].placement == a)
				) 
			return true;
		else
			return false;
	}
	
    public static boolean IPlayer(char a , GamePanel game[])
    {
        if(chick(a , 0 , 1 , 2 , game))
            return true;
        else if(chick(a , 3 , 4 , 5 , game))
            return true;
        else if(chick(a , 6 , 7 , 8 , game))
            return true;
        else if(chick(a , 0 , 3 , 6 , game))
            return true;
        else if(chick(a , 1 , 4 , 7 , game))
            return true;
        else if(chick(a , 2 , 5 , 8 , game))
            return true;
        else if(chick(a , 0 , 4 , 8 , game))
            return true;
        else if(chick(a , 2 , 4 , 6 , game))
            return true;
        else
            return false;
        
    }
    private static boolean chick(char x , int a , int b , int c , GamePanel game[])
    {
        if(game[a].placement == x && game[b].placement == x && game[c].placement == '\u0000')
        {
        	game[c].play();
            return true;
        }
        else if (game[a].placement == x && game[c].placement == x && game[b].placement == '\u0000')
        {
        	game[b].play();
            return true;
        }   
        else if(game[b].placement == x && game[c].placement == x && game[a].placement == '\u0000')
        {
        	game[a].play();
            return true;
        }  
        else 
            return false;
    }
	
}
