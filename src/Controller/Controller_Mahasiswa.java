/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO_Interface;
import DAO.DAO_Mahasiswa;
import Model.varMahasiswa;
import View.frmMahasiswa;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ACER ASPIRE 5
 */
public class Controller_Mahasiswa {
    frmMahasiswa form;
    DAO_Interface<varMahasiswa>model;
    List<varMahasiswa>list;
    String[] header;
    
    
    public Controller_Mahasiswa(frmMahasiswa form){
        this.form=form;
        model= new DAO_Mahasiswa();
        list=model.getALL();
        header = new String[]{"NIM","Nama","Alamat"};   
        form.getTblMahasiswa().setShowGrid(true);
        form.getTblMahasiswa().setShowVerticalLines(true);
        form.getTblMahasiswa().setGridColor(Color.red);
    }
    
    public void reset(){
        form.getTxtNIM().setText("");
        form.getTxtNama().setText("");
        form.getTxtAlamat().setText("");
        form.getTxtNIM().requestFocus();
        isiTabel();

    }
    public void isiTabel(){
        list=model.getALL();
        DefaultTableModel tblModel=new DefaultTableModel(new Object[][]{},header){
        public boolean isCellEditable(int rowIndex,int columnIndex){
            return false;
        }
    };
    Object[] data=new Object[header.length];
    for (varMahasiswa objMahasiswa:list){
        data[0]=objMahasiswa.getvNIM();
        data[1]=objMahasiswa.getvNama();
        data[2]=objMahasiswa.getvAlamat();
        tblModel.addRow(data);
    }
    form.getTblMahasiswa().setModel(tblModel);
    }
    public void isiField(int row){
        form.getTxtNIM().setText(list.get(row).getvNIM());
        form.getTxtNama().setText(list.get(row).getvNama());
        form.getTxtAlamat().setText(list.get(row).getvAlamat());
     
    }
    
    public void insert(){
        varMahasiswa objMahasiswa= new  varMahasiswa();
        
        objMahasiswa.setvNIM(form.getTxtNIM().getText());
        objMahasiswa.setvNama(form.getTxtNama().getText());
        objMahasiswa.setvAlamat(form.getTxtAlamat().getText());
        
        model.insert(objMahasiswa);
    }
    
    public void update(){
       varMahasiswa objMhs = new varMahasiswa();
       objMhs.setvNIM(form.getTxtNIM().getText());
       objMhs.setvNama(form.getTxtNama().getText());
       objMhs.setvAlamat(form.getTxtAlamat().getText());

    model.update(objMhs);     
        
    }
    
    public void delete(){
        if(!form.getTxtNIM().getText().trim().isEmpty()){
            String nim=form.getTxtNIM().getText();
            model.delete(nim);
        }
        
        else{
            JOptionPane.showMessageDialog(form, "Pilih data yang akan dihapus");
        }
        
    }
    public void isiTableCari(){
        list=model.getCari(form.getTxtNIM().getText().trim());
        DefaultTableModel tblModel=new DefaultTableModel(new Object[][]{},header);
        Object[] data=new Object[header.length];
        for(varMahasiswa objMahasiswa:list){
            data[0]=objMahasiswa.getvNIM();
            data[1]=objMahasiswa.getvNama();
            data[2]=objMahasiswa.getvAlamat();
            tblModel.addRow(data);
        
        }
        form.getTblMahasiswa().setModel(tblModel);
    
    }

    
}
