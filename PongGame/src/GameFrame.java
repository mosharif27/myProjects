import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class GameFrame extends JFrame
{

    GamePanel panel = new GamePanel();
    //new instance of GamePanel class is assigned to the variable shown below 'Panel'

    GameFrame(){  //This Method sets the window, title and the background colour
        panel = new GamePanel();
        this.add(panel);
        this.setTitle("Pong Game");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack(); //Resizes the window
        this.setVisible(true);//Allows the window to be displayed
        this.setLocationRelativeTo(null);//used to centre the screen
        this.setBackground(Color.DARK_GRAY);
    }


}
