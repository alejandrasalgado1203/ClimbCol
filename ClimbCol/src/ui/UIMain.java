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
		this.showPanel(UIWelcome.createUIWelcome(this),740,670);
	}

	public void showPanel(JPanel jp, int x, int y) {
		this.addPanel(jp);
		this.setSize(x, y);
		this.setVisible(true);
	}

	public void showPanel (JPanel jp) {
		this.addPanel(jp);
		this.pack();
		this.setVisible(true);
	}

	private void addPanel(JPanel jp) {
		this.setVisible(false);
		this.remove(panel);
		panel = jp;
		this.add(panel);
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

		JMenuItem menuItemUser = new JMenuItem("Use's info");
		menuBar.add(menuItemUser);
		menuItemUser.setEnabled(false);

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
					menuItemUser.setText(ClimbersManager.getCurrentUser().getName()+"'s info");
					menuItemUser.setEnabled(true);
				}

			}
		});

		menuItemLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClimbersManager.setCurrentUser(null);
				menuItemLogout.setEnabled(false);
				menuItemLogin.setEnabled(true);
				menuItemUser.setText("User's info");
				menuItemUser.setEnabled(false);
			}
		});

		menuItemUser.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				showUser();
			}
		});

		menuItemExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		this.setJMenuBar(menuBar);
	}

	protected void showUser() {
		new UIUser(this);		
	}
}
