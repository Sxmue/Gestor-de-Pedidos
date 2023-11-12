package com.cesur.gestorpedidos.models.item;

import com.cesur.gestorpedidos.models.producto.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Clase que representa un Item de la base de datos
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {
    private Integer idPedido;
    private String codigoPedido;
    private Integer cantidad;
    private Integer idProducto;
    private Producto producto;
}
