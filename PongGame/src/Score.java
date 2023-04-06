import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Score extends Rectangle
{

    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int player1;
    int player2;

    Score(int GAME_WIDTH, int GAME_HEIGHT){
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGHT = GAME_HEIGHT;
    }
    public void draw(Graphics g){
        //Takes a Graphics object and uses it to draw the scores on the screen
        g.setColor(Color.white);
        g.setFont(new Font("Consolas",Font.PLAIN,60));
        g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);//White Line drawn in the middle of the screen
        g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10),(GAME_WIDTH/2)-85, 50);//Draw score of player1 and player2
        g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10),(GAME_WIDTH/2)+20, 50);
    }
}
