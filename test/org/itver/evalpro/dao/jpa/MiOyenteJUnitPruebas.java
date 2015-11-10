package org.itver.evalpro.dao.jpa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author Luis Daniel
 */
public class MiOyenteJUnitPruebas implements ActionListener {

    private MiPanelJUnitPruebas panel;    

    public MiOyenteJUnitPruebas(MiPanelJUnitPruebas panel) {
        this.panel = panel;        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String etiqueta = e.getActionCommand();        
        if (etiqueta.equals("Testing")) {                                         
            TestJunitApiBD pruebas = new TestJunitApiBD();            
            panel.getModeloLista().clear();
            panel.getModeloTabla().setDataVector(pruebas.llenarFilas(),pruebas.llenarColumnas());
            panel.getModeloLista().addElement(TestRunnerApiBD.listaExcepciones());            
            panel.getModeloTabla().fireTableDataChanged();            
        } else {
            System.exit(0);
        }
    }
   
}
