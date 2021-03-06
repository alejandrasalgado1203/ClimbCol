package ui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import business.UsersManager;
import data.Route;
import java.awt.Image;

public class UIRoute extends JPanel {

    private GridBagConstraints constraints = new GridBagConstraints();
    private Route route;
    private UIMain uiMain;

    public static UIRoute createUIRute(Route route, UIMain main) {
        return new UIRoute(route, main);
    }

    public UIRoute(Route route, UIMain main) {
        this.constraints.insets = new Insets(5, 5, 5, 5);
        this.route = route;
        this.uiMain = main;
        this.setLayout(new GridBagLayout());
        this.setupMainPanel();
    }

    private void setupMainPanel() {
        createTittle();
        createImage();
        createDescription();
        goToLastAndNextPanel();
        createToolBar();
    }

    private void createTittle() {
        JLabel lblRouteName = new JLabel("Route " + this.route.getName());
        lblRouteName.setFont(new Font("Tahoma", Font.PLAIN, 35));
        this.constraints.gridwidth = 3;
        this.addGB(lblRouteName, 0, 1);
    }

    private void createImage() {
        ImageIcon routeImage = new ImageIcon(route.getImagePath());
        if (routeImage.getIconWidth() > 200 || routeImage.getIconHeight() > 300) {
            routeImage = new ImageIcon(routeImage.getImage().getScaledInstance(215, 320, Image.SCALE_AREA_AVERAGING));
        }
        JLabel labelImage = new JLabel(routeImage);
        this.constraints.gridwidth = 1;
        this.constraints.gridheight = 1;
        this.addGB(labelImage, 0, 2);
    }

    private void createDescription() {
        JPanel infoPanel = new JPanel(new GridLayout(0, 1));

        JLabel lbl = new JLabel("Dificulty: " + route.getDifficulty());
        lbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
        infoPanel.add(lbl);

        lbl = new JLabel("Number of Plates: " + route.getNumberOfPlates());
        lbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
        infoPanel.add(lbl);

        lbl = new JLabel("Type of Route: " + route.getRouteType());
        lbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
        infoPanel.add(lbl);

        lbl = new JLabel("Height: " + route.getHeight());
        lbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
        infoPanel.add(lbl);

        this.constraints.gridwidth = 1;
        this.constraints.gridheight = 1;
        this.addGB(infoPanel, 1, 2);
    }

    private void goToLastAndNextPanel() {

        JButton b1 = new JButton("Return to Welcome");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                uiMain.showPanel(UIWelcome.createUIWelcome(uiMain), 730, 670);
            }
        });

        JButton b2 = new JButton("Return to Park");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                uiMain.showPanel(UIPark.createUIPark(route.getZone().getPark(), uiMain), 730, 670);
            }
        });

        JButton b3 = new JButton("Return to Zone");
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                uiMain.showPanel(UIZone.createUIZone(route.getZone(), uiMain), 730, 670);
            }
        });
        this.constraints.gridwidth = 1;
        this.constraints.gridheight = 1;
        this.addGB(b1, 0, 3);
        this.addGB(b2, 1, 3);
        this.addGB(b3, 2, 3);
    }

    private void createToolBar() {
        
        JButton buttonGoals = new JButton("Add to Goals Routes");
        buttonGoals.setActionCommand("Goals");
        JButton buttonFavorites = new JButton("Add to Favorites Routes");
        buttonFavorites.setActionCommand("Favorites");
        JButton buttonAchieveds = new JButton("Add to Achieveds Routes");
        buttonAchieveds.setActionCommand("Achieveds");

        buttonGoals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (UsersManager.hasCurrentUser()) {
                    if (!UsersManager.addRoute(route, e.getActionCommand())) {
                        JOptionPane.showMessageDialog(null, "the route already exists in your list",
                                null, JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You are not register",
                            null, JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        buttonFavorites.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (UsersManager.hasCurrentUser()) {
                    if (!UsersManager.addRoute(route, e.getActionCommand())) {
                        JOptionPane.showMessageDialog(null, "the route already exists in your list",
                                null, JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You are not register",
                            null, JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        buttonAchieveds.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (UsersManager.hasCurrentUser()) {
                    if (!UsersManager.addRoute(route, e.getActionCommand())) {
                        JOptionPane.showMessageDialog(null, "the route already exists in your list",
                                null, JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You are not register",
                            null, JOptionPane.WARNING_MESSAGE);
                }
            }
        });

         JToolBar toolBar = new JToolBar("ToolBar", JToolBar.HORIZONTAL);
        toolBar.setFloatable(false);
        toolBar.add(buttonGoals);
        toolBar.addSeparator();
        toolBar.add(buttonFavorites);
        toolBar.addSeparator();
        toolBar.add(buttonAchieveds);
        this.constraints.gridwidth = 3;
        this.constraints.gridheight = 1;
        this.addGB(toolBar, 0, 0);
    }

    private void addGB(Component comp, int x, int y) {
        this.constraints.gridx = x;
        this.constraints.gridy = y;
        this.add(comp, this.constraints);
    }
}
