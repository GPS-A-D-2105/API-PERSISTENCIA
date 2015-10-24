/*
 * Copyright (C) 2015 vrebo
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
package org.itver.x.dao.jpa;

import java.util.List;
import org.itver.x.dao.MaestroDAO;
import org.itver.x.dao.MateriaDAO;
import org.itver.x.dto.Carrera;
import org.itver.x.dto.Maestro;
import org.itver.x.dto.Materia;

/**
 *
 * @author vrebo
 */
public class TestJPADAO {
    public static void main(String[] args) {
//        Carrera carrera = new Carrera();
//        carrera.setNombreCarrera("Mecánica");
//        CarreraDAO carreraDAO = new CarreraJPAImpl();
//        carreraDAO.persistir(carrera);
//        carrera = carreraDAO.buscarPorId(1);
//        System.out.println("carrera = " + carrera);
//        carreraDAO.cerrar();
        Carrera c = new Carrera(1);
        MateriaDAO m = new MateriaJPAImpl();
        List<Materia> resultados = m.buscarMateriasPorIdCarrera(1);
        System.out.println("resultados = " + resultados);
        System.out.printf("Registros en la tabla materia %d\n", m.contar());
        m.cerrar();
        MaestroDAO maestroDAO= new MaestroJPAImpl();
        List<Maestro> maestros = maestroDAO.buscarPorMateria(1);
        System.out.println(maestros);
    }
}