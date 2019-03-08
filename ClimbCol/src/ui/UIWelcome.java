
package ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import business.ClimbColManager;
import data.Park;
import data.Route;

public class UIWelcome extends JPanel{
	private UIMain uiMain;
	private GridBagConstraints constraints = new GridBagConstraints();

	public static UIWelcome createUIWelcome(UIMain main){
		return new UIWelcome(main);
	}

	public UIWelcome(UIMain main){
		super(new GridBagLayout());
		this.uiMain = main;
		this.setupPanel();
	}

	private void setupPanel(){
		createPanelWelcome();
		createScrollPane();
		createTipsPanel();
	}

	private void createPanelWelcome () {
		JPanel panelWelcome = new JPanel(new GridLayout(0,1));
		JLabel lblWelcome = new JLabel("Welcome to CLIMBCOL");
		lblWelcome.setFont(new Font("Tahoma",Font.PLAIN,35));
		JPanel jp1 = new JPanel();
		jp1.add(lblWelcome);
		panelWelcome.add(jp1);

		JLabel lblDescription = new JLabel("The best aplication to Colombian and international"
				+ " Climbers");
		lblDescription.setFont(new Font("Tahoma",Font.PLAIN,20));
		jp1 = new JPanel();
		jp1.add(lblDescription);
		panelWelcome.add(jp1);

		DefaultComboBoxModel<Route> model = new DefaultComboBoxModel<>();
		ArrayList<Route> rutes = ClimbColManager.getAllRoutes();
		for(Route r : rutes) {
			model.addElement(r);
		}
		JComboBox <Route> cBoxRutes = new JComboBox <Route> (model);
		cBoxRutes.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				JComboBox <Route> cb = (JComboBox<Route>) e.getSource();
				uiMain.showPanel(UIRoute.createUIRute((Route) cb.getSelectedItem(), uiMain));
			}			
		});
		panelWelcome.add(cBoxRutes);

		this.constraints.gridwidth = 2;	
		this.addGB(panelWelcome,0,0);

	}

	private void createScrollPane() {
		DefaultListModel<Park> model = new DefaultListModel<>();
		for (Park park : ClimbColManager.getParks()) {
			model.addElement(park);
		}
		JList <Park> listParks = new JList <Park> (model);
		listParks.setCellRenderer(new Renderer());
		JScrollPane scrollPaneParks = new JScrollPane(listParks);
		scrollPaneParks.setMinimumSize(new Dimension(300,400));

		listParks.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				uiMain.showPanel(UIPark.createUIPark(listParks.getSelectedValue(), uiMain),730,670);	
			}
		});

		this.constraints.gridwidth = 1;
		this.constraints.gridheight = 1;
		this.constraints.insets = new Insets(10,20,0,20);
		this.addGB(scrollPaneParks, 0, 1);
	}

	private void createTipsPanel() {
		JPanel tips = new JPanel(new GridLayout(0,1));

		JLabel labelTipsImage1 = new JLabel(new ImageIcon("images/Tips.jpg"));
		tips.add(labelTipsImage1);
		this.addGB(tips, 1, 1);
	}

	private void addGB(Component comp, int x, int y) {
		this.constraints.gridx = x;
		this.constraints.gridy = y;
		this.add(comp, this.constraints);
	}
}
