
package ui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Rute extends JFrame {
	private static JPanel panelRute= new JPanel();
	private static JFrame frame = new JFrame ("Example");
	
    public void setupPanelRute(String nameRute) {
        panelRute.setLayout(new GridLayout(8,1));
		
        JLabel lblWelcomeRute = new JLabel("RUTA "+ nameRute);
        lblWelcomeRute.setFont(new Font("Tahoma",Font.PLAIN,35));
        panelRute.add(lblWelcomeRute);
        
        ImageIcon Rute= new ImageIcon("/Images/Diagrama.png");
        JLabel labelImage = new JLabel(Rute);
		labelImage.setVisible(true);
		panelRute.add(labelImage);
		
		JMenuBar menuBar = new JMenuBar();
		panelRute.add(menuBar);
		
		JMenu menuAdd = new JMenu("Agregar");
		menuAdd.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menuAdd);
		setJMenuBar(menuBar);

		JMenuItem menuItemGoals = new JMenuItem("A la lista Retos",KeyEvent.VK_T);
		menuItemGoals.setMnemonic(KeyEvent.VK_B);
		menuAdd.add(menuItemGoals);
		menuAdd.addSeparator();

		JMenuItem menuItemFavorites = new JMenuItem("A la lista de favoritos",KeyEvent.VK_T);
		menuItemFavorites.setMnemonic(KeyEvent.VK_B);
		menuAdd.add(menuItemFavorites);
		menuAdd.addSeparator();
    }
    
    public static void showPanelRute() {
        frame.add(panelRute);
        frame.pack();
    }
}
