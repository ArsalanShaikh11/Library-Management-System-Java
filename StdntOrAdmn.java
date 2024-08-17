import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StdntOrAdmn extends JFrame implements ActionListener {

    JButton Student, Admin;

    StdntOrAdmn() {

      
       setBounds(0,0,1550,1000);
        setLayout(null);

        Student = new JButton("Student Login");
        Student.setBounds(240, 120, 250, 50);
        Student.setBackground(Color.BLACK);
        Student.setForeground(Color.CYAN);
        Student.setFont(new Font("", Font.BOLD, 30));
        Student.setFocusable(false);
        Student.addActionListener(this);
        add(Student);

        Admin = new JButton("Admin Login");
        Admin.setBounds(240, 200, 250, 50);
        Admin.setBackground(Color.BLACK);
        Admin.setForeground(Color.CYAN);
        Admin.setFont(new Font("", Font.BOLD, 30));
        Admin.setFocusable(false);
        Admin.addActionListener(this);
        add(Admin);

        ImageIcon i1 = new ImageIcon("10.jpg");
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);
        
        setUndecorated(true);

        setVisible(true);
    }

    public static void main(String[] args) {
        new StdntOrAdmn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Student) {
            //setVisible(false);
            new Login();

        } else if (e.getSource() == Admin) {
           // setVisible(false);
            new AdminLogin();
        }
    }

}
