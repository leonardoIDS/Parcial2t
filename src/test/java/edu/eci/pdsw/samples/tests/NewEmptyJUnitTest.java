/*
 * Copyright (C) 2015 hcadavid
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
package edu.eci.pdsw.samples.tests;

import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.ServicesFacade;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author hcadavid
 */
public class NewEmptyJUnitTest {

    public NewEmptyJUnitTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void clearDB() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "sa", "");
        Statement stmt = conn.createStatement();
        stmt.execute("delete from COMENTARIOS");
        stmt.execute("delete from SUSCRIPTORES");
        conn.commit();
        conn.close();
    }

    
    /**
     * Recuerde cambiar el nombre del método por algo más significativo.
     * CLASE DE EQUIVALENCIA:
     * @throws PersistenceException 
     */
    @Test
    public void pruebaUnoTest() throws PersistenceException {
        //insertar datos en la base de datos 'volatil', antes de hacer la prueba
        
        //realizar la prueba usando la fachada de servicios haciendo uso de la
        //configuración que usa la base de datos volatil
        ServicesFacade sf=ServicesFacade.getInstance("h2-applicationconfig.properties");        
        
    }

    /**
     * Recuerde cambiar el nombre del método por algo más significativo.
     * CLASE DE EQUIVALENCIA:
     * @throws PersistenceException 
     */
    @Test
    public void pruebaDosTest() throws PersistenceException {
        //insertar datos en la base de datos 'volatil', antes de hacer la prueba
        
        //realizar la prueba usando la fachada de servicios haciendo uso de la
        //configuración que usa la base de datos volatil
        ServicesFacade sf=ServicesFacade.getInstance("h2-applicationconfig.properties");        
        
    }

}
