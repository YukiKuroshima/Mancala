import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class draw the frame for pit and draw stones in the frame based on the
 * number of stones gotten from the Model of MVC pattern
 * 
 * @author Yuki Kuroshima, Elena Pearson, Paul Nguyen
 *
 */
public class PitIcon implements Icon {

	private int height;
	private int width;
	private int numberOfStone;
	private PitIconFormatter strategy;

	private final int DIAMETER_OF_STONE = 10;
	private final double RATIO_OF_MARGIN_BETWEEN_STONE = 1.2;
	private final double RATIO_OF_MARGIN = 0.15;
	private final double RATIO_OF_USED_SPACE = 0.7;

	/**
	 * Class constructor
	 * 
	 * @param h
	 *            Height of Icon
	 * @param w
	 *            Width of Icon
	 * @param aNumberOfStone
	 *            Number of stone to be drawn
	 * @param s
	 *            Formatter class to indicate the shape of pit
	 * 
	 *            <p>
	 *            Precondition: N/A
	 *            <p>
	 *            Postcondition: N/A
	 */
	public PitIcon(int h, int w, int aNumberOfStone, PitIconFormatter s) {
		this.height = h;
		this.width = w;
		this.numberOfStone = aNumberOfStone;
		this.strategy = s;
	}

	/**
	 * This method set the number of stone in the pit
	 * 
	 * @param numberOfStone
	 *            The number of stone to be set to this pit
	 *            <p>
	 *            Precondition: N/A
	 *            <p>
	 *            Postcondition: N/A
	 */
	public void setNumberOfStone(int numberOfStone) {
		this.numberOfStone = numberOfStone;
	}

	/**
	 * Calculate the horizontal (Y) location that a stone to be drawn.
	 * 
	 * @param indexOfStone
	 *            Number of how many stones have been drawn (0 base)
	 *            <p>
	 *            Precondition: N/A
	 *            <p>
	 *            Postcondition: N/A
	 * @return Horizontal location that the stone to be drawn.
	 */
	private int getHorizontalStoneLocation(int indexOfStone) {
		double totalSpace = indexOfStone * DIAMETER_OF_STONE * RATIO_OF_MARGIN_BETWEEN_STONE;
		double divisor = width * RATIO_OF_USED_SPACE;
		double Reminder = totalSpace % divisor;
		double space = DIAMETER_OF_STONE * RATIO_OF_MARGIN_BETWEEN_STONE;
		return (int) (width * RATIO_OF_MARGIN + ((int) (Reminder / space)) * space);
	}

	/**
	 * Calculate the vertical (X) location that a stone to be drawn.
	 * 
	 * @param indexOfStone
	 *            Number of how many stones have been drawn (0 base)
	 *            <p>
	 *            Precondition: N/A
	 *            <p>
	 *            Postcondition: N/A
	 * @return Vertical location that the stone to be drawn.
	 */
	private int getVerticalStoneLocation(int indexOfStone) {
		int indexOfRow = (int) ((DIAMETER_OF_STONE * RATIO_OF_MARGIN_BETWEEN_STONE * indexOfStone)
				/ (width * RATIO_OF_USED_SPACE));

		int middle = (int) (height / 2.0);
		return (int) (middle + indexOfRow * DIAMETER_OF_STONE * RATIO_OF_MARGIN_BETWEEN_STONE);
	}

	/**
	 * This method implements the abstract method from Icon interface. This
	 * method should not be called by the user
	 * 
	 * @param c
	 *            Components that this Icon is attached to
	 * @param g
	 *            Graphics passed by the caller.
	 * @param x
	 *            Horizontal location of this Icon to be drawn
	 * @param y
	 *            Vertical location of this Icon to be drawn
	 *            <p>
	 *            Precondition: N/A
	 *            <p>
	 *            Postcondition: N/A
	 */
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.draw(strategy.makePit(x, y / 2, width, height));
		for (int i = 0; i < numberOfStone; i++) {
			g.fillOval(getHorizontalStoneLocation(i), getVerticalStoneLocation(i), DIAMETER_OF_STONE,
					DIAMETER_OF_STONE);
		}
	}

	/**
	 * Get the width of Icon
	 * <p>
	 * Precondition: N/A
	 * <p>
	 * Postcondition: N/A
	 */
	@Override
	public int getIconWidth() {
		return width;
	}

	/**
	 * Get the height of Icon
	 * <p>
	 * Precondition: N/A
	 * <p>
	 * Postcondition: N/A
	 */
	@Override
	public int getIconHeight() {
		return height;
	}
}
