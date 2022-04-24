import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TampilanRegister extends JFrame{
    JLabel lJudul = new JLabel("REGISTER");
    JLabel lUsername = new JLabel("Username");
    JLabel lPassword = new JLabel("Password");

    JTextField fUsername = new JTextField();
    JTextField fPassword = new JTextField();
    
    JButton btnDaftar = new JButton("Daftar");

    public TampilanRegister() {
        setTitle("Register");
        setSize(400, 400);
        setLayout(null);
        
        add(lJudul);
        add(lUsername);
        add(lPassword);
        add(fUsername);
        add(fPassword);
        add(btnDaftar);
        
        lJudul.setBounds(120, 20, 250, 30);
        lUsername.setBounds(40, 60, 250, 30);
        fUsername.setBounds(40, 90, 250, 30);
        lPassword.setBounds(40, 140, 250, 30);
        fPassword.setBounds(40, 170, 250, 30);
        btnDaftar.setBounds(100, 240, 100, 30);
        
        String query, query1;
        
        String dbTabel = "users";
        Koneksi koneksi = new Koneksi();
        
        btnDaftar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!getUsername().equals("") & !getPassword().equals("") ){
                    try {
                        
                        String query1 = "SELECT * FROM " + dbTabel + " where username = '" + getUsername()+ "'";
                        ResultSet rs = koneksi.statement.executeQuery(query1);
                       
                        if(!rs.next())
                        {
                            String query = "insert into " + dbTabel + " values (NULL, '" + getUsername() +
                                "', '" + getPassword() + "')";
                            koneksi.statement = koneksi.konek.createStatement();
                            koneksi.statement.executeUpdate(query);
                            JOptionPane.showMessageDialog(null, "Berhasil mendaftarkan User");
                        }                                             
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Username Sudah Terpakai");
                        }
                                          
                    } catch (Exception exception){
                        JOptionPane.showMessageDialog(null, "Insert Data Gagal!");
                    } 
                }else{
                    JOptionPane.showMessageDialog(null, "Username & Password Wajib Diisi!");
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
