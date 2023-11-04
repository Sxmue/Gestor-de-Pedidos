package com.cesur.gestorpedidos.models.pedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Clase que representa un pedido de la base de datos
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido implements Serializable {
    private Integer id;
    private String codigo;
    private String fecha;
    private Integer usuario_id;
    private Integer total;
}
