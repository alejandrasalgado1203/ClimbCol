package ui;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import business.UsersManager;
import javax.swing.JOptionPane;

public class UIMain extends JFrame {

    private UIUser uiUser;

    public UIMain() {
        super("CLIMBCOL");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                UsersManager.saveUsers();
                System.exit(0);
            }
        });
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if ((e.getKeyCode() == KeyEvent.VK_Q && e.getModifiers() == InputEvent.META_MASK)
                        || (e.getKeyCode() == KeyEvent.VK_Q && e.getModifiers() == InputEvent.CTRL_MASK)) {
                    UsersManager.saveUsers();
                    System.exit(0);
                }
                return false;
            }
        });
        ImageIcon icon = new ImageIcon("images/icono.png");
        this.setIconImage(icon.getImage());
        this.createMenuBar();
        this.showPanel(UIWelcome.createUIWelcome(this), 740, 670);

    }

    public void showPanel(JPanel jp, int x, int y) {
        this.addPanel(jp);
        this.setSize(x, y);
        this.setVisible(true);
    }

    private void addPanel(JPanel jp) {
        this.setVisible(false);
        this.setContentPane(new JScrollPane(jp));
    }

    public void createMenuBar() {

        boolean user = UsersManager.hasCurrentUser();

        JMenuBar menuBar = new JMenuBar();

        JMenuItem menuItemSignIn = new JMenuItem("Sign in");
        menuBar.add(menuItemSignIn);

        JMenuItem menuItemLogin = new JMenuItem("Login");
        menuBar.add(menuItemLogin);
        menuItemLogin.setEnabled(!user);

        JMenuItem menuItemLogout = new JMenuItem("Logout");
        menuBar.add(menuItemLogout);
        menuItemLogout.setEnabled(user);

        JMenuItem menuItemUser = new JMenuItem("User's info");
        menuBar.add(menuItemUser);
        menuItemUser.setEnabled(user);
        if (user) {
            menuItemUser.setText(UsersManager.getCurrentUser().getName() + "'s info");
        }

        JMenuItem menuItemExit = new JMenuItem("Exit");
        menuBar.add(menuItemExit);

        menuItemSignIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UIUser.showSignInFrame();
            }
        });

        menuItemLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UIUser.showLoginFrame();
                if (UsersManager.hasCurrentUser()) {
                    menuItemLogin.setEnabled(false);
                    menuItemLogout.setEnabled(true);
                    menuItemUser.setText(UsersManager.getCurrentUser().getName() + "'s info");
                    menuItemUser.setEnabled(true);
                }

            }
        });

        menuItemLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UsersManager.setCurrentUser(null);
                menuItemLogout.setEnabled(false);
                menuItemLogin.setEnabled(true);
                menuItemUser.setText("User's info");
                menuItemUser.setEnabled(false);
                uiUser.setVisible(false);

            }
        });

        menuItemUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                uiUser = new UIUser(UIMain.this);
                menuItemUser.setEnabled(false);
            }
        });

        menuItemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UsersManager.saveUsers();
                System.exit(0);
            }
        });

        this.setJMenuBar(menuBar);
        this.revalidate();
    }

    public static void reportProblem(String report) {
        JOptionPane.showMessageDialog(null, report, null, JOptionPane.WARNING_MESSAGE);
    }
}
