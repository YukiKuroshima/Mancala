//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.ButtonGroup;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JRadioButton;
//
//public class OpenInterfaceFrame extends JFrame {
//	private DataModel model;
//
//	public OpenInterfaceFrame() {
//		// DataModel model = new DataModel(d);
//
//		setTitle("Pre Game Setting");
//		setSize(1000, 500);
//
//		JPanel panel = new JPanel();
//
//		JRadioButton circleStrategyButton = new JRadioButton("Circle Looking");
//		circleStrategyButton.setSelected(true);
//		JRadioButton rectangleStrategyButton = new JRadioButton("Rectangle Looking");
//
//		ButtonGroup strategyGroup = new ButtonGroup();
//		strategyGroup.add(circleStrategyButton);
//		strategyGroup.add(rectangleStrategyButton);
//
//		ButtonGroup stoneNumberGroup = new ButtonGroup();
//
//		circleStrategyButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent event) {
//				;
//			}
//		});
//
//		panel.add(circleStrategyButton);
//		panel.add(rectangleStrategyButton);
//
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setVisible(true);
//
//		// JFrame1.dispose(); //Remove JFrame 1
//		// JFrame2.setVisible(true) //Show other frame
//	}
//
//	public static void main(String[] args) {
//
//	}
//}
