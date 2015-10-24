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
import javax.persistence.TypedQuery;
import org.itver.x.dao.MateriaDAO;
import org.itver.x.dto.Materia;

/**
 *
 * @author vrebo
 */
public class MateriaJPAImpl
        extends GenericJPAImpl<Materia, Integer>
        implements MateriaDAO {

    public MateriaJPAImpl() {
        super(Materia.class);
    }

    @Override
    public List<Materia> buscarMateriasPorIdCarrera(Object idCarrera) {
        TypedQuery<Materia> query
                = getEntityManager()
                        .createNamedQuery("Materia.findByIdCarrera", Materia.class);
        query.setParameter("idCarrera", idCarrera);
        List<Materia> results = query.getResultList();
        return results;
    }

}
