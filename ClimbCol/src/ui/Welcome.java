
package ui;

import java.awt.Color;
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
import javax.swing.KeyStroke;

public class Welcome extends JFrame{
    private JPanel panelWelcome = new JPanel();
    
    public void setupPanelWelcome(){// mirar otro tipo de panel
		
        JLabel lblWelcome = new JLabel("Welcome to CLIMBCOL");
        lblWelcome.setFont(new Font("Tahoma",Font.PLAIN,35));
        this.panelWelcome.add(lblWelcome);
        
        JLabel lblDescription = new JLabel("The best aplication to Colombian and international Climbers");
        lblDescription.setFont(new Font("Tahoma",Font.PLAIN,20));
        this.panelWelcome.add(lblDescription);
        
        createMenuBarWelcome();
        
        final JComboBox<String> cbox = new JComboBox<String>();// corregir tipos segun logica
        ArrayList<String> rutes = new ArrayList<String>();
		for(String s : rutes)
			cbox.addItem(s);
		this.panelWelcome.add(cbox);
		
		ImageIcon Tips= new ImageIcon("/Images/Diagrama.png");
        JLabel labelTips = new JLabel(Tips);
		labelTips.setVisible(true);
		this.panelWelcome.add(labelTips);
		
		ImageIcon Video= new ImageIcon("/Images/Diagrama.png");
        JLabel labelVideo = new JLabel(Video);
		labelVideo.setVisible(true);
		this.panelWelcome.add(labelVideo);

        JButton buttonPark1 = new JButton("Parque 1");
        buttonPark1.setForeground(Color.BLACK);
	    buttonPark1.setBackground(Color.WHITE);
        this.panelWelcome.add(buttonPark1);
        
        JButton buttonPark2 = new JButton("Parque 2");
        buttonPark2.setForeground(Color.BLACK);
	    buttonPark2.setBackground(Color.WHITE);
        this.panelWelcome.add(buttonPark2);
        
        JButton buttonPark3 = new JButton("Parque 3");
        buttonPark3.setForeground(Color.BLACK);
	    buttonPark3.setBackground(Color.WHITE);
        this.panelWelcome.add(buttonPark3);
        
        JButton buttonPark4 = new JButton("Parque 4");
        buttonPark4.setForeground(Color.BLACK);
	    buttonPark4.setBackground(Color.WHITE);
        this.panelWelcome.add(buttonPark4);
        
        buttonPark1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    remove(panelWelcome);
                    Park.showPanelPark();
            }
        });
        
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
        
        menuItemInfo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    remove(panelWelcome);
                    User.showPanelUser();
            }
        });
        
        this.setJMenuBar(menuBar);
    }
    
    public void showMenu() {
    	this.setSize(450,200);
        this.add(this.panelWelcome);
    }
}
