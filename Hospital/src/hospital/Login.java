/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import database.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class Login {

    private String user, password;
    DatabaseConnection db = new DatabaseConnection();

    public Login(String user, String password) {
        this.user = user;
        this.password = password;
    }

    // đăng nhập , bằng tài khoản trong database dc cấp
    public int login() {
        db.connect();

        int x = 0;
        String sql = "select user, password from login where user = ? and password = ?";
        ResultSet rs = null;
        PreparedStatement pst;
        try {
            pst = db.getConn().prepareStatement(sql);
            pst.setString(1, this.user);
            pst.setString(2, this.password);
            rs = pst.executeQuery();
            if (rs.next()) {
                x = 1;
            } else {
                JOptionPane.showMessageDialog(null, "Đăng Nhập không thành công!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
