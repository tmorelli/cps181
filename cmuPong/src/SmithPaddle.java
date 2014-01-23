import java.awt.Point;
import javax.swing.ImageIcon;

public class SmithPaddle extends Paddle {
	/*****************************************************************/
    public SmithPaddle(int _x){
        super(_x);
        ImageIcon iiPaddle = new ImageIcon("/Users/anthonymorelli/Documents/edu/cps181/paddle.png");
        // ImageIcon ii = new ImageIcon(this.getClass().getResource("bardejov.jpg"));
        paddleImage = iiPaddle.getImage();
    }
	/*****************************************************************/
    public void update(){
    	paddleLocation.x += paddleVector.x;
    	paddleLocation.y += paddleVector.y;
    	
    	updatePaddleVector();
    }
	/*****************************************************************/
    private void updatePaddleVector(){
    	if (paddleLocation.y > 500 || paddleLocation.y < 10){
    		paddleVector.y *= -1;
    	}
    }
	/*****************************************************************/
    public void init(){
    	paddleLocation = new Point();
    	paddleVector = new Point();
    	paddleVector.x = 0;
    	paddleVector.y = speed;
    	paddleLocation.x = xLocation;
    	paddleLocation.y =  200;
    }
	/*****************************************************************/
}
