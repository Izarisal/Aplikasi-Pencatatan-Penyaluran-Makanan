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
