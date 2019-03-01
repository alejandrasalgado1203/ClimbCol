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
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import data.Parque;
import data.Zona;

public class UIPark extends JPanel{
	private JPanel centerPanel = new JPanel(new GridLayout(1,0));
	private Parque park;
	private UIMain uiMain;
	private int imageIndex = 0;

	public static UIPark createUIPark(Parque park,UIMain main){
		return new UIPark(park,main);
	}
	public UIPark(Parque parque, UIMain main) {
		this.park = parque;
		this.uiMain = main;
		this.setLayout(new BorderLayout());
		this.setupMainPanel();
	}

	public void setupMainPanel() {
		createTittle();
		createDescription();
		createScrollPane();
		createButtonFotos();
	}
	public void createTittle() {
		JLabel lblParkName = new JLabel("PARQUE "+ this.park.getName());
		lblParkName.setFont(new Font("Tahoma",Font.PLAIN,35));
		JPanel panelTittle = new JPanel();
		panelTittle.add(lblParkName);
		this.add(panelTittle,BorderLayout.NORTH);
	}

	public void createDescription() {
		JPanel description = new JPanel(new GridLayout(0,1));
		ImageIcon parkImage = new ImageIcon(park.getMainImage());
		JLabel labelImage = new JLabel(parkImage);
		description.add(labelImage);

		JTextField textDescription = new JTextField(30);
		textDescription.setEditable(false);
		textDescription.setText(park.toString());
		description.add(textDescription);
		centerPanel.add(description);
	}

	public void createScrollPane() {

		DefaultListModel<Zona> model = new DefaultListModel<>();
		for (Zona zone : park.getZonas().values()) {
			model.addElement(zone);
		}
		JList <Zona> listZones = new JList <Zona> (model);
		listZones.setCellRenderer(new Renderer());
		JScrollPane scrollPaneParks = new JScrollPane(listZones);

		centerPanel.add(scrollPaneParks);

		listZones.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				Zona zone = park.getZona((listZones.getSelectedValue().getName()));
				uiMain.showPanel(UIZone.createUIZone(zone, uiMain));	
			}
		});

	}

	public void createButtonFotos(){
		JButton fotos = new JButton("Fotos");
		fotos.setForeground(Color.BLACK);
		fotos.setBackground(Color.WHITE);
		JPanel jp = new JPanel();
		jp.add(fotos);
		this.add(jp,BorderLayout.SOUTH);


		fotos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				showFrameFotos();
			}
		});
	}

	public void showFrameFotos() {
		JFrame frameFotos = new JFrame("FOTOS");
		frameFotos.add(setupPanelFotos());
		frameFotos.pack();
		frameFotos.setVisible(true);
	}

	public JPanel setupPanelFotos() {
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