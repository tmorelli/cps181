import java.awt.Point;
import javax.swing.ImageIcon;

public class DefaultPaddle extends Paddle {
	/**
	 *	@ author Tony Morelli
	 *	@throws None 
	 *	
	 * 	Date: 		1 January 2014
	 *  Purpose: 	Provide a template class with required methods	
	 *  Uses:		Inherits from Paddle  
	 *  
	 */

	/*****************************************************************/
    public DefaultPaddle(int _x){
    	/*
    	*  Purpose: Constructs a DefaultPaddle object
    	*  Preconditions: The horizontal location is passed in
    	*  Postconditions: return nothing
    	*/
        super(_x);
        ImageIcon iiPaddle = new ImageIcon(this.getClass().getResource("paddle.png"));
        paddleImage = iiPaddle.getImage();
    }//end DefaultPaddle
	/*****************************************************************/
    public void update(){
    	/*
    	*  Purpose: Called each frame update (i.e. 30 times a second)
    	*  Preconditions: None
    	*  Postconditions: return nothing
    	*/

    	
    }//end update
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
    	paddleLocation.y =  200;
    }//End init
	/*****************************************************************/
}
