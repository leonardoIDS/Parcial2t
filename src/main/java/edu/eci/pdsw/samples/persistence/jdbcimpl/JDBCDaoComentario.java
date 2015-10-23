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
            //ps = con.prepareStatement("select * from COMENTARIOS");   
            ps= con.prepareStatement("select coment.id, coment.comentario, coment.puntaje, coment.fecha, suscri.nombre from COMENTARIOS AS coment INNER JOIN SUSCRIPTORES AS suscri where coment.CLIENTES_id=suscri.id");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){ 
                
                //allCom.add(new Comentario (rs.getInt(1),rs.getDate(2),rs.getString(3),rs.getInt(4),rs.getObject(5,Suscriptor);
                allCom.add(new Comentario(rs.getInt("id"), rs.getDate("fecha"), rs.getString("comentario"), rs.getInt("puntaje"), new Suscriptor(rs.getInt("id"), rs.getString("nombre"))));
            }
            return allCom;
            }
            
        catch (SQLException ex) {
            throw new PersistenceException("An error ocurred while loading an order.",ex);
        }
        
    }

    @Override
    public Set<Comentario> loadByScore(int n) throws PersistenceException {
        PreparedStatement ps;
        HashSet<Comentario> allCom=new HashSet<Comentario>();
        try {
            //ps = con.prepareStatement("select * from COMENTARIOS");   
            ps= con.prepareStatement("select coment.id, coment.comentario, coment.puntaje, coment.fecha, suscri.nombre from COMENTARIOS AS coment INNER JOIN SUSCRIPTORES AS suscri where coment.CLIENTES_id=suscri.id where id > ?");
            ps.setInt(1, n);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){ 
                
                //allCom.add(new Comentario (rs.getInt(1),rs.getDate(2),rs.getString(3),rs.getInt(4),rs.getObject(5,Suscriptor);
                allCom.add(new Comentario(rs.getInt("id"), rs.getDate("fecha"), rs.getString("comentario"), rs.getInt("puntaje"), new Suscriptor(rs.getInt("id"), rs.getString("nombre"))));
            }
            return allCom;
            }
            
        catch (SQLException ex) {
            throw new PersistenceException("An error ocurred while loading an order.",ex);
        }
        
    }

    @Override
    public void save(Comentario com, Suscriptor sus) {       
        PreparedStatement ps;
        try{
            ps=con.prepareStatement("insert into COMENTARIOS(id, comentario, puntaje, fecha, CLIENTES_id) values (?,?,?,?,?)");
            ps.setInt(1, com.getId());
            ps.setString(2, com.getComentario());
            ps.setInt(3, com.getPuntaje());
            ps.setDate(4, com.getFecha());
            ps.setInt(5, sus.getId());
        }catch (SQLException ex) {
            try {
                throw new PersistenceException("Error cargando los comentarios",ex);
            } catch (PersistenceException ex1) {
                Logger.getLogger(JDBCDaoComentario.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
   

    @Override
    public void saveSuscriptor(Suscriptor sus) {       
        PreparedStatement ps;
        try{
            ps=con.prepareStatement("insert into SUSCRIPTOR(id, Nombre) values (?,?)");
            ps.setInt(1, sus.getId());
            ps.setString(2, sus.getNombre());
           ;
        }catch (SQLException ex) {
            try {
                throw new PersistenceException("Error cargando los comentarios",ex);
            } catch (PersistenceException ex1) {
                Logger.getLogger(JDBCDaoComentario.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

   
    
    
    
}
