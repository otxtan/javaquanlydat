/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB.connectsqlsv;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author otxtan
 */
public class Nguoiban {
    private int Id_nguoiban;
    private String Cmnd;
    private String Hoten;
    private String Ngaysinh;
    private String Sodienthoai;
    private String Diachi;

    public Nguoiban() {
    }

    public Nguoiban(int Id_nguoiban, String Cmnd, String Hoten, String Ngaysinh, String Sodienthoai, String Diachi) {
        this.Id_nguoiban = Id_nguoiban;
        this.Cmnd = Cmnd;
        this.Hoten = Hoten;
        this.Ngaysinh = Ngaysinh;
        this.Sodienthoai = Sodienthoai;
        this.Diachi = Diachi;
    }

    public void setId_nguoiban(int Id_nguoiban) {
        this.Id_nguoiban = Id_nguoiban;
    }

    public void setCmnd(String Cmnd) {
        this.Cmnd = Cmnd;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public void setNgaysinh(String Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }

    public void setSodienthoai(String Sodienthoai) {
        this.Sodienthoai = Sodienthoai;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public int getId_nguoiban() {
        return Id_nguoiban;
    }

    public String getCmnd() {
        return Cmnd;
    }

    public String getHoten() {
        return Hoten;
    }

    public String getNgaysinh() {
        return Ngaysinh;
    }

    public String getSodienthoai() {
        return Sodienthoai;
    }

    public String getDiachi() {
        return Diachi;
    }

    // nhan thong tin nguoi ban
    public List<Nguoiban> getallnguoiban()
    {
         List<Nguoiban> list=new ArrayList<Nguoiban>();
        try {
         
            String sql="select * from Nguoiban";
            Connection con=connectsqlsv.connectsql();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Nguoiban nb=new Nguoiban();
                nb.setId_nguoiban(rs.getInt(1));
                nb.setCmnd(rs.getString(2));
                nb.setHoten(rs.getString(3));
                nb.setNgaysinh(rs.getString(4));
                nb.setSodienthoai(rs.getString(5));
                nb.setDiachi(rs.getString(6));
                list.add(nb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Nguoiban.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
      
    }
//    nhan theo id 
    public Nguoiban gettheoidnguoiban(int id)
    {
         Nguoiban nb=new Nguoiban();
        try {
            String sql="select * from Nguoiban where Id_nguoiban=?";
            
            Connection con=connectsqlsv.connectsql();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
               
                nb.setId_nguoiban(rs.getInt(1));
                nb.setCmnd(rs.getString(2));
                nb.setHoten(rs.getString(3));
                nb.setNgaysinh(rs.getString(4));
                nb.setSodienthoai(rs.getString(5));
                nb.setDiachi(rs.getString(6));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Nguoiban.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nb;
    }
    public boolean suattnguoiban(Nguoiban nb)
    {
        try {
            String sql="update Nguoiban set Cmnd=?, Hoten=?, Ngaysinh=?,Sodienthoai=?,Diachi=? where Id_nguoiban=?";
            
            Connection con=connectsqlsv.connectsql();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, nb.getCmnd());
            ps.setString(2, nb.getHoten());
            ps.setString(3, nb.getNgaysinh());
            ps.setString(4, nb.getSodienthoai());
            ps.setString(5, nb.getDiachi());
            ps.setInt(6,nb.getId_nguoiban());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Nguoiban.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
}
