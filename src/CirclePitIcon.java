import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 * This class is the concrete method of PitIconFormatter. This class generates
 * the circler pit.
 * 
 * @author Yuki Kuroshima, Elena Pearson, Paul Nguyen
 *
 */
public class CirclePitIcon implements PitIconFormatter {

	/*
	 * @inheritDoc This method instantiates the Ellipse and returns it.
	 * 
	 * @param x the horizontal location of shape.
	 * 
	 * @param y the vertical location of shape.
	 * 
	 * @param w the width of Ellipse drawing.
	 * 
	 * @param h the height of Ellipse drawing.
	 * 
	 * <p> Precondition: N/A
	 * 
	 * <p> Postcondition: An Ellipse2D instance is returned to the caller.
	 * 
	 * @see PitIconFormatter#makePit(int, int, int, int)
	 */
	@Override
	public Shape makePit(int x, int y, int w, int h) {
		return new Ellipse2D.Double(x, y, w - 2, h - 2);
	}
}
