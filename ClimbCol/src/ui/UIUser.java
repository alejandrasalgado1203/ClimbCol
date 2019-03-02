
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
	//private static JFrame signInFrame;

	public UIUser(Escalador climber) {
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

	public void createTittle() {
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

	public void createButtons() {

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


	//Sign in
	public static void showSignInFrame() {
		JFrame signInFrame = setupSignInFrame();
		signInFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		signInFrame.pack();
		signInFrame.setLocation(200, 200);
		signInFrame.setVisible(true);
	}

	private static JFrame setupSignInFrame() {
		JFrame signInFrame = new JFrame("CLIMBCOL");
		signInFrame.setLayout(new GridLayout(0,1));

		JLabel lblTittle = new JLabel ("Sign in");
		lblTittle.setFont(new Font("Tahoma",Font.PLAIN,25));
		signInFrame.add(lblTittle);

		JLabel nameLabel= new JLabel("Name: ");
		JTextField nameField =  new JTextField(25);
		signInFrame.add(nameLabel);
		signInFrame.add(nameField);

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
		signInFrame.add(passwordLabel);
		signInFrame.add(passwordField);

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

		JButton btnSend = new JButton ("Send");
		JPanel jp = new JPanel();
		jp.add(btnSend);
		signInFrame.add(jp);

		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nameField.getText().isEmpty()|| passwordField.getPassword().length==0) {
					JOptionPane.showMessageDialog(null,"A space is Empty",null,JOptionPane.ERROR_MESSAGE);	
				}else {
					ClimbersManager.creatUser(nameField.getText(),passwordField.getPassword());
					signInFrame.dispatchEvent(new WindowEvent(signInFrame, WindowEvent.WINDOW_CLOSING));
					JOptionPane.showMessageDialog(null,"The user was create");
				}

			}
		});
		return signInFrame;
	}
}
