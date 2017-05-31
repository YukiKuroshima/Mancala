
import javax.swing.JFrame;

/**
 * This class MancalaTest is used to run the Mancala game.
 * 
 * @author Yuki Kuroshima, Elena Pearson, Paul Nguyen
 */
public class MancalaTest {

	/**
	 * Main Method to run and play the Mancala game. This main method instantiates the BoardFrame class
	 * 
	 * @param args
	 *            default argument
	 */
	public static void main(String[] args) {

		BoardFrame myBoard = new BoardFrame();
		myBoard.setTitle("Mancala Tester");
		myBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myBoard.setVisible(true);
	}
}
