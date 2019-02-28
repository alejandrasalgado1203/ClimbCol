
package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import business.ClimbColManager;
import data.Zona;

public class UIZone extends JPanel {
	private static UIRute panelRutes;
	private static JPanel centerPanel = new JPanel();
	private UIWelcome welcome;
	private Zona zone;

	public UIZone(Zona zone) {
		this.zone = zone;
		showPanelZone();
	}

	public void setupMainPanel(String nameZone) {
		createTittle(nameZone);
		createScrollPane();
		createDescription();
	}

	public void createTittle(String nameZone) {
		JPanel tittle = new JPanel();
		JLabel lblWelcomeZone = new JLabel("ZONA "+ nameZone);
		lblWelcomeZone.setFont(new Font("Tahoma",Font.PLAIN,35));
		tittle.add(lblWelcomeZone);
		this.add(tittle,BorderLayout.NORTH);
	}

	public static void createDescription() {
		JPanel description = new JPanel();
		description.setLayout(new GridLayout(2,1));
		centerPanel.add(description,new FlowLayout());

		ImageIcon Zone= new ImageIcon("images\\4.jpg");
		JLabel labelImage = new JLabel(Zone);
		labelImage.setVisible(true);
		description.add(labelImage);

		JTextField textDescription = new JTextField(30);
		description.add(textDescription);
	}

	public void createScrollPane() {

		JList listRutes = new JList(ClimbColManager.getRutesNames(zone));
		JScrollPane scrollPaneRutes = new JScrollPane(listRutes);

		centerPanel.add(scrollPaneRutes,new FlowLayout());
		this.add(centerPanel,BorderLayout.CENTER);

		listRutes.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				panelRutes = new UIRute(ClimbColManager.getRute(zone,(String) listRutes.getSelectedValue()));
				showPanelZone();
			}
		});
	}

	public void showPanelZone() {
		this.setSize(900,900);
		this.setVisible(true);
		setupMainPanel(" ");
	}
}
