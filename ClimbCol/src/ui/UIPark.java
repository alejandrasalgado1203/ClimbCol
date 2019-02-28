package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import business.ClimbColManager;
import business.ClimbersManager;
import data.Parque;

public class UIPark extends JPanel{
	private static JPanel panelFotos = new JPanel(); 
	private static JPanel panelTittle = new JPanel();
	private static UIZone panelZones;
	private static JPanel centerPanel = new JPanel();
	private UIWelcome welcome;
	private static int imageIndex = 0;
	private static JToolBar toolBar;
	private Parque park;

        public static UIPark createUIPark(Parque park,UIMain main){
            return new UIPark(park,main);
        }
	public UIPark(Parque parque, UIMain main) {
		showPanelPark(main);
	}
	public void setupMainPanel(String namePark,UIMain main) {
		createTittle(namePark);
		createDescription();
		createScrollPane();
		createButtonFotos();
	}
	public void createTittle(String namePark) {
		JLabel lblWelcomePark = new JLabel("PARQUE "+ namePark);
		lblWelcomePark.setFont(new Font("Tahoma",Font.PLAIN,35));
		panelTittle.add(lblWelcomePark);
		this.add(panelTittle,BorderLayout.NORTH);
	}

	public void createDescription() {
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

	public void createScrollPane() {

		JList listZones = new JList(ClimbColManager.getZonesNames(park));
		JScrollPane scrollPaneZones = new JScrollPane(listZones);

		centerPanel.add(scrollPaneZones,new FlowLayout());
		this.add(centerPanel,BorderLayout.CENTER);

		listZones.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				panelZones = new UIZone(ClimbColManager.getZone(park,(String) listZones.getSelectedValue()));
				showPanelZone();
			}
		});

	}
	public void showPanelZone() {
		remove(panelTittle);
		remove(centerPanel);
		remove(panelFotos);
		//welcome.showPanel(panelZones);// mirar
	}
	public void createButtonFotos(){
		JButton fotos = new JButton("Fotos");
		fotos.setForeground(Color.BLACK);
		fotos.setBackground(Color.WHITE);
		this.add(fotos,BorderLayout.SOUTH);


		fotos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				remove(centerPanel);
				remove(fotos);
				showPanelFotos();
			}
		});
	}

	public void setupPanelFotos() {// no funciona

		panelFotos.setLayout(new BorderLayout());

		ArrayList <ImageIcon> images = new ArrayList <ImageIcon>();
		images.add(new ImageIcon("images/sandPile3.png"));
		images.add(new ImageIcon("images/sandPile4.png"));
		images.add(new ImageIcon("images/sandPile5.png"));
		JLabel label = new JLabel (images.get(0));
		panelFotos.add(label,BorderLayout.CENTER);  


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
		panelFotos.add(toolBar, BorderLayout.SOUTH);
		this.add(panelFotos);
	}

	public void showPanelFotos() {
		this.setSize(500,500);
		setupPanelFotos();
		this.setVisible(true);
	}

	public void showPanelPark(UIMain main) {
		this.setSize(900,900);
		setupMainPanel("",main);
		this.setVisible(true);

	}
}
