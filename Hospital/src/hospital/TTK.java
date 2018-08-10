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
public class TTK {

    private String maBN, maBS, maTTK, ngay;

    public TTK(String maBN, String maBS, String maTTK, String ngay) {
        this.maBN = maBN;
        this.maBS = maBS;
        this.maTTK = maTTK;
        this.ngay = ngay;
    }

    public String getMaBN() {
        return maBN;
    }

    public String getMaBS() {
        return maBS;
    }

    public String getMaTTK() {
        return maTTK;
    }

    public String getNgay() {
        return ngay;
    }

}
