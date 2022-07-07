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
public class Nguoimua {

    private int Id_nguoimua;
    private String Cmnd;
    private String Hoten;
    private String Ngaysinh;
    private String Sodienthoai;
    private String Diachi;

    public Nguoimua() {
    }

    public Nguoimua(int Id_nguoimua, String Cmnd, String Hoten, String Ngaysinh, String Sodienthoai, String Diachi) {
        this.Id_nguoimua = Id_nguoimua;
        this.Cmnd = Cmnd;
        this.Hoten = Hoten;
        this.Ngaysinh = Ngaysinh;
        this.Sodienthoai = Sodienthoai;
        this.Diachi = Diachi;
    }

    public void setId_nguoimua(int Id_nguoimua) {
        this.Id_nguoimua = Id_nguoimua;
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

    public int getId_nguoimua() {
        return Id_nguoimua;
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
    
    public List<Nguoimua> getallnguoimua()
    {
         List<Nguoimua> list=null;
        try {
           list=new ArrayList<Nguoimua>();
            String sql="select * from Nguoimua";
            Connection con=connectsqlsv.connectsql();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Nguoimua nb=new Nguoimua();
                nb.setId_nguoimua(rs.getInt(1));
                nb.setCmnd(rs.getString(2));
                nb.setHoten(rs.getString(3));
                nb.setNgaysinh(rs.getString(4));
                nb.setSodienthoai(rs.getString(5));
                nb.setDiachi(rs.getString(6));
                list.add(nb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Nguoimua.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
      
    }
     public Nguoimua gettheoidnguoimua(int id)
    {
         Nguoimua nb=new Nguoimua();
        try {
            String sql="select * from Nguoimua where Id_nguoimua=?";
            
            Connection con=connectsqlsv.connectsql();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
               
                nb.setId_nguoimua(rs.getInt(1));
                nb.setCmnd(rs.getString(2));
                nb.setHoten(rs.getString(3));
                nb.setNgaysinh(rs.getString(4));
                nb.setSodienthoai(rs.getString(5));
                nb.setDiachi(rs.getString(6));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Nguoimua.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nb;
    }
    public boolean suattnguoimua(Nguoimua nb)
    {
        try {
            String sql="update Nguoimua set Cmnd=?, Hoten=?, Ngaysinh=?,Sodienthoai=?,Diachi=? where Id_nguoimua=?";
            
            Connection con=connectsqlsv.connectsql();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, nb.getCmnd());
            ps.setString(2, nb.getHoten());
            ps.setString(3, nb.getNgaysinh());
            ps.setString(4, nb.getSodienthoai());
            ps.setString(5, nb.getDiachi());
            ps.setInt(6, nb.getId_nguoimua());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Nguoimua.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
