import java.awt.Point;
import javax.swing.ImageIcon;

public class MorelliPaddle extends Paddle {
	/*****************************************************************/
    public MorelliPaddle(int _x){
    	/*
    	*  Purpose: Constructs a MorelliPaddle object
    	*  Preconditions: The horizontal location is passed in
    	*  Postconditions: return nothing
    	*/

        super(_x);
        ImageIcon iiPaddle = new ImageIcon(this.getClass().getResource("paddle.png"));
        paddleImage = iiPaddle.getImage();
        name = "Morelli";
    }//End MorelliPaddle
	/*****************************************************************/
    public void update(){
    	/*
    	*  Purpose: Called each frame update (i.e. 30 times a second)
    	*  Preconditions: None
    	*  Postconditions: return nothing
    	*/

    	paddleLocation.x += paddleVector.x;
    	paddleLocation.y += paddleVector.y;
    	if (isPaddleOffScreen()){
    		reversePaddle();
    	}
//    	paddleLocation.y = controller.getBallLocation().y - 20;
    }//end Update
	/*****************************************************************/
    
    private boolean isPaddleOffScreen(){
    	/*
    	*  Purpose: Checks to see if the paddle has gone off screen
    	*  Preconditions: None
    	*  Postconditions: return true if paddle is off screen, false otherwise
    	*/

    	if (paddleLocation.y > 500 || paddleLocation.y < 10){
    		return true;
    	}
    	return false;
    } //End isPaddleOffScreen
	/*****************************************************************/
    
    private void reversePaddle(){
    	/*
    	*  Purpose: Reverse the paddle direction
    	*  Preconditions: None
    	*  Postconditions: None
    	*/
		paddleVector.y *= -1;
    }// End reversePaddle
	/*****************************************************************/
    public void init(){
    	/*
    	*  Purpose: Called by the gameController to init the object
    	*  Preconditions: None
    	*  Postconditions: return nothing
    	*/

    	paddleLocation = new Point();
    	paddleVector = new Point();
    	paddleVector.x = 0;
    	paddleVector.y = speed;
    	paddleLocation.x = xLocation;
    	paddleLocation.y =  20;
    }//end init
	/*****************************************************************/
}
