import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

public class ReturnBook extends JFrame implements ActionListener {

  JButton Return, cancel, search;
  JTextField sname, Rdate, Tdate, D;
  Date todate;

  JLabel tdate;

  Choice rbname;

  ReturnBook() {
    setBounds(0, 0, 1550, 1000);
    setLayout(null);

    JLabel SName = new JLabel("Student Name");
    SName.setBounds(450, 150, 300, 100);
    SName.setFont(new Font("Georgia", Font.PLAIN, 30));
    SName.setForeground(Color.cyan);
    add(SName);

    sname = new JTextField();
    sname.setBounds(740, 185, 200, 30);
    sname.setFont(new Font("", Font.PLAIN, 20));
    add(sname);

    JLabel BName = new JLabel("Book Name");
    BName.setBounds(450, 250, 250, 100);
    BName.setFont(new Font("Georgia", Font.PLAIN, 30));
    BName.setForeground(Color.cyan);
    add(BName);

    rbname = new Choice();

    try {
      Conn conn = new Conn();
      String query = "select * from Available_Books Where Available = 'No'";
      ResultSet rs = conn.s.executeQuery(query);

      while (rs.next()) {
        rbname.add(rs.getString("book_name"));
      }

    } catch (Exception e) {

    }

    rbname.setBounds(740, 285, 200, 100);
    rbname.setFont(new Font("Georgia", Font.BOLD, 20));
    rbname.setBackground(Color.white);

    add(rbname);

    JLabel rdate = new JLabel("Return date");
    rdate.setBounds(450, 350, 250, 100);
    rdate.setFont(new Font("Georgia", Font.PLAIN, 30));
    rdate.setForeground(Color.CYAN);
    add(rdate);

    Rdate = new JTextField();
    Rdate.setBounds(740, 385, 200, 30);
    Rdate.setFont(new Font("", Font.PLAIN, 20));
    Rdate.setEditable(false);
    add(Rdate);

    JLabel tdate = new JLabel("Today's date");
    tdate.setBounds(450, 450, 350, 100);
    tdate.setFont(new Font("Georgia", Font.PLAIN, 30));
    tdate.setForeground(Color.CYAN);
    add(tdate);

    todate = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    String d = formatter.format(todate);
    Calendar ca = Calendar.getInstance();

    D = new JTextField("" + d);
    D.setBounds(740, 485, 200, 30);
    D.setFont(new Font("", Font.PLAIN, 20));
    D.setEditable(false);
    add(D);

    search = new JButton("Search");
    search.setBounds(400, 600, 180, 30);
    search.setFont(new Font("", Font.BOLD, 25));
    search.setBackground(Color.BLACK);
    search.setForeground(Color.white);
    search.addActionListener(this);
    search.setFocusable(false);
    add(search);

    Return = new JButton("Return");
    Return.setBounds(600, 600, 180, 30);
    Return.setFont(new Font("", Font.BOLD, 25));
    Return.setBackground(Color.BLACK);
    Return.setForeground(Color.GREEN);
    Return.addActionListener(this);
    Return.setFocusable(false);
    add(Return);

    cancel = new JButton("Cancel");
    cancel.setBounds(800, 600, 180, 30);
    cancel.setFont(new Font("", Font.BOLD, 25));
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.red);
    cancel.addActionListener(this);
    cancel.setFocusable(false);
    add(cancel);

    ImageIcon i1 = new ImageIcon("8.jpg"); 
    Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0, 0, 1550, 1000);
    add(image);
    setBounds(0, 0, 1550, 1000);
    setUndecorated(true);

    setVisible(true);

  }

  public static void main(String[] args) {
    new ReturnBook();

  }

  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == Return && sname.equals(" ")) {
      JOptionPane.showMessageDialog(null, "Please Enter Correct Details");
    }

    else if (e.getSource() == search) {

      String Sname = sname.getText();
      String Bname = rbname.getSelectedItem();

      try {
        Conn c = new Conn();

        String Query = " select return_date from IssuedBooks where student_name =  '" + Sname + "' and book_name =  '"
            + Bname + "'  ";
        ResultSet rs = c.s.executeQuery(Query);

        if (rs.next()) {
          Rdate.setText(rs.getString("return_date"));
          Rdate.setEditable(false);
        } else {
          JOptionPane.showMessageDialog(null, "Student Name And Book name not matched");
        }

      } catch (Exception ev) {
        ev.printStackTrace();
      }

    }

    else if (e.getSource() == Return) {

      String Bname = rbname.getSelectedItem();
      String Sname = sname.getText();

      try {

        Conn conn = new Conn();

        String query = " select * from IssuedBooks where student_name =  '" + Sname + "'  and book_name = '" + Bname
            + "'  ";
        ResultSet rs = conn.s.executeQuery(query);

        if (rs.next()) {

          String returnDateStr = rs.getString("return_date");
          SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
          Date returnDate = dateFormat.parse(returnDateStr);
          Date today = new Date();

          if (returnDate.after(today) || returnDate.equals(today)) {
            String Query = "Delete From IssuedBooks Where student_name = '" + Sname + "'";
            String Query2 = "Update Available_Books set Available = 'Yes' where book_name = '" + Bname + "' ";

            conn.s.executeUpdate(Query);
            conn.s.executeUpdate(Query2);

            JOptionPane.showMessageDialog(null, "Book Returned");
            setVisible(false);
            new ReturnBook();
          }

          else if (returnDate.before(today)) {
            JOptionPane.showMessageDialog(null, "You are late for Return \n You have to pay the fine");
          }

        } else {
          JOptionPane.showMessageDialog(null, " Student Name And Book name not matched");

        }

      } catch (Exception ec) {
        ec.printStackTrace();
      }

    } else if (e.getSource() == cancel) {
      setVisible(false);
      new DashBoard();
    }

  }

}
