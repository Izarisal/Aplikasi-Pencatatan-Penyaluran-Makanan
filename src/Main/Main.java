/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.DonaturController;
import Model.DonaturModel;
import View.FrmDonatur;

/**
 *
 * @author User
 */
public class Main {
    public static void main(String[] args) {
        DonaturModel data = new DonaturModel();
        FrmDonatur frm = new FrmDonatur();
        DonaturController ctrl = new DonaturController(data, frm);

        ctrl.KosongFormDonatur();
        ctrl.TampilDataDonatur();
        frm.setVisible(true);
    }
}
