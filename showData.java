import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class showData extends JFrame implements ActionListener{
    JTable table;
    JButton back;

    public showData() {

        setTitle("Database Table Example");
        setSize(600, 400);
        setLocation(400, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        back = new JButton("Back");
        back.setBounds(230 , 310 , 90 , 25);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        try {
            String query = "select *from book";
            connection cn = new connection(query);
            ResultSet rs = cn.stmt2.executeQuery(query);

            // Create a table model and populate it with data
            DefaultTableModel model = new DefaultTableModel();
            int columnCount = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(rs.getMetaData().getColumnName(i));
            }
            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                model.addRow(rowData);
            }

            // Create JTable with the model
            table = new JTable(model);
            table.setEnabled(false);
            // Add JTable to a JScrollPane and add it to the frame
            JScrollPane scrollPane = new JScrollPane(table);
            getContentPane().add(scrollPane, BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
        } 
       
    }
    public void actionPerformed(java.awt.event.ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new next();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            showData example = new showData();
            example.setVisible(true);
        });
    }
}
