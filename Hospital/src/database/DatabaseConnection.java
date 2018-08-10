/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaGrammar;
import hospital.BN;
import hospital.HSBN;
import hospital.KetQuaKhamChuyenKhoa;
import hospital.KetQuaKhamDaKhoa;
import hospital.TTK;
import hospital.Thuocs;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class DatabaseConnection {

    private Connection conn;
    private final String url = "jdbc:mysql://localhost:3306/hospital";
    private final String user = "root";
    private final String pass = "";

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    //phuong thuc ket noi co so du lieu
    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(url, user, pass);
            System.out.println("connect success");
        } catch (ClassNotFoundException ex) {
            System.out.println("class not found");
        } catch (Exception ex) {
            System.out.println("connect error");
        }
    }

    //test ket noi
    public static void main(String[] args) {
        DatabaseConnection d = new DatabaseConnection();
        d.connect();
    }

    //them bac si
    public void insertBS(String maBS, String tenBS, String maK) {
        PreparedStatement pst;
        String sql = "insert into bacsi values(?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, maBS);
            pst.setString(2, tenBS);
            pst.setString(3, maK);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // them benh nhan vao csdl
    public void insertBN(String maBN, String tenBN, String gioitinhBN, String cmtBN, String ngaysinhBN, String diachiBN, String sdtBN, String nghenghiepBN) {
        String sql = "insert into benhnhan values(?,?,?,?,?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, maBN);
            pst.setString(2, tenBN);
            pst.setString(3, gioitinhBN);
            pst.setString(4, cmtBN);
            pst.setString(5, ngaysinhBN);
            pst.setString(6, diachiBN);
            pst.setString(7, sdtBN);
            pst.setString(8, nghenghiepBN);

            pst.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //chon benh nhan co maBN ban dau : chuyen qua setText()
    public void selectBN(String mabnSS, String maBN, String tenBN, String gioitinhBN, String cmtBN, String ngaysinhBN, String diachiBN, String sdtBN, String nghenghiepBN) {
        String sql = "select * from benhnhan where maBN = ?";
        PreparedStatement pst;
        ResultSet rs;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, mabnSS);
            rs = pst.executeQuery();
            while (rs.next()) {
                maBN = rs.getString(1);
                tenBN = rs.getString(2);
                gioitinhBN = rs.getString(3);
                cmtBN = rs.getString(4);
                ngaysinhBN = rs.getString(5);
                diachiBN = rs.getString(6);
                sdtBN = rs.getString(7);
                nghenghiepBN = rs.getString(8);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //them thong tin kham
    public void insertTTK(String maBN, String maBS, String mTTK, String ngay) {
        String sql = "insert into khamdakhoa(maBN,maBS,maTTK,ngay) values(?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, maBN);
            pst.setString(2, maBS);
            pst.setString(3, mTTK);
            pst.setString(4, ngay);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //lay thongtinkham theo ma benh nhan
    public TTK getTTK(String maBN) {
        String sql = "select * from khamdakhoa where maBN = ?";
        PreparedStatement pst;
        ResultSet rs;
        TTK ttk = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, maBN);
            rs = pst.executeQuery();
            while (rs.next()) {
                ttk = new TTK(rs.getString("maBN"), rs.getString("maBS"), rs.getString("maTTK"), rs.getString("ngay"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ttk;
    }
    //lay danh sach bac si
    public void getBS(JComboBox ComboName) {
        String sql = "select maBS from bacsi ";
        PreparedStatement pst;
        ResultSet rs;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                model.addElement(rs.getString("maBS"));
            }
            ComboName.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //lay ten bs theo maBS
    public String getTenBS(String maBS) {
        String x = null, sql = "select tenBS from bacsi where maBS = ?";
        PreparedStatement pst;
        ResultSet rs;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, maBS);
            rs = pst.executeQuery();
            while (rs.next()) {
                x = rs.getString("tenBS");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }
    //chon BN theo maBN
    public BN selectBN(String mabnSS) {
        String sql = "select * from benhnhan where maBN = ?";
        PreparedStatement pst;
        ResultSet rs;
        BN bn = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, mabnSS);
            rs = pst.executeQuery();
            while (rs.next()) {
                bn = new BN(rs.getString("maBN"), rs.getString("tenBN"), rs.getString("gioitinhBN"), rs.getString("ngaysinhBN"), rs.getString("diachiBN"), rs.getString("nghenghiepBN"), rs.getString("cmtBN"), rs.getString("sdtBN"));
                System.out.println("selected");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bn;
    }
    // update csdl Benhnnhan

    public void editBN(String mabnSS, String tenBN, String gioitinhBN, String cmtBN, String ngaysinhBN, String diachiBN, String sdtBN, String nghenghiepBN) {
        String sql = "update benhnhan set tenBN = ? ,gioitinhBN = ? ,cmtBN = ? , ngaysinhBN = ? ,diachiBN = ? ,sdtBN = ? ,nghenghiepBN = ? where maBN = ?";
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(8, mabnSS);
            pst.setString(1, tenBN);
            pst.setString(2, gioitinhBN);
            pst.setString(3, cmtBN);
            pst.setString(4, ngaysinhBN);
            pst.setString(5, diachiBN);
            pst.setString(6, sdtBN);
            pst.setString(7, nghenghiepBN);
            pst.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // tao list BN de truyen vao bang
    public ArrayList<BN> listBN() {
        PreparedStatement pst;
        ArrayList<BN> listBN = new ArrayList<>();
        BN bn;
        String sql = "select * from benhnhan ";
        ResultSet rs;
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                bn = new BN(rs.getString("maBN"), rs.getString("tenBN"), rs.getString("gioitinhBN"), rs.getString("ngaysinhBN"), rs.getString("diachiBN"), rs.getString("nghenghiepBN"), rs.getString("cmtBN"), rs.getString("sdtBN"));
                listBN.add(bn);

            }
            System.out.println("oooo");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBN;
    }

    // tim kiem bn theo ten
    // tim BN theo tên
    public BN searchBN(String x) {

        BN bn = null;
        String sql = "select * from benhnhan where tenBN = ? ";
        ResultSet rs;
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, x);
            rs = pst.executeQuery();
            while (rs.next()) {
                bn = new BN(rs.getString("maBN"), rs.getString("tenBN"), rs.getString("gioitinhBN"), rs.getString("ngaysinhBN"), rs.getString("diachiBN"), rs.getString("nghenghiepBN"), rs.getString("cmtBN"), rs.getString("sdtBN"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bn;
    }

   
    // thêm KQKDK
    public void insertKQKDK(String maTTK, Double cannang, Double mach, Double huyetap, Double nhiptho, String lydokham, String tinhtrang, String chuandoansobo, String kieukham) {
        String sql = "insert into thongtinkham values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, maTTK);
            pst.setDouble(2, cannang);
            pst.setDouble(3, mach);
            pst.setDouble(4, huyetap);
            pst.setDouble(5, nhiptho);
            pst.setString(6, lydokham);
            pst.setString(7, tinhtrang);
            pst.setString(8, chuandoansobo);
            pst.setString(9, kieukham);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //lấy KQKDK
    public KetQuaKhamDaKhoa getKQKDK(String maTTK) {
        String sql = "select * from thongtinkham where maTTK = ?";
        ResultSet rs;
        PreparedStatement pst;
        KetQuaKhamDaKhoa kq = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, maTTK);
            rs = pst.executeQuery();
            while (rs.next()) {
                kq = new KetQuaKhamDaKhoa(rs.getString("maTTK"), rs.getString("lidokham"), rs.getString("tinhtrang"), rs.getString("chuandoansobo"), rs.getDouble("cannang"), rs.getDouble("mach"), rs.getDouble("huyetap"), rs.getDouble("nhiptho"), rs.getString("kieukham"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return kq;
    }

    // lấy tên khoa vào combobox
    public void getKhoa(JComboBox ComboName) {
        String sql = "select tenK from khoa ";
        PreparedStatement pst;
        ResultSet rs;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                model.addElement(rs.getString("tenK"));
            }
            ComboName.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    // lay thong tin ve maTTK va kieukham
    public KetQuaKhamDaKhoa getTT(String maBN) {
        String sql = "select ttk.maTTK,ttk.kieukham from khamdakhoa kdk,thongtinkham ttk where kdk.maBN = ? and ttk.maTTK = kdk.maTTK";
        PreparedStatement pst;
        ResultSet rs = null;
        KetQuaKhamDaKhoa kq = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, maBN);
            rs = pst.executeQuery();
            while (rs.next()) {
                kq = new KetQuaKhamDaKhoa(rs.getString(1), rs.getString(2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    // thêm KQKCK
    public void insertKQKCK(String ketqua, String denghi, String maTTK) {
        String sql = "insert into ketqua(ketqua,denghi,maTTK) values(?,?,?)";
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, ketqua);
            pst.setString(2, denghi);
            pst.setString(3, maTTK);

            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //lấy KQKCK
    public KetQuaKhamChuyenKhoa getKQKCK(String maTTK) {
        String sql = "select * from ketqua where maTTK = ?";
        PreparedStatement pst;
        ResultSet rs;
        KetQuaKhamChuyenKhoa kq = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, maTTK);
            rs = pst.executeQuery();
            while (rs.next()) {
                kq = new KetQuaKhamChuyenKhoa(rs.getString("ketqua"), rs.getString("denghi"), maTTK);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    // thêm BA
    public void insertBA(String maTTK, String ketluan, String loikhuyen) {
        String sql = "insert into benhan values(?,?,?)";
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, maTTK);
            pst.setString(2, ketluan);
            pst.setString(3, loikhuyen);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // lây thông tin của bệnh nhân và kết quả khám
    public HSBN getThongTinBenhAn(String maBN) {
        String sql = "select bn.*,kq.ketqua,ttk.cannang,ttk.mach,ttk.huyetap,ttk.nhiptho,ba.ketluan,ba.loikhuyen from benhnhan bn,benhan ba,khamdakhoa kdk,ketqua kq,thongtinkham ttk where bn.maBN = ? and  kdk.maBN = ? and kdk.maTTK = ttk.maTTK and kdk.maTTK = kq.maTTK and kdk.maTTK = ba.maTTK ";
        ResultSet rs;
        PreparedStatement pst;

        String a1, a2, a3, a4, a5, a6, a7, a8, a9, a10;
        Double a11, a12, a13, a14;
        HSBN hs = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, maBN);
            pst.setString(2, maBN);
            rs = pst.executeQuery();

            while (rs.next()) {

                a1 = rs.getString("tenBN");
                a2 = rs.getString("gioitinhBN");
                a3 = rs.getString("cmtBN");
                a4 = rs.getString("ngaysinhBN");
                a5 = rs.getString("diachiBN");
                a6 = rs.getString("sdtBN");
                a7 = rs.getString("nghenghiepBN");
                a8 = rs.getString("ketqua");
                a9 = rs.getString("ketluan");
                a10 = rs.getString("loikhuyen");
                a11 = rs.getDouble("cannang");
                a12 = rs.getDouble("mach");
                a13 = rs.getDouble("huyetap");
                a14 = rs.getDouble("nhiptho");

                hs = new HSBN(maBN, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "sai ở đâu đó :D");
        }
        return hs;
    }
// tim kiem thuoc
    public Thuocs searchThuoc(String tenThuoc) {
        String sql = "select * from thuoc where tenThuoc = ?";
        PreparedStatement pst;
        ResultSet rs;
        Thuocs thuoc = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, tenThuoc);
            rs = pst.executeQuery();
            while (rs.next()) {
                thuoc = new Thuocs(rs.getString("maThuoc"), rs.getString("tenThuoc"), rs.getInt("soLuong"), rs.getInt("donGia"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không có thuốc này");
        }
        return thuoc;
    }

    public void updateThuoc(String maThuoc, int soLuong) {
        String sql = "update thuoc set soLuong = ? where maThuoc = ? ";
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, soLuong);
            pst.setString(2, maThuoc);
            pst.execute();
        } catch (SQLException ex) {
            System.out.println("loi");
        }

    }
}
