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
            data.setJurusan(frm.cbJenis.getText());

            try {
                if (data.SimpanMahasiswa(data)) {
                    JOptionPane.showMessageDialog(null, "Simpan Data Baru Berhasil");
                    KosongFormDonatur();
                    TampilDataDonatur();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if (ae.getSource() == frm.btnEdit) {
            data.setId(frm.txtIdMhs.getText());
            data.setNama(frm.txtNamaMhs.getText());
            data.setJurusan(frm.txtJurMhs.getText());

            try {
                if (data.UpdateMahasiswa(data)) {
                    JOptionPane.showMessageDialog(null, "Update Data Baru Berhasil");
                    KosongFormMhs();
                    TampilDataMhs();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            data.setId(frm.txtIdMhs.getText());

            try {
                if (data.HapusMahasiswa(data)) {
                    JOptionPane.showMessageDialog(null, "Hapus Data Baru Berhasil");
                    KosongFormMhs();
                    TampilDataMhs();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
