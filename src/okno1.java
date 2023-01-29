import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class okno1 extends JFrame{
    private JTextField Login;
    private JButton ZALOGUJButton;
    private JPasswordField Haslo;
    private JPanel Panel;
    private JLabel Wyswietl;
    public okno1() {

        super("Logowanie");
        this.setContentPane(this.Panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);

        ZALOGUJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/swing?useSSL=false","root","");
                    String nazwa=Login.getText();
                    String pass= String.valueOf(Haslo.getPassword());

                    Statement st = con.createStatement();


                    String sql="select * from pracownicy where Login='"+nazwa+"'and Haslo='"+pass+"'";
                    ResultSet rs=st.executeQuery(sql);

                    if(rs.next())
                    {
                        dispose();
                        Start star=new Start();
                        star.show();
                    }
                    else
                    {
                        Wyswietl.setText("Podaj poprawne dane");
                    }
                }
                catch (Exception ev)
                {
                    Wyswietl.setText("blad");
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
