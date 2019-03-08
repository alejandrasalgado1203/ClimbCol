package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JPanel;
import business.UsersManager;
import data.Route;

public class UIRute extends JPanel{
	private   JPanel panelRute= new JPanel();
	private   JPanel centerPanel = new JPanel();
	private Route rute;
	private UIMain uiMain;

	public static   UIRute createUIRute(Route rute,UIMain main){
		return new UIRute(rute,main);
	}
	public UIRute(Route rute, UIMain main) {
		this.rute =rute;
		this.uiMain = main;
		this.setLayout(new BorderLayout());
		this.setupMainPanel();
	}
	private   void setupMainPanel() {
		createTittle();
		createImage();
		createDescription();
		goToLastAndNextPanel();
	}
	private   void createTittle() {
		JPanel tittle = new JPanel(new GridLayout(0,1));
		JLabel lblWelcomeRute = new JLabel("RUTA "+ this.rute.getName());
		lblWelcomeRute.setFont(new Font("Tahoma",Font.PLAIN,35));
		tittle.add(createToolBar());
		tittle.add(lblWelcomeRute);
		this.add(lblWelcomeRute,BorderLayout.NORTH);
	}
	private  void createImage() {
		ImageIcon Rute= new ImageIcon(rute.getImagePath());
		JLabel labelImage = new JLabel(Rute);
		centerPanel.add(labelImage);
	}
	private   void createDescription() {
		JPanel infoPanel = new JPanel(new GridLayout(0,1));

		JLabel lbl = new JLabel("Dificultad: " + rute.getDifficulty());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);
		lbl = new JLabel("Numero de Chapas: " + rute.getNumberOfPlates());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);
		lbl = new JLabel("Tipo de Rute: " + rute.getRouteType());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);
		lbl = new JLabel("Altura: " + rute.getHeight());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);


		centerPanel.add(infoPanel);
		this.add(centerPanel,BorderLayout.CENTER);
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
				uiMain.showPanel(UIPark.createUIPark(rute.getZone().getPark(),uiMain));
			}  
		});

		JButton b3=new JButton("Return to Zone");  
		b3.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				uiMain.showPanel(UIZone.createUIZone(rute.getZone(),uiMain));
			}  
		});


		southPanel.add(b1);
		southPanel.add(b2);
		southPanel.add(b3);
		this.add(southPanel, BorderLayout.SOUTH);
	}

	private JToolBar createToolBar() {
		JToolBar toolBar = new JToolBar();

		JButton buttonGoals = new JButton("Agregar a lista Retos");
		buttonGoals.setActionCommand("Goals");
		JButton buttonFavorites = new JButton("Agregar a lista favoritos");
		buttonFavorites.setActionCommand("Favorites");
		JButton buttonAchieveds = new JButton("Agregar a lista achieveds");
		buttonAchieveds.setActionCommand("Achieveds");

		buttonGoals.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				UsersManager.addRoute(rute,e.getActionCommand());
			}
		});

		buttonFavorites.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				UsersManager.addRoute(rute,e.getActionCommand());
			}
		});

		buttonAchieveds.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				UsersManager.addRoute(rute,e.getActionCommand());
			}
		});

		toolBar = new JToolBar( "ToolBar", JToolBar.HORIZONTAL); 
		toolBar.setFloatable(false);
		toolBar.add(buttonGoals);
		toolBar.addSeparator();
		toolBar.add(buttonFavorites);
		toolBar.addSeparator();
		toolBar.add(buttonAchieveds);
		return toolBar;    

	}
}
