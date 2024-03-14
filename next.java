import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class next extends JFrame implements ActionListener{
    JButton Insert,Delete,Search,Update,show;
    next() {
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

         JLabel text = new JLabel("<html><u><b> WELCOME TO LIBRARY  </b></u></html> ");
        text.setFont(new Font("Arial" , Font.BOLD , 20));
        text.setBounds(200 , 35, 400 ,20);
        add(text);

         JLabel op1 = new JLabel(" Add data in Library :  ");
        op1.setFont(new Font("Arial" , Font.BOLD , 15));
        op1.setBounds(100 , 100, 400 ,20);
        add(op1);

        Insert = new JButton("Insert");
        Insert.setBounds( 320, 100, 100 ,20);
        Insert.addActionListener(this);
        Insert.setBackground(Color.BLACK);
        Insert.setForeground(Color.WHITE);
        add(Insert);
        

         JLabel op2 = new JLabel(" Update data in Library :  ");
        op2.setFont(new Font("Arial" , Font.BOLD , 15));
        op2.setBounds(100 , 150, 400 ,20);
        add(op2);

        Update = new JButton("Update");
        Update.setBounds(320 , 150, 100,20);
        Update.addActionListener(this);
        Update.setBackground(Color.BLACK);
        Update.setForeground(Color.WHITE);
        add(Update);

         JLabel op3 = new JLabel(" Delete data From Library :   ");
        op3.setFont(new Font("Arial" , Font.BOLD , 15));
        op3.setBounds(100 , 200, 400 ,20);
        add(op3);

        Delete = new JButton("Delete");
        Delete.setBounds(320 , 200, 100,20);
        Delete.addActionListener(this);
        Delete.setBackground(Color.BLACK);
        Delete.setForeground(Color.WHITE);
        add(Delete);

        //  JLabel op4 = new JLabel(" Search book from Library :   ");
        // op4.setFont(new Font("Arial" , Font.BOLD , 15));
        // op4.setBounds(100 , 250, 400 ,20);
        // add(op4);

        // Search = new JButton("Search");
        // Search.setBounds(320 , 250, 100 ,20);
        // Search.addActionListener(this);
        // Search.setBackground(Color.BLACK);
        // Search.setForeground(Color.WHITE);
        // add(Search);

         JLabel op5 = new JLabel(" Display Database :   ");
        op5.setFont(new Font("Arial" , Font.BOLD , 15));
        op5.setBounds(100 , 250, 400 ,20);
        add(op5);

        show = new JButton("Show");
        show.setBounds(320 , 250, 100 ,20);
        show.addActionListener(this);
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        add(show);

        setTitle("Welcome");
        setSize(600,400);
        setLocation(400 , 100);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Insert){
            new insert();
            this.setVisible(false);
        }
        if(e.getSource() == Delete){
            new delete();
            this.setVisible(false);
        }

        if(e.getSource() == show){
             SwingUtilities.invokeLater(() -> {
            showData example = new showData();
            example.setVisible(true);
        });
            // new showData();
            this.setVisible(false);
        }
        if(e.getSource() == Update){
            new update();
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new next();
    }
}

