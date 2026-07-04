/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.DashboardController;
import Controller.DonaturController;
import View.Dashboard;

/**
 *
 * @author User
 */
public class Main {
    public static void main(String[] args) {
        Dashboard db = new Dashboard();
        DashboardController ctrl = new DashboardController(db);
        db.setVisible(true);
    }
}
