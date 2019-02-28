package ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import data.Parque;

public class ParkRenderer extends JPanel implements ListCellRenderer<Parque> {

	private JLabel image;
	private JLabel name;

	public ParkRenderer() {
		super();
		this.image = new JLabel();
		this.name = new JLabel();
		this.setLayout(new BorderLayout());
		this.add(image, BorderLayout.CENTER);
		this.add(name, BorderLayout.NORTH);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Parque> list, Parque value, int index,
			boolean isSelected, boolean cellHasFocus) {
		this.image.setIcon(new ImageIcon(value.getMainImage()));
		this.name.setText(value.getName());
		this.name.setFont(new Font("Tahoma",Font.PLAIN,20));
		return this;
	}
}
