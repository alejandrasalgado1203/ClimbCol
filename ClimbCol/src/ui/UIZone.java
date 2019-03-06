package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import data.Ruta;
import data.Zona;

public class UIZone extends JPanel {
	private   JPanel centerPanel = new JPanel();
	private Zona zone;
	private UIMain uiMain;
	private JPanel description = new JPanel(new GridLayout(2,1));

	public static   UIZone createUIZone(Zona zone,UIMain main){
		return new UIZone(zone,main);
	}
	public UIZone(Zona zone, UIMain main) {
		this.zone = zone;
		this.uiMain = main;
		this.setLayout(new BorderLayout());
		this.setupMainPanel();
	}

	public void setupMainPanel() {
		createTittle();
		createScrollPane();
		createImage();
		createDescription();
		goToLastAndNextPanel();
	}

	public void createTittle() {
		JPanel tittle = new JPanel();
		JLabel lblWelcomeZone = new JLabel("ZONA "+ this.zone.getName());
		lblWelcomeZone.setFont(new Font("Tahoma",Font.PLAIN,35));
		tittle.add(lblWelcomeZone);
		this.add(tittle,BorderLayout.NORTH);
	}

	public void createImage() {
		ImageIcon Zone= new ImageIcon(zone.getMainImage());
		JLabel labelImage = new JLabel(Zone);
		description.add(labelImage);
	}
	public   void createDescription() {
		JPanel infoPanel = new JPanel(new GridLayout(0,1));

		JLabel lbl = new JLabel("Dificultad Maxima: " + zone.getDificultadMax());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);
		lbl = new JLabel("Dificultad Minima: " + zone.getDificultadMin());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);
		lbl = new JLabel("Dificultad Promedio: " + zone.getDificultadPromedio());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);
		lbl = new JLabel("No. de Rutas: " + zone.getRutas().size());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);

		description.add(infoPanel);
		centerPanel.add(description);
	}

	public void createScrollPane() {

		DefaultListModel<Ruta> model = new DefaultListModel<>();
		for (Ruta rute : zone.getRutas()) {
			model.addElement(rute);
		}
		JList <Ruta> listRutes = new JList <Ruta> (model);
		listRutes.setCellRenderer(new Renderer());
		JScrollPane scrollPaneRutes = new JScrollPane(listRutes);

		centerPanel.add(scrollPaneRutes);
		this.add(centerPanel, BorderLayout.CENTER);

		listRutes.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				uiMain.showPanel(UIRute.createUIRute(listRutes.getSelectedValue(), uiMain));	
			}
		});
	}
	private void goToLastAndNextPanel() {
		JPanel southPanel = new JPanel ();
		JButton b1=new JButton("Return to Welcome");  
		b1.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				uiMain.showPanel(UIWelcome.createUIWelcome(uiMain),740,670);
			}  
		});

		JButton b2=new JButton("Return to Park");  
		b2.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				uiMain.showPanel(UIPark.createUIPark(zone.getParque(),uiMain));
			}  
		});

		southPanel.add(b1);
		southPanel.add(b2);
		this.add(southPanel, BorderLayout.SOUTH);
	}

}