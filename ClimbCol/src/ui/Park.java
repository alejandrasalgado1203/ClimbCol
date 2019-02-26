
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class Park {
	private static JPanel fotos = new JPanel(); 
	private static JPanel panelZones = new JPanel ();
    private static JPanel centerPanel = new JPanel();
    private static JFrame frame = new JFrame("CLIMBCOL");
	private static int imageIndex = 0;
	private static JToolBar toolBar;
	
	public static void setupMainPanel(String namePark) {
		createTittle(namePark);
		createDescription();
		createScrollPane();
		createButtonFotos();
	}
	public static void createTittle(String namePark) {
		JPanel tittle = new JPanel();
		JLabel lblWelcomePark = new JLabel("PARQUE "+ namePark);
        lblWelcomePark.setFont(new Font("Tahoma",Font.PLAIN,35));
        tittle.add(lblWelcomePark);
        frame.add(tittle,BorderLayout.NORTH);
	}
        
    public static void createDescription() {
    	JPanel description = new JPanel();
    	description.setLayout(new GridLayout(2,1));
    	centerPanel.add(description,new FlowLayout());
    	
    	ImageIcon Park= new ImageIcon("images/4.jpg");
        JLabel labelImage = new JLabel(Park);
		labelImage.setVisible(true);
		description.add(labelImage);
        
		JTextField textDescription = new JTextField(30);
		description.add(textDescription);
    }
    
    public static void createScrollPane() {
    	
    	JPanel scrollPane = new JPanel();
    	JScrollPane scrollPaneZones = new JScrollPane (panelZones,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    	scrollPaneZones.setPreferredSize(new Dimension(350, 250));
    	panelZones.setLayout(new GridLayout(4,1));
    	scrollPane.add(scrollPaneZones);
    	centerPanel.add(scrollPane,new FlowLayout());
    	frame.add(centerPanel,BorderLayout.CENTER);
    	
    	JButton buttonZone1 = new JButton("Zona 1");
        buttonZone1.setForeground(Color.BLACK);
        buttonZone1.setBackground(Color.WHITE);
        panelZones.add(buttonZone1);
        
        JButton buttonZone2 = new JButton("Zona 2");
        buttonZone2.setForeground(Color.BLACK);
        buttonZone2.setBackground(Color.WHITE);
        panelZones.add(buttonZone2);
        
        JButton buttonZone3 = new JButton("Zona 3");
        buttonZone3.setForeground(Color.BLACK);
        buttonZone3.setBackground(Color.WHITE);
        panelZones.add(buttonZone3);
        
        JButton buttonZone4 = new JButton("Zona 4");
        buttonZone4.setForeground(Color.BLACK);
        buttonZone4.setBackground(Color.WHITE);
        panelZones.add(buttonZone4);
        
        buttonZone1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	Zone.showPanelZone();
            }
        });
        
        buttonZone2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	Zone.showPanelZone();
            }
        });
        
        buttonZone3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	Zone.showPanelZone();
            }
        });
        
        buttonZone4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	Zone.showPanelZone();
            }
        });
       
    }
	public static void createButtonFotos(){
		JButton fotos = new JButton("Fotos");
		fotos.setForeground(Color.BLACK);
	    fotos.setBackground(Color.WHITE);
	    frame.add(fotos,BorderLayout.SOUTH);
        
        
        fotos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            		frame.remove(centerPanel);
            		frame.remove(fotos);
                    showPanelFotos();
            }
        });
	}
	    
    public static void setupPanelFotos() {// no funciona
    	
    	fotos.setLayout(new BorderLayout());
		
		ArrayList <ImageIcon> images = new ArrayList <ImageIcon>();
		images.add(new ImageIcon("images/sandPile3.png"));
		images.add(new ImageIcon("images/sandPile4.png"));
		images.add(new ImageIcon("images/sandPile5.png"));
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
		toolBar.setFloatable(true);
		toolBar.add(b1);
		toolBar.addSeparator();
		toolBar.add(b2);
		fotos.add(toolBar, BorderLayout.SOUTH);
		frame.add(fotos);
	}

    public static void showPanelFotos() {
    	frame.setTitle("CLIMBCOL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setResizable(true);
        frame.setVisible(true);
        setupPanelFotos();
        frame.pack();
    }

	public static void showPanelPark() {
		frame.setTitle("CLIMBCOL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,900);
        frame.setResizable(true);
        frame.setVisible(true);
        setupMainPanel(" ");
        frame.pack();
		
	}
}
