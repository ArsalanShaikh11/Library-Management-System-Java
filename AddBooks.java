import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddBooks extends JFrame implements ActionListener {

    JButton addb, cancel;
    JTextField bname, author, Publisher;
    JComboBox Avail;

    AddBooks() {
        setBounds(0, 0, 1550, 1000);
        setLayout(null);

        JLabel B_Name = new JLabel("Book Name");
        B_Name.setBounds(520, 150, 200, 100);
        B_Name.setFont(new Font("Cambria", Font.BOLD, 30));
        B_Name.setBackground(Color.WHITE);
        B_Name.setForeground(Color.black);
        add(B_Name);

        bname = new JTextField();
        bname.setBounds(780, 180, 200, 40);
        bname.setFont(new Font("", Font.PLAIN, 20));
        add(bname);

        JLabel Author = new JLabel("Author");
        Author.setBounds(520, 250, 200, 100);
        Author.setFont(new Font("Cambria", Font.BOLD, 30));
        Author.setForeground(Color.black);
        Author.setBackground(Color.WHITE);
        add(Author);

        author = new JTextField();
        author.setBounds(780, 280, 200, 40);
        author.setFont(new Font("", Font.PLAIN, 20));
        add(author);

        JLabel Available = new JLabel("Available");
        Available.setBounds(520, 350, 200, 100);
        Available.setFont(new Font("Cambria", Font.BOLD, 30));
        Available.setForeground(Color.BLACK);
        add(Available);

        String str[] = { "Yes" };
        Avail = new JComboBox<>(str);
        Avail.setBounds(780, 380, 200, 40);
        Avail.setFont(new Font("", Font.BOLD, 20));
        add(Avail);

        addb = new JButton("SAVE");
        addb.setBounds(560, 500, 120, 30);
        addb.setFont(new Font("", Font.BOLD, 20));
        addb.setBackground(Color.BLACK);
        addb.setForeground(Color.GREEN);
        addb.addActionListener(this);
        addb.setFocusable(false);
        add(addb);

        cancel = new JButton("CANCEL");
        cancel.setBounds(800, 500, 120, 30);
        cancel.setFont(new Font("", Font.BOLD, 20));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.red);
        cancel.addActionListener(this);
        cancel.setFocusable(false);
        add(cancel);

        ImageIcon i1 = new ImageIcon("UvpC1jt.jpg"); /* zimg.7.jpg */
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
        new AddBooks();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addb && bname.getText().equals("") && author.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Enter book name and author name");

        }

        else if (e.getSource() == cancel) {
            // setVisible(false);
            new Admndshbrd();
        }

        else if (e.getSource() == addb && bname.getText().equals("") || author.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Enter book name and author name");

        }

        else if (e.getSource() == addb) {

            String bookname = bname.getText();
            String authorname = author.getText();
            String available = (String) Avail.getSelectedItem();

            try {

                Conn conn = new Conn();
                String Query = "Insert into Available_Books values( '" + bookname + "' , '" + authorname + "', '"
                        + available + "')";
                conn.s.executeUpdate(Query);

                JOptionPane.showMessageDialog(null, "Book Added Successfully");
                // setVisible(false);
                // new AddBooks();
                bname.setText("");
                author.setText("");

            } catch (Exception ee) {
                ee.printStackTrace();
            }

        }

    }
}
