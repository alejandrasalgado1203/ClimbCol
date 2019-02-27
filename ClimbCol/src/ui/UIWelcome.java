
package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import business.ClimbColManager;
import business.ClimbersManager;
import data.Escalador;

public class UIWelcome extends JFrame{
	private JPanel panelWelcome;
	private UIPark panelParks;
	private JPanel panelRutes;
	private UIZone panelZones;
	private JPanel centerPanel;
	private JPanel panelSignIn;
	private UIUser user = new UIUser();

	public UIWelcome() throws HeadlessException {
		super();
	}

	public void createTipsVideoPane() {
		JPanel tipsVideo = new JPanel();
		tipsVideo.setLayout(new GridLayout(2,1));
		centerPanel.add(tipsVideo,new FlowLayout());

		ImageIcon Tips= new ImageIcon("images/2.jpg");
		JLabel labelTips = new JLabel(Tips);
		labelTips.setVisible(true);
		labelTips.setSize(new Dimension(2,2));
		tipsVideo.add(labelTips);

		ImageIcon Video= new ImageIcon("images/3.jpg");
		JLabel labelVideo = new JLabel(Video);
		labelVideo.setVisible(true);
		tipsVideo.add(labelVideo);

	}

	public void createScrollPane() {

		JList listParks = new JList(ClimbColManager.getParksNames());
		JScrollPane scrollPaneParks = new JScrollPane(listParks);

		centerPanel.add(scrollPaneParks,new FlowLayout());
		this.add(centerPanel,BorderLayout.CENTER);

		listParks.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				panelParks = new UIPark(ClimbColManager.getPark(arg0.getSource()));
				showPanelPark();
			}
		});
	}
	public void showPanelPark() {
		remove(panelWelcome);
		remove(centerPanel);
		remove(panelParks);
		this.add(panelParks);
		this.pack();
	}

	public void showPanel(UIZone panelZones) {
		remove(panelWelcome);
		remove(centerPanel);
		remove(panelParks);
		this.add(panelZones);
		this.pack();

	}

	public void createPanelWelcome () {
		panelWelcome.setLayout(new GridLayout(3,1));
		this.add(panelWelcome,BorderLayout.NORTH);

		JLabel lblWelcome = new JLabel("              Welcome to CLIMBCOL");
		lblWelcome.setFont(new Font("Tahoma",Font.PLAIN,35));
		panelWelcome.add(lblWelcome);

		JLabel lblDescription = new JLabel("      The best aplication to Colombian and international Climbers");
		lblDescription.setFont(new Font("Tahoma",Font.PLAIN,20));
		panelWelcome.add(lblDescription);

		final JComboBox<String> cbox = new JComboBox<String>();// agregar listener
		ArrayList<String> rutes = ClimbColManager.getAllRutes();
		for(String s : rutes)
			cbox.addItem(s);
		cbox.setEditable(true);
		panelWelcome.add(cbox);

	}
	public void createMenuBarWelcome(){
		JMenuBar menuBar = new JMenuBar();
		this.add(menuBar);

		JMenuItem menuItemInfo = new JMenuItem("Information User");
		menuBar.add(menuItemInfo);

		JMenuItem menuItemSignIn = new JMenuItem("Sign in");
		menuBar.add(menuItemSignIn);

		JMenuItem menuItemExit = new JMenuItem("Exit");
		menuBar.add(menuItemExit);

		menuItemInfo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				UIUser.showPanelUser();
			}
		});

		menuItemSignIn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				remove(panelWelcome);
				remove(centerPanel);
				remove(panelParks);
				remove(menuBar);// arreglar
				showPanelAdd();
			}
		});

		menuItemExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		this.setJMenuBar(menuBar);
	}

	private void setupPanelAdd() {
		JLabel nameLabel= new JLabel("User: ");
		JLabel passwordLabel = new JLabel ("Password: ");;
		JTextField nameField =  new JTextField();
		nameField.setColumns(25);
		JTextField passwordField = new JTextField();
		passwordField.setColumns(25);
		JPanel userPane = new JPanel();
		JPanel passwordPane = new JPanel();
		JPanel panelAddUser = new JPanel(new GridLayout(0,1));

		JLabel lblAdd = new JLabel ("Sign in");
		lblAdd.setFont(new Font("Tahoma",Font.PLAIN,25));
		panelAddUser.add(lblAdd);

		userPane.add(nameLabel);
		userPane.add(nameField);
		passwordPane.add(passwordLabel);
		passwordPane.add(passwordField);

		panelAddUser.add(userPane);
		panelAddUser.add(passwordPane);

		JButton btnSend = new JButton ("Send");
		panelAddUser.add(btnSend);

		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(nameField.getText().equals("")|| passwordField.getText().equals("") ) {
					indicateSpaceEmpty();	
					Escalador es = new Escalador (nameField.getText(),passwordField.getText());
					ClimbersManager.put(es);
				}
				passwordField.setText("");
				nameField.setText("");
				remove(panelAddUser);
				showAll();
			}
		});

		panelSignIn.add(panelAddUser);
		this.add(panelSignIn);
	}
	public void showPanelAdd() {
		this.setTitle("CLIMBCOL");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		setupPanelAdd();
		this.pack();
		this.setVisible(true);
	}
	public void indicateSpaceEmpty() {
		JOptionPane.showMessageDialog(this,"A space is Empty");
	}

	public void setupMainPanel(){
		createMenuBarWelcome();
		createPanelWelcome();
		createScrollPane();
		createTipsVideoPane();
	}
	public void showAll() {
		this.setTitle("CLIMBCOL");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		setupMainPanel();
		this.pack();
		this.setVisible(true);
	}

}
