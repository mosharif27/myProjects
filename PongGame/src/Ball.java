import java.awt.*;
import java.util.Random;

public class Ball extends Rectangle
{
    Random random;
    int xVelocity;
    int yVelocity;
    int initialSpeed = 2;

    Ball(int x,int y, int width, int height){
        //Takes the 4 parameters x,y,width,height
        super(x,y,width,height);
        random = new Random();//to generate random directions for the ball
        int randomXDirection = random.nextInt(2);
        if(randomXDirection == 0)
            randomXDirection--;
        setXDirection(randomXDirection * initialSpeed);//generates a random x direction for the ball and sets is using
        //the setXDirection method

        int randomYDirection = random.nextInt(2);
        if(randomYDirection == 0)
            randomYDirection--;
        setYDirection(randomYDirection*initialSpeed);
        //Generates a random y direction
    }
    public void setXDirection(int randomXDirection){
        xVelocity = randomXDirection;

    }
    public void setYDirection(int randomYDirection){
        yVelocity = randomYDirection;
    }
    public void move(){
        x += xVelocity;
        y += yVelocity;
        //Sets the direction of the ball velocity in the x and y directions using
        //the setXDirection and setYDirection methods and updates the position for the ball using 'move;

    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x,y,height, width);
        //Draws the pong the ball
    }
}
