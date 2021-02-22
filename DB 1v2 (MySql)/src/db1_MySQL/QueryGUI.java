package db1_MySQL;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class QueryGUI
    extends JFrame {

    private JButton btnNewButton;

    private final JButton btnNewButton_1;

    private final JPanel contentPane;

    private JTable table;

    private final JTextField textField;

    /**
     * Create the frame.
     */
    public QueryGUI() {

        try {
            //
            Class.forName("com.mysql.jdbc.Driver");
            //
            String url = "jdbc:mysql://localhost:3306/EMP";
            Connection con = DriverManager.getConnection(url, "root", "");
            //
            /*
             * System.out.println("URL: " + url);
             * System.out.println("Connection: " + con); System.out.println();
             */
            //
            Statement stmt;
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY");
            /*
             * while ( rs.next() ) { int id = rs.getInt("id"); String name =
             * rs.getString("name"); int age = rs.getInt("age"); String address
             * = rs.getString("address"); float salary = rs.getFloat("salary");
             * System.out.println( "ID = " + id ); System.out.println( "NAME = "
             * + name ); System.out.println( "AGE = " + age );
             * System.out.println( "ADDRESS = " + address ); System.out.println(
             * "SALARY = " + salary ); System.out.println(); }
             */

            this.table = new JTable(QueryGUI.buildTableModel(rs));
            // table.setBounds(0, 0, 428, 258);
            // contentPane.add(table);
            // -------------------------------------
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            this.table = new JTable();
            e.printStackTrace();
        }
        // ----------------------------------------
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 363);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(this.contentPane);
        this.contentPane.setLayout(null);
        // contentPane.setLayout(new BorderLayout(0, 0)); //make resize work -
        // it is BorderLayout in Swing Design

        JScrollPane scrollPane = new JScrollPane(this.table);
        // Rectangle r = contentPane.getBounds();
        // System.out.println(r.x +" "+ r.y+ " "+ r.width+ " "+ r.height);
        scrollPane.setBounds(16, 49, 428, 183);
        this.contentPane.add(scrollPane);

        this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.btnNewButton_1 = new JButton("Copy");
        this.btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(
                final MouseEvent e) {

                if (QueryGUI.this.table.getSelectedRows().length == 1) {
                    String s = "";
                    for (int i = 0; i < QueryGUI.this.table.getColumnCount(); i++) {
                        s +=
                            QueryGUI.this.table
                                .getValueAt(QueryGUI.this.table.getSelectedRows()[0], i) + " ";
                    }
                    QueryGUI.this.textField.setText(s);

                    // QueryGUI.this.textField.setText(
                    // QueryGUI.this.table.getValueAt(QueryGUI.this.table.getSelectedRows()[0],
                    // 0)
                    // + " "
                    // + QueryGUI.this.table
                    // .getValueAt(QueryGUI.this.table.getSelectedRows()[0],
                    // 1));
                }
            }
        });
        this.btnNewButton_1.setBounds(24, 239, 115, 29);
        this.contentPane.add(this.btnNewButton_1);

        this.textField = new JTextField();
        this.textField.setBounds(161, 240, 270, 35);
        this.contentPane.add(this.textField);
        this.textField.setColumns(10);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(63, 6, 132, 22);
        this.contentPane.add(menuBar);

    }

    public static DefaultTableModel buildTableModel(
        final ResultSet rs)
        throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(
                final int row,
                final int column) {

                // all cells false
                return false;
            }
        };

    }

    /**
     * Launch the application.
     */
    public static void main(
        final String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    QueryGUI frame = new QueryGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
