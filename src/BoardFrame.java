
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * BoardFrame class has DataModel, two SidePanel, and one MiddlePanel. This
 * class also implements ChangeListener because when the game is over a pop up
 * window shows up and show the result of game
 * 
 * @author Yuki Kuroshima, Elena Pearson, Paul Nguyen
 *
 */

public class BoardFrame extends JFrame implements ChangeListener {
	private DataModel model;
	private SidePanel Left;
	private SidePanel Right;
	private MiddlePanel Middle;
	private PitIconFormatter strategy;

	/**
	 * Class Constructor
	 * <p>
	 * Instantiating the all the panels and the layout is BorderLayout
	 */
	public BoardFrame() {

		ArrayList<Integer> initialArrayList = new ArrayList<>();
		for (int i = 0; i < 14; i++) {
			initialArrayList.add(0);
		}

		this.strategy = new CirclePitIcon();

		this.model = new DataModel(initialArrayList);

		Object[] StrategyOptions = { "Rectangle", "Circle" };
		int strategyInt = JOptionPane.showOptionDialog(this, "Which look do you want to use?", "Style Setting",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, StrategyOptions,
				StrategyOptions[1]);

		if (strategyInt == 0) {// rectangle
			this.strategy = new RectanglePitIcon();
		} else if (strategyInt == 1) {// Circle
			this.strategy = new CirclePitIcon();
		}

		Object[] stoneNumberOptions = { "3", "4" };
		int stoneNumberInt = JOptionPane.showOptionDialog(this, "How many stones in each pit do you want",
				"Number of Stone Setting", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				stoneNumberOptions, stoneNumberOptions[1]);
		if (stoneNumberInt == 0) {// 3
			for (int i = 0; i < 14; i++) {
				if (!(i == 0 || i == 7)) {
					initialArrayList.set(i, 3);
				}
			}
		} else if (stoneNumberInt == 1) {// 4
			for (int i = 0; i < 14; i++) {
				if (!(i == 0 || i == 7)) {
					initialArrayList.set(i, 4);
				}
			}
		}
		model.setInitialArrayList(initialArrayList);

		setSize(1000, 350);

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());

		TurnTextArea turnText = new TurnTextArea(model, "Player A's Turn");
		turnText.setHorizontalAlignment(SwingConstants.CENTER);
		model.attach(turnText);

		JTextField mancalaB = new JTextField("Player B's Mancala and Pits");
		mancalaB.setEditable(false);

		topPanel.add(mancalaB, BorderLayout.WEST);
		topPanel.add(turnText, BorderLayout.CENTER);

		JPanel buttomPanel = new JPanel();
		buttomPanel.setLayout(new BorderLayout());

		JTextField mancalaA = new JTextField("Player A's Pits and Mancala");
		mancalaA.setEditable(false);

		JButton undoButton = new JButton("Undo");
		undoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				model.undoUpdate();
			}
		});

		buttomPanel.add(undoButton, BorderLayout.CENTER);
		buttomPanel.add(mancalaA, BorderLayout.EAST);

		SidePanel A = new SidePanel(model, 0, 250, 100, strategy);
		SidePanel B = new SidePanel(model, 7, 250, 100, strategy);
		MiddlePanel middlePanel = new MiddlePanel(model, strategy);

		setLayout(new BorderLayout());
		add(topPanel, BorderLayout.NORTH);
		add(A, BorderLayout.EAST);
		add(middlePanel, BorderLayout.CENTER);
		add(B, BorderLayout.WEST);
		add(buttomPanel, BorderLayout.SOUTH);

		model.attach(this);
	}

	/**
	 * This methods sets the formatting of shape of pit by using strategy
	 * pattern
	 * 
	 * @param s
	 *            Strategy for formatting the Shape of Pit
	 *            <p>
	 *            Precondition: N/A
	 * 
	 *            <p>
	 *            Postcondition: New Pit format is set.
	 */
	public void setStrategy(PitIconFormatter s) {
		this.strategy = s;
		repaint();
	}

	/**
	 * @inheritDoc This method is invoked every time the model called the
	 *             stateChagned method but only if the isGameDone() returns the
	 *             true, a pop up dialog will be shown
	 * @param e
	 *            ChangeEvent passed by the update method.
	 *            <p>
	 *            Precondition: N/A
	 * 
	 *            <p>
	 *            Postcondition: The pop up dialog is shown with the result of
	 *            game.
	 */

	@Override
	public void stateChanged(ChangeEvent e) {
		if (model.isGameDone()) {
			System.out.println("In SC of Frame Game Done is true");
			String message = "";
			switch (model.getWinner()) {
			case A:
				message = "Player A is the winner";
				break;
			case B:
				message = "Player B is the winner";
				break;
			case Draw:
				message = "Draw";
				break;
			default:
				break;
			}
			JOptionPane.showMessageDialog(this,
					message + "\nA got " + model.getData().get(0) + "\nB got " + model.getData().get(7));
		}
	}
}
