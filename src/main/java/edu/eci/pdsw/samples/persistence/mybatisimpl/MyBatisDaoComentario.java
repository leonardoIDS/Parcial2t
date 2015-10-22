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
package edu.eci.pdsw.samples.persistence.mybatisimpl;


import edu.eci.pdsw.samples.entities.Comentario;
import edu.eci.pdsw.samples.persistence.DaoComentario;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.ComentariosMapper;
import java.util.Set;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author hcadavid
 */
public class MyBatisDaoComentario implements DaoComentario{

    
    private ComentariosMapper pmap=null;

    public MyBatisDaoComentario(SqlSession session) {        
        pmap=session.getMapper(ComentariosMapper.class);
    }

    @Override
    public Comentario load(int id) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Comentario> loadBySuscriptor(int idsuscriptor) throws PersistenceException {
        return pmap.comms();
    }
    
    
}
