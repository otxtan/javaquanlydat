/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB.connectsqlsv;
import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.regex.Pattern;

/**
 *
 * @author otxtan
 */
public class Dat {

    private int Id_dat;
    private int Id_nguoiban;
    private double Dientich;
    private String vitri;
    private int Giaban;
    private String Trangthai;
    private String Ngaygiaoban;

    public Dat() {
    }

    public Dat(int Id_dat, int Id_nguoiban, float Dientich, String vitri, int Giaban, String Trangthai, String Ngaygiaoban) {
        this.Id_dat = Id_dat;
        this.Id_nguoiban = Id_nguoiban;
        this.Dientich = Dientich;
        this.vitri = vitri;
        this.Giaban = Giaban;
        this.Trangthai = Trangthai;
        this.Ngaygiaoban = Ngaygiaoban;
    }

    public void setId_dat(int Id_dat) {
        this.Id_dat = Id_dat;
    }

    public void setId_nguoiban(int Id_nguoiban) {
        this.Id_nguoiban = Id_nguoiban;
    }

    public void setDientich(double Dientich) {
        this.Dientich = Dientich;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }

    public void setGiaban(int Giaban) {
        this.Giaban = Giaban;
    }

    public void setTrangthai(String Trangthai) {
        this.Trangthai = Trangthai;
    }

    public void setNgaygiaoban(String Ngaygiaoban) {
        this.Ngaygiaoban = Ngaygiaoban;
    }

    public int getId_dat() {
        return Id_dat;
    }

    public int getId_nguoiban() {
        return Id_nguoiban;
    }

    public double getDientich() {
        return Dientich;
    }

    public String getVitri() {
        return vitri;
    }

    public int getGiaban() {
        return Giaban;
    }

    public String getTrangthai() {
        return Trangthai;
    }

    public String getNgaygiaoban() {
        return Ngaygiaoban;
    }

//    public String convertmoney(double money) {
//
//        NumberFormat formatter = NumberFormat.getInstance();
//        String moneyString = formatter.format(money);
//        String tach = moneyString.replace(",", "");
//
//        return tach;
//
//    }
    // them moi mot manh dat
    public boolean addDat(Nguoiban nb, Dat dat, String cmnd) {
        try {

            int idnguoiban = 0;
            int idnguoibanmoi = 0;
            int ktcmnd = 0;
            Connection conn = null;
            conn = connectsqlsv.connectsql();
            // kiem tra cmnd ton tai chua
            String sql = "select count(*) from Nguoiban where Cmnd=?";

            PreparedStatement ps1 = conn.prepareStatement(sql);
            ps1.setString(1, cmnd);
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) {
                ktcmnd = rs.getInt(1);

            }

            // đã tồn tại cmnd
            if (ktcmnd >= 1) {
                // lay id nguoi ban qua cmnd
                conn = connectsqlsv.connectsql();
                String sql6 = "select Id_nguoiban from Nguoiban where Cmnd=?";

                PreparedStatement ps6 = conn.prepareStatement(sql6);
                ps6.setString(1, cmnd);
                rs = ps6.executeQuery();
                while (rs.next()) {
                    idnguoiban = rs.getInt(1);
                }

                String sql4 = "insert into Dat(Id_nguoiban,Dientich,Vitri,Giaban,Trangthai,Ngaygiaoban) values (?,?,?,?,?,?)";
                PreparedStatement ps4 = conn.prepareStatement(sql4);
                ps4.setInt(1, idnguoiban);
                ps4.setDouble(2, dat.getDientich());
                ps4.setString(3, dat.getVitri());
                ps4.setInt(4, dat.getGiaban());
                ps4.setString(5, dat.getTrangthai());
                ps4.setString(6, dat.getNgaygiaoban());
                ps4.executeUpdate();
                return true;
            } //nếu không  có thì thêm rồi về id 
            else if (ktcmnd == 0) {
                System.out.println(nb.getDiachi());
                String sql2 = "insert into Nguoiban(Cmnd,Hoten,Ngaysinh,Sodienthoai,Diachi) values\n"
                        + "(?,?,?,?,?)";
                conn = connectsqlsv.connectsql();
                PreparedStatement ps2 = conn.prepareStatement(sql2);
                ps2.setString(1, nb.getCmnd());
                ps2.setString(2, nb.getHoten());
                ps2.setString(3, nb.getNgaysinh());
                ps2.setString(4, nb.getSodienthoai());
                ps2.setString(5, nb.getDiachi());

                ps2.executeUpdate();

                // lay idnguoiban da them
                String sql3 = "select MAX(Id_nguoiban) from Nguoiban";
                PreparedStatement ps3 = conn.prepareStatement(sql3);
                rs = ps3.executeQuery();
                while (rs.next()) {
                    idnguoibanmoi = rs.getInt(1);
                }
//               thêm  đất
                String sql5 = "insert into Dat(Id_nguoiban,Dientich,Vitri,Giaban,Trangthai,Ngaygiaoban)\n"
                        + "values (?,?,?,?,?,?)";
                PreparedStatement ps5 = conn.prepareStatement(sql5);

                ps5.setInt(1, idnguoibanmoi);
                ps5.setDouble(2, dat.getDientich());
                ps5.setString(3, dat.getVitri());
                ps5.setInt(4, dat.getGiaban());
                ps5.setString(5, dat.getTrangthai());
                ps5.setString(6, dat.getNgaygiaoban());
                ps5.executeUpdate();
                return true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(Dat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
//    lenhoadon

    public boolean lenHoaDon(Nguoimua nm,String cmnd, int iddat, int idnguoiban, int tongtien, String ngayban) {
        try {
            int idnguoimua = 0;
            int idnguoimuamoi = 0;
            int ktcmnd = 0;
            Connection conn = null;
            conn = connectsqlsv.connectsql();
            // kiem tra cmnd ton tai chua
            String sql = "select count(*) from Nguoimua where Cmnd=?";

            PreparedStatement ps1 = conn.prepareStatement(sql);
            ps1.setString(1, cmnd);
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) {
                ktcmnd = rs.getInt(1);

            }
            // đã tồn tại cmnd
            if (ktcmnd >= 1) {
                // lay id nguoi mua qua cmnd
                conn = connectsqlsv.connectsql();
                String sql6 = "select Id_nguoimua from Nguoimua where Cmnd=?";

                PreparedStatement ps6 = conn.prepareStatement(sql6);
                ps6.setString(1, cmnd);
                rs = ps6.executeQuery();
                while (rs.next()) {
                    idnguoimua = rs.getInt(1);
                }
                String sql2 = "insert into Hoadon(Id_dat,Id_nguoiban,id_nguoimua,Tongtien,Ngayban)\n"
                        + "values(?,?,?,?,?)";
                PreparedStatement ps2 = conn.prepareStatement(sql2);

                ps2.setInt(1, iddat);
                ps2.setInt(2, idnguoiban);
                ps2.setInt(3, idnguoimua);
                ps2.setInt(4, tongtien);
                ps2.setString(5, ngayban);

                ps2.executeUpdate();

                String sql3 = "update Dat set Trangthai=? where Id_dat=?";
                PreparedStatement ps3 = conn.prepareStatement(sql3);
                ps3.setString(1, "Đã bán");
                ps3.setInt(2, iddat);
                ps3.executeUpdate();

                return true;

            } //
            else if (ktcmnd == 0) {
                String sql2 = "insert into Nguoimua(Cmnd,Hoten,Ngaysinh,Sodienthoai,Diachi) values\n"
                        + "(?,?,?,?,?)";
                conn = connectsqlsv.connectsql();
                PreparedStatement ps2 = conn.prepareStatement(sql2);
                ps2.setString(1, nm.getCmnd());
                ps2.setString(2, nm.getHoten());
                ps2.setString(3, nm.getNgaysinh());
                ps2.setString(4, nm.getSodienthoai());
                ps2.setString(5, nm.getDiachi());

                ps2.executeUpdate();
                // lay idnguoimua da them
                String sql3 = "select MAX(Id_nguoimua) from Nguoimua";
                PreparedStatement ps3 = conn.prepareStatement(sql3);
                rs = ps3.executeQuery();
                while (rs.next()) {
                    idnguoimuamoi = rs.getInt(1);
                }

                    String sql7 = "insert into Hoadon(Id_dat,Id_nguoiban,Id_nguoimua,Tongtien,Ngayban)\n"
                            + "values(?,?,?,?,?)";
                    PreparedStatement ps4 = conn.prepareStatement(sql7);

                    ps4.setInt(1, iddat);
                    ps4.setInt(2, idnguoiban);
                    ps4.setInt(3, idnguoimuamoi);
                    ps4.setInt(4, tongtien);
                    ps4.setString(5, ngayban);

                    ps4.executeUpdate();

                    String sql8 = "update Dat set Trangthai=? where Id_dat=?";
                    PreparedStatement ps5 = conn.prepareStatement(sql8);
                    ps5.setString(1, "Đã bán");
                    ps5.setInt(2, iddat);
                    ps5.executeUpdate();

                    return true;
                }

            }

         catch (SQLException ex) {
            Logger.getLogger(Dat.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    //sua thong tin dat
    public boolean Suadat(Dat dat) {
        int kq = 0;

        Connection conn = null;
        try {

            conn = connectsqlsv.connectsql();
            String sql = "update Dat set Id_nguoiban=?,Dientich=?,Vitri=?,Giaban=?,Trangthai=?,Ngaygiaoban=? where Id_dat=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, dat.getId_nguoiban());
            ps.setDouble(2, dat.getDientich());
            ps.setString(3, dat.getVitri());
            ps.setInt(4, dat.getGiaban());
            ps.setString(5, dat.getTrangthai());

            ps.setString(6, dat.getNgaygiaoban());
            ps.setInt(7, dat.getId_dat());
            kq = ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Dat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //lay tat ca du lieu tu db

    public List<Dat> getAll() {
        List<Dat> list = new ArrayList<Dat>();
        Connection conn = null;
        try {
            conn = connectsqlsv.connectsql();
            String sql = "select * from Dat";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Dat dat = new Dat();
                dat.setId_dat(rs.getInt(1));
                dat.setId_nguoiban(rs.getInt(2));

                dat.setDientich(rs.getDouble(3));
                dat.setVitri(rs.getString(4));

                dat.setGiaban((rs.getInt(5)));

                dat.setTrangthai(rs.getString(6));
                dat.setNgaygiaoban(rs.getString(7));
                list.add(dat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    // lay du lieu theo id_dat
    public Dat getTheoId(int id) {
        Dat dat = new Dat();
        Connection conn = null;
        try {
            conn = connectsqlsv.connectsql();
            String sql = "select * from Dat where Id_dat=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                dat.setId_dat(rs.getInt(1));
                dat.setId_nguoiban(rs.getInt(2));

                dat.setDientich(rs.getDouble(3));
                dat.setVitri(rs.getString(4));

                dat.setGiaban(rs.getInt(5));

                dat.setTrangthai(rs.getString(6));

                dat.setNgaygiaoban(rs.getString(7));

            }
            return dat;
        } catch (SQLException ex) {
            Logger.getLogger(Dat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dat;
    }

    //xoa thong tin dat
    public boolean deleteDat(int id_dat) {
        Connection conn = null;
        int kq = 0;
        try {

            conn = connectsqlsv.connectsql();
            String sql = "delete from Dat where Id_dat=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_dat);
            kq = ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Dat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    //tim kiem dat
    public List<Dat> searchDat(String timkiem) {
        List<Dat> list = new ArrayList<Dat>();
        Connection conn = null;
        try {
            conn = connectsqlsv.connectsql();
            String sql = "select * from Dat where Id_dat like ? or Id_nguoiban like ? or Dientich like ? or Vitri like ? or Giaban like ? or Trangthai like ? or Ngaygiaoban like ? ";

            PreparedStatement ps = conn.prepareStatement(sql);
            String pattern = "[0-9]+";
            if (Pattern.matches(pattern, timkiem)) {
                ps.setInt(1, Integer.parseInt(timkiem));
            } else {
                ps.setInt(1, 0);
            }
            if (Pattern.matches(pattern, timkiem)) {
                ps.setInt(2, Integer.parseInt(timkiem));
            } else {
                ps.setInt(2, 0);
            }
            if (Pattern.matches(pattern, timkiem)) {
                ps.setDouble(3, Double.parseDouble(timkiem));
            } else {
                ps.setDouble(3, 0);
            }

            ps.setString(4, timkiem);
            ps.setString(5, timkiem);
            ps.setString(6, timkiem);
            ps.setString(7, timkiem);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Dat dat = new Dat();
                dat.setId_dat(rs.getInt(1));
                dat.setId_nguoiban(rs.getInt(2));

                dat.setDientich(rs.getDouble(3));
                dat.setVitri(rs.getString(4));

                dat.setGiaban(rs.getInt(5));

                dat.setTrangthai(rs.getString(6));
                dat.setNgaygiaoban(rs.getString(7));
                list.add(dat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

}
