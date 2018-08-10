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
public class BN {

    private String maBN, tenBN, gioitinhBN, ngaysinhBN, diachiBN, nghenghiepBN;
    private String cmtBN, sdtBN;

    public BN(String maBN, String tenBN, String gioitinhBN, String ngaysinhBN, String diachiBN, String nghenghiepBN, String cmtBN, String sdtBN) {
        this.maBN = maBN;
        this.tenBN = tenBN;
        this.gioitinhBN = gioitinhBN;
        this.ngaysinhBN = ngaysinhBN;
        this.diachiBN = diachiBN;
        this.nghenghiepBN = nghenghiepBN;
        this.cmtBN = cmtBN;
        this.sdtBN = sdtBN;
    }

    public String getMaBN() {
        return maBN;
    }

    public String getTenBN() {
        return tenBN;
    }

    public String getGioitinhBN() {
        return gioitinhBN;
    }

    public String getNgaysinhBN() {
        return ngaysinhBN;
    }

    public String getDiachiBN() {
        return diachiBN;
    }

    public String getNghenghiepBN() {
        return nghenghiepBN;
    }

    public String getCmtBN() {
        return cmtBN;
    }

    public String getSdtBN() {
        return sdtBN;
    }

}
