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
package edu.eci.pdsw.samples.persistence;

import edu.eci.pdsw.samples.entities.Comentario;
import edu.eci.pdsw.samples.entities.Suscriptor;
import java.util.Set;


/**
 *
 * @author hcadavid
 */
public interface DaoComentario {

    
    /**
     * Consultar todos los comentarios
     * @return el listado de todos los comentarios con sus respectivos suscriptores
     * @throws PersistenceException si hay un error en la persistencia
     */
    public Set<Comentario> loadAll() throws PersistenceException;

     /**
     * Consultar todos los comentarios con un puntaje inferior a N
     * @return el listado de todos los comentarios con sus respectivos suscriptores,
     * cuyo puntaje sea menor a n
     * @throws PersistenceException si hay un error en la persistencia
     */
    public Set<Comentario> loadByScore(int n) throws PersistenceException;

    public void save(Comentario com, Suscriptor sus);
    public void saveSuscriptor(Suscriptor sus);

 
    
    
}
