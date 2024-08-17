import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DashBoard extends JFrame implements ActionListener {

   JButton NewStudent, AddBook, Statics, IssueBook, ReturnBook, Logout;

   DashBoard() {
      setBounds(0, 0, 1550, 1000);

      IssueBook = new JButton("Issue Book");
      IssueBook.setBounds(250, 200, 200, 50);
      IssueBook.setFont(new Font("Tahoma", Font.BOLD, 25));
      IssueBook.setBackground(Color.WHITE);
      IssueBook.setForeground(Color.BLACK);
      IssueBook.addActionListener(this);
      IssueBook.setFocusable(false);
      add(IssueBook);

      ReturnBook = new JButton("Return Book");
      ReturnBook.setBounds(250, 300, 200, 50);
      ReturnBook.setFont(new Font("Tahoma", Font.BOLD, 25));
      ReturnBook.setBackground(Color.WHITE);
      ReturnBook.setForeground(Color.BLACK);
      ReturnBook.addActionListener(this);
      ReturnBook.setFocusable(false);
      add(ReturnBook);

      Statics = new JButton("All Books");
      Statics.setBounds(250, 400, 200, 50);
      Statics.setFont(new Font("Tahoma", Font.BOLD, 25));
      Statics.setBackground(Color.WHITE);
      Statics.setForeground(Color.BLACK);
      Statics.addActionListener(this);
      Statics.setFocusable(false);
      add(Statics);

      Logout = new JButton("Log out");
      Logout.setBounds(250, 500, 200, 50);
      Logout.setFont(new Font("tahoma", Font.BOLD, 25));
      Logout.addActionListener(this);
      Logout.setBackground(Color.WHITE);
      Logout.setForeground(Color.BLACK);
      Logout.setFocusable(false);
      add(Logout);

      ImageIcon i1 = new ImageIcon("a.jpg");
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

   @Override
   public void actionPerformed(ActionEvent e) {

      if (e.getSource() == Statics) {

         new Statics();

      } else if (e.getSource() == IssueBook) {

         new IssueBook();

      } else if (e.getSource() == ReturnBook) {

         new ReturnBook();

      } else if (e.getSource() == Logout) {
         setVisible(false);
         new StdntOrAdmn();
      }

   }

   public static void main(String[] args) {
      new DashBoard();
   }

}
