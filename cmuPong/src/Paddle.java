import java.awt.Image;
import java.awt.Point;

public class Paddle {
	/**
	 *	@ author Tony Morelli
	 *	@throws None 
	 *	
	 * 	Date: 		1 January 2014
	 *  Purpose: 	Base paddle class	
	 *  Uses:		
	 *  
	 */

	
	Image paddleImage;
	Point paddleLocation;
	Point paddleVector;
	Point paddleSize;
	int speed = 10;
	int xLocation;
	String name = "Default";
	GameController controller = null;
	
	/*****************************************************************/
    public Paddle(int _x){
    	/*
    	*  Purpose: Constructs a Paddle object
    	*  Preconditions: horizontal value of paddle location
    	*  Postconditions: return nothing
    	*/
    	paddleSize = new Point(25,120);
        xLocation = _x;
    	//Override
    }//End Paddle
	/*****************************************************************/
    public void update(){
    	/*
    	*  Purpose: Called every frame update - typically 30 times a second
    	*  Preconditions: None
    	*  Postconditions: return nothing
    	*/
    	//Override
    }//End update
	/*****************************************************************/
    public void init(){
    	/*
    	*  Purpose: Initializes the object
    	*  Preconditions: None
    	*  Postconditions: return nothing
    	*/

    	//Override
    }//End init
	/*****************************************************************/
    public String getName(){
    	/*
    	*  Purpose: Get the name of the player
    	*  Preconditions: None
    	*  Postconditions: return the name
    	*/

    	return name;
    }//End getName
	/*****************************************************************/
    public Point getLocation(){
    	/*
    	*  Purpose: Get the location of the paddle
    	*  Preconditions: None
    	*  Postconditions: return point containing the location of the paddle
    	*/

    	return paddleLocation;
    }//End getLocation
	/*****************************************************************/
    public Point getSize(){
    	/*
    	*  Purpose: Get the size of the paddle
    	*  Preconditions: None
    	*  Postconditions: return the width stored as x and the height stored as y
    	*/

    	return paddleSize;
    }//End getSize
	/*****************************************************************/
    public void setGameController(GameController gc){
    	/*
    	*  Purpose: Set the gameController object
    	*  Preconditions: The gameController object
    	*  Postconditions: return nothing
    	*/

    	controller = gc;
    }//End setGameController
	/*****************************************************************/
}
