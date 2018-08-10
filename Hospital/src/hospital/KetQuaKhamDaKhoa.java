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
public class KetQuaKhamDaKhoa {

    private String maTTK, lidokham, tinhtrang, chuandoansobo, kieukham;
    private Double cannang, mach, huyetap, nhiptho;

    public KetQuaKhamDaKhoa(String maTTK, String lidokham, String tinhtrang, String chuandoansobo, Double cannang, Double mach, Double huyetap, Double nhiptho, String kieukham) {
        this.maTTK = maTTK;
        this.lidokham = lidokham;
        this.tinhtrang = tinhtrang;
        this.chuandoansobo = chuandoansobo;
        this.cannang = cannang;
        this.mach = mach;
        this.huyetap = huyetap;
        this.nhiptho = nhiptho;
        this.kieukham = kieukham;
    }

    public KetQuaKhamDaKhoa(String maTTK, String kieukham) {
        this.maTTK = maTTK;
        this.kieukham = kieukham;
    }

    public String getKieukham() {
        return kieukham;
    }

    public void setKieukham(String kieukham) {
        this.kieukham = kieukham;
    }

    public String getMaTTK() {
        return maTTK;
    }

    public void setMaTTK(String maTTK) {
        this.maTTK = maTTK;
    }

    public String getLidokham() {
        return lidokham;
    }

    public void setLidokham(String lidokham) {
        this.lidokham = lidokham;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String getChuandoansobo() {
        return chuandoansobo;
    }

    public void setChuandoansobo(String chuandoansobo) {
        this.chuandoansobo = chuandoansobo;
    }

    public Double getCannang() {
        return cannang;
    }

    public void setCannang(Double cannang) {
        this.cannang = cannang;
    }

    public Double getMach() {
        return mach;
    }

    public void setMach(Double mach) {
        this.mach = mach;
    }

    public Double getHuyetap() {
        return huyetap;
    }

    public void setHuyetap(Double huyetap) {
        this.huyetap = huyetap;
    }

    public Double getNhiptho() {
        return nhiptho;
    }

    public void setNhiptho(Double nhiptho) {
        this.nhiptho = nhiptho;
    }

}
