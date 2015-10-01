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
package edu.eci.pdsw.samples.client;

import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.persistence.DaoFactory;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author hcadavid
 */
public class NewClass {
    
    public static void main(String args[]) throws PersistenceException{
        DaoFactory fact=DaoFactory.getInstance();
        fact.beginSession();
        Date d=new java.sql.Date(Calendar.getInstance().getTime().getTime());
        /*Date d=new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Paciente p=new Paciente(11201535,"cc","juan perez",d);
        p.getConsultas().add(new Consulta(d,"resumen 1"));
        p.getConsultas().add(new Consulta(d,"resumen 2"));
        p.getConsultas().add(new Consulta(d,"resumen 3"));
        
        fact.getDaoPaciente().save(p);*/
        
        Paciente p=DaoFactory.getInstance().getDaoPaciente().load(11201535,"cc");
        //p.getConsultas().add(new Consulta(d,"el resumen posterior"));
        
        /*fact.getDaoPaciente().update(p);*/
        
        System.out.println(p);
        //System.out.println(p.getConsultas().size());
        fact.commitTransaction();
        fact.endSession();
    }
    
}
