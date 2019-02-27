
package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.Ruta;

public class UIRute extends JPanel{
	private static JPanel panelRute= new JPanel();
	private static JPanel centerPanel = new JPanel();
	private static JFrame frame = new JFrame ("CLIMBCOL");
	private Ruta rute;

	public UIRute(Ruta rute) {
		this.rute = rute;
	}
	public static void setupMainPanel(String nameRute) {
		createTittle(nameRute);
		createImage();
		createTextField();
		createMenuBar();
	}
	public static void createTittle(String nameRute) {

		JLabel lblWelcomeRute = new JLabel("RUTA "+ nameRute);
		lblWelcomeRute.setFont(new Font("Tahoma",Font.PLAIN,35));
		frame.add(lblWelcomeRute,BorderLayout.NORTH);
	}
	public static void createImage() {
		ImageIcon Rute= new ImageIcon("images\\2.jpg");
		JLabel labelImage = new JLabel(Rute);
		labelImage.setVisible(true);
		centerPanel.add(labelImage,new FlowLayout());
	}
	public static void createTextField() {
		JTextField textDescription = new JTextField(30);
		centerPanel.add(textDescription,new FlowLayout());
		frame.add(centerPanel,BorderLayout.CENTER);
	}
	public static void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		panelRute.add(menuBar);

		JMenu menuAdd = new JMenu("Agregar");
		menuAdd.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menuAdd);
		frame.setJMenuBar(menuBar);

		JMenuItem menuItemGoals = new JMenuItem("A la lista Retos",KeyEvent.VK_T);
		menuItemGoals.setMnemonic(KeyEvent.VK_B);
		menuAdd.add(menuItemGoals);
		menuAdd.addSeparator();

		JMenuItem menuItemFavorites = new JMenuItem("A la lista de favoritos",KeyEvent.VK_T);
		menuItemFavorites.setMnemonic(KeyEvent.VK_B);
		menuAdd.add(menuItemFavorites);
		menuAdd.addSeparator();

		menuItemGoals.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				UIUser.showPanelGoals();
			}
		});

		menuItemFavorites.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				UIUser.showPanelFavorites();
			}
		});
	}
	public static void showPanelRute() {
		frame.setTitle("CLIMBCOL");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900,900);
		frame.setResizable(true);
		setupMainPanel(" ");
		frame.pack();
		frame.setVisible(true);
	}
}
