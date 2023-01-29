import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Ksiazka extends JFrame{
    private JTextField Autor;
    private JTextField Tytuł;
    private JTextField Wydawnictwo;
    private JTextField Status;
    private JButton resetButton;
    private JButton dodajKsiązkeButton;
    private JButton powrótButton;
    private JPanel Panel;

    public Ksiazka() {

        super("Ksiazka");
        this.setContentPane(this.Panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Autor.setText("");
                Tytuł.setText("");
                Wydawnictwo.setText("");
                Status.setText("");
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
        dodajKsiązkeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/swing?useSSL=false","root","");
                    String aut=Autor.getText();
                    String tytu=Tytuł.getText();
                    String wyda=Wydawnictwo.getText();
                    String stat=Status.getText();


                    Statement st = con.createStatement();

                        String sql = "Insert Into ksiazki (Autor,Tytul,Wydawnictwo,Status) Values('" + aut + "','" + tytu + "','" + wyda + "','" + stat + "')";
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

                    String sql = "Delete from ksiazki Where Autor ='' or Tytul ='' or Wydawnictwo ='' or Status =''";

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
