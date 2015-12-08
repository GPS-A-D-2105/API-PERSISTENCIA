/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itver.evalpro.dao.jpa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Luis Daniel
 */
public class ReportePruebas {

    private ArrayList<Object> listaObjetos;
    private MiOyenteJUnitPruebas oyente;
    private String[] columnas;
    private String[][] filas;

    public ReportePruebas() {
        listaObjetos = new ArrayList();
        columnas = llenarColumnas();
        filas = llenarFilas();
    }

    public String[] llenarColumnas() {
        String[] columnas = {"Numero"};
        return columnas;
    }

    public ArrayList<String> listaLlenarFilas(String archivo) {
        String cadena;
        ArrayList<String> lista = new ArrayList<>();
        try {
            FileReader f = new FileReader(archivo);
            BufferedReader b = new BufferedReader(f);
            while ((cadena = b.readLine()) != null) {
                lista.add(cadena);
            }
            b.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public String[][] llenarFilas() {
        String archivo = "Pruebas.txt";
        ArrayList<String> lista = listaLlenarFilas(archivo);
        String[][] arreglo = new String[lista.size()][1];
        for (int filas = 0; filas < lista.size(); filas++) {
            arreglo[filas][0] = lista.get(filas);
            
        }
        return arreglo;
    }

}
