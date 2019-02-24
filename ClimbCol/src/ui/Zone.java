
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Zone {
	private static JPanel panelRutes = new JPanel ();
    private static JPanel centerPanel = new JPanel();
	private static JFrame frame = new JFrame ("CLIMBCOL");

	public static void setupMainPanel(String nameZone) {
		createTittle(nameZone);
		createScrollPane();
		createDescription();
	}
	
	public static void createTittle(String nameZone) {
		JPanel tittle = new JPanel();
		JLabel lblWelcomeZone = new JLabel("ZONA "+ nameZone);
        lblWelcomeZone.setFont(new Font("Tahoma",Font.PLAIN,35));
        tittle.add(lblWelcomeZone);
        frame.add(tittle,BorderLayout.NORTH);
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
	
public static void createScrollPane() {
    	
    	JPanel scrollPane = new JPanel();
    	JScrollPane scrollPaneZones = new JScrollPane (panelRutes,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    	scrollPaneZones.setPreferredSize(new Dimension(350, 250));
    	panelRutes.setLayout(new GridLayout(4,1));
    	scrollPane.add(scrollPaneZones);
    	centerPanel.add(scrollPane,new FlowLayout());
    	frame.add(centerPanel,BorderLayout.CENTER);
    	
    	JButton buttonRute1 = new JButton("Ruta 1");
        buttonRute1.setForeground(Color.BLACK);
        buttonRute1.setBackground(Color.WHITE);
        panelRutes.add(buttonRute1);
        
        JButton buttonRute2 = new JButton("Ruta 2");
        buttonRute2.setForeground(Color.BLACK);
        buttonRute2.setBackground(Color.WHITE);
        panelRutes.add(buttonRute2);
        
        JButton buttonRute3 = new JButton("Ruta 3");
        buttonRute3.setForeground(Color.BLACK);
        buttonRute3.setBackground(Color.WHITE);
        panelRutes.add(buttonRute3);
        
        JButton buttonRute4 = new JButton("Ruta 4");
        buttonRute4.setForeground(Color.BLACK);
        buttonRute4.setBackground(Color.WHITE);
        panelRutes.add(buttonRute4);
        
        buttonRute1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	Rute.showPanelRute();
            }
        });
        
        buttonRute2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	Rute.showPanelRute();
            }
        });
        
        buttonRute3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	Rute.showPanelRute();
            }
        });
        
        buttonRute4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	Rute.showPanelRute();
            }
        });
    }
    
    public static void showPanelZone() {
    	frame.setTitle("CLIMBCOL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,900);
        frame.setResizable(true);
        frame.setVisible(true);
        setupMainPanel(" ");
        frame.pack();
    }
}
