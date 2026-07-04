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
public class MakananModel {

    private String idMakanan;
    private String idDonatur;
    private String nama;
    private int stok;
    private String status;
    private String tanggalKadaluarsa;

    public String getIdMakanan() {
        return idMakanan;
    }

    public void setIdMakanan(String idMakanan) {
        this.idMakanan = idMakanan;
    }

    public String getIdDonatur() {
        return idDonatur;
    }

    public void setIdDonatur(String idDonatur) {
        this.idDonatur = idDonatur;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTanggalKadaluarsa() {
        return tanggalKadaluarsa;
    }

    public void setTanggalKadaluarsa(String tanggalKadaluarsa) {
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }
    
    public boolean SimpanMakanan(MakananModel data) throws SQLException{
        PreparedStatement pstm=null;
        Connection conn=(Connection)Connector.configDB();
        
        String sql="INSERT INTO makanan (id_makanan, id_donatur, nama, stok, status, tgl_kadaluarsa) VALUES (?,?,?,?,?,?)";
        
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, data.getIdMakanan());
            pstm.setString(2, data.getIdDonatur());
            pstm.setString(3, data.getNama());
            pstm.setInt(4, data.getStok());
            pstm.setString(5, data.getStatus());
            pstm.setString(6, data.getTanggalKadaluarsa());
            pstm.execute();
            return true;
        }catch(HeadlessException | SQLException e){
            System.err.println(e);
            return false;
        }
    }
    
    public boolean UpdateMakanan(MakananModel data) throws SQLException{
        PreparedStatement pstm=null;
        Connection conn=(Connection)Connector.configDB();
        
        String sql="UPDATE makanan set id_makanan=?, id_donatur=?, nama=?, stok=?, status=?, tgl_kadaluarsa=? WHERE id_makanan=?";
        
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, data.getIdMakanan());
            pstm.setString(2, data.getIdDonatur());
            pstm.setString(3, data.getNama());
            pstm.setInt(4, data.getStok());
            pstm.setString(5, data.getStatus());
            pstm.setString(6, data.getTanggalKadaluarsa());
            pstm.setString(7, data.getIdMakanan());
            pstm.execute();
            return true;
        }catch(HeadlessException | SQLException e){
            System.err.println(e);
            return false;
        }
    }
    
    public boolean HapusMakanan(MakananModel data) throws SQLException{
        PreparedStatement pstm=null;
        Connection conn=(Connection)Connector.configDB();
        
        String sql="DELETE FROM makanan WHERE id_makanan=?";
        
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, data.getIdMakanan());
            pstm.execute();
            return true;
        }catch(HeadlessException | SQLException e){
            System.err.println(e);
            return false;
        }
    }
}
