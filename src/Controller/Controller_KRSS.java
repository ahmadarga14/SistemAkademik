/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import DAO.DAO_Interface;
import DAO.DAO_KRSS;
import Model.varKRSS;
import View.frmKRSS;
import java.util.List;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Ahmad Arga
 */
public class Controller_KRSS {
    frmKRSS form;
    DAO_Interface<varKRSS> model;
    DAO_KRSS model_internal;
    List<varKRSS> list;
    String[] header;
    
    public Controller_KRSS(frmKRSS form){
        this.form = form;
        model = new DAO_KRSS();
        model_internal = new DAO_KRSS();
        list = model.getALL();
        header = new String[]{"No.","KodeMTK", "NamaMTK", "SKS", "KodePrasyarat"};
        form.getTblKRS().setShowGrid(true);
        form.getTblKRS().setShowVerticalLines(true);
        form.getTblKRS().setGridColor(Color.blue);
    }
    
    public void isicomboTahunAjaran() {
        form.getCboTA().removeAllItems();
        form.getCboTA().addItem("-Pilih-");
        for (varKRSS b : model_internal.isicomboTA()) {
            form.getCboTA().addItem(b.getvTA());
        }
    }
    
    public void isicomboSemester() {
        form.getCboSemester().removeAllItems();
        form.getCboSemester().addItem("-Pilih-");
        for (varKRSS b : model_internal.isicomboSMT()) {
            form.getCboSemester().addItem(b.getvSemester());
        }
    }
    
    public void tampilNamaMahasiswa() {
        for (varKRSS b : model_internal.getNmMHS(form.getTxtNIM().getText())) {
            form.getTxtNama().setText(String.valueOf(b.getvNama()));
        }
    }
    
    public void tampilDataMatakuliah() {
        for (varKRSS b  : model_internal.getDataMtk(form.getTxtKdMtk().getText())) {
            form.getTxtNamaMtk().setText(String.valueOf(b.getvNamaMTK()));
            form.getTxtSKS().setText(String.valueOf(b.getvSKS()));
            form.getTxtKdPrasyarat().setText(String.valueOf(b.getvKodePrasyarat()));
        }
    }
    
    public void isiTabel(){
        String TA = ""+form.getCboTA().getSelectedItem();
        String Semester = ""+form.getCboSemester().getSelectedItem();
        String NIM = form.getTxtNIM().getText();
        list = model_internal.getALLDetilKRSS(TA, Semester, NIM);
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header) {
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        Object[] data = new Object[header.length];
        int i=1;
        for(varKRSS objKRSS : list){
            data[0] = ""+i;
            data[1] = objKRSS.getvKdMtk();
            data[2] = objKRSS.getvNamaMTK();
            data[3] = objKRSS.getvSKS();
            data[4] = objKRSS.getvKodePrasyarat();
            tblModel.addRow(data);
            i++;
    }
    form.getTblKRS().setModel(tblModel);
    int total=0, sks = 0 ;
    for(i = 0; i < tblModel.getRowCount(); i++){
        sks = Integer.parseInt(String.valueOf(tblModel.getValueAt(i,3).toString()));
        total = total + sks;
    }
    form.getTxtTotalSKS().setText(""+total);
    
    } 
    
    public void reset(){
        SimpleDateFormat tgl = new SimpleDateFormat("yyyy-MM-dd");
        form.getCboTA().setSelectedItem("Pilih");
        form.getCboSemester().setSelectedItem("Pilih");
        form.getTxtTglKRS().setText(String.valueOf(tgl.format(new Date())));
        form.getTxtNIM().setText("");
        form.getTxtNama().setText("");
        form.getTxtKdMtk().setText("");
        form.getTxtNamaMtk().setText("");
        form.getTxtSKS().setText("");
        form.getTxtKdPrasyarat().setText("");
        isicomboTahunAjaran();
        isicomboSemester();
        form.getTxtTglKRS().setEditable(false);
        form.getTxtNIM().setEditable(true);
        form.getTxtNIM().requestFocus();
        isiTabel();
    }
    
    public void resetDetil(){
        form.getTxtKdMtk().setText("");
        form.getTxtNamaMtk().setText("");
        form.getTxtSKS().setText("");
        form.getTxtKdPrasyarat().setText("");
        form.getTxtKdMtk().requestFocus();
        isiTabel();
    }
    
    public void isiField(int row){
        form.getTxtKdMtk().setText(list.get(row).getvKdMtk());
        form.getTxtNamaMtk().setText(list.get(row).getvNamaMTK());
        form.getTxtSKS().setText(""+list.get(row).getvSKS());
        form.getTxtKdPrasyarat().setText(list.get(row).getvKodePrasyarat());
    }
    
    public void insert() {
        varKRSS objKRSS = new varKRSS();
        
        objKRSS.setvTA(""+form.getCboTA().getSelectedItem());
        objKRSS.setvSemester(""+form.getCboSemester().getSelectedItem());
        objKRSS.setvNIM(form.getTxtNIM().getText());
        objKRSS.setvTglKRS(form.getTxtTglKRS().getText());
        objKRSS.setvKdMtk(form.getTxtKdMtk().getText());
        model.insert(objKRSS);
    }
    
    public void delete() {
        if(!form.getTxtNIM().getText().trim().isEmpty()){
            String TA = ""+form.getCboTA().getSelectedItem();
            String Semester = ""+form.getCboSemester().getSelectedItem();
            String NIM = form.getTxtNIM().getText();
            String KodeMTK = form.getTxtKdMtk().getText();
            model_internal.delete(TA, Semester, NIM, KodeMTK);
        }
        else{
            JOptionPane.showMessageDialog(form, "Pilih data yang akan dihapus");
        }
    }
}