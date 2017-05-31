import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 * This class instantiates 6 pits for player A and 6 pits for player B
 * 
 * @author Yuki Kuroshima, Elena Pearson, Paul Nguyen
 *
 */
public class MiddlePanel extends JPanel {

	private DataModel model;
	private PitIconFormatter strategy;

	/**
	 * Class constructor.
	 * 
	 * @param m
	 *            DataModel object used to pass it to the PitLabel Class.
	 * @param s
	 *            Formatter for the shape of pit. It is passed to the PitLabel
	 *            class.
	 *            <p>
	 *            Precondition: N/A
	 *            <p>
	 *            Postcondition: N/A
	 */
	public MiddlePanel(DataModel m, PitIconFormatter s) {
		this.model = m;
		this.strategy = s;

		setSize(900, 900);
		setLayout(new GridLayout(2, 6));

		for (int i = 6; i > 0; i--) {
			PitLabel pitLabel = new PitLabel(model, i, 100, 100, strategy);
			add(pitLabel);
			model.attach(pitLabel);
		}
		for (int i = 8; i < 14; i++) {
			PitLabel pitLabel = new PitLabel(model, i, 100, 100, strategy);
			add(pitLabel);
			model.attach(pitLabel);
		}
	}

	/**
	 * Set the pit shame formatter.
	 * 
	 * @param strategy
	 *            New format is set to this PitIconFormatter.
	 *            <p>
	 *            Precondition: N/A
	 *            <p>
	 *            Postcondition: N/A
	 */
	public void setStrategy(final PitIconFormatter strategy) {
		this.strategy = strategy;
	}
}