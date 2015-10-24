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
package org.itver.x.dao;

import java.util.List;

/**
 *
 * @author vrebo
 */
public interface DataAccessObject<E, Id> {

    boolean persistir(E e);

    boolean actualizar(E e);

    boolean eliminar(E e);

    E buscarPorId(Id id);

    List<E> buscarPorRangos(int offset, int limite);

    List<E> buscarTodos();

    int contar();
    
    void cerrar();
}