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

import edu.eci.pdsw.samples.entities.Producto;
import edu.eci.pdsw.samples.persistence.DaoProducto;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author hcadavid
 */
public class MyBatisDaoProducto implements DaoProducto{

    private SqlSession session=null;

    public MyBatisDaoProducto(SqlSession session) {
        this.session=session;
    }
    
    @Override
    public Producto load(int idProducto) throws PersistenceException {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Producto p) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
