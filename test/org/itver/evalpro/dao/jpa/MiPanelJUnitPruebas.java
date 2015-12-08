package org.itver.evalpro.dao.jpa;

import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis Daniel
 */
public class MiPanelJUnitPruebas extends javax.swing.JPanel {
    
    private DefaultTableModel modeloTabla;
    private DefaultListModel modeloLista;
    
    public MiPanelJUnitPruebas() {
        initComponents();
        creaModeloTabla();
    }
    
    
    public final void creaModeloTabla(){        
        modeloTabla = new DefaultTableModel();
        modeloLista = new DefaultListModel();
        jTableResultados.setModel(modeloTabla);
        
    }
    
    
    public void addEventos(MiOyenteJUnitPruebas o) {
        botonTesting.addActionListener(o);
        botonSalir.addActionListener(o);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelC = new javax.swing.JPanel();
        jScrollPaneResultados = new javax.swing.JScrollPane();
        jTableResultados = new javax.swing.JTable();
        jPanelN = new javax.swing.JPanel();
        botonTesting = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanelC.setLayout(new java.awt.BorderLayout());

        jTableResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPaneResultados.setViewportView(jTableResultados);

        jPanelC.add(jScrollPaneResultados, java.awt.BorderLayout.CENTER);

        add(jPanelC, java.awt.BorderLayout.CENTER);

        botonTesting.setText("Testing");
        botonTesting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTestingActionPerformed(evt);
            }
        });
        jPanelN.add(botonTesting);

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        jPanelN.add(botonSalir);

        add(jPanelN, java.awt.BorderLayout.NORTH);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel1.setLayout(new java.awt.BorderLayout());
        add(jPanel1, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonTestingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTestingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonTestingActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton botonTesting;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelC;
    private javax.swing.JPanel jPanelN;
    private javax.swing.JScrollPane jScrollPaneResultados;
    private javax.swing.JTable jTableResultados;
    // End of variables declaration//GEN-END:variables

    public JTable getjTableResultados() {
        return jTableResultados;
    }

    public void setjTableResultados(JTable jTableResultados) {
        this.jTableResultados = jTableResultados;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public DefaultListModel getModeloLista() {
        return modeloLista;
    }

    public void setModeloLista(DefaultListModel modeloLista) {
        this.modeloLista = modeloLista;
    }

    
    
    
}
