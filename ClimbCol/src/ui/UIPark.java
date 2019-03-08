package ui;

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

import data.Park;
import data.Zone;
import java.awt.Component;

public class UIPark extends JPanel{
	private GridBagConstraints constraints = new GridBagConstraints();
	private Park park;
	private UIMain uiMain;
	private int imageIndex = 0;

	public static UIPark createUIPark(Park park,UIMain main){
		return new UIPark(park,main);
	}

	public UIPark(Park park, UIMain main) {
		this.park = park;
		this.uiMain = main;
		this.setLayout(new GridBagLayout());
		this.setupMainPanel();
	}

	private void setupMainPanel() {
		this.constraints.insets = new Insets(15,15,15,15);
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
		ImageIcon parkImage = new ImageIcon(park.getMainImage());
		JLabel labelImage = new JLabel(parkImage);
		this.constraints.gridwidth = 1;
		this.addGB(labelImage,0,1);
	}
	private void createDescription() {
		JPanel infoPanel = new JPanel(new GridLayout(0,1));

		JLabel lbl = new JLabel("Ubicacion: " + park.getLocation());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);

		lbl = new JLabel("ver en Google Maps");
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lbl.setForeground(Color.BLUE.darker());
		lbl.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI(park.getLinkLocation().trim()));
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
					Desktop.getDesktop().browse(new URI(park.getLinkPatk().trim()));
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

		lbl = new JLabel("Temperatura Promedio: " + park.getAverageTemperature());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);

		lbl = new JLabel("Altitud: " + park.getAltitude());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);

		lbl = new JLabel("Numero de zonas: " + park.getZones().size());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);

		this.addGB(infoPanel,0,2);
	}

	private void createScrollPane() {
		DefaultListModel<Zone> model = new DefaultListModel<>();
		for (Zone zone : park.getZones()) {
			model.addElement(zone);
		}
		JList <Zone> listZones = new JList <Zone> (model);
		listZones.setCellRenderer(new Renderer());
		JScrollPane scrollPaneZones = new JScrollPane(listZones);
		scrollPaneZones.setMinimumSize(new Dimension(300,400));

		this.constraints.gridwidth = 1;
		this.constraints.gridheight = 2;
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
		this.addGB(b1,0,4);
	}

	private void createButtonFotos(){
		JButton fotos = new JButton("Fotos");
		fotos.setForeground(Color.BLACK);
		fotos.setBackground(Color.WHITE);
		JPanel jp = new JPanel();
		jp.add(fotos);

		this.constraints.gridwidth = 2;		
		this.addGB(jp,0,3);

		fotos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				showFrameFotos();
			}
		});
	}

	private void showFrameFotos() {
		JFrame frameFotos = new JFrame("FOTOS");
		frameFotos.add(setupPanelFotos());
		frameFotos.setSize(950, 550);
		frameFotos.setVisible(true);
	}

	private JPanel setupPanelFotos() {
		JPanel panelFotos = new JPanel(new GridBagLayout()); 
		JToolBar toolBar;

		ArrayList <ImageIcon>images = new ArrayList <ImageIcon>();
		for(String  s : park.getImagesPaths()) {
			images.add(new ImageIcon(s));
		}
		JLabel label = new JLabel (images.get(0));
		this.constraints.gridx = 0;
		this.constraints.gridy = 0;
		this.constraints.gridheight = 1;
		panelFotos.add(label,constraints);  

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
		this.constraints.gridx = 0;
		this.constraints.gridy = 1;
		panelFotos.add(toolBar,constraints);  
		return panelFotos;
	}

	private void addGB(Component comp, int x, int y) {
		this.constraints.gridx = x;
		this.constraints.gridy = y;
		this.add(comp, this.constraints);
	}

}
