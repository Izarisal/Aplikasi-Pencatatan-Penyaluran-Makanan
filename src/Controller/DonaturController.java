/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Connector;
import Model.DonaturModel;
import View.FrmDonatur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class DonaturController implements ActionListener, MouseListener {

    private DonaturModel data;
    private FrmDonatur frm;

    public DonaturController(DonaturModel data, FrmDonatur frm) {
        this.data = data;
        this.frm = frm;
        
        this.frm.btnSimpan.addActionListener(this);
        this.frm.btnUpdate.addActionListener(this);
        this.frm.btnDelete.addActionListener(this);
        this.frm.btnClear.addActionListener(this);
        this.frm.tableDonatur.addMouseListener(this);
    }

    public void KosongFormDonatur() {
        frm.txtFieldId.setText(null);
        frm.txtFieldNama.setText(null);
        frm.txtFieldLokasi.setText(null);
        frm.txtFieldEmail.setText(null);
        frm.txtFieldNoHP.setText(null);
    }

    public void TampilDataDonatur() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Id");
        model.addColumn("Nama");
        model.addColumn("Jenis");
        model.addColumn("Lokasi");
        model.addColumn("Email");
        model.addColumn("No HP");
        //Menampilkan data pada database ke dalam tabel
        try {
            int no = 1;
            String sql = "SELECT * FROM donatur";
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
            FrmDonatur.tableDonatur.setModel(model);

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == frm.btnSimpan) {
            data.setId(frm.txtFieldId.getText());
            data.setNama(frm.txtFieldNama.getText());
            String jenis = "" + frm.cbJenis.getSelectedItem();
            data.setJenis(jenis);
            data.setLokasi(frm.txtFieldLokasi.getText());
            data.setEmail(frm.txtFieldEmail.getText());
            data.setNo_hp(frm.txtFieldNoHP.getText());

            try {
                if (data.SimpanDonatur(data)) {
                    JOptionPane.showMessageDialog(null, "Simpan Data Baru Berhasil");
                    KosongFormDonatur();
                    TampilDataDonatur();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if (ae.getSource() == frm.btnUpdate) {
            data.setId(frm.txtFieldId.getText());
            data.setNama(frm.txtFieldNama.getText());
            String jenis = "" + frm.cbJenis.getSelectedItem();
            data.setJenis(jenis);
            data.setLokasi(frm.txtFieldLokasi.getText());
            data.setEmail(frm.txtFieldEmail.getText());
            data.setNo_hp(frm.txtFieldNoHP.getText());

            try {
                if (data.UpdateDonatur(data)) {
                    JOptionPane.showMessageDialog(null, "Update Data Baru Berhasil");
                    KosongFormDonatur();
                    TampilDataDonatur();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if (ae.getSource() == frm.btnDelete) {
            data.setId(frm.txtFieldId.getText());

            try {
                if (data.HapusDonatur(data)) {
                    JOptionPane.showMessageDialog(null, "Hapus Data Baru Berhasil");
                    KosongFormDonatur();
                    TampilDataDonatur();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if (ae.getSource() == frm.btnCetak) {
            try {
                java.sql.Connection MySQLConfig = (Connection) Connector.configDB();
                
                String reportPath = "src/Jasper/laporanDonatur.jasper";
                
                JasperPrint print = JasperFillManager.fillReport(reportPath, null, MySQLConfig);
                
                new JasperViewer(print, false).setVisible(true);
                
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "Gagal Mencetak Laporan: " + ex.getMessage());
                ex.printStackTrace();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Koneksi Database Gagal: " + ex.getMessage());
            }
        } else if (ae.getSource() == frm.btnClear) {
            KosongFormDonatur();
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource()==frm.tableDonatur) {
            //frm.txtFieldId.setEditable(false);
            
            int baris=frm.tableDonatur.rowAtPoint(me.getPoint());
            String id=frm.tableDonatur.getValueAt(baris, 1).toString();
            frm.txtFieldId.setText(id);
            String nama=frm.tableDonatur.getValueAt(baris, 2).toString();
            frm.txtFieldNama.setText(nama);
            String jenis=frm.tableDonatur.getValueAt(baris, 3).toString();
            if (jenis.equalsIgnoreCase("katering")) { 
                frm.cbJenis.setSelectedIndex(0);
            } else if (jenis.equalsIgnoreCase("restoran")) { 
                frm.cbJenis.setSelectedIndex(1);
            } else if (jenis.equalsIgnoreCase("kafe")) { 
                frm.cbJenis.setSelectedIndex(2);
            } else {
                frm.cbJenis.setSelectedIndex(3);
            }
            String lokasi=frm.tableDonatur.getValueAt(baris, 4).toString();
            frm.txtFieldLokasi.setText(lokasi);
            String email=frm.tableDonatur.getValueAt(baris, 5).toString();
            frm.txtFieldEmail.setText(email);
            String nohp=frm.tableDonatur.getValueAt(baris, 6).toString();
            frm.txtFieldNoHP.setText(nohp);
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
}
