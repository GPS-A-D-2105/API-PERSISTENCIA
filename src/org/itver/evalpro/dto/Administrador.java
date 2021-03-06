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
@Table(name = "administradores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adminitsrador.findAll", query = "SELECT a FROM Administrador a"),
    @NamedQuery(name = "Administrador.findByIdAdmin", query = "SELECT a FROM Administrador a WHERE a.idAdmin = :idAdmin"),
    @NamedQuery(name = "Administrador.findByNombreAdmin", query = "SELECT a FROM Administrador a WHERE a.nombreAdmin = :nombreAdmin"),
    @NamedQuery(name = "Administrador.findByApePaterno", query = "SELECT a FROM Administrador a WHERE a.apePaterno = :apePaterno"),
    @NamedQuery(name = "Administrador.findByApeMaterno", query = "SELECT a FROM Administrador a WHERE a.apeMaterno = :apeMaterno"),
    @NamedQuery(name = "Administrador.findByPassword", query = "SELECT a FROM Administrador a WHERE a.password = :password"),
    @NamedQuery(name = "Administrador.findByNumeroControl", query = "SELECT a FROM Administrador a WHERE a.numeroControl = :numeroControl"),
    @NamedQuery(name = "Administrador.findByCorreo", query = "SELECT a FROM Administrador a WHERE a.correo = :correo")})
public class Administrador extends Entidad<String> implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idAdmin;
    private String nombreAdmin;
    private String apePaterno;
    private String apeMaterno;
    private String password;
    private String numeroControl;
    private String correo;

    public Administrador() {
    }

    public Administrador(String userName) {
        this.id = userName;
    }

    public Administrador(String userName, int idAdmin, String nombreAdmin, String apePaterno, String apeMaterno, String password, String numeroControl, String correo) {
        this.id = userName;
        this.idAdmin = idAdmin;
        this.nombreAdmin = nombreAdmin;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.password = password;
        this.numeroControl = numeroControl;
        this.correo = correo;
    }

    @Basic(optional = false)
    @Column(name = "idAdmin")
    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    @Basic(optional = false)
    @Column(name = "nombreAdmin")
    public String getNombreAdmin() {
        return nombreAdmin;
    }

    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
    }

    @Basic(optional = false)
    @Column(name = "ApePaterno")
    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    @Basic(optional = false)
    @Column(name = "ApeMaterno")
    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    @Basic(optional = false)
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic(optional = false)
    @Column(name = "numeroControl")
    public String getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    @Basic(optional = false)
    @Column(name = "correo")
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "username")
    @Override
    public String getId() {
        return id;
    }

}
