/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Connector;
import Model.DonaturModel;
import Model.MakananModel;
import Model.PenyaluranModel;
import Model.PenerimaModel;
import View.Dashboard;
import View.FrmPenyaluran;
import View.Popup;
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
public class LaporanController implements ActionListener, MouseListener {

    private PenyaluranModel penyaluranData;
    private DonaturModel donaturData;
    private MakananModel makananData;
    private PenerimaModel penerimaData;
    private Popup frm;

    public LaporanController(PenyaluranModel penyaluranData, DonaturModel donaturData, MakananModel makananData, PenerimaModel penerimaData, Popup frm) {
        this.penyaluranData = penyaluranData;
        this.donaturData = donaturData;
        this.makananData = makananData;
        this.penerimaData = penerimaData;
        this.frm = frm;

        this.frm.btnCetak.addActionListener(this);
        this.frm.btnKembali.addActionListener(this);
        this.frm.tablePenyaluran.addMouseListener(this);
        TampilDataPenyaluran();
    }

    public void TampilDataPenyaluran() {
        String[] kolomPenyaluran = {"No", "Id Penyaluran", "Id Makanan", "Id Penerima", "Stok", "Tanggal Penyaluran"};
        DefaultTableModel model = new DefaultTableModel(kolomPenyaluran, 0);
        //Menampilkan data pada database ke dalam tabel
        try {
            int no = 1;
            String sql = "SELECT p.id_penyaluran, p.id_makanan, p.id_penerima, p.stok, p.tgl_penyaluran, m.nama, t.nama FROM penyaluran p, makanan m, penerima t "
                    + "WHERE p.id_makanan = m.id_makanan AND p.id_penerima = t.id_penerima";
            java.sql.Connection conn = (Connection) Connector.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                model.addRow(new Object[]{
                    no++,
                    res.getString(1),
                    res.getString(2) + " - " + res.getString(6),
                    res.getString(3) + " - " + res.getString(7),
                    res.getString(4),
                    res.getString(5)});
            }
            frm.tablePenyaluran.setModel(model);

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public void TampilDataDonatur(String idDonatur) {
        String[] kolomDonatur = {"No", "Id", "Nama", "Jenis", "Lokasi", "Email", "No HP"};
        DefaultTableModel model = new DefaultTableModel(kolomDonatur, 0);
        //Menampilkan data pada database ke dalam tabel
        try {
            int no = 1;
            String sql = "SELECT * FROM donatur where id_donatur = '" + idDonatur + "'";
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
            frm.tableDonatur.setModel(model);

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public void TampilDataMakanan(String idMakanan) {
        String[] kolomMakanan = {"No", "Id Makanan", "Id Donatur", "Nama", "Stok", "Status", "Tanggal Kadaluarsa"};
        DefaultTableModel model = new DefaultTableModel(kolomMakanan, 0);

        //Menampilkan data pada database ke dalam tabel
        try {
            int no = 1;
            String sql = "SELECT * FROM makanan WHERE id_makanan = '" + idMakanan + "'";
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
            frm.tableMakanan.setModel(model);

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public void TampilDataPenerima(String idPenerima) {
        String[] kolomPenerima = {"No", "Id", "Nama", "Jenis", "Lokasi", "Email", "No HP"};
        DefaultTableModel model = new DefaultTableModel(kolomPenerima, 0);
        //Menampilkan data pada database ke dalam tabel
        try {
            int no = 1;
            String sql = "SELECT * FROM penerima WHERE id_penerima = '" + idPenerima + "'";
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
            frm.tablePenerima.setModel(model);

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == frm.btnCetak) {
            try {
                java.sql.Connection MySQLConfig = (Connection) Connector.configDB();

                String reportPath = "src/Jasper/laporanPenyaluran.jasper";

                JasperPrint print = JasperFillManager.fillReport(reportPath, null, MySQLConfig);

                new JasperViewer(print, false).setVisible(true);

            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "Gagal Mencetak Laporan: " + ex.getMessage());
                ex.printStackTrace();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Koneksi Database Gagal: " + ex.getMessage());
            }
        } else if (ae.getSource() == frm.btnKembali) {
            frm.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == frm.tablePenyaluran) {

            int baris = frm.tablePenyaluran.getSelectedRow();

            String idMakanan = (frm.tablePenyaluran.getValueAt(baris, 2).toString()).substring(0,5);
            String idPenerima = (frm.tablePenyaluran.getValueAt(baris, 3).toString()).substring(0,5);
            String idDonatur = "";
            try {
                String sqlCariDonatur = "SELECT id_donatur FROM makanan WHERE id_makanan = '" + idMakanan + "'";
                java.sql.Connection conn = (Connection) Connector.configDB();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet resCari = stm.executeQuery(sqlCariDonatur);
                if (resCari.next()) {
                    idDonatur = resCari.getString("id_donatur");
                }
            } catch (SQLException e) {
                System.out.println("Gagal merelasikan ke donatur: " + e.getMessage());
            }
            TampilDataDonatur(idDonatur);
            TampilDataMakanan(idMakanan);
            TampilDataPenerima(idPenerima);
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
