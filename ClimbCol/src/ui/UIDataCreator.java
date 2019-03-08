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

import business.DataCreator;
import data.Park;
import data.Zone;


public class UIDataCreator extends JFrame{

	private static final long serialVersionUID = 3948533140531215034L;
	private DataCreator cdd;
	private JPanel newPark = new JPanel();
	private JPanel newZone = new JPanel();
	private JPanel newRoute = new JPanel();
	private JPanel editPark = new JPanel();
	private JPanel editZone = new JPanel();


	public UIDataCreator(DataCreator cdd) {
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

		ZoneChooser zoneChooser = new ZoneChooser(cdd.getParks());
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

		ParkChooser parkChooser = new ParkChooser(cdd.getParks());
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

	private void setupNewRoutePanel() {

		this.newRoute = new JPanel();
		Container box = Box.createVerticalBox();
		this.newRoute.add(box);

		JLabel lblAdd = new JLabel ("Create route");
		lblAdd.setFont(new Font("Tahoma",Font.PLAIN,25));
		box.add(lblAdd);
		box.add(Box.createVerticalStrut(10));

		ZoneChooser zoneChooser = new ZoneChooser(cdd.getParks());
		box.add(zoneChooser);
		box.add(Box.createVerticalStrut(10));

		String[] fields = {"Name","Difficulty","Number of plates","Route type",
		"height","Image"};
		InfoAsker infoAsker = new InfoAsker(fields);
		box.add(infoAsker);
		box.add(Box.createVerticalStrut(20));

		JButton btnSend = new JButton("Send");
		box.add(btnSend);

		btnSend.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				cdd.createRoute(infoAsker.getStatus(),zoneChooser.getStatus());
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

		ParkChooser parkChooser = new ParkChooser(cdd.getParks());
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
				setupNewRoutePanel();
				showNewRoute();
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
		this.setContentPane(null);
		this.setSize(280,190);
	}


	protected void showNewRoute() {
		this.setContentPane(newRoute);
		this.pack();
	}

	protected void showEditZone() {
		this.setContentPane(editZone);
		this.pack();
	}

	protected void showNewZone() {
		this.setContentPane(newZone);
		this.pack();	
	}

	protected void showEditPark() {
		this.setContentPane(editPark);
		this.pack();	
	}

	protected void showNewPark() {
		this.setContentPane(newPark);
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
		JComboBox <Park>  parks;

		public ParkChooser(TreeSet<Park> parks) {
			this.setLayout(new GridLayout(0,1));
			JLabel  lblPark = new JLabel("park");
			this.add(lblPark);
			DefaultComboBoxModel<Park> model = new DefaultComboBoxModel<>();
			for(Park park : parks) {
				model.addElement(park);
			}
			this.parks = new JComboBox <Park> (model);
			this.add(this.parks);
		}
		public Park getStatus(){
			return (Park) parks.getSelectedItem();
		}
	}

	class ZoneChooser extends JPanel{

		private static final long serialVersionUID = 1508471468384862963L;
		JComboBox <Park> parks;
		JComboBox <Zone> zones;

		public ZoneChooser(TreeSet<Park> parks) {
			this.setLayout(new GridLayout(0,1));
			JLabel  lblPark = new JLabel("park");
			this.add(lblPark);

			DefaultComboBoxModel<Park> modelParks = new DefaultComboBoxModel<>();
			for(Park park : parks) {
				modelParks.addElement(park);
			}
			this.parks = new JComboBox <Park> (modelParks);
			this.parks.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actualizeComboboxZone();
				}
			});
			this.add(this.parks);

			JLabel lblZone = new JLabel("zone");
			this.add(lblZone);
			DefaultComboBoxModel<Zone> modelZone = new DefaultComboBoxModel<>();
			Park p = (Park) this.parks.getSelectedItem();
			for(Zone zone : p.getZones()) {
				modelZone.addElement(zone);
			}
			zones = new JComboBox <Zone> (modelZone);
			this.add(zones);
		}
		protected void actualizeComboboxZone() {
			this.remove(zones);
			DefaultComboBoxModel<Zone> modelZone = new DefaultComboBoxModel<>();
			Park p = (Park) parks.getSelectedItem();
			for(Zone zone : p.getZones()) {
				modelZone.addElement(zone);
			}
			zones = new JComboBox <Zone> (modelZone);

			this.add(zones);
			this.validate();
		}
		public Zone getStatus(){
			return (Zone) zones.getSelectedItem();
		}
	}

}