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
public class HSBN {
    String maBN,tenBN,gioitinBN,cmtBN,ngaysinhBN,diachiBN,sdtBN,nghenghiepBN,ketqua,ketluan,loikhuyen;
    Double cannang,mach,huyetap,nhiptho;

    public HSBN(String maBN, String tenBN, String gioitinBN, String cmtBN, String ngaysinhBN, String diachiBN, String sdtBN, String nghenghiepBN, String ketqua, String ketluan, String loikhuyen, Double cannang, Double mach, Double huyetap, Double nhiptho) {
        this.maBN = maBN;
        this.tenBN = tenBN;
        this.gioitinBN = gioitinBN;
        this.cmtBN = cmtBN;
        this.ngaysinhBN = ngaysinhBN;
        this.diachiBN = diachiBN;
        this.sdtBN = sdtBN;
        this.nghenghiepBN = nghenghiepBN;
        this.ketqua = ketqua;
        this.ketluan = ketluan;
        this.loikhuyen = loikhuyen;
        this.cannang = cannang;
        this.mach = mach;
        this.huyetap = huyetap;
        this.nhiptho = nhiptho;
    }

    public String getMaBN() {
        return maBN;
    }

    public void setMaBN(String maBN) {
        this.maBN = maBN;
    }

    public String getTenBN() {
        return tenBN;
    }

    public void setTenBN(String tenBN) {
        this.tenBN = tenBN;
    }

    public String getGioitinBN() {
        return gioitinBN;
    }

    public void setGioitinBN(String gioitinBN) {
        this.gioitinBN = gioitinBN;
    }

    public String getCmtBN() {
        return cmtBN;
    }

    public void setCmtBN(String cmtBN) {
        this.cmtBN = cmtBN;
    }

    public String getNgaysinhBN() {
        return ngaysinhBN;
    }

    public void setNgaysinhBN(String ngaysinhBN) {
        this.ngaysinhBN = ngaysinhBN;
    }

    public String getDiachiBN() {
        return diachiBN;
    }

    public void setDiachiBN(String diachiBN) {
        this.diachiBN = diachiBN;
    }

    public String getSdtBN() {
        return sdtBN;
    }

    public void setSdtBN(String sdtBN) {
        this.sdtBN = sdtBN;
    }

    public String getNghenghiepBN() {
        return nghenghiepBN;
    }

    public void setNghenghiepBN(String nghenghiepBN) {
        this.nghenghiepBN = nghenghiepBN;
    }

    public String getKetqua() {
        return ketqua;
    }

    public void setKetqua(String ketqua) {
        this.ketqua = ketqua;
    }

    public String getKetluan() {
        return ketluan;
    }

    public void setKetluan(String ketluan) {
        this.ketluan = ketluan;
    }

    public String getLoikhuyen() {
        return loikhuyen;
    }

    public void setLoikhuyen(String loikhuyen) {
        this.loikhuyen = loikhuyen;
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
