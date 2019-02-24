
package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

public class Welcome{
	private static JPanel panelWelcome = new JPanel ();
	private static JPanel panelParks = new JPanel ();
    private JPanel mainPanel = new JPanel();
    private static Park park = new Park();
    private static Zone zone = new Zone();
    private static Rute rute = new Rute();
    private static User user = new User();
    private static JFrame frame = new JFrame ("CLIMBCOL");
    
    public void setupMainPanel(){// mirar otro tipo de panel
		
        createMenuBarWelcome();
        createPanelWelcome();
        createScrollPane();
        
        final JComboBox<String> cbox = new JComboBox<String>();// corregir tipos segun logica
        ArrayList<String> rutes = new ArrayList<String>();
		for(String s : rutes)
			cbox.addItem(s);
		mainPanel.add(cbox);
		
		ImageIcon Tips= new ImageIcon("/Images/Diagrama.png");
        JLabel labelTips = new JLabel(Tips);
		labelTips.setVisible(true);
		mainPanel.add(labelTips);
		
		ImageIcon Video= new ImageIcon("/Images/Diagrama.png");
        JLabel labelVideo = new JLabel(Video);
		labelVideo.setVisible(true);
		mainPanel.add(labelVideo);

        
        
    }
    
    public void createScrollPane() {
    	
    	JScrollPane scrollPaneParks = new JScrollPane (panelParks);
    	scrollPaneParks.setPreferredSize(new Dimension(200, 110));
    	frame.getContentPane().add(scrollPaneParks,BorderLayout.SOUTH);
    	
    	JButton buttonPark1 = new JButton("Parque 1");
        buttonPark1.setForeground(Color.BLACK);
	    buttonPark1.setBackground(Color.WHITE);
	    ImageIcon park1 = new ImageIcon("/Images/Diagrama.png");
        panelParks.add(buttonPark1,park1);
        
        JButton buttonPark2 = new JButton("Parque 2");
        buttonPark2.setForeground(Color.BLACK);
	    buttonPark2.setBackground(Color.WHITE);
	    ImageIcon park2 = new ImageIcon("/Images/Diagrama.png");
        panelParks.add(buttonPark2,park2);
        
        JButton buttonPark3 = new JButton("Parque 3");
        buttonPark3.setForeground(Color.BLACK);
	    buttonPark3.setBackground(Color.WHITE);
	    ImageIcon park3 = new ImageIcon("/Images/Diagrama.png");
        panelParks.add(buttonPark3, park3);
        
        JButton buttonPark4 = new JButton("Parque 4");
        buttonPark4.setForeground(Color.BLACK);
	    buttonPark4.setBackground(Color.WHITE);
	    ImageIcon park4 = new ImageIcon("/Images/Diagrama.png");
        panelParks.add(buttonPark4,park4);
        
        buttonPark1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            		frame.add(park, BorderLayout.CENTER);
            }
        });
    }
    
    public void createPanelWelcome () {
    	
    	frame.add(panelWelcome,BorderLayout.CENTER);
    	
    	JLabel lblWelcome = new JLabel("Welcome to CLIMBCOL");
        lblWelcome.setFont(new Font("Tahoma",Font.PLAIN,35));
        panelWelcome.add(lblWelcome);
        
        JLabel lblDescription = new JLabel("The best aplication to Colombian and international Climbers");
        lblDescription.setFont(new Font("Tahoma",Font.PLAIN,20));
        panelWelcome.add(lblDescription);
        
    }
    public void createMenuBarWelcome(){
        JMenuBar menuBar = new JMenuBar();
        frame.add(menuBar);
        
        JMenuItem menuItemInfo = new JMenuItem("Information User",KeyEvent.VK_T);
        menuItemInfo.setMnemonic(KeyEvent.VK_A);
        menuBar.add(menuItemInfo);
        
        JMenuItem menuItemSignIn = new JMenuItem("Sign in",KeyEvent.VK_T);
        menuItemSignIn.setMnemonic(KeyEvent.VK_A);
        menuBar.add(menuItemSignIn);
        
        JMenuItem menuItemExit = new JMenuItem("Exit",KeyEvent.VK_T);
        menuItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuBar.add(menuItemExit);
        
        menuItemInfo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    frame.add(user, BorderLayout.CENTER);
                    User.showPanelUser();
            }
        });
        
        frame.setJMenuBar(menuBar);
    }
    
    public void showMenu() {
    	
    	frame.setTitle("CLIMBCOL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(550,70);
        frame.setResizable(true);
        frame.add(mainPanel,BorderLayout.NORTH);
        mainPanel.setBorder(new EmptyBorder(10,10,10,10));
        mainPanel.setLayout(new CardLayout(0,0));// aprender esto;
        frame.setVisible(true);
        setupMainPanel();
    }
}
