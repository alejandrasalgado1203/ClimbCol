
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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

public class Welcome{
	private static JPanel panelWelcome = new JPanel ();
	private static JPanel panelParks = new JPanel ();
    private static JPanel centerPanel = new JPanel();
    private static Park park;
    private static User user = new User();
    private static JFrame frame = new JFrame ("CLIMBCOL");
    
    public void setupMainPanel(){
        createMenuBarWelcome();
        createPanelWelcome();
        createScrollPane();
        createTipsVideoPane();
    }
    
    public void createTipsVideoPane() {
    	JPanel tipsVideo = new JPanel();
    	tipsVideo.setLayout(new GridLayout(2,1));
    	centerPanel.add(tipsVideo,new FlowLayout());
    	
    	ImageIcon Tips= new ImageIcon("images\\2.jpg");
        JLabel labelTips = new JLabel(Tips);
		labelTips.setVisible(true);
		labelTips.setSize(new Dimension(2,2));
		tipsVideo.add(labelTips);
		
		ImageIcon Video= new ImageIcon("images\\3.jpg");
        JLabel labelVideo = new JLabel(Video);
		labelVideo.setVisible(true);
		tipsVideo.add(labelVideo);

    }
    
    public void createScrollPane() {
    	JPanel scrollPane = new JPanel();
    	JScrollPane scrollPaneParks = new JScrollPane (panelParks,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    	scrollPaneParks.setPreferredSize(new Dimension(350, 250));
    	panelParks.setLayout(new GridLayout(4,1));
    	scrollPane.add(scrollPaneParks);
    	centerPanel.add(scrollPane,new FlowLayout());
    	frame.add(centerPanel,BorderLayout.CENTER);
    	
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
        
        buttonPark2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            		frame.add(new Park("1"), BorderLayout.CENTER);
            }
        });
        
        buttonPark2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            		frame.add(new Park("2"), BorderLayout.CENTER);
            }
        });
        
        buttonPark3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            		frame.add(new Park("3"), BorderLayout.CENTER);
            }
        });
        
        buttonPark4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            		frame.add(new Park("4"), BorderLayout.CENTER);
            }
        });
    }
    
    public void createPanelWelcome () {
    	panelWelcome.setLayout(new GridLayout(3,1));
    	frame.add(panelWelcome,BorderLayout.NORTH);
    	
    	JLabel lblWelcome = new JLabel("              Welcome to CLIMBCOL");
        lblWelcome.setFont(new Font("Tahoma",Font.PLAIN,35));
        panelWelcome.add(lblWelcome);
        
        JLabel lblDescription = new JLabel("      The best aplication to Colombian and international Climbers");
        lblDescription.setFont(new Font("Tahoma",Font.PLAIN,20));
        panelWelcome.add(lblDescription);
        
        final JComboBox<String> cbox = new JComboBox<String>();// corregir tipos segun logica
        ArrayList<String> rutes = new ArrayList<String>();
		for(String s : rutes)
			cbox.addItem(s);
		cbox.setEditable(true);
		panelWelcome.add(cbox);
        
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
        menuItemSignIn.setMnemonic(KeyEvent.VK_A);
        menuBar.add(menuItemExit);
        
        menuItemInfo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    frame.add(user, BorderLayout.CENTER);
                    User.showPanelUser();
            }
        });
        
        menuItemExit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }
        });
        
        frame.setJMenuBar(menuBar);
    }
    
    public void showMenu() {
    	
    	frame.setTitle("CLIMBCOL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,900);
        frame.setResizable(false);
        frame.setVisible(true);
        setupMainPanel();
        frame.pack();
    }
}
