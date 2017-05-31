//import java.awt.FlowLayout;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.geom.Ellipse2D;
//import java.awt.geom.Rectangle2D;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//class StoneJPanel extends JPanel {
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		g.fillOval(35, 45, 10, 10);
//		// Graphics2D g2 = (Graphics2D) g;
//		System.out.println("In PC of StoneJpanel");
//		
//
//	}
//}
//
//public class TestingStoneJPanel extends JPanel {
//
//	private int numberOfStone;
//
//	public TestingStoneJPanel(int n) {
//		numberOfStone = n;
//		setLayout(new FlowLayout());
//		StoneJPanel s1 = new StoneJPanel();
//		add(s1);
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
//		//Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
//		// g2.draw(rect);
//		// draw the enclosed ellipse
//		//Ellipse2D ellipse = new Ellipse2D.Double();
//		//ellipse.setFrame(rect);
//		//g2.draw(ellipse);
//		//g.fillOval(35, 45, 10, 10);
//		g.drawOval(35, 45, 100, 100);
//		System.out.println("In PC of Super");
//	}
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		JFrame frame = new JFrame();
//		frame.setTitle("DrawTest");
//		frame.setSize(400, 400);
//		// add panel to frame
//		TestingStoneJPanel panel = new TestingStoneJPanel(1);
//		frame.add(panel);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//	}
//
//}
