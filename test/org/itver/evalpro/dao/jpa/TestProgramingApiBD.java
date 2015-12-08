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
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Luis Daniel
 */
public class TestProgramingApiBD {

    private static DAOFactory dao;

    public TestProgramingApiBD() {
        dao = DAOJPAFactory.getInstance();
    }

    public static void pruebasPorProgramacion() {
        try {
            String ruta = "Pruebas.txt";
            creaArchivoPruebas(ruta);
        } catch (Exception e) {
            System.out.println("Error del archivo");
        }
    }

    private static void creaArchivoPruebas(String ruta) {
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
            e.printStackTrace();
        }
    }

    private static void pruebas(PrintWriter pw) {
        notNull(pw);
        pruebaNumerosNegativos(pw);
        pruebaBuscaPorRangos(pw);
        pruebaBuscaTodos(pw);
        conteoRegistos(pw); //12-16
        pruebaBuscaPorId(pw);
        pruebaEliminar(pw);
        pruebaPersistir(pw);
        pruebaActualizar(pw);
    }

    private static void pruebaNumerosNegativos(PrintWriter pw) {
        //1            
        try {
            dao.getCarreraDAO().buscarPorRangos(-1, -1);
        } catch (IllegalArgumentException e) {
            pw.append("pruebasNumerosNegativos");
            System.out.println("Numeros negativos");
            pw.println();
        }
    }

    private static void pruebaBuscaPorRangos(PrintWriter pw) {
        pw.append("Pruebas buscaPorRangos***************************************");
        pw.println();
        recorrerListaCarrera(dao.getCarreraDAO().buscarPorRangos(0, 1), pw); //2
        recorrerListaComentario(dao.getComentarioDAO().buscarPorRangos(0, 1), pw); //3
        recorrerListaMaestro(dao.getMaestroDAO().buscarPorRangos(0, 1), pw); //9
        recorrerListaMateria(dao.getMateriaDAO().buscarPorRangos(0, 1), pw); //10                
    }

    private static void pruebaActualizar(PrintWriter pw) {
        boolean bandera;
        pw.append("Pruebas actualizar*******************************************");
        pw.println();
        Administrador a = new Administrador();
        a.setIdAdmin(2);
        a.setNombreAdmin("Nombre Amin Act");
        a.setApePaterno("Paterno Act");
        a.setApeMaterno("Materno Act");
        a.setId("username");
        a.setPassword("password_1 Act");
        a.setNumeroControl("E1XXXXXXX Act");
        a.setCorreo("correo@gmail.com Act");        
        bandera = dao.getAdministradorDAO().actualizar(a);
        assertTrue(bandera);
        pw.append(""+bandera);
        pw.println();
    }

    private static void pruebaEliminar(PrintWriter pw) {
        boolean bandera;
        pw.append("Pruebas eliminar*********************************************");
        pw.println();
        Administrador a = new Administrador();
        a.setId("username");
        bandera = dao.getAdministradorDAO().eliminar(a);
        assertTrue(bandera);
        pw.append(""+bandera);
        pw.println();
    }

    private static void pruebaPersistir(PrintWriter pw) {
        boolean bandera;
        Administrador a = new Administrador();
        a.setIdAdmin(2);
        a.setNombreAdmin("Nombre Amin");
        a.setApePaterno("Paterno");
        a.setApeMaterno("Materno");
        a.setId("username");
        a.setPassword("password_1");
        a.setNumeroControl("E1XXXXXXX");
        a.setCorreo("correo@gmail.com");
        bandera = dao.getAdministradorDAO().persistir(a);
        assertTrue(bandera);
        pw.append(""+bandera);
        pw.println();
    }

    private static void pruebaBuscaPorId(PrintWriter pw) {        
        pw.append("Pruebas buscaPorId*******************************************");
        pw.println();
//        assertNotNull(dao.getAdministradorDAO().buscarPorId("username").getId());
        pw.append(dao.getAdministradorDAO().buscarPorId("username").getId());
        pw.println();

        for (int i = 1; i <= dao.getCarreraDAO().buscarTodos().size(); i++) {
            assertNotNull(dao.getCarreraDAO().buscarPorId(i));
            pw.append("" + dao.getCarreraDAO().buscarPorId(i));
            pw.println();
        }

        for (int i = 1; i <= dao.getComentarioDAO().buscarTodos().size(); i++) {
            assertNotNull(dao.getComentarioDAO().buscarPorId(i));
            pw.append("" + dao.getComentarioDAO().buscarPorId(i).getId());
            pw.println();
        }

        for (int i = 1; i <= dao.getMaestroDAO().buscarTodos().size(); i++) {
            assertNotNull(dao.getMaestroDAO().buscarPorId(i));
            pw.append("" + dao.getMaestroDAO().buscarPorId(i));
            pw.println();
        }

        for (int i = 1; i <= dao.getMateriaDAO().buscarTodos().size(); i++) {
            assertNotNull(dao.getMateriaDAO().buscarPorId(i));
            pw.append("" + dao.getMateriaDAO().buscarPorId(i));
            pw.println();
        }

    }

    private static void pruebaBuscaTodos(PrintWriter pw) {
        pw.append("Pruebas buscaTodos*******************************************");
        pw.println();
        recorrerListaCarrera(dao.getCarreraDAO().buscarTodos(), pw); //7      
        recorrerListaComentario(dao.getComentarioDAO().buscarTodos(), pw); //8       
        recorrerListaMaestro(dao.getMaestroDAO().buscarTodos(), pw);      
        recorrerListaMateria(dao.getMateriaDAO().buscarTodos(), pw);      
    }

    private static void notNull(PrintWriter pw) { //Diferente de listas vacias 16-22        
        pw.append("Pruebas notNull**********************************************");
        pw.println();
        assertFalse(dao.getCarreraDAO().buscarPorRangos(0, 1).isEmpty());
        assertFalse(dao.getMateriaDAO().buscarPorRangos(0, 1).isEmpty());
        assertFalse(dao.getMaestroDAO().buscarPorRangos(0, 1).isEmpty());
        assertFalse(dao.getComentarioDAO().buscarPorRangos(0, 1).isEmpty());
        assertFalse(dao.getAdministradorDAO().buscarPorRangos(0, 1).isEmpty());
    }

    private static void conteoRegistos(PrintWriter pw) {
        pw.append("Pruebas conteoRegistros**************************************");
        pw.println();
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

    private static void recorrerListaCarrera(List<Carrera> lista, PrintWriter pw) {
        for (int i = 0; i < lista.size(); i++) {
            pw.append(lista.get(i).getIconoUrl() + " " + lista.get(i).getNombreCarrera());
            System.out.println(lista.get(i).toString());
            pw.println();
        }
    }

    private static void recorrerListaComentario(List<Comentario> lista, PrintWriter pw) {
        for (int i = 0; i < lista.size(); i++) {
            pw.append(lista.get(i).getUsuario() + " " + lista.get(i).getContenido());
            System.out.println(lista.get(i).toString());
            pw.println();
        }
    }

    private static void recorrerListaMaestro(List<Maestro> lista, PrintWriter pw) {
        for (int i = 0; i < lista.size(); i++) {
            pw.append(lista.get(i).getNombre() + " " + lista.get(i).getApellidoPaterno() + " "
                    + lista.get(i).getApellidoMaterno());
            System.out.println(lista.get(i).toString());
            pw.println();
        }
    }

    private static void recorrerListaMateria(List<Materia> lista, PrintWriter pw) {
        for (int i = 0; i < lista.size(); i++) {
            pw.append(lista.get(i).getId() + " " + lista.get(i).getNombreMateria() + " " + lista.get(i).getCreditos()
                    + " " + lista.get(i).getRegistro());
            System.out.println(lista.get(i).toString());
            pw.println();
        }
    }

}
