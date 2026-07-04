/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Connector;
import Model.MakananModel;
import View.Dashboard;
import View.FrmMakanan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class MakananController implements ActionListener, MouseListener, javax.swing.event.DocumentListener {

    private MakananModel data;
    private FrmMakanan frm;

    public MakananController(MakananModel data, FrmMakanan frm) {
        this.data = data;
        this.frm = frm;
        
        this.frm.btnSimpan.addActionListener(this);
        this.frm.btnUpdate.addActionListener(this);
        this.frm.btnDelete.addActionListener(this);
        this.frm.btnClear.addActionListener(this);
        this.frm.btnCetak.addActionListener(this);
        this.frm.btnDashboard.addActionListener(this);
        this.frm.tblMakanan.addMouseListener(this);
        
        loadComboDonatur();
        KosongFormMakanan();
        TampilDataMakanan();
        
        this.frm.txtFieldStok.getDocument().addDocumentListener(this);
    }
    
    private void cekStatusStok() {
        if (frm.txtFieldStok.getText().isEmpty()) {
            frm.txtFieldStatus.setText("");
            return;
        }

        try {
            int stok = Integer.parseInt(frm.txtFieldStok.getText());

            if (stok > 0) {
                frm.txtFieldStatus.setText("Tersedia");
            } else {
                frm.txtFieldStatus.setText("Habis");
            }
        } catch (NumberFormatException e) {
            frm.txtFieldStatus.setText("");
        }
    }
    
    private void loadComboDonatur() {
        try {
            Connection conn = Connector.configDB();
            String sql = "SELECT id_donatur, nama FROM donatur";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            frm.cmbDonatur.removeAllItems();
            while (rs.next()) {
                frm.cmbDonatur.addItem(
                        rs.getString("id_donatur")
                        + " - "
                        + rs.getString("nama")
                );
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void KosongFormMakanan() {
        frm.txtFieldId.setText(null);
        frm.cmbDonatur.setSelectedIndex(0);
        frm.txtFieldNama.setText(null);
        frm.txtFieldStok.setText(null);
        frm.txtFieldStatus.setText(null);
        frm.dateKadaluarsa.setDate(null);
    }

    public void TampilDataMakanan() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Id Makanan");
        model.addColumn("Id Donatur");
        model.addColumn("Nama");
        model.addColumn("Stok");
        model.addColumn("Status");
        model.addColumn("Tanggal Kadaluarsa");
        
        //Menampilkan data pada database ke dalam tabel
        try {
            int no = 1;
            String sql = "SELECT * FROM makanan";
            java.sql.Connection conn = (Connection) Connector.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                model.addRow(new Object[]{
                    no++,
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6)});
            }
            frm.tblMakanan.setModel(model);

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == frm.btnSimpan) {
            data.setIdMakanan(frm.txtFieldId.getText());
            String comboDonatur = frm.cmbDonatur.getSelectedItem().toString();
            String idDonaturSaja = comboDonatur.split(" - ")[0];
            data.setIdDonatur(idDonaturSaja);
            data.setNama(frm.txtFieldNama.getText());
            data.setStok(Integer.parseInt(frm.txtFieldStok.getText()));
            data.setStatus(frm.txtFieldStatus.getText());
            
            if (frm.dateKadaluarsa.getDate() != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String tanggal_penyaluran = sdf.format(frm.dateKadaluarsa.getDate());
                data.setTanggalKadaluarsa(tanggal_penyaluran);
            } else {
                data.setTanggalKadaluarsa(null);
            }

            try {
                if (data.SimpanMakanan(data)) {
                    JOptionPane.showMessageDialog(null, "Simpan Data Baru Berhasil");
                    KosongFormMakanan();
                    TampilDataMakanan();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if (ae.getSource() == frm.btnUpdate) {
            data.setIdMakanan(frm.txtFieldId.getText());
            String comboDonatur = frm.cmbDonatur.getSelectedItem().toString();
            String idDonaturSaja = comboDonatur.split(" - ")[0];
            data.setIdDonatur(idDonaturSaja);
            data.setNama(frm.txtFieldNama.getText());
            data.setStok(Integer.parseInt(frm.txtFieldStok.getText()));
            data.setStatus(frm.txtFieldStatus.getText());
            
            if (frm.dateKadaluarsa.getDate() != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String tanggal_penyaluran = sdf.format(frm.dateKadaluarsa.getDate());
                data.setTanggalKadaluarsa(tanggal_penyaluran);
            } else {
                data.setTanggalKadaluarsa(null);
            }


            try {
                if (data.UpdateMakanan(data)) {
                    JOptionPane.showMessageDialog(null, "Update Data Baru Berhasil");
                    KosongFormMakanan();
                    TampilDataMakanan();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if (ae.getSource() == frm.btnDelete) {
            data.setIdMakanan(frm.txtFieldId.getText());

            try {
                if (data.HapusMakanan(data)) {
                    JOptionPane.showMessageDialog(null, "Hapus Data Baru Berhasil");
                    KosongFormMakanan();
                    TampilDataMakanan();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if (ae.getSource() == frm.btnCetak) {
            try {
                java.sql.Connection MySQLConfig = (Connection) Connector.configDB();
                
                String reportPath = "src/Jasper/laporanMakanan.jasper";
                
                JasperPrint print = JasperFillManager.fillReport(reportPath, null, MySQLConfig);
                
                new JasperViewer(print, false).setVisible(true);
                
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "Gagal Mencetak Laporan: " + ex.getMessage());
                ex.printStackTrace();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Koneksi Database Gagal: " + ex.getMessage());
            }
        } else if (ae.getSource() == frm.btnClear) {
            KosongFormMakanan();
        } else if (ae.getSource() == frm.btnDashboard) {
            Dashboard db = new Dashboard();
            DashboardController ctrl = new DashboardController(db);
            db.setVisible(true);
            frm.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource()==frm.tblMakanan) {
            //frm.txtFieldId.setEditable(false);
            
            int baris=frm.tblMakanan.rowAtPoint(me.getPoint());
            String idMakanan = frm.tblMakanan.getValueAt(baris, 1).toString();
            frm.txtFieldId.setText(idMakanan);
            String idDonatur=frm.tblMakanan.getValueAt(baris, 2).toString();
            for (int i = 0; i < frm.cmbDonatur.getItemCount(); i++) {
                if (frm.cmbDonatur.getItemAt(i).startsWith(idDonatur)) {
                    frm.cmbDonatur.setSelectedIndex(i);
                    break;
                }
            }
            String nama=frm.tblMakanan.getValueAt(baris, 3).toString();
            frm.txtFieldNama.setText(nama);
            String stok=frm.tblMakanan.getValueAt(baris, 4).toString();
            frm.txtFieldStok.setText(stok);
            String status=frm.tblMakanan.getValueAt(baris, 5).toString();
            frm.txtFieldStatus.setText(status);
            try {
                String tglTabel = frm.tblMakanan.getValueAt(baris, 6).toString();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date tanggal = sdf.parse(tglTabel);
                frm.dateKadaluarsa.setDate(tanggal);
            } catch (ParseException ex) {
                Logger.getLogger(MakananController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //
    }

    public void insertUpdate(javax.swing.event.DocumentEvent e) {
        cekStatusStok();
    }

    @Override
    public void removeUpdate(javax.swing.event.DocumentEvent e) {
        cekStatusStok();
    }

    @Override
    public void changedUpdate(javax.swing.event.DocumentEvent e) {
        cekStatusStok();
    }
}
