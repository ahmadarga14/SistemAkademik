/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Koneksi.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import Model.varKRSS;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.SQLDataException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.varMahasiswa;
import Model.varMatakuliah;

/**
 *
 * @author Ahmad Arga
 */

public class DAO_KRSS implements DAO_Interface<varKRSS>{
    Connection connection;
    public DAO_KRSS() {
        connection = Database.KoneksiDB();
    }
    // Deklarasi SQL statement
    public List<varKRSS> isicomboTA(){
        PreparedStatement statement;
        List<varKRSS> list = null;
        try {
            list = new ArrayList();
            statement = connection.prepareStatement("SELECT DISTINCT TA FROM PERIODE ORDER BY TA");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                varKRSS b = new varKRSS();
                b.setvTA(rs.getString("TA"));
                list.add(b);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<varKRSS> isicomboSMT(){
        PreparedStatement statement;
        List<varKRSS> list = null;
        try {
            list = new ArrayList();
            statement = connection.prepareStatement("SELECT DISTINCT Semester FROM periode ORDER BY Semester");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                varKRSS b = new varKRSS();
                b.setvSemester(rs.getString("Semester"));
                list.add(b);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<varKRSS> getNmMHS(String nim){
        PreparedStatement statement;
        List<varKRSS> list = null;
        try {
            list = new ArrayList();
            statement = connection.prepareStatement("SELECT * FROM Mahasiswa where NIM=?");
            statement.setString(1, nim);
            ResultSet rs = statement.executeQuery();
            if(!rs.next()){
                System.out.println("Data tidak ditemukan");
            }else{
                varKRSS b = new varKRSS();
                b.setvNama(rs.getString("nama"));
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<varKRSS> getDataMtk(String kdmtk){
        PreparedStatement statement;
        List<varKRSS> list = null;
        try {
            list = new ArrayList();
            statement = connection.prepareStatement("SELECT * FROM Matakuliah where KodeMTK=?");
            statement.setString(1, kdmtk);
            ResultSet rs = statement.executeQuery();
            if(!rs.next()){
                System.out.println("Data tidak ditemukan");
            }else{
                varKRSS b = new varKRSS();
                b.setvNamaMTK(rs.getString("NamaMTK"));
                b.setvSKS(rs.getInt("SKS"));
                b.setvKodePrasyarat(rs.getString("KodePrasyarat"));
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<varKRSS> getALLDetilKRSS(String ta, String semester, String nim){
        PreparedStatement st = null;
        List<varKRSS> list = null;
        try {
            list = new ArrayList<varKRSS>();
            st = null;
            String sql = "SELECT * FROM Detil_KRS a, Matakuliah b Where a.TA=? and a.Semester=? and a.NIM=? and a.KodeMTK=b.KodeMTK";
            st = connection.prepareStatement(sql);
            st.setString(1, ta);
            st.setString(2, semester);
            st.setString(3, nim);
            
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                varKRSS objKRSS = new varKRSS();
                objKRSS.setvKdMtk(rs.getString("KodeMTK"));
                objKRSS.setvNamaMTK(rs.getString("NamaMTK"));
                objKRSS.setvSKS(rs.getInt("SKS"));
                objKRSS.setvKodePrasyarat(rs.getString("KodePrasyarat"));
                list.add(objKRSS);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    @Override
    public void insert(varKRSS object) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = connection.prepareStatement("SELECT * FROM krs WHERE TA=? and Semester=? and NIM=?");
            st.setString(1, object.getvTA());
            st.setString(2, object.getvSemester());
            st.setString(3, object.getvNIM());
            rs = st.executeQuery();
            if (!rs.next()){
                st = null;
                st = connection.prepareStatement("INSERT INTO krs(TA, Semester, NIM, Tgl_KRS) VALUES(?,?,?,?)");
                st.setString(1, object.getvTA());
                st.setString(2, object.getvSemester());
                st.setString(3, object.getvNIM());
                st.setString(4, object.getvTglKRS().substring(0,10));
                System.out.println(""+st);
                st.executeUpdate();
            }
            
            st = null;
            st = connection.prepareStatement("SELECT * FROM detil_krs WHERE TA=? and Semester=? and NIM=? and KodeMTK=?");
            st.setString(1, object.getvTA());
            st.setString(2, object.getvSemester());
            st.setString(3, object.getvNIM());
            st.setString(4, object.getvKdMtk());
            rs = st.executeQuery();
            if (!rs.next()){
                st = null;
                st = connection.prepareStatement("INSERT INTO detil_krs(TA, Semester, NIM, KodeMTK) VALUES(?,?,?,?)");
                st.setString(1, object.getvTA());
                st.setString(2, object.getvSemester());
                st.setString(3, object.getvNIM());
                st.setString(4, object.getvKdMtk());
                st.executeUpdate();
            }
            
            rs.close();
            st.close();
        }
        catch(Exception e){
        e.printStackTrace();
        }
    }

    @Override
    public void update(varKRSS object) {
        
    }

    
    public void delete(String ta, String semester, String nim, String kdmtk) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = null;
            st = connection.prepareStatement("SELECT * FROM detil_krs WHERE TA=? and Semester=? adn NIM=? and KodeMTK");
            st.setString(1, ta);
            st.setString(2, semester);
            st.setString(3, nim);
            st.setString(4, kdmtk);
            st.executeQuery();
            if (rs.next()) {
                st = null;
                st = connection.prepareStatement("DELETE * FROM detil_krs WHERE TA=? and Semester=? adn NIM=? and KodeMTK");
                st.setString(1, ta);
                st.setString(2, semester);
                st.setString(3, nim);
                st.setString(4, kdmtk);
                st.executeUpdate();
            }else{
                st = null;
                st = connection.prepareStatement("DELETE * FROM krs WHERE TA=? and Semester=? adn NIM=?");
                st.setString(1, ta);
                st.setString(2, semester);
                st.setString(3, nim);
                st.executeUpdate();
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    @Override
    public List<varKRSS> getALL() {
        return null;
    }

    @Override
    public List<varKRSS> getCari(String key) {
        return null;
    }

    @Override
    public void delete(String nim) {
    }

    @Override
    public List<varMatakuliah> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}