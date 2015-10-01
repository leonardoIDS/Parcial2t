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

import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Paciente;

/**
 *
 * @author hcadavid
 */
public class ServicesFacade {
    
    /**
     * Registra un nuevo paciente en el sistema
     * @param p El nuevo paciente
     * @throws ServicesFacadeException si se presenta algún error lógico
     * o de persistencia (por ejemplo, si el paciente ya existe).
     */
    public void registrarNuevoPaciente(Paciente p) throws ServiceFacadeException{
        
    }
    
    /**
     * Agrega una consulta a un paciente ya registrado
     * @param idPaciente el identificador del paciente
     * @param tipoid el tipo de identificación
     * @param c la consulta a ser agregada
     */
    public void agregarConsultaAPaciente(int idPaciente,String tipoid,Consulta c){
        
    }
    
}
