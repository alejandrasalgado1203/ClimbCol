
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

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
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
import data.Parque;

public class UIWelcome extends JPanel{
	private Box mainBox;
	private Box centerBox;
	private UIMain uiMain;

	public static UIWelcome createUIWelcome(UIMain main){
		return new UIWelcome(main);
	}

	public UIWelcome(UIMain main){
		super();
		this.uiMain = main;
		this.mainBox = Box.createVerticalBox();
		this.mainBox.add(Box.createVerticalStrut(20));
		this.centerBox = Box.createHorizontalBox();
		this.centerBox.add(Box.createHorizontalStrut(40));
		setupMainBox();
		this.mainBox.add(centerBox);
		this.mainBox.add(Box.createVerticalStrut(40));
		
		this.add(mainBox);
	}

	public void setupMainBox(){
		createPanelWelcome();
		createScrollPane();
		createTipsVideoPane();
	}

	public void createPanelWelcome () {
		JPanel panelWelcome = new JPanel(new GridLayout(3,1));
		JLabel lblWelcome = new JLabel("Welcome to CLIMBCOL");
		lblWelcome.setFont(new Font("Tahoma",Font.PLAIN,35));
		JPanel jp1 = new JPanel();
		jp1.add(lblWelcome);
		panelWelcome.add(jp1);

		JLabel lblDescription = new JLabel("The best aplication to Colombian and international Climbers");
		lblDescription.setFont(new Font("Tahoma",Font.PLAIN,20));
		jp1 = new JPanel();
		jp1.add(lblDescription);
		panelWelcome.add(jp1);

		/*final JComboBox<String> cbox = new JComboBox<String>();// agregar listener
		ArrayList<String> rutes = ClimbColManager.getAllRutes();
		for(String s : rutes)
			cbox.addItem(s);
		cbox.setEditable(true);
		panelWelcome.add(cbox);*/

		this.mainBox.add(panelWelcome);
		this.mainBox.add(Box.createVerticalStrut(20));
	}

	public void createScrollPane() {
		DefaultListModel<Parque> model = new DefaultListModel<>();
		for (Parque park : ClimbColManager.getParks().values()) {
			model.addElement(park);
		}
		JList <Parque> listParks = new JList <Parque> (model);
		listParks.setCellRenderer(new ParkRenderer());
		JScrollPane scrollPaneParks = new JScrollPane(listParks);

		centerBox.add(scrollPaneParks);
		centerBox.add(Box.createHorizontalStrut(30));
		
		listParks.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				Parque park = ClimbColManager.getPark((listParks.getSelectedValue().getName()));
				uiMain.showPanel(UIPark.createUIPark(park, uiMain));	
			}
		});
	}


	public void createTipsVideoPane() {
		JPanel tipsVideo = new JPanel();
		tipsVideo.setLayout(new GridLayout(2,1));

		ImageIcon Tips= new ImageIcon("images/2.jpg");
		JLabel labelTips = new JLabel(Tips);
		labelTips.setVisible(true);
		labelTips.setSize(new Dimension(2,2));
		tipsVideo.add(labelTips);

		ImageIcon Video= new ImageIcon("images/3.jpg");
		JLabel labelVideo = new JLabel(Video);
		labelVideo.setVisible(true);
		tipsVideo.add(labelVideo);
		centerBox.add(tipsVideo);
		centerBox.add(Box.createHorizontalStrut(40));
	}
}
