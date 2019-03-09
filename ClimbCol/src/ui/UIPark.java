package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.Insets;

import data.Park;
import data.Zone;
import java.awt.Component;
import java.awt.Image;

public class UIPark extends JPanel {

    private GridBagConstraints constraints = new GridBagConstraints();
    private Park park;
    private UIMain uiMain;
    private int imageIndex = 0;

    public static UIPark createUIPark(Park park, UIMain main) {
        return new UIPark(park, main);
    }

    public UIPark(Park park, UIMain main) {
        this.constraints.insets = new Insets(15, 15, 15, 15);
        this.park = park;
        this.uiMain = main;
        this.setLayout(new GridBagLayout());
        this.setupMainPanel();
    }

    private void setupMainPanel() {
        createTittle();
        createImage();
        createDescription();
        createScrollPane();
        goToLastPanel();
        createButtonFotos();
    }

    private void createTittle() {
        JLabel lblParkName = new JLabel("Park " + this.park.getName());
        lblParkName.setFont(new Font("Tahoma", Font.PLAIN, 35));
        this.constraints.gridwidth = 2;
        this.addGB(lblParkName, 0, 0);
    }

    private void createImage() {
        JLabel image = new JLabel(new ImageIcon(park.getMainImage()));
        this.constraints.gridwidth = 1;
        this.constraints.gridheight = 1;
        this.addGB(image, 0, 1);
    }

    private void createDescription() {
        JPanel infoPanel = new JPanel(new GridLayout(0, 1));

        JLabel lbl = new JLabel("Location: " + park.getLocation());
        lbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
        infoPanel.add(lbl);

        lbl = new JLabel("Go to Google Maps");
        lbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbl.setForeground(Color.BLUE.darker());
        lbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(park.getLinkLocation().trim()));
                } catch (IOException | URISyntaxException e1) {
                    JOptionPane.showMessageDialog(null, "ha ocurrido un error, "
                            + "el link no se puede abrir", null, JOptionPane.ERROR_MESSAGE);
                }
            }

            public void mouseExited(MouseEvent e) {
                JLabel lbl = (JLabel) e.getSource();
                lbl.setText("Go to Google Maps");
            }

            public void mouseEntered(MouseEvent e) {
                JLabel lbl = (JLabel) e.getSource();
                lbl.setText("<html><a href=''>" + "Go to Google Maps" + "</a></html>");
            }
        });
        infoPanel.add(lbl);

        lbl = new JLabel("Go to ParkWebSite");
        lbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbl.setForeground(Color.BLUE.darker());
        lbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(park.getLinkPatk().trim()));
                } catch (IOException | URISyntaxException e1) {
                    JOptionPane.showMessageDialog(null, "ha ocurrido un error, "
                            + "el link no se puede abrir", null, JOptionPane.ERROR_MESSAGE);
                }
            }

            public void mouseExited(MouseEvent e) {
                JLabel lbl = (JLabel) e.getSource();
                lbl.setText("Go to ParkWebSite");
            }

            public void mouseEntered(MouseEvent e) {
                JLabel lbl = (JLabel) e.getSource();
                lbl.setText("<html><a href=''>" + "Go to ParkWebSite" + "</a></html>");
            }
        });
        infoPanel.add(lbl);

        lbl = new JLabel("Average Temperature: " + park.getAverageTemperature());
        lbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
        infoPanel.add(lbl);

        lbl = new JLabel("Altitude: " + park.getAltitude());
        lbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
        infoPanel.add(lbl);

        lbl = new JLabel("Number of Zones: " + park.getZones().size());
        lbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
        infoPanel.add(lbl);

        this.constraints.gridwidth = 1;
        this.constraints.gridheight = 1;
        this.addGB(infoPanel, 0, 2);
    }

    private void createScrollPane() {
        DefaultListModel<Zone> model = new DefaultListModel<>();
        for (Zone zone : park.getZones()) {
            model.addElement(zone);
        }
        JList<Zone> listZones = new JList<Zone>(model);
        listZones.setCellRenderer(new Renderer());
        JScrollPane scrollPaneZones = new JScrollPane(listZones);
        scrollPaneZones.setMinimumSize(new Dimension(300, 400));

        this.constraints.gridwidth = 1;
        this.constraints.gridheight = 2;
        this.addGB(scrollPaneZones, 1, 1);

        listZones.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent arg0) {
                uiMain.showPanel(UIZone.createUIZone(listZones.getSelectedValue(), uiMain), 730, 670);
            }
        });

    }

    private void goToLastPanel() {

        JButton b1 = new JButton("Return to Welcome");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                uiMain.showPanel(UIWelcome.createUIWelcome(uiMain), 740, 670);
            }
        });
        this.constraints.gridwidth = 1;
        this.addGB(b1, 0, 3);
    }

    private void createButtonFotos() {
        JButton fotos = new JButton("Fotos");
        fotos.setForeground(Color.BLACK);
        fotos.setBackground(Color.WHITE);
        this.constraints.gridwidth = 1;
        this.addGB(fotos, 1, 3);

        fotos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showFrameFotos();
            }
        });
    }

    private void showFrameFotos() {
        JFrame frameFotos = new JFrame("FOTOS");
        frameFotos.add(setupPanelFotos());
        frameFotos.setSize(950, 550);
        frameFotos.setVisible(true);
    }

    private JPanel setupPanelFotos() {
        JPanel panelFotos = new JPanel(new GridBagLayout());
        JToolBar toolBar;

        ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
        for (String s : park.getImagesPaths()) {
            images.add(new ImageIcon(s));
        }

        JLabel label = new JLabel(images.get(0));
        this.constraints.gridx = 0;
        this.constraints.gridy = 0;
        this.constraints.gridheight = 1;
        panelFotos.add(label, constraints);

        JButton b1 = new JButton(new ImageIcon("images/previous.png"));
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (imageIndex != 0) {
                    imageIndex--;
                    label.setIcon(images.get(imageIndex));
                    ImageIcon icon = images.get(imageIndex);
                    if (icon.getIconWidth() > 130 || icon.getIconHeight() > 90) {
                        icon = new ImageIcon(icon.getImage().getScaledInstance(130, 90, Image.SCALE_AREA_AVERAGING));
                    }
                }
            }
        });

        JButton b2 = new JButton(new ImageIcon("images/next.png"));
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (imageIndex != images.size() - 1) {
                    imageIndex++;
                    label.setIcon(images.get(imageIndex));
                }
            }
        });

        toolBar = new JToolBar("ToolBar", SwingConstants.HORIZONTAL);
        toolBar.setFloatable(false);
        toolBar.add(b1);
        toolBar.addSeparator();
        toolBar.add(b2);
        this.constraints.gridx = 0;
        this.constraints.gridy = 1;
        panelFotos.add(toolBar, constraints);
        return panelFotos;
    }

    private void addGB(Component comp, int x, int y) {
        this.constraints.gridx = x;
        this.constraints.gridy = y;
        this.add(comp, this.constraints);
    }

}
