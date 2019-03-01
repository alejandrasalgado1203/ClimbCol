
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import business.ClimbersManager;
import data.Escalador;
import data.Ruta;

public class UIUser extends JFrame {
	private JPanel panelTittle = new JPanel();
	private JPanel panelAll = new JPanel(new GridLayout(1,2));
	private JPanel panelInfo = new JPanel(new GridLayout(0,1));
	private Escalador climber;
	private UIMain uiMain;

	public UIUser(Escalador climber) throws HeadlessException {
		super("info User");
		this.climber = climber;
		setupMainPanel();
		this.panelAll.add(panelInfo);
		this.add(panelAll, BorderLayout.CENTER);
		this.setResizable(true);
		this.pack();
		this.setVisible(true);
	}
	public   void setupMainPanel() {
		createTittle();
		createImage();
		createTextField();
		creatSpinner();
		createButtons();
	}

	public   void createTittle() {
		JLabel lblWelcomeUser = new JLabel(this.climber.getName());
		lblWelcomeUser.setFont(new Font("Tahoma",Font.PLAIN,35));
		panelTittle.add(lblWelcomeUser);
		this.add(panelTittle,BorderLayout.NORTH);
	}

	private void createImage() {
		JPanel imageUser= new JPanel();
		ImageIcon user= new ImageIcon(this.climber.getDireccionImagen());
		JLabel labelImage = new JLabel(user);
		labelImage.setVisible(true);
		imageUser.add(labelImage);
		this.panelAll.add(imageUser);
	}

	public   void createTextField() { 
		JTextField textfield = new JTextField(30);
		textfield.setEditable(false);
		textfield.setText(this.climber.toString());
		this.panelInfo.add(textfield);
	}

	private void creatSpinner() {
		JSpinner spinnLogradas = new JSpinner();


		this.panelInfo.add(spinnLogradas);
	}

	public   void createButtons() {

		JPanel btns = new JPanel(); 
		JRadioButton buttonGoals= new JRadioButton("Grupo de Retos");
		buttonGoals.setForeground(Color.BLACK);
		buttonGoals.setBackground(Color.WHITE);

		JRadioButton buttonFavorites = new JRadioButton("Favoritos");
		buttonFavorites.setForeground(Color.BLACK);
		buttonFavorites.setBackground(Color.WHITE);

		ButtonGroup bg = new ButtonGroup();
		bg.add(buttonFavorites);
		bg.add(buttonGoals);

		btns.add(buttonGoals);
		btns.add(buttonFavorites);
		buttonGoals.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setuoPanelRutes(climber.getRetos().values());
			}

		});

		buttonFavorites.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setuoPanelRutes(climber.getFavoritos().values());
			}
		});
		this.panelInfo.add(btns);
	}

	public   void setuoPanelRutes(Collection<Ruta> collection) {//modificar
		DefaultListModel<Ruta> model = new DefaultListModel<>();
		for (Ruta r: collection) {
			model.addElement(r);
		}
		JList <Ruta> listRutes = new JList <Ruta> (model);
		listRutes.setCellRenderer(new Renderer());
		JScrollPane scrollPaneRutes = new JScrollPane(listRutes);

		showPanelRutes(scrollPaneRutes);

		listRutes.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				Ruta rute = listRutes.getSelectedValue();
				uiMain.showPanel(UIRute.createUIRute(rute, uiMain));	
			}
		});

	}

	private void showPanelRutes(JScrollPane scrollPaneParks) {
		if (this.panelInfo.getComponentCount()==4)
			this.panelInfo.remove(3);
		this.panelInfo.add(scrollPaneParks);
	}



	private void setupPanelAdd(UIMain main) {
		JLabel nameLabel= new JLabel("User: ");
		JLabel passwordLabel = new JLabel ("Password: ");;
		JTextField nameField =  new JTextField();
		nameField.setColumns(25);
		JTextField passwordField = new JTextField();
		passwordField.setColumns(25);
		JPanel userPane = new JPanel();
		JPanel passwordPane = new JPanel();
		JPanel panelAddUser = new JPanel(new GridLayout(0,1));

		JLabel lblAdd = new JLabel ("Sign in");
		lblAdd.setFont(new Font("Tahoma",Font.PLAIN,25));
		panelAddUser.add(lblAdd);

		userPane.add(nameLabel);
		userPane.add(nameField);
		passwordPane.add(passwordLabel);
		passwordPane.add(passwordField);

		panelAddUser.add(userPane);
		panelAddUser.add(passwordPane);

		JRadioButton btnSend = new JRadioButton ("Send");
		panelAddUser.add(btnSend);

		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(nameField.getText().equals("")|| passwordField.getText().equals("") ) {
					indicateSpaceEmpty();	
					Escalador es = new Escalador (nameField.getText(),passwordField.getText());
					ClimbersManager.put(es);
				}
				passwordField.setText("");
				nameField.setText("");
				remove(panelAddUser);

			}
		});

		//panelSignIn.add(panelAddUser);
		//this.add(panelSignIn);
	}
	public void showPanelAdd(UIMain main) {
		setupPanelAdd(main);
		this.setVisible(true);
	}
	public void indicateSpaceEmpty() {
		JOptionPane.showMessageDialog(this,"A space is Empty");
	}

}
