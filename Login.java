
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {

  JButton login, cancel;
  JTextField username;
  JPasswordField password;

  Login() {

    JLabel stdlg = new JLabel("Student Login");
    stdlg.setBounds(280, 100, 300, 60);
    stdlg.setFont(new Font("Georgia", Font.BOLD, 30));
    add(stdlg);

    JLabel user = new JLabel("Username");
    user.setBounds(180, 250, 200, 30);
    user.setFont(new Font("Georgia", Font.BOLD, 30));
    add(user);

    username = new JTextField();
    username.setBounds(400, 250, 200, 30);
    username.setFont(new Font("", Font.PLAIN, 20));
    username.setBackground(Color.WHITE);
    add(username);

    JLabel pass = new JLabel("Password");
    pass.setBounds(180, 350, 200, 30);
    pass.setFont(new Font("Georgia", Font.BOLD, 30));
    add(pass);

    password = new JPasswordField();
    password.setBounds(400, 350, 200, 30);
    password.setFont(new Font("", Font.PLAIN, 20));
    password.setBackground(Color.WHITE);
    add(password);

    login = new JButton("Login");
    login.setBounds(200, 450, 120, 30);
    login.setFont(new Font("", Font.BOLD, 20));
    login.setBackground(Color.BLACK);
    login.setForeground(Color.GREEN);
    login.addActionListener(this);
    login.setFocusable(false);
    add(login);

    cancel = new JButton("Cancel");
    cancel.setBounds(410, 450, 120, 30);
    cancel.setFont(new Font("", Font.BOLD, 20));
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.red);
    cancel.addActionListener(this);
    cancel.setFocusable(false);
    add(cancel);

    ImageIcon i1 = new ImageIcon("_default.jpg");
    Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0, 0, 1550, 1000);
    add(image);
    setBounds(0, 0, 1550, 1000);

    setLayout(null);
    setUndecorated(true);

    setVisible(true);

  }

  public static void main(String[] args) {
    new Login();
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == login) {

      String user = username.getText();
      String pass = password.getText();

      try {
        Conn c = new Conn();

        String query = " select * from Username where Username =  '" + user + "' and Password = '" + pass + "' ";

        ResultSet rs = c.s.executeQuery(query);

        if (rs.next()) {
          setVisible(false);
          new DashBoard();

        } else {
          JOptionPane.showMessageDialog(null, "Please Enter Correct Username And Password");

        }

      }

      catch (Exception ea) {
        ea.getStackTrace();

      }
    } else if (e.getSource() == cancel) {
      // setVisible(false);
      new HomePage();
    }

  }

}
