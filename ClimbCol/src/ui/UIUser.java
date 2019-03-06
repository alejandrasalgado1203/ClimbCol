package ui;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Locale;
import java.util.TreeSet;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import business.ClimbersManager;
import data.Escalador;
import data.Ruta;


public class UIUser extends JFrame {

	private Escalador climber;
	private UIMain uiMain;
	private JPanel userPanel;
	private JPanel editPanel;
	private GridBagConstraints constraints = new GridBagConstraints();
	private String [] editValues;

	public UIUser(UIMain main) {
		super("User's info");
		this.climber = ClimbersManager.getCurrentUser();
		this.uiMain = main;
		createMenu();
		showUserPanel();
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				uiMain.createMenuBar();
				setVisible(false);
			}
		});
		this.setResizable(true);
		this.pack();
		this.setVisible(true);
	}

	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenuItem editInfo = new JMenuItem("Edit info");
		menuBar.add(editInfo);
		editInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showEditInfoPanel();
			}
		});

		JMenuItem editFavorites = new JMenuItem("Edit favorites");
		menuBar.add(editFavorites);
		editFavorites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showEditRoutesPanel(climber.getFavoritos(),"favorites");
			}
		});

		JMenuItem editGoals = new JMenuItem("Edit goals");
		menuBar.add(editGoals);
		editGoals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showEditRoutesPanel(climber.getRetos(),"goals");
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
		this.setContentPane(userPanel);
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

		JLabel lbl = new JLabel("Birthdate: " + 
				climber.getFechaDeNacimiento().format(DateTimeFormatter.ofPattern( "d MMMM uuuu")));
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
				setupPanelRutes(climber.getRetos());
			}
		});

		JRadioButton buttonFavorites = new JRadioButton("Favoritos");
		buttonFavorites.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setupPanelRutes(climber.getFavoritos());
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

	private void showEditInfoPanel() {
		this.editPanel = new JPanel(new GridBagLayout());
		this.editValues = new String [] {"","","","",""};
		createEditImage();
		creatEditInfo();
		createEditButtons();
		this.setContentPane(editPanel);
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
		JFormattedTextField txtBirthdate = new JFormattedTextField(
				DateTimeFormatter.ofPattern( "d MMMM uuuu").toFormat());
		txtBirthdate.setValue(climber.getFechaDeNacimiento());
		txtBirthdate.addPropertyChangeListener("value", new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				editValues [0] = txtBirthdate.getText();
			}

		});
		editInfoPanel.add(txtBirthdate);

		lbl = new JLabel("Achieved routes: ");
		lbl.setFont(new Font("Tahoma",Font.PLAIN,15));
		editInfoPanel.add(lbl);
		JFormattedTextField txtAchievedRoutes = new JFormattedTextField(
				NumberFormat.getIntegerInstance());
		txtAchievedRoutes.setValue(climber.getLogradas());
		txtAchievedRoutes.addPropertyChangeListener("value", new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				editValues [1] = txtAchievedRoutes.getText();
			}

		});
		editInfoPanel.add(txtAchievedRoutes);

		lbl = new JLabel("Favorite climbing: ");
		lbl.setFont(new Font("Tahoma",Font.PLAIN,15));
		editInfoPanel.add(lbl);
		JTextField txtFavoriteClimbing = new JTextField(climber.getEscaladaFavorita());
		txtFavoriteClimbing.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				edit();
			}
			public void removeUpdate(DocumentEvent e) {
				edit();
			}
			public void insertUpdate(DocumentEvent e) {
				edit();
			}
			public void edit() {
				editValues [2] = txtFavoriteClimbing.getText();
			}
		});

		editInfoPanel.add(txtFavoriteClimbing);

		lbl = new JLabel("Maximum difficulty achieved: ");
		lbl.setFont(new Font("Tahoma",Font.PLAIN,15));
		editInfoPanel.add(lbl);
		JFormattedTextField txtMaxDifficulty = new JFormattedTextField(NumberFormat.getInstance(Locale.ENGLISH));
		txtMaxDifficulty.setValue(climber.getMaximaDificultadLograda());
		txtMaxDifficulty.addPropertyChangeListener("value", new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				editValues [3] =  txtMaxDifficulty.getText();
			}

		});

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
				loadImage();
			}
		});
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		this.addGB(editPanel, btnEditImage, 0, 2);

		JButton btnSave = new JButton("save");
		btnSave.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				ClimbersManager.editUser(editValues);
				showUserPanel();
			}
		});
		this.addGB(editPanel, btnSave, 0, 3);

		JButton btnCancel = new JButton("cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showUserPanel();
			}
		});
		this.addGB(editPanel, btnCancel, 1, 3);
	}

	private void loadImage() {
		JFileChooser imageChooser = new JFileChooser();
		imageChooser.setDialogTitle("Edit image");
		imageChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		imageChooser.setFileFilter(new FileNameExtensionFilter("images", "png", "gif","jpg"));
		int returnVal = imageChooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) 
			editValues [4] = imageChooser.getSelectedFile().getPath();
	}

	private void showEditRoutesPanel(TreeSet<Ruta> treeSet, String item) {
		DefaultListModel<Ruta> model = new DefaultListModel<>();
		for (Ruta r: treeSet) {
			model.addElement(r);
		}
		JList <Ruta> listRutes = new JList <Ruta> (model);
		listRutes.setCellRenderer(new Renderer());
		JScrollPane scrollPaneRoutes = new JScrollPane(listRutes);

		JButton btnDelete = new JButton("delete selected items");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Ruta r : listRutes.getSelectedValuesList()) {
					ClimbersManager.removeRoute(r,item);
				}
			}
		});
		this.editPanel = new JPanel(new GridBagLayout());
		this.constraints.gridheight = 1;
		this.constraints.gridwidth = 0;
		this.addGB(editPanel,scrollPaneRoutes,0,0);
		this.addGB(editPanel,btnDelete,0,1);
		this.setContentPane(editPanel);
		this.pack();
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

		JLabel passwordRulesLbl = new JLabel("*the password must have more than 5 characters");
		passwordRulesLbl.setFont(new Font("Tahoma",Font.PLAIN,12));

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


		Object [] message = new Object[] {nameLabel,nameField,passwordLabel,
				passwordField,passwordRulesLbl };
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
					JOptionPane.showMessageDialog(null,"the password or the names are incorrect "
							+ "or you are not register yet",
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
