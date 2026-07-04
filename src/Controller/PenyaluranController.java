/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Connector;
import Model.DonaturModel;
import Model.MakananModel;
import Model.PenerimaModel;
import Model.PenyaluranModel;
import View.Dashboard;
import View.FrmPenyaluran;
import View.Popup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class PenyaluranController implements ActionListener, MouseListener {

    private PenyaluranModel data;
    private FrmPenyaluran frm;
    private PreparedStatement pst;
    private ResultSet rst;

    private DefaultTableModel modelKeranjang;

    public PenyaluranController(PenyaluranModel data, FrmPenyaluran frm) {
        this.data = data;
        this.frm = frm;

        this.frm.btnSimpan.addActionListener(this);
        this.frm.btnUpdate.addActionListener(this);
        this.frm.btnDelete.addActionListener(this);
        this.frm.btnCari.addActionListener(this);
        this.frm.btnTambah.addActionListener(this);
        this.frm.btnHapus.addActionListener(this);
        this.frm.btnDonasi.addActionListener(this);
        this.frm.btnLaporan.addActionListener(this);
        this.frm.btnDashboard.addActionListener(this);
        this.frm.btnDashboard2.addActionListener(this);
        this.frm.btnDashboard3.addActionListener(this);

        this.frm.tablePenyaluran.addMouseListener(this);
        this.frm.tableMakanan.addMouseListener(this);
        this.frm.tableProsesPenyaluran.addMouseListener(this);
        
        TampilDataPenyaluran();
        cari();
        LoadComboMakanan();
        LoadComboPenerima();
        OtomatisIdPenyaluran();
        InisialisasiTabelKanan();
    }

    private void InisialisasiTabelKanan() {
        modelKeranjang = new DefaultTableModel();
        modelKeranjang.addColumn("No");
        modelKeranjang.addColumn("Id Makanan");
        modelKeranjang.addColumn("Nama Makanan");
        modelKeranjang.addColumn("Nama Donatur");
        modelKeranjang.addColumn("Stok");
        frm.tableProsesPenyaluran.setModel(modelKeranjang);
    }

    public final void LoadComboMakanan() {
        frm.cbMakanan.removeAllItems();
        try {
            String sql = "SELECT id_makanan FROM makanan";
            java.sql.Connection conn = (Connection) Connector.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                frm.cbMakanan.addItem(res.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("Gagal load combo makanan: " + e.getMessage());
        }
    }

    public final void LoadComboPenerima() {
        frm.cbPenerima.removeAllItems();
        frm.cbPenerimaPenyaluran.removeAllItems();
        try {

            String sql = "SELECT id_penerima FROM penerima";
            java.sql.Connection conn = (Connection) Connector.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                frm.cbPenerima.addItem(res.getString(1));
                frm.cbPenerimaPenyaluran.addItem(res.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("Gagal load combo penerima: " + e.getMessage());
        }
    }

    public void OtomatisIdPenyaluran() {
        try {
            String sql = "SELECT id_penyaluran FROM penyaluran ORDER BY id_penyaluran DESC LIMIT 1";
            java.sql.Connection conn = (Connection) Model.Connector.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            if (res.next()) {
                String idTerakhir = res.getString("id_penyaluran");
                int angka = Integer.parseInt(idTerakhir.substring(2));
                angka++;

                String idBaru = String.format("PL%04d", angka);
                frm.txtFieldIdPenyaluran.setText(idBaru);
            } else {
                frm.txtFieldIdPenyaluran.setText("PL0001");
            }

            frm.txtFieldIdPenyaluran.setEditable(false);
        } catch (Exception e) {
            System.out.println("Gagal membuat ID Otomatis: " + e.getMessage());
        }
    }

    public void cari() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Id Makanan");
        model.addColumn("Id Donatur");
        model.addColumn("Nama");
        model.addColumn("Stok");
        model.addColumn("Status");
        model.addColumn("Tanggal Kadaluarsa");

        String namaMakanan = frm.txtFieldNamaMakanan.getText();

        try {
            int no = 1;

            String sql = "SELECT * FROM makanan WHERE "
                    + "nama LIKE '%" + namaMakanan + "%'";

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

    private String getNamaDonaturByID(String id_donatur) {
        String nama_donatur = "";
        try {
            String sqlDonatur = "SELECT nama FROM donatur WHERE id_donatur = '" + id_donatur + "'";
            java.sql.Connection conn = (Connection) Connector.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet resDonatur = stm.executeQuery(sqlDonatur);
            if (resDonatur.next()) {
                nama_donatur = resDonatur.getString("nama");
            } else {
                nama_donatur = id_donatur;
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil nama donatur: " + e.getMessage());
            nama_donatur = id_donatur;
        }
        return nama_donatur;
    }

    private boolean isInputValid(int stokSekarang) {
        String stokDisalurkan = frm.txtFieldStok.getText();
        if (stokDisalurkan.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Masukkan jumlah stok yang ingin disalurkan!");
            return false;
        }

        try {
            int jumlahDisalurkan = Integer.parseInt(stokDisalurkan);
            if (jumlahDisalurkan > stokSekarang) {
                JOptionPane.showMessageDialog(null, "Stok Makanan Kurang!");
                return false;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Input jumlah disalurkan harus berupa angka!");
            return false;
        }

        return true;
    }

    private void tambahKeKeranjang(int baris, String id_makanan, String nama_makanan, String nama_donatur, int jumlahDisalurkan, int stokSekarang) {
        int no = modelKeranjang.getRowCount() + 1;
        modelKeranjang.addRow(new Object[]{
            no,
            id_makanan,
            nama_makanan,
            nama_donatur,
            jumlahDisalurkan
        });
        frm.tableMakanan.setValueAt(stokSekarang - jumlahDisalurkan, baris, 4);
        frm.txtFieldStok.setText("");
    }

    public void KosongFormPenyaluran() {
        frm.txtFieldIdPenyaluranCRUD.setText(null);
        frm.cbMakanan.setSelectedItem(null);
        frm.cbPenerima.setSelectedItem(null);
        frm.jDatePenyaluran.setDate(null);
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
            frm.tableMakanan.setModel(model);

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == frm.btnSimpan) {
            data.setId_penyaluran(frm.txtFieldIdPenyaluranCRUD.getText());
            String id_makanan = "" + frm.cbMakanan.getSelectedItem();
            data.setId_makanan(id_makanan);
            String id_penerima = "" + frm.cbPenerima.getSelectedItem();
            data.setId_penerima(id_penerima);

            data.setStok(frm.txtFieldStokCRUD.getText());

            if (frm.jDatePenyaluran.getDate() != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String tanggal_penyaluran = sdf.format(frm.jDatePenyaluran.getDate());
                data.setTgl_penyaluran(tanggal_penyaluran);
            } else {
                data.setTgl_penyaluran(null);
            }

            try {
                if (data.SimpanDonatur(data)) {
                    JOptionPane.showMessageDialog(null, "Simpan Data Baru Berhasil");
                    KosongFormPenyaluran();
                    TampilDataPenyaluran();
                    OtomatisIdPenyaluran();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if (ae.getSource() == frm.btnUpdate) {
            data.setId_penyaluran(frm.txtFieldIdPenyaluranCRUD.getText());
            String id_makanan = "" + frm.cbMakanan.getSelectedItem();
            data.setId_makanan(id_makanan);
            String id_penerima = "" + frm.cbPenerima.getSelectedItem();
            data.setId_penerima(id_penerima);
            data.setStok(frm.txtFieldStokCRUD.getText());

            if (frm.jDatePenyaluran.getDate() != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String tanggal_penyaluran = sdf.format(frm.jDatePenyaluran.getDate());
                data.setTgl_penyaluran(tanggal_penyaluran);
            } else {
                data.setTgl_penyaluran(null);
            }

            try {
                if (data.UpdateDonatur(data)) {
                    JOptionPane.showMessageDialog(null, "Update Data Baru Berhasil");
                    KosongFormPenyaluran();
                    TampilDataPenyaluran();
                    OtomatisIdPenyaluran();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if (ae.getSource() == frm.btnDelete) {
            data.setId_penyaluran(frm.txtFieldIdPenyaluranCRUD.getText());

            try {
                if (data.HapusDonatur(data)) {
                    JOptionPane.showMessageDialog(null, "Hapus Data Baru Berhasil");
                    KosongFormPenyaluran();
                    TampilDataPenyaluran();
                    OtomatisIdPenyaluran();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if (ae.getSource() == frm.btnClear) {
            KosongFormPenyaluran();
        } else if (ae.getSource() == frm.btnCari) {
            cari();
        } else if (ae.getSource() == frm.btnTambah) {
            int baris = frm.tableMakanan.getSelectedRow();

            String id_makanan = frm.tableMakanan.getValueAt(baris, 1).toString();
            String id_donatur = frm.tableMakanan.getValueAt(baris, 2).toString();
            String nama_makanan = frm.tableMakanan.getValueAt(baris, 3).toString();
            int stokSekarang = Integer.parseInt(frm.tableMakanan.getValueAt(baris, 4).toString());

            if (!isInputValid(stokSekarang)) {
                return;
            }

            String nama_donatur = getNamaDonaturByID(id_donatur);
            int jumlahDisalurkan = Integer.parseInt(frm.txtFieldStok.getText());
            tambahKeKeranjang(baris, id_makanan, nama_makanan, nama_donatur, jumlahDisalurkan, stokSekarang);
        } else if (ae.getSource() == frm.btnDonasi) {
            int totalBaris = modelKeranjang.getRowCount();
            if (totalBaris == 0) {
                JOptionPane.showMessageDialog(null, "Daftar donasi masih kosong!");
                return;
            }

            int konfirmasi = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin memproses seluruh donasi ini?", "Konfirmasi Donasi", JOptionPane.YES_NO_OPTION);
            if (konfirmasi != JOptionPane.YES_OPTION) {
                return;
            }

            try {
                java.sql.Connection MySQLConfig = (Connection) Model.Connector.configDB();

                java.util.Date tanggalSekarang = new java.util.Date();
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                String tgl_penyaluran = sdf.format(tanggalSekarang);

                String id_penyaluran_awal = frm.txtFieldIdPenyaluran.getText();
                String id_penerima = "" + frm.cbPenerimaPenyaluran.getSelectedItem();

                int angkaBase = Integer.parseInt(id_penyaluran_awal.substring(2));

                String sqlInsert = "INSERT INTO penyaluran (id_penyaluran, id_makanan, id_penerima, stok, tgl_penyaluran) VALUES (?, ?, ?, ?, ?)";
                String sqlUpdateStok = "UPDATE makanan SET stok = stok - ? WHERE id_makanan = ?";

                PreparedStatement pstInsert = MySQLConfig.prepareStatement(sqlInsert);
                PreparedStatement pstUpdate = MySQLConfig.prepareStatement(sqlUpdateStok);

                for (int i = 0; i < totalBaris; i++) {
                    String id_penyaluran_unik = String.format("PL%04d", angkaBase + i);

                    String id_makanan = modelKeranjang.getValueAt(i, 1).toString();
                    int jumlahSalur = Integer.parseInt(modelKeranjang.getValueAt(i, 4).toString());

                    pstUpdate.setInt(1, jumlahSalur);
                    pstUpdate.setString(2, id_makanan);
                    pstUpdate.execute();

                    pstInsert.setString(1, id_penyaluran_unik);
                    pstInsert.setString(2, id_makanan);
                    pstInsert.setString(3, id_penerima);
                    pstInsert.setInt(4, jumlahSalur);
                    pstInsert.setString(5, tgl_penyaluran);
                    pstInsert.execute();
                }

                JOptionPane.showMessageDialog(null, "Donasi penyaluran berhasil diproses!");

                modelKeranjang.setRowCount(0);

                TampilDataMakanan();
                TampilDataPenyaluran();
                OtomatisIdPenyaluran();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error Transaksi: " + ex.getMessage());
            }
        } else if (ae.getSource() == frm.btnHapus) {
            int barisTerpilih = frm.tableProsesPenyaluran.getSelectedRow();

            String idMakananBatal = modelKeranjang.getValueAt(barisTerpilih, 1).toString();
            int jmlKembali = Integer.parseInt(modelKeranjang.getValueAt(barisTerpilih, 4).toString());

            for (int i = 0; i < frm.tableMakanan.getRowCount(); i++) {
                if (frm.tableMakanan.getValueAt(i, 1).toString().equals(idMakananBatal)) {
                    int stokTabelKiri = Integer.parseInt(frm.tableMakanan.getValueAt(i, 4).toString());
                    frm.tableMakanan.setValueAt(stokTabelKiri + jmlKembali, i, 4);
                    break;
                }
            }

            modelKeranjang.removeRow(barisTerpilih);

            for (int i = 0; i < modelKeranjang.getRowCount(); i++) {
                modelKeranjang.setValueAt(i + 1, i, 0);
            }
        } else if (ae.getSource() == frm.btnLaporan) {
            try {
                java.sql.Connection MySQLConfig = (Connection) Connector.configDB();

                java.util.Date tglSebelum = frm.TanggalSebelum.getDate();
                java.util.Date tglMulai = frm.TanggalAntaraAwal.getDate();
                java.util.Date tglSampai = frm.TanggalAntaraAkhir.getDate();
                java.util.Date tglSetelah = frm.TanggalSetelah.getDate();

                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                String sql = "";

                if (tglMulai != null && tglSampai != null) {
                    String mulai = sdf.format(tglMulai);
                    String sampai = sdf.format(tglSampai);
                    sql = "SELECT * FROM penyaluran WHERE tgl_penyaluran BETWEEN '" + mulai + "' AND '" + sampai + "'";
                } else if (tglSebelum != null) {
                    String sblm = sdf.format(tglSebelum);
                    sql = "SELECT * FROM penyaluran WHERE tgl_penyaluran < '" + sblm + "'";
                } else if (tglSetelah != null) {
                    String stlh = sdf.format(tglSetelah);
                    sql = "SELECT * FROM penyaluran WHERE tgl_penyaluran > '" + stlh + "'";
                } else {
                    JOptionPane.showMessageDialog(null, "Silakan masukkan tanggal filter terlebih dahulu!");
                    return;
                }

                Popup pop = new Popup(sql); 
                
                pop.setVisible(true);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        } else if ((ae.getSource() == frm.btnDashboard) || (ae.getSource() == frm.btnDashboard2) || (ae.getSource() == frm.btnDashboard3)) {
            Dashboard db = new Dashboard();
            DashboardController ctrl = new DashboardController(db);
            db.setVisible(true);
            frm.dispose();
        } else if (ae.getSource() == frm.btnCari) {
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == frm.tablePenyaluran) {
            //frm.txtFieldId.setEditable(false);

            int baris = frm.tablePenyaluran.rowAtPoint(me.getPoint());
            String id_penyaluran = frm.tablePenyaluran.getValueAt(baris, 1).toString();
            frm.txtFieldIdPenyaluranCRUD.setText(id_penyaluran);

            String id_makanan = frm.tablePenyaluran.getValueAt(baris, 2).toString();
            for (int i = 0; i < frm.cbMakanan.getItemCount(); i++) {
                String itemCombo = frm.cbMakanan.getItemAt(i);

                if (id_makanan.equalsIgnoreCase(itemCombo)) {
                    frm.cbMakanan.setSelectedIndex(i);
                    break;
                }
            }

            String id_penerima = frm.tablePenyaluran.getValueAt(baris, 3).toString();
            for (int i = 0; i < frm.cbPenerima.getItemCount(); i++) {
                String itemCombo = frm.cbPenerima.getItemAt(i);

                if (id_penerima.equalsIgnoreCase(itemCombo)) {
                    frm.cbPenerima.setSelectedIndex(i);
                    break;
                }
            }

            String stok = frm.tablePenyaluran.getValueAt(baris, 4).toString();
            frm.txtFieldStokCRUD.setText(stok);

            try {
                String tglTabel = frm.tablePenyaluran.getValueAt(baris, 5).toString();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date tanggal = sdf.parse(tglTabel);
                frm.jDatePenyaluran.setDate(tanggal);
            } catch (ParseException ex) {
                Logger.getLogger(PenyaluranController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (me.getSource() == frm.tableMakanan) {

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
