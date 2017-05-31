//import java.awt.Graphics;
//
//import javax.management.modelmbean.ModelMBean;
//import javax.swing.JPanel;
//import javax.swing.event.ChangeEvent;
//import javax.swing.event.ChangeListener;
//
//public class TurnPanel extends JPanel implements ChangeListener {
//	private String turn;
//	DataModel modeal;
//
//	@Override
//	public TurnPanel(DataModel m) {
//		this.modeal = m;
//		this.turn = "Player A's Turn";
//	}
//
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//
//		g2.drawString(turn);
//	}
//
//	@Override
//	public void stateChanged(ChangeEvent e) {
//		if (ModelMBean.getTurn()) {
//			this.turn = "Player A's Turn";
//		} else {
//			this.turn = "Player B's Turn";
//		}
//		repaint();
//	}
//}
