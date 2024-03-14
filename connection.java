
import java.sql.*;

import javax.swing.JOptionPane;
public class connection {

    Connection cn;
    PreparedStatement stmt;
    Statement stmt2;
    
    connection(String query) {
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "Dhruvil@23");
            stmt = cn.prepareStatement(query);
            stmt2 = cn.createStatement();
        } catch (Exception e) { 
            System.out.println("Error in connecting to the database." + e);
            JOptionPane.showMessageDialog(null,"Rjau");
        }
    }
    
    public static void main(String[] args) {
        new connection("");
    }
}
