/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Vincent Gunawan
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Koneksi.Database;
import Model.varMahasiswa;
import Model.varMatakuliah;
import Model.varPeriode;

public class DAO_Periode implements DAO_Interface<varPeriode> {
    Connection connection;

    public DAO_Periode() {
        connection = Database.KoneksiDB();
    }

    String INSERT = "INSERT INTO periode(ta, semester) VALUES(?, ?)";
    String UPDATE = "UPDATE periode SET semester=? WHERE ta=? and Semester=?";
    String DELETE = "DELETE FROM periode WHERE ta=? and Semester=?";
    String SELECT = "SELECT * FROM periode";
    String CARI = "SELECT * FROM periode WHERE ta=? and Semester=?";

    @Override
    public void insert(varPeriode Object) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(CARI);
            st.setString(1, Object.getvTA());
            st.setString(2, Object.getvSemester());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Data sudah pernah di simpan");
            } else {
                st = null;
                st = connection.prepareStatement(INSERT);
                st.setString(1, Object.getvTA());
                st.setString(2, Object.getvSemester());
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil di simpan");
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(varPeriode Object) {
        PreparedStatement st = null;
        try {
            st = null;
            st = connection.prepareStatement(UPDATE);
            st.setString(1, Object.getvSemester());
            st.setString(2, Object.getvTA());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil di ubah");
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String key) {
        PreparedStatement st = null;
        try {
            st = null;
            st = connection.prepareStatement(DELETE);
            st.setString(1, key);
            st.setString(2, key);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil di hapus");
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(String ta, String Semester) {
        PreparedStatement st = null;
        try {
            st = null;
            st = connection.prepareStatement(DELETE);
            st.setString(1, ta);
            st.setString(2, Semester);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil di hapus");
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<varPeriode> getALL() {
        List<varPeriode> list = null;
        PreparedStatement st = null;
        try {
            st = null;
            list = new ArrayList<varPeriode>();
            st = connection.prepareStatement(SELECT);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                varPeriode objMhs = new varPeriode();
                objMhs.setvTA(rs.getString("TA"));
                objMhs.setvSemester(rs.getString("Semester"));
                list.add(objMhs);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    @Override
    public List<varPeriode> getCari(String key) {
        List<varPeriode> list = null;
        PreparedStatement st = null;
        try {
            st = null;
            list = new ArrayList<varPeriode>();
            st = connection.prepareStatement(CARI);
            st.setString(1, key);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                varPeriode objMhs = new varPeriode();
                objMhs.setvTA(rs.getString("TA"));
                objMhs.setvSemester(rs.getString("Semester"));
                list.add(objMhs);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    
    public void Update(varMahasiswa objMahasiswa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<varMatakuliah> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}