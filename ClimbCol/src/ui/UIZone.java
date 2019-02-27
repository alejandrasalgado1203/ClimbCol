
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import business.ClimbColManager;

public class UIZone extends JPanel {
	private static JPanel panelRutes = new JPanel ();
    private static JPanel centerPanel = new JPanel();
    private ClimbColManager climbcolManager;
    private UIWelcome welcome;

	public UIZone(Object zone) {
		showPanelZone();
		this.climbcolManager = climbcolManager;
	}

	public void setupMainPanel(String nameZone) {
		createTittle(nameZone);
		createScrollPane();
		createDescription();
	}
	
	public void createTittle(String nameZone) {
		JPanel tittle = new JPanel();
		JLabel lblWelcomeZone = new JLabel("ZONA "+ nameZone);
        lblWelcomeZone.setFont(new Font("Tahoma",Font.PLAIN,35));
        tittle.add(lblWelcomeZone);
        this.add(tittle,BorderLayout.NORTH);
	}
	
	public static void createDescription() {
    	JPanel description = new JPanel();
    	description.setLayout(new GridLayout(2,1));
    	centerPanel.add(description,new FlowLayout());
    	
    	ImageIcon Zone= new ImageIcon("images\\4.jpg");
        JLabel labelImage = new JLabel(Zone);
		labelImage.setVisible(true);
		description.add(labelImage);
        
		JTextField textDescription = new JTextField(30);
		description.add(textDescription);
    }
	
public void createScrollPane() {
    	
	JList listRutes = new JList(climbcolManager.getZonesNames());
	JScrollPane scrollPaneRutes = new JScrollPane(listRutes);
	
	centerPanel.add(scrollPaneRutes,new FlowLayout());
	this.add(centerPanel,BorderLayout.CENTER);
    
    listRutes.addListSelectionListener(new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent arg0) {
			panelRutes = new UIZone(climbcolManager.getZone(arg0.getSource()));
			showPanelZone();
		}
    });
    }
    
    public void showPanelZone() {
        this.setSize(900,900);
        this.setVisible(true);
        setupMainPanel(" ");
    }
}
