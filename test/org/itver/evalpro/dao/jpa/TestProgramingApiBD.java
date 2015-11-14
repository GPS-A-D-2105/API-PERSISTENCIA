/*
 * Copyright (C) 2015 Luis Daniel
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.itver.evalpro.dao.jpa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import org.itver.evalpro.dao.DAOFactory;
import org.itver.evalpro.dto.Administrador;
import org.itver.evalpro.dto.Carrera;
import org.itver.evalpro.dto.Comentario;
import org.itver.evalpro.dto.Maestro;
import org.itver.evalpro.dto.Materia;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author Luis Daniel
 */
public class TestProgramingApiBD {

    public static void pruebasPorProgramacion() {
        try {
            String ruta = "Pruebas.txt";
            creaArchivoPruebas(ruta);
        } catch (Exception e) {
            System.out.println("Error del archivo");
        }
    }

    public static void creaArchivoPruebas(String ruta) {
        File file = new File(ruta);
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pruebas(pw);
            pw.close();
            bw.close();
        } catch (Exception e) {
            System.out.println("Error de archivo");
        }
    }

    public static void pruebas(PrintWriter pw) {
//        notNull();
//        pruebaNumerosNegativos(pw);
//        pruebaBuscaPorRangos(pw);
//        pruebaBuscaTodos(pw);
//        conteoRegistos(pw); //12-16
//        pruebaBuscaPorId(pw);
//        pruebaActualizar();
        pruebaEliminar();
    }

    public static void pruebaNumerosNegativos(PrintWriter pw) {
        DAOFactory dao = DAOJPAFactory.getInstance();
        //1            
        try {
            dao.getCarreraDAO().buscarPorRangos(-1, -1);
        } catch (IllegalArgumentException e) {
            pw.append("Numeros negativos");
            System.out.println("Numeros negativos");
            pw.println();
        }
    }

    public static void pruebaBuscaPorRangos(PrintWriter pw) {
        DAOFactory dao = DAOJPAFactory.getInstance();
        recorrerListaCarrera(dao.getCarreraDAO().buscarPorRangos(0, 1), pw); //2
        recorrerListaComentario(dao.getComentarioDAO().buscarPorRangos(0, 1), pw); //3
        recorrerListaMaestro(dao.getMaestroDAO().buscarPorRangos(0, 1), pw); //9
        recorrerListaMateria(dao.getMateriaDAO().buscarPorRangos(0, 1), pw); //10        
    }

    public static void pruebaActualizar(){
        DAOFactory dao = DAOJPAFactory.getInstance();
        Administrador a = new Administrador();
        a.setIdAdmin(1);
        a.setNombreAdmin("Senen 2");
        a.setApePaterno("Juarez");
        a.setApeMaterno("Tinoco");        
        a.setNumeroControl("1234");
        a.setCorreo("@hotmail");
        a.setUserName("senen");
        a.setPassword("password");
        dao.getAdministradorDAO().actualizar(a);
    }
         
       public static void pruebaEliminar(){
        DAOFactory dao = DAOJPAFactory.getInstance();
        Administrador a = new Administrador();
        a.setUserName("senen");        
        Carrera c = new Carrera();
        c.setId(1);        
        c.setNombreCarrera("Ingenieria en Sistemas Computacionales");
        c.setIconoUrl("www.google.com/sistemas");
        System.out.println(dao.getCarreraDAO().eliminar(c));
    }
    
    public static void pruebaBuscaPorId(PrintWriter pw) {
        DAOFactory dao = DAOJPAFactory.getInstance();
        assertNotNull(dao.getAdministradorDAO().buscarPorId("Senen").getApeMaterno());
        for (int i = 1; i <= dao.getCarreraDAO().buscarTodos().size(); i++) {
            assertNotNull(dao.getCarreraDAO().buscarPorId(i));
        }
        for (int i = 1; i <= dao.getComentarioDAO().buscarTodos().size(); i++) {
            assertNotNull(dao.getComentarioDAO().buscarPorId(i));
        }
        for (int i = 1; i <= dao.getMaestroDAO().buscarTodos().size(); i++) {
            assertNotNull(dao.getMaestroDAO().buscarPorId(i));
        }
        for (int i = 1; i <= dao.getMateriaDAO().buscarTodos().size(); i++) {
            assertNotNull(dao.getMateriaDAO().buscarPorId(i));
        }
    }

    public static void pruebaBuscaTodos(PrintWriter pw) {
        DAOFactory dao = DAOJPAFactory.getInstance();
        recorrerListaCarrera(dao.getCarreraDAO().buscarTodos(), pw); //7
        recorrerListaComentario(dao.getComentarioDAO().buscarTodos(), pw); //8
        recorrerListaMaestro(dao.getMaestroDAO().buscarTodos(), pw);
        recorrerListaMateria(dao.getMateriaDAO().buscarTodos(), pw);
    }

    public static void notNull() { //Diferente de listas vacias 16-22
        DAOFactory dao = DAOJPAFactory.getInstance();
        assertFalse(dao.getCarreraDAO().buscarPorRangos(0, 1).isEmpty());
        assertFalse(dao.getMateriaDAO().buscarPorRangos(0, 1).isEmpty());
        assertFalse(dao.getMaestroDAO().buscarPorRangos(0, 1).isEmpty());
        assertFalse(dao.getComentarioDAO().buscarPorRangos(0, 1).isEmpty());
        assertFalse(dao.getAdministradorDAO().buscarPorRangos(0, 1).isEmpty());
    }

    public static void conteoRegistos(PrintWriter pw) {
        DAOFactory dao = DAOJPAFactory.getInstance();
        pw.append("Conteo de los registros de CarreraDAO " + dao.getCarreraDAO().contar()); //12            
        pw.println();
        pw.append("Conteo de los registros de ComentarioDAO " + dao.getComentarioDAO().contar()); //13
        pw.println();
        pw.append("Conteo de los registros de MaestroDAO " + dao.getMaestroDAO().contar()); //14
        pw.println();
        pw.append("Conteo de los registros de MateriaDAO " + dao.getMateriaDAO().contar()); //15
        pw.println();
        pw.append("Conteo de los registros de AdministradorDAO " + dao.getAdministradorDAO().contar()); //16
        pw.println();
    }

    public static void recorrerListaCarrera(List<Carrera> lista, PrintWriter pw) {
        for (int i = 0; i < lista.size(); i++) {
            pw.append(lista.get(i).getIconoUrl() + " " + lista.get(i).getNombreCarrera());
            System.out.println(lista.get(i).toString());
            pw.println();
        }
    }

    public static void recorrerListaComentario(List<Comentario> lista, PrintWriter pw) {
        for (int i = 0; i < lista.size(); i++) {
            pw.append(lista.get(i).getUsuario() + " " + lista.get(i).getContenido());
            System.out.println(lista.get(i).toString());
            pw.println();
        }
    }

    public static void recorrerListaMaestro(List<Maestro> lista, PrintWriter pw) {
        for (int i = 0; i < lista.size(); i++) {
            pw.append(lista.get(i).getNombre() + " " + lista.get(i).getApellidoPaterno() + " "
                    + lista.get(i).getApellidoMaterno());
            System.out.println(lista.get(i).toString());
            pw.println();
        }
    }

    public static void recorrerListaMateria(List<Materia> lista, PrintWriter pw) {
        for (int i = 0; i < lista.size(); i++) {
            pw.append(lista.get(i).getId() + " " + lista.get(i).getNombreMateria() + " " + lista.get(i).getCreditos()
                    + " " + lista.get(i).getRegistro());
            System.out.println(lista.get(i).toString());
            pw.println();
        }
    }

}
