package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.Insets;

import data.Parque;
import data.Zona;
import java.awt.Component;

public class UIPark extends JPanel{
        private GridBagConstraints constraints = new GridBagConstraints();
	private Parque park;
	private UIMain uiMain;
	private int imageIndex = 0;

	public static UIPark createUIPark(Parque park,UIMain main){
		return new UIPark(park,main);
	}
	public UIPark(Parque park, UIMain main) {
		this.park = park;
		this.uiMain = main;
		this.setLayout(new GridBagLayout());
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
                JPanel panelTittle = new JPanel(new GridLayout(0,1));
		JLabel lblParkName = new JLabel("PARQUE "+ this.park.getName());
		lblParkName.setFont(new Font("Tahoma",Font.PLAIN,35));
		panelTittle.add(lblParkName);
                this.constraints.gridwidth = 2;
                this.addGB(panelTittle,0,0);
	}

	private void createImage() {
                JPanel image = new JPanel(new GridLayout(0,1));
		ImageIcon parkImage = new ImageIcon(park.getMainImage());
		JLabel labelImage = new JLabel(parkImage);
		image.add(labelImage);
                this.addGB(image,0,1);
	}
	private void createDescription() {
		JPanel infoPanel = new JPanel(new GridLayout(0,1));

		JLabel lbl = new JLabel("Ubicacion: " + park.getUbicacion());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);
                
		lbl = new JLabel("ver en Google Maps");
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lbl.setForeground(Color.BLUE.darker());
		lbl.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI(park.getLinkUbicacion().trim()));
				} catch (IOException | URISyntaxException e1) {
					JOptionPane.showMessageDialog(null, "ha ocurrido un error, "
							+ "el link no se puede abrir", null, JOptionPane.ERROR_MESSAGE);
				}
			}
			public void mouseExited(MouseEvent e) {
				JLabel lbl = (JLabel) e.getSource();
				lbl.setText("ver en Google Maps");
			}
			public void mouseEntered(MouseEvent e) {
				JLabel lbl = (JLabel) e.getSource();
				lbl.setText("<html><a href=''>" + "ver en Google Maps" + "</a></html>");
			}
		});
		infoPanel.add(lbl);
                
                lbl = new JLabel("ver website del parque");
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lbl.setForeground(Color.BLUE.darker());
		lbl.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI(park.getLinkParque().trim()));
				} catch (IOException | URISyntaxException e1) {
					JOptionPane.showMessageDialog(null, "ha ocurrido un error, "
							+ "el link no se puede abrir", null, JOptionPane.ERROR_MESSAGE);
				}
			}
			public void mouseExited(MouseEvent e) {
				JLabel lbl = (JLabel) e.getSource();
				lbl.setText("ver website del parque");
			}
			public void mouseEntered(MouseEvent e) {
				JLabel lbl = (JLabel) e.getSource();
				lbl.setText("<html><a href=''>" + "ver website del parque" + "</a></html>");
			}
		});
		infoPanel.add(lbl);

		lbl = new JLabel("Temperatura Promedio: " + park.getTemperaturaPromedio());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);
                
		lbl = new JLabel("Altitud: " + park.getAltitud());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);
                
		lbl = new JLabel("Numero de zonas: " + park.getZonas().size());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);

		this.addGB(infoPanel,0,2);
	}

	private void createScrollPane() {
		DefaultListModel<Zona> model = new DefaultListModel<>();
		for (Zona zone : park.getZonas()) {
			model.addElement(zone);
		}
		JList <Zona> listZones = new JList <Zona> (model);
		listZones.setCellRenderer(new Renderer());
		JScrollPane scrollPaneZones = new JScrollPane(listZones);
                scrollPaneZones.setMinimumSize(new Dimension(300,400));

		this.constraints.gridwidth = 1;
                this.constraints.gridheight = 2;
                this.constraints.insets = new Insets(10,20,0,20);
		this.addGB(scrollPaneZones,1,1);

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
                this.constraints.gridwidth = 2;
		this.addGB(b1,0,3);
	}

	private void createButtonFotos(){
		JButton fotos = new JButton("Fotos");
		fotos.setForeground(Color.BLACK);
		fotos.setBackground(Color.WHITE);
		JPanel jp = new JPanel();
		jp.add(fotos);
                this.constraints.gridwidth = 2;
                this.addGB(jp,0,4);

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
        
        private void addGB(Component comp, int x, int y) {
		this.constraints.gridx = x;
		this.constraints.gridy = y;
		this.add(comp, this.constraints);
	}

}
