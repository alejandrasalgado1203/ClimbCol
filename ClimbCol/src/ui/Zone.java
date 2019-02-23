
package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Zone extends JFrame {
	private static JPanel panelZone = new JPanel();
	private static JFrame frame = new JFrame ("Example");
	
	public void setupPanelZone(String nameZone){
        panelZone.setLayout(new GridLayout(8,1));
		
        JLabel lblWelcomeZone = new JLabel("ZONA "+ nameZone);
        lblWelcomeZone.setFont(new Font("Tahoma",Font.PLAIN,35));
        panelZone.add(lblWelcomeZone);
        
        ImageIcon Zone= new ImageIcon("/Images/Diagrama.png");
        JLabel labelImage = new JLabel(Zone);
		labelImage.setVisible(true);
		panelZone.add(labelImage);
		
        JButton buttonRute1 = new JButton("Ruta 1");
        buttonRute1.setForeground(Color.BLACK);
        buttonRute1.setBackground(Color.WHITE);
        panelZone.add(buttonRute1);
        
        JButton buttonRute2 = new JButton("Ruta 2");
        buttonRute2.setForeground(Color.BLACK);
        buttonRute2.setBackground(Color.WHITE);
        panelZone.add(buttonRute2);
        
        JButton buttonRute3 = new JButton("Ruta 3");
        buttonRute3.setForeground(Color.BLACK);
        buttonRute3.setBackground(Color.WHITE);
        panelZone.add(buttonRute3);
        
        JButton buttonRute4 = new JButton("Ruta 4");
        buttonRute4.setForeground(Color.BLACK);
        buttonRute4.setBackground(Color.WHITE);
        panelZone.add(buttonRute4);
        
        buttonRute1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    remove(panelZone);
                    Rute.showPanelRute();
            }
        });
        
        buttonRute2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    remove(panelZone);
                    Rute.showPanelRute();
            }
        });
        
        buttonRute3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    remove(panelZone);
                    Rute.showPanelRute();
            }
        });
        
        buttonRute4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    remove(panelZone);
                    Rute.showPanelRute();
            }
        });
    }
    
    public static void showPanelZone() {
        frame.add(panelZone);
        frame.pack();
    }
}
