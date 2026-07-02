/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class PenyaluranModel {
    private String id_penyaluran;
    private String id_makanan;
    private String id_penerima;
    private String tgl_penyaluran;

    public String getId_penyaluran() {
        return id_penyaluran;
    }

    public void setId_penyaluran(String id_penyaluran) {
        this.id_penyaluran = id_penyaluran;
    }

    public String getId_makanan() {
        return id_makanan;
    }

    public void setId_makanan(String id_makanan) {
        this.id_makanan = id_makanan;
    }

    public String getId_penerima() {
        return id_penerima;
    }

    public void setId_penerima(String id_penerima) {
        this.id_penerima = id_penerima;
    }

    public String getTgl_penyaluran() {
        return tgl_penyaluran;
    }

    public void setTgl_penyaluran(String tgl_penyaluran) {
        this.tgl_penyaluran = tgl_penyaluran;
    }
    
    public boolean SimpanDonatur(PenyaluranModel data) throws SQLException{
        PreparedStatement pstm=null;
        Connection conn=(Connection)Connector.configDB();
        
        String sql="INSERT INTO penyaluran (id_penyaluran, id_makanan, id_penerima, tgl_penyaluran) VALUES (?,?,?,?)";
        
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, data.getId_penyaluran());
            pstm.setString(2, data.getId_makanan());
            pstm.setString(3, data.getId_penerima());
            pstm.setString(4, data.getTgl_penyaluran());
            pstm.execute();
            return true;
        }catch(HeadlessException | SQLException e){
            System.err.println(e);
            return false;
        }
    }
    
    public boolean UpdateDonatur(PenyaluranModel data) throws SQLException{
        PreparedStatement pstm=null;
        Connection conn=(Connection)Connector.configDB();
        
        String sql="UPDATE penyaluran set id_penyaluran=?, id_makanan=?, id_penerima=?, tgl_penyaluran=? WHERE id_penyaluran=?";
        
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, data.getId_penyaluran());
            pstm.setString(2, data.getId_makanan());
            pstm.setString(3, data.getId_penerima());
            pstm.setString(4, data.getTgl_penyaluran());
            pstm.setString(5, data.getId_penyaluran());
            pstm.execute();
            return true;
        }catch(HeadlessException | SQLException e){
            System.err.println(e);
            return false;
        }
    }
    
    public boolean HapusDonatur(PenyaluranModel data) throws SQLException{
        PreparedStatement pstm=null;
        Connection conn=(Connection)Connector.configDB();
        
        String sql="DELETE FROM penyaluran WHERE id_penyaluran=?";
        
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, data.getId_penyaluran());
            pstm.execute();
            return true;
        }catch(HeadlessException | SQLException e){
            System.err.println(e);
            return false;
        }
    }
    
}
