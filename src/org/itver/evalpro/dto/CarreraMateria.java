/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itver.evalpro.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vrebo
 */
@Entity
@Table(name = "`carrera_materia`")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CarreraMateria.findAll", query = "SELECT c FROM CarreraMateria c"),
    @NamedQuery(name = "CarreraMateria.findByIdCarreraMateria", query = "SELECT c FROM CarreraMateria c WHERE c.id = :idCarreraMateria")})
public class CarreraMateria extends Entidad<Integer> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idCarrera;
    private Integer idMateria;

    public CarreraMateria() {
    }

    public CarreraMateria(Integer idCarreraMateria) {
        this.id = idCarreraMateria;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "idCarreraMateria")
    @Override
    public Integer getId() {
        return id;
    }

@Column(name = "idCarrera")
    public Integer getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Integer idCarrera) {
        this.idCarrera = idCarrera;
    }

@Column(name = "idMateria")
    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    @Override
    public String toString() {
        return "org.itver.x.dto.CarreraMateria[ idCarreraMateria=" + id + " ]";
    }

}
