//import java.awt.Component;
//import java.awt.FlowLayout;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.geom.Rectangle2D;
//
//import javax.swing.Icon;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//public class TestingStoneWithIcon extends JPanel {
//
//	private int heightOfPit;
//	private int widthOfPit;
//	private int heightOfMancala;
//	private int widthOfMancala;
//
//	public TestingStoneWithIcon() {
//		setLayout(new FlowLayout());
//		TestPitIcon p0 = new TestPitIcon(100, 100, 40);
//		JLabel l0 = new JLabel(p0);
//		add(l0);
//	}
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		JFrame frame = new JFrame();
//		frame.setTitle("DrawTest");
//		frame.setSize(400, 400);
//		// add panel to frame
//		TestingStoneWithIcon panel = new TestingStoneWithIcon();
//		frame.add(panel);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//	}
//}
//
//class TestPitIcon implements Icon {
//
//	private int height;
//	private int width;
//	private int numberOfStone;
//	private final int DIAMETER_OF_STONE = 10;
//	private final double RATIO_OF_MARGIN_BETWEEN_STONE = 1.2;
//	private final double RATIO_OF_MARGIN = 0.15;
//	private final double RATIO_OF_USED_SPACE = 0.7;
//
//	public TestPitIcon(int h, int w, int aNumberOfStone) {
//		height = h;
//		width = w;
//		numberOfStone = aNumberOfStone;
//	}
//
//	public void setNumberOfStone(int numberOfStone) {
//		this.numberOfStone = numberOfStone;
//	}
//
//	public int getHorizontalStoneLocation(int indexOfStone) {
//		// return (int) (width * 0.15 + ((indexOfStone * (DIAMETER_OF_STONE *
//		// 2)) % (width * 0.7)));
//		double totalSpace = indexOfStone * DIAMETER_OF_STONE * RATIO_OF_MARGIN_BETWEEN_STONE;
//		double divisor = width * RATIO_OF_USED_SPACE;
//		double Reminder = totalSpace % divisor;
//		double space = DIAMETER_OF_STONE * RATIO_OF_MARGIN_BETWEEN_STONE;
//
//		// System.out.println("Length: " + totalSpace + " divisor: " + divisor +
//		// " Remender: " + Reminder + " space: "
//		// + space + " Remender/space: " + (int) (Reminder / space) + "
//		// Remender/space*space: "
//		// + ((int) (Reminder / space)) * space);
//		return (int) (width * RATIO_OF_MARGIN + ((int) (Reminder / space)) * space);
//	}
//
//	public int getVerticalStoneLocation(int indexOfStone) {
//		int indexOfRow = (int) ((DIAMETER_OF_STONE * RATIO_OF_MARGIN_BETWEEN_STONE * indexOfStone)
//				/ (width * RATIO_OF_USED_SPACE));
//		// System.out.println("Row: " + (int) ((DIAMETER_OF_STONE * 2 *
//		// indexOfStone) / (width * 0.7)));
//		return (int) (height * RATIO_OF_MARGIN + indexOfRow * DIAMETER_OF_STONE * RATIO_OF_MARGIN_BETWEEN_STONE);
//	}
//
//	@Override
//	public void paintIcon(Component c, Graphics g, int x, int y) {
//		g.drawOval(x, y, height, width);
//		// Graphics2D g2 = (Graphics2D) g;
//		// Rectangle2D rect = new Rectangle2D.Double(x, y, width, height);
//		// g2.draw(rect);
//		for (int i = 0; i < numberOfStone; i++) {
//			// System.out.println("X: " + getHorizontalStoneLocation(i) + " Y: "
//			// + getVerticalStoneLocation(i));
//			g.fillOval(getHorizontalStoneLocation(i), getVerticalStoneLocation(i), DIAMETER_OF_STONE,
//					DIAMETER_OF_STONE);
//		}
//	}
//
//	@Override
//	public int getIconWidth() {
//		return width;
//	}
//
//	@Override
//	public int getIconHeight() {
//		return height;
//	}
//
//}
