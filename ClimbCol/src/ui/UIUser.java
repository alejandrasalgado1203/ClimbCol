
package ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import business.ClimbersManager;
import data.Escalador;
import data.Ruta;

public class UIUser extends JFrame {

	private Escalador climber;
	private UIMain uiMain;
	private JPanel userPanel;
	private JPanel editPanel;
	private GridBagConstraints constraints = new GridBagConstraints();

	public UIUser(UIMain main) {
		super("User's info");
		this.climber = ClimbersManager.getCurrentUser();
		this.uiMain = main;
		createMenu();
		showUserPanel();
		this.setResizable(true);
		this.pack();
		this.setVisible(true);
	}

	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenuItem menuItemEdit = new JMenuItem("Edit");
		menuBar.add(menuItemEdit);
		menuItemEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showEditPanel();
			}
		});
		this.setJMenuBar(menuBar);
	}

	private void showUserPanel() {
		this.userPanel = new JPanel(new GridBagLayout());
		this.constraints.insets = new Insets(10,10,10,10);
		createTittle();
		createImage();
		createInfo();
		createButtons();
		this.add(userPanel);
		this.pack();
	}

	private void createTittle() {
		JLabel lblTittle = new JLabel(this.climber.getName());
		lblTittle.setFont(new Font("Tahoma",Font.PLAIN,35));
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		this.addGB(userPanel,lblTittle, 0, 0);
	}

	private void createImage() {
		ImageIcon user= new ImageIcon(this.climber.getDireccionImagen());
		JLabel labelImage = new JLabel(user);
		constraints.gridheight = 2;
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.CENTER;
		this.addGB(userPanel,labelImage, 0, 1);
	}

	private   void createInfo() { 
		JPanel infoPanel = new JPanel(new GridLayout(0,1));

		JLabel lbl = new JLabel("Birthdate: " + climber.getFechaDeNacimiento());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);
		lbl = new JLabel("Achieved routes: " + climber.getLogradas());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);
		lbl = new JLabel("Favorite climbing: " + climber.getEscaladaFavorita());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);
		lbl = new JLabel("Maximum difficulty achieved: " + climber.getMaximaDificultadLograda());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);

		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.CENTER;
		this.addGB(userPanel, infoPanel, 1, 1);
	}

	private void createButtons() {
		JPanel btnsPanel = new JPanel(); 

		JRadioButton buttonGoals= new JRadioButton("Grupo de Retos");
		buttonGoals.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setupPanelRutes(climber.getRetos().values());
			}
		});

		JRadioButton buttonFavorites = new JRadioButton("Favoritos");
		buttonFavorites.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setupPanelRutes(climber.getFavoritos().values());
			}
		});

		ButtonGroup bg = new ButtonGroup();
		bg.add(buttonFavorites);
		bg.add(buttonGoals);

		btnsPanel.add(buttonGoals);
		btnsPanel.add(buttonFavorites);

		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.CENTER;
		this.addGB(userPanel, btnsPanel, 1, 2);
	}

	private void setupPanelRutes(Collection<Ruta> collection) {
		DefaultListModel<Ruta> model = new DefaultListModel<>();
		for (Ruta r: collection) {
			model.addElement(r);
		}
		JList <Ruta> listRutes = new JList <Ruta> (model);
		listRutes.setCellRenderer(new Renderer());
		JScrollPane scrollPaneRoutes = new JScrollPane(listRutes);

		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.CENTER;
		this.addGB(userPanel, scrollPaneRoutes, 1, 3);

		listRutes.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				Ruta rute = listRutes.getSelectedValue();
				uiMain.showPanel(UIRute.createUIRute(rute, uiMain));	
			}
		});
	}

	private void showEditPanel() {
		this.editPanel = new JPanel(new GridBagLayout());
		createEditImage();
		creatEditInfo();
		createEditButtons();
		this.remove(userPanel);
		this.add(editPanel, BorderLayout.CENTER);
		this.pack();
	}

	private void createEditImage() {
		ImageIcon user= new ImageIcon(this.climber.getDireccionImagen());
		JLabel labelImage = new JLabel(user);
		constraints.gridheight = 2;
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.CENTER;
		this.addGB(editPanel,labelImage, 0, 0);
	}

	private void creatEditInfo() {
		JPanel editInfoPanel = new JPanel(new GridLayout(0,1));

		JLabel lbl = new JLabel("Birthdate: ");
		lbl.setFont(new Font("Tahoma",Font.PLAIN,15));
		editInfoPanel.add(lbl);
		JTextField txtBirthdate = new JTextField();
		editInfoPanel.add(txtBirthdate);
		lbl = new JLabel("Achieved routes: ");
		lbl.setFont(new Font("Tahoma",Font.PLAIN,15));
		editInfoPanel.add(lbl);
		JTextField txtAchievedRoutes = new JTextField();
		editInfoPanel.add(txtAchievedRoutes);
		lbl = new JLabel("Favorite climbing: ");
		lbl.setFont(new Font("Tahoma",Font.PLAIN,15));
		editInfoPanel.add(lbl);
		JTextField txtFavoriteClimbing = new JTextField();
		editInfoPanel.add(txtFavoriteClimbing);
		lbl = new JLabel("Maximum difficulty achieved: ");
		lbl.setFont(new Font("Tahoma",Font.PLAIN,15));
		editInfoPanel.add(lbl);
		JTextField txtMaxDifficulty = new JTextField();
		editInfoPanel.add(txtMaxDifficulty);

		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.CENTER;
		this.addGB(editPanel, editInfoPanel, 1, 0);
	}

	private void createEditButtons() {
		JButton btnEditImage = new JButton("Edit Image");
		btnEditImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		this.addGB(editPanel, btnEditImage, 0, 2);

		JButton btnSave = new JButton("save");
		btnSave.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {

			}
		});
		this.addGB(editPanel, btnSave, 0, 3);

		JButton btnCancel = new JButton("cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(editPanel);
				showUserPanel();
			}
		});
		this.addGB(editPanel, btnCancel, 1, 3);
	}

	private void addGB(JPanel jp,Component comp, int x, int y) {
		constraints.gridx = x;
		constraints.gridy = y;
		jp.add(comp, constraints);
	}


	//Sign in
	public static void showSignInFrame() {
		JFrame frame = new JFrame ();

		JLabel nameLabel= new JLabel("Name: ");
		JTextField nameField =  new JTextField(25);

		nameField.setInputVerifier(new InputVerifier() {
			public boolean verify(JComponent input) {
				JTextField tf = (JTextField) input;
				boolean b = ClimbersManager.isValidName(tf.getText());
				if(!b) {
					input.getToolkit().beep();
					JOptionPane.showMessageDialog(null, "already exist an user with this name",
							null, JOptionPane.WARNING_MESSAGE);
				}
				return b;
			}
		});

		JLabel passwordLabel = new JLabel ("Password: ");
		JPasswordField passwordField = new JPasswordField(25);

		passwordField.setInputVerifier(new InputVerifier() {
			public boolean verify(JComponent input) {
				JPasswordField pf = (JPasswordField) input;
				boolean b = ClimbersManager.isValidPassword(pf.getPassword());
				if(!b) {
					input.getToolkit().beep();
					JOptionPane.showMessageDialog(null, "the password is too short or already exist",
							null, JOptionPane.WARNING_MESSAGE);
				}
				return b;
			}
		});

		JButton btnSignIn = new JButton ("Sign in");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nameField.getText().isEmpty()|| passwordField.getPassword().length==0) {
					JOptionPane.showMessageDialog(null,"A space is Empty",null,JOptionPane.ERROR_MESSAGE);	
				}else {
					Window w = SwingUtilities.getWindowAncestor(btnSignIn);
					if (w != null) 
						w.setVisible(false);
					ClimbersManager.creatUser(nameField.getText(),passwordField.getPassword());
					JOptionPane.showMessageDialog(null,"The user was create");
				}
			}
		});

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window w = SwingUtilities.getWindowAncestor(btnCancel);
				if(w!=null)
					w.setVisible(false);
			}
		});


		Object [] message = new Object[] {nameLabel,nameField,passwordLabel,passwordField};
		Object[] options = new Object[] {btnSignIn, btnCancel};
		JOptionPane.showOptionDialog(frame, message, "Sign in", 0,
				JOptionPane.QUESTION_MESSAGE, null, options, btnSignIn);
	}

	//login
	public static void showLoginFrame() {
		JFrame frame = new JFrame();

		JLabel nameLabel= new JLabel("Name: ");
		JTextField nameField =  new JTextField(25);

		JLabel passwordLabel = new JLabel ("Password: ");
		JPasswordField passwordField = new JPasswordField(25);

		JButton btnLogin = new JButton ("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ClimbersManager.doLogin(nameField.getText(),passwordField.getPassword())) {
					Window w = SwingUtilities.getWindowAncestor(btnLogin);
					if (w!=null) 
						w.setVisible(false);
					JOptionPane.showMessageDialog(null,"The Login was successful");
				}else {
					JOptionPane.showMessageDialog(null,"the password or the names are incorrect or you are not register yet",
							null,JOptionPane.ERROR_MESSAGE);
					nameField.setText(null);
					passwordField.setText(null);;
				}
			}
		});

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window w = SwingUtilities.getWindowAncestor(btnCancel);
				if(w!=null)
					w.setVisible(false);
			}
		});

		Object [] message = new Object[] {nameLabel,nameField,passwordLabel,passwordField};
		Object[] options = new Object[] {btnLogin, btnCancel};
		JOptionPane.showOptionDialog(frame, message, "Login", 0,
				JOptionPane.QUESTION_MESSAGE, null, options, btnLogin);
	}
}
