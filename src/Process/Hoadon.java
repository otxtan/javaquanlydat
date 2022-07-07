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
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author otxtan
 */
public class Hoadon {

    private int Id_hoadon;
    private int Id_dat;
    private int Id_nguoiban, Id_nguoimua;
    private int Tongtien;
    private String Ngayban;

    public Hoadon() {
    }

    public Hoadon(int Id_hoadon, int Id_dat, int Id_nguoiban, int Id_nguoimua, int Tongtien, String Ngayban) {
        this.Id_hoadon = Id_hoadon;
        this.Id_dat = Id_dat;
        this.Id_nguoiban = Id_nguoiban;
        this.Id_nguoimua = Id_nguoimua;
        this.Tongtien = Tongtien;
        this.Ngayban = Ngayban;
    }

    public void setId_hoadon(int Id_hoadon) {
        this.Id_hoadon = Id_hoadon;
    }

    public void setId_dat(int Id_dat) {
        this.Id_dat = Id_dat;
    }

    public void setId_nguoiban(int Id_nguoiban) {
        this.Id_nguoiban = Id_nguoiban;
    }

    public void setId_nguoimua(int Id_nguoimua) {
        this.Id_nguoimua = Id_nguoimua;
    }

    public void setTongtien(int Tongtien) {
        this.Tongtien = Tongtien;
    }

    public void setNgayban(String Ngayban) {
        this.Ngayban = Ngayban;
    }

    public int getId_hoadon() {
        return Id_hoadon;
    }

    public int getId_dat() {
        return Id_dat;
    }

    public int getId_nguoiban() {
        return Id_nguoiban;
    }

    public int getId_nguoimua() {
        return Id_nguoimua;
    }

    public int getTongtien() {
        return Tongtien;
    }

    public String getNgayban() {
        return Ngayban;
    }

    public String convertmoney(double money) {

        NumberFormat formatter = NumberFormat.getInstance();
        String moneyString = formatter.format(money);
        String tach = moneyString.replace(",", "");

        return tach;

    }

    public List<Hoadon> getALLHD() {
        List<Hoadon> list = new ArrayList<Hoadon>();
        Connection conn = null;
        try {
            conn = connectsqlsv.connectsql();
            String sql = "select * from Hoadon";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hoadon hd = new Hoadon();
                hd.setId_hoadon(rs.getInt(1));
                hd.setId_dat(rs.getInt(2));

                hd.setId_nguoiban(rs.getInt(3));
                hd.setId_nguoimua(rs.getInt(4));

                hd.setTongtien(rs.getInt(5));

                hd.setNgayban(rs.getString(6));
                list.add(hd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
//    lấy dữ liệu theo mã idhd

    public Hoadon getTheoIDHD(int idhd) {
        Hoadon hd = new Hoadon();
        Connection conn = null;
        try {
            conn = connectsqlsv.connectsql();
            String sql = "select * from Hoadon where Id_hoadon=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idhd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                hd.setId_hoadon(rs.getInt(1));
                hd.setId_dat(rs.getInt(2));

                hd.setId_nguoiban(rs.getInt(3));
                hd.setId_nguoimua(rs.getInt(4));

                hd.setTongtien(rs.getInt(5));
                hd.setNgayban(rs.getString(6));

            }
            return hd;
        } catch (SQLException ex) {
            Logger.getLogger(Dat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hd;
    }

    //xoa hoa don
    public boolean deleteHD(int idhd) {
        Connection conn = null;
        try {
            conn = connectsqlsv.connectsql();
            String sql = "delete from Hoadon where Id_hoadon=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idhd);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Dat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Hoadon> searchHD(String timkiem) {
        List<Hoadon> list = new ArrayList<Hoadon>();
        Connection conn = null;
        try {
            conn = connectsqlsv.connectsql();
            String sql = "select * from Hoadon where Id_hoadon like ? or Id_dat like ? or Id_nguoiban like ? or id_nguoimua like ? or Tongtien like ? or Ngayban like ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(timkiem));
            ps.setInt(2, Integer.parseInt(timkiem));
            ps.setInt(3, Integer.parseInt(timkiem));
            ps.setInt(4, Integer.parseInt(timkiem));
            ps.setString(5, timkiem);
            ps.setString(6, timkiem);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hoadon hd = new Hoadon();
                hd.setId_hoadon(rs.getInt(1));
                hd.setId_dat(rs.getInt(2));

                hd.setId_nguoiban(rs.getInt(3));
                hd.setId_nguoimua(rs.getInt(4));

                hd.setTongtien(rs.getInt(5));

                hd.setNgayban(rs.getString(6));
                list.add(hd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
//    sua hoa don

    public boolean edithd(Hoadon hd1) {

        int i = 0;
        try {
            Connection conn = connectsqlsv.connectsql();
            String sql = "update Hoadon set Id_dat=?, Id_nguoiban=?,Id_nguoimua=?,Tongtien=?,Ngayban=? where Id_hoadon=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, hd1.getId_dat());
            ps.setInt(2, hd1.getId_nguoiban());
            ps.setInt(3, hd1.getId_nguoimua());
            ps.setInt(4, hd1.getTongtien());
            ps.setString(5, hd1.getNgayban());
            ps.setInt(6, hd1.getId_hoadon());
            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Dat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // thong ke theo thang
    public List<Hoadon> Thongke(int thang) {
        List<Hoadon> list = new ArrayList<Hoadon>();

        try {
            Connection conn = connectsqlsv.connectsql();

            String sql = "select * from Hoadon where DATEPART(mm,Ngayban)=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, thang);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hoadon hd = new Hoadon();
                hd.setId_hoadon(rs.getInt(1));
                hd.setId_dat(rs.getInt(2));
                System.out.println(thang + rs.getInt(2));
                hd.setId_nguoiban(rs.getInt(3));
                hd.setId_nguoimua(rs.getInt(4));

                hd.setTongtien(rs.getInt(5));

                hd.setNgayban(rs.getString(6));
                list.add(hd);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Dat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
//   tinh tong tien theo thang

    public int Tongtienthongke(int thang) {
        int kq = 0;
        try {

            Connection con = connectsqlsv.connectsql();
            String sql = "select sum(Tongtien) from Hoadon where DATEPART(mm,Ngayban)=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, thang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                kq = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Hoadon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

}
