package org.itver.evalpro.dao.jpa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            TestProgramingApiBD test = new TestProgramingApiBD();
            test.pruebasPorProgramacion();
            ReportePruebas reporte = new ReportePruebas();
            panel.getModeloLista().clear();
            panel.getModeloTabla().setDataVector(reporte.llenarFilas(), reporte.llenarColumnas());        
            panel.getModeloTabla().fireTableDataChanged();
        } else {
            System.exit(0);
        }
    }

}
