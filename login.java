import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
public class login  extends JFrame implements ActionListener{

    JButton signIn , next , clear;
    JTextField userField ;
    JPasswordField passField;
    
    ResultSet rset = null;

    int flag =0;
    static ArrayList<String> list = new ArrayList<>();
    login(){
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
        JLabel text = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        text.setFont(new Font("Arial" , Font.BOLD , 20));
        text.setBounds(180 , 30 , 400 , 80);
        add(text);

        JLabel useName = new JLabel("User Name : ");
        useName.setFont(new Font("Arial" , Font.BOLD , 15));
        useName.setBounds(180 , 120 , 100 , 50);
        add(useName);
        userField = new JTextField();
        userField.setBounds(290 ,135 , 200 , 25 );
        add(userField);
        
        JLabel pass = new JLabel("Password : ");
        pass.setFont(new Font("Arial" , Font.BOLD , 15));
        pass.setBounds(180 , 155 ,100 , 50);
        add(pass);
        passField = new JPasswordField();
        passField.setBounds(290 ,170 , 200 , 25 );
        add(passField);
        
        signIn = new JButton("SIGN IN");
        signIn.setBounds(290 , 220 , 80 , 25);
        signIn.addActionListener(this);
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.white);
        add(signIn);
        
        clear = new JButton("CLEAR");
        clear.setBounds(410 , 220 , 80 , 25);
        clear.addActionListener(this);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);
        
        // next = new JButton("NEXT");
        // next.setBounds(350 , 260 , 90 , 25);
        // next.addActionListener(this);
        // next.setBackground(Color.BLACK);
        // next.setForeground(Color.WHITE);
        // add(next);
        
        setTitle("Login Page");
        setSize(600,400);
        setLocation(400 , 100);
        setVisible(true);
    }
    public void actionPerformed( ActionEvent ae){
        if( ae.getSource() == clear ){
            userField.setText(" ");
            passField.setText(" ");
        }
        if(ae.getSource() == next){
            setVisible(false);
            new next();
        }
        else if(ae.getSource() == signIn){
            String query = "insert into signin values( ? , ?)";
            try {
                connection cn = new connection(query);
                System.out.println("conection created");
                char[] passwordChars = passField.getPassword();
                String password = new String(passwordChars);
                cn.stmt.setString(1, userField.getText());
                cn.stmt.setString(2, password);
                cn.stmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"Signin successfully !!");
                setVisible(false);
                new next();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        }
    public static void main(String[] args) throws Exception  {
        new login();
    }
}