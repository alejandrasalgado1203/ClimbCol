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
import java.util.TreeSet;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
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
import data.Zona;


public class UICreardorDeDatos extends JFrame{

	private static final long serialVersionUID = 3948533140531215034L;
	private CreadorDeDatos cdd;
	private JPanel newPark = new JPanel();
	private JPanel newZone = new JPanel();
	private JPanel newRute = new JPanel();
	private JPanel editPark = new JPanel();
	private JPanel editZone = new JPanel();


	public UICreardorDeDatos(CreadorDeDatos cdd) {
		super();
		this.cdd = cdd;
		this.setTitle("data creator");
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

		JLabel lblAdd = new JLabel ("edit zone");
		lblAdd.setFont(new Font("Tahoma",Font.PLAIN,25));
		box.add(lblAdd);
		box.add(Box.createVerticalStrut(10));

		ZoneChooser zoneChooser = new ZoneChooser(cdd.getParques());
		box.add(zoneChooser);
		box.add(Box.createVerticalStrut(10));


		String[] fields = {"Image path"};
		InfoAsker infoAsker = new InfoAsker(fields);
		box.add(infoAsker);
		box.add(Box.createVerticalStrut(20));

		JButton btnSend = new JButton("Send");
		btnSend.setMnemonic(Event.ENTER);
		box.add(btnSend);

		btnSend.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				cdd.editZone(infoAsker.getStatus(),zoneChooser.getStatus());
				showHome();
			}  
		});  
	}

	private void setupEditParkPanel() {
		this.editPark = new JPanel();
		Container box = Box.createVerticalBox();
		this.editPark.add(box);

		JLabel lblAdd = new JLabel ("edit park");
		lblAdd.setFont(new Font("Tahoma",Font.PLAIN,25));
		box.add(lblAdd);
		box.add(Box.createVerticalStrut(10));

		ParkChooser parkChooser = new ParkChooser(cdd.getParques());
		box.add(parkChooser);
		box.add(Box.createVerticalStrut(10));

		String[] fields = {"Image path"};
		InfoAsker infoAsker = new InfoAsker(fields);
		box.add(infoAsker);
		box.add(Box.createVerticalStrut(20));

		JButton btnSend = new JButton("Send");
		btnSend.setMnemonic(Event.ENTER);
		box.add(btnSend);

		btnSend.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				cdd.editPark(infoAsker.getStatus(),parkChooser.getStatus());
				showHome();
			}  
		}); 
	}

	private void setupNewRutePanel() {

		this.newRute = new JPanel();
		Container box = Box.createVerticalBox();
		this.newRute.add(box);

		JLabel lblAdd = new JLabel ("Create ruote");
		lblAdd.setFont(new Font("Tahoma",Font.PLAIN,25));
		box.add(lblAdd);
		box.add(Box.createVerticalStrut(10));

		ZoneChooser zoneChooser = new ZoneChooser(cdd.getParques());
		box.add(zoneChooser);
		box.add(Box.createVerticalStrut(10));

		String[] fields = {"Name","Difficulty","Number of plates","Route type",
		"height"};
		InfoAsker infoAsker = new InfoAsker(fields);
		box.add(infoAsker);
		box.add(Box.createVerticalStrut(20));

		JButton btnSend = new JButton("Send");
		box.add(btnSend);

		btnSend.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				cdd.createRute(infoAsker.getStatus(),zoneChooser.getStatus());
				showHome();
			}  
		});  
	}

	private void setupNewZonePanel() {

		this.newZone = new JPanel();
		Container box = Box.createVerticalBox();
		this.newZone.add(box);

		JLabel lblAdd = new JLabel ("Create zone");
		lblAdd.setFont(new Font("Tahoma",Font.PLAIN,25));
		box.add(lblAdd);
		box.add(Box.createVerticalStrut(10));

		ParkChooser parkChooser = new ParkChooser(cdd.getParques());
		box.add(parkChooser);
		box.add(Box.createVerticalStrut(10));

		String[] fields = {"Name","Image path"};
		InfoAsker infoAsker = new InfoAsker(fields);
		box.add(infoAsker);
		box.add(Box.createVerticalStrut(20));

		JButton btnSend = new JButton("Send");
		box.add(btnSend);
		btnSend.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				ArrayList<String> info = infoAsker.getStatus();
				cdd.createZone(info, parkChooser.getStatus());
				showHome();
			}  
		});  

	}

	private void setupNewParkPanel() {
		this.newPark = new JPanel();
		Container box = Box.createVerticalBox();
		this.newPark.add(box);

		JLabel lblAdd = new JLabel ("Create park");
		lblAdd.setFont(new Font("Tahoma",Font.PLAIN,25));
		box.add(lblAdd);
		box.add(Box.createVerticalStrut(10));

		String[] fields = {"Name","Ubication","Link ubication","average temperature",
				"altitude","Link park","imag path"};
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
		JMenu menuPark = new JMenu("park");
		JMenuItem newPark = new JMenuItem("new park");
		newPark.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setupNewParkPanel();
				showNewPark();
			}
		});
		menuPark.add(newPark);

		JMenuItem editPark = new JMenuItem("edit parqk");
		editPark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setupEditParkPanel();
				showEditPark();
			}
		});
		menuPark.add(editPark);

		JMenu menuZone = new JMenu("zone");
		JMenuItem newZone = new JMenuItem("new zone");
		newZone.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setupNewZonePanel();
				showNewZone();
			}
		});
		menuZone.add(newZone);
		JMenuItem editZone = new JMenuItem("edit zone");
		editZone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setupEditZonePanel();
				showEditZone();
			}
		});
		menuZone.add(editZone);

		JMenu menuRute = new JMenu("route");
		JMenuItem newRute = new JMenuItem("new route");
		newRute.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setupNewRutePanel();
				showNewRute();
			}
		});
		menuRute.add(newRute);

		JMenuItem save = new JMenuItem("save");
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

		private static final long serialVersionUID = -125891320999749783L;

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

		private static final long serialVersionUID = -3632316906732791719L;
		JComboBox <Parque>  parks;

		public ParkChooser(TreeSet<Parque> parks) {
			this.setLayout(new GridLayout(0,1));
			JLabel  lblPark = new JLabel("park");
			this.add(lblPark);
			DefaultComboBoxModel<Parque> model = new DefaultComboBoxModel<>();
			for(Parque park : parks) {
				model.addElement(park);
			}
			this.parks = new JComboBox <Parque> (model);
			this.add(this.parks);
		}
		public Parque getStatus(){
			return (Parque) parks.getSelectedItem();
		}
	}

	class ZoneChooser extends JPanel{

		private static final long serialVersionUID = 1508471468384862963L;
		JComboBox <Parque> parks;
		JComboBox <Zona> zones;

		public ZoneChooser(TreeSet<Parque> parks) {
			this.setLayout(new GridLayout(0,1));
			JLabel  lblPark = new JLabel("park");
			this.add(lblPark);

			DefaultComboBoxModel<Parque> modelParks = new DefaultComboBoxModel<>();
			for(Parque park : parks) {
				modelParks.addElement(park);
			}
			this.parks = new JComboBox <Parque> (modelParks);
			this.parks.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actualizeComboboxZone();
				}
			});
			this.add(this.parks);

			JLabel lblZone = new JLabel("zone");
			this.add(lblZone);
			DefaultComboBoxModel<Zona> modelZone = new DefaultComboBoxModel<>();
			Parque p = (Parque) this.parks.getSelectedItem();
			for(Zona zone : p.getZonas()) {
				modelZone.addElement(zone);
			}
			zones = new JComboBox <Zona> (modelZone);
			this.add(zones);
		}
		protected void actualizeComboboxZone() {
			this.remove(zones);
			DefaultComboBoxModel<Zona> modelZone = new DefaultComboBoxModel<>();
			Parque p = (Parque) parks.getSelectedItem();
			for(Zona zone : p.getZonas()) {
				modelZone.addElement(zone);
			}
			zones = new JComboBox <Zona> (modelZone);

			this.add(zones);
			this.validate();
		}
		public Zona getStatus(){
			return (Zona) zones.getSelectedItem();
		}
	}

}