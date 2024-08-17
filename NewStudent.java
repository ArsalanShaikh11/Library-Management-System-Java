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

public class NewStudent extends JFrame implements ActionListener {

    JButton addS, cancel;
    JTextField name, Roll_no;
    JComboBox Year, branch;

    NewStudent() {

        setBounds(00, 00, 1550, 1000);
        setLayout(null);

        JLabel Name = new JLabel("Name");
        Name.setBounds(530, 150, 200, 100);
        Name.setFont(new Font("times new roman", Font.BOLD, 40));
        Name.setBackground(new Color(153, 76, 0));
        Name.setForeground(Color.BLACK);
        add(Name);

        name = new JTextField();
        name.setBounds(740, 180, 200, 40);
        name.setFont(new Font("", Font.PLAIN, 20));
        add(name);

        JLabel Rollno = new JLabel("Roll No");
        Rollno.setBounds(530, 250, 200, 100);
        Rollno.setFont(new Font("times new roman", Font.BOLD, 40));
        Rollno.setBackground(new Color(153, 76, 0));
        Rollno.setForeground(Color.BLACK);
        add(Rollno); // font name
                     // arial, arial black , cambria , raleway ,tahoma , times new roman
                     // courier new ,
        Roll_no = new JTextField(); // Georgia ,Garamond , Century Gothic ,
        Roll_no.setBounds(740, 280, 200, 40);
        Roll_no.setFont(new Font("", Font.PLAIN, 20));
        add(Roll_no);

        JLabel year = new JLabel("Year");
        year.setBounds(530, 350, 200, 100);
        year.setFont(new Font("times new roman", Font.BOLD, 40));
        year.setBackground(new Color(153, 76, 0));
        year.setForeground(Color.BLACK);
        add(year);

        String str[] = { "FE", "SE", "TE", "BE" };
        Year = new JComboBox<>(str);
        Year.setBounds(740, 380, 200, 40);
        Year.setFont(new Font("", Font.BOLD, 20));
        add(Year);

        JLabel Branch = new JLabel("Branch");
        Branch.setBounds(530, 450, 200, 100);
        Branch.setFont(new Font("times new roman", Font.BOLD, 40));
        Branch.setBackground(new Color(153, 76, 0));
        Branch.setForeground(Color.BLACK);
        add(Branch);

        String str1[] = { "IT", "CS", "AIML", "EXTC" };
        branch = new JComboBox<>(str1);
        branch.setBounds(740, 480, 200, 40);
        branch.setFont(new Font("", Font.BOLD, 20));
        add(branch);

        addS = new JButton("SAVE");
        addS.setBounds(580, 600, 120, 30);
        addS.setFont(new Font("arial", Font.BOLD, 20));
        addS.setBackground(Color.BLACK);
        addS.setForeground(Color.GREEN);
        addS.addActionListener(this);
        add(addS);

        cancel = new JButton("CANCEL");
        cancel.setBounds(780, 600, 120, 30);
        cancel.setFont(new Font("arial", Font.BOLD, 20));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.red);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon("4.jpg");
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

        if (e.getSource() == addS && name.getText().equals("") && Roll_no.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Name and Roll No should not be empty");
        }

        else if (e.getSource() == cancel) {
            setVisible(false);
            new Admndshbrd();
        }

        else if (e.getSource() == addS && name.getText().equals("") || Roll_no.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Name and Roll No should not be empty");
        }

        else if (e.getSource() == addS) {

            String Name = name.getText();
            String Rollno = Roll_no.getText();
            String year = (String) Year.getSelectedItem();
            String Branch = (String) branch.getSelectedItem();

            try {

                Conn conn = new Conn();
                String Query = "Insert into student values( '" + Name + "' , '" + Rollno + "', '" + year + "', '"
                        + Branch + "')";
                conn.s.executeUpdate(Query);

                JOptionPane.showMessageDialog(null, "Student Added Successfully");
                setVisible(false);
                new NewStudent();
            } catch (Exception ea) {
                ea.printStackTrace();

            }

        }

    }

    public static void main(String[] args) {
        new NewStudent();
    }

}
