import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TampilanLogin extends JFrame{
    JLabel lJudul = new JLabel("LOGIN");
    JLabel lUsername = new JLabel("Username");
    JLabel lPassword = new JLabel("Password");
    JLabel lTanya = new JLabel("Belum memiliki akun? Klik Daftar Disini");
    
    JTextField fUsername = new JTextField();
    JTextField fPassword = new JTextField();
    
    JButton btnLogin = new JButton("Login");
    JButton btnToRegister = new JButton("Daftar");
    
    public TampilanLogin() {
        setTitle("Login");
        setSize(400, 400);
        setLayout(null);
        
        add(lJudul);
        add(lUsername);
        add(lPassword);
        add(lTanya);
        add(fUsername);
        add(fPassword);
        add(btnLogin);
        add(btnToRegister);
        
        lJudul.setBounds(120, 20, 250, 30);
        lUsername.setBounds(40, 60, 250, 30);
        fUsername.setBounds(40, 90, 250, 30);
        lPassword.setBounds(40, 140, 250, 30);
        fPassword.setBounds(40, 170, 250, 30);
        btnLogin.setBounds(100, 240, 100, 30);
        lTanya.setBounds(20, 300, 250, 30);
        btnToRegister.setBounds(250, 305, 80, 20);
        
        String query, query1;
        
        String dbTabel = "users";
        Koneksi koneksi = new Koneksi();
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String query1 = "SELECT * FROM " + dbTabel + " where username = '" + getUsername()+ "'";
                           // + " and password = '" + getPassword() + "'";
                    ResultSet rs = koneksi.statement.executeQuery(query1);
                    
                    if(rs.next()){
                        //JOptionPane.showMessageDialog(null, "Login Berhasil!");
                        String query = "SELECT * FROM " + dbTabel + " where username = '" + getUsername()+ "'"
                                + " and password = '" + getPassword()+ "'";
                        ResultSet rs2 = koneksi.statement.executeQuery(query);
                        
                        if(rs2.next()){
                            JOptionPane.showMessageDialog(null, "Login Berhasil!");
                        }else{
                            JOptionPane.showMessageDialog(null, "Password Salah!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Username Tidak Ditemukan!");
                    }
                } catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "Gagal Login!");
                } 
            }
        });
        
        btnToRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new TampilanRegister();
                } catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "Gagal Mendaftar!");
                } 
            }
        });
        
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public String getUsername(){
        return fUsername.getText();
    }

    public String getPassword(){
        return fPassword.getText();
    }
}
