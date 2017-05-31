import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 * This class implements the concrete method of PitInconFormatter.
 * 
 * @author Yuki Kuroshima, Elena Pearson, Paul Nguyen
 *
 */
public class RectanglePitIcon implements PitIconFormatter {

	/**
	 * @param x
	 *            Horizontal Location of Shape
	 * 
	 * @param y
	 *            Vertical Location of Shape
	 * @param w
	 *            Width of shape
	 * @param h
	 *            Height of shape
	 * 
	 *            <p>
	 *            Precondition: N/A
	 *            <p>
	 *            Postcondition: N/A
	 */
	@Override
	public Shape makePit(int x, int y, int w, int h) {
		return new Rectangle.Double(x, y, w - 2, h - 2);
	}
}
