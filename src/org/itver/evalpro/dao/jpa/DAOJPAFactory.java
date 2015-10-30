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
package org.itver.evalpro.dao.jpa;

import org.itver.evalpro.dao.CarreraDAO;
import org.itver.evalpro.dao.ComentarioDAO;
import org.itver.evalpro.dao.DAOFactory;
import org.itver.evalpro.dao.MaestroDAO;
import org.itver.evalpro.dao.MateriaDAO;

/**
 *
 * @author vrebo
 */
public final class DAOJPAFactory implements DAOFactory{

    private final CarreraJPAImpl    carreraDAO;
    private final ComentarioJPAImpl comentarioDAO;
    private final MaestroJPAImpl    maestroDAO;
    private final MateriaJPAImpl    materiaDAO;

    private DAOJPAFactory() {
        carreraDAO      = new CarreraJPAImpl();
        comentarioDAO   = new ComentarioJPAImpl();
        maestroDAO      = new MaestroJPAImpl();
        materiaDAO      = new MateriaJPAImpl();
    }

    public static DAOFactory getInstance() {
        return new DAOJPAFactory();
    }

    @Override
    public CarreraDAO getCarreraDAO() {
        return carreraDAO;
    }

    @Override
    public ComentarioDAO getComentarioDAO() {
        return comentarioDAO;
    }

    @Override
    public MaestroDAO getMaestroDAO() {
        return maestroDAO;
    }

    @Override
    public MateriaDAO getMateriaDAO() {
        return materiaDAO;
    }

}
