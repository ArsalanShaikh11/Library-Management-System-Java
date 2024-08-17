import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;

public class IssueBook extends JFrame implements ActionListener {

    JButton iss, cancel;
    JTextField sname, idate, rdate;
    Choice bname;

    IssueBook() {

        setBounds(0, 0, 1550, 1000);
        setLayout(null);

        JLabel SName = new JLabel("Student Name");
        SName.setBounds(500, 150, 300, 100);
        SName.setFont(new Font("times new roman", Font.PLAIN, 30));
        SName.setForeground(Color.cyan);
        add(SName);

        sname = new JTextField();
        sname.setBounds(740, 180, 200, 30);
        sname.setFont(new Font("", Font.PLAIN, 20));
        add(sname);

        JLabel BName = new JLabel("Book Name");
        BName.setBounds(500, 250, 200, 100);
        BName.setFont(new Font("times new roman", Font.PLAIN, 30));
        BName.setForeground(Color.cyan);
        add(BName);

        bname = new Choice();

        try {
            Conn conn = new Conn();
            String query = "select * from Available_Books Where Available = 'Yes'";
            ResultSet rs = conn.s.executeQuery(query);

            while (rs.next()) {
                bname.add(rs.getString("book_name"));
            }

        } catch (Exception e) {

        }

        bname.setBounds(740, 280, 200, 100);
        bname.setFont(new Font("Georgia", Font.BOLD, 20));
        bname.setBackground(Color.white);
        add(bname);

        JLabel Idate = new JLabel("Issue Date");
        Idate.setBounds(500, 350, 200, 100);
        Idate.setFont(new Font("times new roman", Font.PLAIN, 30));
        Idate.setForeground(Color.CYAN);
        add(Idate);

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String d = formatter.format(date);
        Calendar ca = Calendar.getInstance();

        idate = new JTextField("" + d);
        idate.setBounds(740, 380, 200, 30);
        idate.setFont(new Font("", Font.PLAIN, 20));
        idate.setEditable(false);
        add(idate);

        JLabel Rdate = new JLabel("Return Date");
        Rdate.setBounds(500, 450, 200, 100);
        Rdate.setFont(new Font("times new roman", Font.PLAIN, 30));
        Rdate.setForeground(Color.CYAN);
        add(Rdate);

        rdate = new JTextField();
        rdate.setBounds(740, 480, 200, 30);
        rdate.setFont(new Font("", Font.PLAIN, 20));
        add(rdate);

        iss = new JButton("ISSUE");
        iss.setBounds(580, 600, 120, 30);
        iss.setFont(new Font("Century Gothic", Font.BOLD, 20));
        iss.setBackground(Color.BLACK);
        iss.setForeground(Color.GREEN);
        iss.addActionListener(this);
        iss.setFocusable(false);
        add(iss);

        cancel = new JButton("CANCEL");
        cancel.setBounds(780, 600, 120, 30);
        cancel.setFont(new Font("Century Gothic", Font.BOLD, 20));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.red);
        cancel.addActionListener(this);
        cancel.setFocusable(false);
        add(cancel);

        ImageIcon i1 = new ImageIcon("image.jpg");
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);

        setBounds(0, 0, 1550, 1000);
        setUndecorated(true);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String studentname = sname.getText();
        String bookname = (String) bname.getSelectedItem();
        String issuedate = idate.getText();
        String returndate = rdate.getText();

        if (e.getSource() == iss && bookname.equals(" ")) {

            JOptionPane.showMessageDialog(null, "     BOOK NOT AVAILABLE  ");

        }

        else if (e.getSource() == iss) {

            try {

                Conn conn = new Conn();

                String query = " select * from Student where Name =  '" + studentname + "' ";

                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    String Query = "Insert into IssuedBooks values( '" + studentname + "' , '" + bookname + "', '"
                            + issuedate + "', '" + returndate + "')";
                    String Query2 = "Update Available_Books set Available = 'No' where book_name = '" + bookname + "' ";

                    conn.s.executeUpdate(Query);
                    conn.s.executeUpdate(Query2);

                    JOptionPane.showMessageDialog(null, "Book Issued");
                    setVisible(false);
                    new IssueBook();

                } else {
                    JOptionPane.showMessageDialog(null, " Student Name not Found");

                }

            } catch (Exception ec) {
                ec.printStackTrace();
            }

        } else if (e.getSource() == cancel) {
            setVisible(false);
            new DashBoard();
        } else if (e.getSource() == iss || (studentname.equals(" ") || issuedate.equals("") || returndate.equals(""))) {
            JOptionPane.showMessageDialog(null, "Please Enter Correct Details");
        }

    }

    public static void main(String[] args) {
        new IssueBook();
    }

}
