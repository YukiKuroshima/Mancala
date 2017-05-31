import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class extends JTextField and implements ChangeListener to show which
 * player's turn is
 * 
 * @author Yuki Kuroshima, Elena Pearson, Paul Nguyen
 *
 */
public class TurnTextArea extends JTextField implements ChangeListener {
	private DataModel model;
	private String message;

	/**
	 * Class constructor
	 * 
	 * @param m
	 *            DataModel object to get the current player's turn
	 * @param defaultMessage
	 *            default message to be shown
	 */
	public TurnTextArea(DataModel m, String defaultMessage) {
		this.model = m;
		this.message = defaultMessage;
		this.setText(message);
		setEditable(false);
	}

	/**
	 * To set the message based on the turn that is getting from the DataModel
	 * getNextPlayerTurn method.
	 * 
	 * @param e
	 *            ChangeEvent to be evoked
	 *            <p>
	 *            Precondition: N/A
	 *            <p>
	 *            Postcondition: N/A
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		if (model.getNextPlayerTurn()) {
			message = "Player B's Turn";
		} else {
			message = "Player A's Turn";
		}
		this.setText(message);
	}

}
