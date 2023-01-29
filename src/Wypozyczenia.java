import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Wypozyczenia extends JFrame{
    private JTable table1;
    private JTextField Imie;
    private JTextField Nazwisko;
    private JTextField Tytul;
    private JButton resetButton;
    private JPanel Panel;
    private JButton pokazDaneButton;
    private JButton exitButton;
    private JButton przypiszWypożyczenieButton;
    private JButton zwróćButton;
    private JButton obliczKareButton;
    private JTextField date;

    public Wypozyczenia() {

        super("Wypozyczenia");
        this.setContentPane(this.Panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 500);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pokazDaneButton.setEnabled(true);
                Imie.setText("");
                Nazwisko.setText("");
                Tytul.setText("");

                ((DefaultTableModel)table1.getModel()).setNumRows(0);
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
                    String sql = "Select * from wypozyczenia";
                    ResultSet rs = st.executeQuery(sql);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    DefaultTableModel mod = (DefaultTableModel) table1.getModel();

                    int kolumny = rsmd.getColumnCount();
                    String[] nazwa = new String[kolumny];
                    for (int i = 0; i < kolumny; i++)
                        nazwa[i] = rsmd.getColumnName(i + 1);
                    mod.setColumnIdentifiers(nazwa);

                    String one, two, three, four,five;

                    while (rs.next()) {
                        one = rs.getString(1);
                        two = rs.getString(2);
                        three = rs.getString(3);
                        four = rs.getString(4);
                        five = rs.getString(5);
                        String[] row = {one, two, three, four, five};
                        mod.addRow(row);
                    }
                    st.close();
                    con.close();

                } catch (Exception ev) {
                    System.out.println(ev.getMessage());
                }
            }
        });
        przypiszWypożyczenieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/swing?useSSL=false","root","");
                    String name=Imie.getText();
                    String last=Nazwisko.getText();
                    String tytul=Tytul.getText();
                    String data = date.getText();


                    Statement st = con.createStatement();

                    String sql="Insert Into wypozyczenia (Imie_Klienta,Nazwisko_Klienta,Tytul,Data_Zwrotu) Values('"+name+"','"+last+"','"+tytul+"','"+data+"')";

                    st.executeUpdate(sql);
                    st.close();
                    con.close();
                }
                catch (Exception ev)
                {
                    System.out.println(ev.getMessage());
                }

                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/swing?useSSL=false","root","");
                    String tytul=Tytul.getText();


                    Statement st = con.createStatement();

                    String sql="Update ksiazki Set Status='Wypozyczona' Where tytul='"+tytul+"'";

                    st.executeUpdate(sql);
                    st.close();
                    con.close();
                }
                catch (Exception ev)
                {
                    System.out.println(ev.getMessage());
                }

                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/swing?useSSL=false","root","");

                    Statement st = con.createStatement();

                    String sql = "Delete from wypozyczenia Where Imie_Klienta ='' or Nazwisko_Klienta ='' or Tytul ='' or Data_Zwrotu =''";

                    st.executeUpdate(sql);

                    st.close();
                    con.close();

                }
                catch (Exception ev)
                {
                    System.out.println(ev.getMessage());
                }

            }
        });
        zwróćButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/swing?useSSL=false","root","");
                    String name=Imie.getText();
                    String last=Nazwisko.getText();
                    String tytul=Tytul.getText();


                    Statement st = con.createStatement();

                    String sql="Delete from wypozyczenia Where Imie_Klienta= '"+name+"'and Nazwisko_Klienta='"+last+"'and Tytul='"+tytul+"'";

                    st.executeUpdate(sql);
                    st.close();
                    con.close();
                }
                catch (Exception ev)
                {
                    System.out.println(ev.getMessage());
                }

                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/swing?useSSL=false","root","");
                    String tytul=Tytul.getText();


                    Statement st = con.createStatement();

                    String sql="Update ksiazki Set Status='Dostepna' Where tytul='"+tytul+"'";

                    st.executeUpdate(sql);
                    st.close();
                    con.close();
                }
                catch (Exception ev)
                {
                    System.out.println(ev.getMessage());
                }
            }
        });
        obliczKareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/swing?useSSL=false","root","");

                    Statement st = con.createStatement();

                    String sql="Update wypozyczenia Set Kara='20zl' Where Cast(Data_Zwrotu AS int)-Cast(CURDATE() AS int)<0";

                    st.executeUpdate(sql);
                    st.close();
                    con.close();
                }
                catch (Exception ev)
                {
                    System.out.println(ev.getMessage());
                }
            }
        });
    }
    public static void main(String[] args)
    {
        okno1 Example = new okno1();
        Example.setVisible(true);

    }
}
