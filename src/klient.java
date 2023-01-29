import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class klient extends JFrame{
    private JTextField Imie;
    private JTextField Nazwisko;
    private JTextField Adres;
    private JTextField telefon;
    private JButton dodajNowegoKlientaButton;
    private JPanel Panel;
    private JButton powrótButton;
    private JButton resetButton;

    public klient() {
        super("Klient");
        this.setContentPane(this.Panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);

        dodajNowegoKlientaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/swing?useSSL=false","root","");
                    String name=Imie.getText();
                    String last=Nazwisko.getText();
                    String adr=Adres.getText();
                    String nr_telefonu =telefon.getText();

                    Statement st = con.createStatement();


                    String sql="Insert Into klient (Imie,Nazwisko,Adres,Nr_telefonu) Values('"+name+"','"+last+"','"+adr+"','"+nr_telefonu+"')";
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

                    String sql = "Delete from klient Where Imie ='' or Nazwisko ='' or Adres ='' or Nr_telefonu =''";

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
        powrótButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Start star=new Start();
                star.show();
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Imie.setText("");
                Nazwisko.setText("");
                Adres.setText("");
                telefon.setText("");
            }
        });
    }
    public static void main(String[] args)
    {
        okno1 Example = new okno1();
        Example.setVisible(true);

    }
}
