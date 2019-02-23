
package ui;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class UI{
    private JPanel mainPanel = new JPanel();
    private static Welcome welcome = new Welcome();
    private static Park park = new Park();
    private static Zone zone = new Zone();
    private static Rute rute = new Rute();
    private static User user = new User();
    private static JFrame frame = new JFrame ("Example");

    // mirar windows builder
    public UI() {

        frame.setTitle("CLIMBCOL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(400,200);
        frame.setResizable(true);
        frame.add(mainPanel);
        mainPanel.setBorder(new EmptyBorder(10,10,10,10));
        mainPanel.setLayout(new CardLayout(0,0));// aprender esto
        frame.setContentPane(mainPanel);
        initComponents("HOLA","HOLA","HOLA","HOLA");// diego tarea
        frame.setVisible(true);
    }
    
    private void initComponents(String namePark,String nameZone,String nameRute,String nombreEscalador) {
        welcome.setupPanelWelcome();
        park.setupPanelPark(namePark);
        zone.setupPanelZone(nameZone);
        rute.setupPanelRute(nameRute);
        user.setupPanelUser(nombreEscalador);
    }
    
    public void showComponents () {
    	welcome.showMenu();
    }

    
}
