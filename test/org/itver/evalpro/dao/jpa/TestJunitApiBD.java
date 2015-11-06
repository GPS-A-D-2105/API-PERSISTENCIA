/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itver.evalpro.dao.jpa;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Luis Daniel
 */
public class TestJunitApiBD {

    private ArrayList<Object> listaObjetos;
    private MiOyenteJUnitPruebas oyente;
    private String[] columnas;
    private Object[][] filas;

    public TestJunitApiBD() {
        listaObjetos = new ArrayList();
        columnas = llenarColumnas();
        filas = llenarFilas();
    }

    public String[] llenarColumnas() {
        String[] columnas = {"Numero", "Nombre de la prueba", "Esperado", "Resultado"};
        return columnas;
    }

    public Object[][] llenarFilas() {
        Object[][] filas = {{1, "Metodo persistir", true, false},
                            {2, "Metodo actualizar", true, true},
                            {3, "Metodo eliminar", true, true}
                            };
        return filas;
    }

    @Test
    public void testPrintMessage() {  
        int f = filas.length;
        int c = filas[0].length;                        
        for (int i = 0; i < f; i++) {
            assertEquals(filas[i][c-2], filas[i][c-1]);            
        }
    }
}
