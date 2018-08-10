/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import database.DatabaseConnection;

/**
 *
 * @author pc
 */
public class BSdakhoa extends BS {

    DatabaseConnection db = new DatabaseConnection();
    // Ghi thông tin khám Đa khoa 
    public void addKQKDK(String maTTK, Double cannang, Double mach, Double huyetap, Double nhiptho, String lydokham, String tinhtrang, String chuandoansobo, String kieukham) {

        db.connect();
        db.insertKQKDK(maTTK, cannang, mach, huyetap, nhiptho, lydokham, tinhtrang, chuandoansobo, kieukham);
    }
    //lấy thông tin khám đa khoa của bênh nhân.
    public KetQuaKhamDaKhoa getKQKDK(String maTTK) {

        db.connect();
        KetQuaKhamDaKhoa kq = db.getKQKDK(maTTK);
        return kq;
    }
    //xem kết quả khám chuyên khoa
    public KetQuaKhamChuyenKhoa getKQKCK(String maTTK) {

        db.connect();
        KetQuaKhamChuyenKhoa kq = db.getKQKCK(maTTK);
        return kq;
    }
    // Ghi kết luận
    public void addKL(String maTTK, String ketluan, String loikhuyen) {
        db.connect();
        db.insertBA(maTTK, ketluan, loikhuyen);
    }
}
