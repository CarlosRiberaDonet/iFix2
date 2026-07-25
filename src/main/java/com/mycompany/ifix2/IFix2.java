/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ifix2;

import com.formdev.flatlaf.FlatLightLaf;
import main.MainFrame;

/**
 *
 * @author sovi8
 */
public class IFix2 {

    public static void main(String[] args) {
         java.awt.EventQueue.invokeLater(() -> {
             FlatLightLaf.setup();
            new MainFrame().setVisible(true);
        });
         
    }
}
