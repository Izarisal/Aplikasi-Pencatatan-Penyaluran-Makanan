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
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Id Penyaluran");
        model.addColumn("Id Makanan");
        model.addColumn("Id Penerima");
        model.addColumn("Stok");
        model.addColumn("Tanggal Penyaluran");

        //Menampilkan data pada database ke dalam tabel
        try {
            int no = 1;
            String sql = "SELECT * FROM penyaluran";
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
                    res.getString(5)});
            }
            frm.tablePenyaluran.setModel(model);

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public void TampilDataDonatur(String idDonatur) {
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
            FrmPenyaluran frmPenyaluran = new FrmPenyaluran();
            PenyaluranModel data = new PenyaluranModel();
            PenyaluranController ctrl = new PenyaluranController(data, frmPenyaluran);
            frmPenyaluran.setVisible(true);
            frm.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == frm.tablePenyaluran) {

            int baris = frm.tablePenyaluran.getSelectedRow();
            String idPenyaluran = frm.tablePenyaluran.getValueAt(baris, 1).toString();
            String idMakanan = frm.tablePenyaluran.getValueAt(baris, 2).toString();
            String idPenerima = frm.tablePenyaluran.getValueAt(baris, 3).toString();

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