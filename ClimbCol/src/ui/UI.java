
package ui;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class UI extends JFrame{
    private JPanel mainPanel;
    private JPanel panelWelcome;
    private JPanel panelPark;
    private JPanel panelZone;
    private JPanel panelRute;
    private JPanel panelFavorites;
    private JPanel panelGoals;
    
    //crear clases por cada panel
    // mirar windows builder
    public UI() {

        this.setTitle("CLIMBCOL");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(400,200);
        this.setResizable(true);
        this.mainPanel = new JPanel();
        this.mainPanel.setBorder(new EmptyBorder(10,10,10,10));
        this.mainPanel.setLayout(new CardLayout(0,0));// aprender esto
        this.setContentPane(mainPanel);
        initComponents("HOLA","HOLA","HOLA");// diego tarea
        this.setVisible(true);
    }
    
    private void initComponents(String namePark,String nameZone,String nameRute) {
        this.setupPanelWelcome();
        this.setupPanelPark(namePark);
        this.setupPanelZone(nameZone);
        this.setupPanelRute(nameRute);
        this.setupPanelFavorites();
        this.setupPanelGoals();
    }
    
    public void setupPanelWelcome(){
        this.panelWelcome = new JPanel();// mirar otro tipo de panel
		
        JLabel lblWelcome = new JLabel("Welcome to CLIMBCOL");
        lblWelcome.setFont(new Font("Tahoma",Font.PLAIN,35));
        this.panelWelcome.add(lblWelcome);
        
        JLabel lblDescription = new JLabel("The best aplication to Colombian and international Climbers");
        lblDescription.setFont(new Font("Tahoma",Font.PLAIN,20));
        this.panelWelcome.add(lblDescription);
        
        createMenuBarWelcome();
        
        JButton buttonPark1 = new JButton("Parque 1");
        buttonPark1.setForeground(Color.BLACK);
	    buttonPark1.setBackground(Color.WHITE);
        this.panelWelcome.add(buttonPark1);
        
        JButton buttonPark2 = new JButton("Parque 2");
        buttonPark1.setForeground(Color.BLACK);
	    buttonPark1.setBackground(Color.WHITE);
        this.panelWelcome.add(buttonPark1);
        
        JButton buttonPark3 = new JButton("Parque 3");
        buttonPark1.setForeground(Color.BLACK);
	    buttonPark1.setBackground(Color.WHITE);
        this.panelWelcome.add(buttonPark1);
        
        JButton buttonPark4 = new JButton("Parque 4");
        buttonPark1.setForeground(Color.BLACK);
	    buttonPark1.setBackground(Color.WHITE);
        this.panelWelcome.add(buttonPark1);
        
        buttonPark1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    remove(panelWelcome);
                    showPanelPark();
            }
        });
        
    }
    
    public void showMenu() {
	this.setSize(450,200);
        this.add(this.panelWelcome);
    }
    
    public void createMenuBarWelcome(){
        JMenuBar menuBar = new JMenuBar();
        this.panelWelcome.add(menuBar);
 
 
        JMenuItem menuItemInfo = new JMenuItem("Information User",KeyEvent.VK_T);
        menuItemInfo.setMnemonic(KeyEvent.VK_A);
        menuBar.add(menuItemInfo);
        
        JMenuItem menuItemSignIn = new JMenuItem("Sign in",KeyEvent.VK_T);
        menuItemSignIn.setMnemonic(KeyEvent.VK_A);
        menuBar.add(menuItemSignIn);
        
        JMenuItem menuItemExit = new JMenuItem("Exit",KeyEvent.VK_T);
        menuItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuBar.add(menuItemExit);
        
        this.setJMenuBar(menuBar);
    }
    
    public void setupPanelPark(String namePark){
        this.panelPark = new JPanel();
        this.panelPark.setLayout(new GridLayout(8,1));
		
        JLabel lblWelcomePark = new JLabel("PARQUE "+ namePark);
        lblWelcomePark.setFont(new Font("Tahoma",Font.PLAIN,35));
        this.panelPark.add(lblWelcomePark);
        
        JButton buttonZone1 = new JButton("Zona 1");
        buttonZone1.setForeground(Color.BLACK);
	buttonZone1.setBackground(Color.WHITE);
        this.panelPark.add(buttonZone1);
        
        JButton buttonZone2 = new JButton("Zona 2");
        JButton buttonZone3 = new JButton("Zona 3");
        JButton buttonZone4 = new JButton("Zona 4");
        
        buttonZone1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    remove(panelPark);
                    showPanelZone();
            }
        });
        
    }
    
    public void showPanelPark() {
        this.add(this.panelPark);
        this.pack();
    }
    
    public void setupPanelZone(String nameZone){
        this.panelZone = new JPanel();
        this.panelZone.setLayout(new GridLayout(8,1));
		
        JLabel lblWelcomeZone = new JLabel("ZONA "+ nameZone);
        lblWelcomeZone.setFont(new Font("Tahoma",Font.PLAIN,35));
        this.panelZone.add(lblWelcomeZone);
        
    }
    
    public void showPanelZone() {
        this.add(this.panelZone);
        this.pack();
    }
    
    public void setupPanelRute(String nameRute) {
    	this.panelZone = new JPanel();
        this.panelZone.setLayout(new GridLayout(8,1));
		
        JLabel lblWelcomeRute = new JLabel("RUTA "+ nameRute);
        lblWelcomeRute.setFont(new Font("Tahoma",Font.PLAIN,35));
        this.panelZone.add(lblWelcomeRute);
    }
    
    public void setupPanelFavorites(){
        
    }
    
    public void setupPanelGoals(){
        
    }
    
}
