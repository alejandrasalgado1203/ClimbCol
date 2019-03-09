package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.Insets;
import data.Route;
import data.Zone;

public class UIZone extends JPanel {
        private GridBagConstraints constraints = new GridBagConstraints();
	private Zone zone;
	private UIMain uiMain;

	public static  UIZone createUIZone(Zone zone,UIMain main){
            return new UIZone(zone,main);
	}
	public UIZone(Zone zone, UIMain main) {
                this.constraints.insets = new Insets(15,15,15,15);
		this.zone = zone;
		this.uiMain = main;
		this.setLayout(new GridBagLayout());
		this.setupMainPanel();
	}

	private void setupMainPanel() {
		createTittle();
		createScrollPane();
		createImage();
		createDescription();
		goToLastAndNextPanel();
	}

	private void createTittle() {
		JPanel tittle = new JPanel(new GridLayout(0,1));
		JLabel lblNameZone = new JLabel("Zone "+ this.zone.getName());
		lblNameZone.setFont(new Font("Tahoma",Font.PLAIN,35));
		tittle.add(lblNameZone);
		this.constraints.gridwidth = 2;
                this.addGB(tittle,0,0);
	}

	private void createImage() {
                JPanel image = new JPanel(new GridLayout(0,1));
		ImageIcon zoneImage= new ImageIcon(zone.getMainImage());
		JLabel labelImage = new JLabel(zoneImage);
		image.add(labelImage);
                this.constraints.gridwidth = 1;
                this.constraints.gridheight = 1;
                this.addGB(image,1,1);
	}
	private void createDescription() {
		JPanel infoPanel = new JPanel(new GridLayout(0,1));

		JLabel lbl = new JLabel("Max Difficulty: " + zone.getMaxDifficulty());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);
                
		lbl = new JLabel("Min Difficulty: " + zone.getMinDifficulty());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);

		lbl = new JLabel("Average Difficulty: " + zone.getAverageDifficulty());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);

		lbl = new JLabel("Number of Routes: " + zone.getRoutes().size());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);
                
                this.constraints.gridwidth = 1;
                this.constraints.gridheight = 1;
                this.addGB(infoPanel,1,2);
	}

	private void createScrollPane() {

		DefaultListModel<Route> model = new DefaultListModel<>();
		for (Route rute : zone.getRoutes()) {
			model.addElement(rute);
		}

		JList <Route> listRoutes = new JList <Route> (model);
		listRoutes.setCellRenderer(new Renderer());
		JScrollPane scrollPaneRoutes = new JScrollPane(listRoutes);
                scrollPaneRoutes.setMinimumSize(new Dimension(300,400));

                this.constraints.gridwidth = 1;
                this.constraints.gridheight = 2;
		this.addGB(scrollPaneRoutes,0,1);

		listRoutes.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				uiMain.showPanel(UIRoute.createUIRute(listRoutes.getSelectedValue(), uiMain),730,680);	
			}
		});
	}
	private void goToLastAndNextPanel() {
            
		JButton b1=new JButton("Return to Welcome");  
		b1.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				uiMain.showPanel(UIWelcome.createUIWelcome(uiMain),730,670);
			}  
		});

		JButton b2=new JButton("Return to Park");  
		b2.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
                        uiMain.showPanel(UIPark.createUIPark(zone.getPark(),uiMain),730,670);
			}  
		});

		this.constraints.gridwidth = 1;
		this.addGB(b1,0,3);
                this.addGB(b2,1,3);
	}
        
        private void addGB(Component comp, int x, int y) {
		this.constraints.gridx = x;
		this.constraints.gridy = y;
		this.add(comp, this.constraints);
	}

}
