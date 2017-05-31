import java.awt.Shape;

/**
 * This interface is used for formatting the shape of Pit by using the strategy
 * pattern.
 * 
 * @author Yuki Kuroshima, Elena Pearson, Paul Nguyen
 *
 */
public interface PitIconFormatter {

	public Shape makePit(int x, int y, int w, int h);
}
