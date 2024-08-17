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

public class AdmnABT extends JFrame implements ActionListener {

    JButton back;
    JTable table;

    AdmnABT() {
        setBounds(0, 0, 1550, 1000);
        setLayout(null);

        back = new JButton("Back");
        back.setBounds(700, 670, 120, 40);
        back.setFont(new Font("", Font.TYPE1_FONT, 20));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFocusable(false);
        add(back);

        JLabel Books_Available = new JLabel("Books");
        Books_Available.setBounds(680, 55, 1000, 50);
        Books_Available.setFont(new Font("Tahoma", Font.TYPE1_FONT, 40));
        Books_Available.setForeground(Color.BLACK);
        Books_Available.setBackground(Color.DARK_GRAY);
        add(Books_Available);

        JLabel Bookname = new JLabel("Book Name");
        Bookname.setBounds(430, 150, 1000, 50);
        Bookname.setFont(new Font("courier new", Font.BOLD, 25));
        Bookname.setForeground(Color.BLACK);
        Bookname.setBackground(Color.white);
        add(Bookname);

        JLabel Authorname = new JLabel("Author");
        Authorname.setBounds(730, 150, 1000, 50);
        Authorname.setFont(new Font("courier new", Font.BOLD, 25));
        Authorname.setForeground(Color.BLACK);
        Authorname.setBackground(Color.white);
        add(Authorname);

        JLabel Available = new JLabel("Available");
        Available.setBounds(1030, 150, 1000, 50);
        Available.setFont(new Font("Courier New", Font.BOLD, 25));
        Available.setForeground(Color.BLACK);
        Available.setBackground(Color.white);
        add(Available);

        table = new JTable();
        table.setBounds(300, 200, 950, 450);
        table.setFont(new Font("calibri", Font.PLAIN, 15)); // calibri
        add(table);

        try {
            Conn c = new Conn();
            String Query = "Select * From Available_Books";
            ResultSet rs = c.s.executeQuery(Query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception ee) {
            ee.printStackTrace();
        }

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);

        setUndecorated(true);

        setVisible(true);

    }

    public static void main(String[] args) {
        new AdmnABT();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Admndshbrd();
    }

}
