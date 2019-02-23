
package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class User extends JFrame {
	private static JPanel panelUser = new JPanel();
	private JPanel panelGoals = new JPanel();
	private JPanel panelFavorites = new JPanel();
	private static JFrame frame = new JFrame ("Example");
	
	 public void setupPanelUser(String nombre) {
	        panelUser.setLayout(new GridLayout(8,1));
			
	        JLabel lblWelcomeUser = new JLabel(nombre);
	        lblWelcomeUser.setFont(new Font("Tahoma",Font.PLAIN,35));
	        panelUser.add(lblWelcomeUser);
	        
	        JButton buttonGoals= new JButton("Retos");
	        buttonGoals.setForeground(Color.BLACK);
	        buttonGoals.setBackground(Color.WHITE);
	        panelUser.add(buttonGoals);
	        
	        JButton buttonFavorites = new JButton("Favoritos");
	        buttonFavorites.setForeground(Color.BLACK);
	        buttonFavorites.setBackground(Color.WHITE);
	        panelUser.add(buttonFavorites);
	        
	        buttonGoals.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e) {
	                    remove(panelUser);
	                    showPanelGoals();
	            }

	        });
	        
	        buttonFavorites.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e) {
	                    remove(panelUser);
	                    showPanelFavorites();
	            }
	        });
	        
	    }
	    
	    public static void showPanelUser() {
	    	frame.add(panelUser);
	        frame.pack();
	    }
	    
	    public void showPanelFavorites() {
	        add(panelFavorites);
	        pack();
	    }
		
	    public void showPanelGoals() {
	        add(panelGoals);
	        pack();
	    }
	    
}
