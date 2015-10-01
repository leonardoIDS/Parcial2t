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
package edu.eci.pdsw.samples.persistence.mybatisimpl.mappers;

import edu.eci.pdsw.samples.entities.DetallePedido;
import edu.eci.pdsw.samples.entities.Pedido;
import edu.eci.pdsw.samples.entities.Producto;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author hcadavid
 */
public interface PedidoMapper {
  
    
    @Select("SELECT p.codigo as cod, p.fecha_radicacion as fr from ORD_PEDIDOS p where p.codigo=#{id}")
    @Results(
            value = {
                @Result(property="codigo",column = "cod", id = true),
                @Result(property="fecha",column = "fr"),
                @Result(property="detallesPedido", javaType = Set.class, column="cod", 
                        many=@Many(select="edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.PedidoMapper.getDetallePedido"))
            }
    )
    Pedido selectPedido(@Param("id") int id);
    
    
    @Select("SELECT producto_fk as codprod,cantidad from ORD_DETALLES_PEDIDO where pedido_fk=#{idped}")
    @Results(
            value = {
                @Result(property = "cantidad",column = "cantidad"),
                @Result(property = "producto",javaType = Producto.class,
                        one = @One(select = "edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.ProductoMapper.selectProducto"),column = "codprod")
                
            }
    )
    Set<DetallePedido> getDetallePedido(@Param("idped") int idped);
 

    
}
