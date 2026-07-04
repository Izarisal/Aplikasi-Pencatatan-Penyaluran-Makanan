/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Connector;
import View.FrmMakanan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class MakananController {

    private FrmMakanan view;

    public MakananController(FrmMakanan view) {
        this.view = view;
    }

    public void simpan() {
        if (view.getTxtFieldId().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID Makanan masih kosong");
            return;
        }
        if (view.getCmbDonatur().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Pilih donatur terlebih dahulu");
            return;
        }

        if (view.getTxtFieldNama().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nama masih kosong");
            return;
        }
        if (view.getTxtFieldStok().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Stok masih kosong");
            return;
        }
        if (view.getDateKadaluarsa().getDate() == null) {
            JOptionPane.showMessageDialog(null,
                    "Tanggal kadaluarsa belum dipilih");
            return;
        }
        String idMakanan = view.getTxtFieldId().getText();
        String idDonatur
                = view.getCmbDonatur()
                        .getSelectedItem()
                        .toString()
                        .split(" - ")[0];
        String nama = view.getTxtFieldNama().getText();
        int stok
                = Integer.parseInt(
                        view.getTxtFieldStok().getText()
                );
        String status
                = view.getTxtFieldStatus().getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String tanggalKadaluarsa
                = sdf.format(
                        view.getDateKadaluarsa().getDate()
                );
        try {
            Connection conn = Connector.configDB();
            String sql = "INSERT INTO makanan "
                    + "(id_makanan, id_donatur, nama, stok, status, tgl_kadaluarsa) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idMakanan);
            ps.setString(2, idDonatur);
            ps.setString(3, nama);
            ps.setInt(4, stok);
            ps.setString(5, status);
            ps.setString(6, tanggalKadaluarsa);

            ps.executeUpdate();
            tampilData();
            JOptionPane.showMessageDialog(null, "Data makanan berhasil disimpan.");
            view.clearForm();
            ps.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void tampilData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Makanan");
        model.addColumn("ID Donatur");
        model.addColumn("Nama");
        model.addColumn("Stok");
        model.addColumn("Status");
        model.addColumn("Kadaluarsa");
        try {
            Connection conn = Connector.configDB();
            String sql = "SELECT * FROM makanan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_makanan"),
                    rs.getString("id_donatur"),
                    rs.getString("nama"),
                    rs.getInt("stok"),
                    rs.getString("status"),
                    rs.getDate("tgl_kadaluarsa")
                });
            }
            view.getTableMakanan().setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void pilihData() {
        int baris = view.getTableMakanan().getSelectedRow();
        if (baris == -1) {
            return;
        }
        view.getTxtFieldId().setText(
                view.getTableMakanan().getValueAt(baris, 0).toString());
        String idDonatur
                = view.getTableMakanan().getValueAt(baris, 1).toString();
        for (int i = 0; i < view.getCmbDonatur().getItemCount(); i++) {
            if (view.getCmbDonatur()
                    .getItemAt(i)
                    .startsWith(idDonatur)) {
                view.getCmbDonatur()
                        .setSelectedIndex(i);
                break;
            }
        }
        view.getTxtFieldNama().setText(
                view.getTableMakanan().getValueAt(baris, 2).toString());
        view.getTxtFieldStok().setText(
                view.getTableMakanan().getValueAt(baris, 3).toString());
        view.getTxtFieldStatus().setText(
                view.getTableMakanan().getValueAt(baris, 4).toString());
    }
}
