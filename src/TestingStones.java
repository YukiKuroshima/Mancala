//import java.awt.Component;
//import java.awt.FlowLayout;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.geom.Ellipse2D;
//import java.awt.geom.Rectangle2D;
//
//import javax.swing.Icon;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.event.ChangeEvent;
//import javax.swing.event.ChangeListener;
//
//public class TestingStones extends JPanel implements ChangeListener {
//	public static final int DEFAULT_WIDTH = 400;
//	public static final int DEFAULT_HEIGHT = 400;
//	private StoneIcon i1;
//	private JLabel l1;
//	private int numberOfStones;
//
//	public TestingStones(int numberOfStones) {
//		this.numberOfStones = numberOfStones;
//		setLayout(new FlowLayout());
//
//		StoneIcon i1 = new StoneIcon();
//		JLabel l1 = new JLabel(i1);
//
//		add(l1);
//
//	}
//
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		Graphics2D g2 = (Graphics2D) g;
//		// draw a rectangle
//		double leftX = 100;
//		double topY = 100;
//		double width = 200;
//		double height = 200;
//		Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
//		// g2.draw(rect);
//		// draw the enclosed ellipse
//		Ellipse2D ellipse = new Ellipse2D.Double();
//		ellipse.setFrame(rect);
//		g2.draw(ellipse);
//	}
//
//	@Override
//	public void stateChanged(ChangeEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		JFrame frame = new JFrame();
//		frame.setTitle("DrawTest");
//		frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
//		// add panel to frame
//		TestingStones panel = new TestingStones(1);
//		frame.add(panel);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//	}
//}
//
//class StoneIcon implements Icon {
//
//	@Override
//	public void paintIcon(Component c, Graphics g, int x, int y) {
//		g.fillOval(0, 0, 1000, 10000);
//		//g.drawOval(0, 0, 1000, 1000);
//
//	}
//
//	@Override
//	public int getIconWidth() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int getIconHeight() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//}
//
////class BorderIcon implements Icon {
////
////	@Override
////	public void paintIcon(Component c, Graphics g, int x, int y) {
////		// TODO Auto-generated method stub
////		Graphics2D g2 = (Graphics2D) g;
////		// draw a rectangle
////		double leftX = 100;
////		double topY = 100;
////		double width = 200;
////		double height = 200;
////		Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
////		// g2.draw(rect);
////		// draw the enclosed ellipse
////		Ellipse2D ellipse = new Ellipse2D.Double();
////		ellipse.setFrame(rect);
////		g2.draw(ellipse);
////	}
////
////	@Override
////	public int getIconWidth() {
////		// TODO Auto-generated method stub
////		return 0;
////	}
////
////	@Override
////	public int getIconHeight() {
////		// TODO Auto-generated method stub
////		return 0;
////	}
////
////}
