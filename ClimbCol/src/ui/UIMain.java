package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class UIMain extends JFrame{

	private JPanel panel;

	public UIMain() {
		super("CLIMBCOL");
		this.panel = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.createMenuBarWelcome();
		this.showPanel(UIWelcome.createUIWelcome(this),850,750);
	}

	public void showPanel(JPanel createUIWelcome, int x, int y) {
		this.showPanel(createUIWelcome);
		this.setSize(x, y);
	}

	public void showPanel (JPanel jp) {
		this.remove(panel);
		panel = jp;
		this.add(panel);
		this.pack();
		this.setVisible(true);
	}

	public void createMenuBarWelcome(){
		JMenuBar menuBar = new JMenuBar();

		JMenuItem menuItemInfo = new JMenuItem("Information User");
		menuBar.add(menuItemInfo);

		JMenuItem menuItemSignIn = new JMenuItem("Sign in");
		menuBar.add(menuItemSignIn);

		JMenuItem menuItemExit = new JMenuItem("Exit");
		menuBar.add(menuItemExit);

		menuItemInfo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

			}
		});

		menuItemSignIn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

			}
		});

		menuItemExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		this.setJMenuBar(menuBar);
	}
}
