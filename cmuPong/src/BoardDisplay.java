import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Color;


import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BoardDisplay extends JPanel {
	/**
	 *	@ author Tony Morelli
	 *	@throws None 
	 *	
	 * 	Date: 		1 January 2014
	 *  Purpose: 	Controls game play of the cmuPong game	
	 *  Uses:		JPanel  
	 *  
	 */

	private Image backgroundImage;
	private Image ballImage;
	private Point ballLocation;
	private Point ballVector;
	int speed = 20;
	private int scores[] = new int[2];
	private Paddle player1 = null;
	private Paddle player2 = null;
	private boolean gameOver = false;
	private static int POINTS_TO_WIN = 10;
	
	/*****************************************************************/
    public BoardDisplay(){
    	/*
    	*  Purpose: Constructs a BoardDisplay object
    	*  Preconditions: None
    	*  Postconditions: return nothing
    	*/

        ImageIcon iiBackground = new ImageIcon(this.getClass().getResource("background.png"));
        ImageIcon iiBall = new ImageIcon(this.getClass().getResource("ball.png"));

        backgroundImage = iiBackground.getImage();
        ballImage = iiBall.getImage();
    }//End BoardDisplay
	/*****************************************************************/
    public void update(){
    	/*
    	*  Purpose: Update the state of the game
    	*  Preconditions: None
    	*  Postconditions: return nothing
    	*/

    	ballLocation.x += ballVector.x;
    	ballLocation.y += ballVector.y;
    	
    	if (!ballCollidesWithPaddle())
    	{
    		updateBallVector();
    	}
    }//End update
	/*****************************************************************/
    private boolean ballCollidesWithPaddle(){
    	/*
    	*  Purpose: Check to see if the ball collides with a paddle
    	*  Preconditions: None
    	*  Postconditions: return true if there is a collision, false otherwise
    	*/

    	if (ballCollidesWithPaddle(player1)){
    		ballVector.x *= -1;
    		ballLocation.x += speed;
    	}
    	else if (ballCollidesWithPaddle(player2)){
    		ballVector.x *= -1;
    		ballLocation.x -= speed;
    	}
    	return false;
    }//End ballCollidesWithPaddle
	/*****************************************************************/
    private boolean ballCollidesWithPaddle (Paddle p){
    	/*
    	*  Purpose: Check to see if the ball collides with the paddle
    	*  Preconditions: None
    	*  Postconditions: return true if there is a collision, false otherwise
    	*/

    	if ((ballLocation.x >= p.getLocation().x && ballLocation.x <= p.getLocation().x+p.getSize().x) || 
    		(ballLocation.x +30 >= p.getLocation().x && ballLocation.x+30 <= p.getLocation().x+p.getSize().x)){
        	if (ballLocation.y >= p.getLocation().y && ballLocation.y <= p.getLocation().y+p.getSize().y){
        		return true;
        	}
    	}
    	return false;
    }//ballCollidesWithPaddle
	/*****************************************************************/
    private void updateBallVector(){
    	/*
    	*  Purpose: Check to see if the ball hits any wall
    	*  Preconditions: None
    	*  Postconditions: return none
    	*/

    	if (ballLocation.x > 770){
    		scores[0]++;
    		ballVector.x *= -1;
    		pointScored();
    	}
    	else if (ballLocation.x < 10){
    		scores[1]++;
    		ballVector.x *= -1;
    		pointScored();
    	}
    	if (ballLocation.y > 570 || ballLocation.y < 10){
    		ballVector.y *= -1;
    	}
    }//End updateBallVector
	/*****************************************************************/
    private void pointScored(){
    	/*
    	*  Purpose: Handle the state where a point has been scored
    	*  Preconditions: None
    	*  Postconditions: None
    	*/

    	ballLocation.x = 400;
    	checkGameOver();
    }//End pointScored
	/*****************************************************************/
    private void checkGameOver(){
    	/*
    	*  Purpose: Determine if the game has ended
    	*  Preconditions: None
    	*  Postconditions: None
    	*/
    	if (scores[0] >= POINTS_TO_WIN || scores[1] >=POINTS_TO_WIN){
    		gameOver = true;
    	}
    }//End pointScored
	/*****************************************************************/
    @Override
    public void paint(Graphics g){
    	/*
    	*  Purpose: Redraw Graphics called by repaint()
    	*  Preconditions: graphics 
    	*  Postconditions: None
    	*/

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(backgroundImage, 0, 0, null);
        g2d.drawImage(ballImage, ballLocation.x, ballLocation.y, null);
        Font f = new Font("Dialog", Font.BOLD, 24);
        g2d.setColor(Color.white);
        g2d.setFont(f);
        g2d.drawString(Integer.toString(scores[0]), 200, 50);
        g2d.drawString(player1.getName(), 200, 80);
        g2d.drawString(Integer.toString(scores[1]), 600, 50);
        g2d.drawString(player2.getName(), 600, 80);
        
        g2d.drawImage(player1.paddleImage, player1.paddleLocation.x, player1.paddleLocation.y, null);
        g2d.drawImage(player2.paddleImage, player2.paddleLocation.x, player2.paddleLocation.y, null);
        
        
    }//End paint
	/*****************************************************************/
    public void init(){
    	/*
    	*  Purpose: Init the board
    	*  Preconditions: None
    	*  Postconditions: return None
    	*/

    	ballLocation = new Point();
    	ballVector = new Point();
    	ballVector.x = speed;
    	ballVector.y = speed;
    	ballLocation.x = 400;
    	ballLocation.y = 300;
    	scores[0] = 0;
    	scores[1] = 0;
    }//End init
	/*****************************************************************/
    public void setPlayer1(Paddle p){
    	/*
    	*  Purpose: Set a local pointer to player1
    	*  Preconditions: None
    	*  Postconditions: return None
    	*/

    	player1 = p;
    }//End setPlayer1
	/*****************************************************************/
    public void setPlayer2(Paddle p){
    	/*
    	*  Purpose: Set a local pointer to player2
    	*  Preconditions: None
    	*  Postconditions: return None
    	*/

    	player2 = p;
    }//End setPlayer2
	/*****************************************************************/
    public boolean getGameOver(){
    	/*
    	*  Purpose: Return if the game has ended or not
    	*  Preconditions: None
    	*  Postconditions: return gameOver
    	*/
    	return gameOver;
    }//getGameOver
	/*****************************************************************/
    public Point getBallLocation(){
    	/*
    	*  Purpose: Return ball location
    	*  Preconditions: None
    	*  Postconditions: return Point containing the location of the ball
    	*/
    	return ballLocation;
    }//getBallLocation
	/*****************************************************************/
    public int getScore(int _idx){
    	/*
    	*  Purpose: Get score for a player
    	*  Preconditions: player index
    	*  Postconditions: return score for the player
    	*/
    	if (_idx < 0 || _idx > 1){
    		return -1;
    	}
    	return scores[_idx];
    }//getScore
	/*****************************************************************/
}
