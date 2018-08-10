/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframehopital;

import jframehopital.LoginFrame;

/**
 *
 * @author pc
 */
public class Hospital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginFrame lg = new LoginFrame();
        // chỉnh giao diện theo máy chạy 
        try {
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        } catch (ClassNotFoundException ex) {
            //Handle Exception
        } catch (InstantiationException ex) {
            //Handle Exception
        } catch (IllegalAccessException ex) {
            //Handle Exception
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            //Handle Exception
        }
        lg.setVisible(true);
    }

}
