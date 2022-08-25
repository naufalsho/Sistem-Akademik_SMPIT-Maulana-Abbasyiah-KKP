/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
/**
 *
 * @author Naufal Sholahuddin
 */
public class Nilai extends javax.swing.JPanel {

    /**
     * Creates new form Nilai
     */
    
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    private String kdMapelTengahSm; 
    private String kdMapelAkhirSm;
    
    protected void kosongTengahSm(){
        CbRelasiNis1.setSelectedIndex(0);
        tNamaSiswa1.setText("");
        tKelas1.setText("");
        CbRelasiMapel1.setSelectedIndex(0);
        CbSemester1.setSelectedIndex(0);
        tTahun1.setText("");
        tTahunT1.setText("");
        tNilai1.setText("");
    }
    protected void kosongAkhirSm(){
        CbRelasiNis2.setSelectedIndex(0);
        tNamaSiswa2.setText("");
        tKelas2.setText("");
        CbRelasiMapel2.setSelectedIndex(0);
        CbSemester2.setSelectedIndex(0);
        tTahun2.setText("");
        tTahunT2.setText("");
        tNilaiPengetahuan2.setText("");
        tNilaiKeterampilan2.setText("");
    }

    protected void datatableTengahSm(){
        Object[] Baris = {
            "NIS",
            "Nama Siswa",
            "Kelas",
            "kode Mapel",
            "Mata Pelajaran",
            "Semester",
            "Tahun Ajar",
            "Nilai"
        };
        
        tabmode = new DefaultTableModel(null, Baris);
        tableNilai1.setModel(tabmode);

        String sql = "SELECT * FROM nilai_tengah_semester ORDER by nis, kd_mapel, semester";
        
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("nis");
                String b = hasil.getString("nama_siswa");
                String c = hasil.getString("kelas");
                String d = hasil.getString("kd_mapel");
                String e = hasil.getString("mapel");
                String f = hasil.getString("semester");
                String g = hasil.getString("tahun_ajar");
                String h = hasil.getString("nilai");
                
                String[] data={a, b, c, d, e, f, g, h};
                tabmode.addRow(data);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    protected void datatableAkhirSm(){
        Object[] Baris = {
            "NIS",
            "Nama Siswa",
            "Kelas",
            "kode Mapel",
            "Mata Pelajaran",
            "Semester",
            "Tahun Ajar",
            "Nilai Pengetahuan",
            "Nilai Keterampilan"
        };
        
        tabmode = new DefaultTableModel(null, Baris);
        tableNilai2.setModel(tabmode);

        String sql = "SELECT * FROM nilai_akhir_semester ORDER BY nis, kd_mapel, semester";
        
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("nis");
                String b = hasil.getString("nama_siswa");
                String c = hasil.getString("kelas");
                String d = hasil.getString("kd_mapel");
                String e = hasil.getString("mapel");
                String f = hasil.getString("semester");
                String g = hasil.getString("tahun_ajar");
                String h = hasil.getString("nilai_pengetahuan");
                String i = hasil.getString("nilai_keterampilan");
                
                String[] data={a, b, c, d, e, f, g, h, i};
                tabmode.addRow(data);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
   
    protected void getRelasiNisTengahSm(){
     
        String sql = "SELECT DISTINCT siswa.nis FROM siswa left join nilai_tengah_semester On siswa.nis = nilai_tengah_semester.nis;";
        
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("siswa.nis");
                
                String[] data={a};
                CbRelasiNis1.addItem(a);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
     protected void getRelasiNisAkhirSm(){
     
        String sql = "SELECT DISTINCT siswa.nis FROM siswa left join nilai_akhir_semester On siswa.nis = nilai_akhir_semester.nis;";
        
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("siswa.nis");
                
                String[] data={a};
                CbRelasiNis2.addItem(a);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
     
    protected void getRelasiKdMapelTengahSm(){
     
        String sql = "SELECT DISTINCT pelajaran.mapel, pelajaran.kd_mapel FROM pelajaran left join nilai_tengah_semester On pelajaran.kd_mapel = nilai_tengah_semester.kd_mapel";
        
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("pelajaran.mapel");
                
                String[] data={a};
                CbRelasiMapel1.addItem(a);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    protected void getRelasiKdMapelAkhirSm(){
     
        String sql = "SELECT DISTINCT pelajaran.mapel, pelajaran.kd_mapel FROM pelajaran left join nilai_akhir_semester On pelajaran.kd_mapel = nilai_akhir_semester.kd_mapel";
        
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("pelajaran.mapel");
                
                String[] data={a};
                CbRelasiMapel2.addItem(a);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
   

    
    public Nilai() {
        initComponents();
        datatableTengahSm();
        datatableAkhirSm();
        getRelasiNisTengahSm();
        getRelasiNisAkhirSm();
        getRelasiKdMapelTengahSm();
        getRelasiKdMapelAkhirSm();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        JTabNilai = new javax.swing.JTabbedPane();
        PanelUTS = new javax.swing.JPanel();
        Judul2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        nis1 = new javax.swing.JLabel();
        mataPelajaran1 = new javax.swing.JLabel();
        CbRelasiNis1 = new javax.swing.JComboBox<>();
        CbRelasiMapel1 = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        judul3 = new javax.swing.JLabel();
        nilai1 = new javax.swing.JLabel();
        tNilai1 = new javax.swing.JTextField();
        semester1 = new javax.swing.JLabel();
        CbSemester1 = new javax.swing.JComboBox<>();
        tahunAjar1 = new javax.swing.JLabel();
        tTahun1 = new javax.swing.JTextField();
        tSlash1 = new javax.swing.JTextField();
        tTahunT1 = new javax.swing.JTextField();
        bClear1 = new javax.swing.JButton();
        bSimpan1 = new javax.swing.JButton();
        bHapus1 = new javax.swing.JButton();
        bEdit1 = new javax.swing.JButton();
        namaSiswa1 = new javax.swing.JLabel();
        tNamaSiswa1 = new javax.swing.JTextField();
        kelas1 = new javax.swing.JLabel();
        tKelas1 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableNilai1 = new javax.swing.JTable();
        bCari1 = new javax.swing.JButton();
        tCari1 = new javax.swing.JTextField();
        PanelUAS = new javax.swing.JPanel();
        Judul1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        nis2 = new javax.swing.JLabel();
        mataPelajaran2 = new javax.swing.JLabel();
        CbRelasiNis2 = new javax.swing.JComboBox<>();
        CbRelasiMapel2 = new javax.swing.JComboBox<>();
        bClear2 = new javax.swing.JButton();
        bSimpan2 = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        bEdit2 = new javax.swing.JButton();
        namaSiswa2 = new javax.swing.JLabel();
        tNamaSiswa2 = new javax.swing.JTextField();
        kelas2 = new javax.swing.JLabel();
        tKelas2 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        judul4 = new javax.swing.JLabel();
        nilaiPengetahuan2 = new javax.swing.JLabel();
        nilaiKeterampilan2 = new javax.swing.JLabel();
        tNilaiPengetahuan2 = new javax.swing.JTextField();
        tNilaiKeterampilan2 = new javax.swing.JTextField();
        semester2 = new javax.swing.JLabel();
        CbSemester2 = new javax.swing.JComboBox<>();
        tahunAjar2 = new javax.swing.JLabel();
        tTahun2 = new javax.swing.JTextField();
        tSlash2 = new javax.swing.JTextField();
        tTahunT2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableNilai2 = new javax.swing.JTable();
        bCari2 = new javax.swing.JButton();
        tCari2 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 153, 204));

        JTabNilai.setName("UTS"); // NOI18N

        Judul2.setBackground(new java.awt.Color(255, 255, 255));
        Judul2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Judul2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Judul2.setText("FORM PENILAIAN TENGAH SEMESTER");
        Judul2.setOpaque(true);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        nis1.setText("Nama Siswa (input NIS)");

        mataPelajaran1.setText("Mata Pelajaran");

        CbRelasiNis1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih NIS Siswa -" }));
        CbRelasiNis1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbRelasiNis1ItemStateChanged(evt);
            }
        });

        CbRelasiMapel1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Mata Pelajaran -" }));
        CbRelasiMapel1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbRelasiMapel1ItemStateChanged(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(0, 102, 153));

        judul3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        judul3.setText("Nilai Siswa");
        judul3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        nilai1.setText("Nilai");

        semester1.setText("Semsester");

        CbSemester1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GANJIL", "GENAP", " " }));

        tahunAjar1.setText("Tahun Ajar");

        tSlash1.setText("/");
        tSlash1.setAutoscrolls(false);
        tSlash1.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(judul3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nilai1)
                            .addComponent(semester1)
                            .addComponent(tahunAjar1))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CbSemester1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tNilai1)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(tTahun1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tSlash1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tTahunT1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judul3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(semester1)
                    .addComponent(CbSemester1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tahunAjar1)
                    .addComponent(tTahun1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tSlash1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tTahunT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tNilai1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nilai1))
                .addGap(14, 14, 14))
        );

        bClear1.setText("Clear");
        bClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClear1ActionPerformed(evt);
            }
        });

        bSimpan1.setText("Simpan");
        bSimpan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSimpan1ActionPerformed(evt);
            }
        });

        bHapus1.setText("Hapus");
        bHapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapus1ActionPerformed(evt);
            }
        });

        bEdit1.setText("Edit");
        bEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEdit1ActionPerformed(evt);
            }
        });

        namaSiswa1.setText("Nama Siswa");

        tNamaSiswa1.setEnabled(false);

        kelas1.setText("Kelas");

        tKelas1.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(nis1)
                                .addGap(32, 32, 32)
                                .addComponent(CbRelasiNis1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(namaSiswa1)
                                    .addComponent(kelas1)
                                    .addComponent(mataPelajaran1))
                                .addGap(72, 72, 72)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tKelas1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CbRelasiMapel1, javax.swing.GroupLayout.Alignment.LEADING, 0, 206, Short.MAX_VALUE)
                                    .addComponent(tNamaSiswa1)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(bSimpan1)
                        .addGap(79, 79, 79)
                        .addComponent(bClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(bHapus1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(bEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nis1)
                            .addComponent(CbRelasiNis1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tNamaSiswa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namaSiswa1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kelas1)
                            .addComponent(tKelas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CbRelasiMapel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mataPelajaran1)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSimpan1)
                    .addComponent(bClear1)
                    .addComponent(bHapus1)
                    .addComponent(bEdit1))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tableNilai1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NIS", "Nama Siswa", "Kelas", "Kode Mata Pelajaran", "Mata Pelajaran", "Semester", "Tahun Ajar", "Nilai"
            }
        ));
        tableNilai1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableNilai1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableNilai1);

        bCari1.setText("Cari");
        bCari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCari1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(bCari1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(tCari1)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCari1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCari1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelUTSLayout = new javax.swing.GroupLayout(PanelUTS);
        PanelUTS.setLayout(PanelUTSLayout);
        PanelUTSLayout.setHorizontalGroup(
            PanelUTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUTSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelUTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Judul2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelUTSLayout.setVerticalGroup(
            PanelUTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUTSLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Judul2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JTabNilai.addTab("UTS(Penilaian Tengah Semsester)", PanelUTS);

        Judul1.setBackground(new java.awt.Color(255, 255, 255));
        Judul1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Judul1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Judul1.setText("FORM PENILAIAN AKHIR SEMESTER");
        Judul1.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        nis2.setText("Nama Siswa (input NIS)");

        mataPelajaran2.setText("Mata Pelajaran");

        CbRelasiNis2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih NIS Siswa -" }));
        CbRelasiNis2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbRelasiNis2ItemStateChanged(evt);
            }
        });

        CbRelasiMapel2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Mata Pelajaran -" }));
        CbRelasiMapel2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbRelasiMapel2ItemStateChanged(evt);
            }
        });

        bClear2.setText("Clear");
        bClear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClear2ActionPerformed(evt);
            }
        });

        bSimpan2.setText("Simpan");
        bSimpan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSimpan2ActionPerformed(evt);
            }
        });

        bHapus.setText("Hapus");
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        bEdit2.setText("Edit");
        bEdit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEdit2ActionPerformed(evt);
            }
        });

        namaSiswa2.setText("Nama Siswa");

        tNamaSiswa2.setEnabled(false);

        kelas2.setText("Kelas");

        tKelas2.setEnabled(false);

        jPanel7.setBackground(new java.awt.Color(0, 102, 153));

        judul4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        judul4.setText("Nilai Siswa");
        judul4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        nilaiPengetahuan2.setText("Nilai Pengetahuan");

        nilaiKeterampilan2.setText("Nilai Keterampilan");

        semester2.setText("Semsester");

        CbSemester2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GANJIL", "GENAP" }));

        tahunAjar2.setText("Tahun Ajar");

        tSlash2.setText("/");
        tSlash2.setAutoscrolls(false);
        tSlash2.setEnabled(false);
        tSlash2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSlash2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(judul4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nilaiPengetahuan2)
                            .addComponent(nilaiKeterampilan2)
                            .addComponent(semester2)
                            .addComponent(tahunAjar2))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CbSemester2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(tTahun2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tSlash2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tTahunT2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tNilaiKeterampilan2)
                            .addComponent(tNilaiPengetahuan2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judul4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(semester2)
                    .addComponent(CbSemester2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tahunAjar2)
                    .addComponent(tTahun2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tSlash2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tTahunT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nilaiPengetahuan2)
                    .addComponent(tNilaiPengetahuan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nilaiKeterampilan2)
                    .addComponent(tNilaiKeterampilan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(bSimpan2)
                .addGap(68, 68, 68)
                .addComponent(bClear2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(bEdit2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namaSiswa2)
                            .addComponent(kelas2)
                            .addComponent(mataPelajaran2))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tNamaSiswa2)
                            .addComponent(tKelas2)
                            .addComponent(CbRelasiMapel2, 0, 202, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(nis2)
                        .addGap(32, 32, 32)
                        .addComponent(CbRelasiNis2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nis2)
                            .addComponent(CbRelasiNis2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tNamaSiswa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namaSiswa2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kelas2)
                            .addComponent(tKelas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CbRelasiMapel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mataPelajaran2)))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSimpan2)
                    .addComponent(bClear2)
                    .addComponent(bHapus)
                    .addComponent(bEdit2))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tableNilai2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NIS", "Nama Siswa", "Kelas", "Kode Mata Pelajaran", "Mata Pelajaran", "Semester", "Tahun Ajar", "Nilai Pengetahuan", "Nilai Keterampilan"
            }
        ));
        tableNilai2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableNilai2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableNilai2);

        bCari2.setText("Cari");
        bCari2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCari2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(bCari2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(tCari2)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCari2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCari2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelUASLayout = new javax.swing.GroupLayout(PanelUAS);
        PanelUAS.setLayout(PanelUASLayout);
        PanelUASLayout.setHorizontalGroup(
            PanelUASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUASLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelUASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Judul1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelUASLayout.setVerticalGroup(
            PanelUASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUASLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Judul1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JTabNilai.addTab("UAS(Penilaian Akhir Semester)", PanelUAS);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTabNilai)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(JTabNilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        JTabNilai.getAccessibleContext().setAccessibleName("UTS");
    }// </editor-fold>//GEN-END:initComponents

    private void bSimpan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpan2ActionPerformed
        // TODO add your handling code here:
        String sql = "INSERT INTO nilai_akhir_semester VALUES (?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setString(1, CbRelasiNis2.getSelectedItem().toString());
            stat.setString(2, tNamaSiswa2.getText());
            stat.setString(3, tKelas2.getText());
            stat.setString(4, kdMapelAkhirSm);
            stat.setString(5, CbRelasiMapel2.getSelectedItem().toString());
            stat.setString(6, CbSemester2.getSelectedItem().toString());
            stat.setString(7, tTahun2.getText()+tSlash2.getText()+tTahunT2.getText());
            stat.setString(8, tNilaiPengetahuan2.getText());
            stat.setString(9, tNilaiKeterampilan2.getText());
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "DATA Berhasil Disimpan");
            tNilaiPengetahuan2.setText("");
            tNilaiKeterampilan2.setText("");
            tNilaiPengetahuan2.requestFocus();
            datatableAkhirSm();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan "+e);
        }
        
    }//GEN-LAST:event_bSimpan2ActionPerformed

    private void bClear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClear2ActionPerformed
        // TODO add your handling code here:
        datatableAkhirSm();
        kosongAkhirSm();
    }//GEN-LAST:event_bClear2ActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog",JOptionPane.YES_NO_CANCEL_OPTION);
        if(ok == 0){
            String sql = "DELETE FROM nilai_akhir_semester WHERE nis='"+CbRelasiNis2.getSelectedItem()+"' AND mapel='"+CbRelasiMapel2.getSelectedItem()+"'";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);

                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil diUbah ");
                kosongAkhirSm();
                tNilaiPengetahuan2.requestFocus();
                datatableAkhirSm();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Data Gagal DiUbah " + e);
            }
        }
    }//GEN-LAST:event_bHapusActionPerformed

    private void bEdit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEdit2ActionPerformed
        // TODO add your handling code here:

        try{
            String sql = "UPDATE nilai_akhir_semester set nama_siswa=?, kelas=?, kd_mapel=?, mapel=?, semester=?, tahun_ajar=?, nilai_pengetahuan=?, nilai_keterampilan=? WHERE nis=? AND mapel='"+CbRelasiMapel2.getSelectedItem().toString()+"'";
            PreparedStatement stat = conn.prepareStatement(sql);
            
            stat.setString(1, tNamaSiswa2.getText());
            stat.setString(2, tKelas2.getText());
            stat.setString(3, kdMapelAkhirSm);
            stat.setString(4, CbRelasiMapel2.getSelectedItem().toString());
            stat.setString(5, CbSemester2.getSelectedItem().toString());
            stat.setString(6, tTahun2.getText()+tSlash2.getText()+tTahunT2.getText());
            stat.setString(7, tNilaiPengetahuan2.getText());
            stat.setString(8, tNilaiKeterampilan2.getText());
            stat.setString(9, CbRelasiNis2.getSelectedItem().toString());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil diUbah ");
            kosongAkhirSm();
            tNilaiPengetahuan2.requestFocus();
            datatableAkhirSm();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Data Gagal DiUbah " + e);
        }
    }//GEN-LAST:event_bEdit2ActionPerformed

    private void tableNilai2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableNilai2MouseClicked
        // TODO add your handling code here:
        int bar = tableNilai2.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        //d itu untuk kd_mapel pada table, tidak perlu dipanggil, karena tidak ada fieldnya
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
        String h = tabmode.getValueAt(bar, 7).toString();
        String i = tabmode.getValueAt(bar, 8).toString();
        
        
        CbRelasiNis2.setSelectedItem(a);
        tNamaSiswa2.setText(b);
        tKelas2.setText(c);
        CbRelasiMapel2.setSelectedItem(e);
        CbSemester2.setSelectedItem(f);
        tTahun2.setText(g.substring(0,4));
        tTahunT2.setText(g.substring(g.length()-4));
        tNilaiPengetahuan2.setText(h);
        tNilaiKeterampilan2.setText(i);
    }//GEN-LAST:event_tableNilai2MouseClicked

    private void CbRelasiNis2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbRelasiNis2ItemStateChanged
        // TODO add your handling code here:
        String sql = "SELECT DISTINCT siswa.nama, siswa.kelas FROM siswa left join nilai_akhir_semester On siswa.nis = nilai_akhir_semester.nis WHERE siswa.nis='"+CbRelasiNis2.getSelectedItem().toString()+"';";
        
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("siswa.nama");
                String b = hasil.getString("siswa.kelas");
                
                String[] data={a, b};
                tNamaSiswa2.setText(a);
                tKelas2.setText(b);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_CbRelasiNis2ItemStateChanged

    private void CbRelasiMapel2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbRelasiMapel2ItemStateChanged
        // TODO add your handling code here:
        String sql = "SELECT DISTINCT pelajaran.kd_mapel FROM pelajaran left join nilai_akhir_semester On pelajaran.mapel = nilai_akhir_semester.mapel WHERE pelajaran.mapel='"+CbRelasiMapel2.getSelectedItem().toString()+"';";
        
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                kdMapelAkhirSm = hasil.getString("pelajaran.kd_mapel");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_CbRelasiMapel2ItemStateChanged

    private void bCari2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCari2ActionPerformed
        // TODO add your handling code here:
        Object[] Baris = {"NIS","Nama Siswa","Kelas","Kode Mapel","Mata pelajaran","Semester","Tahun Ajar","Nilai Pengetahuan","Nilai Keterampilan"};
        tabmode = new DefaultTableModel(null, Baris);
        tableNilai2.setModel(tabmode);

        String sql = "SELECT * FROM nilai_akhir_semester WHERE nama LIKE '%"+bCari2.getText()+"%'";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("nis");
                String b = hasil.getString("nama_siswa");
                String c = hasil.getString("kelas");
                String d = hasil.getString("kd_mapel");
                String e = hasil.getString("mapel");
                String f = hasil.getString("semester");
                String g = hasil.getString("tahun_ajar");
                String h = hasil.getString("nilai_pengetahuan");
                String i = hasil.getString("nilai_keterampilan");

                String[] data={a, b, c, d, e, f, g, h, i};
                tabmode.addRow(data);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        kosongAkhirSm();
    }//GEN-LAST:event_bCari2ActionPerformed

    private void CbRelasiNis1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbRelasiNis1ItemStateChanged
        // TODO add your handling code here:
        String sql = "SELECT DISTINCT siswa.nama, siswa.kelas FROM siswa left join nilai_tengah_semester On siswa.nis = nilai_tengah_semester.nis WHERE siswa.nis='"+CbRelasiNis1.getSelectedItem().toString()+"';";
        
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("siswa.nama");
                String b = hasil.getString("siswa.kelas");
                
                String[] data={a, b};
                tNamaSiswa1.setText(a);
                tKelas1.setText(b);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_CbRelasiNis1ItemStateChanged

    private void CbRelasiMapel1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbRelasiMapel1ItemStateChanged
    // TODO add your handling code here:
        String sql = "SELECT DISTINCT pelajaran.kd_mapel FROM pelajaran left join nilai_tengah_semester On pelajaran.mapel = nilai_tengah_semester.mapel WHERE pelajaran.mapel='"+CbRelasiMapel1.getSelectedItem().toString()+"';";
        
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                kdMapelTengahSm = hasil.getString("pelajaran.kd_mapel");
                
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_CbRelasiMapel1ItemStateChanged

    private void bClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClear1ActionPerformed
        // TODO add your handling code here:
        datatableTengahSm();
        kosongTengahSm();
    }//GEN-LAST:event_bClear1ActionPerformed

    private void bSimpan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpan1ActionPerformed
        // TODO add your handling code here:
        String sql = "INSERT INTO nilai_tengah_semester VALUES (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setString(1, CbRelasiNis1.getSelectedItem().toString());
            stat.setString(2, tNamaSiswa1.getText());
            stat.setString(3, tKelas1.getText());
            stat.setString(4, kdMapelTengahSm);
            stat.setString(5, CbRelasiMapel1.getSelectedItem().toString());
            stat.setString(6, CbSemester1.getSelectedItem().toString());
            stat.setString(7, tTahun1.getText()+tSlash1.getText()+tTahunT1.getText());
            stat.setString(8, tNilai1.getText());
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "DATA Berhasil Disimpan");
            tNilai1.setText("");
            tNilai1.requestFocus();
            datatableTengahSm();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan "+e);
        }
    }//GEN-LAST:event_bSimpan1ActionPerformed

    private void bHapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapus1ActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog",JOptionPane.YES_NO_CANCEL_OPTION);
        if(ok == 0){
            String sql = "DELETE FROM nilai_tengah_semester WHERE nis='"+CbRelasiNis1.getSelectedItem()+"' AND mapel='"+CbRelasiMapel1.getSelectedItem()+"'";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);

                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil diUbah ");
                kosongTengahSm();
                tNilai1.requestFocus();
                datatableTengahSm();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Data Gagal DiUbah " + e);
            }
        }
    }//GEN-LAST:event_bHapus1ActionPerformed

    private void bEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEdit1ActionPerformed
        // TODO add your handling code here:
         try{
            String sql = "UPDATE nilai_tengah_semester set nama_siswa=?, kelas=?, kd_mapel=?, mapel=?, semester=?, tahun_ajar=?, nilai=? WHERE nis=? AND mapel='"+CbRelasiMapel1.getSelectedItem().toString()+"'";
            PreparedStatement stat = conn.prepareStatement(sql);
            
            stat.setString(1, tNamaSiswa1.getText());
            stat.setString(2, tKelas1.getText());
            stat.setString(3, kdMapelTengahSm);
            stat.setString(4, CbRelasiMapel1.getSelectedItem().toString());
            stat.setString(5, CbSemester1.getSelectedItem().toString());
            stat.setString(6, tTahun1.getText()+tSlash1.getText()+tTahunT1.getText());
            stat.setString(7, tNilai1.getText());
            stat.setString(8, CbRelasiNis1.getSelectedItem().toString());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil diUbah ");
            kosongTengahSm();
            tNilai1.requestFocus();
            datatableTengahSm();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Data Gagal DiUbah " + e);
        }
    }//GEN-LAST:event_bEdit1ActionPerformed

    private void tableNilai1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableNilai1MouseClicked
        // TODO add your handling code here:
        int bar = tableNilai1.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        //d itu untuk kd_mapel pada table, tidak perlu dipanggil, karena tidak ada fieldnya
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
        String h = tabmode.getValueAt(bar, 7).toString();
        
        CbRelasiNis1.setSelectedItem(a);
        tNamaSiswa1.setText(b);
        tKelas1.setText(c);
        CbRelasiMapel1.setSelectedItem(e);
        CbSemester1.setSelectedItem(f);
        tTahun1.setText(g.substring(0,4));
        tTahunT1.setText(g.substring(g.length()-4));
        tNilai1.setText(h);
    }//GEN-LAST:event_tableNilai1MouseClicked

    private void bCari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCari1ActionPerformed
        // TODO add your handling code here:
        Object[] Baris = {"NIS","Nama Siswa","Kelas","Kode Mapel","Mata pelajaran","Semester","tahun_ajar","Nilai"};
        tabmode = new DefaultTableModel(null, Baris);
        tableNilai1.setModel(tabmode);

        String sql = "SELECT * FROM nilai_tengah_semester WHERE nama LIKE '%"+bCari1.getText()+"%'";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("nis");
                String b = hasil.getString("nama_siswa");
                String c = hasil.getString("kelas");
                String d = hasil.getString("kd_mapel");
                String e = hasil.getString("mapel");
                String f = hasil.getString("semester");
                String g = hasil.getString("tahun_ajar");
                String h = hasil.getString("nilai");

                String[] data={a, b, c, d, e, f, g, h};
                tabmode.addRow(data);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        kosongTengahSm();
    }//GEN-LAST:event_bCari1ActionPerformed

    private void tSlash2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSlash2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tSlash2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbRelasiMapel1;
    private javax.swing.JComboBox<String> CbRelasiMapel2;
    private javax.swing.JComboBox<String> CbRelasiNis1;
    private javax.swing.JComboBox<String> CbRelasiNis2;
    private javax.swing.JComboBox<String> CbSemester1;
    private javax.swing.JComboBox<String> CbSemester2;
    private javax.swing.JTabbedPane JTabNilai;
    private javax.swing.JLabel Judul1;
    private javax.swing.JLabel Judul2;
    private javax.swing.JPanel PanelUAS;
    private javax.swing.JPanel PanelUTS;
    private javax.swing.JButton bCari1;
    private javax.swing.JButton bCari2;
    private javax.swing.JButton bClear1;
    private javax.swing.JButton bClear2;
    private javax.swing.JButton bEdit1;
    private javax.swing.JButton bEdit2;
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bHapus1;
    private javax.swing.JButton bSimpan1;
    private javax.swing.JButton bSimpan2;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel judul3;
    private javax.swing.JLabel judul4;
    private javax.swing.JLabel kelas1;
    private javax.swing.JLabel kelas2;
    private javax.swing.JLabel mataPelajaran1;
    private javax.swing.JLabel mataPelajaran2;
    private javax.swing.JLabel namaSiswa1;
    private javax.swing.JLabel namaSiswa2;
    private javax.swing.JLabel nilai1;
    private javax.swing.JLabel nilaiKeterampilan2;
    private javax.swing.JLabel nilaiPengetahuan2;
    private javax.swing.JLabel nis1;
    private javax.swing.JLabel nis2;
    private javax.swing.JLabel semester1;
    private javax.swing.JLabel semester2;
    private javax.swing.JTextField tCari1;
    private javax.swing.JTextField tCari2;
    private javax.swing.JTextField tKelas1;
    private javax.swing.JTextField tKelas2;
    private javax.swing.JTextField tNamaSiswa1;
    private javax.swing.JTextField tNamaSiswa2;
    private javax.swing.JTextField tNilai1;
    private javax.swing.JTextField tNilaiKeterampilan2;
    private javax.swing.JTextField tNilaiPengetahuan2;
    private javax.swing.JTextField tSlash1;
    private javax.swing.JTextField tSlash2;
    private javax.swing.JTextField tTahun1;
    private javax.swing.JTextField tTahun2;
    private javax.swing.JTextField tTahunT1;
    private javax.swing.JTextField tTahunT2;
    private javax.swing.JTable tableNilai1;
    private javax.swing.JTable tableNilai2;
    private javax.swing.JLabel tahunAjar1;
    private javax.swing.JLabel tahunAjar2;
    // End of variables declaration//GEN-END:variables
}
