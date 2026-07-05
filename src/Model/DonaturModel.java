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
public class DonaturModel extends AktorModel {
    
    public boolean SimpanDonatur(DonaturModel data) throws SQLException{
        PreparedStatement pstm=null;
        Connection conn=(Connection)Connector.configDB();
        
        String sql="INSERT INTO donatur (id_donatur, nama, jenis, lokasi, email, no_hp) VALUES (?,?,?,?,?,?)";
        
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
    
    public boolean UpdateDonatur(DonaturModel data) throws SQLException{
        PreparedStatement pstm=null;
        Connection conn=(Connection)Connector.configDB();
        
        String sql="UPDATE donatur set id_donatur=?, nama=?, jenis=?, lokasi=?, email=?, no_hp=? WHERE id_donatur=?";
        
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, data.getId());
            pstm.setString(2, data.getNama());
            pstm.setString(3, data.getJenis());
            pstm.setString(4, data.getLokasi());
            pstm.setString(5, data.getEmail());
            pstm.setString(6, data.getNo_hp());
            pstm.setString(7, data.getId());
            pstm.execute();
            return true;
        }catch(HeadlessException | SQLException e){
            System.err.println(e);
            return false;
        }
    }
    
    public boolean HapusDonatur(DonaturModel data) throws SQLException{
        PreparedStatement pstm=null;
        Connection conn=(Connection)Connector.configDB();
        
        String sql="DELETE FROM donatur WHERE id_donatur=?";
        
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, data.getId());
            pstm.execute();
            return true;
        }catch(HeadlessException | SQLException e){
            System.err.println(e);
            return false;
        }
    }
}
