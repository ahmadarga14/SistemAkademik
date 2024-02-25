/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.varMahasiswa;
import Koneksi.Database;
import Model.varMatakuliah;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author ACER ASPIRE 5
 */
public class DAO_Mahasiswa implements DAO_Interface<varMahasiswa>{
    Connection connection;
    public DAO_Mahasiswa(){
        connection=Database.KoneksiDB();
    }
    
    String INSERT="INSERT INTO mahasiswa (NIM,nama,alamat)VALUES(?,?,?)";    
    String UPDATE="UPDATE mahasiswa set nama=?,alamat=? WHERE NIM=?";
    String DELETE="DELETE from mahasiswa where NIM=?";
    String SELECT="SELECT*FROM mahasiswa";
    String CARI="SELECT * FROM MAHASISWA WHERE NIM=?";
    
    
    
    
    
    @Override
    public void insert(varMahasiswa object) {
        PreparedStatement st=null;
        try {st= connection.prepareStatement(CARI);
             st.setString(1,object.getvNIM());
             ResultSet rs=st.executeQuery();
             if(rs.next()){
                 JOptionPane.showMessageDialog(null,"Data pernah di simpan");
               }
        else{
             st=null;
             st=connection.prepareStatement(INSERT);
             st.setString(1,object.getvNIM());
             st.setString(2,object.getvNama());
             st.setString(3,object.getvAlamat());
             st.executeUpdate();
             JOptionPane.showMessageDialog(null,"Data berhasil di simpan");

            
            }
             st.close();
            
        } catch (Exception e) {
        }
        
        
    }

    @Override
    public void update(varMahasiswa object) {
        PreparedStatement st=null;
        try {
             st=null;
             st=connection.prepareStatement(UPDATE);
             st.setString(1,object.getvNama());
             st.setString(2,object.getvAlamat());
             st.setString(3,object.getvNIM());
             st.executeUpdate();
             JOptionPane.showMessageDialog(null,"Data berhasil di ubah");

             st.close(); 
            }
            
            
         catch (Exception e) {
             e.printStackTrace();
        }
    }

    @Override
    public void delete( String nim) {
        PreparedStatement st=null;
        try {
             st=null;
             st=connection.prepareStatement(DELETE);
             st.setString(1,nim); 
             st.executeUpdate();
             JOptionPane.showMessageDialog(null,"Data berhasil di hapus");
             st.close(); 
        

            }
            
            
         catch (Exception e) {
             e.printStackTrace();
        }
    }

    
    @Override
    public List<varMahasiswa> getALL() {
        List<varMahasiswa> list=null;
        PreparedStatement st=null;
        try {
            st=null;
            list= new ArrayList<varMahasiswa>();
            st=connection.prepareStatement(SELECT);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                varMahasiswa objMahasiswa = new varMahasiswa();
                objMahasiswa.setvNIM(rs.getNString("NIM"));
                objMahasiswa.setvNama(rs.getNString("Nama"));
                objMahasiswa.setvAlamat(rs.getNString("Alamat"));
                list.add(objMahasiswa);

                
                
            }
            st.close();
        } 
        
        catch (Exception e) {
        }
        
        
        
        return list;
        
    }

    @Override
    public List<varMahasiswa> getCari(String key) {
        List<varMahasiswa> list=null;
        PreparedStatement st=null;
        try {
            st=null;
            list= new ArrayList<varMahasiswa>();
            st=connection.prepareStatement(CARI);
            st.setString(1,"%"+key+"%");
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                varMahasiswa objMahasiswa = new varMahasiswa();
                objMahasiswa.setvNIM(rs.getNString("NIM"));
                objMahasiswa.setvNama(rs.getNString("Nama"));
                objMahasiswa.setvAlamat(rs.getNString("Alamat"));
                list.add(objMahasiswa);               
            }
            st.close();
        }
        catch (Exception e) {
        }
        return list;
    }

    @Override
    public List<varMatakuliah> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
        
        
        
       
    
