/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import database.DatabaseConnection;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class BS {

    private String maBS, tenBS, maKhoa;

    public BS() {
    }

    public BS(String maBS, String tenBS, String maKhoa) {
        this.maBS = maBS;
        this.tenBS = tenBS;
        this.maKhoa = maKhoa;
    }
    // lấy thông tin BN từ bảng chờ
    public BN getBN(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String mabnSS = model.getValueAt(0, 1).toString();
        DatabaseConnection db = new DatabaseConnection();
        db.connect();
        return db.selectBN(mabnSS);
    }
    //lấy thông tin khám của Bệnh nhân
    public void getPhieu(JTable t, JTextField a, JTextField b, JTextField c, JTextField d) {
        DatabaseConnection db = new DatabaseConnection();
        db.connect();
        TTK ttk = db.getTTK(getBN(t).getMaBN());
        a.setText(ttk.getMaBS());
        b.setText(ttk.getMaTTK());
        c.setText(ttk.getNgay());
        d.setText(db.getTenBS(ttk.getMaBS()));
    }
    // gọi bệnh nhân tiếp theo
    public void callBN(JTable t, JTextField a, JTextField b, JTextField c, JTextField d, JTextField e, JTextField f, JTextField g, JTextField h) {
        BN bn1 = getBN(t);
        if (bn1 != null) {
            a.setText(bn1.getMaBN());
            b.setText(bn1.getTenBN());
            c.setText(bn1.getCmtBN());
            d.setText(bn1.getNgaysinhBN());
            e.setText(bn1.getGioitinhBN());
            f.setText(bn1.getDiachiBN());
            g.setText(bn1.getSdtBN());
            h.setText(bn1.getNghenghiepBN());
        } else {
            a.setText("");
            b.setText("");
            c.setText("");
            d.setText("");
            e.setText("");
            f.setText("");
            g.setText("");
            h.setText("");

        }
    }

    public String getMaBS() {
        return maBS;
    }

    public void setMaBS(String maBS) {
        this.maBS = maBS;
    }

    public String getTenBS() {
        return tenBS;
    }

    public void setTenBS(String tenBS) {
        this.tenBS = tenBS;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

}
