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
package edu.eci.pdsw.samples.services;

import edu.eci.pdsw.samples.entities.Comentario;
import edu.eci.pdsw.samples.entities.Suscriptor;
import edu.eci.pdsw.samples.persistence.DaoComentario;
import edu.eci.pdsw.samples.persistence.DaoFactory;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author hcadavid
 */

@ManagedBean (name = "servi")
public class ServicesFacade {
    
    
    private static ServicesFacade instance=null;
    private DaoFactory df=DaoFactory.getInstance(null);
    private final Properties properties=new Properties();
    
    private ServicesFacade(String propFileName) throws IOException{        
	InputStream input = null;
        input = this.getClass().getClassLoader().getResourceAsStream(propFileName);        
        properties.load(input);
    }
    
    public static ServicesFacade getInstance(String propertiesFileName) throws RuntimeException{
        if (instance==null){
            try {
                instance=new ServicesFacade(propertiesFileName);
            } catch (IOException ex) {
                throw new RuntimeException("Error on application configuration:",ex);
            }
        }        
        return instance;
    }

           
    /**
     * Consultar todos los comentarios registrados
     * @return todos los comentarios
     * @throws ServiceFacadeException si se presenta un error a nivel de base
     * de datos
     */
    public Set<Comentario> comenteriosRegistrados() throws ServiceFacadeException, PersistenceException{
        Set<Comentario> coms;
        coms = new HashSet<Comentario>() ;
        df.beginSession();
        DaoComentario dc = df.getDaoComentario();
        coms = dc.loadAll();
        df.endSession();
        
                   
        return coms;
    }


  
    
    /**
     * Consultar todos los comentarios cuyo puntaje sea menor al valor n
     * @param n valor de referencia
     * @return el listado de comentarios cuyo puntaje es mejor que n
     * @throws ServiceFacadeException si n es negativo o si se presenta un error
     * a nivel de base de datos
     */
    public Set<Comentario> comenteriosMasBajos(int n) throws ServiceFacadeException, PersistenceException{
        Set<Comentario> coms;
        coms = new HashSet<Comentario>() ;
        df.beginSession();
        DaoComentario dc = df.getDaoComentario();
        coms = dc.loadByScore(n);
        df.endSession();
        return coms;
    }
    

 

    public void RegistrarComentario(Comentario com, Suscriptor sus) {
        try{
            DaoFactory df=DaoFactory.getInstance(properties);
            df.beginSession();
            df.getDaoComentario().save(com,sus);
            df.commitTransaction();
            df.endSession();
        }catch(PersistenceException ex){
            Logger.getLogger(ServicesFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void RegistrarSuscriptor(Suscriptor sus) {
        try{
            DaoFactory df=DaoFactory.getInstance(properties);
            df.beginSession();
            df.getDaoComentario().saveSuscriptor(sus);
            df.commitTransaction();
            df.endSession();
        }catch(PersistenceException ex){
            Logger.getLogger(ServicesFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        


}
