/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

/**
 *
 * @author pc
 */
public class KetQuaKhamChuyenKhoa {

    private String ketqua, denghi, maTTK;

    public KetQuaKhamChuyenKhoa(String ketqua, String denghi, String maTTK) {
        this.ketqua = ketqua;
        this.denghi = denghi;
        this.maTTK = maTTK;
    }

    public String getKetqua() {
        return ketqua;
    }

    public String getDenghi() {
        return denghi;
    }

    public String getMaTTK() {
        return maTTK;
    }

}
