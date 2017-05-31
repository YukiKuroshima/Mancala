
import javax.swing.JPanel;

/**
 * This class instantiates a mancala
 * 
 * @author Yuki Kuroshima, Elena Pearson, Paul Nguyen
 *
 */
public class SidePanel extends JPanel {
	private PitLabel mancala;
	private PitIconFormatter strategy;

	/**
	 * Class constructor
	 * 
	 * @param model
	 *            DataModel object to be passed to the PitLabel class
	 * @param pitIndex
	 *            Indext of pit
	 * @param pitHeight
	 * 
	 * @param pitWidth
	 *            Widths of pit
	 * @param s
	 *            Formatter of the shape of pit
	 */
	public SidePanel(DataModel model, int pitIndex, int pitHeight, int pitWidth, PitIconFormatter s) {
		this.strategy = s;
		mancala = new PitLabel(model, pitIndex, pitHeight, pitWidth, strategy);
		add(mancala);
		model.attach(mancala);
	}
}
