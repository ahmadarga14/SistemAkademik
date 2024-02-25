package Controller;

import java.awt.Color;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.DAO_Interface;
import DAO.DAO_Periode;
import Model.varPeriode;
import View.FrmPeriode;

public class Controller_Periode {
    FrmPeriode form;
    DAO_Interface<varPeriode> model;
    DAO_Periode model2;
    List<varPeriode> list;
    String[] header;

    public Controller_Periode(FrmPeriode form) {
        this.form = form;
        model = new DAO_Periode();
        model2 = new DAO_Periode();
        list = model.getALL();
        header = new String[] { "TA", "Semester" };
        form.getTblPeriode().setShowGrid(true);
        form.getTblPeriode().setShowVerticalLines(true);
        form.getTblPeriode().setGridColor(Color.blue);
    }

    public void reset() {
        form.getTxtTA().setText("");
        form.getTxtSemester().setText("");
        isiTabel();
    }

    public void isiTabel() {
        list = model.getALL();
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][] {}, header) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        Object[] data = new Object[header.length];
        for (varPeriode objMhs : list) {
            data[0] = objMhs.getvTA();
            data[1] = objMhs.getvSemester();
            tblModel.addRow(data);
        }
        form.getTblPeriode().setModel(tblModel);
    }

    public void isiField(int row) {
        form.getTxtTA().setText(list.get(row).getvTA());
        form.getTxtSemester().setText(list.get(row).getvSemester());
    }

    public void insert() {
        varPeriode objMhs = new varPeriode();

        objMhs.setvTA(form.getTxtTA().getText());
        objMhs.setvSemester(form.getTxtSemester().getText());
        model.insert(objMhs);
    }

    public void delete() {
        if (!form.getTxtTA().getText().trim().isEmpty()) {
            String ta = form.getTxtTA().getText();
            String Semester = form.getTxtSemester().getText();
            model2.delete(ta,Semester);
        } else {
            JOptionPane.showMessageDialog(form, "Pilih data yang akan dihapus");
        }
    }

    public void isiTabelCari() {
        list = model.getCari(form.getTxtTA().getText().trim());
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][] {}, header);
        Object[] data = new Object[header.length];
        for (varPeriode objMhs : list) {
            data[0] = objMhs.getvTA();
            data[1] = objMhs.getvSemester();
            tblModel.addRow(data);
        }
        form.getTblPeriode().setModel(tblModel);
    }

    public void update() {
       varPeriode objMhs = new varPeriode();

        objMhs.setvTA(form.getTxtTA().getText());
        objMhs.setvSemester(form.getTxtSemester().getText());
        model.update(objMhs);
}
}