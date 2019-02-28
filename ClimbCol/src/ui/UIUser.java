
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SpinnerModel;
import javax.swing.SwingConstants;

import business.ClimbersManager;
import data.Escalador;

public class UIUser extends JFrame {
	private static JPanel Welcome = new JPanel(new GridLayout(2,1));
	private static JPanel panelGoals = new JPanel();
	private static JPanel panelFavorites = new JPanel();
	private static JFrame frameUser = new JFrame ("CLIMBCOL");
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
		frameUser.add(Welcome,BorderLayout.NORTH);
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
		frameUser.add(toolBar,BorderLayout.SOUTH);
	    }
	    
	    public static void showPanelUser() {
	    	frameUser.setTitle("CLIMBCOL");
	        frameUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frameUser.setSize(500,500);
	        frameUser.setResizable(true);
	        setupMainPanel("buuuu ");
	        frameUser.pack();
	        frameUser.setVisible(true);
	    }
	    
	    public static void showPanelFavorites() {//modificar
	        frameUser.add(panelFavorites);
	        frameUser.pack();
	    }
		
	    public static void showPanelGoals() {//modificar
	        frameUser.add(panelGoals);
	        frameUser.pack();
	    }
		private void setupPanelAdd(UIMain main) {
			JLabel nameLabel= new JLabel("User: ");
			JLabel passwordLabel = new JLabel ("Password: ");;
			JTextField nameField =  new JTextField();
			nameField.setColumns(25);
			JTextField passwordField = new JTextField();
			passwordField.setColumns(25);
			JPanel userPane = new JPanel();
			JPanel passwordPane = new JPanel();
			JPanel panelAddUser = new JPanel(new GridLayout(0,1));

			JLabel lblAdd = new JLabel ("Sign in");
			lblAdd.setFont(new Font("Tahoma",Font.PLAIN,25));
			panelAddUser.add(lblAdd);

			userPane.add(nameLabel);
			userPane.add(nameField);
			passwordPane.add(passwordLabel);
			passwordPane.add(passwordField);

			panelAddUser.add(userPane);
			panelAddUser.add(passwordPane);

			JButton btnSend = new JButton ("Send");
			panelAddUser.add(btnSend);

			btnSend.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if(nameField.getText().equals("")|| passwordField.getText().equals("") ) {
						indicateSpaceEmpty();	
						Escalador es = new Escalador (nameField.getText(),passwordField.getText());
						ClimbersManager.put(es);
					}
					passwordField.setText("");
					nameField.setText("");
					remove(panelAddUser);
					
				}
			});

			//panelSignIn.add(panelAddUser);
			//this.add(panelSignIn);
		}
		public void showPanelAdd(UIMain main) {
			setupPanelAdd(main);
			this.setVisible(true);
		}
		public void indicateSpaceEmpty() {
			JOptionPane.showMessageDialog(this,"A space is Empty");
		}

}
