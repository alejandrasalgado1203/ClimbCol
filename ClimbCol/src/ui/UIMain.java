package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import business.ClimbersManager;

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

		JMenuItem menuItemSignIn = new JMenuItem("Sign in");
		menuBar.add(menuItemSignIn);

		JMenuItem menuItemLogin = new JMenuItem("Login");
		menuBar.add(menuItemLogin);

		JMenuItem menuItemLogout = new JMenuItem("Logout");
		menuBar.add(menuItemLogout);
		menuItemLogout.setEnabled(false);

		JMenuItem menuItemExit = new JMenuItem("Exit");
		menuBar.add(menuItemExit);

		menuItemSignIn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				UIUser.showSignInFrame();
			}
		});

		menuItemLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				UIUser.showLoginFrame();
				if(ClimbersManager.getCurrentUser()!=null) {
					menuItemLogin.setEnabled(false);
					menuItemLogout.setEnabled(true);
				}

			}
		});

		menuItemLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClimbersManager.setCurrentUser(null);
				menuItemLogout.setEnabled(false);
				menuItemLogin.setEnabled(true);
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
