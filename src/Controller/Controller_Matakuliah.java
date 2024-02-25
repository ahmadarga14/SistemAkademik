/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ACER ASPIRE 5
 */
package Controller;

import java.awt.Color;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.DAO_Interface;
import DAO.DAO_Matakuliah;
import Model.varMatakuliah;
import View.FrmMatakuliah;

public class Controller_Matakuliah {
    FrmMatakuliah form;
    DAO_Interface<varMatakuliah> model;
    List<varMatakuliah> list;
    String[] header;

    public Controller_Matakuliah(FrmMatakuliah form) {
        this.form = form;
        model = new DAO_Matakuliah();
        list = model.getAll();
        header = new String[] { "Kode Matakuliah", "Nama Matkul", "sks", "kodeprasyarat" };
        form.getTblMatkul().setShowGrid(true);
        form.getTblMatkul().setShowVerticalLines(true);
        form.getTblMatkul().setGridColor(Color.blue);
    }

    public void reset() {
        form.getTxtMatkul().setText("");
        form.getTxtNama().setText("");
        form.getTxtSKS().setText("");
        form.getTxtKode().setText("");
        form.getTxtMatkul().requestFocus();
        isiTabel();
    }

    public void isiTabel() {
        list = model.getAll();
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][] {}, header) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        Object[] data = new Object[header.length];
        for (varMatakuliah objMhs : list) {
            data[0] = objMhs.getvKodematkul();
            data[1] = objMhs.getvNama();
            data[2] = objMhs.getvSKS();
            data[3] = objMhs.getvKdpersyarat();
            tblModel.addRow(data);
        }
        form.getTblMatkul().setModel(tblModel);
    }

    public void isiField(int row) {
        form.getTxtMatkul().setText(list.get(row).getvKodematkul());
        form.getTxtNama().setText(list.get(row).getvNama());
        form.getTxtSKS().setText(list.get(row).getvSKS());
        form.getTxtKode().setText(list.get(row).getvKdpersyarat());
    }

    public void insert() {
        varMatakuliah objMhs = new varMatakuliah();

        objMhs.setvKodematkul(form.getTxtMatkul().getText());
        objMhs.setvNama(form.getTxtNama().getText());
        objMhs.setvSKS(form.getTxtSKS().getText());
        objMhs.setvKdpersyarat(form.getTxtKode().getText());

        model.insert(objMhs);
    }

    public void update() {
        varMatakuliah objMhs = new varMatakuliah();

        objMhs.setvKodematkul(form.getTxtMatkul().getText());
        objMhs.setvNama(form.getTxtNama().getText());
        objMhs.setvSKS(form.getTxtSKS().getText());
        objMhs.setvKdpersyarat(form.getTxtKode().getText());

        model.update(objMhs);
    }

    public void delete() {
        if (!form.getTxtMatkul().getText().trim().isEmpty()) {
            String key = form.getTxtMatkul().getText();

            model.delete(key);
        } else {
            JOptionPane.showMessageDialog(form, "Pilih data yang akan di hapus");
        }
    }

    public void isiTabelCari() {
        list = model.getCari(form.getTxtMatkul().getText().trim());
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][] {}, header);
        Object[] data = new Object[header.length];
        for (varMatakuliah objMhs : list) {
            data[0] = objMhs.getvKodematkul();
            data[1] = objMhs.getvNama();
            data[2] = objMhs.getvSKS();
            data[3] = objMhs.getvKdpersyarat();
            tblModel.addRow(data);
        }
        form.getTblMatkul().setModel(tblModel);
    }
}