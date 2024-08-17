import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HomePage extends JFrame implements ActionListener {

    HomePage() {

        JPanel panel = new JPanel();
        panel.setBounds(300, 250, 1000, 120);
        panel.setBackground(new Color(153, 76, 0));
        panel.setFont(new Font("", Font.BOLD, 20));
        add(panel);

        JLabel text = new JLabel("LIBRARY MANAGEMENT");
        text.setBounds(550, 800, 1000, 100);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Century Gothic", Font.ITALIC, 80));
        text.setLayout(null);
        panel.add(text);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("1.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1550, 1000);
        add(image);

        JButton next = new JButton("Next");
        next.setBounds(1150, 650, 135, 50);
        next.setForeground(Color.black);
        next.addActionListener(this);
        next.setFont(new Font("", Font.ITALIC, 25));
        next.setFocusable(false);
        image.add(next);

        setSize(1550, 1000);
        setLocation(0, 0);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        // setVisible(false);
        new StdntOrAdmn();
    }

    public static void main(String[] args) {
        new HomePage();
    }
}
