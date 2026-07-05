/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author User
 */
public class FrmPenyaluran extends javax.swing.JFrame {
    /**
     * Creates new form FrmDonatur
     */
    public FrmPenyaluran() {
        initComponents();
        styleFormPenyaluran();
    }
    
    private void styleFormPenyaluran() {
        Color warnaBG = new Color(245, 247, 250); // Abu-abu
        Color warnaNavIndigo = new Color(63, 114, 175);  // Biru Indigo
        Color warnaSimpanHijau = new Color(46, 117, 89);   // Hijau gelap
        Color warnaHapusMerah = new Color(186, 45, 50);   // Merah bata
        Color warnaTeksGelap = new Color(17, 45, 78);    // Navy gelap
        Color warnaTeksLabel = new Color(73, 80, 87);    // Abu-abu gelap

        this.getContentPane().setBackground(warnaBG);
        
        jPanel1.setBackground(warnaBG);
        jPanel2.setBackground(warnaBG);
        jPanel3.setBackground(warnaBG);
        
        jTabbedPane1.setBackground(warnaBG);
        jTabbedPane1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jTabbedPane1.setForeground(warnaTeksLabel);

        lblFrmPenyaluran.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblFrmPenyaluran.setForeground(warnaTeksGelap);
        
        lblFrmDonatur.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblFrmDonatur.setForeground(warnaTeksGelap);
        
        lblFrmPenyaluran3.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblFrmPenyaluran3.setForeground(warnaTeksGelap);
        
        lblDataPenyaluran.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblDataPenyaluran.setForeground(warnaTeksGelap);
        
        lblDataMakanan.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblDataMakanan.setForeground(warnaTeksGelap);
        
        lblMakananDisalurkan.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblMakananDisalurkan.setForeground(warnaTeksGelap);
        
        lblTanggalSebelum.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTanggalSebelum.setForeground(warnaTeksGelap);
        
        lblTanggalAntara.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTanggalAntara.setForeground(warnaTeksGelap);
        
        lblTanggalSetelah.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTanggalSetelah.setForeground(warnaTeksGelap);

        Font fontLabel = new Font("Segoe UI", Font.PLAIN, 14);
        lblNamaMakanan.setFont(fontLabel);
        lblNamaMakanan.setForeground(warnaTeksLabel);
        lblIdMakanan.setFont(fontLabel);
        lblIdMakanan.setForeground(warnaTeksLabel);
        lblIdPenerima.setFont(fontLabel);
        lblIdPenerima.setForeground(warnaTeksLabel);
        lblIdPenerima2.setFont(fontLabel);
        lblIdPenerima2.setForeground(warnaTeksLabel);
        lblTanggalPenyaluran.setFont(fontLabel);
        lblTanggalPenyaluran.setForeground(warnaTeksLabel);
        lblStok.setFont(fontLabel);
        lblStok.setForeground(warnaTeksLabel);
        lblStok2.setFont(fontLabel);
        lblStok2.setForeground(warnaTeksLabel);
        cbPenerimaPenyaluran.setFont(fontLabel);
        cbPenerimaPenyaluran.setForeground(warnaTeksLabel);
        lblIdPenyaluran.setFont(fontLabel);
        lblIdPenyaluran.setForeground(warnaTeksLabel);
        lblIdPenyaluran2.setFont(fontLabel);
        lblIdPenyaluran2.setForeground(warnaTeksLabel);

        Font fontInput = new Font("Segoe UI", Font.PLAIN, 14);
        txtFieldIdPenyaluranCRUD.setFont(fontInput);
        txtFieldIdPenyaluran.setFont(fontInput);
        cbMakanan.setFont(fontInput);
        cbPenerima.setFont(fontInput);
        txtFieldStokCRUD.setFont(fontInput);
        jDatePenyaluran.setFont(fontInput);
        cbPenerimaPenyaluran.setFont(fontInput);
        TanggalSebelum.setFont(fontInput);
        TanggalAntaraAwal.setFont(fontInput);
        TanggalAntaraAkhir.setFont(fontInput);
        TanggalSetelah.setFont(fontInput);

        Font fontTombol = new Font("Segoe UI", Font.BOLD, 13);

        btnSimpan.setFont(fontTombol);
        btnSimpan.setBackground(warnaSimpanHijau);
        btnSimpan.setForeground(Color.WHITE);
        btnSimpan.setFocusPainted(false);

        btnUpdate.setFont(fontTombol);
        btnUpdate.setBackground(warnaSimpanHijau);
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.setFocusPainted(false);

        btnDelete.setFont(fontTombol);
        btnDelete.setBackground(warnaHapusMerah);
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setFocusPainted(false);

        btnClear.setFont(fontTombol);
        btnClear.setBackground(warnaSimpanHijau);
        btnClear.setForeground(Color.WHITE);
        btnClear.setFocusPainted(false);

        btnCari.setFont(fontTombol);
        btnCari.setBackground(warnaNavIndigo);
        btnCari.setForeground(Color.WHITE);
        btnCari.setFocusPainted(false);

        btnDashboard.setFont(fontTombol);
        btnDashboard.setBackground(warnaNavIndigo);
        btnDashboard.setForeground(Color.WHITE);
        btnDashboard.setFocusPainted(false);
        
        btnTambah.setFont(fontTombol);
        btnTambah.setBackground(warnaNavIndigo);
        btnTambah.setForeground(Color.WHITE);
        btnTambah.setFocusPainted(false);
        
        btnDonasi.setFont(fontTombol);
        btnDonasi.setBackground(warnaSimpanHijau);
        btnDonasi.setForeground(Color.WHITE);
        btnDonasi.setFocusPainted(false);
        
        btnHapus.setFont(fontTombol);
        btnHapus.setBackground(warnaHapusMerah);
        btnHapus.setForeground(Color.WHITE);
        btnHapus.setFocusPainted(false);
        
        btnLaporan.setFont(fontTombol);
        btnLaporan.setBackground(warnaNavIndigo);
        btnLaporan.setForeground(Color.WHITE);
        btnLaporan.setFocusPainted(false);
        
        btnDashboard2.setFont(fontTombol);
        btnDashboard2.setBackground(warnaNavIndigo);
        btnDashboard2.setForeground(Color.WHITE);
        btnDashboard2.setFocusPainted(false);
        
        btnDashboard3.setFont(fontTombol);
        btnDashboard3.setBackground(warnaNavIndigo);
        btnDashboard3.setForeground(Color.WHITE);
        btnDashboard3.setFocusPainted(false);

        tablePenyaluran.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tablePenyaluran.setRowHeight(25);
        tablePenyaluran.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        
        tableProsesPenyaluran.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tableProsesPenyaluran.setRowHeight(25);
        tableProsesPenyaluran.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        
        tableMakanan.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tableMakanan.setRowHeight(25);
        tableMakanan.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDonatur = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePenyaluran = new javax.swing.JTable();
        lblTanggalPenyaluran = new javax.swing.JLabel();
        lblDataPenyaluran = new javax.swing.JLabel();
        btnDashboard2 = new javax.swing.JButton();
        lblFrmPenyaluran = new javax.swing.JLabel();
        lblIdPenyaluran2 = new javax.swing.JLabel();
        cbPenerima = new javax.swing.JComboBox<>();
        lblIdMakanan = new javax.swing.JLabel();
        lblIdPenerima = new javax.swing.JLabel();
        jDatePenyaluran = new com.toedter.calendar.JDateChooser();
        cbMakanan = new javax.swing.JComboBox<>();
        txtFieldIdPenyaluranCRUD = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblStok2 = new javax.swing.JLabel();
        txtFieldStokCRUD = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblFrmDonatur = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProsesPenyaluran = new javax.swing.JTable();
        btnHapus = new javax.swing.JButton();
        lblIdPenyaluran = new javax.swing.JLabel();
        txtFieldIdPenyaluran = new javax.swing.JTextField();
        btnDonasi = new javax.swing.JButton();
        lblNamaMakanan = new javax.swing.JLabel();
        txtFieldStok = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMakanan = new javax.swing.JTable();
        lblMakananDisalurkan = new javax.swing.JLabel();
        lblStok = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        txtFieldNamaMakanan = new javax.swing.JTextField();
        lblDataMakanan = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JButton();
        lblIdPenerima2 = new javax.swing.JLabel();
        cbPenerimaPenyaluran = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        lblTanggalSebelum = new javax.swing.JLabel();
        btnDashboard3 = new javax.swing.JButton();
        btnLaporan = new javax.swing.JButton();
        lblFrmPenyaluran3 = new javax.swing.JLabel();
        TanggalSebelum = new com.toedter.calendar.JDateChooser();
        TanggalAntaraAwal = new com.toedter.calendar.JDateChooser();
        lblTanggalAntara = new javax.swing.JLabel();
        TanggalSetelah = new com.toedter.calendar.JDateChooser();
        lblTanggalSetelah = new javax.swing.JLabel();
        TanggalAntaraAkhir = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 250));

        lblDonatur.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        tablePenyaluran.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tablePenyaluran.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePenyaluran.setFocusable(false);
        jScrollPane3.setViewportView(tablePenyaluran);

        lblTanggalPenyaluran.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblTanggalPenyaluran.setText("Tanggal Penyaluran");

        lblDataPenyaluran.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblDataPenyaluran.setText("Data Penyaluran");

        btnDashboard2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnDashboard2.setText("Dashboard");
        btnDashboard2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboard2ActionPerformed(evt);
            }
        });

        lblFrmPenyaluran.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblFrmPenyaluran.setText("Form Penyaluran");

        lblIdPenyaluran2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblIdPenyaluran2.setText("Id Penyaluran");

        cbPenerima.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbPenerima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPenerimaActionPerformed(evt);
            }
        });

        lblIdMakanan.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblIdMakanan.setText("Id Makanan");

        lblIdPenerima.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblIdPenerima.setText("Id Penerima");

        jDatePenyaluran.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        cbMakanan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbMakanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMakananActionPerformed(evt);
            }
        });

        txtFieldIdPenyaluranCRUD.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFieldIdPenyaluranCRUD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldIdPenyaluranCRUDActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnSimpan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblStok2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblStok2.setText("Stok");

        txtFieldStokCRUD.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFieldStokCRUD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldStokCRUDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblDataPenyaluran)
                        .addGap(330, 330, 330))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblTanggalPenyaluran)
                                    .addComponent(lblIdMakanan)
                                    .addComponent(lblIdPenerima)
                                    .addComponent(jDatePenyaluran, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                                    .addComponent(cbPenerima, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbMakanan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtFieldIdPenyaluranCRUD)
                                    .addComponent(lblStok2)
                                    .addComponent(txtFieldStokCRUD)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(btnSimpan)
                                        .addGap(26, 26, 26)
                                        .addComponent(btnUpdate)
                                        .addGap(26, 26, 26)
                                        .addComponent(btnDelete)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnDashboard2)))
                        .addContainerGap())))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(512, 512, 512)
                .addComponent(lblFrmPenyaluran)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblIdPenyaluran2)
                    .addContainerGap(1104, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblFrmPenyaluran)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDataPenyaluran)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtFieldIdPenyaluranCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblIdMakanan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMakanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblIdPenerima)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblStok2)
                        .addGap(2, 2, 2)
                        .addComponent(txtFieldStokCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lblTanggalPenyaluran)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDatePenyaluran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(btnDashboard2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(lblIdPenyaluran2)
                    .addContainerGap(434, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("CRUD", jPanel3);

        lblFrmDonatur.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblFrmDonatur.setText("Penyaluran Makanan");

        tableProsesPenyaluran.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tableProsesPenyaluran.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tableProsesPenyaluran);

        btnHapus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnHapus.setText("Hapus");

        lblIdPenyaluran.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblIdPenyaluran.setText("ID Penyaluran");

        txtFieldIdPenyaluran.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFieldIdPenyaluran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldIdPenyaluranActionPerformed(evt);
            }
        });

        btnDonasi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnDonasi.setText("Donasi");

        lblNamaMakanan.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblNamaMakanan.setText("Masukkan Nama Makanan");

        txtFieldStok.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFieldStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldStokActionPerformed(evt);
            }
        });

        btnCari.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        tableMakanan.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tableMakanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableMakanan);
        if (tableMakanan.getColumnModel().getColumnCount() > 0) {
            tableMakanan.getColumnModel().getColumn(1).setResizable(false);
            tableMakanan.getColumnModel().getColumn(2).setResizable(false);
            tableMakanan.getColumnModel().getColumn(3).setResizable(false);
        }

        lblMakananDisalurkan.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblMakananDisalurkan.setText("Makanan Yang Akan Disalurkan");

        lblStok.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblStok.setText("Jumlah Stok yang Ingin disalurkan");

        btnTambah.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnTambah.setText("Tambah");

        txtFieldNamaMakanan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFieldNamaMakanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldNamaMakananActionPerformed(evt);
            }
        });

        lblDataMakanan.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblDataMakanan.setText("Data Makanan");

        btnDashboard.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnDashboard.setText("Dashboard");
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });

        lblIdPenerima2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblIdPenerima2.setText("ID Penerima (Yang akan Disalurkan)");

        cbPenerimaPenyaluran.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbPenerimaPenyaluran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPenerimaPenyaluranActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDataMakanan)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtFieldStok, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtFieldNamaMakanan, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNamaMakanan)
                    .addComponent(lblStok)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtFieldIdPenyaluran, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblIdPenyaluran)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                        .addComponent(lblMakananDisalurkan)
                        .addGap(187, 187, 187))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblIdPenerima2)
                                .addGap(18, 18, 18)
                                .addComponent(cbPenerimaPenyaluran, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDonasi, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnDashboard)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 29, Short.MAX_VALUE))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(461, 461, 461)
                .addComponent(lblFrmDonatur)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblFrmDonatur, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamaMakanan)
                    .addComponent(lblMakananDisalurkan))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFieldNamaMakanan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(17, 17, 17)
                        .addComponent(lblDataMakanan)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFieldIdPenyaluran, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdPenyaluran))))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDonasi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStok)
                    .addComponent(lblIdPenerima2)
                    .addComponent(cbPenerimaPenyaluran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFieldStok, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Penyaluran", jPanel1);

        lblTanggalSebelum.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblTanggalSebelum.setText("Penyaluran Sebelum Tanggal");

        btnDashboard3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnDashboard3.setText("Dashboard");
        btnDashboard3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboard3ActionPerformed(evt);
            }
        });

        btnLaporan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnLaporan.setText("Cari");
        btnLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaporanActionPerformed(evt);
            }
        });

        lblFrmPenyaluran3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblFrmPenyaluran3.setText("Laporan Penyaluran");

        TanggalSebelum.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        TanggalAntaraAwal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblTanggalAntara.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblTanggalAntara.setText("Penyaluran Antara Tanggal");

        TanggalSetelah.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblTanggalSetelah.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblTanggalSetelah.setText("Penyaluran Setelah Tanggal");

        TanggalAntaraAkhir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(757, 757, 757)
                        .addComponent(btnDashboard3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TanggalAntaraAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblTanggalSebelum)
                                .addComponent(TanggalSebelum, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTanggalAntara)
                                .addComponent(TanggalAntaraAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTanggalSetelah)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TanggalSetelah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(349, 349, 349))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(483, 483, 483)
                .addComponent(lblFrmPenyaluran3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblFrmPenyaluran3)
                .addGap(27, 27, 27)
                .addComponent(lblTanggalSebelum)
                .addGap(18, 18, 18)
                .addComponent(TanggalSebelum, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTanggalAntara)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TanggalAntaraAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TanggalAntaraAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTanggalSetelah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TanggalSetelah, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDashboard3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Laporan", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDonatur))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(lblDonatur))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbPenerimaPenyaluranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPenerimaPenyaluranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPenerimaPenyaluranActionPerformed

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void txtFieldNamaMakananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldNamaMakananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldNamaMakananActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed

    }//GEN-LAST:event_btnCariActionPerformed

    private void txtFieldStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldStokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldStokActionPerformed

    private void txtFieldIdPenyaluranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldIdPenyaluranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldIdPenyaluranActionPerformed

    private void txtFieldStokCRUDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldStokCRUDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldStokCRUDActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtFieldIdPenyaluranCRUDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldIdPenyaluranCRUDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldIdPenyaluranCRUDActionPerformed

    private void cbMakananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMakananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMakananActionPerformed

    private void cbPenerimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPenerimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPenerimaActionPerformed

    private void btnDashboard2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboard2ActionPerformed
        
    }//GEN-LAST:event_btnDashboard2ActionPerformed

    private void btnDashboard3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboard3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDashboard3ActionPerformed

    private void btnLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaporanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLaporanActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPenyaluran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPenyaluran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPenyaluran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPenyaluran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPenyaluran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public com.toedter.calendar.JDateChooser TanggalAntaraAkhir;
    public com.toedter.calendar.JDateChooser TanggalAntaraAwal;
    public com.toedter.calendar.JDateChooser TanggalSebelum;
    public com.toedter.calendar.JDateChooser TanggalSetelah;
    public javax.swing.JButton btnCari;
    public javax.swing.JButton btnClear;
    public javax.swing.JButton btnDashboard;
    public javax.swing.JButton btnDashboard2;
    public javax.swing.JButton btnDashboard3;
    public javax.swing.JButton btnDelete;
    public javax.swing.JButton btnDonasi;
    public javax.swing.JButton btnHapus;
    public javax.swing.JButton btnLaporan;
    public javax.swing.JButton btnSimpan;
    public javax.swing.JButton btnTambah;
    public javax.swing.JButton btnUpdate;
    public javax.swing.JComboBox<String> cbMakanan;
    public javax.swing.JComboBox<String> cbPenerima;
    public javax.swing.JComboBox<String> cbPenerimaPenyaluran;
    public com.toedter.calendar.JDateChooser jDatePenyaluran;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDataMakanan;
    private javax.swing.JLabel lblDataPenyaluran;
    private javax.swing.JLabel lblDonatur;
    private javax.swing.JLabel lblFrmDonatur;
    private javax.swing.JLabel lblFrmPenyaluran;
    private javax.swing.JLabel lblFrmPenyaluran3;
    private javax.swing.JLabel lblIdMakanan;
    private javax.swing.JLabel lblIdPenerima;
    private javax.swing.JLabel lblIdPenerima2;
    private javax.swing.JLabel lblIdPenyaluran;
    private javax.swing.JLabel lblIdPenyaluran2;
    private javax.swing.JLabel lblMakananDisalurkan;
    private javax.swing.JLabel lblNamaMakanan;
    private javax.swing.JLabel lblStok;
    private javax.swing.JLabel lblStok2;
    private javax.swing.JLabel lblTanggalAntara;
    private javax.swing.JLabel lblTanggalPenyaluran;
    private javax.swing.JLabel lblTanggalSebelum;
    private javax.swing.JLabel lblTanggalSetelah;
    public javax.swing.JTable tableMakanan;
    public static javax.swing.JTable tablePenyaluran;
    public javax.swing.JTable tableProsesPenyaluran;
    public javax.swing.JTextField txtFieldIdPenyaluran;
    public javax.swing.JTextField txtFieldIdPenyaluranCRUD;
    public javax.swing.JTextField txtFieldNamaMakanan;
    public javax.swing.JTextField txtFieldStok;
    public javax.swing.JTextField txtFieldStokCRUD;
    // End of variables declaration//GEN-END:variables
}
