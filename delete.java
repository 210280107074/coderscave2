import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class delete extends JFrame implements ActionListener{
    JTextField tf1;
    JButton Delete;
    JTextField bookname;
    delete(){
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Sign Up 2Page");
        setSize(430,250);
        setLocation(400, 100);
        setVisible(true);
        setLayout(null);
        setLayout(null);

        JLabel Title = new JLabel(" Deletion  ");
        Title.setFont( new Font("Arial" , Font.BOLD , 25));
        Title.setBounds(140 , 20 , 250 , 30);
        add(Title);

        JLabel bookname = new JLabel("Enter the Book Name :");
        bookname.setFont( new Font("Arial" , Font.BOLD , 15));
        bookname.setBounds(40 , 90 , 180 , 30);
        add(bookname);
        tf1 = new JTextField();                                     
        tf1.setBounds(210 , 95 , 160 , 20 );
        add(tf1);

        Delete = new JButton("Delete");
        Delete.setBounds(160 , 145 , 90 , 25);
        Delete.addActionListener(this);
        Delete.setBackground(Color.BLACK);
        Delete.setForeground(Color.WHITE);
        add(Delete);

       
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == Delete){
            try {
                String query = "DELETE FROM book WHERE  BookName = '" + tf1.getText()+"'";
                connection cn2 = new connection(query);
                System.out.println("connected");
                System.out.println(query);
                cn2.stmt2.executeUpdate(query);
                cn2.stmt2.close();
                cn2.cn.close();
                JOptionPane.showMessageDialog(null,"Deleted successfully !!");
                setVisible(false);
                new next();
            } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
    public static void main(String arg[]){
        new delete();
        }
}
