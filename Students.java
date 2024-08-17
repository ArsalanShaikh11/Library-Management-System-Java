import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Students extends JFrame implements ActionListener {

  JButton back;
  JTable table;

  Students() {
    setBounds(0, 0, 1550, 1000);
    setLayout(null);

    back = new JButton("Back");
    back.setBounds(700, 650, 120, 40);
    back.setFont(new Font("", Font.TYPE1_FONT, 20));
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.addActionListener(this);
    back.setFocusable(false);
    add(back);

    JLabel Name = new JLabel(" Name");
    Name.setBounds(380, 150, 1000, 50);
    Name.setFont(new Font("courier new", Font.BOLD, 25));
    Name.setForeground(Color.BLACK);
    Name.setBackground(Color.white);
    add(Name);

    JLabel Rollno = new JLabel("Rollno");
    Rollno.setBounds(600, 150, 1000, 50);
    Rollno.setFont(new Font("courier new", Font.BOLD, 25));
    Rollno.setForeground(Color.BLACK);
    Rollno.setBackground(Color.white);
    add(Rollno);

    JLabel year = new JLabel("Year");
    year.setBounds(850, 150, 1000, 50);
    year.setFont(new Font("Courier New", Font.BOLD, 25));
    year.setForeground(Color.BLACK);
    year.setBackground(Color.white);
    add(year);

    JLabel Branch = new JLabel("Branch");
    Branch.setBounds(1050, 150, 1000, 50);
    Branch.setFont(new Font("Courier New", Font.BOLD, 25));
    Branch.setForeground(Color.BLACK);
    Branch.setBackground(Color.white);
    add(Branch);

    table = new JTable();
    table.setBounds(300, 200, 950, 400);
    table.setFont(new Font("calibri", Font.PLAIN, 15)); // calibri

    add(table);

    try {
      Conn c = new Conn();
      String Query = "Select * From student";
      ResultSet rs = c.s.executeQuery(Query);
      table.setModel(DbUtils.resultSetToTableModel(rs));

    } catch (Exception ee) {
      ee.printStackTrace();
    }

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("2.jpg"));
    Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0, 0, 1550, 1000);
    add(image);

    setUndecorated(true);

    setVisible(true);
  }

  public static void main(String[] args) {
    new Students();

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    setVisible(false);
    new Admndshbrd();
  }

}
