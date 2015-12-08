/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itver.evalpro.dao.jpa;

import javax.swing.JFrame;
import org.itver.evalpro.dao.DAOFactory;

/**
 *
 * @author Luis Daniel
 */
public class JUnitPruebas {

    public static void main(String[] args) {
      JUnitPruebas.crearVentanaComparaciones();
    }

    public static void crearVentanaComparaciones() {
        JFrame f = new JFrame("Pruebas Api de Base de datos");
        MiPanelJUnitPruebas panel = new MiPanelJUnitPruebas();
        MiOyenteJUnitPruebas oyente = new MiOyenteJUnitPruebas(panel);
         
        panel.addEventos(oyente);
        f.setSize(500, 500);
        f.setVisible(true);
        f.add(panel);
    }

}
