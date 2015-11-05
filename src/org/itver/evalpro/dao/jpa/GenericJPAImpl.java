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

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.itver.evalpro.dao.DataAccessObject;

/**
 *
 * @author vrebo
 */
public class GenericJPAImpl<E, Id> implements DataAccessObject<E, Id> {

    private final Class<E> clase;
    private EntityManagerFactory emf;
    private EntityManager em;
    private static final String PERSISTENCE_UNIT = "misprofesores";

    public GenericJPAImpl(Class<E> clase) {
        this.clase = clase;
        em = getEntityManager();
    }

    @Override
    public boolean persistir(E e) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(e);
            et.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            et.rollback();
            return false;
        }
    }

    @Override
    public boolean actualizar(E e) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.merge(e);
            et.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            et.rollback();
            return false;
        }
    }

    @Override
    public boolean eliminar(E e) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.remove(e);
            et.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            et.rollback();
            return false;
        }
    }

    @Override
    public E buscarPorId(Id id) {
        E entidad = em.find(clase, id);
        return entidad;
    }

    @Override
    public List<E> buscarPorRangos(int offset, int limite) {
        if (offset < 0) {
            throw new IllegalArgumentException(
                    String.format("Valor de offset inválido, el valor es negativo (%d)", offset));
        }
        if(limite < 0 ){
            throw new IllegalArgumentException(
                    String.format("Valor de para limite inválido, el valor es negativo (%d)", offset));
        }
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(clase));
        Query q = em.createQuery(cq);
        return q.setFirstResult(offset).getResultList();
    }

    @Override
    public List<E> buscarTodos() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(clase));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public int contar() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<E> rt = cq.from(clase);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    protected final EntityManager getEntityManager() {
        if (emf == null) {
            emf = javax.persistence.Persistence
                    .createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        if (em == null) {
            em = emf.createEntityManager();
        }
        return em;
    }

    @Override
    public void cerrar() {
        em.close();
        emf.close();

    }

}
