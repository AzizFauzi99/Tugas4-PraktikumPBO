import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Koneksi {
    String dbUrl = "jdbc:mysql://localhost/tugasjdbc";
    String dbUsername = "root";
    String dbPassword = "";
    static final String driver = "com.mysql.cj.jdbc.Driver"; //newer version includes cj
    Connection konek;
    Statement statement; //untuk melakukan eksekusi query
    public Koneksi() {
        try{
            Class.forName(driver); 
            //membuka koneksi ke database
            konek = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
            statement = konek.createStatement();
            System.out.println("Koneksi Berhasil");
        } catch(Exception ex){
            System.out.println("Koneksi gagal");
        }
    }
}
