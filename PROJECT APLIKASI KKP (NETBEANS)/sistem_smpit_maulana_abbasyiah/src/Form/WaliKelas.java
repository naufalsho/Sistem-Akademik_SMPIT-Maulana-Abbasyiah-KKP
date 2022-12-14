/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;

/**
 *
 * @author Naufal Sholahuddin
 */
public class WaliKelas extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    
     protected void kosong(){
        CbRelasiNip.setSelectedIndex(0);
        tNamaGuru.setText("");
        tNoHp.setText("");
        CbKelas.setSelectedIndex(0);
    }
     
    protected void datatable(){
        Object[] Baris = {
            "NIP",
            "Nama Guru(Wali Kelas)",
            "No. Hp",
            "Rujukan Kelas"
        };
        
        tabmode = new DefaultTableModel(null, Baris);
        tableWaliKelas.setModel(tabmode);

        String sql = "SELECT * FROM wali_kelas";
        
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("nip");
                String b = hasil.getString("nama_guru");
                String c = hasil.getString("no_hp");
                String d = hasil.getString("kelas");
                
                String[] data={a, b, c, d};
                tabmode.addRow(data);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    protected void getRelasi(){
     
        String sql = "SELECT DISTINCT guru.nip FROM guru left join wali_kelas On guru.nip = wali_kelas.nip;";
        
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("guru.nip");
                
                String[] data={a};
                CbRelasiNip.addItem(a);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public WaliKelas() {
        initComponents();
        datatable();
        getRelasi();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        judul = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        kelas = new javax.swing.JLabel();
        bHapus = new javax.swing.JButton();
        bClear = new javax.swing.JButton();
        nip = new javax.swing.JLabel();
        bSimpan = new javax.swing.JToggleButton();
        bEdit = new javax.swing.JButton();
        CbRelasiNip = new javax.swing.JComboBox<>();
        namaGuru = new javax.swing.JLabel();
        noHp = new javax.swing.JLabel();
        tNamaGuru = new javax.swing.JTextField();
        tNoHp = new javax.swing.JTextField();
        CbKelas = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableWaliKelas = new javax.swing.JTable();
        tCari = new javax.swing.JTextField();
        bCari = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 204));

        judul.setBackground(new java.awt.Color(255, 255, 255));
        judul.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        judul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul.setText("FORM WALI KELAS");
        judul.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        kelas.setText("Rujukan Kelas");

        bHapus.setText("Hapus");
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        bClear.setText("Clear");
        bClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClearActionPerformed(evt);
            }
        });

        nip.setText("NIP");

        bSimpan.setText("Simpan");
        bSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSimpanActionPerformed(evt);
            }
        });

        bEdit.setText("Edit");
        bEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditActionPerformed(evt);
            }
        });

        CbRelasiNip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih NIP -" }));
        CbRelasiNip.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbRelasiNipItemStateChanged(evt);
            }
        });

        namaGuru.setText("Nama Guru(Wali Kelas)");

        noHp.setText("No. Hp");

        tNamaGuru.setEnabled(false);

        tNoHp.setEnabled(false);

        CbKelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7", "8", "9" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(nip)
                                .addGap(110, 110, 110)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CbKelas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CbRelasiNip, 0, 190, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(namaGuru)
                                    .addComponent(kelas)
                                    .addComponent(noHp))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tNoHp)
                                    .addComponent(tNamaGuru)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(bSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(bEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(bClear, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nip)
                    .addComponent(CbRelasiNip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaGuru)
                    .addComponent(tNamaGuru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noHp)
                    .addComponent(tNoHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kelas)
                    .addComponent(CbKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSimpan)
                    .addComponent(bHapus)
                    .addComponent(bEdit)
                    .addComponent(bClear))
                .addGap(23, 23, 23))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tableWaliKelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NIP", "Nama Guru(Wali Kelas)", "No. Hp", "Rujukan Kelas"
            }
        ));
        tableWaliKelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableWaliKelasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableWaliKelas);

        bCari.setText("Cari");
        bCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bCari, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(tCari)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCari))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(judul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableWaliKelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableWaliKelasMouseClicked
        // TODO add your handling code here:
         int bar = tableWaliKelas.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        
        CbRelasiNip.setSelectedItem(a);
        tNamaGuru.setText(b);
        tNoHp.setText(c);
        CbKelas.setSelectedItem(d);
    }//GEN-LAST:event_tableWaliKelasMouseClicked

    private void bEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "UPDATE wali_kelas set nama_guru=?, no_hp=?, kelas=? WHERE nip=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, tNamaGuru.getText());
            stat.setString(2, tNoHp.getText());
            stat.setString(3, CbKelas.getSelectedItem().toString());
            stat.setString(4, CbRelasiNip.getSelectedItem().toString());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil diUbah ");
            kosong();
            datatable();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Data Gagal DiUbah " + e);
        }
    }//GEN-LAST:event_bEditActionPerformed

    private void bSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpanActionPerformed
        // TODO add your handling code here:
        String sql = "INSERT INTO wali_kelas VALUES (?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setString(1, CbRelasiNip.getSelectedItem().toString());
            stat.setString(2, tNamaGuru.getText());
            stat.setString(3, tNoHp.getText());
            stat.setString(4, CbKelas.getSelectedItem().toString());
            

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "DATA Berhasil Disimpan");
            kosong();
            datatable();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan "+e);
        }
    }//GEN-LAST:event_bSimpanActionPerformed

    private void bClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClearActionPerformed
        // TODO add your handling code here:
        kosong();
        datatable();
    }//GEN-LAST:event_bClearActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog",JOptionPane.YES_NO_CANCEL_OPTION);
        if(ok == 0){
            String sql = "DELETE FROM wali_kelas WHERE nip='"+CbRelasiNip.getSelectedItem().toString()+"'";
            
            try{
                PreparedStatement stat = conn.prepareStatement(sql);  
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil diUbah ");
                kosong();
                datatable();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Data Gagal DiUbah " + e);
            }
        }
    }//GEN-LAST:event_bHapusActionPerformed

    private void bCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariActionPerformed
        // TODO add your handling code here:
        Object[] Baris = {"NIP","Nama Guru(Wali Kelas)","No. Hp","Rujukan Kelas"};
        tabmode = new DefaultTableModel(null, Baris);
        tableWaliKelas.setModel(tabmode);

        String sql = "SELECT * FROM wali_kelas WHERE nama_guru LIKE '%"+bCari.getText()+"%'";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("nip");
                String b = hasil.getString("nama_guru");
                String c = hasil.getString("no_hp");
                String d = hasil.getString("kelas");

                String[] data={a, b, c, d};
                tabmode.addRow(data);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        kosong();
    }//GEN-LAST:event_bCariActionPerformed

    private void CbRelasiNipItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbRelasiNipItemStateChanged
        // TODO add your handling code here:
        String sql = "SELECT DISTINCT guru.nama, guru.no_hp FROM guru left join wali_kelas On guru.nip = wali_kelas.nip WHERE guru.nip='"+CbRelasiNip.getSelectedItem().toString()+"';";
        
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("guru.nama");
                String b = hasil.getString("guru.no_hp");
                
                String[] data={a, b};
                tNamaGuru.setText(a);
                tNoHp.setText(b);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_CbRelasiNipItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbKelas;
    private javax.swing.JComboBox<String> CbRelasiNip;
    private javax.swing.JButton bCari;
    private javax.swing.JButton bClear;
    private javax.swing.JButton bEdit;
    private javax.swing.JButton bHapus;
    private javax.swing.JToggleButton bSimpan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel judul;
    private javax.swing.JLabel kelas;
    private javax.swing.JLabel namaGuru;
    private javax.swing.JLabel nip;
    private javax.swing.JLabel noHp;
    private javax.swing.JTextField tCari;
    private javax.swing.JTextField tNamaGuru;
    private javax.swing.JTextField tNoHp;
    private javax.swing.JTable tableWaliKelas;
    // End of variables declaration//GEN-END:variables
}
