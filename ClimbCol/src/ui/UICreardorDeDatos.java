package ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Event;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import business.CreadorDeDatos;
import data.Parque;


public class UICreardorDeDatos extends JFrame{

	private CreadorDeDatos cdd;
	private JPanel newPark = new JPanel();
	private JPanel newZone = new JPanel();
	private JPanel newRute = new JPanel();
	private JPanel editPark = new JPanel();
	private JPanel editZone = new JPanel();


	public UICreardorDeDatos(CreadorDeDatos cdd) {
		super();
		this.cdd = cdd;
		this.setTitle("creador de datos");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(280,190);
		this.setLocation(200,200);
		JPanel mainPanel = new JPanel ();
		mainPanel.setBorder(new EmptyBorder(10,10,10,10));
		mainPanel.setLayout(new BorderLayout());
		this.setContentPane(mainPanel);
		setupMenu();
		this.setVisible(true);
	}

	private void setupEditZonePanel() {
		this.editZone = new JPanel();
		Container box = Box.createVerticalBox();
		this.editZone.add(box);

		JLabel lblAdd = new JLabel ("editar Zona");
		lblAdd.setFont(new Font("Tahoma",Font.PLAIN,25));
		box.add(lblAdd);
		box.add(Box.createVerticalStrut(10));

		ZoneChooser zoneChooser = new ZoneChooser(cdd.getParques());
		box.add(zoneChooser);
		box.add(Box.createVerticalStrut(10));


		String[] fields = {"Direccion imagen"};
		InfoAsker infoAsker = new InfoAsker(fields);
		box.add(infoAsker);
		box.add(Box.createVerticalStrut(20));

		JButton btnSend = new JButton("Send");
		btnSend.setMnemonic(Event.ENTER);
		box.add(btnSend);

		btnSend.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				ArrayList<String> zone = new ArrayList<String>();
				zone.addAll(zoneChooser.getStatus());
				zone.addAll(infoAsker.getStatus());
				cdd.editZone(zone);
				showHome();
			}  
		});  
	}

	private void setupEditParkPanel() {
		this.editPark = new JPanel();
		Container box = Box.createVerticalBox();
		this.editPark.add(box);

		JLabel lblAdd = new JLabel ("editar parque");
		lblAdd.setFont(new Font("Tahoma",Font.PLAIN,25));
		box.add(lblAdd);
		box.add(Box.createVerticalStrut(10));

		ParkChooser parkChooser = new ParkChooser(cdd.getParques());
		box.add(parkChooser);
		box.add(Box.createVerticalStrut(10));

		String[] fields = {"Direccion imagen"};
		InfoAsker infoAsker = new InfoAsker(fields);
		box.add(infoAsker);
		box.add(Box.createVerticalStrut(20));

		JButton btnSend = new JButton("Send");
		btnSend.setMnemonic(Event.ENTER);
		box.add(btnSend);

		btnSend.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				ArrayList<String> park = new ArrayList<String>();
				park.add(parkChooser.getStatus());
				park.addAll(infoAsker.getStatus());
				cdd.editPark(park);
				showHome();
			}  
		}); 
	}

	private void setupNewRutePanel() {

		this.newRute = new JPanel();
		Container box = Box.createVerticalBox();
		this.newRute.add(box);

		JLabel lblAdd = new JLabel ("Crear Ruta");
		lblAdd.setFont(new Font("Tahoma",Font.PLAIN,25));
		box.add(lblAdd);
		box.add(Box.createVerticalStrut(10));

		ZoneChooser zoneChooser = new ZoneChooser(cdd.getParques());
		box.add(zoneChooser);
		box.add(Box.createVerticalStrut(10));

		String[] fields = {"Nmobre","Dificultad","Numero de chapas","Tipo de ruta",
		"Altura"};
		InfoAsker infoAsker = new InfoAsker(fields);
		box.add(infoAsker);
		box.add(Box.createVerticalStrut(20));

		JButton btnSend = new JButton("Send");
		box.add(btnSend);

		btnSend.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				ArrayList<String> list = zoneChooser.getStatus();
				list.addAll(infoAsker.getStatus());
				cdd.createRute(list);
				showHome();
			}  
		});  
	}

	private void setupNewZonePanel() {

		this.newZone = new JPanel();
		Container box = Box.createVerticalBox();
		this.newZone.add(box);

		JLabel lblAdd = new JLabel ("Crear zona");
		lblAdd.setFont(new Font("Tahoma",Font.PLAIN,25));
		box.add(lblAdd);
		box.add(Box.createVerticalStrut(10));

		ParkChooser parkChooser = new ParkChooser(cdd.getParques());
		box.add(parkChooser);
		box.add(Box.createVerticalStrut(10));

		String[] fields = {"Nmobre","Direccion imagen"};
		InfoAsker infoAsker = new InfoAsker(fields);
		box.add(infoAsker);
		box.add(Box.createVerticalStrut(20));

		JButton btnSend = new JButton("Send");
		box.add(btnSend);
		btnSend.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				ArrayList<String> list = infoAsker.getStatus();
				list.add(0, parkChooser.getStatus());
				cdd.createZone(list);
				showHome();
			}  
		});  

	}

	private void setupNewParkPanel() {
		this.newPark = new JPanel();
		Container box = Box.createVerticalBox();
		this.newPark.add(box);

		JLabel lblAdd = new JLabel ("Crear Parque");
		lblAdd.setFont(new Font("Tahoma",Font.PLAIN,25));
		box.add(lblAdd);
		box.add(Box.createVerticalStrut(10));

		String[] fields = {"Nmobre","Ubicacion","Link ubicacion","Temperatura Promedio",
				"Campeonato","Link parque","Direccion imagen"};
		InfoAsker infoAsker = new InfoAsker(fields);
		box.add(infoAsker);
		box.add(Box.createVerticalStrut(20));

		JButton btnSend = new JButton("Send");
		box.add(btnSend);
		btnSend.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				cdd.createPark(infoAsker.getStatus());
				showHome();
			}  
		});  
	}

	private void setupMenu() {
		JMenu menuPark = new JMenu("parque");
		JMenuItem newPark = new JMenuItem("parque nuevo");
		newPark.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setupNewParkPanel();
				showNewPark();
			}
		});
		menuPark.add(newPark);

		JMenuItem editPark = new JMenuItem("editar Parque");
		editPark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setupEditParkPanel();
				showEditPark();
			}
		});
		menuPark.add(editPark);

		JMenu menuZone = new JMenu("zona");
		JMenuItem newZone = new JMenuItem("zona nueva");
		newZone.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setupNewZonePanel();
				showNewZone();
			}
		});
		menuZone.add(newZone);
		JMenuItem editZone = new JMenuItem("editar zona");
		editZone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setupEditZonePanel();
				showEditZone();
			}
		});
		menuZone.add(editZone);

		JMenu menuRute = new JMenu("ruta");
		JMenuItem newRute = new JMenuItem("ruta nueva");
		newRute.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setupNewRutePanel();
				showNewRute();
			}
		});
		menuRute.add(newRute);

		JMenuItem save = new JMenuItem("guardar");
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				cdd.save();
			}
		});

		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menuPark);
		menuBar.add(menuZone);
		menuBar.add(menuRute);
		menuBar.add(save);
		this.setJMenuBar(menuBar);
	}


	protected void showHome() {
		this.remove(editPark);
		this.remove(editZone);
		this.remove(newPark);
		this.remove(newRute);
		this.remove(newZone);
		this.setSize(280,190);
	}


	protected void showNewRute() {
		this.showHome();
		this.add(newRute);
		this.pack();
	}

	protected void showEditZone() {
		this.showHome();
		this.add(editZone);
		this.pack();
	}

	protected void showNewZone() {
		this.showHome();
		this.add(newZone);
		this.pack();	
	}

	protected void showEditPark() {
		this.showHome();
		this.add(editPark);
		this.pack();	
	}

	protected void showNewPark() {
		this.showHome();
		this.add(newPark);
		this.pack();
	}




	class InfoAsker extends JPanel{

		public InfoAsker(String[] fields) {
			this.setLayout(new GridLayout(0,1));
			JLabel lbl;
			JTextField txtField;
			for (String string : fields) {
				lbl = new JLabel(string);
				this.add(lbl);
				txtField = new JTextField();
				txtField.setColumns(25);
				this.add(txtField);
			}
		}

		public ArrayList<String> getStatus(){
			ArrayList<String> status = new ArrayList<String>();
			for(Component comp : this.getComponents()) {
				if(comp.getClass().getSimpleName().equals("JTextField")) {
					JTextField txt = (JTextField)comp;
					status.add(txt.getText());
					txt.setText("");
				}
			}
			return status;
		}
	}

	class ParkChooser extends JPanel{

		JComboBox  parque;

		public ParkChooser(TreeMap<String,Parque> parks) {
			this.setLayout(new GridLayout(0,1));
			JLabel  lblParque = new JLabel("parque");
			this.add(lblParque);
			parque = new JComboBox ( parks.keySet().toArray());
			parque.setEditable(true);
			this.add(parque);
		}
		public String getStatus(){
			return (String) parque.getSelectedItem();
		}
	}

	class ZoneChooser extends JPanel{

		JComboBox  parque;
		JComboBox  zona;
		TreeMap<String,Parque> parks;

		public ZoneChooser(TreeMap<String,Parque> parks) {
			this.parks = parks;
			this.setLayout(new GridLayout(0,1));
			JLabel  lblParque = new JLabel("parque");
			this.add(lblParque);
			parque = new JComboBox( parks.keySet().toArray());
			parque.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JComboBox  cb = (JComboBox)e.getSource();
					actualizeComboboxZone((String)cb.getSelectedItem());
				}
			});
			parque.setEditable(true);
			this.add(parque);

			JLabel lblZone = new JLabel("zona");
			this.add(lblZone);
			zona = new JComboBox( parks.get(parque.getSelectedItem()).getZonas().keySet().toArray());
			zona.setEditable(true);
			this.add(zona);
		}
		protected void actualizeComboboxZone(String selectedItem) {
			this.remove(zona);
			zona =  new JComboBox ( parks.get(selectedItem).getZonas().keySet().toArray());
			this.add(zona);
			this.validate();
		}
		public ArrayList<String> getStatus(){
			ArrayList<String> status = new ArrayList<String>();
			status.add((String) parque.getSelectedItem());
			status.add((String) zona.getSelectedItem());
			return status;
		}
	}

}