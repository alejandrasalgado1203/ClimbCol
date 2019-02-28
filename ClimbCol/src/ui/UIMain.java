package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class UIMain {

	private JFrame frame;
	private JPanel panel = new JPanel();
	
	public static void main(String[] args) {
		new UIMain();	
	}

	public UIMain() {
		frame = new JFrame("CLIMBCOL");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.showPanel(UIWelcome.creatRBE(this));
	}
	
	public void showPanel (JPanel jp) {
		frame.remove(panel);
		panel = jp;
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

}
