import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class has PitIcons and set the pit index to each pit
 * 
 * @author Yuki Kuroshima, Elena Pearson, Paul Nguyen
 *
 */
public class PitLabel extends JLabel implements ChangeListener {
	private DataModel model;
	private PitIcon pitIcon;
	private int pitID;
	private PitIconFormatter strategy;

	/**
	 * Class constructor
	 * 
	 * @param d
	 *            DataModel that is used to get the number of stone in each pit.
	 * @param pitID
	 *            Index of pit to assign to each pit
	 * @param pitHeight
	 *            Height of Pit
	 * @param pitWidth
	 *            Width of pit
	 * @param s
	 *            Formatter for the shape of pit
	 */
	public PitLabel(DataModel d, int pitID, int pitHeight, int pitWidth, PitIconFormatter s) {
		this.model = d;
		this.pitID = pitID;
		this.strategy = s;

		pitIcon = new PitIcon(pitHeight, pitWidth, model.getData().get(pitID), strategy);
		setIcon(pitIcon);

		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				model.update(pitID);
			}
		});
	}

	/**
	 * @param e
	 *            ChangeEvent to be invoked in this method.
	 * 
	 *            <p>
	 *            Precondition: The state of game has to be in game
	 *            <p>
	 *            Postcondition: New number of stone in each pits is set and
	 *            repainted.
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		pitIcon.setNumberOfStone(model.getData().get(pitID).intValue());
		pitIcon.setNumberOfStone(model.getData().get(pitID));
		repaint();
	}
}
