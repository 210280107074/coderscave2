import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class update extends JFrame implements ActionListener {
    JTextField t1;
    JComboBox<String> c1; // Specify the generic type for JComboBox
    JButton ok;

    update() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Updation");
        setSize(600, 400);
        setLocation(400, 100);
        setVisible(true);
        setLayout(null);

        JLabel info = new JLabel("Updatation  ");
        info.setFont(new Font("Arial", Font.BOLD, 25));
        info.setBounds(220, 20, 250, 50);
        add(info);

        JLabel l2 = new JLabel("Enter a Book Id :  ");
        l2.setFont(new Font("times new roman", Font.BOLD, 15));
        l2.setBounds(60, 130, 140, 15);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(190, 128, 220, 20);
        add(t1);

        JLabel l1 = new JLabel("Select The Field That  You Want To Update :  ");
        l1.setFont(new Font("times new roman", Font.BOLD, 15));
        l1.setBounds(60, 180, 330, 15);
        add(l1);

        String[] column = {"BookName", "Author", "Quantity", "Price"}; // Make sure column names match your database
        c1 = new JComboBox<>(column);
        c1.setBounds(375, 178, 110, 20);
        c1.setBackground(Color.WHITE);
        add(c1);

        ok = new JButton("OK");
        ok.setBounds(250, 250, 90, 25);
        ok.addActionListener(this);
        ok.setBackground(Color.BLACK);
        ok.setForeground(Color.WHITE);
        add(ok);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            this.setVisible(false);
            JFrame f2 = new JFrame();
            f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
            f2.setVisible(true);
            f2.setTitle("Updation");
            f2.setSize(500, 300);
            f2.setLocation(400, 100);
            f2.setLayout(null);

            String selected = "Enter a new value for " + (String) c1.getSelectedItem() + " :";
            JLabel l2 = new JLabel(selected);
            l2.setFont(new Font("Arial", Font.BOLD, 14));
            l2.setBounds(30, 100, 300, 30);
            f2.add(l2);

            JTextField textf = new JTextField();
            textf.setBounds(280, 105, 180, 20);
            f2.add(textf);

            JButton ok2 = new JButton("Update");
            ok2.setBounds(250, 160, 80, 25);
            ok2.setBackground(Color.BLACK);
            ok2.setForeground(Color.WHITE);
            f2.add(ok2);

            ok2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {


                    String column;
                    String selected = (String)c1.getSelectedItem();

                    
                    String query2 = "UPDATE book11 SET "+ selected + " = ? WHERE bid = ?;";
                    System.out.println(query2);
                    
                    try {
                        connection cn = new connection(query2);
                        if(selected == "Price"){
                            cn.stmt.setInt(1,Integer.parseInt(textf.getText()));
                            cn.stmt.setString(2,t1.getText());
                        }
                        if(selected == "Quantity"){
                            cn.stmt.setInt(1,Integer.parseInt(textf.getText()));
                            cn.stmt.setString(2,t1.getText());
                        }
                        else{
                            cn.stmt.setString(1, textf.getText());
                            cn.stmt.setString(2, t1.getText());
                        }
                        int rowsUpdated = cn.stmt.executeUpdate();
                        System.out.println(query2);
                        JOptionPane.showMessageDialog(null, "Data Updated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("data updated successfully");
                        setVisible(false);
                        new next();
                        
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        new update();
    }
}
