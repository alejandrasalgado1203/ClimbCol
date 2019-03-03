
package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import business.ClimbersManager;
import data.Parque;
import data.Ruta;
import data.Zona;

public class UIRute extends JPanel{
	private   JPanel panelRute= new JPanel();
	private   JPanel centerPanel = new JPanel();
	private Ruta rute;
	private UIMain uiMain;

	public static   UIRute createUIRute(Ruta rute,UIMain main){
		return new UIRute(rute,main);
	}
	public UIRute(Ruta rute, UIMain main) {
		this.rute =rute;
		this.uiMain = main;
		this.setLayout(new BorderLayout());
		this.setupMainPanel();
	}
	public   void setupMainPanel() {
		createTittle();
		createImage();
		createDescription();
		createMenuBar();
		goToLastAndNextPanel();
	}
	public   void createTittle() {
		JPanel tittle = new JPanel();
		JLabel lblWelcomeRute = new JLabel("RUTA "+ this.rute.getName());
		lblWelcomeRute.setFont(new Font("Tahoma",Font.PLAIN,35));
		tittle.add(lblWelcomeRute);
		this.add(lblWelcomeRute,BorderLayout.NORTH);
	}
	public   void createImage() {
		ImageIcon Rute= new ImageIcon("images\\2.jpg");
		JLabel labelImage = new JLabel(Rute);
		centerPanel.add(labelImage);
	}
	public   void createDescription() {
		JPanel infoPanel = new JPanel(new GridLayout(0,1));

		JLabel lbl = new JLabel("Dificultad: " + rute.getDificultad());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);
		lbl = new JLabel("Numero de Chapas: " + rute.getNumeroDeChapas());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);
		lbl = new JLabel("Tipo de Rute: " + rute.getTipoDeRuta());
		lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
		infoPanel.add(lbl);
		lbl = new JLabel("Altura: " + rute.getAltura());
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
				uiMain.showPanel(UIPark.createUIPark(rute.getZona().getParque(),uiMain));
			}  
		});
		
		JButton b3=new JButton("Return to Zone");  
		b3.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				uiMain.showPanel(UIZone.createUIZone(rute.getZona(),uiMain));
			}  
		});
		
		
		southPanel.add(b1);
		southPanel.add(b2);
		this.add(southPanel, BorderLayout.SOUTH);
	}
	
	public   void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		panelRute.add(menuBar);

		JMenu menuAdd = new JMenu("Agregar");
		menuBar.add(menuAdd);

		JMenuItem menuItemGoals = new JMenuItem("A la lista Retos");
		menuAdd.add(menuItemGoals);
		menuAdd.addSeparator();

		JMenuItem menuItemFavorites = new JMenuItem("A la lista de favoritos");
		menuAdd.add(menuItemFavorites);
		menuAdd.addSeparator();

		menuItemGoals.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ClimbersManager.addGoalRute(rute);
			}
		});

		menuItemFavorites.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ClimbersManager.addFavoriteRute(rute);
			}
		});
	}


}
