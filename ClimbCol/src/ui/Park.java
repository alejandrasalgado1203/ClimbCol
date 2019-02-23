
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class Park extends JFrame{
	private static JPanel fotos = new JPanel();
	private int imageIndex = 0;
	private JToolBar toolBar;
	private static JPanel panelPark = new JPanel();
	private static JFrame frame = new JFrame ("Example");
	
	public void setupPanelPark(String namePark){
        panelPark.setLayout(new GridLayout(8,1));
		
        JLabel lblWelcomePark = new JLabel("PARQUE "+ namePark);
        lblWelcomePark.setFont(new Font("Tahoma",Font.PLAIN,35));
        panelPark.add(lblWelcomePark);
        
        ImageIcon Park= new ImageIcon("/Images/Diagrama.png");
        JLabel labelImage = new JLabel(Park);
		labelImage.setVisible(true);
		panelPark.add(labelImage);
        
		JTextField textDescription = new JTextField();
		panelPark.add(textDescription);
        
        JButton buttonZone1 = new JButton("Zona 1");
        buttonZone1.setForeground(Color.BLACK);
        buttonZone1.setBackground(Color.WHITE);
        panelPark.add(buttonZone1);
        
        JButton buttonZone2 = new JButton("Zona 2");
        buttonZone2.setForeground(Color.BLACK);
        buttonZone2.setBackground(Color.WHITE);
        panelPark.add(buttonZone2);
        
        JButton buttonZone3 = new JButton("Zona 3");
        buttonZone3.setForeground(Color.BLACK);
        buttonZone3.setBackground(Color.WHITE);
        panelPark.add(buttonZone3);
        
        JButton buttonZone4 = new JButton("Zona 4");
        buttonZone4.setForeground(Color.BLACK);
        buttonZone4.setBackground(Color.WHITE);
        panelPark.add(buttonZone4);
        
        JButton fotos = new JButton("Fotos");
        fotos.setForeground(Color.BLACK);
        fotos.setBackground(Color.WHITE);
        panelPark.add(fotos);
        
        fotos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    remove(panelPark);
                    setupPanelFotos();
            }
        });
        
        buttonZone1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    remove(panelPark);
                    Zone.showPanelZone();
            }
        });
        
        buttonZone2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    remove(panelPark);
                    Zone.showPanelZone();
            }
        });
        
        buttonZone3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    remove(panelPark);
                    Zone.showPanelZone();
            }
        });
        
        buttonZone4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    remove(panelPark);
                    Zone.showPanelZone();
            }
        });
        
    }
    
    public void setupPanelFotos() {
    	
    	fotos.setLayout(new BorderLayout());
		
		ArrayList <ImageIcon> images = new ArrayList <ImageIcon>();
		images.add(new ImageIcon("images/sandPile3.png"));
		images.add(new ImageIcon("images/sandPile4.png"));
		images.add(new ImageIcon("images/sandPile5.png"));
		images.add(new ImageIcon("images/sandPile6.png"));
		images.add(new ImageIcon("images/sandPile7.png"));
		JLabel label = new JLabel (images.get(0));
		fotos.add(label,BorderLayout.CENTER);  

		
		JButton b1 = new JButton(new ImageIcon("images/previous.png"));
		b1.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				if (imageIndex != 0) {
					imageIndex--;
					label.setIcon(images.get(imageIndex));
				}
			}  
		});  
		
		
		JButton b2 = new JButton(new ImageIcon("images/next.png"));
		b2.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				if (imageIndex != images.size()-1) {
					imageIndex++;
					label.setIcon(images.get(imageIndex));
				}
			}  
		});  
		
		
		toolBar = new JToolBar( "ToolBar", SwingConstants.HORIZONTAL); 
		toolBar.setFloatable(false);
		toolBar.add(b1);
		toolBar.addSeparator();
		toolBar.add(b2);
		this.add(toolBar, BorderLayout.NORTH);
	}
    
    public static void showPanelPark() {
        frame.add(panelPark);
        frame.pack();
    }
}
