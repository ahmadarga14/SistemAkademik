/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;
import java.awt.HeadlessException;
import java.util.Properties;
import java.sql.Connection;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author ACER ASPIRE 5
 */
public class Database {
    static Properties mypanel;
    static String driver, database, user, pass;
    static Connection conn;
    
    public static Connection KoneksiDB(){
        if(conn == null){
            try{
                mypanel = new Properties();
                mypanel.load(new FileInputStream("lib/database.ini"));
                driver = mypanel.getProperty("DBDriver");
                database = mypanel.getProperty("DBDatabase");
                user = mypanel.getProperty("DBUsername");
                pass = mypanel.getProperty("DBPassword");   
                
                Class.forName(driver).newInstance();
                conn = DriverManager.getConnection(database,user,pass);
                JOptionPane.showMessageDialog(null,"Koneksi Berhasil","Pesan",JOptionPane.INFORMATION_MESSAGE); 
         }catch(IOException | ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException | HeadlessException ex){
                JOptionPane.showMessageDialog(null,"KONEKSI TIDAK BERHASIL", "PESAN", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Error : "+ex.getMessage());
                }
    }
    return conn;
}
}

