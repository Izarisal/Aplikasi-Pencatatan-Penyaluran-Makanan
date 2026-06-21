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
public class DonaturModel {
    private String id;
    private String nama;
    private String jenis;
    private String lokasi;
    private String email;
    private String no_hp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }
    
    public boolean SimpanDonatur(DonaturModel data) throws SQLException{
        PreparedStatement pstm=null;
        Connection conn=(Connection)Connector.configDB();
        
        String sql="INSERT INTO donatur (id, nama, jenis, lokasi, email, no_hp) VALUES (?,?,?,?,?,?)";
        
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, data.getId());
            pstm.setString(2, data.getNama());
            pstm.setString(3, data.getJenis());
            pstm.setString(4, data.getLokasi());
            pstm.setString(5, data.getEmail());
            pstm.setString(6, data.getNo_hp());
            pstm.execute();
            return true;
        }catch(HeadlessException | SQLException e){
            System.err.println(e);
            return false;
        }
    }
}
