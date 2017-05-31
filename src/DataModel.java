import java.util.*;

import javax.swing.event.*;

/**
 * The Model of MVC pattern.
 * 
 * @author Yuki Kuroshima, Elena Pearson, Paul Nguyen
 *
 */
public class DataModel { // this is the model

	private ArrayList<Integer> data; // holds the number of stones in each pit
										// (pit # is
	// index #)
	private ArrayList<Integer> dataPreviouse;
	private ArrayList<ChangeListener> listeners;
	private boolean turn; // true = player1's turn false = player 2's turn
	// True = Allowed. becomes false only after undo is done.
	// after a player picks next pit it becomes true.
	private boolean isUndoAllowed;

	public enum Winner {
		A, B, Draw
	}

	private Winner winner;

	private int undoCounterA;
	private int undoCounterB;
	private boolean isGameFinished;
	private boolean freeTurn;
	private boolean isNoStoneInAsPits; // true if all of A's pits don't have
										// stones

	/**
	 * Class constructor
	 * 
	 * @param d
	 *            ArrayList of Integer. This ArrayList is used to initialize the
	 *            number of stones in each pits.
	 *            
	 */
	public DataModel(ArrayList<Integer> d) {
		this.data = d;
		this.dataPreviouse = (ArrayList<Integer>) (data.clone());
		this.listeners = new ArrayList<ChangeListener>();
		this.turn = true; // starts at player 1's turn
		this.isUndoAllowed = false;
		this.undoCounterA = 0;
		this.undoCounterB = 0;
		this.freeTurn = false;
		this.isNoStoneInAsPits = true;
		this.isGameFinished = false;
	}

	/**
	 * This method returns the ArrayList of Integer that contains the number of
	 * stones in each pits.
	 * <p>
	 * Precondition: N/A
	 * 
	 * @return ArrayList of Integer which contains the number of stones in each
	 *         pits.
	 *         <p>
	 *         Postcondition: N/A
	 */
	public ArrayList<Integer> getData() { // accessor
		return (ArrayList<Integer>) (data.clone());
	}

	/**
	 * This method add the ChangeListener passed by the parameter to the
	 * ArrayList of ChagneListener.
	 * 
	 * @param c
	 *            ChangeListener that is from the caller.
	 *            <p>
	 *            Precondition: N/A
	 *            <p>
	 *            Postcondition: ChangeListener is added to the ArrayList of
	 *            ChangeListner.
	 */
	public void attach(ChangeListener c) {
		listeners.add(c);
	}

	/**
	 * This method is used to initialize the data ArrayList. This method should
	 * not be invoked during the game is being played.
	 * 
	 * @param a
	 *            ArrayList of Integer. The data ArrayList of this class is
	 *            replaced by the new ArrayList passed by the parameter.
	 *            ChangeListener that is from the caller.
	 *            <p>
	 *            Precondition: This method is to be invoked only before players
	 *            start the game or after the player ends the game
	 *            <p>
	 *            Postcondition: The data ArrayList is replaced by the new
	 *            ArrayList passed by parameter.
	 */
	public void setInitialArrayList(ArrayList<Integer> a) {
		this.data = a;
		this.dataPreviouse = a;
		for (ChangeListener l : listeners) {
			l.stateChanged(new ChangeEvent(this));
		}
	}

	/**
	 * This method get the boolean representation of next player.
	 * <p>
	 * Precondition: The condition has to be in the game to get valid boolean.
	 * <p>
	 * Postcondition: The next player's turn is returned.
	 * 
	 * @return true player A is the next player. False if B is the next player.
	 */
	public boolean getNextPlayerTurn() {
		return (!turn);
	}

	/**
	 * This method does undo. Each players are allowed to unod only three times
	 * in a game. A player cannot do undo repeatedly. If A player does undo then
	 * the player has to pick the next pit. After choosing the pit, the player
	 * can do undo one more time.
	 * <p>
	 * Precondition: The condition has to be in the game to get valid boolean.
	 * <p>
	 * Postcondition: The next player's turn is returned.
	 * 
	 * @return true if undo is succeeded. False if undo is not succeeded.
	 */
	public boolean undoUpdate() {
		boolean isUndoSucceeded = false;
		// Check if undo is allowed now. == did a player pick after one undo?
		if (isUndoAllowed) {
			// determine which player just picked a pit
			if (freeTurn) {
				if (turn) { // After FreeTurn A just Picked
					if (undoCounterA < 3) { // check if B used all three undo
						data = (ArrayList<Integer>) (dataPreviouse.clone());
						undoCounterA++;
						isUndoAllowed = false;
						isUndoSucceeded = true;
					}
				} else { // After FreeTurn B just Picked
					if (undoCounterB < 3) { // check if A used all three undo
						data = (ArrayList<Integer>) (dataPreviouse.clone());
						undoCounterB++;
						isUndoAllowed = false;
						isUndoSucceeded = true;
					}
				}
			} else { // No free turn
				if (turn) { // Player B just picked and current is player A's
							// turn
					if (undoCounterB < 3) { // check if B used all three undo
						data = (ArrayList<Integer>) (dataPreviouse.clone());
						undoCounterB++;
						isUndoAllowed = false;
						isUndoSucceeded = true;
						turn = !turn;
					}
				} else { // Player A just picked and current is player B's turn
					if (undoCounterA < 3) { // check if A used all three undo
						data = (ArrayList<Integer>) (dataPreviouse.clone());
						undoCounterA++;
						isUndoAllowed = false;
						isUndoSucceeded = true;
						turn = !turn;
					}
				}
			}
			for (ChangeListener l : listeners) {
				l.stateChanged(new ChangeEvent(this));
			}
		}
		return isUndoSucceeded;
	}

	/**
	 * This method update the stones in the pits per the rule of Mancala.
	 * 
	 * @param pitNum
	 *            the index of pit
	 *              6  5  4  3  2  1<br>
	 *           7                     0<br> 
	 *              8  9  10 11 12 13<br>
	 *              <p>
	 * Precondition: The state has to be in game.
	 * <p>
	 * Postcondition: The number of stones in each pits is updated.
	 */
	public void update(int pitNum) { // mutator
		// we need to start pit #'s at 0 to be the same as the index

		// user clicked Mancala.
		// just return.
		if (pitNum == 0 || pitNum == 7)
			return;
		else if (turn == false && ((pitNum >= 8 && pitNum <= 13) || pitNum == 0))
			return;
		else if (turn == true && (pitNum >= 1 && pitNum <= 7))
			return;

		// At this point all the validation is done.
		// Keep the current data.
		this.dataPreviouse = (ArrayList<Integer>) (data.clone());

		int numOfStonesInPit = data.get(pitNum);

		int tempPitNum = pitNum + 1; // tempPitNum is the pit after the one we
										// pick up the stones from
		if (tempPitNum >= data.size())
			tempPitNum = tempPitNum % data.size();
		int tempStones;
		boolean alreadyPlayed;

		for (int i = numOfStonesInPit; i > 0;) {
			alreadyPlayed = false;

			tempStones = data.get(tempPitNum) + 1; // next pit's new numOfStones

			if (turn && tempPitNum != 7 && !alreadyPlayed) { // player1's turn &
																// next pit is
																// not player2's
																// mancala
				if (i == 1 && !alreadyPlayed) { // last stone
					if (tempPitNum == 0 && !alreadyPlayed) {// mancala
						data.set(tempPitNum, tempStones);
						turn = turn; // player gets a free turns
						freeTurn = true;
						alreadyPlayed = true;
					} // end mancala
					if (data.get(tempPitNum) == 0 && !alreadyPlayed) {// empty
						if (tempPitNum == 13) {
							data.set(0, data.get(0) + data.get(1) + 1);
							data.set(1, 0);
							alreadyPlayed = true;
						}
						if (tempPitNum == 12) {
							data.set(0, data.get(0) + data.get(2) + 1);
							data.set(2, 0);
							alreadyPlayed = true;
						}
						if (tempPitNum == 11) {
							data.set(0, data.get(0) + data.get(3) + 1);
							data.set(3, 0);
							alreadyPlayed = true;
						}
						if (tempPitNum == 10) {
							data.set(0, data.get(0) + data.get(4) + 1);
							data.set(4, 0);
							alreadyPlayed = true;
						}
						if (tempPitNum == 9) {
							data.set(0, data.get(0) + data.get(5) + 1);
							data.set(5, 0);
							alreadyPlayed = true;
						}
						if (tempPitNum == 8) {
							data.set(0, data.get(0) + data.get(6) + 1);
							data.set(6, 0);
							alreadyPlayed = true;
						}
						if (tempPitNum >= 1 && tempPitNum <= 6) {
							data.set(tempPitNum, tempStones);
							alreadyPlayed = true;
						}
						turn = !turn; // it is the next player's turn
						freeTurn = false;
					} // end empty
					if (data.get(tempPitNum) != 0 && !alreadyPlayed) { // not
																		// empty
						data.set(tempPitNum, tempStones);
						turn = !turn; // it is the next player's turn
						freeTurn = false;
					} // end not empty
				} // end last stone
				if (i != 1 && !alreadyPlayed) { // not last stone
					data.set(tempPitNum, tempStones);
					alreadyPlayed = true;
				} // end not last stone
				alreadyPlayed = true;
			}
			// end player1's turn & next pit is not player2's mancala
			// if player 1's turn and pitNum is 7 (2's mancala)
			else if (turn && tempPitNum == 7) {// beucase we skip the opponent's
												// mancala, add one back to i
				i++;
			}
			if (!turn && tempPitNum != 0 && !alreadyPlayed) { // if it is player
																// 2's turn and
																// the next pit
																// is not
																// player1's
																// manacala
				if (i == 1) { // last stone
					if (tempPitNum == 7 && !alreadyPlayed) {// mancala
						data.set(tempPitNum, tempStones);
						turn = turn; // player gets a free turn
						freeTurn = true;
						alreadyPlayed = true;

					} // end mancala
					if (data.get(tempPitNum) == 0 && !alreadyPlayed) { // empty
						if (tempPitNum == 1) { // mancala 7 is player 2
							data.set(7, data.get(7) + data.get(13) + 1);
							data.set(13, 0);
							alreadyPlayed = true;
						}
						if (tempPitNum == 2) {
							data.set(7, data.get(7) + data.get(12) + 1);
							data.set(12, 0);
							alreadyPlayed = true;
						}
						if (tempPitNum == 3) {
							data.set(7, data.get(7) + data.get(11) + 1);
							data.set(11, 0);
							alreadyPlayed = true;
						}
						if (tempPitNum == 4) {
							data.set(7, data.get(7) + data.get(10) + 1);
							data.set(10, 0);
							alreadyPlayed = true;
						}
						if (tempPitNum == 5) {
							data.set(7, data.get(7) + data.get(9) + 1);
							data.set(9, 0);
							alreadyPlayed = true;
						}
						if (tempPitNum == 6) {
							data.set(7, data.get(7) + data.get(8) + 1);
							data.set(8, 0);
							alreadyPlayed = true;
						}
						if (tempPitNum >= 8 && tempPitNum <= 13) {
							data.set(tempPitNum, tempStones);
							alreadyPlayed = true;
						}
						turn = !turn; // it is the next player's turn
						freeTurn = false;
					} // end empty
					if (data.get(tempPitNum) != 0 && !alreadyPlayed) { // not
																		// empty
						data.set(tempPitNum, tempStones);
						alreadyPlayed = true;
						turn = !turn; // it is the next player's turn
						freeTurn = false;
					} // end not empty
				} // end last stone
				if (i != 1 && !alreadyPlayed) {// not last stone
					data.set(tempPitNum, tempStones);
					alreadyPlayed = true;
				} // end not last stone
			}
			// end if it is player 2's turn and the next pit is not player1's
			// manacala
			// if 2's turn and tempPitNum is 0 (1's mancala)
			else if (!turn && tempPitNum == 0) { // beucase we skip the
													// opponent's mancala, add
													// one back to i
				i++;
			}

			tempPitNum++;
			if (tempPitNum >= data.size())
				tempPitNum = tempPitNum % data.size();

			i--;
			data.set(pitNum, i);

		} // end for loop
			// after either player picks pit its ok to undo
		isUndoAllowed = true;
		for (ChangeListener l : listeners) {
			l.stateChanged(new ChangeEvent(this));
		}

		// Validate if game end (no stone in a player's all pits)
		if (chechEndGame()) {
			moveStoneAfterGame();
			for (ChangeListener l : listeners) {
				l.stateChanged(new ChangeEvent(this));
			}
		}
	}// end update

	/**
	 * get the result of the game.
	 * <p>
	 * Precondition: The game has to be done. Not in game.
	 * <p>
	 * Postcondition: N/A
	 * @return A, B, or Draw depending on the result of the game.
	 */
	public Winner getWinner() {
		return this.winner;
	}

	/**
	 * This method validates if the game is done. That means that either all of player A or player B's pits have no stone.
	 * <p>
	 * Precondition:N/A
	 * <p>
	 * Postcondition: N/A
	 * @return true if the gome is done. False if game is not done.
	 */
	public boolean isGameDone() {
		return this.isGameFinished;
	}

	/**
	 * Private method to be called only in the class. Compare the player A'a mancala and player B's mancala and get set the winner based on the number of stones.
	 *<p>
	 * Precondition:N/A
	 * <p>
	 * Postcondition: N/A
	 */
	private void setWinner() {
		if (data.get(0) == data.get(7)) {
			this.winner = Winner.Draw;
		} else if (data.get(0) > data.get(7)) { // player A has more stones
			this.winner = Winner.A;
		} else if (data.get(0) < data.get(7)) { // player B has more stones
			this.winner = Winner.B;
		}
		this.isGameFinished = true;
	}

	/**
	 * This method is to be called by only this class. When game is done, which means that either player A's or player B's pits have not stones. 
	 *<p>
	 * Precondition:N/A
	 * <p>
	 * Postcondition: Stones are moved to a mancala per the rule of Mancala
	 */
	private void moveStoneAfterGame() {
		if (isNoStoneInAsPits) { // No stones in A's pits
			// move all B's pits (at 1 to 6) stone to the B's mancala (at 7)
			for (int i = 1; i < 7; i++) {
				data.set(7, data.get(7) + data.get(i));
				data.set(i, 0);
			}
		} else { // No stones in B's pits
			// move all A's pits (at 8 to 13) stone to the A's mancala (at 0)
			for (int i = 8; i < 14; i++) {
				data.set(0, data.get(0) + data.get(i));
				data.set(i, 0);
			}
		}
		setWinner();
	}

	/**
	 * This method checks if the game is ended or not. The game ends when either player A's or player B's pits have not stones. 
	 * <p>
	 * Precondition:N/A
	 * <p>
	 * Postcondition: N/A
	 * @return true if the game is ended. False if it is not ended.
	 */
	private boolean chechEndGame() {
		int i = 0;
		for (i = 1; i < 7; i++) {
			// if one or more of B's pits has stone
			if (data.get(i) != 0) {
				break;
			}
		}
		if (i == 7) { // for loop did not break, means all B' pits contains no
						// stone
			this.isNoStoneInAsPits = false;
			return true;
		}
		for (i = 8; i < 14; i++) {
			// if one or more of A's pits has stone
			if (data.get(i) != 0) {
				break;
			}
		}
		if (i == 14) { // for loop did not break, means all A' pits contains no
						// stone
			this.isNoStoneInAsPits = true;
			return true;
		}
		return false;
	}
}