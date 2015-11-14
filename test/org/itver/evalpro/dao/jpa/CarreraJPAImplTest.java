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

import org.itver.evalpro.dto.Carrera;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vrebo
 */
public class CarreraJPAImplTest {
    
    public CarreraJPAImplTest() {
    }    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("Inicia una prueba..");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testEliminar() {
        Carrera carrera = new Carrera(2);
        assertTrue(new CarreraJPAImpl().eliminar(carrera));
    }
    
    @Test
    public void anotherTest(){
        
    }
    
}
