import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;


public class GameController extends JFrame {
	/**
	 *	@ author Tony Morelli
	 *	@throws None 
	 *	
	 * 	Date: 		1 January 2014
	 *  Purpose: 	Controls all aspects of the CMU Pong Game	
	 *  Uses:		JFrame  
	 *  
	 */

    private Timer timer;
    private BoardDisplay board = null;
    private Paddle player1 = null;
    private Paddle player2 = null;
    private boolean gameInPlay = true;
    
    private static int PLAYER1_LOCATION = 20;
    private static int PLAYER2_LOCATION = 750;
    private Scores scores = new Scores();
    
/*****************************************************************/
	public GameController(){
    	/*
    	*  Purpose: Constructs a GameController object
    	*  Preconditions: None
    	*  Postconditions: return nothing
    	*/

        board = new BoardDisplay();
        player1 = new DefaultPaddle(PLAYER1_LOCATION);
        player2 = new DefaultPaddle(PLAYER2_LOCATION);
        player1.setGameController(this);
        player2.setGameController(this);
        add(board);
        board.setPlayer1(player1);
        board.setPlayer2(player2);

		createWindow();
		initObjects();
		
		ActionListener updateListener = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                update();
            }
        };
        timer = new Timer(33,updateListener); //Update 30 times a second
        timer.start();
        
	}//End GameController
	/*****************************************************************/
	private void initObjects(){
    	/*
    	*  Purpose: Initialize all game objects
    	*  Preconditions: None
    	*  Postconditions: return nothing
    	*/

		board.init();
		player1.init();
		player2.init();
		scores.readScores();
	}//end initObjects
	/*****************************************************************/
	private void createWindow(){
    	/*
    	*  Purpose: Create the window to display the game
    	*  Preconditions: None
    	*  Postconditions: return nothing
    	*/

        setTitle("cmuPong");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 620);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
	}//end createWindow
/*****************************************************************/
	private void update(){
    	/*
    	*  Purpose: Called 30 times a second to update game objects
    	*  Preconditions: None
    	*  Postconditions: return nothing
    	*/
		if (gameInPlay){
			player1.update();
			player2.update();
			board.update();
			if (board.getGameOver()){
				gameInPlay = false;
				gameOver();
			}
			repaint();
		}
	}//end Update
/*****************************************************************/
	private void gameOver(){
    	/*
    	*  Purpose: Called when the game ends
    	*  Preconditions: None
    	*  Postconditions: return nothing
    	*/
		scores.writeScores(board.getScore(0), board.getScore(1));
		scores.appendScores(board.getScore(0), board.getScore(1));
	}
/*****************************************************************/
	public static void main(String[] args) {
    	/*
    	*  Purpose: Main entry for the program
    	*  Preconditions: None
    	*  Postconditions: return nothing
    	*/

		new GameController();
	}//end main
/*****************************************************************/
	public Point getOtherPlayerLocation(Paddle _p){
    	/*
    	*  Purpose: Return the location of the other player's paddle
    	*  Preconditions: None
    	*  Postconditions: return point containing the location
    	*/

		if ((_p.paddleLocation.x == player1.paddleLocation.x) && 
			(_p.paddleLocation.y == player1.paddleLocation.y )){
			return player2.paddleLocation;
		}
		else{
			return player1.paddleLocation;
		}
	}//end getOtherPlayerLocation
/*****************************************************************/
	public Point getBallLocation(){
    	/*
    	*  Purpose: Return the location of the ball
    	*  Preconditions: None
    	*  Postconditions: return point containing the location
    	*/
		return board.getBallLocation();
	}//end getBallLocation
}
/*****************************************************************/
