import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Admndshbrd extends JFrame implements ActionListener {

  JButton NewStudent, AddBook, Students, IssuedBooks, Availablebooks, Back;

  Admndshbrd() {

    setBounds(0, 0, 1550, 1000);
    setLayout(null);

    NewStudent = new JButton("Add Student");
    NewStudent.setBounds(250, 150, 250, 50);
    NewStudent.setFont(new Font("Tahoma", Font.BOLD, 25));
    NewStudent.setBackground(Color.WHITE);
    NewStudent.addActionListener(this);
    NewStudent.setForeground(Color.BLACK);
    NewStudent.setFocusable(false);
    add(NewStudent);

    AddBook = new JButton("Add Books");
    AddBook.setBounds(250, 250, 250, 50);
    AddBook.setFont(new Font("Tahoma", Font.BOLD, 25));
    AddBook.setBackground(Color.WHITE);
    AddBook.setForeground(Color.BLACK);
    AddBook.addActionListener(this);
    AddBook.setFocusable(false);
    add(AddBook);

    Students = new JButton("Students");
    Students.setBounds(250, 350, 250, 50);
    Students.setFont(new Font("Tahoma", Font.BOLD, 25));
    Students.setBackground(Color.WHITE);
    Students.setForeground(Color.BLACK);
    Students.addActionListener(this);
    Students.setFocusable(false);
    add(Students);

    IssuedBooks = new JButton("Issued Books");
    IssuedBooks.setBounds(250, 450, 250, 50);
    IssuedBooks.setFont(new Font("Tahoma", Font.BOLD, 25));
    IssuedBooks.setBackground(Color.WHITE);
    IssuedBooks.setForeground(Color.BLACK);
    IssuedBooks.addActionListener(this);
    IssuedBooks.setFocusable(false);
    add(IssuedBooks);

    Availablebooks = new JButton("All Books");
    Availablebooks.setBounds(250, 550, 250, 50);
    Availablebooks.setFont(new Font("Tahoma", Font.BOLD, 25));
    Availablebooks.setBackground(Color.WHITE);
    Availablebooks.setForeground(Color.BLACK);
    Availablebooks.addActionListener(this);
    Availablebooks.setFocusable(false);
    add(Availablebooks);

    Back = new JButton("Log Out");
    Back.setBounds(250, 650, 250, 50);
    Back.setFont(new Font("tahoma", Font.BOLD, 25));
    Back.addActionListener(this);
    Back.setBackground(Color.WHITE);
    Back.setForeground(Color.BLACK);
    Back.setFocusable(false);
    add(Back);

    ImageIcon i1 = new ImageIcon("4.jpg");
    Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0, 0, 1550, 1000);
    add(image);

    setUndecorated(true);

    setVisible(true);

  }

  public static void main(String[] args) {
    new Admndshbrd();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == NewStudent) {
      // setVisible(false);
      new NewStudent();
    } else if (e.getSource() == AddBook) {
      // setVisible(false);
      new AddBooks();
    } else if (e.getSource() == Students) {
      // setVisible(false);
      new Students();
    } else if (e.getSource() == IssuedBooks) {
      // setVisible(false);
      new AdmnIST();
    } else if (e.getSource() == Availablebooks) {
      // setVisible(false);
      new AdmnABT();
    } else if (e.getSource() == Back) {
      // setVisible(false);
      new StdntOrAdmn();
    }
  }

}
