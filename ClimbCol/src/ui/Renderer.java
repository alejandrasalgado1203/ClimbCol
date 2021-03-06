package ui;

import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import data.Renderable;

public class Renderer extends JPanel implements ListCellRenderer<Renderable> {

    private JLabel image;
    private JLabel name;

    public Renderer() {
        super();
        setLayout(new BorderLayout(5, 5));
        this.image = new JLabel();
        this.name = new JLabel();
        this.add(image,BorderLayout.WEST);
        this.add(name,BorderLayout.CENTER);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Renderable> list, Renderable value, int index,
            boolean isSelected, boolean cellHasFocus) {
        ImageIcon icon = new ImageIcon(value.getMainImage());
        if (icon.getIconWidth() > 130 || icon.getIconHeight() > 90) {
            icon = new ImageIcon(icon.getImage().getScaledInstance(130, 90, Image.SCALE_AREA_AVERAGING));
        }
        this.image.setIcon(icon);
        this.name.setText(value.getName());
        this.name.setFont(new Font("Tahoma", Font.PLAIN, 20));
        return this;
    }
}
