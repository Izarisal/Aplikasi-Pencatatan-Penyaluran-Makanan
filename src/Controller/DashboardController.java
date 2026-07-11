/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DonaturModel;
import Model.MakananModel;
import Model.PenerimaModel;
import Model.PenyaluranModel;
import View.Dashboard;
import View.FrmDonatur;
import View.FrmMakanan;
import View.FrmPenerima;
import View.FrmPenyaluran;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class DashboardController implements ActionListener {

    private Dashboard frm;

    public DashboardController(Dashboard frm) {
        this.frm = frm;

        this.frm.btnDonatur.addActionListener(this);
        this.frm.btnPenerima.addActionListener(this);
        this.frm.btnMakanan.addActionListener(this);
        this.frm.btnPenyaluran.addActionListener(this);
        
        hitungDanTampilkanTotal();
    }

    private void hitungDanTampilkanTotal() {
        try {
            java.sql.Connection conn = (java.sql.Connection) Model.Connector.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res;

            int totalDonatur = 0;
            int totalMakanan = 0;
            int totalPenerima = 0;
            int totalPenyaluran = 0;

            res = stm.executeQuery("SELECT COUNT(*) AS total FROM donatur");
            if (res.next()) { totalDonatur = res.getInt("total"); }

            res = stm.executeQuery("SELECT COUNT(*) AS total FROM makanan");
            if (res.next()) { totalMakanan = res.getInt("total"); }

            res = stm.executeQuery("SELECT COUNT(*) AS total FROM penerima");
            if (res.next()) { totalPenerima = res.getInt("total"); }

            res = stm.executeQuery("SELECT COUNT(*) AS total FROM penyaluran");
            if (res.next()) { totalPenyaluran = res.getInt("total"); }

            res.close();
            stm.close();

            frm.updateTeksDashboard(
                String.valueOf(totalDonatur),
                String.valueOf(totalPenerima),
                String.valueOf(totalMakanan),
                String.valueOf(totalPenyaluran)
            );

        } catch (java.sql.SQLException e) {
            System.out.println("Gagal menghitung jumlah baris tabel: " + e.getMessage());
        }
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == frm.btnDonatur) {
            DonaturModel data = new DonaturModel();
            FrmDonatur frmDonatur = new FrmDonatur();
            DonaturController ctrl = new DonaturController(data, frmDonatur);
            ctrl.TampilDataDonatur();
            frmDonatur.setVisible(true);
            frm.dispose();
        } else if (ae.getSource() == frm.btnPenerima) {
            PenerimaModel data = new PenerimaModel();
            FrmPenerima frmPenerima = new FrmPenerima();
            PenerimaController ctrl = new PenerimaController(data, frmPenerima);
            ctrl.TampilDataPenerima();
            frmPenerima.setVisible(true);
            frm.dispose();
        } else if (ae.getSource() == frm.btnMakanan) {
            MakananModel data = new MakananModel();
            FrmMakanan frmMakanan = new FrmMakanan();
            MakananController ctrl = new MakananController(data, frmMakanan);
            ctrl.TampilDataMakanan();
            frmMakanan.setVisible(true);
            frm.dispose();
        } else if (ae.getSource() == frm.btnPenyaluran) {
            PenyaluranModel data = new PenyaluranModel();
            FrmPenyaluran frmPenyaluran = new FrmPenyaluran();
            PenyaluranController ctrl = new PenyaluranController(data, frmPenyaluran);
            ctrl.TampilDataPenyaluran();
            frmPenyaluran.setVisible(true);
            frm.dispose();
        }
    }

    
}
