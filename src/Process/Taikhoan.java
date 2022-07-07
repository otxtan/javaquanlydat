/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB.connectsqlsv;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author otxtan
 */
public class Taikhoan {
    private String Tendn,password;

    public Taikhoan() {
    }

    public Taikhoan(String Tendn, String password) {
        this.Tendn = Tendn;
        this.password = password;
    }

    public void setTendn(String Tendn) {
        this.Tendn = Tendn;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTendn() {
        return Tendn;
    }

    public String getPassword() {
        return password;
    }
//    doi mat khau
    public boolean doiMK(String tendn,String pass_word)
    { 
      
        try {
            Connection conn = connectsqlsv.connectsql();
            String sql = "update Taikhoan set password=? where Tendn=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pass_word);
            ps.setString(2, tendn);
            
            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Dat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
