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
import business.ClimbersManager;
import data.Ruta;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class UIRute extends JPanel{
        private GridBagConstraints constraints = new GridBagConstraints();
	private Ruta rute;
	private UIMain uiMain;

	public static   UIRute createUIRute(Ruta rute,UIMain main){
		return new UIRute(rute,main);
	}
	public UIRute(Ruta rute, UIMain main) {
                this.constraints.insets = new Insets(15,15,15,15);
		this.rute =rute;
		this.uiMain = main;
		this.setLayout(new GridBagLayout());
		this.setupMainPanel();
	}
	private   void setupMainPanel() {
		createTittle();
		createImage();
		createDescription();
		goToLastAndNextPanel();
                createToolBar();
	}
	private   void createTittle() {
		JPanel tittle = new JPanel(new GridLayout(0,1));
		JLabel lblRouteName = new JLabel("Route "+ this.rute.getName());
		lblRouteName.setFont(new Font("Tahoma",Font.PLAIN,35));
		tittle.add(lblRouteName);
                this.constraints.gridwidth = 3;
		this.addGB(lblRouteName,0,0);
	}
	private  void createImage() {
                JPanel image = new JPanel(new GridLayout(0,1));
		ImageIcon routeImage= new ImageIcon(rute.getImage());
		JLabel labelImage = new JLabel(routeImage);
                image.add(labelImage);
                this.constraints.gridwidth = 3;
                this.constraints.gridheight = 1;
                this.addGB(image,0,1);
		
	}
	private   void createDescription() {
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
                
                this.constraints.gridwidth = 3;
                this.constraints.gridheight = 1;
		this.addGB(infoPanel,0,2);
	}

	private void goToLastAndNextPanel() {
            
		JButton b1=new JButton("Return to Welcome");  
		b1.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				uiMain.showPanel(UIWelcome.createUIWelcome(uiMain),730,670);
			}  
		});

		JButton b2=new JButton("Return to Park");  
		b2.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				uiMain.showPanel(UIPark.createUIPark(rute.getZona().getParque(),uiMain),730,670);
			}  
		});

		JButton b3=new JButton("Return to Zone");  
		b3.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				uiMain.showPanel(UIZone.createUIZone(rute.getZona(),uiMain),730,670);
			}  
		});

                this.constraints.gridwidth = 1;
                this.constraints.gridheight = 1;
		this.addGB(b1,0,4);
		this.addGB(b2,1,4);
		this.addGB(b3,2,4);
	}

	private void createToolBar() {
                JPanel toolBarPanel = new JPanel();
		JToolBar toolBar = new JToolBar();

		JButton buttonGoals = new JButton("Add to Goals Routes");
		buttonGoals.setActionCommand("Goals");
		JButton buttonFavorites = new JButton("Add to Favorites Routes");
		buttonFavorites.setActionCommand("Favorites");
		JButton buttonAchieveds = new JButton("Add to Achieveds Routes");
		buttonAchieveds.setActionCommand("Achieveds");

		buttonGoals.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ClimbersManager.addRute(rute,e.getActionCommand());
			}
		});

		buttonFavorites.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ClimbersManager.addRute(rute,e.getActionCommand());
			}
		});

		buttonAchieveds.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ClimbersManager.addRute(rute,e.getActionCommand());
			}
		});

		toolBar = new JToolBar( "ToolBar", JToolBar.HORIZONTAL); 
		toolBar.setFloatable(false);
		toolBar.add(buttonGoals);
		toolBar.addSeparator();
		toolBar.add(buttonFavorites);
		toolBar.addSeparator();
		toolBar.add(buttonAchieveds);
                toolBarPanel.add(toolBar);
                this.constraints.gridwidth = 3;
                this.constraints.gridheight = 1;
                this.addGB(toolBarPanel,0,3);
	}
            private void addGB(Component comp, int x, int y) {
            this.constraints.gridx = x;
            this.constraints.gridy = y;
            this.add(comp, this.constraints);
	}
}
