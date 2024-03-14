import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class insert extends JFrame implements ActionListener {
    JLabel bookid, bname, author, quantity, price;
    JTextField id, bookname, aname;
    JSpinner qnty;
    JTextField p;
    JButton add;

    insert() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Insert Data ");
        setSize(600, 400);
        setLocation(400, 100);
        setVisible(true);
        setLayout(null);

        JLabel info = new JLabel("Enter Book Details  ");
        info.setFont(new Font("Arial", Font.BOLD, 26));
        info.setBounds(180, 8, 250, 38);
        add(info);

        bookid = new JLabel("Book ID : ");
        bookid.setFont(new Font("times new roman", Font.BOLD, 15));
        bookid.setBounds(100, 70, 100, 20);
        add(bookid);
        id = new JTextField();
        id.setBounds(210, 72, 180, 20);
        add(id);

        bname = new JLabel("Book Name : ");
        bname.setFont(new Font("times new roman", Font.BOLD, 15));
        bname.setBounds(100, 120, 100, 20);
        add(bname);
        bookname = new JTextField();
        bookname.setBounds(210, 122, 180, 20);
        add(bookname);

        author = new JLabel("Author Name : ");
        author.setFont(new Font("times new roman", Font.BOLD, 15));
        author.setBounds(100, 170, 120, 20);
        add(author);
        aname = new JTextField();
        aname.setBounds(210, 172, 180, 20);
        add(aname);

        quantity = new JLabel("Quantities : ");
        quantity.setFont(new Font("times new roman", Font.BOLD, 15));
        quantity.setBounds(100, 220, 100, 20);
        add(quantity);

        // Using a spinner for quantity input
        SpinnerModel qntyModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
        qnty = new JSpinner(qntyModel);
        ((JSpinner.DefaultEditor) qnty.getEditor()).getTextField().setEditable(false); // make it non-editable
        qnty.setBounds(210, 222, 180, 20);
        add(qnty);

        price = new JLabel("Price : ");
        price.setFont(new Font("times new roman", Font.BOLD, 15));
        price.setBounds(100, 270, 100, 20);
        add(price);
        p = new JTextField();
        p.setBounds(210, 272, 180, 20);
        add(p);

        add = new JButton("+ Add");
        add.setBounds(300, 310, 90, 25);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == add){
            try{
                String quary = "insert into book values(?,?,?,?,?)";
                connection cn = new connection(quary); 
                System.out.println("connected");
                cn.stmt.setString(1, id.getText());
                cn.stmt.setString(2, bookname.getText());
                cn.stmt.setString(3, aname.getText());
                cn.stmt.setInt(4,(int) qnty.getValue() );
                cn.stmt.setInt(5, Integer.parseInt(p.getText()));
                System.out.println(Integer.parseInt(p.getText()));
                cn.stmt.executeUpdate();
                cn.stmt.close();
                JOptionPane.showMessageDialog(null,"Data saved successfully !!");
                this.setVisible(false);
                new next();
            }
            catch (Exception e) {
                System.out.println("User with that username already Exist !");
                JOptionPane.showMessageDialog(null,"User with that username already Exist !");
           }
        }    
    }

    public static void main(String[] args) {
        new insert();
    }
}
