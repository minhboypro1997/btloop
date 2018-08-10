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
public class BSchuyenkhoa extends BS {
    // lấy thông tin mã Phiếu khám và kiểu khám khi bệnh nhân khác từ bs Đa khoa 
    public KetQuaKhamDaKhoa getTT(String maBN) {
        DatabaseConnection db = new DatabaseConnection();
        db.connect();
        return db.getTT(maBN);
    }
    // lấy lưu kết quả khám chuyên khoa
    public KetQuaKhamChuyenKhoa setKQ(String ketqua, String denghi, String maTTK) {
        KetQuaKhamChuyenKhoa kq = new KetQuaKhamChuyenKhoa(ketqua, denghi, maTTK);
        DatabaseConnection db = new DatabaseConnection();
        db.connect();
        db.insertKQKCK(ketqua, denghi, maTTK);

        return kq;

    }
}
