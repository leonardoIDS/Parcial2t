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

import edu.eci.pdsw.samples.entities.Comentario;
import edu.eci.pdsw.samples.entities.Suscriptor;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.ServiceFacadeException;
import edu.eci.pdsw.samples.services.ServicesFacade;
import static java.lang.reflect.Array.set;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author hcadavid
 * 
 * <Clases de equivalencia :
 * 
 * ComentariosRegistrados
 * CE1: Registra comentarios normales (texto con letras ordinarias entre los limites de caracteres)
 * CE2: Registra comentarios sin texto
 * CE3: Comentarios con valoraciones negativas
 * CE4: Comentarios con valoracion cero
 * CE5: Comentarios con valoracion Positiva
 * CE6: Comentarios sin texto
 * CE7: Comentarios con la misma calificacion diferente fecha 
 * 
 * >
 */
public class JUnitTest {

    public JUnitTest() {
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
     * <CLASE DE EQUIVALENCIA: CE1 // Comentarios normales 
     * deberia mostrarlos ordenados por fecha >
     * @throws PersistenceException 
     */
    @Test
    public void pruebaComentariosRegistrados() throws PersistenceException, ServiceFacadeException {
        //insertar datos en la base de datos 'volatil', antes de hacer la prueba
        Suscriptor sus = new Suscriptor(01,"Leonardo");
        Comentario com;
        
        com = new Comentario(01,new Date(2015,10,3),"Esta muy genial",10,sus);
        Suscriptor sus2 = new Suscriptor(02,"Fabio");
        Comentario com2;
        com2 = new Comentario(01,new Date(2015,10,4),"Esta muy fea",1,sus2);
        
        Set<Comentario> coms = new HashSet<Comentario>() ;
        coms.add(com);
        coms.add(com2);
        
        
       
        ServicesFacade sf=ServicesFacade.getInstance("h2-applicationconfig.properties");    
        
        sf.RegistrarSuscriptor(sus);
        sf.RegistrarSuscriptor(sus2);
        sf.RegistrarComentario(com2,sus2);
        sf.RegistrarComentario(com,sus);
        
        
        Set<Comentario> regis = sf.comenteriosRegistrados();
                
       
       
        Iterator<Comentario> i = regis.iterator();
        Iterator<Comentario> it = coms.iterator();
        while(i.hasNext()&& it.hasNext()){
            assertEquals(it.next(), i.next());
        }
    }

    /**
     * <CLASE DE EQUIVALENCIA: CE5 Comentarios con calificaciones positivas 
     * Deberia mostrar comentarios menores a un N
     * ordenados por fecha>
     * @throws PersistenceException 
     */
    @Test
    public void pruebaComentariosMasBajos() throws PersistenceException, ServiceFacadeException {
        Suscriptor sus = new Suscriptor(01,"Leonardo");
        Comentario com;
        com = new Comentario(01,new Date(2015,10,3),"Esta muy genial",10,sus);
        Suscriptor sus2 = new Suscriptor(02,"Fabio");
        Comentario com2;
        com2 = new Comentario(01,new Date(2015,10,4),"Esta muy fea",5,sus2);
        Suscriptor sus3 = new Suscriptor(03,"Pepito");
        Comentario com3 ;
        com3 = new Comentario(01,new Date(2015,10,5),"Esta demasiado muy fea",1,sus3);
        Set<Comentario> coms = new HashSet<Comentario>() ;
        
        coms.add(com2);
        coms.add(com3);
        
        
        
       
        ServicesFacade sf=ServicesFacade.getInstance("h2-applicationconfig.properties");    
        sf.RegistrarSuscriptor(sus);
        sf.RegistrarSuscriptor(sus2);
        sf.RegistrarSuscriptor(sus3);
        sf.RegistrarComentario(com3,sus3);
        sf.RegistrarComentario(com2,sus2);
        sf.RegistrarComentario(com,sus);
        
        
        Set<Comentario> regis = sf.comenteriosMasBajos(6);                
       
       
        Iterator<Comentario> i = regis.iterator();
        Iterator<Comentario> it = coms.iterator();
        while(i.hasNext()&& it.hasNext()){
            assertEquals(it.next(), i.next());
        }
      
    }

    /**
     * <CLASE DE EQUIVALENCIA: CE7 Comentarios con misma calificacion Diferentes fechas
     * deberia mostrar organizado por fechas>
     * @throws PersistenceException 
     */
    @Test
    public void pruebaComentariosMasBajosDos() throws PersistenceException, ServiceFacadeException {
        Suscriptor sus = new Suscriptor(01,"Leonardo");
        Comentario com;
        com = new Comentario(01,new Date(2015,10,3),"Esta muy genial",10,sus);
        Suscriptor sus2 = new Suscriptor(02,"Fabio");
        Comentario com2;
        com2 = new Comentario(01,new Date(2015,10,4),"Esta muy fea",3,sus2);
        Suscriptor sus3 = new Suscriptor(03,"Pepito");
        Comentario com3 ;
        com3 = new Comentario(01,new Date(2015,10,5),"Esta demasiado muy fea",3,sus3);
        Set<Comentario> coms = new HashSet<Comentario>() ;
        
        coms.add(com2);
        coms.add(com3);
        
        
        
       
        ServicesFacade sf=ServicesFacade.getInstance("h2-applicationconfig.properties");    
        sf.RegistrarSuscriptor(sus);
        sf.RegistrarSuscriptor(sus2);
        sf.RegistrarSuscriptor(sus3);
        sf.RegistrarComentario(com3,sus3);
        sf.RegistrarComentario(com,sus);
        sf.RegistrarComentario(com2,sus2);
        
        
        Set<Comentario> regis = sf.comenteriosMasBajos(6);                
       
       
        Iterator<Comentario> i = regis.iterator();
        Iterator<Comentario> it = coms.iterator();
        while(i.hasNext()&& it.hasNext()){
            assertEquals(it.next(), i.next());
        }
    }
}
