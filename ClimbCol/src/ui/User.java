
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SpinnerModel;
import javax.swing.SwingConstants;

public class User extends JFrame {
	private static JPanel Welcome = new JPanel(new GridLayout(2,1));
	private static JPanel panelGoals = new JPanel();
	private static JPanel panelFavorites = new JPanel();
	private static JFrame frame = new JFrame ("CLIMBCOL");
	private static JToolBar toolBar;
	
	public static void setupMainPanel(String nombreEscalador) {
		createTittle(nombreEscalador);
		createTextField();
		createButtons();
	}
	public static void createTittle(String name) {
		JLabel lblWelcomeUser = new JLabel(name);
        lblWelcomeUser.setFont(new Font("Tahoma",Font.PLAIN,35));
        Welcome.add(lblWelcomeUser);
	}
	public static void createTextField() { 
		JTextField textfield = new JTextField(30);
		Welcome.add(textfield);
		frame.add(Welcome,BorderLayout.NORTH);
	}
	
	public static void createSpinner() {// no entendi spinner jajaja
		
	}
	 public static void createButtons() {
		
        JButton buttonGoals= new JButton("Grupo de Retos");
        buttonGoals.setForeground(Color.BLACK);
        buttonGoals.setBackground(Color.WHITE);
        //buttons.add(buttonGoals,FlowLayout.CENTER);
        
        JButton buttonFavorites = new JButton("Favoritos");
        buttonFavorites.setForeground(Color.BLACK);
        buttonFavorites.setBackground(Color.WHITE);
        //buttons.add(buttonFavorites,FlowLayout.CENTER);
        
        //frame.add(buttons,BorderLayout.SOUTH);
        
        buttonGoals.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    showPanelGoals();
            }

        });
        
        buttonFavorites.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    showPanelFavorites();
            }
        });
	        
        toolBar = new JToolBar( "ToolBar", SwingConstants.HORIZONTAL); 
		toolBar.setFloatable(true);
		toolBar.add(buttonGoals);
		toolBar.addSeparator();
		toolBar.add(buttonFavorites);
		frame.add(toolBar,BorderLayout.SOUTH);
	    }
	    
	    public static void showPanelUser() {
	    	frame.setTitle("CLIMBCOL");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(500,500);
	        frame.setResizable(true);
	        frame.setVisible(true);
	        setupMainPanel("buuuu ");
	        frame.pack();
	    }
	    
	    public static void showPanelFavorites() {//modificar
	        frame.add(panelFavorites);
	        frame.pack();
	    }
		
	    public static void showPanelGoals() {//modificar
	        frame.add(panelGoals);
	        frame.pack();
	    }
	    
}
