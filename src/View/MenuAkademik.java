    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author ACER ASPIRE 5
 */
public class MenuAkademik extends javax.swing.JFrame {

    /**
     * Creates new form MenuAkademik
     */
    public MenuAkademik() {
        initComponents();
        setSize(1000,600);
        setLocationRelativeTo(this);
        Koneksi.Database.KoneksiDB();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuMahasiswa = new javax.swing.JMenuItem();
        mnuMatakuliah = new javax.swing.JMenuItem();
        mnuPeriode = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuKeluar = new javax.swing.JMenuItem();
        mnuTransaksi = new javax.swing.JMenu();
        mnuKRSS = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuDaftarMahasiswa = new javax.swing.JMenuItem();
        mnuDaftarMatakuliah = new javax.swing.JMenuItem();
        mnuCetakKRSS = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        jMenuItem4.setText("jMenuItem4");

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mnuFile.setText("File");
        mnuFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFileActionPerformed(evt);
            }
        });

        mnuMahasiswa.setText("Mahasiswa");
        mnuMahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMahasiswaActionPerformed(evt);
            }
        });
        mnuFile.add(mnuMahasiswa);

        mnuMatakuliah.setText("Matakuliah");
        mnuMatakuliah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMatakuliahActionPerformed(evt);
            }
        });
        mnuFile.add(mnuMatakuliah);

        mnuPeriode.setText("Periode");
        mnuPeriode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPeriodeActionPerformed(evt);
            }
        });
        mnuFile.add(mnuPeriode);
        mnuFile.add(jSeparator1);

        mnuKeluar.setText("Keluar");
        mnuKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuKeluarActionPerformed(evt);
            }
        });
        mnuFile.add(mnuKeluar);

        jMenuBar1.add(mnuFile);

        mnuTransaksi.setText("Transaksi");

        mnuKRSS.setText("KRSS");
        mnuKRSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuKRSSActionPerformed(evt);
            }
        });
        mnuTransaksi.add(mnuKRSS);

        jMenuBar1.add(mnuTransaksi);

        jMenu2.setText("Laporan");

        mnuDaftarMahasiswa.setText("Daftar Mahasiswa");
        mnuDaftarMahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDaftarMahasiswaActionPerformed(evt);
            }
        });
        jMenu2.add(mnuDaftarMahasiswa);

        mnuDaftarMatakuliah.setText("Daftar Matakuliah");
        jMenu2.add(mnuDaftarMatakuliah);

        mnuCetakKRSS.setText("Cetak KRSS");
        jMenu2.add(mnuCetakKRSS);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuMahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMahasiswaActionPerformed
        View.frmMahasiswa obMahasiswa=new View.frmMahasiswa();
        obMahasiswa.setLocationRelativeTo(this);
        obMahasiswa.setVisible(true);
    }//GEN-LAST:event_mnuMahasiswaActionPerformed

    private void mnuDaftarMahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDaftarMahasiswaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuDaftarMahasiswaActionPerformed

    private void mnuFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFileActionPerformed
        
    }//GEN-LAST:event_mnuFileActionPerformed

    private void mnuMatakuliahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMatakuliahActionPerformed
        View.FrmMatakuliah obMahasiswa=new View.FrmMatakuliah();
        obMahasiswa.setLocationRelativeTo(this);
        obMahasiswa.setVisible(true);
    }//GEN-LAST:event_mnuMatakuliahActionPerformed

    private void mnuPeriodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPeriodeActionPerformed
        View.FrmPeriode obMahasiswa=new View.FrmPeriode();
        obMahasiswa.setLocationRelativeTo(this);
        obMahasiswa.setVisible(true);
    }//GEN-LAST:event_mnuPeriodeActionPerformed

    private void mnuKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuKeluarActionPerformed
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        System.exit(0);
    }//GEN-LAST:event_mnuKeluarActionPerformed

    private void mnuKRSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuKRSSActionPerformed
        View.frmKRSS obMahasiswa=new View.frmKRSS();
        obMahasiswa.setLocationRelativeTo(this);
        obMahasiswa.setVisible(true);
    }//GEN-LAST:event_mnuKRSSActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuAkademik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAkademik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAkademik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAkademik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAkademik().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem mnuCetakKRSS;
    private javax.swing.JMenuItem mnuDaftarMahasiswa;
    private javax.swing.JMenuItem mnuDaftarMatakuliah;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuItem mnuKRSS;
    private javax.swing.JMenuItem mnuKeluar;
    private javax.swing.JMenuItem mnuMahasiswa;
    private javax.swing.JMenuItem mnuMatakuliah;
    private javax.swing.JMenuItem mnuPeriode;
    private javax.swing.JMenu mnuTransaksi;
    // End of variables declaration//GEN-END:variables
}