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
package edu.eci.pdsw.samples.persistence.jdbcimpl;

import edu.eci.pdsw.samples.entities.Comentario;
import edu.eci.pdsw.samples.entities.Suscriptor;
import edu.eci.pdsw.samples.persistence.DaoComentario;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hcadavid
 */
public class JDBCDaoComentario implements DaoComentario {

    Connection con;

    public JDBCDaoComentario(Connection con) {
        this.con = con;
    }            
    
    @Override
    public Set<Comentario> loadAll() throws PersistenceException {
        PreparedStatement ps;
        HashSet<Comentario> allCom=new HashSet<Comentario>();
        try {
            ps = con.prepareStatement("select * from COMENTARIOS");   
            ResultSet rs=ps.executeQuery();
            while(rs.next()){ 
                
                allCom.add(new Comentario (rs.getInt(1),rs.getDate(2),rs.getString(3),rs.getInt(4),rs.getObject(5,Suscriptor);
            }
            return allCom;
        }catch (SQLException ex) {
            throw new PersistenceException("An error ocurred while loading an order.",ex);
        }
        
        
        

    }

    @Override
    public Set<Comentario> loadByScore(int n) throws PersistenceException {
                PreparedStatement ps;
        HashSet<Comentario> allCom=new HashSet<Comentario>();
        try {
            ps = con.prepareStatement("select * from COMENTARIOS where puntaje > ?");
            ps.setInt(1, n);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){ 
                
                allCom.add(new Comentario (rs.getInt(1),rs.getDate(2),rs.getString(3),rs.getInt(4),rs.getObject(5,Suscriptor);
            }
      
            
            return allCom;
        }catch (SQLException ex) {
            throw new PersistenceException("An error ocurred while loading an order.",ex);
        }
        
        
        
    
    }
    
}
