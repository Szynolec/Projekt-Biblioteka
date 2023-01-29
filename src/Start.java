import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Start extends JFrame {
    private JButton dodajKsiążkęButton;
    private JButton wylogujButton;
    private JButton wypozyczButton;
    private JButton dodajKlientaButton;
    private JPanel Panel1;
    private JButton pokazDaneButton;
    private JTable table1;
    private JButton pokazKlientówButton;
    private JTable table2;
    private JButton resetButton;

    public Start() {

        super("Strona Główna");
        this.setContentPane(this.Panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);

        dodajKsiążkęButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Ksiazka ksiaz = new Ksiazka();
                ksiaz.show();

            }
        });
        dodajKlientaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                klient kli = new klient();
                kli.show();

            }
        });
        wypozyczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Wypozyczenia wypo = new Wypozyczenia();
                wypo.show();
            }
        });
        wylogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                okno1 Example = new okno1();
                Example.show();
            }
        });
        pokazDaneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pokazDaneButton.setEnabled(false);
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing?useSSL=false", "root", "");
                    Statement st = con.createStatement();
                    String sql = "Select * from ksiazki";
                    ResultSet rs = st.executeQuery(sql);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    DefaultTableModel mod = (DefaultTableModel) table1.getModel();

                    int kolumny = rsmd.getColumnCount();
                    String[] nazwa = new String[kolumny];
                    for (int i = 0; i < kolumny; i++)
                        nazwa[i] = rsmd.getColumnName(i + 1);
                    mod.setColumnIdentifiers(nazwa);

                    String one, two, three, four;

                    while (rs.next()) {
                        one = rs.getString(1);
                        two = rs.getString(2);
                        three = rs.getString(3);
                        four = rs.getString(4);
                        String[] row = {one, two, three, four};
                        mod.addRow(row);
                    }
                    st.close();
                    con.close();

                } catch (Exception ev) {
                    System.out.println(ev.getMessage());
                }

            }
        });

        pokazKlientówButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pokazKlientówButton.setEnabled(false);
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing?useSSL=false", "root", "");
                    Statement st = con.createStatement();
                    String sql = "Select * from klient";
                    ResultSet rs = st.executeQuery(sql);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    DefaultTableModel mod = (DefaultTableModel) table2.getModel();

                    int kolumny = rsmd.getColumnCount();
                    String[] nazwa = new String[kolumny];
                    for (int i = 0; i < kolumny; i++)
                        nazwa[i] = rsmd.getColumnName(i + 1);
                    mod.setColumnIdentifiers(nazwa);

                    String one, two, three, four;

                    while (rs.next()) {
                        one = rs.getString(1);
                        two = rs.getString(2);
                        three = rs.getString(3);
                        four = rs.getString(4);
                        String[] row = {one, two, three, four};
                        mod.addRow(row);
                    }
                    st.close();
                    con.close();

                } catch (Exception ev) {
                    System.out.println(ev.getMessage());
                }
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pokazKlientówButton.setEnabled(true);
                pokazDaneButton.setEnabled(true);
                ((DefaultTableModel)table1.getModel()).setNumRows(0);
                ((DefaultTableModel)table2.getModel()).setNumRows(0);
            }
        });
    }

    public static void main(String[] args) {
        okno1 Example = new okno1();
        Example.setVisible(true);

    }
}

