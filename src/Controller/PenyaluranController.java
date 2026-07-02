/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Connector;
import Model.PenyaluranModel;
import View.FrmPenyaluran;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class PenyaluranController implements ActionListener, MouseListener {
    private PenyaluranModel data;
    private FrmPenyaluran frm;

    public PenyaluranController(PenyaluranModel data, FrmPenyaluran frm) {
        this.data = data;
        this.frm = frm;
        
        this.frm.btnSimpan.addActionListener(this);
        this.frm.btnUpdate.addActionListener(this);
        this.frm.btnDelete.addActionListener(this);
        this.frm.tablePenyaluran.addMouseListener(this);
        
        LoadComboMakanan();
        LoadComboPenerima();
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
        try {

            String sql = "SELECT id_penerima FROM penerima"; 
            java.sql.Connection conn = (Connection) Connector.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                frm.cbPenerima.addItem(res.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("Gagal load combo penerima: " + e.getMessage());
        }
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
                    res.getString(4)});
            }
            frm.tablePenyaluran.setModel(model);

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
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            // jasper report
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource()==frm.tablePenyaluran) {
            //frm.txtFieldId.setEditable(false);
            
            int baris=frm.tablePenyaluran.rowAtPoint(me.getPoint());
            String id_penyaluran=frm.tablePenyaluran.getValueAt(baris, 1).toString();
            frm.txtFieldIdPenyaluranCRUD.setText(id_penyaluran);
            
            String id_makanan=frm.tablePenyaluran.getValueAt(baris, 2).toString();
            for (int i = 0; i < frm.cbMakanan.getItemCount(); i++) {
                String itemCombo = frm.cbMakanan.getItemAt(i);
                
                if(id_makanan.equalsIgnoreCase(itemCombo)) {
                    frm.cbMakanan.setSelectedIndex(i);
                    break;
                }
            }
            
            String id_penerima=frm.tablePenyaluran.getValueAt(baris, 3).toString();
            for (int i = 0; i < frm.cbPenerima.getItemCount(); i++) {
                String itemCombo = frm.cbPenerima.getItemAt(i);
                
                if(id_penerima.equalsIgnoreCase(itemCombo)) {
                    frm.cbPenerima.setSelectedIndex(i);
                    break;
                }
            }
            
            try {
                String tglTabel = frm.tablePenyaluran.getValueAt(baris, 4).toString();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date tanggal = sdf.parse(tglTabel);
                frm.jDatePenyaluran.setDate(tanggal);
            } catch (ParseException ex) {
                Logger.getLogger(PenyaluranController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
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
