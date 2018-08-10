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
public class Khoa {

    private String maK, tenk;

    public Khoa(String maK, String tenk) {
        this.maK = maK;
        this.tenk = tenk;
    }

    public String getMaK() {
        return maK;
    }

    public void setMaK(String maK) {
        this.maK = maK;
    }

    public String getTenk() {
        return tenk;
    }

    public void setTenk(String tenk) {
        this.tenk = tenk;
    }

}
