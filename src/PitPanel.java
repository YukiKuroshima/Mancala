//import java.awt.FlowLayout;
//import java.util.ArrayList;
//
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.event.ChangeEvent;
//import javax.swing.event.ChangeListener;
//
//public class PitPanel extends JPanel implements ChangeListener {
//	private DataModel model;
//	private int indexOfPit;
//
//	public PitPanel(DataModel m, int indexOfPit) {
//		this.model = m;
//		this.indexOfPit = indexOfPit;
//	}
//
//	@Override
//	public void stateChanged(ChangeEvent e) {
//		
//		repaint();
//	}
//
//	public static void main(String[] args) {
//		ArrayList<Double> d = new ArrayList<>();
//		for (int i = 0; i < 14; i++) {
//			d.add(4.0);
//		}
//		DataModel model = new DataModel(d);
//
//		JFrame frame = new JFrame();
//		frame.setTitle("PitPanel");
//		frame.setSize(400, 400);
//		// add panel to frame
//		JPanel panel = new JPanel();
//		panel.setLayout(new FlowLayout());
//		PitPanel pitPanel = new PitPanel(model, 0);
//		PitIcon p0 = new PitIcon(100, 100, 40);
//		JLabel l0 = new JLabel(p0);
//		pitPanel.add(l0);
//		panel.add(pitPanel);
//		frame.add(panel);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//	}
//}
