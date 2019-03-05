package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import data.Parque;
import data.Zona;

public class UIPark extends JPanel{
	private JPanel centerPanel = new JPanel(new GridLayout(1,0));
	private JPanel southPanel = new JPanel();
	private JPanel description = new JPanel(new GridLayout(0,1));
	private Parque park;
	private UIMain uiMain;
	private int imageIndex = 0;

	public static UIPark createUIPark(Parque park,UIMain main){
		return new UIPark(park,main);
	}
	public UIPark(Parque park, UIMain main) {
		this.park = park;
		this.uiMain = main;
		this.setLayout(new BorderLayout());
		this.setupMainPanel();
	}

	private void setupMainPanel() {
		createTittle();
		createImage();
		createDescription();
		createScrollPane();
		goToLastPanel();
		createButtonFotos();
	}
	private void createTittle() {
		JLabel lblParkName = new JLabel("PARQUE "+ this.park.getName());
		lblParkName.setFont(new Font("Tahoma",Font.PLAIN,35));
		JPanel panelTittle = new JPanel();
		panelTittle.add(lblParkName);
		this.add(panelTittle,BorderLayout.NORTH);
	}

	private void createImage() {
		ImageIcon parkImage = new ImageIcon(park.getMainImage());
		JLabel labelImage = new JLabel(parkImage);
		description.add(labelImage);
	}
	private void createDescription() {
		JPanel infoPanel = new JPanel(new GridLayout(0,1));

		JLabel lbl = new JLabel("Ubicacion: " + park.getUbicacion());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);
		lbl = new JLabel("Link Ubicacion: " + park.getLinkUbicacion());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);
		lbl = new JLabel("Temperatura Promedio: " + park.getTemperaturaPromedio());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);
		lbl = new JLabel("Altitud: " + park.getAltitud());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);
		lbl = new JLabel("Link Parque: " + park.getLinkParque());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);
		//lbl = new JLabel("Numero de zonas: " + park.getZonas().size());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);

		description.add(infoPanel);
		centerPanel.add(description);
	}

	private void createScrollPane() {

		DefaultListModel<Zona> model = new DefaultListModel<>();
		for (Zona zone : park.getZonas()) {
			model.addElement(zone);
		}
		JList <Zona> listZones = new JList <Zona> (model);
		listZones.setCellRenderer(new Renderer());
		JScrollPane scrollPaneParks = new JScrollPane(listZones);

		centerPanel.add(scrollPaneParks);
		this.add(centerPanel, BorderLayout.CENTER);

		listZones.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				uiMain.showPanel(UIZone.createUIZone(listZones.getSelectedValue(), uiMain));	
			}
		});

	}

	private void goToLastPanel() {

		JButton b1=new JButton("Return to Welcome");  
		b1.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				uiMain.showPanel(UIWelcome.createUIWelcome(uiMain),740,670);
			}  
		});

		this.southPanel.add(b1);
	}

	private void createButtonFotos(){
		JButton fotos = new JButton("Fotos");
		fotos.setForeground(Color.BLACK);
		fotos.setBackground(Color.WHITE);
		JPanel jp = new JPanel();
		jp.add(fotos);
		this.southPanel.add(jp);
		this.add(southPanel, BorderLayout.SOUTH);


		fotos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				showFrameFotos();
			}
		});
	}

	private void showFrameFotos() {
		JFrame frameFotos = new JFrame("FOTOS");
		frameFotos.add(setupPanelFotos());
		frameFotos.pack();
		frameFotos.setVisible(true);
	}

	private JPanel setupPanelFotos() {
		JPanel panelFotos = new JPanel(new BorderLayout()); 
		JToolBar toolBar;

		ArrayList <ImageIcon>images = new ArrayList <ImageIcon>();
		for(String  s : park.getDireccionImagenes()) {
			images.add(new ImageIcon(s));
		}
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
		toolBar.setFloatable(false);
		toolBar.add(b1);
		toolBar.addSeparator();
		toolBar.add(b2);
		panelFotos.add(toolBar, BorderLayout.SOUTH);
		return panelFotos;
	}

}