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
package edu.eci.pdsw.samples.mvccontrollers;

import edu.eci.pdsw.samples.entities.Comentario;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.ServicesFacade;
import java.io.Serializable;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author hcadavid
 */
@ManagedBean
@SessionScoped
public class ConsultaComentariosBackingBean implements Serializable{
    
    public Set<Comentario> getComs(){
        try {
            return ServicesFacade.getInstance("applicationconfig.properties").comms();
        } catch (PersistenceException ex) {
            Logger.getLogger(ConsultaComentariosBackingBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public int getCount(){
        try {
            return ServicesFacade.getInstance("applicationconfig.properties").comms().size();
        } catch (PersistenceException ex) {
            Logger.getLogger(ConsultaComentariosBackingBean.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        
    }
}
