import java.awt.*;
import java.awt.event.*;
import java.awt.image.renderable.RenderableImage;
import java.security.Key;
import java.util.*;
import javax.swing.*;



public class GamePanel extends JPanel implements Runnable
{
    static final int GAME_WIDTH = 1000; // Sets the dimensions for the window
    static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;//Sets the dimensions of the ball
    static final int PADDLE_WIDTH = 25;//Sets the size of the paddles
    static final int PADDLE_HEIGHT = 100;
    Thread gameThread; //Object that is used for the game loop
    Image image;  //Used to draw the game graphics
    Graphics graphics;//Object used to draw on the image
    Random random;//Used to generate random numbers for the game
    Paddle paddle1;//The variables for the two paddles
    Paddle paddle2;
    Ball ball;
    Score score;

    GamePanel(){
        //Used for rendering the game graphics and handling the user input.
        newPaddles();
        newBall();

        score = new Score(GAME_WIDTH, GAME_HEIGHT);
        this.setPreferredSize(SCREEN_SIZE);
        this.addKeyListener(new AL());
        this.setFocusable(true);

        gameThread = new Thread(this);
        gameThread.start();//Starts the game loop in a new thread.
    }

    public void newBall(){
        //random = new Random();
        ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER / 2),(GAME_HEIGHT/2)-(BALL_DIAMETER/2),BALL_DIAMETER,BALL_DIAMETER);
        //Calculates the x-coordinate of the center of the ball so that it starts in the centre of the window
    }
    public void newPaddles(){
        paddle1 = new Paddle(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT,1);
        paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT,2);
        //Sets the paddle positions to their fixed locations on either side of the game window
    }
    public void paint(Graphics g){
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
        //draws the game graphics onto the panel and uses and off-screen buffer to avoid flickering

    }
    public void draw(Graphics g){
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);
        //Draws the paddles and the ball


    }
    public void move(){
        paddle1.move();
        paddle2.move();
        ball.move();
        //responsible for the movement of the paddles and the ball in the game
    }
    public void checkCollision(){
        //This part of the code uses if statements to check if the bal has collided with the top
        //or the bottom walls in the game area along with the paddles.
        if(ball.y <= 0){
           ball.setYDirection(-ball.yVelocity);
       }
       if(ball.y >= GAME_HEIGHT - BALL_DIAMETER)
       {
           ball.setYDirection(-ball.yVelocity);
       }
       //bounces ball off the paddles
        if(ball.intersects(paddle1)){
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;//option for higher difficulty
            if(ball.yVelocity>0)
                ball.yVelocity++;//option for higher difficulty
            else
                ball.yVelocity--;
                ball.setXDirection(ball.xVelocity);
                ball.setYDirection(ball.yVelocity);
        }
        if(ball.intersects(paddle2)){
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;//option for higher difficulty
            if(ball.yVelocity>0)
                ball.yVelocity++;//option for higher difficulty
            else
                ball.yVelocity--;
            ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }


        if(paddle1.y<=0)
           paddle1.y=0;
        if(paddle1.y >= (GAME_HEIGHT - PADDLE_HEIGHT))
            paddle1.y = GAME_HEIGHT - PADDLE_HEIGHT;
        if(paddle2.y<=0)
            paddle2.y=0;
        if(paddle2.y >= (GAME_HEIGHT - PADDLE_HEIGHT))
            paddle2.y = GAME_HEIGHT - PADDLE_HEIGHT;


        //give a player 1 point and creates new paddles and ball

        if(ball.x <= 0){
            score.player2++;
            newPaddles();
            newBall();
            System.out.println("Player 2: "+score.player2);
        }
        if(ball.x >= GAME_WIDTH - BALL_DIAMETER){
            score.player1++;
            newPaddles();
            newBall();
            System.out.println("Player 1: "+score.player1);
        }


    }
    public void run(){
        //This part of the code is responsible for the game loop and uses the system clock to ensure
        //the game runs at a constant speed

        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000/amountOfTicks;
        double delta = 0;
        while(true){ // Loop that checks the elapsed time and calls the move, collision and repaint methods
            //at 60 ticks per second.
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            if(delta >= 1){
                move();
                checkCollision();
                repaint();
                delta--;
                //Variable is used to keep track the amount of time that has passed since the last tick

            }
        }

    }
    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
            //For the user inputs when they press a key the paddle moves


        }
        public void keyReleased(KeyEvent e){
            paddle1.keyPressed(e);
            paddle2.keyReleased(e);
            //When released the paddle stops

        }
    }


}
